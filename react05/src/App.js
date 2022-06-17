import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import Intro from './pages/Intro';
import DeptList from './pages/DeptList';
import Login from './pages/Login';
import Mnav from './modules/Mnav';
import DeptAdd from './pages/DeptAdd';

function App() {
  return (
    <BrowserRouter>
    <Mnav/>
    <Routes>
      <Route path="/" element={<Home />}/>
      <Route path="/intro" element={<Intro />}/>
      <Route path="/dept" element={<DeptList />}/>
      <Route path='/add' element={<DeptAdd />}/>
      <Route path="/login" element={<Login />}/>
    </Routes>
  </BrowserRouter>
  );
}

export default App;
