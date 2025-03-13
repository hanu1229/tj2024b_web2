/*
    Joy UI : 
    - 설치 : npm install @mui/joy @emotion/react @emotion/styled
    - 
*/

import Table from '@mui/joy/Table';
import Sheet from '@mui/joy/Sheet';
import ModalClose from '@mui/joy/ModalClose';
import { Button, Modal, Typography } from '@mui/material';
import { BarChart } from '@mui/x-charts/BarChart';
import { useState } from 'react';
import { LineChart } from '@mui/x-charts';

export default function Example2(props) {

    const [open, setOpen] = useState(false);

    return (
        <>
            <h3>HTML 테이블</h3>
            <table style={{margin : "0px auto"}}>
                <thead>
                    <tr>
                        <th>제목</th><th>작성자</th>
                    </tr>
                </thead>
                <tbody>
                    <tr><td>안녕하세요1</td><td>유재석</td></tr>
                    <tr><td>안녕하세요2</td><td>강호동</td></tr>
                </tbody>
            </table>

            <h3>MUI Joy UI 테이블</h3>
            <Table aria-label="basic table">
                <thead>
                    <tr>
                        <th>제목</th><th>작성자</th>
                    </tr>
                </thead>
                <tbody>
                    <tr><td>안녕하세요1</td><td>유재석</td></tr>
                    <tr><td>안녕하세요2</td><td>강호동</td></tr>
                </tbody>
            </Table>

            <h3>모달</h3>
            <Button variant="outlined" color="neutral" onClick={() => setOpen(true)}>모달창</Button>

            <Modal
                aria-labelledby="modal-title"
                aria-describedby="modal-desc"
                open={open}
                onClose={() => setOpen(false)}
                sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}
            >
                <Sheet variant="outlined" sx={{ maxWidth: 500, borderRadius: 'md', p: 3, boxShadow: 'lg' }}>
                    <ModalClose variant="plain" sx={{ m: 1 }} />
                    <Typography component="h2" id="modal-title" level="h4" textColor="inherit" sx={{ fontWeight: 'lg', mb: 1 }}>
                        안녕하세요
                    </Typography>
                    <Typography id="modal-desc" textColor="text.tertiary">
                        회원가입 축하드립니다
                    </Typography>
                </Sheet>
            </Modal>

            <h3>막대 차트</h3>
            {/* 
                xAxis속성 : data는 [가로축]
                series속성 : 축의 값(2차원 배열) , 범례
            */}
            <BarChart
                xAxis={[{ scaleType: 'band', data: ['인사팀', '영업팀', '개발팀'] }]}
                series={[
                    { data: [100, 100, 500] }, 
                    { data: [200, 80, 100] }, 
                    { data: [344, 70, 450] }, 
                    { data: [400, 60, 50] }
                ]}
                width={500}
                height={300}
                style={{margin : "0px auto"}}
            />

            <h3>선 차트</h3>
            {/* 가로축을 문자열로 인식시킬려면 scaleType = "band"를 xAxis에 작성 */}
            <LineChart
                xAxis={[{scaleType : "band", data: ["2023", "2024", "2025"] }]}
                series={[
                {
                data: [1000000, 12577274, 1245455],
                },
                ]}
                width={500}
                height={300}
                style={{margin : "0px auto"}}
            />
        </>
    );
}