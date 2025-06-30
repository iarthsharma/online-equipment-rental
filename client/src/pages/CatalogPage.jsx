import React, { useEffect, useState } from 'react';
import { fetchCatalogItems } from '../services/catalogService';
import EquipmentCard from '../components/catalog/EquipmentCard';
import SearchFilter from '../components/catalog/SearchFilter';

const CatalogPage = () => {
    const [items, setItems] = useState([]);
    const [filteredItems, setFilteredItems] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const loadCatalogItems = async () => {
            const data = await fetchCatalogItems();
            setItems(data);
            setFilteredItems(data);
            setLoading(false);
        };

        loadCatalogItems();
    }, []);

    const handleFilterChange = (filters) => {
        const filtered = items.filter(item => {
            // Apply filtering logic based on filters
            return Object.keys(filters).every(key => 
                item[key].toString().toLowerCase().includes(filters[key].toLowerCase())
            );
        });
        setFilteredItems(filtered);
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h1>Equipment Catalog</h1>
            <SearchFilter onFilterChange={handleFilterChange} />
            <div className="catalog-grid">
                {filteredItems.map(item => (
                    <EquipmentCard key={item.id} item={item} />
                ))}
            </div>
        </div>
    );
};

export default CatalogPage;