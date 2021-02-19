package ui;

import org.json.JSONObject;
import persistence.Writable;

public class TimeSlot implements Writable {
    private boolean eightHalf; // 0800-0830
    private boolean halfNine; // 0830-0900
    private boolean nineHalf; // 0900-0930
    private boolean halfTen; // 0930-1000
    private boolean tenHalf; // 1000-1030
    private boolean halfEleven; // 1030-1100
    private boolean elevenHalf; // 1100-1130
    private boolean halfTwelve; // 1130-1200
    private boolean twelveHalf; // 1200-1230
    private boolean halfThirteen; // 1230-1300
    private boolean thirteenHalf; // 1300-1330
    private boolean halfFourteen; // 1330-1400
    private boolean fourteenHalf; // 1400-1430
    private boolean halfFifteen; // 1430-1500
    private boolean fifteenHalf; // 1500-1530
    private boolean halfSixteen; // 1530-1600
    private boolean sixteenHalf; // 1600-1630
    private boolean halfSeventeen; // 1630-1700
    private boolean seventeenHalf; // 1700-1730
    private boolean halfEighteen; // 1730-1800
//    private boolean eighteenHalf; // 1800-1830
//    private boolean halfNineteen; // 1830-1900
//    private boolean nineteenHalf; // 1900-1930


    // EFFECTS: set up all the time slots, false represent not available at this time slot
    public TimeSlot() {
        eightHalf = false; // 0800-0830
        halfNine = false; // 0830-0900
        nineHalf = false; // 0900-0930
        halfTen = false; // 0930-1000
        tenHalf = false; // 1000-1030
        halfEleven = false; // 1030-1100
        elevenHalf = false; // 1100-1130
        halfTwelve = false; // 1130-1200
        twelveHalf = false; // 1200-1230
        halfThirteen = false; // 1230-1300
        thirteenHalf = false; // 1300-1330
        halfFourteen = false; // 1330-1400
        fourteenHalf = false; // 1400-1430
        halfFifteen = false; // 1430-1500
        fifteenHalf = false; // 1500-1530
        halfSixteen = false; // 1530-1600
        sixteenHalf = false; // 1600-1630
        halfSeventeen = false; // 1630-1700
        seventeenHalf = false; // 1700-1730
        halfEighteen = false; // 1730-1800
//        eighteenHalf = false; // 1800-1830
//        halfNineteen = false; // 1830-1900
    }


    // MODIFIES: this
    // EFFECTS: set the time slot according to the given availability
    public void setTimeSlot(boolean eightHalf, boolean halfNine, boolean nineHalf, boolean halfTen, boolean tenHalf,
                            boolean halfEleven, boolean elevenHalf, boolean halfTwelve, boolean twelveHalf,
                            boolean halfThirteen, boolean thirteenHalf, boolean halfFourteen, boolean fourteenHalf,
                            boolean halfFifteen, boolean fifteenHalf, boolean halfSixteen, boolean sixteenHalf,
                            boolean halfSeventeen, boolean seventeenHalf, boolean halfEighteen) {
        this.eightHalf = eightHalf;
        this.halfNine = halfNine;
        this.nineHalf = nineHalf;
        this.halfTen = halfTen;
        this.tenHalf = tenHalf;
        this.halfEleven = halfEleven;
        this.elevenHalf = elevenHalf;
        this.halfTwelve = halfTwelve;
        this.twelveHalf = twelveHalf;
        this.halfThirteen = halfThirteen;
        this.thirteenHalf = thirteenHalf;
        this.halfFourteen = halfFourteen;
        this.fourteenHalf = fourteenHalf;
        this.halfFifteen = halfFifteen;
        this.fifteenHalf = fifteenHalf;
        this.halfSixteen = halfSixteen;
        this.sixteenHalf = sixteenHalf;
        this.halfSeventeen = halfSeventeen;
        this.seventeenHalf = seventeenHalf;
        this.halfEighteen = halfEighteen;
    }


