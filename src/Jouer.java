import java.io.IOException;
import java.util.Scanner;

public class Jouer {

    //Code pour manipuler la classe niveau, donc jouer

    
    public static void commencerPartie() throws IOException {

        final String AINSI_GREEN ="\u001B[32m";
        int compteurNiveau = 1;
        while(true){
            Niveau niveauActuel = Niveau.lireFichier(compteurNiveau);
            //call

            if (niveauActuel==null){
                System.out.println(AINSI_GREEN+"Bravo, vous avez fini le jeu!!!!");
                //plus de fichiers valides donc fini le jeu
                break;
            }
            else{
                jouerNiveauActuel(niveauActuel,compteurNiveau);

            }

            compteurNiveau++;
        }
    }
    public static void afficherLignePlanche(Niveau niveauActuel,int ligneActuelle) {
        final String AINSI_RED ="\u001B[31m";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        //Rembourer la planche
        if (ligneActuelle==0){
            System.out.print(" ");
            for (int i = 0;i<niveauActuel.plancheActuelle.planche[0].length+2;i++){
                System.out.print(AINSI_RED+"█");
            }
            System.out.print("\tPièces à placer:");
            System.out.println();
        }
        if (ligneActuelle==niveauActuel.plancheActuelle.planche.length){
            System.out.print(" ");
            for (int i = 0;i<niveauActuel.plancheActuelle.planche[0].length+2;i++){
                System.out.print(AINSI_RED+ "█");
            }

            System.out.println();
            return;
        }

        System.out.print(AINSI_RED+""+(ligneActuelle+1));
        System.out.print("█");
        for (int i = 0;i<niveauActuel.plancheActuelle.planche[0].length;i++){

            if(niveauActuel.plancheActuelle.planche[ligneActuelle][i]==1){
                System.out.print("█");
            }
            else if(niveauActuel.plancheActuelle.planche[ligneActuelle][i]==0){
                System.out.print("░");
            }
            else if (niveauActuel.plancheActuelle.planche[ligneActuelle][i]!=0&&niveauActuel.plancheActuelle.planche[ligneActuelle][i]!=1) {
                System.out.print(""+alphabet.charAt((niveauActuel.plancheActuelle.planche[ligneActuelle][i])-1));
            }

        }
        System.out.print("█");
        System.out.print("\t");
        //print
    }
    public static void afficherLignePiece(Niveau niveauActuel,int ligneActuelle){
        final String AINSI_CYAN ="\u001B[36m";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

            for (int i = 0; i < niveauActuel.listePiecesActuelles.length; i++) {
                try {
                    for (int h = 0; h < niveauActuel.listePiecesActuelles[i].piece[ligneActuelle].length; h++) {
                        if (niveauActuel.listePiecesActuelles[i].piece[ligneActuelle][h] == 1) {
                            System.out.print(AINSI_CYAN + "" + alphabet.charAt(25 - i));
                        } else if (niveauActuel.listePiecesActuelles[i].piece[ligneActuelle][h] == 0) {
                            System.out.print(AINSI_CYAN + "░");
                        }
                        else if (niveauActuel.listePiecesActuelles[i].piece[ligneActuelle][h] == 2) {
                            System.out.print(AINSI_CYAN + " ");
                        }


                    }
                    System.out.print("  ");
                }catch (ArrayIndexOutOfBoundsException e){
                    for(int d = 0; d< niveauActuel.listePiecesActuelles[i].piece[0].length;d++){
                        System.out.print(" ");
                    }
                    System.out.print("  ");

                }
            }





        }

    public static void afficherNiveau(Niveau niveauActuel,int compteuNiveau){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        final String AINSI_RED ="\u001B[31m";


        //Print le nom du niveau
        System.out.println("~Montezuma~N"+compteuNiveau);
        //Print l'espace avant les lettres
        for (int i=0;i<2;i++){
            System.out.print(" ");
        }
        //Print les lettres
        for(int i = 0; i< niveauActuel.plancheActuelle.planche[0].length; i++){
            System.out.print(AINSI_RED+""+ Character.toUpperCase(alphabet.charAt(i)));
        }
        System.out.println();

        //Print chaque ligne
        for (int i = 0;i<niveauActuel.plancheActuelle.planche.length+1;i++) {
            afficherLignePlanche(niveauActuel, i);
            afficherLignePiece(niveauActuel,i);
            System.out.println();
        }





    }

