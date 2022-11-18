import axios from "axios";
import { HOST } from "../router/Host";

const BASE_URL = `${HOST}/auth`;
class AuthService {
  signin(dataLogin) {
    return axios.post(`${BASE_URL}/signin`, dataLogin);
  }
}
export default new AuthService();
