package model;

public class Appointment {
    private int id;
    private String counsellor;
    private String date;
    private String time;
    private String reason;

    public Appointment() {}

    public Appointment(int id, String counsellor, String date, String time, String reason) {
        this.id = id;
        this.counsellor = counsellor;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCounsellor() { return counsellor; }
    public void setCounsellor(String counsellor) { this.counsellor = counsellor; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}

