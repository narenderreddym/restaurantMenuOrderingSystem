1. Technology Stack Used:
    - Java 17
    - Spring Boot 3.2.2
    - GraphQL
    - In-memory database (such as H2)

Import The project into Intellij Idea

Step 1 :
application.properties added h2 data base properties.

Step 2
Run the application

Step 3
Open below URL and execute below query in H2 data base
http://localhost:8989/h2-console/login.jsp

INSERT INTO menu_item (item_id, item_name, item_category, description, price) VALUES
('1', 'Dish 1', 'Entrée', 'Description 1', 10.99),
('2', 'Dish 2', 'Appetizer', 'Description 2', 8.99),
('3', 'Dish 3', 'Dessert', 'Description 3', 12.99);

Step 4: Once completed. Perform below operations

1) Queries to fetch a list of all menu items including their attributes.
   query getMenuItems{
   getMenuItems {
   itemId
   itemName
   itemCategory
   description
   price
   }
   }
   Response:
   {
   "data": {
   "getMenuItems": [
   {
   "itemId": "1",
   "itemName": "Dish 1",
   "itemCategory": "Entrée",
   "description": "Description 1",
   "price": 10.99
   },
   {
   "itemId": "2",
   "itemName": "Dish 2",
   "itemCategory": "Appetizer",
   "description": "Description 2",
   "price": 8.99
   },
   {
   "itemId": "3",
   "itemName": "Dish 3",
   "itemCategory": "Dessert",
   "description": "Description 3",
   "price": 12.99
   }
   ]
   }
   }

2) Queries to fetch a specific menu item by its itemId.
   Query:
   query menuItemByID {
   menuByItemID(itemId:"1") {
   itemId
   itemName
   itemCategory
   description
   price
   }
   }
   Response:
   {
   "data": {
   "menuByItemID": {
   "itemId": "1",
   "itemName": "Dish 1",
   "itemCategory": "Entrée",
   "description": "Description 1",
   "price": 10.99
   }
   }
   }

3) Queries to fetch a specific menu item by its itemId.
   Query:
   query catagory{
   getMenuItemsByCategory(itemCategory:"Appetizer") {
   itemId
   itemName
   itemCategory
   description
   price
   }
   }
   Response:
   {
   "data": {
   "getMenuItemsByCategory": [
   {
   "itemId": "2",
   "itemName": "Dish 2",
   "itemCategory": "Appetizer",
   "description": "Description 2",
   "price": 8.99
   }
   ]
   }
   }

4)Mutations to place an order with attributes including itemIds and quantities.

Query:

	mutation {
    placeOrder(
        itemIds: ["1", "2"],
        quantities: [2, 1]
    ) {
        orderId
        items {
            itemId
            itemName
            itemCategory
            description
            price
        }
        totalPrice
        orderDate
    }

}
Response:
{
"data": {
"placeOrder": {
"orderId": "9ec4102d-3842-49b5-b5aa-fa26976ddba6",
"items": [
{
"itemId": "1",
"itemName": "Dish 1",
"itemCategory": "Entrée",
"description": "Description 1",
"price": 10.99
},
{
"itemId": "2",
"itemName": "Dish 2",
"itemCategory": "Appetizer",
"description": "Description 2",
"price": 8.99
}
],
"totalPrice": 30.97,
"orderDate": "2024-02-22T10:03:32.536906100"
}
}
}
