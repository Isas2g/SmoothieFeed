import React from 'react';
import './styles/zeroing-file.css';
import './styles/App.scss';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import MainNews from "./pages/MainNews";
import Main from "./pages/Main";


function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Main />} />
            <Route path="/news" element={<MainNews />} />
        </Routes>
    </BrowserRouter>
  );
}

export default App;
