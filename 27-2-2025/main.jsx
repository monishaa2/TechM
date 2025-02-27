import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
// import Component1 from './27feb task-1/c1.jsx'
// import Component2 from './27feb task-1/c2.jsx'
// import Component3 from './27feb task-1/c3.jsx'
// import Component4 from './27feb task-1/c4.jsx'
// import Component5 from './27feb task-1/c5.jsx'
// import ABComponent2 from './27feb1/ex1.jsx'

import C1 from './C1'





createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/* <Component1/>
    <Component2 />
    <Component3 />
    <Component4 />
    <Component5 />
    <ABComponent2/> */}

    <C1/>
    
    
  </StrictMode>,
)
