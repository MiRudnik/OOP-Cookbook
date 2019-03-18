package Application.Controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MyTokenizer {

    public ArrayList<String> parse(String in) {
        StringTokenizer st = new StringTokenizer(in);
        ArrayList<String> parsed = new ArrayList<>();
        while(st.hasMoreTokens()) {
            parsed.add(st.nextToken());
        }
        return parsed;
    }
}

// simple method of parsing input
// https://docs.oracle.com/javase/8/docs/api/index.html?java/util/StringTokenizer.html