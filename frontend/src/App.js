import './App.css';
import React, { Component } from 'react'
import GridViewComponent from './components/GridViewComponent';
import RobotViewComponent from './components/RobotViewComponent';
import RobotService from './services/RobotService';

class App extends Component {

  constructor() {
    super()
    this.submitRobotWithId = this.submitRobotWithId.bind(this)
    this.submitMarsGrid = this.submitMarsGrid.bind(this)
    this.removeRobot = this.removeRobot.bind(this)
    this.state = {
        value: [],
        count: 1,
        robots : [],
        marsGrid : {}
       } 
  }

  submitRobotWithId (robotId, robot){
    console.log('got to the parent after submitting')
    let robots = [...this.state.robots];
    robots[robotId-1] = robot;
    this.setState({robots});
  }

  submitMarsGrid (marsGrid){
    console.log('parent got this mars grit')
    console.log(marsGrid)
    this.setState({
      marsGrid
    })
    
  }

  addMoreRobots() {
    this.setState({
      count: this.state.count+1
    })
  }
  removeRobot(){
    console.log('tryining to delete')
      this.setState({
        count: this.state.count - 1
      }) 
  }

  displayRobotComponents(){
     let robotComponents = [];
     for(let i = 0; i < this.state.count; i++){
               robotComponents.push(
               <div key={i}>
                  <RobotViewComponent id={i+1} funcSubmitRobot={this.submitRobotWithId} funcDeleteRobot={this.removeRobot}/>
               </div>
            )
     }
     return robotComponents || null;
  }

  calculatePosition () {
    console.log('calculating for this robots...')
    console.log(this.state.robots);
    //RobotService.getPositionOfRobots(this.state.marsGrid, this.state.robots);

  }

  render(){
      return (
      <div className="App">
      <div className = "container">
        <h1 className="display-4 text-light main-title">Martian Robot Management App</h1>
      </div>  
        <GridViewComponent funcSubmitMarsGrid={this.submitMarsGrid}/> 
        {this.displayRobotComponents()}
        
        <button onClick = { () => this.addMoreRobots()} type="button" className="btn btn-light"> Add robot </button>
        <button onClick = { () => this.calculatePosition()} type="button" className="btn btn-light"> Calculate position </button>

      </div>
    )
  }
}

export default App;
