import { configureStore } from '@reduxjs/toolkit';
import bookingReducer from './slices/bookingSlice';
import catalogReducer from './slices/catalogSlice';

const store = configureStore({
  reducer: {
    booking: bookingReducer,
    catalog: catalogReducer,
  },
});

export default store;