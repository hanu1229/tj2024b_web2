package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    /**
        [1] 업로드 : 스프링에서는 MultipartFile 인터페이스를 지원하므로 파일 업로드를 지원 <br/>
        Content-Type : multipart/form-data <br/>
        BODY : Text대신 Form 선택 name : multipartFile [File] = "파일"
    */
    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile) {
        System.out.println("FileController.fileUpload start");
        System.out.println("multipartFile = " + multipartFile);
        String result = fileService.fileUpload(multipartFile);
        System.out.println("result = " + result);
        System.out.println("FileController.fileUpload end");
        return result;
    }

    /** [2] 업로드된 파일 다운로드 */
    @GetMapping("/download")
    public void fileDownload(@RequestParam(name = "filename") String filename, HttpServletResponse resp) {
        System.out.println("FileController.fileDownload start");
        System.out.println("filename = " + filename + ", resp = " + resp);
        fileService.fileDownload(filename, resp);
    }

    /** [3] 업로드된 파일 삭제 */
    // url?filename=[삭제할파일명]
    @DeleteMapping("/delete")
    public boolean fileDelete(@RequestParam(name = "filename") String filename) {
        System.out.println("FileController.fileDelete start");
        System.out.println("filename = " + filename);
        boolean result = fileService.fileDelete(filename);
        System.out.println("result = " + result);
        System.out.println("FileController.fileDelete end");
        return result;

    }
}
