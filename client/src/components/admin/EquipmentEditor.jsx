import React, { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchEquipment, updateEquipment } from '../../services/adminService';
import { selectEquipment } from '../../store/slices/catalogSlice';

const EquipmentEditor = ({ equipmentId }) => {
    const dispatch = useDispatch();
    const equipment = useSelector(selectEquipment(equipmentId));
    const [formData, setFormData] = useState({
        name: '',
        description: '',
        price: '',
        quantity: ''
    });

    useEffect(() => {
        if (equipment) {
            setFormData({
                name: equipment.name,
                description: equipment.description,
                price: equipment.price,
                quantity: equipment.quantity
            });
        }
    }, [equipment]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        dispatch(updateEquipment(equipmentId, formData));
    };

    return (
        <div>
            <h2>Edit Equipment</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Name:</label>
                    <input
                        type="text"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Description:</label>
                    <textarea
                        name="description"
                        value={formData.description}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Price:</label>
                    <input
                        type="number"
                        name="price"
                        value={formData.price}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Quantity:</label>
                    <input
                        type="number"
                        name="quantity"
                        value={formData.quantity}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit">Update Equipment</button>
            </form>
        </div>
    );
};

export default EquipmentEditor;