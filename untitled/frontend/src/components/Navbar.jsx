import { Link, useLocation } from 'react-router-dom';
import { HiUserGroup, HiPlus, HiHome } from 'react-icons/hi';

/**
 * Navbar component - Sticky top navigation bar.
 * Shows app title and navigation links with active state highlighting.
 */
const Navbar = () => {
  const location = useLocation();

  const isActive = (path) => location.pathname === path;

  return (
    <nav className="bg-gradient-to-r from-indigo-600 via-purple-600 to-indigo-700 shadow-lg sticky top-0 z-50">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex items-center justify-between h-16">
          {/* Logo & Title */}
          <Link to="/" className="flex items-center gap-3 group">
            <div className="bg-white/20 p-2 rounded-lg group-hover:bg-white/30 transition-all">
              <HiUserGroup className="text-white text-xl" />
            </div>
            <span className="text-white font-bold text-xl tracking-tight">
              Employee Manager
            </span>
          </Link>

          {/* Navigation Links */}
          <div className="flex items-center gap-2">
            <Link
              to="/"
              className={`flex items-center gap-2 px-4 py-2 rounded-lg text-sm font-medium transition-all ${
                isActive('/')
                  ? 'bg-white/25 text-white shadow-inner'
                  : 'text-indigo-100 hover:bg-white/15 hover:text-white'
              }`}
            >
              <HiHome className="text-lg" />
              <span className="hidden sm:inline">Home</span>
            </Link>
            <Link
              to="/add"
              className={`flex items-center gap-2 px-4 py-2 rounded-lg text-sm font-medium transition-all ${
                isActive('/add')
                  ? 'bg-white/25 text-white shadow-inner'
                  : 'text-indigo-100 hover:bg-white/15 hover:text-white'
              }`}
            >
              <HiPlus className="text-lg" />
              <span className="hidden sm:inline">Add Employee</span>
            </Link>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;

