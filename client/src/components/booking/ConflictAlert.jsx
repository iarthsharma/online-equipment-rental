import React from 'react';

const ConflictAlert = ({ conflicts }) => {
    if (!conflicts || conflicts.length === 0) {
        return null;
    }

    return (
        <div className="conflict-alert">
            <h2>Booking Conflicts</h2>
            <ul>
                {conflicts.map((conflict, index) => (
                    <li key={index}>{conflict}</li>
                ))}
            </ul>
        </div>
    );
};

export default ConflictAlert;