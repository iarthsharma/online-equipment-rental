import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchUserBookings } from '../store/slices/bookingSlice';
import BookingCard from '../components/booking/BookingCard';

const UserBookings = () => {
    const dispatch = useDispatch();
    const bookings = useSelector((state) => state.booking.bookings);
    const loading = useSelector((state) => state.booking.loading);
    const error = useSelector((state) => state.booking.error);

    useEffect(() => {
        dispatch(fetchUserBookings());
    }, [dispatch]);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h1>Your Bookings</h1>
            {bookings.length === 0 ? (
                <p>No bookings found.</p>
            ) : (
                bookings.map((booking) => (
                    <BookingCard key={booking.id} booking={booking} />
                ))
            )}
        </div>
    );
};

export default UserBookings;