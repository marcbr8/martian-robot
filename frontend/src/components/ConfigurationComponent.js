import '../App.css';
import React, { Component } from 'react'
import GridViewComponent from './GridViewComponent';
import RobotCreationComponent from './RobotCreationComponent';
import RobotService from '../services/RobotService';
import GridService from '../services/GridService';

class ConfigurationComponent extends Component {

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

  submitRobotWithId (robot){
    this.setState(previousState => ({
      robots: [...previousState.robots, robot]
    }));
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
    this.props.history.push('/results')
  }

  render(){
      return (
      <div className="App">
      <div className = "container">
        <h1 className="display-4 text-light main-title">Martian Robot Management App</h1>
      </div>  
        <GridViewComponent funcSubmitMarsGrid={this.submitMarsGrid} funcClearAllGrids={this.clearAllGrids}/>
        <RobotCreationComponent funcSubmitRobot={this.submitRobotWithId}/>
        <div className="container mt-5">
          <div className="row text-center"> 
                <div className="col align-self-right">          
                  <button onClick = { () => this.clearAllRobots()} type="button" className="btn btn-danger mars-font"> Clear all robots </button>
          </div>
          <div className="row text-center mt-3"> 
                    <button onClick = { () => this.calculatePosition()} type="button" className="btn btn-light  btn-lg mars-font"> Calculate position </button>
                </div>
              </div>
          </div>
      </div>
    )
  }
}

export default ConfigurationComponent;
