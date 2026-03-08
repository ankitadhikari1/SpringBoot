import { useNavigate } from 'react-router-dom';
import { HiUserAdd } from 'react-icons/hi';
import EmployeeForm from '../components/EmployeeForm';
import { createEmployee } from '../services/EmployeeService';

/**
 * AddEmployeePage - Page for creating a new employee.
 * Renders the EmployeeForm in create mode.
 */
const AddEmployeePage = () => {
  const navigate = useNavigate();

  const handleCreate = async (employeeData) => {
    await createEmployee(employeeData);
    navigate('/');
  };

  return (
    <div className="min-h-screen bg-gray-50">
      <div className="max-w-2xl mx-auto px-4 sm:px-6 lg:px-8 py-10">
        {/* Page Header */}
        <div className="mb-8">
          <div className="flex items-center gap-3 mb-2">
            <div className="bg-indigo-100 p-2 rounded-xl">
              <HiUserAdd className="text-indigo-600 text-xl" />
            </div>
            <h1 className="text-2xl font-bold text-gray-900">Add New Employee</h1>
          </div>
          <p className="text-gray-500 text-sm ml-12">
            Fill in the details below to add a new employee to the directory.
          </p>
        </div>

        {/* Form Card */}
        <div className="bg-white rounded-2xl shadow-sm border border-gray-100 p-6 sm:p-8">
          <EmployeeForm onSubmit={handleCreate} isEdit={false} />
        </div>
      </div>
    </div>
  );
};

export default AddEmployeePage;

