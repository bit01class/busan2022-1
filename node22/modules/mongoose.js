var mongoose = require('mongoose');// 1. mongoose 모듈 가져오기
    mongoose.connect('mongodb://localhost:27017/testDB');// 2. testDB 세팅
    var db = mongoose.connection;// 3. 연결된 testDB 사용
    // 6. Schema 생성. (혹시 스키마에 대한 개념이 없다면, 입력될 데이터의 타입이 정의된 DB 설계도 라고 생각하면 됩니다.)
    var emp = mongoose.Schema({
        empno : 'number',
        ename : 'string',
        sal : 'number'
    });

    // 7. 정의된 스키마를 객체처럼 사용할 수 있도록 model() 함수로 컴파일
    var Student = mongoose.model('emp', emp);
    module.exports=Student;