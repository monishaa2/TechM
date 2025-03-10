import React, { useState, useEffect } from "react";
import axios from "axios";
import BookList from "./BookList";
import EnquiryForm from "./EnquiryForm";

const App = () => {
  const [books, setBooks] = useState([]); 

  useEffect(() => {
    axios.get("/api.json")  
      .then((response) => setBooks(response.data.books))
      .catch((error) => console.error("Error fetching books:", error));
  }, []);

  return (
    <div>
      <h1 className="text-center mt-3">Book Enquiry System</h1>
      <BookList books={books} />  
      <EnquiryForm books={books} />  
    </div>
  );
};

export default App;
