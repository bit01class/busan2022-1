import React, { useContext, useEffect } from 'react';
import {Link} from 'react-router-dom';
import { Navbar,Container,Nav } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import UserCtxt, { LOGOUT } from './store';

function Menubar() {
  const user=useContext(UserCtxt);
  useEffect(()=>{
    console.log(typeof user.state.username,user.state);
  },[]);
  const logoutHandler=(e)=>{
    e.preventDefault();
    user.dispatch({type:LOGOUT});
  };
  return (
    <>
        <Navbar bg="primary" variant="dark">
          <Container>
            <Navbar.Brand as={Link} to="/">비트교육센터</Navbar.Brand>
            <Nav className="me-auto">
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to="/">Home</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to="/intro">Intro</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to="/dept">List</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to="/dept/add">Add</Link>
                </li>
                {user.state.result?
                <>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" to="/logout" onClick={logoutHandler}>Logout</Link>
                  </li>
                  <p>{user.state.username}</p>
                </>
                :
                <>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" to="/login">Login</Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" to="/join">Join</Link>
                  </li>
                </>
                }
              </ul>
            </Nav>
          </Container>
        </Navbar>
    </>
  )
}

export default Menubar