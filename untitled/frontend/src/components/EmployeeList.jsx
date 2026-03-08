import EmployeeCard from './EmployeeCard';
import { HiUserGroup } from 'react-icons/hi';

/**
 * EmployeeList component - Renders a responsive grid of EmployeeCards.
 * Props:
 *  - employees: Array of employee objects
 *  - onDelete: callback passed to each EmployeeCard
 *  - loading: boolean for loading state
 */
const EmployeeList = ({ employees, onDelete, loading }) => {
  if (loading) {
    return (
      <div className="flex flex-col items-center justify-center py-20">
        <div className="w-12 h-12 border-4 border-indigo-200 border-t-indigo-600 rounded-full animate-spin"></div>
        <p className="mt-4 text-gray-500 text-sm">Loading employees...</p>
      </div>
    );
  }

  if (!employees || employees.length === 0) {
    return (
      <div className="flex flex-col items-center justify-center py-20 text-center">
        <div className="bg-gray-100 p-5 rounded-2xl mb-4">
          <HiUserGroup className="text-4xl text-gray-400" />
        </div>
        <h3 className="text-gray-600 font-semibold text-lg">No employees found</h3>
        <p className="text-gray-400 text-sm mt-1 max-w-sm">
          Get started by adding your first employee or try a different search term.
        </p>
      </div>
    );
  }

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-5">
      {employees.map((employee) => (
        <EmployeeCard
          key={employee.id}
          employee={employee}
          onDelete={onDelete}
        />
      ))}
    </div>
  );
};

export default EmployeeList;

