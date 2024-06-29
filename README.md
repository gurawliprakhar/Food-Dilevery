
# Food Delivery App

This is a Food Delivery Application developed using Spring Boot for the backend and React for the frontend. The application facilitates food ordering, user authentication, and management of food items, categories, orders, and restaurants.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features

- User Authentication and Authorization (JWT based)
- Admin and User roles with role-based access control
- Food item management
- Category management
- Cart management
- Order processing
- Restaurant management

## Technologies Used

### Backend

- Java
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- JWT for security
- Maven

### Frontend

- React
- Axios for HTTP requests
- Redux for state management

## Project Structure

### Backend

```
src
├── main
│   ├── java
│   │   └── com.velamdir
│   │       ├── config
│   │       │   ├── AppConfig.java
│   │       │   ├── JwtConstant.java
│   │       │   ├── JwtProvider.java
│   │       │   └── JwtTokenValidator.java
│   │       ├── controller
│   │       │   ├── AdminFoodController.java
│   │       │   ├── AdminOrderController.java
│   │       │   ├── AdminRestaurantController.java
│   │       │   ├── AuthController.java
│   │       │   ├── CartController.java
│   │       │   ├── CategoryController.java
│   │       │   ├── FoodController.java
│   │       │   ├── HomeController.java
│   │       │   ├── IngredientController.java
│   │       │   ├── OrderController.java
│   │       │   ├── RestaurantController.java
│   │       │   └── UserController.java
│   │       ├── DTO
│   │       │   └── RestaurantDto.java
│   │       ├── model
│   │       │   ├── Address.java
│   │       │   ├── Cart.java
│   │       │   ├── CartItem.java
│   │       │   ├── Category.java
│   │       │   ├── ContactInformation.java
│   │       │   ├── Food.java
│   │       │   ├── IngredientItem.java
│   │       │   ├── IngredientCategory.java
│   │       │   ├── Order.java
│   │       │   ├── OrderItem.java
│   │       │   ├── Restaurant.java
│   │       │   ├── User.java
│   │       │   └── USER_ROLE.java
│   │       ├── repository
│   │       │   ├── AddressRepository.java
│   │       │   ├── CartItemRepository.java
│   │       │   ├── CartRepository.java
│   │       │   ├── CategoryRepository.java
│   │       │   ├── FoodRepository.java
│   │       │   ├── IngredientCategoryRepository.java
│   │       │   ├── IngredientItemRepository.java
│   │       │   ├── OrderItemRepository.java
│   │       │   ├── OrderRepository.java
│   │       │   ├── RestaurantRepository.java
│   │       │   └── UserRepository.java
│   │       ├── request
│   │       │   ├── AddCartItemRequest.java
│   │       │   ├── CreateRestaurantRequest.java
│   │       │   ├── CreateFoodRequest.java
│   │       │   ├── IngredientCategoryRequest.java
│   │       │   ├── IngredientRequest.java
│   │       │   ├── LoginRequest.java
│   │       │   └── UpdateCartItemRequest.java
│   │       ├── response
│   │       │   ├── AuthResponse.java
│   │       │   └── MessageResponse.java
│   │       └── service
│   │           ├── CartService.java
│   │           ├── CartServiceImpl.java
│   │           ├── CategoryService.java
│   │           ├── CategoryServiceImpl.java
│   │           ├── CustomerUserDetailsService.java
│   │           ├── FoodService.java
│   │           ├── FoodServiceImpl.java
│   │           ├── IngredientService.java
│   │           ├── IngredientServiceImpl.java
│   │           ├── OrderService.java
│   │           ├── OrderServiceImpl.java
│   │           ├── RestaurantService.java
│   │           ├── RestaurantServiceImpl.java
│   │           └── UserService.java
│   │           └── UserServiceImpl.java
│   │           └── OnlineFoodOrderingAppliaction.java
│   └── resources
│       └── application.properties
```

### Frontend

