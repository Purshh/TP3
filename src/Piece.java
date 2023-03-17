public class Piece {
    int[][] piece;


    public Piece(int[][] pieceConstruite) {
        this.piece = pieceConstruite;
    }
    public static Piece construirePiece(String piece){
        String[] pieceSplit = piece.split("\\|");
        int[][] pieceConstruite = new int[Integer.parseInt(String.valueOf(pieceSplit[1].charAt(0)))][Integer.parseInt(String.valueOf(pieceSplit[1].charAt(2)))];
        int indexTemporaire = 0;
        for (int i = 0;i<pieceConstruite.length;i++){
            for (int j =0; j<pieceConstruite[i].length;j++){
                pieceConstruite[i][j]=Integer.parseInt(String.valueOf(pieceSplit[2].charAt(indexTemporaire)));
                indexTemporaire++;
            }
        }


        return new Piece(pieceConstruite);
    }




}