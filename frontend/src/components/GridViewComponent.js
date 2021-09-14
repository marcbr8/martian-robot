import React, { Component } from 'react'

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

		defineXForMarsGrid(a){

			this.setState( prevState => ({
				marsGrid : {
					...prevState.marsGrid,
					x: a
				}
			}));
		}

		defineYForMarsGrid(a){

			this.setState( prevState => ({
				marsGrid : {
					...prevState.marsGrid,
					y: a
				}
			}));

		}

		submitGrid(){
			this.props.funcSubmitMarsGrid(this.state.marsGrid);
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
											<a onClick = { () => this.defineXForMarsGrid(1) } className="dropdown-item" href="/#">1</a>
											    <a onClick = { () => this.defineXForMarsGrid(2) } className="dropdown-item" href="/#">2</a>
											    <a onClick = { () => this.defineXForMarsGrid(3) } className="dropdown-item" href="/#">3</a>
											    <a onClick = { () => this.defineXForMarsGrid(4) } className="dropdown-item" href="/#">4</a>
											    <a onClick = { () => this.defineXForMarsGrid(5) } className="dropdown-item" href="/#">5</a>
											    <a onClick = { () => this.defineXForMarsGrid(6) } className="dropdown-item" href="/#">6</a>
											    <a onClick = { () => this.defineXForMarsGrid(7) } className="dropdown-item" href="/#">7</a>
											    <a onClick = { () => this.defineXForMarsGrid(8) } className="dropdown-item" href="/#">8</a>
											    <a onClick = { () => this.defineXForMarsGrid(9) } className="dropdown-item" href="/#">9</a>
											    <a onClick = { () => this.defineXForMarsGrid(10) } className="dropdown-item" href="/#">10</a>
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
											    <a onClick = { () => this.defineYForMarsGrid(1) } className="dropdown-item" href="/#">1</a>
											    <a onClick = { () => this.defineYForMarsGrid(2) } className="dropdown-item" href="/#">2</a>
											    <a onClick = { () => this.defineYForMarsGrid(3) } className="dropdown-item" href="/#">3</a>
											    <a onClick = { () => this.defineYForMarsGrid(4) } className="dropdown-item" href="/#">4</a>
											    <a onClick = { () => this.defineYForMarsGrid(5) } className="dropdown-item" href="/#">5</a>
											    <a onClick = { () => this.defineYForMarsGrid(6) } className="dropdown-item" href="/#">6</a>
											    <a onClick = { () => this.defineYForMarsGrid(7) } className="dropdown-item" href="/#">7</a>
											    <a onClick = { () => this.defineYForMarsGrid(8) } className="dropdown-item" href="/#">8</a>
											    <a onClick = { () => this.defineYForMarsGrid(9) } className="dropdown-item" href="/#">9</a>
											    <a onClick = { () => this.defineYForMarsGrid(10) } className="dropdown-item" href="/#">10</a>
											  </div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div className="row text-center">	
							<div className="col align-self-center">					
								<button onClick = { () => this.submitGrid() }type="button" className="btn btn-success">Submit Grid</button>
							</div>
						</div>
					</div>
				</div>
				)
		}

	}
export default GridViewComponent;