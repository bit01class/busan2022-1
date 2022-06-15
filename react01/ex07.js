class Cl01{
    constructor(a){
        console.log(this);
        this.su1=a;
    }
    getSu1(){return this.su1;}
    setSu1(a){this.su1=a;}
}

let obj1=new Cl01(2222);
console.log(obj1.getSu1());
obj1.setSu1(3333);
console.log(obj1.getSu1());

class Cl02 extends Cl01{
    constructor(b){
        super(1111);
        this.su2=b;
    }
}
let obj3=new Cl02(6666);
// obj3.setSu1(5555);
console.log(obj3.getSu1());
console.log(obj3.su1,obj3.su2);
