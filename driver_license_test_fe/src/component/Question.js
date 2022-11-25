import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import QuestionService from "../service/QuestionService";
import "../css/Question.css";
import {
  Affix,
  Button,
  Card,
  Col,
  Modal,
  Radio,
  Row,
  Space,
  Statistic,
} from "antd";
const { Countdown } = Statistic;

function StartTest() {
  const { id } = useParams();
  const [dataQuestion, setDataQuestion] = useState([]);
  const [modalOpen, setModalOpen] = useState(false);
  const [modal2Open, setModal2Open] = useState(false);
  const deadline = Date.now() + 1000 * 60 * 19;

  console.log(deadline);

  const fetchData = async () => {
    try {
      const response = await QuestionService.getDataQuestion(id);
      setDataQuestion(response.data.data);
      console.log(response);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const items = dataQuestion.map((item, index) => {
    return (
      <Card
        title={`Câu ${index + 1}: ${item.name}`}
        size="middle"
        wrap="false"
        type="inner"
        key={index}
      >
        <Radio.Group>
          <Space direction="vertical">
            {item.listAnswer.map((answer, index) => {
              return <Radio value={answer.idAnswer}>{answer.name}</Radio>;
            })}
          </Space>
        </Radio.Group>
      </Card>
    );
  });

  const onFinish = () => {
    // console.log("abc");
    setModalOpen(true);
  };

  const countDown = () => {
    return (
      <Affix offsetTop={120} onChange={(affixed) => console.log(affixed)}>
        <Countdown title="Thời gian làm bài" value={deadline} format="mm:ss" />
      </Affix>
    );
  };

  return (
    <div>
      <Row>
        <Col className="countDown" span={3}>
          <div>{countDown()}</div>
        </Col>
        <Col span={18}>
          <div className="container">
            <h1 className="textTop">BỘ ĐỀ THI THỬ BẰNG LÁI XE HẠNG A1</h1>
            <Modal
              title="Thông báo"
              centered
              open={modalOpen}
              footer={[
                <Button key="back" onClick={() => setModalOpen(false)}>
                  Nộp bài
                </Button>,
              ]}
            >
              <h2 className="countDown">Bạn đã hết giờ làm bài!</h2>
            </Modal>
            <Space
              direction="vertical"
              size="middle"
              style={{
                display: "flex",
              }}
            >
              {items}
            </Space>
            <Button type="primary" onClick={() => setModal2Open(true)} className="btnSubmit">
              NỘP BÀI
            </Button>
            <Modal
              title="Thông báo"
              centered
              visible={modal2Open}
              onOk={() => setModal2Open(false)}
              onCancel={() => setModal2Open(false)}
            >
              <h2 className="textNoti">BẠN CÓ CHẮC CHẮN NỘP BÀI?</h2>
            </Modal>
          </div>
        </Col>
        <Col className="countDown" span={3}>
          <div>{countDown()}</div>
        </Col>
      </Row>
    </div>
  );
}

export default StartTest;
