import axios from 'axios';
import {Link} from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import { Card,Container,CardGroup } from 'react-bootstrap';

function DeptList() {
  const [arr,setArr]=useState([]);

  useEffect(()=>{

    axios.get('http://localhost:8080/api/dept')
      .then(e=>{setArr(e.data)});

  },[]);

  return (
    <Container>
      <h1>List Page</h1>
      <CardGroup>
        {arr.map((bean,idx)=>(
        <Card key={bean.deptno}>
          <Card.Body>
            <Card.Title>{bean.deptno}</Card.Title>
            <Card.Subtitle className="mb-2 text-muted">{bean.dname}</Card.Subtitle>
            <Card.Text>{bean.loc}</Card.Text>
            <Card.Link as={Link} to={"/dept/"+bean.deptno}>Detail</Card.Link>
          </Card.Body>
        </Card>
        ))}

      </CardGroup> 
    </Container>
  )
}

export default DeptList;