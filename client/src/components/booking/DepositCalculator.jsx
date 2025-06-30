import React, { useState } from 'react';

const DepositCalculator = () => {
    const [totalAmount, setTotalAmount] = useState(0);
    const [depositPercentage, setDepositPercentage] = useState(0);
    const [depositAmount, setDepositAmount] = useState(0);

    const calculateDeposit = () => {
        const deposit = (totalAmount * depositPercentage) / 100;
        setDepositAmount(deposit);
    };

    return (
        <div className="deposit-calculator">
            <h2>Deposit Calculator</h2>
            <div>
                <label>Total Amount: </label>
                <input
                    type="number"
                    value={totalAmount}
                    onChange={(e) => setTotalAmount(e.target.value)}
                />
            </div>
            <div>
                <label>Deposit Percentage: </label>
                <input
                    type="number"
                    value={depositPercentage}
                    onChange={(e) => setDepositPercentage(e.target.value)}
                />
            </div>
            <button onClick={calculateDeposit}>Calculate Deposit</button>
            <div>
                <h3>Deposit Amount: ${depositAmount.toFixed(2)}</h3>
            </div>
        </div>
    );
};

export default DepositCalculator;