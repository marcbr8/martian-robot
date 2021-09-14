import React, { Component } from 'react'

	class RobotViewComponent extends Component {

		constructor(props){
			super(props)
			this.state = {
				robot : {
			
				}

			}
		}

		defineXforRobot(a){

			this.setState( prevState => ({
				robot : {
					...prevState.robot,
					x: a
				}
			}));
		}

		defineYforRobot(a){

			this.setState( prevState => ({
				robot : {
					...prevState.robot,
					y: a
				}
			}));

		}


		render () {
			return (
				<div>
					<div className="container">
						<div className="row">
							<h2 className="text-left"> Robot </h2>
							<div className="col">
								<div className="dropdown">
								  <button className="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    {this.state.robot.x ? this.state.robot.x : 'X coordinate'}
								  </button>
								  <div className="dropdown-menu" aria-labelledby="dropdownMenuButton">
								    <a onClick = { () => this.defineXforRobot(1) } className="dropdown-item" href="/#">1</a>
								    <a onClick = { () => this.defineXforRobot(2) } className="dropdown-item" href="/#">2</a>
								    <a onClick = { () => this.defineXforRobot(3) } className="dropdown-item" href="/#">3</a>
								    <a onClick = { () => this.defineXforRobot(4) } className="dropdown-item" href="/#">4</a>
								    <a onClick = { () => this.defineXforRobot(5) } className="dropdown-item" href="/#">5</a>
								    <a onClick = { () => this.defineXforRobot(6) } className="dropdown-item" href="/#">6</a>
								    <a onClick = { () => this.defineXforRobot(7) } className="dropdown-item" href="/#">7</a>
								    <a onClick = { () => this.defineXforRobot(8) } className="dropdown-item" href="/#">8</a>
								    <a onClick = { () => this.defineXforRobot(9) } className="dropdown-item" href="/#">9</a>
								    <a onClick = { () => this.defineXforRobot(10) } className="dropdown-item" href="/#">10</a>
								  </div>
								</div>
							</div>
							<div className="col">
								<div className="dropdown">
								  <button className="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    {this.state.robot.y ? this.state.robot.y : 'Y coordinate'}
								  </button>
								  <div className="dropdown-menu" aria-labelledby="dropdownMenuButton">
								    <a onClick = { () => this.defineYforRobot(1) } className="dropdown-item" href="/#">1</a>
								    <a onClick = { () => this.defineYforRobot(2) } className="dropdown-item" href="/#">2</a>
								    <a onClick = { () => this.defineYforRobot(3) } className="dropdown-item" href="/#">3</a>
								    <a onClick = { () => this.defineYforRobot(4) } className="dropdown-item" href="/#">4</a>
								    <a onClick = { () => this.defineYforRobot(5) } className="dropdown-item" href="/#">5</a>
								    <a onClick = { () => this.defineYforRobot(6) } className="dropdown-item" href="/#">6</a>
								    <a onClick = { () => this.defineYforRobot(7) } className="dropdown-item" href="/#">7</a>
								    <a onClick = { () => this.defineYforRobot(8) } className="dropdown-item" href="/#">8</a>
								    <a onClick = { () => this.defineYforRobot(9) } className="dropdown-item" href="/#">9</a>
								    <a onClick = { () => this.defineYforRobot(10) } className="dropdown-item" href="/#">10</a>
								  </div>
								</div>
							</div>
							<div className="col">
								<div className="input-group mb-3">
								  <div className="input-group-prepend">
								    <span className="input-group-text" id="basic-addon1">Instructions</span>
								  </div>
								  <input type="text" class="form-control" placeholder="Please type your instructions" aria-label="" aria-describedby="basic-addon1"></input>
								</div>
							</div>
						</div>

					</div>
				</div>
				)
		}

	}
export default RobotViewComponent;