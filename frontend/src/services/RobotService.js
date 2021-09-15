import axios from 'axios';

const ROBOT_API_BASE_URL = "http://localhost:8080/robot"

class RobotService {

	createRobot (robot){
		var result = axios.post(ROBOT_API_BASE_URL, robot);
	}

	clearAllRobots () {
		var result = axios.delete(ROBOT_API_BASE_URL);

	}
	getPositionOfRobots(ROBOT_API_BASE_URL){
		var result = axios.get(ROBOT_API_BASE_URL + '/calculate');
		console.log(result);

	}	

}

export default new RobotService();