package Day17Task2;

public class Task17_2 {
    public static void main(String[] args) {

        ChessBoard chessBoard = new ChessBoard(new ChessPiece2[][]{
                {ChessPiece2.ROOK_BLACK, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.ROOK_BLACK, ChessPiece2.KING_BLACK, ChessPiece2.EMPTY},
                {ChessPiece2.EMPTY, ChessPiece2.ROOK_WHITE, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.PAWN_BLACK, ChessPiece2.PAWN_BLACK, ChessPiece2.EMPTY, ChessPiece2.PAWN_BLACK},
                {ChessPiece2.PAWN_BLACK, ChessPiece2.EMPTY, ChessPiece2.KNIGHT_BLACK, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.PAWN_BLACK, ChessPiece2.EMPTY},
                {ChessPiece2.QUEEN_BLACK, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.BISHOP_WHITE, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY},
                {ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.BISHOP_BLACK, ChessPiece2.PAWN_WHITE, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY},
                {ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.BISHOP_WHITE, ChessPiece2.PAWN_WHITE, ChessPiece2.EMPTY, ChessPiece2.EMPTY},
                {ChessPiece2.PAWN_WHITE, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.QUEEN_WHITE, ChessPiece2.EMPTY, ChessPiece2.PAWN_WHITE, ChessPiece2.EMPTY, ChessPiece2.PAWN_WHITE},
                {ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.EMPTY, ChessPiece2.ROOK_WHITE, ChessPiece2.KING_WHITE, ChessPiece2.EMPTY},
        });

        chessBoard.print();

    }
}
