import React, { useState } from 'react';

const SearchFilter = ({ onFilterChange }) => {
    const [searchTerm, setSearchTerm] = useState('');

    const handleInputChange = (event) => {
        const value = event.target.value;
        setSearchTerm(value);
        onFilterChange(value);
    };

    return (
        <div className="search-filter">
            <input
                type="text"
                placeholder="Search equipment..."
                value={searchTerm}
                onChange={handleInputChange}
            />
        </div>
    );
};

export default SearchFilter;