import { HiSearch, HiX } from 'react-icons/hi';

/**
 * SearchBar component - Controlled search input with clear button.
 * Props:
 *  - query: current search string
 *  - onQueryChange: callback when search text changes
 *  - onClear: callback to clear the search
 */
const SearchBar = ({ query, onQueryChange, onClear }) => {
  return (
    <div className="relative w-full max-w-md">
      <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
        <HiSearch className="text-gray-400 text-lg" />
      </div>
      <input
        type="text"
        value={query}
        onChange={(e) => onQueryChange(e.target.value)}
        placeholder="Search by name or department..."
        className="w-full pl-10 pr-10 py-2.5 bg-white border border-gray-200 rounded-xl
                   text-gray-700 placeholder-gray-400 text-sm
                   focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-transparent
                   shadow-sm transition-all"
      />
      {query && (
        <button
          onClick={onClear}
          className="absolute inset-y-0 right-0 pr-3 flex items-center
                     text-gray-400 hover:text-gray-600 transition-colors"
        >
          <HiX className="text-lg" />
        </button>
      )}
    </div>
  );
};

export default SearchBar;