    public static void jouerNiveauActuel(Niveau niveauActuel,int compteurNiveau){
        int nombrePieces= niveauActuel.listePiecesActuelles.length;

        afficherNiveau(niveauActuel,compteurNiveau);

        int compteurLignes = 0;
        int piecesRestantes = 0;

        while(nombrePieces-piecesRestantes!=0) {
            piecesRestantes = piecesRestantes+placerPiece(niveauActuel,compteurNiveau,compteurLignes);

            afficherNiveau(niveauActuel, compteurNiveau);
            compteurLignes++;
        }
        System.out.println("Bravo! niveau reussi");
        compteurLignes=0;



    }
    public static int placerPiece(Niveau niveauActuel, int compteurNiveau, int compteurLigne){

        //EXCEPTION  SCANNER
        Scanner clavier = new Scanner(System.in);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.print("Entrez la pièces et la position désirée(! pour quitter)>>>:");
        String reponsePlacer = clavier.next();
        if (reponsePlacer.equals("!")){
            System.out.println("Merci d'avoir joué ! Au revoir.");
            System.exit(0);
        }
        if (reponsePlacer.charAt(0)=='<'){
            String[] nomFichierCommande = reponsePlacer.split("<");
            //LIRE FILE + FAIRE COMMANDES
        }
        int nombrePiecesModifies =0;
        if (reponsePlacer.length()==1){

            int pieceAPoser = alphabet.indexOf(reponsePlacer.charAt(0))+1;

            //Retablir la planche
            //V/rifier qu<elle existe
            for(int i = 0;i<niveauActuel.plancheActuelle.planche.length;i++){
                for (int j =0;j<niveauActuel.plancheActuelle.planche[i].length;j++){
                    if (niveauActuel.plancheActuelle.planche[i][j]==pieceAPoser){
                        niveauActuel.plancheActuelle.planche[i][j] = 0;
                    }
                }
            }

            //Reafficher les pieces
            for (int g=0;g<niveauActuel.listePiecesActuelles[26 -pieceAPoser].piece.length;g++){
                for (int h=0;h<niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g].length;h++){
                    if(niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g][h] == 2){
                        niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g][h]=1;
                    }

                }
            }
            nombrePiecesModifies--;

            //essayer de retirer
            //si marche, nombrePiece++
        }
        else{

            int pieceAPoser = alphabet.indexOf(reponsePlacer.charAt(0))+1;
            int colonnePlanche = alphabet.indexOf(reponsePlacer.charAt(1));
            int lignePlanche = Integer.parseInt(String.valueOf(reponsePlacer.charAt(2)))-1;


            //Si la planche est la piece sont compatibles sur le coin gauche
            boolean compatible = false;
            if((niveauActuel.plancheActuelle.planche[lignePlanche][colonnePlanche]+niveauActuel.listePiecesActuelles[26 -pieceAPoser].piece[0][0] == 0)||(niveauActuel.plancheActuelle.planche[lignePlanche][colonnePlanche]+niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[0][0] == 1)){
                //Verifier l<entierte de la piece
                try {
                    for (int g = 0; g < niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece.length; g++) {
                        for (int h = 0; h < niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g].length; h++) {

                            if ((niveauActuel.plancheActuelle.planche[lignePlanche + g][colonnePlanche + h] + niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g][h] == 0) || (niveauActuel.plancheActuelle.planche[lignePlanche + g][colonnePlanche + h]) + (niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g][h]) == 1) {
                                compatible = true;
                            }
                            if((niveauActuel.plancheActuelle.planche[lignePlanche + g][colonnePlanche + h] + niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g][h] >= 2)&&(niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g][h]!=0)){
                                if (niveauActuel.plancheActuelle.planche[lignePlanche + g][colonnePlanche + h]!=0){
                                    compatible = false;
                                    break;
                                }
                            }

                        }
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("LA piece ne peut pas etre placee ici");
                        compatible =false;
                    }
                if (compatible) {

                    for (int g = 0; g < niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece.length; g++) {
                        for (int h = 0; h < niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g].length; h++) {
                            if ((niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g][h] == 1&&(niveauActuel.plancheActuelle.planche[lignePlanche+g][colonnePlanche+h]+niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[g][h] == 1))) {
                                niveauActuel.plancheActuelle.planche[lignePlanche + g][colonnePlanche + h] = pieceAPoser;
                            }
                        }

                    }



                    //rendre invisible
                    for (int u=0;u<niveauActuel.listePiecesActuelles[26 -pieceAPoser].piece.length;u++){
                        for (int v=0;v<niveauActuel.listePiecesActuelles[26 - pieceAPoser].piece[u].length;v++){
                            if (niveauActuel.listePiecesActuelles[26-pieceAPoser].piece[u][v]==1){
                                niveauActuel.listePiecesActuelles[26-pieceAPoser].piece[u][v]=2;
                            }

                        }
                    }
                    nombrePiecesModifies++;
                }
                else{
                    System.out.println("La piece ne peut pas etre placee ici");
                }


            }
            else{
                System.out.println("La piece ne peut pas etre placee ici");
            }

            //essayer de placer
            //si marche, nombrePiece--
        }
        return nombrePiecesModifies;
    }
}

