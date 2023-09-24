package models;

public class Words {
private String eng ;
private String az ;


public Words(String eng , String az){
    setEng(eng);
    setAz(az);
}

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng.trim().toLowerCase();
    }

    public String getAz() {
        return az;
    }

    public void setAz(String az) {
        this.az = az.trim().toLowerCase();
    }

    @Override
    public String toString() {
        return eng + ":" + az +"\n";
    }
}
