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
    //var cur=coll.find({}).skip(0).limit(5);
    var cur=coll.find();
      cur.toArray(function(err, result) { // toArray(func) 배열로 반환
        if (err) throw err;
        console.log(typeof result, Array.isArray(result));
        res.render('dept/list',{total:tot,arr:result});
        db.close();
      });
    });


});
router.get('/add',function(req,res){
    res.render('dept/add');
});

router.post('/add',function(req,res){
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/";

    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("testDB");
        var myobj = {empno:req.body.empno,ename:req.body.ename,sal:req.body.sal};
        dbo.collection("emp").insertOne(myobj, function(err, result) {
            if (err) throw err;
            console.log("1 document inserted",result.insertedId);
            db.close();
            res.redirect('/dept/list');
        });
    });

});

router.get('/row',function(req,res){
    var param=req.query._id;
    var MongoClient = mongo.MongoClient;
    var url = "mongodb://localhost:27017/";

    MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    var dbo = db.db("testDB");
    dbo.collection("emp").findOne({_id:new mongo.ObjectId(param)}, function(err, result) {
            if (err) throw err;
            console.log(result);
            db.close();
            res.render('dept/emp',{bean:result});
        });
    });
});

router.post('/row',function(req,res){
    console.log(req.body);
    var MongoClient = mongo.MongoClient;
    var url = "mongodb://127.0.0.1:27017/";

    MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    var dbo = db.db("testDB");
    var myquery = { _id: new mongo.ObjectId(req.body._id) };
    var newvalues = { $set: {empno: parseInt(req.body.empno), ename: req.body.ename} };
    if(req.body.sal) newvalues['$set'].sal=parseInt(req.body.sal);
    dbo.collection("emp").updateOne(myquery, newvalues, function(err, result) {
            if (err) throw err;
            console.log("updated",result);
            db.close();
        });
    });
    res.redirect("list");
});

module.exports=router;