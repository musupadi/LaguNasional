package com.destiny.lagunasionalindonesia.Model;


import java.util.ArrayList;

public class DataModelWajib {
    public static String[][] data = new String[][]{
            {"Indonesia Raya",
                    "W.R Supratman",
                    "Indonesia tanah airku\n" +
                            "Tanah tumpah darahku\n" +
                            "Disanalah aku berdiri\n" +
                            "Jadi pandu ibuku.\n" +
                            "\n" +
                            "Indonesia kebangsaanku\n" +
                            "Bangsa dan Tanah Airku\n" +
                            "Marilah kita berseru\n" +
                            "Indonesia bersatu\n" +
                            "\n" +
                            "Hiduplah tanahku\n" +
                            "Hiduplah negriku\n" +
                            "Bangsaku Rakyatku semuanya\n" +
                            "Bangunlah jiwanya\n" +
                            "Bangunlah badannya\n" +
                            "Untuk Indonesia Raya\n" +
                            "\n" +
                            "Indonesia Raya\n" +
                            "Merdeka Merdeka\n" +
                            "Tanahku negriku yang kucinta\n" +
                            "\n" +
                            "Indonesia Raya\n" +
                            "Merdeka Merdeka\n" +
                            "Hiduplah Indonesia Raya\n" +
                            "\n" +
                            "Indonesia Raya\n" +
                            "Merdeka! Merdeka!\n" +
                            "Tanahku negriku yang kucinta",
                    "",
                    "1"
            },
            {"Tanah Airku",
                    "Ibu Soed",
                    "Tanah airku tidak kulupakan\n" +
                            "Kan terkenang selama hidupku\n" +
                            "Biarpun saya pergi jauh\n" +
                            "Tidak kan hilang dari kalbu\n" +
                            "Tanah ku yang kucintai\n" +
                            "Engkau kuhargai\n" +
                            "\n" +
                            "Walaupun banyak negri kujalani\n" +
                            "Yang masyhur permai dikata orang\n" +
                            "Tetapi kampung dan rumahku\n" +
                            "Di sanalah kurasa senang\n" +
                            "Tanahku tak kulupakan\n" +
                            "Engkau kubanggakan",
                    "",
                    "2"
            },
    };
    public static ArrayList<Models> getListData(){
        Models models = null;
        ArrayList<Models> list = new ArrayList<>();
        for (String[] aData : data) {
            models = new Models();
            models.setJudul(aData[0]);
            models.setPencipta(aData[1]);
            models.setLirik(aData[2]);
            models.setAsal(aData[3]);
            models.setLagu(aData[4]);
            list.add(models);
        }
        return list;
    }
}
