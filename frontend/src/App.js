import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

import Home from './pages/Home/Home.jsx';
import NotFound from './pages/NotFound/NotFound.jsx';

import './styles/Main.css';

function App() {
  return (
   <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </Router>
  );
}

export default App;
