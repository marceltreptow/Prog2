package gui.Test0506;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.script.Bindings;

public class PropertyBaseAdder {
    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();
    private DoubleProperty z = new SimpleDoubleProperty();

    public void setX(double x){
        this.x.set(x);

    }

    public double getX(){
        return x.get();

    }

    public DoubleProperty xProperty(){
        return x;

    }

    public void setY(double y){
        this.y.set(y);

    }

    public double getY(){
        return y.get();

    }

    public DoubleProperty yProperty(){
        return y;

    }

    public void setZ(double z){
        this.z.set(z);

    }

    public double getZ(){
        return z.get();

    }

    public DoubleProperty zProperty(){
        return z;

    }

    public PropertyBaseAdder(){
        z.bind(x.add(y));
        //z.bind(Bindings.add(x,y));

    }

    public static void main(String[] args) {
        PropertyBaseAdder propertyBaseAdder = new PropertyBaseAdder();
        propertyBaseAdder.zProperty().addListener((obs,o,n) -> System.out.println("new value for z: " + n));
        propertyBaseAdder.setX(2);
        propertyBaseAdder.setX(1);

    }

    public static void main1(String[] args) {
        DoubleProperty x = new SimpleDoubleProperty();
        DoubleProperty y = new SimpleDoubleProperty();

        y.bind(x);
        /*y.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldvalue, Number newvalue) {
                System.out.println("new value: " + newvalue);
            }
        });*/

        y.addListener((obs,oldValue, newValue) -> System.out.println("newvalue" + newValue));
        x.set(2);
        x.set(3);
    }
}