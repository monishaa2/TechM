import React from "react";
function Divisibleby16(props) {
  const num = props.a % 16;
  let text;
  if (num == 0) {
    text = " Divisible by 16";
  } else {
    text = "Not divisible by 16";
  }

  return (
    <>
      <h1>TASK1</h1>
      <h1>the given number is : {props.a} </h1>
      <p>{text}</p>
    </>
  );
}

function GovernmentOffer(props) {
  return (
    <>
      <h1>TASK2</h1>
      <h1>What government identity card do you have?</h1>

      <ul>
        <li>AADHAR CARD (Enter 1)</li>
        <li>PAN CARD (Enter 2)</li>
      </ul>

      <h2>
        {props.id === 1 || props.id === 2
          ? "You have a government offer!"
          : "You do not have a government offer."}
      </h2>
    </>
  );
}

function Cars() {
  let cars = ["BMW", "Ford", "Audi", "Mercedes"];

  return (
    <>
      {cars.map((car) => (
        <ul>
          {" "}
          <li>
            <h4>Heyy, this is {car}</h4>
          </li>
        </ul>
      ))}
    </>
  );
}

function Listofstudents() {
  let list = [
    { id: 1, Name: "vihan" },
    { id: 2, Name: "noah" },
    { id: 3, Name: "noma" },
  ];

  return (
    <>
      <h1>TASK3</h1>
      <h1>student details</h1>
      <ul>
        
        {list.map((student) => (
          <li>
         
            id : {student.id} , name : {student.Name}{" "}
          </li>
        ))}
      </ul>
      
      </>
  
  );
}


import React from "react";

function Students() {
  let details = [
    { id: 1, name: "Ria", marks: 60 },
    { id: 2, name: "Noah", marks: 40 },
    { id: 3, name: "Anisha", marks: 100 }
  ];

  return (
    <>
      <h1>Welcome to Student Marklist Dashboard</h1>
      <ul>
        {details.map((stu) => (
          <li key={stu.id}>
            <h3>
              {stu.name} - {stu.marks >= 50 ? "Pass ✅" : "Fail ❌"}
            </h3>
          </li>
        ))}
      </ul>
    </>
  );
}

export default Students;
  

export { Divisibleby16, Cars, GovernmentOffer, Listofstudents };
