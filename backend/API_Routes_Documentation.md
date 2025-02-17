# API Routes Documentation

## User Routes

### Update User
- **URL:** `/api/users/update/{userId}`
- **Method:** `PUT`
- **Description:** Update user details.
- **Request Body:**
  ```json
  {
    "full_name": "string",
    "profile_picture": "string"
  }
  ```
- **Response:**
  ```json
  {
    "id": "integer",
    "full_name": "string",
    "email": "string",
    "profile_picture": "string"
  }
  ```

### Get User Profile
- **URL:** `/api/users/profile`
- **Method:** `GET`
- **Description:** Get the profile of the authenticated user.
- **Response:**
  ```json
  {
    "id": "integer",
    "full_name": "string",
    "email": "string",
    "profile_picture": "string"
  }
  ```

### Search Users
- **URL:** `/api/users/search`
- **Method:** `GET`
- **Description:** Search users by name.
- **Query Parameters:**
  - `name`: The name to search for.
- **Response:**
  ```json
  [
    {
      "id": "integer",
      "full_name": "string",
      "email": "string",
      "profile_picture": "string"
    }
  ]
  ```

## Auth Routes

### Sign Up
- **URL:** `/auth/signup`
- **Method:** `POST`
- **Description:** Create a new user account.
- **Request Body:**
  ```json
  {
    "full_name": "string",
    "email": "string",
    "password": "string"
  }
  ```
- **Response:**
  ```json
  {
    "jwt": "string",
    "status": "boolean"
  }
  ```

### Sign In
- **URL:** `/auth/signin`
- **Method:** `POST`
- **Description:** Authenticate a user and generate a JWT token.
- **Request Body:**
  ```json
  {
    "email": "string",
    "password": "string"
  }
  ```
- **Response:**
  ```json
  {
    "jwt": "string",
    "status": "boolean"
  }
  ```

## Chat Routes

### Create Single Chat
- **URL:** `/api/chats/single`
- **Method:** `POST`
- **Description:** Create a single chat between two users.
- **Request Body:**
  ```json
  {
    "userId": "integer"
  }
  ```
- **Response:**
  ```json
  {
    "id": "integer",
    "chat_name": "string",
    "chat_image": "string",
    "is_group": "boolean",
    "admins": [],
    "created_by": {
      "id": "integer",
      "full_name": "string",
      "email": "string",
      "profile_picture": "string"
    },
    "users": [],
    "messages": []
  }
  ```

### Create Group Chat
- **URL:** `/api/chats/group`
- **Method:** `POST`
- **Description:** Create a group chat.
- **Request Body:**
  ```json
  {
    "userIds": ["integer"],
    "chat_name": "string",
    "chat_image": "string"
  }
  ```
- **Response:**
  ```json
  {
    "id": "integer",
    "chat_name": "string",
    "chat_image": "string",
    "is_group": "boolean",
    "admins": [],
    "created_by": {
      "id": "integer",
      "full_name": "string",
      "email": "string",
      "profile_picture": "string"
    },
    "users": [],
    "messages": []
  }
  ```

### Get Chat by ID
- **URL:** `/api/chats/{chatId}`
- **Method:** `GET`
- **Description:** Get chat details by chat ID.
- **Response:**
  ```json
  {
    "id": "integer",
    "chat_name": "string",
    "chat_image": "string",
    "is_group": "boolean",
    "admins": [],
    "created_by": {
      "id": "integer",
      "full_name": "string",
      "email": "string",
      "profile_picture": "string"
    },
    "users": [],
    "messages": []
  }
  ```

### Get All Chats by User ID
- **URL:** `/api/chats/user`
- **Method:** `GET`
- **Description:** Get all chats for the authenticated user.
- **Response:**
  ```json
  [
    {
      "id": "integer",
      "chat_name": "string",
      "chat_image": "string",
      "is_group": "boolean",
      "admins": [],
      "created_by": {
        "id": "integer",
        "full_name": "string",
        "email": "string",
        "profile_picture": "string"
      },
      "users": [],
      "messages": []
    }
  ]
  ```

### Add User to Group
- **URL:** `/api/chats/{chatId}/add/{userId}`
- **Method:** `PUT`
- **Description:** Add a user to a group chat.
- **Response:**
  ```json
  {
    "id": "integer",
    "chat_name": "string",
    "chat_image": "string",
    "is_group": "boolean",
    "admins": [],
    "created_by": {
      "id": "integer",
      "full_name": "string",
      "email": "string",
      "profile_picture": "string"
    },
    "users": [],
    "messages": []
  }
  ```

