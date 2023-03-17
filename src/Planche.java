public class Planche {
    int[][] planche;

    public Planche(int[][] plancheConstruite) {
        this.planche = plancheConstruite;
    }
    public static Planche constuirePlanche(String planche){
        String[] plancheSplit = planche.split("\\|");
        int[][] plancheConstruite = new int[Integer.parseInt(String.valueOf(plancheSplit[1].charAt(0)))][Integer.parseInt(String.valueOf(plancheSplit[1].charAt(2)))];
        int indexTemporaire = 0;
        for (int i = 0;i<plancheConstruite.length;i++){
            for (int j =0; j<plancheConstruite[i].length;j++){
                plancheConstruite[i][j]=Integer.parseInt(String.valueOf(plancheSplit[2].charAt(indexTemporaire)));
                indexTemporaire++;
            }
        }


        return new Planche(plancheConstruite);
    }




}
