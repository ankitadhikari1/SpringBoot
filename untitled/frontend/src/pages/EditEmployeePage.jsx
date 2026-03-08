import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { HiPencilAlt } from 'react-icons/hi';
import EmployeeForm from '../components/EmployeeForm';
import { getEmployeeById, updateEmployee } from '../services/EmployeeService';

/**
 * EditEmployeePage - Page for editing an existing employee.
 * Fetches the employee by ID from URL params and renders a pre-filled form.
 */
const EditEmployeePage = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [employee, setEmployee] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    const fetchEmployee = async () => {
      try {
        const response = await getEmployeeById(id);
        setEmployee(response.data);
      } catch (err) {
        setError('Employee not found. It may have been deleted.');
        console.error('Failed to fetch employee:', err);
      } finally {
        setLoading(false);
      }
    };
    fetchEmployee();
  }, [id]);

  const handleUpdate = async (employeeData) => {
    await updateEmployee(id, employeeData);
    navigate('/');
  };

  if (loading) {
    return (
      <div className="min-h-screen bg-gray-50 flex items-center justify-center">
        <div className="flex flex-col items-center">
          <div className="w-12 h-12 border-4 border-indigo-200 border-t-indigo-600 rounded-full animate-spin"></div>
          <p className="mt-4 text-gray-500 text-sm">Loading employee data...</p>
        </div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="min-h-screen bg-gray-50 flex items-center justify-center">
        <div className="text-center">
          <p className="text-red-500 font-medium">{error}</p>
          <button
            onClick={() => navigate('/')}
            className="mt-4 px-4 py-2 text-sm bg-indigo-600 text-white rounded-xl hover:bg-indigo-700 transition-colors cursor-pointer"
          >
            Back to Home
          </button>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gray-50">
      <div className="max-w-2xl mx-auto px-4 sm:px-6 lg:px-8 py-10">
        {/* Page Header */}
        <div className="mb-8">
          <div className="flex items-center gap-3 mb-2">
            <div className="bg-amber-100 p-2 rounded-xl">
              <HiPencilAlt className="text-amber-600 text-xl" />
            </div>
            <h1 className="text-2xl font-bold text-gray-900">Edit Employee</h1>
          </div>
          <p className="text-gray-500 text-sm ml-12">
            Update the details for {employee?.firstName} {employee?.lastName}.
          </p>
        </div>

        {/* Form Card */}
        <div className="bg-white rounded-2xl shadow-sm border border-gray-100 p-6 sm:p-8">
          <EmployeeForm
            initialData={employee}
            onSubmit={handleUpdate}
            isEdit={true}
          />
        </div>
      </div>
    </div>
  );
};

export default EditEmployeePage;

