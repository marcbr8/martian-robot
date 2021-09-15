import React, { Component } from 'react'
import RobotService from '../services/RobotService';

	class ViewResultsComponent extends Component {

		constructor(props){
			super(props)
			this.state = {
				grid : {},
				robots : []

			}
		}

		componentDidMount(){

			RobotService.getPositionOfRobots().then( res => {
				this.setState({robots :res.data})
			})
		}

		showResults() {
			return this.state.robots.map((robot, index) => (
    				<div className="col alert-light" key={index}>
    					<div className="row " key={index}>
    					<h1> Robot {index+1} </h1>
    					<p>Coordinate X: {robot.coordinates.x}</p>
			        	<p>Coordinate Y: {robot.coordinates.y}</p>	
			        	<p>Orientation: {robot.orientation}</p>	
			        	<p>Lost: {robot.lost ? 'LOST' : 'NOT LOST'}</p>

			        	</div>
    				</div>
				));
			

		}

		render () {
			return (
				 <div >
			        <h1 className="display-4 text-light main-title">Martian Robot Results </h1>
			     
					<div className="container mars-font text-light">
					<div className="row mt-5">
						{this.showResults()}
					</div>
					</div>
				</div>
				);
		}
}

export default ViewResultsComponent;