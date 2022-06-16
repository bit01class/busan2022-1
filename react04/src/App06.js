import { useEffect, useState } from "react";


export default function App06(props){
    console.log('App06 loading...');
    const [msg,setMsg]=useState(1);
    const [msg2,setMsg2]=useState("두번째");
    useEffect(function(){
        setTimeout(() => {
            setMsg(msg+1);
            
        }, 3000);
    },[msg,msg2]);

    const btnHandler=()=>{
        setMsg(1);
    };
    const btnHandler2=()=>{
        setMsg2(new String(msg2));
    };

    return (
        <div>
            <h1>{msg}-{msg2}</h1>
            <button onClick={btnHandler}>버튼</button>
            <button onClick={btnHandler2}>버튼</button>
        </div>
    );
}