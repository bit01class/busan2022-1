import { useState, createContext, useContext, useEffect } from "react";

var UserContext;
function App777({setMsg1}){
    const msg1 = useContext(UserContext); 
    const [msg2, setMsg2] = useState('손자');
    console.log('App777 loading...');
    const btnHandler=()=>{
        setMsg1('ABCD');
    }
    const btnHandler2=()=>{
        setMsg2('바꿈');
    }
    return (
    <div>
        <h1>{msg1}</h1>
        <button onClick={btnHandler}>btn</button>
        <button onClick={btnHandler2}>btn</button>
    </div>
    );
}
function App77({setMsg1}){
    console.log('App77 loading...');
    useEffect(function(){
        setMsg1('ABCD');
    },[]);
    return (
    <div>
        <App777 setMsg1={setMsg1}/>
    </div>
    );
}
export default function App07(){
    UserContext = createContext();
    console.log('App07 loading...');
    const [msg1,setMsg1]=useState('abcd');
    return (
    <div>
        <UserContext.Provider value={msg1}>
        <App77 setMsg1={setMsg1}/>
        </UserContext.Provider>
    </div>
    );
}