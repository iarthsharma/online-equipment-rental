import React from 'react';
import PropTypes from 'prop-types';
import './styles.css'; // Assuming you have some styles for the EquipmentCard

const EquipmentCard = ({ equipment }) => {
    return (
        <div className="equipment-card">
            <img src={equipment.imageUrl} alt={equipment.name} className="equipment-image" />
            <h3 className="equipment-name">{equipment.name}</h3>
            <p className="equipment-description">{equipment.description}</p>
            <p className="equipment-price">${equipment.price}</p>
            <button className="equipment-button">View Details</button>
        </div>
    );
};

EquipmentCard.propTypes = {
    equipment: PropTypes.shape({
        imageUrl: PropTypes.string.isRequired,
        name: PropTypes.string.isRequired,
        description: PropTypes.string.isRequired,
        price: PropTypes.number.isRequired,
    }).isRequired,
};

export default EquipmentCard;