var fs=require('fs');
//console.log(fs);
var obj;

// 비동기
// fs.readFile('./ex01.js',function(err,data){
//     console.log(data);
//     console.log(data.toString());
//     obj=data.toString();
// });
// 동기
obj=fs.readFileSync('./ex01.js');

console.log(obj.toString());

