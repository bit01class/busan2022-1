var mysql = require('mysql');
var pool  = mysql.createPool({
    connectionLimit : 10,   // 미리 만들어놓을 접속객체 수
    host            : 'localhost',
    user            : 'user01',
    password        : '1234',
    database        : 'scott'
});

module.exports=pool;