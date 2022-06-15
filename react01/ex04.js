let su=1234;
let msg1='"문자"'+su+'열';
let msg2="'문자'"+su+"열";
let msg3=`문자${su}열`;
let msg4=`
개행
`;
console.log(msg1,msg2,msg3,msg4);