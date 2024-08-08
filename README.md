# Library Management System API Documentation

## Book API

### 1. Get All Books
- **Endpoint:** `GET /api/books`
- **Description:** Retrieve a list of all books.
- **Response Example:**
  ```json
  [
      {
          "id": 1,
          "isbn": "978-3-16-148410-0",
          "title": "Book One",
          "author": "Author One",
          "publicationYear": 2020,
          "publisher": "Publisher One",
          "pages": 300,
          "status": "Available"
      },
      {
          "id": 2,
          "isbn": "978-3-16-1456877-0",
          "title": "Book Two",
          "author": "Author Two",
          "publicationYear": 1987,
          "publisher": "Publisher Two",
          "pages": 350,
          "status": "Not Available"
      }
  ]
  ```
  
  ### 2. Get Book by ID
  - **Endpoint:** `GET /api/books/{id}`
  - **Description:** Retrieve a book by its ID.
  - **Response Example:**
  ```json
  {
    "id": 1,
    "isbn": "978-3-16-148410-0",
    "title": "Book One",
    "author": "Author One",
    "publicationYear": 2020,
    "publisher": "Publisher One",
    "pages": 300,
    "status": "Available"}
  ```
  
  ### 3. Add New Book
  - **Endpoint:** `POST /api/books`
  - **Description:** Add a new book to the collection.
  - **Request Body Example:**
  ```json
  {
    "isbn": "978-3-16-148410-0",
    "title": "Book One",
    "author": "Author One",
    "publicationYear": 2020,
    "publisher": "Publisher One",
    "pages": 300
  }
  ```
  - **Response Example:**
  ```json
  {
    "id": 1,
    "isbn": "978-3-16-148410-0",
    "title": "Book One",
    "author": "Author One",
    "publicationYear": 2020,
    "publisher": "Publisher One",
    "pages": 300,
    "status": "Available"
  }
  ```
  
  ### 4. Update Book
  - **Endpoint:** `PUT /api/books/{id}`
  - **Description:** Update the details of an existing book.
  - **Request Body Example:**
  ```json
  {
    "title": "Updated Book One",
    "author": "Updated Author One"
  }
  ```
  - **Response Example:**
  ```json
  {
    "id": 1,
    "isbn": "978-3-16-148410-0",
    "title": "Updated Book One",
    "author": "Updated Author One",
    "publicationYear": 2020,
    "publisher": "Publisher One",
    "pages": 300,
    "status": "Available"
  }
  ```
  
  ### 5. Update Book
  - **Endpoint:** `DELETE /api/books/{id}`
  - **Description:** Delete a book by its ID.
  - **Response Example:**
  ```json
  {
    "message": "Book with id 1 was successfully deleted."
  }
  ```

  ## Patron API
  
  ### 1. Get All Patrons
  - **Endpoint:** `GET /api/patrons`
  - **Description:** Retrieve a list of all patrons.
  - **Response Example:**
  ```json
  [
  {
        "id": 1,
        "name": "Patron One",
        "email": "patron1@example.com",
        "phone": "123-456-7890",
        "address": "123 Main St",
        "zip": "12345"
    }
  ]
  ```

   ### 2. Get Patron by ID
  - **Endpoint:** `GET /api/patrons/{id}`
  - **Description:** Retrieve a patron by its ID.
  - **Response Example:**
  ```json
  
  {
    "id": 1,
    "name": "Patron One",
    "email": "patron1@example.com",
    "phone": "123-456-7890",
    "address": "123 Main St",
    "zip": "12345"
  }
  ```

   ### 3. Add New Patron
  - **Endpoint:** `POST /api/patrons`
  - **Description:** Add a new patron to the system.
  - **Request Body Example:**
  ```json
  {
    "name": "Patron One",
    "email": "patron1@example.com",
    "phone": "123-456-7890",
    "address": "123 Main St",
    "zip": "12345"
  }
  ```
   - **Response Example:**
  ```json
  {
    "id": 1,
    "name": "Patron One",
    "email": "patron1@example.com",
    "phone": "123-456-7890",
    "address": "123 Main St",
    "zip": "12345"
  }
  ```

   ### 4. Update Patron
  - **Endpoint:** `PUT /api/patrons/{id}`
  - **Description:** Update the details of an existing patron.
  - **Request Body Example:**
  ```json
  {
    "name": "Updated Patron One",
    "email": "updatedpatron1@example.com"
  }
  ```
   - **Response Example:**
  ```json
  {
    "id": 1,
    "name": "Updated Patron One",
    "email": "updatedpatron1@example.com",
    "phone": "123-456-7890",
    "address": "123 Main St",
    "zip": "12345"
  }
  ```

   ### 5. Delete Patron
  - **Endpoint:** `DELETE /api/patrons/{id}`
  - **Description:** Delete a patron by its ID.
  - **Response Example:**
  ```json
  {
    "message": "Patron with id 1 was successfully deleted."
  }
  ```
  
  ## Borrowing Record API

   ### 1. Borrow Book
  - **Endpoint:** `POST /api/borrow/{bookId}/patron/{patronId}`
  - **Description:** Borrow a book by a patron.
  - **Response Example:**
    Update the book status from `Available` to `Not Available`
  ```json
  {Book with id 1 was borrowed successfully by patron with id 2}
  ```

   ### 2. Return Book
  - **Endpoint:** `POST /api/return/{bookId}/patron/{patronId}`
  - **Description:** Return a borrowed book.
  - **Response Example:**
    Update the book status from `Not Available` to  `Available` and Add a `returnDate` value
  ```json
  {
   The patron with 1 return The Book with id 1
  }
  ```
  

  
  
 
  
    

  
  
  
  
