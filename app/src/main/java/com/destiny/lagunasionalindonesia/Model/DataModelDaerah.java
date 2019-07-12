package com.destiny.lagunasionalindonesia.Model;

import com.destiny.lagunasionalindonesia.R;

import java.util.ArrayList;

public class DataModelDaerah {
    public static String[][] data = new String[][]{
            {"Ambo Logo",
                    "Sulawesi Selatan",
                    "Duabulu' samanna \n" +
                            "mattettongeng...indo' logo\n" +
                            "Duabulu' samanna \n" +
                            "mattettongeng...indo' logo\n" +
                            "\n" +
                            "Kegasisamanna \n" +
                            "rionroiallarionroi\n" +
                            "Palettu' sengereng\n" +
                            "\n" +
                            "Sengerengmusamanna \n" +
                            "pada bulu'... ambo' logo\n" +
                            "Sengerengmusamanna \n" +
                            "pada bulu'... ambo' logo\n" +
                            "\n" +
                            "Adammusamanna \n" +
                            "silappae... allasilappae\n" +
                            "Ruttungemmanengngi\n" +
                            "\n" +
                            "Buluesamanna\n" +
                            "Maruttuttona...indo' logo\n" +
                            "Buluesamanna\n" +
                            "Maruttuttona...indo' logo\n" +
                            "\n" +
                            "Tanetesamanna\n" +
                            "Leppatonaallaleppatona\n" +
                            "Natarouddani\n" +
                            "\n" +
                            "Muddanikkisamanna\n" +
                            "Appasekki... ambo' logo\n" +
                            "Muddanikkisamanna\n" +
                            "Appasekki... ambo' logo\n" +
                            "\n" +
                            "Lettugisamana\n" +
                            "Telettugi... allaTelettugi\n" +
                            "Ko mappasemmuki\n",
                    "",
                    String.valueOf(R.raw.tentangresma)
            },
            {"Ambon Manise",
                    "Maluku",
                    "Waktu hujan sore sore\n" +
                            "Kilat sambar pohonkenari\n" +
                            "E jojarodengmongare\n" +
                            "Mari dansa dan menari\n" +
                            "\n" +
                            "Pukultifa toto buang kata balimbing di kereta\n" +
                            "Nona dansadengantuanjangansindirnama beta\n" +
                            "\n" +
                            "E menarisambilgoyangbadane\n" +
                            "Menarilombopeganglensomanise\n" +
                            "Rasa ramaijanganpulangdulue\n",
                    "",
                    String.valueOf(R.raw.tentangresma)
            },
    };
    public static ArrayList<Models> getListData(){
        Models models = null;
        ArrayList<Models> list = new ArrayList<>();
        for (String[] aData : data) {
            models = new Models();
            models.setJudul(aData[0]);
            models.setPencipta(aData[1]);
            models.setAsal(aData[2]);
            models.setLirik(aData[3]);
            models.setLagu(aData[4]);
            list.add(models);
        }
        return list;
    }
}
