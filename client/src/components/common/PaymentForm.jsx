import React, { useState } from 'react';

const PaymentForm = ({ onSubmit }) => {
    const [amount, setAmount] = useState('');
    const [cardNumber, setCardNumber] = useState('');
    const [expiryDate, setExpiryDate] = useState('');
    const [cvv, setCvv] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!amount || !cardNumber || !expiryDate || !cvv) {
            setError('All fields are required');
            return;
        }
        setError('');
        onSubmit({ amount, cardNumber, expiryDate, cvv });
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Payment Form</h2>
            {error && <p className="error">{error}</p>}
            <div>
                <label>Amount:</label>
                <input
                    type="text"
                    value={amount}
                    onChange={(e) => setAmount(e.target.value)}
                />
            </div>
            <div>
                <label>Card Number:</label>
                <input
                    type="text"
                    value={cardNumber}
                    onChange={(e) => setCardNumber(e.target.value)}
                />
            </div>
            <div>
                <label>Expiry Date:</label>
                <input
                    type="text"
                    placeholder="MM/YY"
                    value={expiryDate}
                    onChange={(e) => setExpiryDate(e.target.value)}
                />
            </div>
            <div>
                <label>CVV:</label>
                <input
                    type="text"
                    value={cvv}
                    onChange={(e) => setCvv(e.target.value)}
                />
            </div>
            <button type="submit">Submit Payment</button>
        </form>
    );
};

export default PaymentForm;