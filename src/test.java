import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        try {
            int numeroNiveau =1;
            String nomNiveau = "niveau" + ("" + numeroNiveau) + ".txt";
            BufferedReader fichierNiveau = new BufferedReader(new FileReader("src/" + nomNiveau));
            String stringTemporaire = fichierNiveau.readLine();
            int nbPieces = 0;
            while (stringTemporaire != null) {
                if (stringTemporaire.contains("P")) {
                    nbPieces++;
                }
                stringTemporaire = fichierNiveau.readLine();
            }
            fichierNiveau.close();
            Piece[] pieces = new Piece[nbPieces];

            fichierNiveau = new BufferedReader(new FileReader("src/" + nomNiveau));
            int compteur = 0;
            stringTemporaire = fichierNiveau.readLine();
            while (stringTemporaire != null) {

                if (stringTemporaire.contains("G")) {
                    System.out.println(stringTemporaire);
                    Planche plancheActuelle = Planche.constuirePlanche(stringTemporaire);
                } else if (stringTemporaire.contains("P")) {
                    System.out.println(stringTemporaire);
                    Piece pieceActuelle = Piece.construirePiece(stringTemporaire);
                    pieces[compteur] = pieceActuelle;
                    compteur++;
                }

                stringTemporaire = fichierNiveau.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("lol");
        }


    }
}