package Application.Model;

import java.io.*;
import java.util.ArrayList;

public class CookbookList implements Serializable{

    // made to serialize whole data into one file
    // only one exists

    public String name;
    public ArrayList<Cookbook> cookbooks;

    public CookbookList(ArrayList<Cookbook> cookbooks){
        this.name = "OnlyList";
        this.cookbooks = cookbooks;
    }

    public CookbookList(){
        this.name = "OnlyList";
        this.cookbooks = new ArrayList<Cookbook>();
    }

    public void setCookbooks(ArrayList<Cookbook> cookbooks) {
        this.cookbooks = cookbooks;
    }

    public void addCookbook(Cookbook cookbook) throws  CookbookAlreadyExistsException{
        if(cookbooks.contains(cookbook)) throw new CookbookAlreadyExistsException();
        else cookbooks.add(cookbook);
    }

    public void removeCookbook(int index){
        cookbooks.remove(index);
    }

    public ArrayList<Cookbook> getCookbooks() {
        return cookbooks;
    }

    public void serialize() throws IOException{
        FileOutputStream file = new FileOutputStream("Cookbooks.txt");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(this);
        out.close();
        file.close();
    }

    public static CookbookList deserialize() throws IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream("Cookbooks.txt");
        ObjectInputStream in = new ObjectInputStream(file);
        CookbookList cookbooks = (CookbookList) in.readObject();
        in.close();
        file.close();
        return cookbooks;
    }

}