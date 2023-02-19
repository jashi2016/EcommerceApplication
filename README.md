# EcommerceApplication


EcommerceController
It has all the endpoints for 
1. Creating users,products,addresses, orders
2. Get users,products,addresses, orders by their id
3. Delete Prodcuts using its id.
4. Get List of products with category as query param



EcommerceInt
This interface all the abstract methods for this application



EcommerceIntImpl
It is the service layer which provides implemenataion for all methods in the EcommerceInt interface.



Method:1
User saveUser(User user)
.Saves user details in user repository.
api-url: "localhost:8080/ecommerce/users" and pass user details as requestBody



Method:2
Address saveAddress(Address address)
.Saves address details in address repository.
api-url: "localhost:8080/ecommerce/address" and pass address details as requestBody




Method:3
Product saveProduct(Product product)
.Saves product details in product repository.
api-url: "localhost:8080/ecommerce/products" and pass product details as requestBody

Method:4
Order createOrder(Order order)
.Saves order details in order repository.
api-url: "localhost:8080/ecommerce/orders" and pass order details as requestBody



Method:5
User getUserById(Integer id)
.get user details from user repository using id.
api-url: "localhost:8080/ecommerce/user/{<userID>}" and pass user id as path variable



Method:6
Product getProductById(Integer id)
.get product details from product repository using id.
api-url: "localhost:8080/ecommerce/product/{<productID>}" and pass product id as path variable



Method:7
Address getAddressById(Integer id)
.get address details from address repository using id.
api-url: "localhost:8080/ecommerce/address/{<addressID>}" and pass address id as path variable



Method:8
Order getOrderById(Integer id)
.get order details from order repository using id.
api-url: "localhost:8080/ecommerce/order/{<orderID>}" and pass order id as path variable



Method:9
List<Product> getAllProductsByCategory(String category)
.get product details as list from prodiuct repository using category.
api-url: "localhost:8080/ecommerce/products/getAll?category=<category name>" and pass categor name as requestparam




Method:10
Product deleteProductById(Integer id)
.delete product details from product repository using id.
api-url: "localhost:8080/ecommerce/products/delete/{<productID>}" and pass product id as path variable




EcommerceCustomException
This class will be responsible for catching the runtime exceptions and display the message using the controlleradvice class and handles the exception




Data Structures used are List from java.util library.



Flow:

1. Once the api is hit with respective data. 
2. Controller will contact service class and executes respective methods.
3. From service method, it contacts respective repository and performs necessary action and returns the resukt to the controller
4. If any exception occurs, then custom messages will be displayed to report that exception.
