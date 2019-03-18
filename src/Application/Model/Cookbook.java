package Application.Model;

import java.io.Serializable;
import java.util.ArrayList;


public class Cookbook implements Serializable{

    private String name;
    private ArrayList<Recipe> recipeList;

    public Cookbook(String name, ArrayList<Recipe> recipeList){
        this.name = name;
        this.recipeList = recipeList;
    }

    public Cookbook(String name){
        this.name = name;
        this.recipeList = new ArrayList<Recipe>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecipeList(ArrayList<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public void addRecipe(Recipe recipe){
        recipeList.add(recipe);
    }

    public void removeRecipe(int index){
        recipeList.remove(index);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Cookbook cookbook = (Cookbook) o;
        return name.equals(cookbook.name);
    }

}
