import { useNavigate } from 'react-router-dom';
import { HiPencil, HiTrash, HiMail, HiPhone, HiCalendar, HiCurrencyDollar, HiOfficeBuilding } from 'react-icons/hi';

/**
 * EmployeeCard component - Displays individual employee info in a card.
 * Props:
 *  - employee: Employee object
 *  - onDelete: callback when delete button is clicked
 */
const EmployeeCard = ({ employee, onDelete }) => {
  const navigate = useNavigate();

  // Generate avatar initials from name
  const initials = `${employee.firstName?.[0] || ''}${employee.lastName?.[0] || ''}`.toUpperCase();

  // Department color mapping for visual distinction
  const departmentColors = {
    Engineering: 'bg-blue-100 text-blue-700',
    Marketing: 'bg-pink-100 text-pink-700',
    Finance: 'bg-green-100 text-green-700',
    HR: 'bg-yellow-100 text-yellow-700',
    Design: 'bg-purple-100 text-purple-700',
    Sales: 'bg-orange-100 text-orange-700',
  };
  const deptColor = departmentColors[employee.department] || 'bg-gray-100 text-gray-700';

  // Avatar background colors
  const avatarColors = [
    'bg-indigo-500', 'bg-pink-500', 'bg-emerald-500', 'bg-amber-500',
    'bg-cyan-500', 'bg-rose-500', 'bg-violet-500', 'bg-teal-500',
  ];
  const avatarColor = avatarColors[(employee.id || 0) % avatarColors.length];

  const formatSalary = (salary) => {
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD',
      minimumFractionDigits: 0,
    }).format(salary);
  };

  const formatDate = (dateStr) => {
    if (!dateStr) return '—';
    return new Date(dateStr).toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
    });
  };

  return (
    <div className="bg-white rounded-2xl shadow-sm border border-gray-100 hover:shadow-md hover:border-gray-200 transition-all duration-300 overflow-hidden group">
      {/* Card Header */}
      <div className="p-5 pb-3">
        <div className="flex items-start gap-4">
          {/* Avatar */}
          <div className={`${avatarColor} w-12 h-12 rounded-xl flex items-center justify-center text-white font-bold text-sm shrink-0 shadow-sm`}>
            {initials}
          </div>

          {/* Name & Department */}
          <div className="flex-1 min-w-0">
            <h3 className="text-gray-900 font-semibold text-base truncate">
              {employee.firstName} {employee.lastName}
            </h3>
            <span className={`inline-block mt-1 px-2.5 py-0.5 rounded-full text-xs font-medium ${deptColor}`}>
              <HiOfficeBuilding className="inline mr-1 -mt-0.5" />
              {employee.department}
            </span>
          </div>
        </div>
      </div>

      {/* Card Body - Details */}
      <div className="px-5 pb-4 space-y-2.5">
        <div className="flex items-center gap-2 text-sm text-gray-500">
          <HiMail className="text-gray-400 shrink-0" />
          <span className="truncate">{employee.email}</span>
        </div>

        {employee.phone && (
          <div className="flex items-center gap-2 text-sm text-gray-500">
            <HiPhone className="text-gray-400 shrink-0" />
            <span>{employee.phone}</span>
          </div>
        )}

        <div className="flex items-center justify-between">
          <div className="flex items-center gap-2 text-sm text-gray-500">
            <HiCurrencyDollar className="text-gray-400 shrink-0" />
            <span className="font-medium text-gray-700">{formatSalary(employee.salary)}</span>
          </div>
          {employee.joinDate && (
            <div className="flex items-center gap-1.5 text-xs text-gray-400">
              <HiCalendar className="shrink-0" />
              <span>{formatDate(employee.joinDate)}</span>
            </div>
          )}
        </div>
      </div>

      {/* Card Footer - Actions */}
      <div className="border-t border-gray-50 px-5 py-3 flex justify-end gap-2 opacity-0 group-hover:opacity-100 transition-opacity duration-200">
        <button
          onClick={() => navigate(`/edit/${employee.id}`)}
          className="inline-flex items-center gap-1.5 px-3 py-1.5 text-xs font-medium rounded-lg
                     text-indigo-600 bg-indigo-50 hover:bg-indigo-100 transition-colors cursor-pointer"
        >
          <HiPencil className="text-sm" />
          Edit
        </button>
        <button
          onClick={() => onDelete(employee.id, `${employee.firstName} ${employee.lastName}`)}
          className="inline-flex items-center gap-1.5 px-3 py-1.5 text-xs font-medium rounded-lg
                     text-red-600 bg-red-50 hover:bg-red-100 transition-colors cursor-pointer"
        >
          <HiTrash className="text-sm" />
          Delete
        </button>
      </div>
    </div>
  );
};

export default EmployeeCard;

