package Logic;

public class Pawn extends Piece {


    public Pawn(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    public Pawn() {

    }



    @Override
    public void movePiece(int corX, int corY, Boolean color ) {
        int enterCordY = 0; //coordenada en Y a donde se movera el peon
        int enterCordX = 0; //coordenada en X a donde se movera el peon
        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (verifyMovement(corX ,corY ,color) == false) {
            System.out.println("Movimiento invalido");
            return;
        }
         specialMovement(corX , corY ,color);

        //si el peon es true(blanco) mueve abajo de lo contrario ( negro) mueve arriba
        if (color) {
            this.ubicationY = corY + enterCordY ;
        } else {
            this.ubicationY = corY - enterCordY;
        }
        //No devuelve el tablero ya que eso se hace en el identificador
    }

    public  boolean  verifyMovement(int cordX, int cordY, boolean color){
        Board board = new Board();
        //verifica que las nuevas posiciones  no muevan el peon abajo si es negro o arriba si es blanco
        if (color && cordY <=this.ubicationY || color == false && cordX >= this.ubicationY){
            return false;
        //verifica que cuando el peon esta en la ubicacion inicial no se mueva mas de 2 cuadros dependiendo su color
        }else if (color && ubicationY == 2 && cordY >4 || color ==false && ubicationY == 7 && cordY < 5) {
            return false;
        //verifica que la posicion a donde se quiere mover el peon este vacia , si no es asi no se movera
        } else if (  board.getBoard()[cordX][this.ubicationY +cordY] != null){
            return  false;
        }
        return  true;

    }



    public void specialMovement(int cordX, int cordY, boolean color) {

        //verifica si las posiciones dadas al escojer la pieza son las inciales y ejecuta el movimiento especial segun el color
        if (cordY == 2 && color == true) {
            this.ubicationY = cordY + 2;
        } else if (cordY == 7 && color == false)
            this.ubicationY = cordY - 2;
    }
    //No devuelve el tablero ya que eso se hace en el identificador



}