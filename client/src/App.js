import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import HomePage from './pages/HomePage';
import CatalogPage from './pages/CatalogPage';
import EquipmentDetailPage from './pages/EquipmentDetailPage';
import BookingPage from './pages/BookingPage';
import AdminDashboard from './pages/AdminDashboard';
import UserBookings from './pages/UserBookings';
import './assets/styles/global.css';

function App() {
    return (
        <Router>
            <Switch>
                <Route path="/" exact component={HomePage} />
                <Route path="/catalog" component={CatalogPage} />
                <Route path="/equipment/:id" component={EquipmentDetailPage} />
                <Route path="/booking" component={BookingPage} />
                <Route path="/admin" component={AdminDashboard} />
                <Route path="/user/bookings" component={UserBookings} />
            </Switch>
        </Router>
    );
}

export default App;