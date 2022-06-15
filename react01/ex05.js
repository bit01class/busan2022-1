var arr1=['item1','item2','item3'];

// for(i=0; i<arr1.length; i++){
//     console.log(arr1[i]);
// }
// for(let idx in arr1){
//     console.log(arr1[idx]);
// }
// for(let item of arr1){
//     console.log(item);
// }
// let result1=arr1.forEach(function(ele,idx){
    // console.log(ele,idx);
// });
// let result2=arr1.map(function(ele,idx){
//     // console.log(ele,idx);
//     return ele+idx;
// });
// let result3=arr1.filter(function(ele,idx){
//     console.log(ele,idx)
//     if(idx!=1)return ele;
// });
// let result4=arr1.find(function(ele,idx){
//     console.log(ele,idx);
//     return ele=='item2';
// });
// let result5=arr1.every(function(ele,idx,arr){
//     console.log(ele,idx,arr);
//     return false;
// });

// let result6=arr1.some(function(ele,idx,arr){
//     console.log(ele,idx,arr);
//     return true;
// });
// let arr2=[1,3,5,7,9];
// let result7=arr2.reduce(function(prev,ele,idx,arr){
//     console.log(prev,ele,idx,arr);
//     return prev+ele;
// });
// let result7=arr1.reduce(function(prev,ele,idx,arr){
//     console.log(prev,ele,idx,arr);
//     return prev+','+ele;
// });

let arr3=[1,3,5,7];
let arr4=[2,4,6,1];
let arr5=arr3.concat(arr4);
let arr6=[].concat(arr3);
console.log(arr5,arr3,arr4,arr6);
