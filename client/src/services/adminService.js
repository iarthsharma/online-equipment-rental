import api from './api';

export const fetchApprovalQueue = async () => {
    try {
        const response = await api.get('/admin/approval-queue');
        return response.data;
    } catch (error) {
        throw new Error('Error fetching approval queue: ' + error.message);
    }
};

export const approveItem = async (itemId) => {
    try {
        const response = await api.post(`/admin/approve/${itemId}`);
        return response.data;
    } catch (error) {
        throw new Error('Error approving item: ' + error.message);
    }
};

export const rejectItem = async (itemId) => {
    try {
        const response = await api.post(`/admin/reject/${itemId}`);
        return response.data;
    } catch (error) {
        throw new Error('Error rejecting item: ' + error.message);
    }
};

export const updateEquipment = async (equipmentId, equipmentData) => {
    try {
        const response = await api.put(`/admin/equipment/${equipmentId}`, equipmentData);
        return response.data;
    } catch (error) {
        throw new Error('Error updating equipment: ' + error.message);
    }
};