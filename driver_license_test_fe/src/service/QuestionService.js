import axios from "axios";
import { HOST } from "../router/Host";
import LocalStorageService from "./LocalStorageService";

const BASE_URL = `${HOST}/question`;

const headers = {
  headers: {
    Authorization: `Bearer ${LocalStorageService.getToken()}`,
  },
};

class QuestionService {
  getDataQuestion(id) {
    return axios.get(`${BASE_URL}/all/${id}`, headers);
  }
}
export default new QuestionService();
