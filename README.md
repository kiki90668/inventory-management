# Inventory Management System

This is an Inventory Management System built with Spring Boot, designed to help users efficiently manage product information. The system supports functionalities such as adding new products, querying existing products, updating inventory upon shipping, and deleting products. Additionally, it includes error handling to ensure smooth operations and meaningful feedback.

## Features

- **Query Products**: 
  - Retrieve details of a specific product by its ID.
  - View a list of all products in the inventory.
  
- **Add Products**:
  - Add a single product to the inventory.
  - Add multiple products at once by sending a list.

- **Ship Products**:
  - Update the stock quantity of a product when it is shipped.
  - Ensure that sufficient inventory is available before shipping.

- **Delete Products**:
  - Remove a product from the inventory by specifying its ID.

- **Exception Handling**:
  - Handles common exceptions like invalid input or product not found, and provides meaningful error messages.
 
=========================================================

## Technologies Used

- **Spring Boot**: For building the backend and RESTful APIs.
- **Spring Data JPA**: For database interaction.
- **MySQL**: For storing product data.
- **Lombok**: For reducing boilerplate code.

=========================================================

## API Endpoints
GET /products/{id}: Get a product by its ID.

GET /products: Get a list of all products.

POST /products/add: Add a new product.

POST /products/addList: Add multiple products.

PUT /products/{id}/ship/{quantity}: Ship a product by specifying its ID and the quantity to ship.

DELETE /products/{id}: Delete a product by its ID.

=========================================================

## Error Handling
400 Bad Request: Returned when there is an issue with the input (e.g., invalid product ID or quantity).

500 Internal Server Error: Returned for unexpected errors.

Contribution
Feel free to fork the repository, make changes, and submit pull requests. Contributions are welcome!
