import React, { useEffect, useState } from "react";
import logo from "../img/driver-license.png";
import { Button, Form, Image, Input, message } from "antd";
import AuthService from "../service/AuthService";
import "../css/Login.css";
import LocalStorageService from "../service/LocalStorageService";
import { useNavigate } from "react-router-dom";

const initialValue = {
  username: "",
  password: "",
};

function Login() {
  const [login, setLogin] = useState(initialValue);
  const navigate = useNavigate();
  const handleChange = (e) => {
    const value = e.target.value;
    setLogin({ ...login, [e.target.name]: value });
    console.log(login);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    AuthService.signin(login).then((res) => {
      LocalStorageService.setToken(res.data.token);
      if (res.data.token) {
        navigate("/home");
      }
    });
    console.log(LocalStorageService.getToken());
  };

  return (
    <div>
      <div className="lContainer">
        <div className="lItem">
          <div className="loginImage">
            <Image
              src={logo}
              width="300"
              style={{ position: "relative" }}
              alt="login"
              preview={false}
            />
          </div>
          <div className="loginForm">
            <h1>THI BẰNG LÁI XE</h1>
            <Form className="login-form">
              <Form.Item
                rules={[
                  {
                    required: true,
                    message: "Please input your username!",
                  },
                ]}
              >
                <Input
                  name="username"
                  placeholder="Nhập tên đăng nhập"
                  onChange={(e) => handleChange(e)}
                />
              </Form.Item>
              <Form.Item
                rules={[
                  {
                    required: true,
                    message: "Please input your password!",
                  },
                ]}
              >
                <Input.Password
                  name="password"
                  placeholder="Nhập mật khẩu"
                  onChange={(e) => handleChange(e)}
                />
              </Form.Item>
              <Form.Item>
                <Button
                  type="primary"
                  htmlType="submit"
                  className="login-form-button"
                  onClick={(e) => handleSubmit(e)}
                >
                  ĐĂNG NHẬP
                </Button>
              </Form.Item>
            </Form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
