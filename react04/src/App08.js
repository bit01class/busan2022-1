import { useReducer } from "react";
const ADD='ADD';
const DELETE='DELETE';
let init=[<li>item1</li>];

function reducer(state,action){
    const cnt=state.length;
    switch(action.type){
    case ADD:
        return [...state,<li>{action.msg}{cnt+1}</li>];
    case DELETE:
        return state.filter(function(ele,idx){
            return cnt-1!=idx;
        });
    default :
        return state;
    }
}
export default function App08(){
    const [lis, dispatch]= useReducer(reducer,init);
    return (
        <>
        <button onClick={()=>{dispatch({type:ADD,msg:'add'})}}>add</button>
        <button onClick={()=>{dispatch({type:DELETE})}}>delete</button>
        <ul>
            {lis.map((ele,idx)=>ele)}
        </ul>
        </>
    );
}