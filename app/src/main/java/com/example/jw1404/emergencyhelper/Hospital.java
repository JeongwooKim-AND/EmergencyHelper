package com.example.jw1404.emergencyhelper;

/**
 * Created by jw140 on 2018-02-28.
 */

public class Hospital {
    String hospitalname;
    String hospitalnumber;
    String hospitalplace;

    public Hospital(String hospitalname, String hospitalnumber, String hospitalplace) {
        this.hospitalname = hospitalname;
        this.hospitalnumber = hospitalnumber;
        this.hospitalplace = hospitalplace;
    }


    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getHospitalnumber() {
        return hospitalnumber;
    }

    public void setHospitalnumber(String hospitalnumber) {
        this.hospitalnumber = hospitalnumber;
    }

    public String getHospitalplace() {
        return hospitalplace;
    }

    public void setHospitalplace(String hospitalplace) {
        this.hospitalplace = hospitalplace;
    }
}


