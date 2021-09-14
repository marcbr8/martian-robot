import axios from 'axios';

const DRIVER_API_BASE_URL = "http://localhost:8080/robot/move"

class RobotService {

	getPositionOfRobots(marsGrid, robots){
		var requestObject = {
        	robotList : robots,
        	marsGrid : marsGrid
    	}
    	console.log('Here comes the request object');
    	console.log(JSON.stringify(requestObject));
		var result = axios.post(DRIVER_API_BASE_URL, requestObject);
		console.log(result);

	}	

}

export default new RobotService();