import { TOKEN } from "../config/contant/Contant";

class LocalStorageService {
  setToken(token) {
    localStorage.setItem(TOKEN, token);
  }
  getToken() {
    return localStorage.getItem(TOKEN);
  }
  removeToken(){
    localStorage.setItem(TOKEN, "");
  }
}
export default new LocalStorageService();
