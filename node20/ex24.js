var http=require('http');
var fs=require('fs');
var url=require('url');
var qs=require('querystring');

var arr=[];

var callback1=function(req,res){
    if(req.url=='/'){
        res.statusCode=200;
        res.setHeader('Content-Type', 'text/html;charset=utf-8');
        res.write('<h1>리스트페이지</h1>');
        res.write('<table>');
        res.write('<tr>');
        res.write('<th>empno</th>');
        res.write('<th>ename</th>');
        res.write('<th>sal</th>');
        res.write('</tr>');
        for(var emp of arr){
        res.write('<tr>');
        res.write('<td>'+emp.empno+'</td>');
        res.write('<td>'+emp.ename+'</td>');
        res.write('<td>'+emp.sal+'</td>');
        res.write('</tr>');
        }
        res.write('</table>');
        res.end('<a href="add.html">입력</a>');
    }else if(req.url=='/add.html'){
        res.statusCode=200;
        res.setHeader('Content-Type', 'text/html;charset=utf-8');
        // res.write('<h1>입력페이지</h1>');
        // res.write('<form action="result.html">');
        // res.write('id<input type="text" name="id"/><br/>');
        // res.write('pw<input type="text" name="pw"/><br/>');
        // res.write('<button>입력</button>');
        // res.end('</form>');
        fs.readFile('ex24.html',function(err,data){
            res.end(data);
        });
    }else if(req.url.startsWith('/result.html')){
        var q= url.parse(req.url).query;
        var params=qs.parse(q);
        console.log(params);
        arr.push(params);
        res.statusCode=200;
        res.setHeader('Content-Type', 'text/html;charset=utf-8');
        res.write('<h1>성공</h1>');
        res.end('<script>setTimeout(function(){location.href="/";},0)</script>');
    }else{
        res.statusCode = 404;
        res.end();
    }

};



http.createServer(callback1).listen(7070,'localhost',function(err){
    console.log('서비스 중...');
});