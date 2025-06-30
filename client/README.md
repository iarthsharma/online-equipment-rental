# Project Title

This project is a React application designed for managing equipment bookings. It provides a user-friendly interface for browsing equipment, making bookings, and managing administrative tasks.

## Project Structure

The project is organized into the following main directories:

- **public/**: Contains static files such as the main HTML file, favicon, and manifest.
- **src/**: Contains the source code for the application, including components, pages, services, and styles.
  - **assets/**: Contains stylesheets for global and theme-specific styles.
  - **components/**: Contains reusable React components organized by functionality (catalog, booking, admin, common).
  - **pages/**: Contains components that represent different pages of the application.
  - **services/**: Contains API service files for handling data fetching and business logic.
  - **store/**: Contains Redux store configuration and slices for state management.
  - **utils/**: Contains utility functions for various operations.

## Installation

To get started with the project, clone the repository and install the dependencies:

```bash
git clone <repository-url>
cd client
npm install
```

## Usage

To run the application in development mode, use the following command:

```bash
npm start
```

This will start the development server and open the application in your default web browser.

## Features

- Browse and filter equipment in the catalog.
- Make bookings with a date picker and deposit calculator.
- Admin dashboard for managing equipment and approvals.
- User notifications for booking status and alerts.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.