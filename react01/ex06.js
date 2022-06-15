let func1=function(){console.log(this);return 'func1 run...';};
//let result1=func1();
let func2=()=>{console.log(this);return 'func2 run...';};
//let result2=func2(12,34);
// console.log(result1,result2);
func2();
// new func1();