The frontend React application should follow a standard structure with components, services for API calls, and Redux for state management.

```
frontend/
├── node_modules/
├── public/
│   ├── favicon.ico
│   ├── index.html
│   ├── logo192.png
│   ├── logo512.png
│   ├── manifest.json
│   └── robots.txt
└── src/
    ├── component/
    │   └── Cart/
    │       └── AddressCard.jsx
    │       └── Cart.jsx
    │       └── CartItem.jsx
    │   └── Home/
    │       └── Home.js
    │       └── Home.css
    │       └── Carasoul.jsx
    │       └── topMeel.js
    │       └── MutiItemCarasoul.jsx
    │   └── Navbar/
    │       └── Navbar.js
    │       └── Navbar.css
    │   └── Profile/
    │       └── Favorites.jsx
    │       └── Address.jsx
    │       └── Event.jsx
    │       └── Order.jsx
    │       └── UserProfile.jsx
    │       └── Profile.jsx
    │       └── ProfileNavigation.jsx
    │   └── Restaurant/
    │       └── RestaurantCard.jsx
    │       └── RestaurantDetails.jsx
    │       └── ManuCard.jsx
    ├── Routers/
    │       └── CustomerRouter.jsx
    ├── Theme/
    │   └── DarkTheme.js
    ├── App.css
    ├── App.js
    ├── App.test.js
    ├── index.css
    ├── index.js
    ├── logo.SVG
    ├── reportWebVitals.js
    └── setupTests.js

```

## Installation

### Backend

1. Clone the repository:
    ```sh
    git clone <repository-url>
    ```
2. Navigate to the backend directory:
    ```sh
    cd backend
    ```
3. Build the project using Maven:
    ```sh
    mvn clean install
    ```
4. Run the Spring Boot application:
    ```sh
    mvn spring-boot:run
    ```

### Frontend

1. Navigate to the frontend directory:
    ```sh
    cd frontend
    ```
2. Install the dependencies:
    ```sh
    npm install
    ```
3. Start the React application:
    ```sh
    npm start
    ```

## Usage

1. Open your browser and navigate to `http://localhost:3000` to access the frontend.
2. Use the available features to register, log in, browse food items, manage the cart, and place orders.

## API Endpoints

### Authentication
- `POST /api/auth/login`: User login
- `POST /api/auth/register`: User registration

### Food
- `GET /api/food`: Get all food items
- `POST /api/admin/food`: Create a new food item (Admin)
- `PUT /api/admin/food/{id}`: Update a food item (Admin)
- `DELETE /api/admin/food/{id}`: Delete a food item (Admin)

### Categories
- `GET /api/categories`: Get all categories
- `POST /api/admin/categories`: Create a new category (Admin)
- `PUT /api/admin/categories/{id}`: Update a category (Admin)
- `DELETE /api/admin/categories/{id}`: Delete a category (Admin)

### Cart
- `GET /api/cart`: Get cart items
- `POST /api/cart`: Add item to cart
- `PUT /api/cart`: Update cart item
- `DELETE /api/cart/{id}`: Remove item from cart

### Orders
- `GET /api/orders`: Get all orders
- `POST /api/orders`: Create a new order
- `GET /api/orders/{id}`: Get order details

### Restaurants
- `GET /api/restaurants`: Get all restaurants
- `POST /api/admin/restaurants`: Create a new restaurant (Admin)
- `PUT /api/admin/restaurants/{id}`: Update a restaurant (Admin)
- `DELETE /api/admin/restaurants/{id}`: Delete a restaurant (Admin)

## Contributing

1. Fork the repository.
2. Create your feature branch:
    ```sh
    git checkout -b feature/your-feature
    ```
3. Commit your changes:
    ```sh
    git commit -m 'Add some feature'
    ```
4. Push to the branch:
    ```sh
    git push origin feature/your-feature
    ```
5. Open a pull request.


Feel free to contribute to the project by submitting pull requests or reporting issues. Your feedback and suggestions are highly appreciated!
