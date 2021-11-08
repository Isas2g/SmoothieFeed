import React from 'react';
import './styles/zeroing-file.css';
import './styles/App.scss';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import MainNews from "./pages/MainNews";
import Main from "./pages/Main";
import Entry from "./pages/Entry";
import Programs from "./pages/Programs";
import Achievements from "./pages/Achievements";
import AboutApplication from "./pages/AboutApplication";


function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Main />} />
            <Route path="/news" element={<MainNews />} />
            <Route path="/entry" element={<Entry />} />
            <Route path="/programs" element={<Programs />} />
            <Route path="/achievements" element={<Achievements />} />
            <Route path="/about" element={<AboutApplication />} />
        </Routes>
    </BrowserRouter>
  );
}

export default App;
