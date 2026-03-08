import { useState, useEffect } from 'react';
import { HiSave, HiArrowLeft } from 'react-icons/hi';
import { useNavigate } from 'react-router-dom';

/**
 * EmployeeForm component - Reusable form for creating and editing employees.
 * Props:
 *  - initialData: pre-filled employee data (for edit mode)
 *  - onSubmit: async callback when form is submitted
 *  - isEdit: boolean to toggle between Create/Update mode
 */
const EmployeeForm = ({ initialData = {}, onSubmit, isEdit = false }) => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    department: '',
    salary: '',
    phone: '',
    joinDate: '',
  });
  const [errors, setErrors] = useState({});
  const [submitting, setSubmitting] = useState(false);

  // Populate form when initialData changes (edit mode)
  useEffect(() => {
    if (initialData && Object.keys(initialData).length > 0) {
      setFormData({
        firstName: initialData.firstName || '',
        lastName: initialData.lastName || '',
        email: initialData.email || '',
        department: initialData.department || '',
        salary: initialData.salary || '',
        phone: initialData.phone || '',
        joinDate: initialData.joinDate || '',
      });
    }
  }, [initialData]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
    // Clear error when user types
    if (errors[name]) {
      setErrors((prev) => ({ ...prev, [name]: '' }));
    }
  };

  // Client-side validation
  const validate = () => {
    const newErrors = {};
    if (!formData.firstName.trim()) newErrors.firstName = 'First name is required';
    if (!formData.lastName.trim()) newErrors.lastName = 'Last name is required';
    if (!formData.email.trim()) {
      newErrors.email = 'Email is required';
    } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
      newErrors.email = 'Please enter a valid email';
    }
    if (!formData.department.trim()) newErrors.department = 'Department is required';
    if (!formData.salary) {
      newErrors.salary = 'Salary is required';
    } else if (Number(formData.salary) <= 0) {
      newErrors.salary = 'Salary must be positive';
    }
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!validate()) return;

    setSubmitting(true);
    try {
      await onSubmit({
        ...formData,
        salary: parseFloat(formData.salary),
      });
    } catch (err) {
      // Handle server-side validation errors
      if (err.response?.data?.messages) {
        setErrors(err.response.data.messages);
      }
    } finally {
      setSubmitting(false);
    }
  };

  const departments = ['Engineering', 'Marketing', 'Finance', 'HR', 'Design', 'Sales', 'Operations', 'Support'];

  const inputClasses = (field) =>
    `w-full px-4 py-2.5 rounded-xl border text-sm transition-all focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-transparent ${
      errors[field] ? 'border-red-300 bg-red-50' : 'border-gray-200 bg-white hover:border-gray-300'
    }`;

  return (
    <form onSubmit={handleSubmit} className="space-y-6">
      {/* Name Row */}
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-5">
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1.5">
            First Name <span className="text-red-400">*</span>
          </label>
          <input
            type="text"
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
            placeholder="John"
            className={inputClasses('firstName')}
          />
          {errors.firstName && (
            <p className="mt-1 text-xs text-red-500">{errors.firstName}</p>
          )}
        </div>
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1.5">
            Last Name <span className="text-red-400">*</span>
          </label>
          <input
            type="text"
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
            placeholder="Doe"
            className={inputClasses('lastName')}
          />
          {errors.lastName && (
            <p className="mt-1 text-xs text-red-500">{errors.lastName}</p>
          )}
        </div>
      </div>

      {/* Email */}
      <div>
        <label className="block text-sm font-medium text-gray-700 mb-1.5">
          Email Address <span className="text-red-400">*</span>
        </label>
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="john.doe@company.com"
          className={inputClasses('email')}
        />
        {errors.email && (
          <p className="mt-1 text-xs text-red-500">{errors.email}</p>
        )}
      </div>

      {/* Department & Salary */}
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-5">
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1.5">
            Department <span className="text-red-400">*</span>
          </label>
          <select
            name="department"
            value={formData.department}
            onChange={handleChange}
            className={inputClasses('department')}
          >
            <option value="">Select Department</option>
            {departments.map((dept) => (
              <option key={dept} value={dept}>{dept}</option>
            ))}
          </select>
          {errors.department && (
            <p className="mt-1 text-xs text-red-500">{errors.department}</p>
          )}
        </div>
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1.5">
            Salary (USD) <span className="text-red-400">*</span>
          </label>
          <input
            type="number"
            name="salary"
            value={formData.salary}
            onChange={handleChange}
            placeholder="75000"
            min="0"
            step="1000"
            className={inputClasses('salary')}
          />
          {errors.salary && (
            <p className="mt-1 text-xs text-red-500">{errors.salary}</p>
          )}
        </div>
      </div>

      {/* Phone & Join Date */}
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-5">
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1.5">
            Phone Number
          </label>
          <input
            type="tel"
            name="phone"
            value={formData.phone}
            onChange={handleChange}
            placeholder="+1-555-0100"
            className={inputClasses('phone')}
          />
        </div>
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1.5">
            Join Date
          </label>
          <input
            type="date"
            name="joinDate"
            value={formData.joinDate}
            onChange={handleChange}
            className={inputClasses('joinDate')}
          />
        </div>
      </div>

      {/* Form Actions */}
      <div className="flex items-center justify-end gap-3 pt-4 border-t border-gray-100">
        <button
          type="button"
          onClick={() => navigate('/')}
          className="inline-flex items-center gap-2 px-5 py-2.5 text-sm font-medium rounded-xl
                     text-gray-700 bg-gray-100 hover:bg-gray-200 transition-colors cursor-pointer"
        >
          <HiArrowLeft />
          Cancel
        </button>
        <button
          type="submit"
          disabled={submitting}
          className="inline-flex items-center gap-2 px-6 py-2.5 text-sm font-medium rounded-xl
                     text-white bg-indigo-600 hover:bg-indigo-700 disabled:opacity-50
                     disabled:cursor-not-allowed transition-colors shadow-sm cursor-pointer"
        >
          <HiSave />
          {submitting ? 'Saving...' : isEdit ? 'Update Employee' : 'Add Employee'}
        </button>
      </div>
    </form>
  );
};

export default EmployeeForm;

