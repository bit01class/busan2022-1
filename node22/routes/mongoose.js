let express=require('express');
const { mongo } = require('mongoose');
const Student = require('../modules/mongoose');
let router=express.Router();

router.get('/add.html',function(req,res){
    res.render('mongoose/add');
});
router.get('/',function(req,res){
    Student.find(function(err,results){
        res.render('mongoose/list',{list:results});
    });
});
router.post('/',function(req,res){

    var newStudent = new Student(req.body);

    newStudent.save(function(){
        res.redirect('./');
    });
});
router.get('/:_id',function(req,res){
    Student.findOne({_id:req.params._id}, function(error,result){
        res.render('mongoose/emp.ejs',{bean:result});
    });
});
router.put('/:_id',function(req,res){
    Student.findById({_id:req.params._id}, function(error,student){
        console.log('--- Update(PUT) ---');
        if(error){
            console.log(error);
        }else{
            student.ename=req.body.ename;
            student.save(function(){
                res.redirect('./');
            });
        }
    });
});

module.exports=router;