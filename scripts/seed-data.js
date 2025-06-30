const { MongoClient } = require('mongodb');

// Database connection URL and options
const url = process.env.MONGODB_URI || 'mongodb://localhost:27017';
const dbName = 'myDatabase'; // Change this to your database name

async function seedDatabase() {
    const client = new MongoClient(url, { useNewUrlParser: true, useUnifiedTopology: true });

    try {
        // Connect to the MongoDB server
        await client.connect();
        console.log('Connected to the database');

        const db = client.db(dbName);

        // Sample data to insert
        const sampleData = [
            { name: 'Sample Item 1', description: 'This is a sample item', price: 10.99 },
            { name: 'Sample Item 2', description: 'This is another sample item', price: 15.99 },
            { name: 'Sample Item 3', description: 'Yet another sample item', price: 20.99 },
        ];

        // Insert sample data into a collection
        const result = await db.collection('items').insertMany(sampleData);
        console.log(`${result.insertedCount} documents were inserted`);

    } catch (error) {
        console.error('Error seeding the database:', error);
    } finally {
        // Close the database connection
        await client.close();
    }
}

// Run the seed function
seedDatabase();