# E-Commerce Microservice Application

Microservices that can be designed as part of a large e-commerce application:
1. Product Catalog Service
2. Inventory Service
3. Order Service

## Product Catalog Service

Service manages the product information. Reponsibilities:
- Product CRUD operations
- Categories and Tags
- Pricing Information
- Search Filters

## Inventory Service

Servcie that manages the stock level of each product. Responsibilities:
- Manage stock avaialbility
- Reserve and Release stock
- Stock updates after purchase
- Low stock alerts

## Order Service

Manages the orders placed by the users. Responsibilities:
- Create Order
- Manage Order Status (CREATED, PLACED, SHIPPED, DELIVERED, CANCELLED)
- Manager Order history
- Coordinate with inventory, payment and shipping services
