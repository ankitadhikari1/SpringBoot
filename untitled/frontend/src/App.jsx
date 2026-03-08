import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import HomePage from './pages/HomePage';
import AddEmployeePage from './pages/AddEmployeePage';
import EditEmployeePage from './pages/EditEmployeePage';

/**
 * Root App component.
 * Sets up routing and renders the Navbar + page content.
 */
function App() {
  return (
    <Router>
      <div className="min-h-screen bg-gray-50">
        <Navbar />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/add" element={<AddEmployeePage />} />
          <Route path="/edit/:id" element={<EditEmployeePage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
