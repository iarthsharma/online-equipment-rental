import React from 'react';
import ApprovalQueue from '../components/admin/ApprovalQueue';
import EquipmentEditor from '../components/admin/EquipmentEditor';

const AdminDashboard = () => {
    return (
        <div>
            <h1>Admin Dashboard</h1>
            <ApprovalQueue />
            <EquipmentEditor />
        </div>
    );
};

export default AdminDashboard;