    // REQUIRES: the main time slot must have at least one available time interval
    // EFFECTS: return true if this time slot covers all the given slots, 8:00-10:00.
    public boolean contain(TimeSlot timeslot) {
        boolean eightHalf = true;
        boolean halfNine = true;
        boolean nineHalf = true;
        boolean halfTen = true;
        boolean result;

        if (timeslot.getEightHalf()) {
            eightHalf = this.eightHalf;
        }
        if (timeslot.getHalfNine()) {
            halfNine = this.halfNine;
        }
        if (timeslot.getNineHalf()) {
            nineHalf = this.nineHalf;
        }
        if (timeslot.getHalfTen()) {
            halfTen = this.halfTen;
        }

        result = eightHalf && halfNine && nineHalf && halfTen && containHelper1(timeslot)
                && containHelper2(timeslot) && containHelper3(timeslot) && containHelper4(timeslot);
        return result;
    }


    // EFFECTS: contain helper1 due to line limit in each method, 10:00-12:00.
    public boolean containHelper1(TimeSlot timeslot) {
        boolean tenHalf = true;
        boolean halfEleven = true;
        boolean elevenHalf = true;
        boolean halfTwelve = true;
        boolean result;

        if (timeslot.getTenHalf()) {
            tenHalf = this.tenHalf;
        }
        if (timeslot.getHalfEleven()) {
            halfEleven = this.halfEleven;
        }
        if (timeslot.getElevenHalf()) {
            elevenHalf = this.elevenHalf;
        }
        if (timeslot.getHalfTwelve()) {
            halfTwelve = this.halfTwelve;
        }

        result = tenHalf && halfEleven && elevenHalf && halfTwelve;
        return result;
    }

    // EFFECTS: contain helper2 due to line limit in each method, 12:00-14:00.
    public boolean containHelper2(TimeSlot timeslot) {
        boolean twelveHalf = true;
        boolean halfThirteen = true;
        boolean thirteenHalf = true;
        boolean halfFourteen = true;
        boolean result;

        if (timeslot.getTwelveHalf()) {
            twelveHalf = this.twelveHalf;
        }
        if (timeslot.getHalfThirteen()) {
            halfThirteen = this.halfThirteen;
        }
        if (timeslot.getThirteenHalf()) {
            thirteenHalf = this.thirteenHalf;
        }
        if (timeslot.getHalfFourteen()) {
            halfFourteen = this.halfFourteen;
        }

        result = twelveHalf && halfThirteen && thirteenHalf && halfFourteen;
        return result;
    }

    // EFFECTS: contain helper2 due to line limit in each method, 14:00-16:00.
    public boolean containHelper3(TimeSlot timeslot) {
        boolean fourteenHalf = true;
        boolean halfFifteen = true;
        boolean fifteenHalf = true;
        boolean halfSixteen = true;
        boolean result;

        if (timeslot.getFourteenHalf()) {
            fourteenHalf = this.fourteenHalf;
        }
        if (timeslot.getHalfFifteen()) {
            halfFifteen = this.halfFifteen;
        }
        if (timeslot.getFifteenHalf()) {
            fifteenHalf = this.fifteenHalf;
        }
        if (timeslot.getHalfSixteen()) {
            halfSixteen = this.halfSixteen;
        }

        result = fourteenHalf && halfFifteen && fifteenHalf && halfSixteen;
        return result;
    }


    // EFFECTS: contain helper2 due to line limit in each method, 16:00-18:00.
    public boolean containHelper4(TimeSlot timeslot) {
        boolean sixteenHalf = true;
        boolean halfSeventeen = true;
        boolean seventeenHalf = true;
        boolean halfEighteen = true;
        boolean result;

        if (timeslot.getSixteenHalf()) {
            sixteenHalf = this.sixteenHalf;
        }
        if (timeslot.getHalfSeventeen()) {
            halfSeventeen = this.halfSeventeen;
        }
        if (timeslot.getSeventeenHalf()) {
            seventeenHalf = this.seventeenHalf;
        }
        if (timeslot.getHalfEighteen()) {
            halfEighteen = this.halfEighteen;
        }

        result = sixteenHalf && halfSeventeen && seventeenHalf && halfEighteen;
        return result;
    }


