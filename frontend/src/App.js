import './App.css';
import React, { Component } from 'react'
import GridViewComponent from './components/GridViewComponent';
import RobotViewComponent from './components/RobotViewComponent';

class App extends Component {

  constructor() {
    super()
    this.state = {
        value: [],
        count: 1
       } 
  }

  addMoreRobots() {
    this.setState({
      count: this.state.count+1
    })
  }

  displayRobotComponents(){
     let robotComponents = [];
     for(let i = 0; i < this.state.count; i++){
               robotComponents.push(
               <div key={i}>
                  <RobotViewComponent id={i+1}/>
               </div>
            )
     }
     return robotComponents || null;
  }

  returnId () {
    return 1
  }

  render(){
      return (
      <div className="App">
        <h1>Martian Robot Management App</h1>
        <GridViewComponent /> 
        {this.displayRobotComponents()}
        
        <button onClick = { () => this.addMoreRobots()} type="button" className="btn btn-light"> + </button>
      </div>
    )
  }
}

export default App;
