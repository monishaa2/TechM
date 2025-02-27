
import "../App.css";

function Component2() {
    function m1()
    {
      alert("this is from component 2");
    }
    return (
      <>
        
        <button onClick={m1}>click me</button>
      </>
    );
}
export default Component2;