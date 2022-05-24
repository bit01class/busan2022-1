var path=require('path');
var express = require('express');

var app = express();

app.use(express.static(path.resolve(__dirname,'../public')));
app.set('views',path.resolve(__dirname,'../views'));
app.set('view engine', 'ejs');
app.use(express.urlencoded({extended:false}));

app.get('/emp/list', function (req, res) {
    var p=req.query.p==undefined?1:parseInt(req.query.p);
// mysql에서 아래 수행 ('caching_sha2_password'->'mysql_native_password' )
// ALTER USER 'user01'@'localhost' IDENTIFIED WITH mysql_native_password BY '1234';
    var mysql = require('mysql');

    var conn = mysql.createConnection({
        host: "localhost",
        user: "user01",
        password: "1234",
        database : 'scott'
    });

    conn.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
    });    
    var tot;
    // p=1, 0=5*0(p-1)
    // p=2, 5=5*1(p-1)
    // p=3, 10=5*2(p-1)
    conn.query('select count(*) as "tot" from emp',function(err,result){
        tot=result[0].tot;
        console.log('tot',result[0].tot);
    });
    conn.query('select * from emp  LIMIT '+5*(p-1)+', 5', function (error, results, fields) {
        if (error) throw error;
        res.render('emplist', {arr: results,total:tot});
    });
    conn.end();
//   res.render('emplist', {arr: [{empno:1111,ename:'tester1',sal:1000},{empno:2222,ename:'tester2',sal:1000}]});
});

app.get('/emp/add',function(req,res){
    res.render('empadd',{obj:null});
});
app.post('/emp/add',function(req,res){
    var mysql = require('mysql');

    var con = mysql.createConnection({
    host: "localhost",
    user: "user01",
    password: "1234",
    database: "scott"
    });

    con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
    // var sql = "INSERT INTO emp (empno, ename, sal, hiredate) VALUES ("+req.body.empno+",'"+req.body.ename+"',"+req.body.sal+",now())";
    var sql="insert into emp (empno,ename,sal,hiredate) values (?,?,?,now())";
    con.query(sql,[req.body.empno,req.body.ename,req.body.sal], function (err, result) {
        if (err){
            res.render('empadd',{obj:req.body});
            return;
        };
        console.log('insert',result);
        res.redirect('list');
    });
    });
});

app.listen(3000,function(){
    console.log('server starting...');
    console.log( path.resolve(__dirname,'../public'));
});
