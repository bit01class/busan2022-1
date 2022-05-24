var fs=require('fs');
// fs.writeFile('ex18.txt','내용을 작성합니다',function(err){
//     if(err)console.log(err);    
// });
// fs.readFile('ex18.txt',function(err,data){
//     console.log(data.toString());
// });
fs.writeFileSync('ex18.txt','동기적 실행으로 작성');
console.log(fs.readFileSync('ex18.txt'));
// console.log(new Buffer('동기적 실행으로 작성'));
console.log(Buffer.from('동기적 실행으로 작성'));
console.log(Buffer.from('동기적 실행으로 작성').toString());
console.log(Buffer.alloc(5));