import React, { useContext, useRef } from 'react';
import UserCtxt, { LOGIN } from '../modules/store';
import { useNavigate } from "react-router-dom";

function LoginPage() {
  const navigate=useNavigate();
  const user=useContext(UserCtxt);
  
  const inputId=useRef();
  const inputPw=useRef();

  const loginHandler =(e)=>{
    e.preventDefault();
    console.log(inputId.current.value,inputPw.current.value,user);
    //select * from ~~~
    user.dispatch({type:LOGIN,username:inputId.current.value});
    navigate('/');
  };

  return (
    <>
      <h1>login page</h1>
      <form onSubmit={loginHandler}>
        <label> id: 
          <input ref={inputId} />
        </label>
        <label> pw: 
          <input ref={inputPw}/>
        </label>
        <button type='submit'>login</button>
      </form>
    </>
  )
}

export default LoginPage