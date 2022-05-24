var mysql = require('mysql');
var my=require('../mymodule/bitmysql');

var express = require('express');
var router=express.Router();
 
router.get('/list', function (req, res) {
    var p=req.query.p==undefined?1:parseInt(req.query.p);
    
    // mysql에서 아래 수행 ('caching_sha2_password'->'mysql_native_password' )
// ALTER USER 'user01'@'localhost' IDENTIFIED WITH mysql_native_password BY '1234';
    var conn = mysql.createConnection(my);
    conn.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
    });    
    var tot;
    conn.query('select count(*) as "tot" from emp',function(err,result){
        tot=result[0].tot;
    });
    conn.query('select * from emp  LIMIT '+5*(p-1)+', 5', function (error, results, fields) {
        if (error) throw error;
        res.render('emplist', {arr: results,total:tot});
    });
    conn.end();
});
router.get('/add',function(req,res){
    res.render('empadd',{obj:null});
});
router.post('/add',function(req,res){

    var conn = mysql.createConnection(my);
    conn.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
    // var sql = "INSERT INTO emp (empno, ename, sal, hiredate) VALUES ("+req.body.empno+",'"+req.body.ename+"',"+req.body.sal+",now())";
    var sql="insert into emp (empno,ename,sal,hiredate) values (?,?,?,now())";
    conn.query(sql,[req.body.empno,req.body.ename,req.body.sal], function (err, result) {
        if (err){
            res.render('empadd',{obj:req.body});
            return;
        };
        console.log('insert',result);
        res.redirect('list');
    });
    });
});

router.get('/row',function(req,res){
      var conn = mysql.createConnection(my);
      conn.connect(function(err) {
      if (err) throw err;
      conn.query('SELECT empno "empno", ename as "ename", sal as "sal" FROM emp WHERE empno = ?',[parseInt(req.query.empno)], function (err, result) {
        if (err) throw err;
        console.log(result);
        res.render("emp",{bean:result[0]});
      });
    });
}); 

router.post('/row',function(req,res){

    var conn = mysql.createConnection(my);
    conn.connect(function(err) {
    if (err) throw err;
    var sql = "UPDATE emp SET ename=?,sal=? WHERE empno=?";
    conn.query(sql,[req.body.ename,req.body.sal,req.body.empno],function (err, result) {
        if (err) throw err;
        console.log(result.affectedRows + " record(s) updated");
        res.redirect('list');
    });
    });

});

router.post('/delete',function(req,res){

    var conn = mysql.createConnection(my);
    conn.connect(function(err) {
    if (err) throw err;
    var sql = "DELETE FROM emp WHERE empno = ?";
    conn.query(sql,[req.body.empno], function (err, result) {
        if (err) throw err;
        console.log("Number of records deleted: " + result.affectedRows);
        if(result.affectedRows>0)res.statusCode=200;
        else res.statusCode=500;
        res.end();
    });
    });
});

module.exports=router;