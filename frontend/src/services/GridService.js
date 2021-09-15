import axios from 'axios';

const GRID_API_BASE_URL = "http://localhost:8080/grid"

class GridService {

	createGrid (grid){
		var result = axios.post(GRID_API_BASE_URL, grid);
		return result;
	}

	getCurrentGrid(){
		var result = axios.get(GRID_API_BASE_URL);
		return result;

	}

	clearAllGrids(){
		var result = axios.delete(GRID_API_BASE_URL);
		return result;
	}	

}

export default new GridService();