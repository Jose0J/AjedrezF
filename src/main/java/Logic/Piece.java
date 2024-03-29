package Logic;

import Logic.Interface.Moveable;

public abstract class Piece implements Moveable, Cloneable {

    //Cuando la ficha es blanca la variable es true
    protected boolean color = true;
    //EL nombre es el mismo tipo de ficha
    protected String name = "";
    //Ubicacion en la matriz, eje x
    protected int ubicationX = 0;
    //Ubicacion en la matriz, eje x
    protected int ubicationY = 0;

    //Metodos Principales
    public boolean verifyRange(int corX, int corY){
        if(corX<9 && corX>0 && corY<9 && corY>0){
            return true;
        }
        return false;
    }

    //Getters
    public boolean getColor(){
        return color;
    }
    public String getName(){
        return name;
    }
    public int getUbicationX(){
        return ubicationX;
    }
    public int getUbicationY(){
        return ubicationY;
    }
    //Constructor
    public Piece(boolean color, String name, int ubicationX, int ubicationY) {
        this.color = color;
        this.name = name;
        this.ubicationX = ubicationX;
        this.ubicationY = ubicationY;

    }

    @Override
    public String toString() {
        return "Pieza seleccionada: "+this.getName()+"\nNueva ubicacion X: "+(char)(getUbicationX()+64)+" Y: "+getUbicationY();
    }

    
}