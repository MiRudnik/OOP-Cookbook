package Application.Model;

import java.io.Serializable;

public class Product implements Serializable{

    private String name;
    private float value;
    private Unit unit;

    public Product(String name, float value, Unit unit) throws IllegalValueException{
        this.name = name;
        if(value <= 0) throw new IllegalValueException();
        this.value = value;
        this.unit = unit;
    }

    public Product(String name, int value) throws IllegalValueException{
        this.name = name;
        if(value <= 0) throw new IllegalValueException();
        this.value = value;
        this.unit = null;
    }

    public Product(String name){
        this.name = name;
        this.value = -1;
        this.unit = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(float value) throws IllegalValueException{
        if(value < 0) throw new IllegalValueException();
        this.value = value;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

}
