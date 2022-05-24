var mysql = require('mysql');
var express = require('express');
var app = express();
 
var path=require('path');
app.use(express.static(path.resolve(__dirname,'../public')));
app.set('views',path.resolve(__dirname,'../views'));
app.set('view engine', 'ejs');
app.use(express.json(),express.urlencoded({extended:false}));


app.use('/emp',require('./routers/emp'));



app.listen(3000,function(){
    console.log('server starting...');
    console.log( path.resolve(__dirname,'../public'));
});
