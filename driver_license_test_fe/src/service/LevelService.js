import axios from "axios";
import { HOST } from "../router/Host";
import LocalStorageService from "./LocalStorageService";

const BASE_URL = `${HOST}/level`;

const headers = {
  headers: {
    Authorization: `Bearer ${LocalStorageService.getToken()}`,
  },
};

class LevelService {
  getDataLevel() {
    return axios.get(`${BASE_URL}/all`, headers);
  }
}
export default new LevelService();
