import {Link} from "react-router-dom";

export default function Mnav(){
    return (
        <nav className="navbar navbar-inverse">
            <div className="container-fluid">
                <div className="navbar-header">
                <Link className="navbar-brand" to="#">비트교육센터</Link>
                </div>
                <ul className="nav navbar-nav">
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/intro">Intro</Link></li>
                    <li><Link to="/dept">Dept</Link></li>
                    <li><Link to="/login">Login</Link></li>
                </ul>
            </div>
        </nav>
    );
}