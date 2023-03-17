import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Niveau {
    //Attributs de la classe niveau
     Planche plancheActuelle;
     Piece[] listePiecesActuelles;



    public Niveau(Piece[] pieces, Planche planche) {
        this.listePiecesActuelles = pieces;
        this.plancheActuelle = planche;
    }




//Fonction qui cree un objet planche et des pieces d'apres le fichier

    public static Niveau lireFichier(int numeroNiveau) throws IOException {

        try {

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
            Planche planche = null;


            fichierNiveau = new BufferedReader(new FileReader("src/" + nomNiveau));
            int compteur = 0;
            stringTemporaire = fichierNiveau.readLine();
            while (stringTemporaire != null) {

                if (stringTemporaire.contains("G")) {
                    planche = Planche.constuirePlanche(stringTemporaire);

                }
                else if (stringTemporaire.contains("P")) {
                    Piece pieceActuelle = Piece.construirePiece(stringTemporaire);
                    pieces[compteur] = pieceActuelle;
                    compteur++;
                }

                stringTemporaire = fichierNiveau.readLine();
            }

            return new Niveau(pieces, planche);

        } catch (FileNotFoundException e) {
            return null;
        }



    }


}


