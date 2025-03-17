package web.service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.UUID;

@Service
public class FileService {

    /*
         [*] 업로드 된 파일을 저장할 폴더 경로, 배포 전 주로 resources 폴더 내 경로 사용
         src -> main -> resources -> static -> upload
         1. 현재 프로젝트 최상위 디렉토리(폴더) 경로 찾기
    */
    // 현재 작업 최상위 폴더 경로를 반환
    String baseDir = System.getProperty("user.dir");
    // 프로젝트 경로를 불러옴
    // src와 build 폴더 차이점 : src(실행 전 코드 : 개발자) VS build(실행 후 코드 : 사용자)
    // 개발자는 src에서 작업하고 항상 서버를 실행 하므로써 작업한 코드를 build에 반영한다(컴파일/빌드)
    // String uploadPath = "/src/resources/static/upload/";
    // 프로젝트 경로/build/resources/main/static/upload/
    String uploadPath = baseDir + "/build/resources/main/static/upload/";

    /** [1] 업로드 : 스프링에서는 MultipartFile 인터페이스를 지원하므로 파일 업로드를 지원 */
    public String fileUpload(MultipartFile multipartFile) {
        // (1) 매개변수로 MultipartFile 인터페이스 타입을 받는다.
        // (2) multipartFile 인터페이스 내 다양한 메소드를 제공
        // .getContentType() : 첨부파일의 확장자를 반환
        System.out.println("확장자 = " + multipartFile.getContentType());
        // .getSize() : 첨부파일의 용량(바이트)을 반환
        System.out.println("용량 = " + multipartFile.getSize());
        // .getOriginalFilename() : 첨부파일의 파일명을 반환
        System.out.println("파일명 = " + multipartFile.getOriginalFilename());
        // .isEmpty() : 첨부파일이 있으면 false 없으면 true 반환
        System.out.println("존재 여부 = " + multipartFile.isEmpty());
        // (3) 업로드 할 경로 만들기 / 동일한 파일명으로 업로드할 경우 식별이 불가능 / 해결방안 : UUID, 식별자 생성
        // UUID 규약에 따른 난수 문자열 생성(고유성 보장)
        String uuid = UUID.randomUUID().toString();
        System.out.println("uuid = " + uuid);
        // uuid + 파일명(파일명에 _언더바가 존재하면 -하이픈으로 모두 변경) / _언더바는 uuid와 파일명을 구분하는 용도로 사용해야 하기 때문에 -하이픈으로 변경
        String fileName = uuid + "_" + multipartFile.getOriginalFilename().replaceAll("_", "-");
        // 업로드 기본경로 + uuid가 포함된 파일명
        String filePath = uploadPath + fileName;
        System.out.println("filePath = " + filePath);
        // 만일 업로드 경로(/upload 폴더)가 존재X
        if(!new File(uploadPath).exists()) { new File(uploadPath).mkdir(); }
        // (4) File 클래스 : File과 관련된 메소드를 제공하는 클래스 / new File("파일경로");
        File file = new File(filePath);
        // (5) 업로드 하기 / File객체
        try {
            multipartFile.transferTo(file);
        } catch(IOException e) {
            System.out.println(e);
            return null;
        }
        return fileName;
    }
    
    // 사용자 -- HTTP --> 서버 -- FileInputStream --> C:
    // 사용자 <-- HTTP -- 서버 <-- FileInputStream --
    // HTTP : 문자(JSON) 전송, 대용량 파일(첨부파일)은 바이트(바이너리)로 전송
    /** [2] 업로드된 파일 다운로드 */
    public void fileDownload(String filename, HttpServletResponse resp) {
        // (1) 사용자로부터 다운로드 받을 파일명과 HTTP응답 객체를 받는다
        // (2) 다운로드 받을 파일명과 업로드 경로 조합(업로드 기본 경로 + 파일명)
        String downloadPath = uploadPath + filename;
        System.out.println("downloadPath = " + downloadPath);
        // (3) 만일 파일이 존재하지 않으면 리턴(취소)
        File file = new File(downloadPath);
        if(!file.exists()) {
            // 다운로드 취소
            return;
        }
        // (4) 업로드된 파일을 자바(바이트)로 가져오기
        // (4-1) 파일 입력스트립 객체 생성 / new FileInputStream(파일객체);
        try {
            FileInputStream fin = new FileInputStream(downloadPath);
            // (4-2) 해당하는 파일의 용량만큼 배열 선언
            // 파일의 용량 구하기 (long타입으로 반환되어 타입 변환이 필요)
            long fileSize = file.length();
            // 파일의 용량만큼 배열 선언 / 배열은 int타입으로 길이 설정
            byte[] bytes = new byte[(int)fileSize];
            // 파일 입력스트림 객체로 파일 읽어오기 / .read(바이트배열) / 읽어온 바이트들을 바이트배열에 대입
            fin.read(bytes);
            // System.out.println(Arrays.toString(bytes));
            // 파일 입력 스트림 닫기(용량이 클 경우 필수) 생략 시 일정 시간 이후 GC가 삭제 / .close();
            fin.close();
            // (5) 가져온 파일을 HTTP response을 이용하여 요청한 사용자로부터 바이트로 응답하기
            // 파일명에 한글이 존재하면 깨짐 / HTTP는 본래 한글을 지원하지 않음(인코딩 필요)
            // URLEncoder.encode(한글파일명, "UTF-8");
            String oldFilename = URLEncoder.encode(filename.split("_")[1], "UTF-8");
            // * HTTP 응답객체의 헤더 속성 추가 / 브라우저에게 다운로드 형식임을 알림 / 다운로드 화면은 브라우저가 제공
            resp.setHeader("Content-Disposition", "attachment;filename=" + oldFilename);

            // (5-1) 서블릿 출력스트림 객체 생성 / resp.getOutputStream() : resp객체에서 출력스트림 반환
            ServletOutputStream fout = resp.getOutputStream();
            // (5-2) 서블릿 출력스트림객체를 이용해 읽어온 바이트 내보내기 / .write(출력할 배열);
            fout.write(bytes);
            // (5-3) 서블릿 출력스트림 닫기 / .close();
            fout.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    /** [3] 업로드된 파일 삭제 */
    public boolean fileDelete(String filename) {
        System.out.println("FileService.fileDelete start");
        // (1) 삭제할 파일명을 매개변수로 받음
        // (2) 업로드경로와 삭제할 파일명을 연결
        String filePath = uploadPath + filename;
        // (3) new File(파일경로);
        File file = new File(filePath);
        // (4) .exists() : 경로상에 파일이 존재하면 true 없으면 false 반환
        if(file.exists()) {
            // (5) .delete() : 경로상의 파일 삭제
            file.delete();
            System.out.println("FileService.fileDelete end");
            return true;
        }
        System.out.println("FileService.fileDelete end");
        return false;
    }


}

