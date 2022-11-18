import React from "react";
import { Routes, Route } from "react-router-dom";
import Home from "../component/Home";
import Level from "../component/Level";
import Question from "../component/Question";
import Test from "../component/Test";
import Login from "../page/Login";

const RouterApp = () => {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/login" index element={<Login />} />
      <Route element={<Home />}>
        <Route path="/home" element={<Level />} />
        <Route path="/home/test/:id" element={<Test />} />
        <Route path="/home/test/start/:id" element={<Question />} />
      </Route>
    </Routes>
  );
};

export default RouterApp;
