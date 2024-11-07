
# **Cart & Checkout Service**

A Spring Boot application that provides shopping cart and checkout functionality using **MongoDB** for persistent data storage and **Redis** for fast, in-memory access. This service includes APIs for adding items to the cart, reviewing the cart, and finalizing the checkout process.

---

## **Features**

1. **Add to Cart**:
    - Users can add products to their cart.
    - Cart data is stored in **MongoDB** and cached in **Redis** for faster retrieval.

2. **Cart Review**:
    - Users can view the items in their cart, including:
        - Product name
        - Quantity
        - Price
        - Total cost of the cart

3. **Checkout**:
    - Users can finalize their purchase by:
        - Confirming their cart contents
        - Specifying a delivery address
        - Choosing a payment method
    - Upon successful checkout, the cart is cleared.

---

## **Tech Stack**

- **Java 17**
- **Spring Boot 3.x**
    - Spring Data MongoDB
    - Spring Data Redis
    - Spring Web
- **MongoDB** (for cart persistence)
- **Redis** (for fast, in-memory caching)
- **Maven** (for dependency management)

---

## **API Endpoints**

### **Cart APIs**

#### 1. Add to Cart
**Endpoint**:  
`POST /cart/{userId}/add`

**Description**:  
Adds an item to the user's cart.

**Request Body**:
```json
{
  "productId": "123",
  "productName": "Laptop",
  "quantity": 1,
  "price": 1000.0
}
```

**Response**:
- `200 OK` if the item is added successfully.

---

#### 2. View Cart
**Endpoint**:  
`GET /cart/{userId}`

**Description**:  
Fetches the user's cart details.

**Response**:
```json
{
  "userId": "user123",
  "items": [
    {
      "productId": "123",
      "productName": "Laptop",
      "quantity": 1,
      "price": 1000.0
    }
  ],
  "total": 1000.0
}
```

---

### **Checkout APIs**

#### 1. Checkout
**Endpoint**:  
`POST /checkout/{userId}`

**Description**:  
Finalizes the user's purchase and clears the cart.

**Query Parameters**:
- `deliveryAddress`: The delivery address for the order.
- `paymentMethod`: The chosen payment method.

**Example Request**:  
`POST /checkout/user123?deliveryAddress=123 Main St&paymentMethod=CreditCard`

**Response**:
```json
{
  "orderId": "order123",
  "userId": "user123",
  "items": [
    {
      "productId": "123",
      "productName": "Laptop",
      "quantity": 1,
      "price": 1000.0
    }
  ],
  "deliveryAddress": "123 Main St",
  "paymentMethod": "CreditCard",
  "total": 1000.0
}
```

---

## **Setup Instructions**

### Prerequisites
- **Java 17**
- **MongoDB** (e.g., MongoDB Atlas or a local MongoDB server)
- **Redis** (e.g., local Redis server)

### Clone the Repository
```bash
git clone https://github.com/your-repo/cart-checkout-service.git
cd cart-checkout-service
```

### Configure the Application

1. **MongoDB Configuration**:  
   Update the connection URI in `application.yml`:
   ```yaml
   spring:
     data:
       mongodb:
         uri: mongodb+srv://<username>:<password>@cluster0.mongodb.net/<database>?retryWrites=true&w=majority
   ```

2. **Redis Configuration**:  
   Update the Redis host and port in `application.yml`:
   ```yaml
   spring:
     redis:
       host: localhost
       port: 6379
   ```

### Build and Run

1. **Build the application**:
   ```bash
   mvn clean install
   ```

2. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

---

## **Testing the APIs**

You can use tools like **Postman**, **cURL**, or a similar API client to test the endpoints.

---

## **Future Improvements**

- Add authentication and authorization for secure API access.
- Implement email or SMS notifications upon successful checkout.
- Enable coupon code support for discounts.
- Introduce a payment gateway integration for real-time payments.

---
