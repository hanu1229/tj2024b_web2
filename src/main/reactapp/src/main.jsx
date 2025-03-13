import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
// import './index.css';
// import App from './App.jsx';

// react 18
/*
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
*/
// (*) index.html에 rootDOM 가져오기
const root = createRoot(document.querySelector("#root"))

// day01 : 컴포넌트 만들기 렌더링
// import 호출할컴포넌트명 from '경로/파일명(확장자);
// import Component1 from './example/1_동작구조/Component1.js';
// root.render(<Component1 />);

// day01 : 여러컴포넌트 만들기
// import Component2 from './example/1_동작구조/Component2.jsx';
// root.render(<Component2 />);

// day02 : 컴포넌트의 JSX활용
// import Example1 from './example/2_컴포넌트/Example1.jsx';
// root.render(<Example1 />);

// day02 : 컴포넌트의 JSX활용
// import Example2 from './example/2_컴포넌트/Example2.jsx';
// root.render(<Example2 />);

// day02 : Task.jsx 실습
// import Task from './example/2_컴포넌트/task.jsx';
// root.render(<Task />);

// day03 : 생명주기1
// import Example1 from './example/3_훅/Example1.jsx';
// root.render(<Example1 />);

// day03 : 생명주기2
// import Example2 from './example/3_훅/Example2.jsx';
// root.render(<Example2 />);

// day03 : 생명주기3
// import Example3 from './example/3_훅/Example3.jsx';
// root.render(<Example3 />);

// day03 : 3_훅.Task1.jsx 과제1
// import Task1 from './example/3_훅/Task1.jsx';
// root.render(<Task1 />);

// day03 : 3_훅.Task2.jsx 과제3
// import Task2 from './example/3_훅/Task2.jsx';
// root.render(<Task2 />);

// day04 : 4_훅2 useEffect 사용법
// import Example1 from './example/4_훅2/Example1.jsx';
// root.render(<Example1 />);

// day04 : 5_라우터 라우터 사용법
// 맨 위에 존재하는 import App 샘플 코드를 주석 처리
// 맨 위에 존재하는 import ./index.css를 주석 처리
// import App from './example/5_라우터/Example1.jsx';
// root.render(<App />);

// day05 : 6_AXIOS axios 사용법 (application/json)
// import Example1 from './example/6_AXIOS/Example1';
// root.render(<Example1 />);

// day05 : 6_AXIOS axios 사용법 (multipart/form-data)
// import Example2 from './example/6_AXIOS/Example2.jsx';
// root.render(<Example2 />);

// day05 : 6_AXIOS Task.jsx
// import Task from './example/6_AXIOS/Task.jsx';
// root.render(<Task />)

// day06 : 7_AXIOS2 라우터 사용법
// import './App.css';
// import App from './example/7_AXIOS2/App';
// root.render(<App />);

// day07(2025-03-13) : 8_MUI Material UI 사용법
// import "./App.css";
// import Example1 from './example/8_MUI/Example1';
// root.render(<Example1 />);

// day07(2025-03-13) : 8_MUI Joy UI 사용법
import "./App.css";
import Example2 from './example/8_MUI/Example2';
root.render(<Example2 />);