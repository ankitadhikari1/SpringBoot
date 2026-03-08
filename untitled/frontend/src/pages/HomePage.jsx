import { useState, useEffect, useCallback } from 'react';
import { Link } from 'react-router-dom';
import { HiPlus } from 'react-icons/hi';
import EmployeeList from '../components/EmployeeList';
import SearchBar from '../components/SearchBar';
import { getAllEmployees, deleteEmployee, searchEmployees } from '../services/EmployeeService';

/**
 * HomePage - Main dashboard page.
 * Displays the employee list with search and delete functionality.
 */
const HomePage = () => {
  const [employees, setEmployees] = useState([]);
  const [loading, setLoading] = useState(true);
  const [searchQuery, setSearchQuery] = useState('');
  const [stats, setStats] = useState({ total: 0, departments: 0 });

  // Fetch all employees on mount
  const fetchEmployees = useCallback(async () => {
    setLoading(true);
    try {
      const response = await getAllEmployees();
      setEmployees(response.data);
      // Calculate stats
      const departments = new Set(response.data.map((e) => e.department));
      setStats({ total: response.data.length, departments: departments.size });
    } catch (error) {
      console.error('Failed to fetch employees:', error);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    fetchEmployees();
  }, [fetchEmployees]);

  // Handle search
  const handleSearch = useCallback(async (query) => {
    setSearchQuery(query);
    if (!query.trim()) {
      fetchEmployees();
      return;
    }
    setLoading(true);
    try {
      const response = await searchEmployees(query);
      setEmployees(response.data);
    } catch (error) {
      console.error('Search failed:', error);
    } finally {
      setLoading(false);
    }
  }, [fetchEmployees]);

  // Handle delete with confirmation
  const handleDelete = async (id, name) => {
    if (!window.confirm(`Are you sure you want to delete ${name}? This action cannot be undone.`)) {
      return;
    }
    try {
      await deleteEmployee(id);
      setEmployees((prev) => prev.filter((e) => e.id !== id));
      setStats((prev) => ({ ...prev, total: prev.total - 1 }));
    } catch (error) {
      console.error('Failed to delete employee:', error);
      alert('Failed to delete employee. Please try again.');
    }
  };

  const clearSearch = () => {
    setSearchQuery('');
    fetchEmployees();
  };

  return (
    <div className="min-h-screen bg-gray-50">
      {/* Hero Header */}
      <div className="bg-white border-b border-gray-100">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
          <div className="flex flex-col sm:flex-row sm:items-center sm:justify-between gap-4">
            <div>
              <h1 className="text-2xl font-bold text-gray-900">Employee Directory</h1>
              <p className="text-gray-500 text-sm mt-1">
                {stats.total} employee{stats.total !== 1 ? 's' : ''} across {stats.departments} department{stats.departments !== 1 ? 's' : ''}
              </p>
            </div>
            <Link
              to="/add"
              className="inline-flex items-center gap-2 px-5 py-2.5 text-sm font-medium rounded-xl
                         text-white bg-indigo-600 hover:bg-indigo-700 transition-colors shadow-sm"
            >
              <HiPlus className="text-lg" />
              Add Employee
            </Link>
          </div>

          {/* Search Bar */}
          <div className="mt-6">
            <SearchBar
              query={searchQuery}
              onQueryChange={handleSearch}
              onClear={clearSearch}
            />
          </div>
        </div>
      </div>

      {/* Employee Grid */}
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
        {searchQuery && (
          <p className="text-sm text-gray-500 mb-4">
            Showing results for "<span className="font-medium text-gray-700">{searchQuery}</span>"
          </p>
        )}
        <EmployeeList
          employees={employees}
          onDelete={handleDelete}
          loading={loading}
        />
      </div>
    </div>
  );
};

export default HomePage;

