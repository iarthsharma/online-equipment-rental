import api from './api';

const catalogService = {
    getAllEquipment: async () => {
        try {
            const response = await api.get('/equipment');
            return response.data;
        } catch (error) {
            throw new Error('Error fetching equipment: ' + error.message);
        }
    },

    getEquipmentById: async (id) => {
        try {
            const response = await api.get(`/equipment/${id}`);
            return response.data;
        } catch (error) {
            throw new Error('Error fetching equipment: ' + error.message);
        }
    },

    searchEquipment: async (query) => {
        try {
            const response = await api.get('/equipment/search', { params: { query } });
            return response.data;
        } catch (error) {
            throw new Error('Error searching equipment: ' + error.message);
        }
    },

    addEquipment: async (equipmentData) => {
        try {
            const response = await api.post('/equipment', equipmentData);
            return response.data;
        } catch (error) {
            throw new Error('Error adding equipment: ' + error.message);
        }
    },

    updateEquipment: async (id, equipmentData) => {
        try {
            const response = await api.put(`/equipment/${id}`, equipmentData);
            return response.data;
        } catch (error) {
            throw new Error('Error updating equipment: ' + error.message);
        }
    },

    deleteEquipment: async (id) => {
        try {
            const response = await api.delete(`/equipment/${id}`);
            return response.data;
        } catch (error) {
            throw new Error('Error deleting equipment: ' + error.message);
        }
    }
};

export default catalogService;