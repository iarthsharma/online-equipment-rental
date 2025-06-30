import React from 'react';

const Notification = ({ message, type }) => {
    if (!message) return null;

    const notificationClass = `notification ${type}`;

    return (
        <div className={notificationClass}>
            {message}
        </div>
    );
};

export default Notification;