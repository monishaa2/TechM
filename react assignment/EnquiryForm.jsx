import React, { useState } from "react";

const EnquiryForm = ({ books }) => {  
  const [query, setQuery] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const bookFound = books.some((book) =>
      book.title.toLowerCase().includes(query.toLowerCase())
    );

    if (bookFound) {
      setMessage(`The book "${query}" is available!`);
    } else {
      setMessage(` Sorry, the book "${query}" is not available.`);
    }

    setQuery(""); 
  };

  return (
    <div className="container mt-4">
      <h2>Check Book Availability</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          className="form-control mb-2"
          placeholder="Enter book title"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
        />
        <button className="btn btn-primary" type="submit">
          Check Availability
        </button>
      </form>
      {message && <p className="mt-3">{message}</p>}
    </div>
  );
};

export default EnquiryForm;
