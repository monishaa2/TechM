
import "../App.css";

function Component3() {
    function m1()
    {
      alert("this is from component 3");
    }
    return (
      <>
        
        <button onClick={m1}>click me</button>
      </>
    );
}
  
export default Component3;