### Rename Group
- **URL:** `/api/chats/{chatId}/rename`
- **Method:** `PUT`
- **Description:** Rename a group chat.
- **Request Body:**
  ```json
  {
    "groupName": "string"
  }
  ```
- **Response:**
  ```json
  {
    "id": "integer",
    "chat_name": "string",
    "chat_image": "string",
    "is_group": "boolean",
    "admins": [],
    "created_by": {
      "id": "integer",
      "full_name": "string",
      "email": "string",
      "profile_picture": "string"
    },
    "users": [],
    "messages": []
  }
  ```

### Remove User from Group
- **URL:** `/api/chats/{chatId}/remove/{userId}`
- **Method:** `PUT`
- **Description:** Remove a user from a group chat.
- **Response:**
  ```json
  {
    "id": "integer",
    "chat_name": "string",
    "chat_image": "string",
    "is_group": "boolean",
    "admins": [],
    "created_by": {
      "id": "integer",
      "full_name": "string",
      "email": "string",
      "profile_picture": "string"
    },
    "users": [],
    "messages": []
  }
  ```

### Delete Chat
- **URL:** `/api/chats/delete/{chatId}/{userId}`
- **Method:** `DELETE`
- **Description:** Delete a chat.
- **Response:**
  ```json
  {
    "id": "integer",
    "chat_name": "string",
    "chat_image": "string",
    "is_group": "boolean",
    "admins": [],
    "created_by": {
      "id": "integer",
      "full_name": "string",
      "email": "string",
      "profile_picture": "string"
    },
    "users": [],
    "messages": []
  }
  ```

## Message Routes

### Send Message
- **URL:** `/api/messages/create`
- **Method:** `POST`
- **Description:** Send a message in a chat.
- **Request Body:**
  ```json
  {
    "chatId": "integer",
    "userId": "integer",
    "content": "string"
  }
  ```
- **Response:**
  ```json
  {
    "id": "integer",
    "content": "string",
    "timeStamp": "string",
    "is_read": "boolean",
    "user": {
      "id": "integer",
      "full_name": "string",
      "email": "string",
      "profile_picture": "string"
    },
    "chat": {
      "id": "integer",
      "chat_name": "string",
      "chat_image": "string",
      "is_group": "boolean",
      "admins": [],
      "created_by": {
        "id": "integer",
        "full_name": "string",
        "email": "string",
        "profile_picture": "string"
      },
      "users": [],
      "messages": []
    }
  }
  ```

### Get Messages by Chat ID
- **URL:** `/api/messages/chat/{chatId}`
- **Method:** `GET`
- **Description:** Get all messages in a chat.
- **Response:**
  ```json
  [
    {
      "id": "integer",
      "content": "string",
      "timeStamp": "string",
      "is_read": "boolean",
      "user": {
        "id": "integer",
        "full_name": "string",
        "email": "string",
        "profile_picture": "string"
      },
      "chat": {
        "id": "integer",
        "chat_name": "string",
        "chat_image": "string",
        "is_group": "boolean",
        "admins": [],
        "created_by": {
          "id": "integer",
          "full_name": "string",
          "email": "string",
          "profile_picture": "string"
        },
        "users": [],
        "messages": []
      }
    }
  ]
  ```

### Delete Message
- **URL:** `/api/messages/{messageId}`
- **Method:** `DELETE`
- **Description:** Delete a message.
- **Response:**
  ```json
  {
    "message": "string",
    "status": "boolean"
  }
  ```

## Home Route

### Home
- **URL:** `/`
- **Method:** `GET`
- **Description:** Welcome message.
- **Response:**
  ```json
  "Wellcome to our whatsapp API using Spring boot"
  ```

## WebSocket Routes

### WebSocket Endpoint
- **URL:** `/ws`
- **Description:** WebSocket endpoint for real-time communication.

### Public Group Message
- **URL:** `/group/public`
- **Description:** Endpoint for public group messages.

### Private Message
- **URL:** `/user/private`
- **Description:** Endpoint for private messages.

### Application Destination Prefix
- **Prefix:** `/app`
- **Description:** Prefix for application destinations.

### User Destination Prefix
- **Prefix:** `/user`
- **Description:** Prefix for user destinations.

### Group Destination Prefix
- **Prefix:** `/group`
- **Description:** Prefix for group destinations.
