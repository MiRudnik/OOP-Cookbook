package Application.Controller;

import Application.Model.Cookbook;
import Application.Model.CookbookAlreadyExistsException;
import Application.Model.CookbookList;
import Application.View.*;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class GeneralController implements IChosenCommands{

    protected Pointer pointer;

    GeneralController(Pointer pointer){
        this.pointer = pointer;
    }

    @Override
    public void getCommand(ArrayList<String> commands){
            // General commands start with upper case letter
        if(Character.isUpperCase(commands.get(0).charAt(0))){
            doGeneralCommand(commands);
        }
        else{
            doSpecifiedCommand(commands);
        }
    }


    private void doGeneralCommand(ArrayList<String> commands){
        switch(commands.get(0)){
            case "HELP": {
                printHelp();
                break;
            }
            case "BOOKS": {
                printCookbooks();
                pointer.setPreviousContext(pointer.getCurrentContext());
                pointer.setCurrentContext(null);
                break;
            }
            case "WHEREAMI": {
                getLocation();
                break;
            }
            case "SAVE":{
                saveBooks();
                break;
            }
            case "LOAD": {
                loadBooks();
                break;
            }
            default: {
                System.out.println("Wrong command.\nType HELP for list of commands");
            }
        }
    }

    protected void doSpecifiedCommand(ArrayList<String> commands){
        switch(commands.get(0)) {
            case "addBook": {
                addCookbook(commands);
                break;
            }
            case "deleteBook": {
                deleteCookbook(commands);
                break;
            }
            case "openBook": {
                openBook(commands);
                break;
            }
            default: {
                System.out.println("Wrong command.\nType HELP for list of commands");
            }
        }
    }

    protected void printHelp(){
        ProgramViews programViewer = new ProgramViews();
        programViewer.showGeneralHelp();
        programViewer.showCookbookListHelp();
    }

    private void printCookbooks(){
        BasicViews basicViewer = new BasicViews();
        basicViewer.showCookbookList(pointer.getCookbookList());
        pointer.setCurrentContext(null);
    }

    private void getLocation(){
        Object context = pointer.getCurrentContext();
        if(context == null){
            System.out.println("List of cookbooks");
        }
        else if (context instanceof Cookbook){
            System.out.println("Cookbook");
        }
        else System.out.println("Recipe");
    }

    private void saveBooks() {
        try{
            pointer.getCookbookList().serialize();
            System.out.println("Books successfully saved.");
        }
        catch (IOException e){
            System.out.println("In/Out error.");
        }
    }

    private void loadBooks() {
        try{
            CookbookList cookbookList = CookbookList.deserialize();
            pointer.setCookbookList(cookbookList);
        }
        catch (ClassNotFoundException e){
            System.out.println("File doesn't exist.");
        }
        catch (IOException e){
            System.out.println("In/Out error.");
        }
    }

    private void addCookbook(ArrayList<String> commands){
        try{
            String name = commands.get(1);
            pointer.getCookbookList().addCookbook(new Cookbook(name));
        }
        catch (CookbookAlreadyExistsException e){
            System.out.println("This name is already taken.");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Name not provided.");
        }
    }

    private void deleteCookbook(ArrayList<String> commands){
        try {
            int index = parseInt(commands.get(1));
            index = index - 1;
            pointer.getCookbookList().removeCookbook(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Index not provided.");
        }
    }

    private void openBook(ArrayList<String> commands){
        try {
            int index = parseInt(commands.get(1));
            index = index - 1;
            Cookbook context = pointer.getCookbookList().getCookbooks().get(index);
            pointer.setCurrentContext(context);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Index not provided.");
        }
    }
}
