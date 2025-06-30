const { MongoClient } = require('mongodb');
const uri = process.env.MONGODB_URI; // MongoDB connection string from environment variables

async function initDB() {
    const client = new MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });

    try {
        await client.connect();
        const database = client.db(process.env.DB_NAME); // Database name from environment variables

        // Create collections
        const usersCollection = database.collection('users');
        const productsCollection = database.collection('products');

        // Create indexes
        await usersCollection.createIndex({ email: 1 }, { unique: true });
        await productsCollection.createIndex({ name: 1 });

        console.log('Database initialized successfully.');
    } catch (error) {
        console.error('Error initializing the database:', error);
    } finally {
        await client.close();
    }
}

initDB();