import { Button, Image, Menu, Layout } from "antd";
import logo from "../img/driver-license.png";
import React, { useEffect } from "react";
import "../css/Home.css";
import { Link, Outlet, useNavigate } from "react-router-dom";
import LocalStorageService from "../service/LocalStorageService";
const { Header, Content } = Layout;

function Home() {
  const itemsHeader = [
    {
      key: 1,
      label: "Trang chủ",
      path: "/home",
    },
    {
      key: 2,
      label: "About",
      path: "/about",
    },
    {
      key: 3,
      label: "Todo",
      path: "/todo",
    },
  ];

  const navigate = useNavigate();

  const logout = () => {
    LocalStorageService.removeToken();
    navigate("/login");
  };

  useEffect(() => {
    const check = LocalStorageService.getToken();
    if (check === "") {
      navigate("/login");
    }
  }, []);

  return (
    <div>
      <Layout className="layout">
        <Header>
          <div className="logo">
            <Image
              className="imgLogo"
              width={70}
              height={70}
              src={logo}
              preview={false}
            />
          </div>
          <Menu theme="dark" mode="horizontal" defaultSelectedKeys={["2"]}>
            {itemsHeader.map((item) => (
              <Menu.Item key={item.key}>
                <Link to={item.path}>{item.label}</Link>
              </Menu.Item>
            ))}
            <Menu.Item key={logout}>
              <Button onClick={logout}>Đăng xuất</Button>
            </Menu.Item>
          </Menu>
        </Header>
        <Content
          className="content"
          style={{
            padding: "0 50px",
            background: "#ffff",
          }}
        >
          <div className="site-layout-content">
            <Outlet />
          </div>
        </Content>
      </Layout>
    </div>
  );
}

export default Home;