    // EFFECTS: set this timeslot to be unavailable whenever the given timeslot is available, 8:00-16:00.
    public void turnOffTimeSlot(TimeSlot timeslot) {
        if (timeslot.getEightHalf()) {
            eightHalf = false;
        }
        if (timeslot.getHalfNine()) {
            halfNine = false;
        }
        if (timeslot.getNineHalf()) {
            nineHalf = false;
        }
        if (timeslot.getHalfTen()) {
            halfTen = false;
        }
        if (timeslot.getTenHalf()) {
            tenHalf = false;
        }
        if (timeslot.getHalfEleven()) {
            halfEleven = false;
        }
        if (timeslot.getElevenHalf()) {
            elevenHalf = false;
        }
        if (timeslot.getHalfTwelve()) {
            halfTwelve = false;
        }
        if (timeslot.getTwelveHalf()) {
            twelveHalf = false;
        }
        if (timeslot.getHalfThirteen()) {
            halfThirteen = false;
        }
        if (timeslot.getThirteenHalf()) {
            thirteenHalf = false;
        }
        if (timeslot.getHalfFourteen()) {
            halfFourteen = false;
        }
        if (timeslot.getFourteenHalf()) {
            fourteenHalf = false;
        }
        if (timeslot.getHalfFifteen()) {
            halfFifteen = false;
        }
        if (timeslot.getFifteenHalf()) {
            fifteenHalf = false;
        }
        if (timeslot.getHalfSixteen()) {
            halfSixteen = false;
        }
        if (timeslot.getSixteenHalf()) {
            sixteenHalf = false;
        }
        if (timeslot.getHalfSeventeen()) {
            halfSeventeen = false;
        }
        if (timeslot.getSeventeenHalf()) {
            seventeenHalf = false;
        }
        if (timeslot.getHalfEighteen()) {
            halfEighteen = false;
        }
    }


    // EFFECTS: count the total time in this timeslot
    public double countTime() {
        double time = 0;
        if (eightHalf) {
            time = time + 0.5;
        }
        if (halfNine) {
            time = time + 0.5;
        }
        if (nineHalf) {
            time = time + 0.5;
        }
        if (halfTen) {
            time = time + 0.5;
        }
        if (tenHalf) {
            time = time + 0.5;
        }
        if (halfEleven) {
            time = time + 0.5;
        }
        if (elevenHalf) {
            time = time + 0.5;
        }
        if (halfTwelve) {
            time = time + 0.5;
        }
        if (twelveHalf) {
            time = time + 0.5;
        }
        if (halfThirteen) {
            time = time + 0.5;
        }
        if (thirteenHalf) {
            time = time + 0.5;
        }
        if (halfFourteen) {
            time = time + 0.5;
        }
        if (fourteenHalf) {
            time = time + 0.5;
        }
        if (halfFifteen) {
            time = time + 0.5;
        }
        if (fifteenHalf) {
            time = time + 0.5;
        }
        if (halfSixteen) {
            time = time + 0.5;
        }
        if (sixteenHalf) {
            time = time + 0.5;
        }
        if (halfSeventeen) {
            time = time + 0.5;
        }
        if (seventeenHalf) {
            time = time + 0.5;
        }
        if (halfEighteen) {
            time = time + 0.5;
        }

        return time;
    }


//    // EFFECTS: print out the time slot for test purpose
//    public void printTimeSlot() {
//        System.out.println(eightHalf);
//        System.out.println(halfNine);
//        System.out.println(nineHalf);
//        System.out.println(halfTen);
//        System.out.println(tenHalf);
//        System.out.println(halfEleven);
//        System.out.println(elevenHalf);
//        System.out.println(halfTwelve);
//    }


    // EFFECTS: convert timeslot to JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("8:00 - 8:30", eightHalf);
        json.put("8:30 - 9:00", halfNine);
        json.put("9:00 - 9:30", nineHalf);
        json.put("9:30 - 10:00", halfTen);

        json.put("10:00 - 10:30", tenHalf);
        json.put("10:30 - 11:00", halfEleven);
        json.put("11:00 - 11:30", elevenHalf);
        json.put("11:30 - 12:00", halfTwelve);

        json.put("12:00 - 12:30", twelveHalf);
        json.put("12:30 - 13:00", halfThirteen);
        json.put("13:00 - 13:30", thirteenHalf);
        json.put("13:30 - 14:00", halfFourteen);

        json.put("14:00 - 14:30", fourteenHalf);
        json.put("14:30 - 15:00", halfFifteen);
        json.put("15:00 - 15:30", fifteenHalf);
        json.put("15:30 - 16:00", halfSixteen);

        json.put("16:00 - 16:30", sixteenHalf);
        json.put("16:30 - 17:00", halfSeventeen);
        json.put("17:00 - 17:30", seventeenHalf);
        json.put("17:30 - 18:00", halfEighteen);

