package Day17Task2;

public class ChessBoard {
    ChessPiece2[][] chessPiece2;

    public ChessBoard(ChessPiece2[][] chessPiece2) {
        this.chessPiece2 = chessPiece2;
    }

    public void print(){
        for (int i = 0; i< chessPiece2.length; i++) {
            for (int j = 0; j < chessPiece2.length; j++) {
                System.out.print(chessPiece2[i][j].getRepresentationOfFigure());
            }
            System.out.println();
        }


    }
}
