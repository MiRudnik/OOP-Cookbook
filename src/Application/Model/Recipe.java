package Application.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Recipe implements Comparator<Recipe>,Serializable{
    private String name;
    private ArrayList<Product> productList;
    private ArrayList<String> steps;
    private int timeNeeded;                     // - how much time is needed for dish to be ready [in minutes]

    public Recipe(String name, ArrayList<Product> productList, ArrayList<String> steps, int timeNeeded){
        this.name = name;
        this.productList = productList;
        this.steps = steps;
        this.timeNeeded = timeNeeded;
    }

    public Recipe(String name, int timeNeeded){
        this.name = name;
        this.productList = new ArrayList<Product>();
        this.steps = new ArrayList<String>();
        this.timeNeeded = timeNeeded;
    }

    public Recipe(String name){
        this.name = name;
        this.productList = new ArrayList<Product>();
        this.steps = new ArrayList<String>();
        this.timeNeeded = -1;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void addStep(String step){
        steps.add(step);
    }

    public void setTimeNeeded(int timeNeeded){
        this.timeNeeded = timeNeeded;
    }

    public void removeProductFromRecipe(int i){
        if (i < 0 || i >= productList.size()) throw new IndexOutOfBoundsException();
        else productList.remove(i);
    }

    public void removeStepFromRecipe(int i){
        if (i < 0 || i >= steps.size()) throw new IndexOutOfBoundsException();
        else steps.remove(i);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public int getTimeNeeded() {
        return timeNeeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return name.equals(recipe.name);
    }

    @Override
    public int compare(Recipe r1, Recipe r2) {
        return r1.name.compareTo(r2.name);
    }
}
