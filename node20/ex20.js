var fs=require('fs');
var rs=fs.createReadStream('./ex18.txt');
rs.on('data',function(fileData){        // 스트림 읽어올때 이벤트
    console.log("읽기 :" + fileData);
});
 
rs.on('end',function(){                 // 읽을 것이 없을 때 일어나는 이벤트
    console.log("읽기 종료");
    rs.end();                         // 반드시 end이벤트에서 닫아야 함
});
