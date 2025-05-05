# Inventory Management System

This is an Inventory Management System built with Spring Boot, designed to help users efficiently manage product and supplier information. The system supports functionalities such as adding new products, querying existing products, updating inventory upon shipping, and managing suppliers. Additionally, it includes error handling to ensure smooth operations and meaningful feedback.

## Features

### Product Management
- **Query Products**: 
  - Retrieve details of a specific product by its ID.
  - View a list of all products in the inventory.
  
- **Add Products**:
  - Add a single product to the inventory.
  - Add multiple products at once by sending a list.

- **Ship Products**:
  - Update the stock quantity of a product when it is shipped.
  - Ensure that sufficient inventory is available before shipping.

- **Update Products**:
  - Modify product details such as name, quantity, and price.

- **Delete Products**:
  - Remove a product from the inventory by specifying its ID.

### Supplier Management
- **Query Suppliers**:
  - Retrieve details of a specific supplier by its ID.
  - View a list of all suppliers.

- **Add Suppliers**:
  - Add a single supplier.
  - Add multiple suppliers at once by sending a list.

- **Update Suppliers**:
  - Modify supplier details such as name, email, and contact information.

- **Delete Suppliers**:
  - Remove a supplier by specifying its ID.

### Combined Supplier-Product Management
- **Add Supplier with Products**:
  - Add a supplier along with one or more products in a single request.

- **Query Products by Supplier**:
  - Retrieve all products associated with a specific supplier.

- **Query All Supplier-Product Relationships**:
  - View all suppliers and their associated products.

### Exception Handling
- Handles common exceptions like invalid input or entity not found, and provides meaningful error messages.

## Technologies Used

- **Spring Boot**: For building the backend and RESTful APIs.
- **Spring Data JPA**: For database interaction.
- **MySQL**: For storing product and supplier data.
- **Lombok**: For reducing boilerplate code.
- **Jakarta Validation**: For validating input data.

## API Endpoints

### Product Endpoints
- `GET /products/{id}`: Get a product by its ID.
- `GET /products`: Get a list of all products.
- `POST /products`: Add a new product.
- `POST /products/addList`: Add multiple products.
- `PUT /products/{id}/ship/{quantity}`: Ship a product by specifying its ID and the quantity to ship.
- `PUT /products/{id}`: Update product details.
- `DELETE /products/{id}`: Delete a product by its ID.

### Supplier Endpoints
- `GET /suppliers/{id}`: Get a supplier by its ID.
- `GET /suppliers`: Get a list of all suppliers.
- `POST /suppliers`: Add a new supplier.
- `POST /suppliers/addList`: Add multiple suppliers.
- `PUT /suppliers/{id}`: Update supplier details.
- `DELETE /suppliers/{id}`: Delete a supplier by its ID.

### Supplier-Product Endpoints
- `POST /supplier-product/add`: Add a supplier with a single product.
- `POST /supplier-product/addList`: Add a supplier with multiple products.
- `GET /supplier-product/{supplierId}/products`: Get all products associated with a specific supplier.
- `GET /supplier-product/all`: Get all suppliers and their associated products.

## Error Handling

- **400 Bad Request**: Returned when there is an issue with the input (e.g., invalid product or supplier data).
- **404 Not Found**: Returned when a requested entity (e.g., product or supplier) is not found.
- **500 Internal Server Error**: Returned for unexpected errors.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
