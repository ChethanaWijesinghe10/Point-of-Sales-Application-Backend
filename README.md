#Point of Sales (POS) Application Backend
This is a Spring Boot-based backend application designed for a Point of Sales (POS) system. It manages customers, items, and orders, and provides comprehensive RESTful APIs for frontend integration.

#Features
- Manage Customers: Add, update, delete, and retrieve customer details.
- Manage Items: Add, and retrieve item details.
- Manage Orders: Create, and retrieve orders.
- RESTful API: Well-documented endpoints for frontend integration.
- Data Validation: Ensures data integrity through input validation.
- Pagination: Efficiently handles large datasets by implementing pagination in API responses.
- Model Mapping: Uses ModelMapper and MapStruct for easy conversion between DTOs and entities.

 #Technologies Used
- Java 17.0.5
- Spring Boot 
- Spring Data JPA
- Hibernate
- MySQL (as the relational database)
- RESTful APIs
- Maven (for project build and dependency management)
- ModelMapper (for flexible object mapping)
- MapStruct (for compile-time mapping between DTOs and entities)
- Pagination (for handling large datasets efficiently)

#Getting Started
Prerequisites
- Java 11 or higher
- Maven
- MySQL Database

#Installation

1. Clone the repository:
   bash
   git clone https://github.com/your-username/Point-of-Sales-Application-Backend.git
   cd Point-of-Sales-Application-Backend
   
#Configure the Database:
2. Install and run MySQL server.
Create a new database (e.g., pos_system).
Update the database settings in src/main/resources/application.properties or application.yml:
        spring.datasource.url=jdbc:mysql://localhost:3306/pos_system
        spring.datasource.username=your-username
        spring.datasource.password=your-password
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   
3. Run the Application:
     mvn spring-boot:run

HTTP Method	Endpoint	        Description	                Pagination Parameters
GET	        /api/customers	        Retrieve all customers	        page, size
GET	        /api/customers/{id}	Retrieve customer by ID	
POST	        /api/customers	        Create a new customer	
PUT	        /api/customers/{id}	Update customer by ID	
DELETE	        /api/customers/{id}	Delete customer by ID	

4. Pagination
API endpoints that return large datasets support pagination. You can use the following query parameters:
        page: The page number (starting from 0).
        size: The number of records per page.
        sort: The field by which to sort the results (e.g., name,asc).
5. Model Mapping
The project utilizes two popular model mapping libraries:
        ModelMapper: Used for dynamic and flexible object mapping, especially when runtime mapping configurations are required.
        MapStruct: Employed for compile-time mapping between DTOs and entities, providing high performance and type safety.

#Contact
For any questions or support, please contact chethanawijesinghe10@gmail.com

#Acknowledgments
Thanks to the Spring community for providing excellent documentation.
Credits to the developers of ModelMapper and MapStruct for efficient object mapping.
