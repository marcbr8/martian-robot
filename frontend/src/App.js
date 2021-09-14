import './App.css';
import GridViewComponent from './components/GridViewComponent';
import RobotViewComponent from './components/RobotViewComponent';

function App() {
  return (
    <div className="App">
      <h1>Martian Robot Management App</h1>
      <GridViewComponent /> 
      <RobotViewComponent />
    </div>
  );
}

export default App;
