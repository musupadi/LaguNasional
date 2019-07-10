package com.destiny.lagunasionalindonesia.Model;

import com.destiny.lagunasionalindonesia.R;

import java.util.ArrayList;

public class QuizModel {
    public static String[][] data = new String[][]{
            {"1",
                    "Soal 1",
                    "A",
                    "A.Pigand A 1 Jawaban A",
                    "B.Pigand B 1",
                    "C.Pigand C 1",
                    "D.Pigand D 1",
            },
            {"2",
                    "Soal 2",
                    "B",
                    "A.Pigand A 2",
                    "B.Pigand B 2 jawaban B",
                    "C.Pigand C 2",
                    "D.Pigand D 2",
            },
    };
    public static ArrayList<Models> getListData(){
        Models models = null;
        ArrayList<Models> list = new ArrayList<>();
        for (String[] aData : data) {
            models = new Models();
            models.setNo(aData[0]);
            models.setSoal(aData[1]);
            models.setJawaban(aData[2]);
            models.setJawabana(aData[3]);
            models.setJawabanb(aData[4]);
            models.setJawabanc(aData[5]);
            models.setJawaband(aData[6]);
            list.add(models);
        }
        return list;
    }
}
