# bankingapi
1. Introduction
This documentation provides essential details for the "bankingapi Application". 
This application is built using Spring Boot with Maven and Java 17 and utilizes an in-memory H2 database.

2. Prerequisites
- Java: JDK 17. Download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or use OpenJDK.
- Maven: Ensure Maven is installed. Refer to [Maven's official installation guide](https://maven.apache.org/install.html) for instructions.

3. Getting Started
3.1. Cloning the Repository
git clone https://github.com/halhoula/bankingapi.git
cd bankingapi

3.2. Building the Application
mvn clean install
This command compiles the application and packages it into a `.jar` file in the `target` directory.
4. Configuration
This application uses application.properties for configuration:
- Server Port : 8080, the port is configured using server.port .
- H2 Console: By default, the H2 console is accessible at `/h2-console`.

5. Running the Application
java -jar target/bankingapi-0.0.1-SNAPSHOT.jar

6. Accessing the Application
After starting the application:
- Access the main application at `http://localhost:8080`.

Endpoints:
1. /createAccount: 
   - Method: POST
   - Description: Creates a new account.
   - Payload: 
{
    "customerId":[the_customer_id]
    "initialCredit": [the_initial_credit]
}

   - Response: 
If Customer not found : 404 with message « Customer [the_customer_id]not found »
If Account created : 200 with message « Account [the_Account_id] created successfully for customer [the_customer_id]»

2. /getUserInfo/{customerId}: 
   - Method: GET
   - Description: Retrieves Customer informations.
   - Parameters:  path variable : customerId.
   - Response: 
If Customer not found : 404 with message « Customer [the_customer_id]not found »
If Customer  found : 200 with customer informations exemple :
{"id": 1,
    "name": "Amina",
    "surname": "HALHOUL",
    "balance": 200.0,
    "accounts": [
        {
            "id": 3,
            "balance": 200.0,
            "transactions": [
                {
                    "id": 4,
                    "amount": 0.0,
                    "type": "CREDIT"
                }
            ]
        }
    ]
}
7. Database - H2
The application uses an in-memory H2 database:
- Console: Access the H2 console at http://localhost:8080/h2-console.
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password:

8. Maintenance and Monitoring
- Logs: The application logs can be found in the application directory under ‘logs/’. Describe the different log levels and what each level captures.
  
9. Troubleshooting
- Application not starting: Ensure no other process is using the configured port.
- Database connectivity issues: Since H2 is in-memory, data will be lost upon application restart. Ensure the application is running when trying to access data.

