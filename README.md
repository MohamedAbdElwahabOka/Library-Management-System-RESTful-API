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
          "ISBN": "978-3-16-148410-0",
          "title": "Book One",
          "author": "Author One",
          "publicationYear": 2020,
          "publisher": "Publisher One",
          "pages": 300,
          "status": "Available"
      },
      {
          "id": 2,
          "ISBN": "978-3-16-1456877-0",
          "title": "Book Two",
          "author": "Author Two",
          "publicationYear": 1987,
          "publisher": "Publisher Two",
          "pages": 350,
          "status": "Not Available"
      }
  ]
