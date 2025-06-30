export const calculateTotalAmount = (amount, taxRate) => {
    const taxAmount = amount * taxRate;
    return amount + taxAmount;
};

export const formatCurrency = (amount) => {
    return new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
    }).format(amount);
};

export const validatePaymentDetails = (paymentDetails) => {
    const { cardNumber, expirationDate, cvv } = paymentDetails;
    const isValidCardNumber = /^\d{16}$/.test(cardNumber);
    const isValidExpirationDate = /^\d{2}\/\d{2}$/.test(expirationDate);
    const isValidCvv = /^\d{3}$/.test(cvv);
    
    return isValidCardNumber && isValidExpirationDate && isValidCvv;
};