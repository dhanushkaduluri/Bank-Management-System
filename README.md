# Bank-Management-System
This is a simple Bank Management System implemented in Java with MySQL as the database.

Features
Account Management: Create, view, and manage customer accounts.
Transaction Handling: Deposit, withdraw, and check balance.
Customer Information: Retrieve and update customer details.
Database Integration: Utilizes MySQL for data storage.
Requirements
Java Development Kit (JDK)
MySQL Database
Setup
Database Setup:

Create a MySQL database named bank_management_system.
Execute the SQL script database.sql to create necessary tables.
Java Development Kit (JDK):

Make sure you have JDK installed. You can download it from Oracle JDK or use OpenJDK.
Clone the Repository:
git clone https://github.com/yourusername/bank-management-system.git
cd bank-management-system
Configure Database Connection:

Open src/main/resources/application.properties.
Update the database URL, username, and password as per your MySQL configuration.
Build the Project:


javac -cp .:lib/mysql-connector-java-8.0.23.jar src/*.java -d out
Usage
Run the Application:
java -cp .:lib/mysql-connector-java-8.0.23.jar:out Main
(Make sure to include the MySQL Connector JAR in the classpath)

Follow On-screen Instructions:

Use the application by following the on-screen instructions.
Create accounts, perform transactions, and manage customer details.
Contributing
Contributions are welcome! If you find any issues or want to add new features, feel free to create a pull request.
