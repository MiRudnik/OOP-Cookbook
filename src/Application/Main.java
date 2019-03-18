package Application;

import Application.Controller.Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        Pointer pointer = new Pointer();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = br.readLine();
                if (input.equals("quit") || input.equals("q") || input.equals("Q") || input.equals("QUIT")) return;
                ArrayList<String> commands = pointer.parser.parse(input);
                pointer.currentControls.getCommand(commands);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
