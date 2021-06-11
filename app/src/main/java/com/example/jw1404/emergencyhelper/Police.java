package com.example.jw1404.emergencyhelper;

/**
 * Created by jw140 on 2018-03-01.
 */

public class Police {
    String policename;
    String policenumber;
    String policeplace;

    public Police(String policename, String policenumber, String policeplace) {
        this.policename = policename;
        this.policenumber = policenumber;
        this.policeplace = policeplace;
    }

    public String getPolicename() {
        return policename;
    }

    public void setPolicename(String policename) {
        this.policename = policename;
    }

    public String getPolicenumber() {
        return policenumber;
    }

    public void setPolicenumber(String policenumber) {
        this.policenumber = policenumber;
    }

    public String getPoliceplace() {
        return policeplace;
    }

    public void setPoliceplace(String policeplace) {
        this.policeplace = policeplace;
    }
}
