## Setting Up the Environment Variables for the Backend

### Prerequisites
- Ensure you have [Java 17](w) installed.
- Ensure you have [MySQL](w) installed and running.

### Steps to Configure the Backend
1. Navigate to the backend folder inside your project:
   ```sh
   cd backend
   ```
2. Create a `.env` file in the root of the backend folder, using `.env.example` as a template:
   ```sh
   cp .env.example .env
   ```
3. Open the `.env` file and update the values according to your environment setup.

### Database Setup
- In your MySQL instance, create a database named `chat_app`:
  ```sql
  CREATE DATABASE chat_app;
  ```

### Running the Application
1. Navigate to the backend folder:
   ```sh
   cd backend
   ```
2. Build the project using Maven:
   ```sh
   ./mvnw clean install
   ```
3. Run the Spring Boot application:
   ```sh
   ./mvnw spring-boot:run
   ```

After completing these steps, your backend should be up and running.

### API Documentation
To see routes of application click on [API_ROUTES](API_Routes_Documentation.md).

