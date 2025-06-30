import React, { useEffect, useState } from 'react';
import { fetchApprovalQueue } from '../../services/adminService';

const ApprovalQueue = () => {
    const [items, setItems] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const loadApprovalQueue = async () => {
            try {
                const data = await fetchApprovalQueue();
                setItems(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        loadApprovalQueue();
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h2>Approval Queue</h2>
            {items.length === 0 ? (
                <p>No items awaiting approval.</p>
            ) : (
                <ul>
                    {items.map(item => (
                        <li key={item.id}>
                            {item.name} - {item.status}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default ApprovalQueue;