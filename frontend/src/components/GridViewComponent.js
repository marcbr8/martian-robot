import React, { Component } from 'react'
import GridService from '../services/GridService'

	class GridViewComponent extends Component {

		constructor(props){
			super(props)
			this.state = {
				marsGrid : {
					boundaries : {
						x : 0,
						y : 0			
					}
				}
			}
		}

		componentDidMount(){
			GridService.clearAllGrids();
			
		}

		defineXForMarsGrid(a){
			var marsGrid = {...this.state.marsGrid}
			marsGrid.boundaries = {...marsGrid.boundaries,
				x: a}
			this.setState({marsGrid})

		}

		defineYForMarsGrid(a){

			var marsGrid = {...this.state.marsGrid}
			marsGrid.boundaries = {...marsGrid.boundaries,
				y: a}
			this.setState({marsGrid})

		}

		submitGrid(){
			this.props.funcSubmitMarsGrid(this.state.marsGrid);
		}

		clearGrids() {
			this.props.funcClearAllGrids();
		}

		render () {
			return (
				<div>
					<div className="container mars-font">
						<h2 className="text-left"> Mars Grid </h2>
						<div className="row alert alert-info">
							<div className="col">
								<div className="container">
									<div className="row">								
										<div className="col my-auto">
											<p className="text-left my-auto">
												X coordinate
											</p>
										</div>
										<div className="col my-auto">
											<div className="dropdown">
											  <button className="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								 			   {this.state.marsGrid.boundaries.x}
											  </button>
											  <div className="dropdown-menu" aria-labelledby="dropdownMenuButton">
												<button onClick = { () => this.defineXForMarsGrid(0) } className="dropdown-item" >0</button>											  
												<button onClick = { () => this.defineXForMarsGrid(1) } className="dropdown-item" >1</button>
											    <button onClick = { () => this.defineXForMarsGrid(2) } className="dropdown-item" >2</button>
											    <button onClick = { () => this.defineXForMarsGrid(3) } className="dropdown-item" >3</button>
											    <button onClick = { () => this.defineXForMarsGrid(4) } className="dropdown-item" >4</button>
											    <button onClick = { () => this.defineXForMarsGrid(5) } className="dropdown-item" >5</button>
											    <button onClick = { () => this.defineXForMarsGrid(6) } className="dropdown-item" >6</button>
											    <button onClick = { () => this.defineXForMarsGrid(7) } className="dropdown-item" >7</button>
											    <button onClick = { () => this.defineXForMarsGrid(8) } className="dropdown-item" >8</button>
											    <button onClick = { () => this.defineXForMarsGrid(9) } className="dropdown-item" >9</button>
											    <button onClick = { () => this.defineXForMarsGrid(10) } className="dropdown-item" >10</button>
											  </div>
											</div>
										</div>
									</div>
								</div>	
							</div>
							<div className="col">
								<div className="container">
									<div className="row">								
										<div className="col my-auto">
											<p className="text-left my-auto">
												Y coordinate
											</p>
										</div>
										<div className="col my-auto">
											<div className="dropdown">
											  <button className="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								  			  {this.state.marsGrid.boundaries.y}
											  </button>
											  <div className="dropdown-menu" aria-labelledby="dropdownMenuButton">
											    <button onClick = { () => this.defineYForMarsGrid(1) } className="dropdown-item" >1</button>
											    <button onClick = { () => this.defineYForMarsGrid(2) } className="dropdown-item" >2</button>
											    <button onClick = { () => this.defineYForMarsGrid(3) } className="dropdown-item" >3</button>
											    <button onClick = { () => this.defineYForMarsGrid(4) } className="dropdown-item" >4</button>
											    <button onClick = { () => this.defineYForMarsGrid(5) } className="dropdown-item" >5</button>
											    <button onClick = { () => this.defineYForMarsGrid(6) } className="dropdown-item" >6</button>
											    <button onClick = { () => this.defineYForMarsGrid(7) } className="dropdown-item" >7</button>
											    <button onClick = { () => this.defineYForMarsGrid(8) } className="dropdown-item" >8</button>
											    <button onClick = { () => this.defineYForMarsGrid(9) } className="dropdown-item" >9</button>
											    <button onClick = { () => this.defineYForMarsGrid(10) } className="dropdown-item" >10</button>
											  </div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div className="row text-center">	
							<div className="col align-self-right">					
								<button onClick = { () => this.submitGrid() }type="button" className="btn btn-success">Submit Grid</button>
							</div>
							<div className="col align-self-left">					
								<button onClick = { () => this.clearGrids() }type="button" className="btn btn-danger">Clear all stored grids</button>
							</div>
						</div>
					</div>
				</div>
				)
		}

	}
export default GridViewComponent;