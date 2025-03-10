import React from "react";

const BookList = ({ books }) => {  

  return (
    <div className="container mt-4">
      <h2>Available Books</h2>
      <div className="row">
        {books.map((book) => (
          <div key={book.id} className="col-md-4">
            <div className="card mb-3">
              <div className="card-body">
                <h5>{book.title}</h5>
                <p>{book.author}</p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BookList;
