package com.tinne.finalproject4.data;

import com.tinne.finalproject4.R;
import com.tinne.finalproject4.model.BusModel;

import java.util.ArrayList;

public class Data {

    public Data() {

    }

    public ArrayList<BusModel> getData(String Kemana, String Darimana, int image) {
        ArrayList<BusModel> busModelArrayList = new ArrayList<>();
        busModelArrayList.add(
                new BusModel(
                        "Sejahtera 21",
                        "S21",
                        R.drawable.bus1,
                        Darimana,
                        Kemana,
                        "18:00",
                        "14:00",
                        120000
                )
        );
        busModelArrayList.add(
                new BusModel(
                        "Sejahtera 23",
                        "S23",
                        R.drawable.bus2,
                        Darimana,
                        Kemana,
                        "17:00",
                        "10:00",
                        90000
                )
        );
        busModelArrayList.add(
                new BusModel(
                        "Sejahtera 27",
                        "S27",
                        R.drawable.bus3,
                        Darimana,
                        Kemana,
                        "20:00",
                        "12:00",
                        140000
                )
        );
        busModelArrayList.add(
                new BusModel(
                        "Sejahtera 29",
                        "S29",
                        R.drawable.bus4,
                        Darimana,
                        Kemana,
                        "18:00",
                        "17:00",
                        1200000
                )
        );
        return busModelArrayList;
    }


}

