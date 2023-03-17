import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner clavier = new Scanner(System.in);

        /* Couleurs ASCII*/
        final String AINSI_CYAN ="\u001B[36m";
        final String AINSI_GREEN ="\u001B[32m";
        final String AINSI_RED ="\u001B[31m";


        /*Print du titre*/
        System.out.println(AINSI_CYAN+"$$\\      $$\\                      $$\\                                                           ");
        System.out.println("$$$\\    $$$ |                     $$ |                                                          ");
        System.out.println("$$$$\\  $$$$ | $$$$$$\\  $$$$$$$\\ $$$$$$\\    $$$$$$\\  $$$$$$$$\\ $$\\   $$\\ $$$$$$\\$$$$\\   $$$$$$\\  ");
        System.out.println("$$\\$$\\$$ $$ |$$  __$$\\ $$  __$$\\\\_$$  _|  $$  __$$\\ \\____$$  |$$ |  $$ |$$  _$$  _$$\\  \\____$$\\ ");
        System.out.println("$$ \\$$$  $$ |$$ /  $$ |$$ |  $$ | $$ |    $$$$$$$$ |  $$$$ _/ $$ |  $$ |$$ / $$ / $$ | $$$$$$$ |");
        System.out.println("$$ |\\$  /$$ |$$ |  $$ |$$ |  $$ | $$ |$$\\ $$   ____| $$  _/   $$ |  $$ |$$ | $$ | $$ |$$  __$$ |");
        System.out.println( "$$ | \\_/ $$ |\\$$$$$$  |$$ |  $$ | \\$$$$  |\\$$$$$$$\\ $$$$$$$$\\ \\$$$$$$  |$$ | $$ | $$ |\\$$$$$$$ |");
        System.out.println("\\__|     \\__| \\______/ \\__|  \\__|  \\____/  \\_______|\\________| \\______/ \\__| \\__| \\__| \\_______|");
        System.out.println(AINSI_RED+"\nCasse tête de Montezuma, par Quentin Piché-Savard.");
        System.out.println(AINSI_GREEN+"\n\nAppuyez sur ENTRÉE pour lancer le jeu!!");

        /*Commencer le jeu
        String commencerJeu = clavier.nextLine();
        while(commencerJeu!=null) {
            if (commencerJeu.isEmpty()) {
                commencerJeu=null;
            }
            else {
                commencerJeu = clavier.nextLine();
            }
        }

        /* Choix du type de placement de pièces*/




        //jouer tou les niveaux disponibles
        Jouer.commencerPartie();










    }
}