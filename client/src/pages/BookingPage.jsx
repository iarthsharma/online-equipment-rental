import React from 'react';
import DatePicker from '../components/booking/DatePicker';
import DepositCalculator from '../components/booking/DepositCalculator';
import ConflictAlert from '../components/booking/ConflictAlert';

const BookingPage = () => {
    return (
        <div>
            <h1>Booking Page</h1>
            <DatePicker />
            <DepositCalculator />
            <ConflictAlert />
        </div>
    );
};

export default BookingPage;