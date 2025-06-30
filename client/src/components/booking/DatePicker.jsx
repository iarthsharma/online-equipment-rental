import React, { useState } from 'react';
import { DatePicker as AntDatePicker } from 'antd';
import 'antd/dist/antd.css';

const DatePicker = ({ onDateChange }) => {
    const [selectedDate, setSelectedDate] = useState(null);

    const handleChange = (date, dateString) => {
        setSelectedDate(date);
        onDateChange(dateString);
    };

    return (
        <div className="date-picker">
            <AntDatePicker 
                onChange={handleChange} 
                value={selectedDate} 
                format="YYYY-MM-DD" 
            />
        </div>
    );
};

export default DatePicker;