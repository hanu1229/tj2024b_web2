// MUI : 리액트, JS기반의 미리 만들어진 컴포넌트들을 제공하는 회사명
// 비슷한 회사 : 부트스트랩
/*
    1. MUI가 제공하는 컴포넌트 파트
        - Material UI
        - JOY UI
        - MUI X
        - toolpad

    2. Material UI 설치
        - 컴포넌트 설치 : npm install @mui/material @emotion/react @emotion/styled
        - 컴포넌트 CSS 설치 : npm install @mui/material @mui/styled-engine-sc styled-components
        - 아이콘 설치 : npm install @mui/icons-material

    3. Material UI에서 사용하고 싶은 컴포넌트 코드 가져오기
        - <Button> : MUI에서 제공하는 마크업(컴포넌트), 별도의 import가 필요
        - <button> : HTML에서 제공하는 마크업(컴포넌트), 별도의 import가 필요 없음
        - <Ration> : MUI에서 제공하는 마크업(컴포넌트), 별도의 import가 필요
*/

/*
    * 리액트(node.js) 환경에서 외부 라이브러리 다운로드 받는 방법
    서버(터미널)가 꺼져 있는 상태에서 리액트 최상위 폴더 클릭 후 터미널 열기
    설치할 라이브러리 npm코드 넣고 엔터 --> 알아서 설치 후 'package.json'파일 내 'dependencies'에 코드 자동 작성
    --> 협업(다른 사람이 라이브러리를 설치 하면 'package.json'이 변경되고 취합 이후에 다른 사람들은 npm install )
    npm install : 현재 'package.json'파일내 'dependencies'코드의 라이브러리를 자동 설치
*/

import Button from '@mui/material/Button';
import Rating from '@mui/material/Rating';
import { Box, Divider, FormControl, InputLabel, List, ListItem, ListItemButton, ListItemIcon, ListItemText, MenuItem, Select, Typography } from '@mui/material';
import InboxIcon from '@mui/icons-material/Inbox';
import DraftsIcon from '@mui/icons-material/Drafts';
import { useState } from 'react';

export default function Example1(props) {

    const [value, setValue] = useState(2);
    const [age, setAge] = useState('');

    const handleChange = (event) => {
      setAge(event.target.value);
    };

    return (
        <>  
            <h3>버튼</h3>
            <Button variant="outlined">MUI 버튼</Button>
            <button>HTML 버튼</button>

            <h3>별 찍기</h3>
            <Typography component="legend">Read only</Typography>
            <Rating name="read-only" value={value} readOnly />

            <h3>Select</h3>
            <FormControl fullWidth>
                <InputLabel id="demo-simple-select-label">부서</InputLabel>
                <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    label="부서"
                >
                    <MenuItem value={"인사팀"}>인사팀</MenuItem>
                    <MenuItem value={"영업팀"}>영업팀</MenuItem>
                    <MenuItem value={"개발팀"}>개발팀</MenuItem>
                </Select>
            </FormControl>
            <select>
                <option>인사팀</option>
                <option>영업팀</option>
                <option>개발팀</option>
            </select>

            <h3>List</h3>
            {/* List : ul/ol과 비슷하게 mui에서 리스트(목록)를 구성할때 사용되는 컴포넌트 */}
            <Box sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
                <nav aria-label="main mailbox folders">
                    <List>
                        <ListItem disablePadding>
                            <ListItemButton>
                                <ListItemIcon>
                                    <InboxIcon />
                                </ListItemIcon>
                                <ListItemText primary="인사관리" />
                            </ListItemButton>
                        </ListItem>
                        <ListItem disablePadding>
                            <ListItemButton>
                                <ListItemIcon>
                                    <DraftsIcon />
                                </ListItemIcon>
                                <ListItemText primary="부품관리" />
                            </ListItemButton>
                        </ListItem>
                    </List>
                </nav>
                <Divider />
                <nav aria-label="secondary mailbox folders">
                    <List>
                        <ListItem disablePadding>
                            <ListItemButton>
                                <ListItemText primary="Trash" />
                            </ListItemButton>
                        </ListItem>
                            <ListItem disablePadding>
                                <ListItemButton component="a" href="#simple-list">
                                    <ListItemText primary="Spam" />
                                </ListItemButton>
                            </ListItem>
                    </List>
                </nav>
            </Box>
        </>
    );
}