        return json;
    }


    public boolean getEightHalf() {
        return eightHalf;
    }


    public boolean getHalfNine() {
        return halfNine;
    }


    public boolean getNineHalf() {
        return nineHalf;
    }


    public boolean getHalfTen() {
        return halfTen;
    }


    public boolean getTenHalf() {
        return tenHalf;
    }


    public boolean getHalfEleven() {
        return halfEleven;
    }


    public boolean getElevenHalf() {
        return elevenHalf;
    }


    public boolean getHalfTwelve() {
        return halfTwelve;
    }


    public boolean getTwelveHalf() {
        return twelveHalf;
    }


    public boolean getHalfThirteen() {
        return halfThirteen;
    }


    public boolean getThirteenHalf() {
        return thirteenHalf;
    }


    public boolean getHalfFourteen() {
        return halfFourteen;
    }


    public boolean getFourteenHalf() {
        return fourteenHalf;
    }


    public boolean getHalfFifteen() {
        return halfFifteen;
    }


    public boolean getFifteenHalf() {
        return fifteenHalf;
    }


    public boolean getHalfSixteen() {
        return halfSixteen;
    }


    public boolean getSixteenHalf() {
        return sixteenHalf;
    }


    public boolean getHalfSeventeen() {
        return halfSeventeen;
    }


    public boolean getSeventeenHalf() {
        return seventeenHalf;
    }


    public boolean getHalfEighteen() {
        return halfEighteen;
    }


    // EFFECTS: set 8:00 - 8:30 to be available
    public void setEightHalf() {
        this.eightHalf = true;
    }


    // EFFECTS: set 8:30 - 9:00 to be available
    public void setHalfNine() {
        this.halfNine = true;
    }


    // EFFECTS: set 9:00 - 9:30 to be available
    public void setNineHalf() {
        this.nineHalf = true;
    }


    // EFFECTS: set 9:30 - 10:00 to be available
    public void setHalfTen() {
        this.halfTen = true;
    }

    // EFFECTS: set 10:00 - 10:30 to be available
    public void setTenHalf() {
        this.tenHalf = true;
    }


    // EFFECTS: set 10:30 - 11:00 to be available
    public void setHalfEleven() {
        this.halfEleven = true;
    }


    // EFFECTS: set 11:00 - 11:30 to be available
    public void setElevenHalf() {
        this.elevenHalf = true;
    }


    // EFFECTS: set 11:30 - 12:00 to be available
    public void setHalfTwelve() {
        this.halfTwelve = true;
    }

    // EFFECTS: set 12:00 - 12:30 to be available
    public void setTwelveHalf() {
        this.twelveHalf = true;
    }


    // EFFECTS: set 12:30 - 13:00 to be available
    public void setHalfThirteen() {
        this.halfThirteen = true;
    }


    // EFFECTS: set 13:00 - 13:30 to be available
    public void setThirteenHalf() {
        this.thirteenHalf = true;
    }


    // EFFECTS: set 13:30 - 14:00 to be available
    public void setHalfFourteen() {
        this.halfFourteen = true;
    }


    // EFFECTS: set 14:00 - 14:30 to be available
    public void setFourteenHalf() {
        this.fourteenHalf = true;
    }


    // EFFECTS: set 14:30 - 15:00 to be available
    public void setHalfFifteen() {
        this.halfFifteen = true;
    }


    // EFFECTS: set 15:00 - 15:30 to be available
    public void setFifteenHalf() {
        this.fifteenHalf = true;
    }


    // EFFECTS: set 15:30 - 16:00 to be available
    public void setHalfSixteen() {
        this.halfSixteen = true;
    }


    // EFFECTS: set 16:00 - 16:30 to be available
    public void setSixteenHalf() {
        this.sixteenHalf = true;
    }


    // EFFECTS: set 16:30 - 17:00 to be available
    public void setHalfSeventeen() {
        this.halfSeventeen = true;
    }


    // EFFECTS: set 17:00 - 17:30 to be available
    public void setSeventeenHalf() {
        this.seventeenHalf = true;
    }


    // EFFECTS: set 17:30 - 18:00 to be available
    public void setHalfEighteen() {
        this.halfEighteen = true;
    }

}

