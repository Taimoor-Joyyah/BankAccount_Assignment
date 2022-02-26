public class Date {
    //class attributes initialization
    private int year;
    private int month;
    private int day;

    //class constructor
    public Date(int day, int month, int year) {
        if(year >= 1970)
            this.year = year;
        if(month <= 12)
            this.month = month;
        if(day <= 31)
            this.day = day;
    }

    //class getter and setter
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year >= 1970)
            this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month <= 12)
            this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(day <= 31)
            this.day = day;
    }

    //class display String
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
