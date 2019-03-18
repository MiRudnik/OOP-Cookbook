package Application.Model;

import java.io.Serializable;

public enum Unit implements Serializable{
    g("g"),
    dag("dag"),
    kg("kg"),
    ml("ml"),
    l("l"),
    cups("cups"),
    Tbsps("Tbsps"),
    tsps("tsps");


    private String text;

    Unit(String text){
        this.text=text;
    }

    public String getText() {
        return this.text;
    }

    public static Unit fromString(String text) {
        for (Unit u : Unit.values()) {
            if (u.text.equalsIgnoreCase(text)) {
                return u;
            }
        }
        return null;
    }
}

