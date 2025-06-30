import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    items: [],
    loading: false,
    error: null,
};

const catalogSlice = createSlice({
    name: 'catalog',
    initialState,
    reducers: {
        fetchCatalogStart(state) {
            state.loading = true;
            state.error = null;
        },
        fetchCatalogSuccess(state, action) {
            state.loading = false;
            state.items = action.payload;
        },
        fetchCatalogFailure(state, action) {
            state.loading = false;
            state.error = action.payload;
        },
        addItem(state, action) {
            state.items.push(action.payload);
        },
        removeItem(state, action) {
            state.items = state.items.filter(item => item.id !== action.payload);
        },
    },
});

export const {
    fetchCatalogStart,
    fetchCatalogSuccess,
    fetchCatalogFailure,
    addItem,
    removeItem,
} = catalogSlice.actions;

export default catalogSlice.reducer;