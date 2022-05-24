var fs=require('fs');
var ws=fs.createWriteStream('ex18.txt');
ws.write('한번 작성합니다\n');
ws.write('또한번 작성합니다');
ws.end();