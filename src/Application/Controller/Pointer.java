package Application.Controller;

import Application.Model.Cookbook;
import Application.Model.CookbookList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pointer {

    private Object currentContext;      // - what app should do
    private Object previousContext;     // - saves the previous context
    public IChosenCommands currentControls;     // - what controller should be used
    public MyTokenizer parser;
    private CookbookList cookbookList;

    public Pointer(){
        this.currentContext = null;
        this.previousContext = null;
        this.currentControls = new GeneralController(this);
        this.parser = new MyTokenizer();
        this.cookbookList = new CookbookList();
    }

    public void setCurrentContext(Object currentContext) {
        this.previousContext = currentContext;
        this.currentContext = currentContext;
        if(currentContext == null){
            currentControls = new GeneralController(this);
        }
        else if (currentContext instanceof Cookbook){
            currentControls = new CookbookController(this);
        }
        else currentControls = new RecipeController(this);

    }

    public void setPreviousContext(Object previousContext) {
        this.previousContext = previousContext;
    }

    public Object getCurrentContext() {
        return currentContext;
    }

    public Object getPreviousContext() {
        return previousContext;
    }

    public CookbookList getCookbookList() {
        return cookbookList;
    }

    public void setCookbookList(CookbookList cookbookList) {
        this.cookbookList = cookbookList;
    }
}
