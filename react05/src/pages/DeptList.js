import { useEffect,useState } from "react";
import {Link} from "react-router-dom";

export default function DeptList(props){
    const [arr,setArr]=useState([]);

    useEffect(()=>{
        fetch('http://localhost:8080/api/dept')
        .then((res)=>(res.json()))
        .then((json)=>setArr(json))
        ;
    },[]);

    return (
    <>
        <h1>List page</h1>
        <ul className="list-group">
            {arr.map((ele)=>(
                <li className="list-group-item" key={ele.deptno}>{ele.dname}</li>
            ))}
        </ul>
        <Link to="/add" className="btn btn-primary btn-block">입력</Link>
    </>
    );
}