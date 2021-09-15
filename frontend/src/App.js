import './App.css';
import React, { Component } from 'react'
import GridViewComponent from './components/GridViewComponent';
import RobotViewComponent from './components/RobotViewComponent';
import RobotService from './services/RobotService';
import GridService from './services/GridService';

class App extends Component {

  constructor() {
    super()
    this.submitRobotWithId = this.submitRobotWithId.bind(this)
    this.submitMarsGrid = this.submitMarsGrid.bind(this)
    this.clearAllGrids = this.clearAllGrids.bind(this)

    this.state = {
        value: [],
        count: 1,
        robots : [],
        marsGrid : {}
       } 
  }

  submitRobotWithId (robotId, robot){
    let robots = [...this.state.robots];
    robots[robotId-1] = robot;
    this.setState({robots});
    RobotService.createRobot(robot);
  }

  submitMarsGrid (marsGrid){
   GridService.createGrid(marsGrid);
    this.setState({
      marsGrid
    })
  }

  clearAllGrids (){
    GridService.clearAllGrids()
    this.setState({
      marsGrid : {}
    })
  }

  clearAllRobots (){
    RobotService.clearAllRobots()
    this.setState({
      robots : []
    })
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
        <GridViewComponent funcSubmitMarsGrid={this.submitMarsGrid} funcClearAllGrids={this.clearAllGrids}/>
        <RobotViewComponent funcSubmitRobot={this.submitRobotWithId}/>
        
        
        <button onClick = { () => this.clearAllRobots()} type="button" className="btn btn-light"> Clear all robots </button>
        <button onClick = { () => this.calculatePosition()} type="button" className="btn btn-light"> Calculate position </button>

      </div>
    )
  }
}

export default App;
