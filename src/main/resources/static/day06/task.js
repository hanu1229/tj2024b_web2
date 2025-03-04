async function main() {
    const name1 = "Alice";
    const age1 = 25;
    // 1. let과 const를 사용해서 name(이름)과 age(나이)를 저장하고 값을 출력해 보세요.
    console.log("====== 01번 문제 ======");
    console.log(name1);
    console.log(age1);
    // 2. 숫자 두 개를 받아서 곱한 값을 반환하는 화살표 함수를 작성하세요.
    console.log("====== 02번 문제 ======");
    const func1 = (x, y) => {
        return x * y;
    }
    console.log(func1(3, 4));
    // 3. name과 age를 활용해서 "저는 [이름]이고, [나이]살입니다." 를 출력하세요.
    console.log("====== 03번 문제 ======");
    console.log(`저는 ${name1}이고, ${age1}살입니다.`);
    // 4. user 객체에서 name과 email 값을 추출해 변수를 만들고 출력하세요.
    console.log("====== 04번 문제 ======");
    const user = { name: "Alice", email: "alice@example.com", age: 25 };
    const {name, email} = user;
    console.log(name);
    console.log(email);
    // 5. arr1과 arr2를 합쳐 result 배열을 만드세요.
    console.log("====== 05번 문제 ======");
    const arr1 = [1, 2, 3];
    const arr2 = [4, 5, 6];
    const result = [...arr1, ...arr2];
    console.log(result);
    // 6. greet 함수가 name 값을 받지 않으면 "Guest" 라고 출력하도록 만드세요.
    console.log("====== 06번 문제 ======");
    const greet = (name = "Guest") => `Hello, ${name}!`;
    console.log(greet());
    // 7. 객체를 만들 때 name2, age2 변수를 그대로 사용하세요.
    console.log("====== 07번 문제 ======");
    const name2 = "Alice";
    const age2 = 25;
    const obj1 = {name2, age2};
    console.log(obj1);
    // 8. 첫 번째 값을 first, 나머지를 rest에 저장하세요.
    console.log("====== 08번 문제 ======");
    const numbers = [10, 20, 30, 40];
    const [first, ...rest] = numbers;
    console.log(first);
    console.log(rest);
    // 9. isLoggedIn이 true면 "Welcome!", false면 "Please log in."을 출력하세요.
    console.log("====== 09번 문제 ======");
    const isLoggedIn = true;
    const str1 = isLoggedIn == true ? "Welcome!" : "Please log in.";
    console.log(str1);
    // 10. 동기 fetch를 사용해서 JSONPlaceholder API에서 https://jsonplaceholder.typicode.com/posts/1 데이터를 가져오세요.
    console.log("====== 10번 문제 ======");
    const func2 = async () => {
        try {
            let response = await fetch(`https://jsonplaceholder.typicode.com/posts/1`);
            let data = await response.json();
            console.log(data);
        } catch(e) {
            console.log(e);
        }

    }
    await func2();
    // 11. 배열 ages에서 각 나이를 기준으로 "성인" 또는 "미성년자"를 판단하여 새로운 배열을 만들어 출력하세요.
    console.log("====== 11번 문제 ======");
    const ages = [25, 12, 20, 8];
    let adult = ages.filter((value) => {return value >= 18;});
    let minor = ages.filter((value) => {return value < 18;})
    console.log(adult);
    console.log(minor);
}
main();