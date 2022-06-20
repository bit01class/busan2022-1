import React from "react";

export const LOGIN="login";
export const LOGOUT="LOGOUT";

export const initialState={
    result:false,
    username:'guest'
  };
export const reducer=(state,action)=>{
    switch (action.type) {
      case LOGIN:
        return {...state,result:true,username:action.username};
  
      case LOGOUT:
        return {...state,result:false,username:'guest'};
    
      default:
        return state;
    }
  };
  
const UserCtxt=React.createContext();

export default UserCtxt;