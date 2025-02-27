import { useState } from "react";
import "../App.css";
function Component1() {
  const [txt, setTxt] = useState("");

  function m1() {
    setTxt("This is from Component 1");
  }

  return (
    <>
      <button onClick={m1}>Click me</button>
      <p>{txt}</p>
    </>
  );
}

export default Component1;
