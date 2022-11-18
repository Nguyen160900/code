import { Card, Space } from "antd";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import LevelService from "../service/LevelService";
import "../css/Level.css";

function Level() {
  const [dataLevel, setDataLevel] = useState([]);

  const fetchData = async () => {
    try {
      const response = await LevelService.getDataLevel();
      setDataLevel(response.data.data);
      console.log(response);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const items = dataLevel.map((item, index) => {
    return (
      <Link to={`test/${item.levelId}`} key={index}>
        <Card title={item.descriptions} size="middle">
          <h1 className="textCard">{item.name}</h1>
        </Card>
      </Link>
    );
  });

  return (
    <div>
      <Space size={[10, 10]} style={{margin: "15px 0px"}} wrap>
        {items}
      </Space>
    </div>
  );
}

export default Level;
