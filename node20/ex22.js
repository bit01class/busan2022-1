var evn=require('events'); 
var emit=new evn.EventEmitter();
emit.once('event1',function(e){
    console.log('이벤트1 발생');
});
var callback2=function(e){
    console.log('이벤트2 발생');
};
emit.on('event1',callback2);
var callback3=function(e){
    console.log('이벤트3 발생');
};
emit.addListener('event3',callback3);


emit.removeListener('event1',callback2);

console.log(emit.eventNames(),emit.listenerCount('event1'));
emit.emit('event1');
emit.emit('event1');
// emit.removeListener('event3',callback3);
emit.off('event3',callback3);
emit.emit('event3');
