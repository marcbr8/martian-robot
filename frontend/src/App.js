import './App.css';
import React from 'react'
import ConfigurationComponent from './components/ConfigurationComponent';
import ViewResultsComponent from './components/ViewResultsComponent';



import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

function App() {
  return (
    <Router>
      <div className="container">
      <Switch>
        <Route path="/" exact component = {ConfigurationComponent}></Route>
		<Route path="/results" exact component = {ViewResultsComponent}></Route>
      </Switch>
      </div>
    </Router>
  );
}

export default App;
