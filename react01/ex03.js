let obj1={'key1':'val1'};

let obj2={key2:'val2'};
let obj3={['key3']:'val3'};
var key4='val4';
let obj4={key4};
let obj5={key4:key4};
let obj6={key1:1111,key2:2222};

let obj7={...obj6,key1:3333};
let obj8=JSON.parse(JSON.stringify(obj6));
let obj9=Object.assign({},obj6);

let obj10={func1(){console.log('func10');}};
let obj11={func1:function(){console.log('func11');}};
obj11.func1();
