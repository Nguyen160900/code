import { Button } from "antd";
import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import "../css/Test.css";

function Test() {
  const [loadings, setLoadings] = useState([]);
  const navigate = useNavigate();
  const { id } = useParams();

  const enterLoading = (index) => {
    setLoadings((prevLoadings) => {
      const newLoadings = [...prevLoadings];
      newLoadings[index] = true;
      return newLoadings;
    });

    setTimeout(() => {
      setLoadings((prevLoadings) => {
        const newLoadings = [...prevLoadings];
        newLoadings[index] = false;
        navigate(`/home/test/start/${id}`);
        return newLoadings;
      });
    }, 1000);
  };

  return (
    <div>
      <div className="textView">
        <p>
          Cấu trúc bộ đề thi sát hạch giấy phép lái xe hạng A1 sẽ bao gồm{" "}
          <b>25 câu hỏi</b>, mỗi câu hỏi chỉ có{" "}
          <b>duy nhất 1 đáp trả lời đúng</b>. Khác hẳn với bộ đề thi luật cũ là
          2 đáp án. Mỗi đề thi chúng tôi sẽ bố trí từ{" "}
          <b>2 - 4 câu hỏi điểm liệt</b> để học viên có thể làm quen và ghi nhớ,
          tránh việc làm sai câu hỏi liệt.
        </p>
        <ul>
          <li>
            Số lượng câu hỏi: <b className="textShow">25 Câu</b>.
          </li>
          <li>
            Yêu cầu làm đúng <b className="textShow">21/25 Câu</b>.
          </li>
          <li>
            Thời gian: <b className="textShow">19 Phút</b>.
          </li>
        </ul>
        <p>
          <b className="textShow">Lưu ý đặc biệt:</b> Tuyệt đối không được làm
          sai câu hỏi điểm liệt, vì trong kỳ thi thật nếu học viên làm sai{" "}
          <b>"Câu Điểm Liệt"</b> đồng nghĩa với việc <b>"KHÔNG ĐẠT"</b> dù cho
          các câu khác trả lời đúng!
        </p>
        <Button
          type="primary"
          loading={loadings[0]}
          onClick={() => enterLoading(0)}
          className="btnTest"
        >
          BẮT ĐẦU THI
        </Button>
      </div>
    </div>
  );
}

export default Test;
