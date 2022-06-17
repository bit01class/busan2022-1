import {useNavigate} from "react-router-dom";

function DeptAdd(props){
    const navigate = useNavigate();

    const insertSubmit=(e)=>{
        e.preventDefault();
        const param={};
        param.deptno=Number(e.target.deptno.value);
        param.dname=e.target.dname.value;
        param.loc=e.target.loc.value;
        console.log(param);
        fetch('http://localhost:8080/api/dept/',{
            method: 'POST', // *GET, POST, PUT, DELETE 등
            headers: {
                'Content-Type': 'application/json',
                // 'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: JSON.stringify(param), // body의 데이터 유형은 반드시 "Content-Type" 헤더와 일치
            //body: 'deptno='+param.deptno+"&dname="+param.dname+"&loc="+param.loc
        })
        .then(res=>(res.json()))
        .then(result=>{
            console.log(result)
            console.log(props)
            // this.props.history.push('/dept');
            // props.history.push('/dept');
            navigate('/dept');
        });
    };
    return (
    <>
        <h1>Add page</h1>
        <form onSubmit={insertSubmit}>
        <div className="form-group">
            <label>
            <input type="text" className="form-control" name="deptno" placeholder="deptno"/>
            </label>
        </div>
        <div className="form-group">
            <label>
            <input type="text" className="form-control" name="dname" placeholder="dname"/>
            </label>
        </div>
        <div className="form-group">
            <label>
            <input type="text" className="form-control" name="loc" placeholder="loc"/>
            </label>
        </div>
        <button type="submit" className="btn btn-default">Submit</button>
        </form>
    </>
    );
}

// export default withRouter(DeptAdd);
export default DeptAdd;