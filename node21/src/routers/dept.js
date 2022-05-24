var express = require('express');
var mongo = require('mongodb');

var router=express.Router();


router.get('/list',function(req,res){
    var MongoClient = mongo.MongoClient;
    var url = "mongodb://localhost:27017/";

    MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    var dbo = db.db("testDB");
    var coll=dbo.collection("emp");
    var tot;
    coll.find({}).toArray(function(err,result){tot=result.length;});
    var cur=coll.find({}).skip(0).limit(5);
      cur.toArray(function(err, result) { // toArray(func) 배열로 반환
        if (err) throw err;
        console.log(typeof result, Array.isArray(result));
        res.render('dept/list',{total:tot,arr:result});
        db.close();
      });
    });


});




module.exports=router;