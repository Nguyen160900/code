package com.example.driver_license_test.config.utils;

import com.example.driver_license_test.config.contant.Constant;

public class NumberQuestion {
    private NumberQuestion() {
    }

    public static int getNumberQuestion(String levelName) {
        int number = 0;
        switch (levelName) {
            case "A1":
            case "a1":
                number = Constant.NUMBER_QUESTION_A1;
                break;
            case "A2":
            case "A3":
            case "A4":
            case "a2":
            case "a3":
            case "a4":
                number = Constant.NUMBER_QUESTION_A2_A3_A4;
                break;
            case "B1":
            case "b1":
                number = Constant.NUMBER_QUESTION_B1;
                break;
            case "B2":
            case "b2":
                number = Constant.NUMBER_QUESTION_B2;
                break;
            case "C":
            case "c":
                number = Constant.NUMBER_QUESTION_C;
                break;
            case "D":
            case "E":
            case "F":
            case "d":
            case "e":
            case "f":
                number = Constant.NUMBER_QUESTION_D_E_F;
                break;
        }
        return number;
    }

    public static int getNumberQuestionPass(String levelName) {
        int number = 0;
        switch (levelName) {
            case "A1":
            case "a1":
                number = Constant.NUMBER_QUESTION_PASS_A1;
                break;
            case "A2":
            case "A3":
            case "A4":
            case "a2":
            case "a3":
            case "a4":
                number = Constant.NUMBER_QUESTION_PASS_A2_A3_A4;
                break;
            case "B1":
            case "b1":
                number = Constant.NUMBER_QUESTION_PASS_B1;
                break;
            case "B2":
            case "b2":
                number = Constant.NUMBER_QUESTION_PASS_B2;
                break;
            case "C":
            case "c":
                number = Constant.NUMBER_QUESTION_PASS_C;
                break;
            case "D":
            case "E":
            case "F":
            case "d":
            case "e":
            case "f":
                number = Constant.NUMBER_QUESTION_PASS_D_E_F;
                break;
        }
        return number;
    }
}
