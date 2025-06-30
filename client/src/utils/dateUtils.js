const formatDate = (date) => {
    const options = { year: 'numeric', month: '2-digit', day: '2-digit' };
    return new Intl.DateTimeFormat('en-US', options).format(date);
};

const parseDate = (dateString) => {
    const parts = dateString.split('/');
    return new Date(parts[2], parts[0] - 1, parts[1]);
};

const isDateInRange = (date, startDate, endDate) => {
    return date >= startDate && date <= endDate;
};

export { formatDate, parseDate, isDateInRange };