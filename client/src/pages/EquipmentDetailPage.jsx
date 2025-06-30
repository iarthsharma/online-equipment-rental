import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getEquipmentDetails } from '../services/catalogService';
import EquipmentCard from '../components/catalog/EquipmentCard';

const EquipmentDetailPage = () => {
    const { id } = useParams();
    const [equipment, setEquipment] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchEquipmentDetails = async () => {
            try {
                const data = await getEquipmentDetails(id);
                setEquipment(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        fetchEquipmentDetails();
    }, [id]);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            {equipment ? (
                <EquipmentCard equipment={equipment} />
            ) : (
                <div>No equipment found.</div>
            )}
        </div>
    );
};

export default EquipmentDetailPage;