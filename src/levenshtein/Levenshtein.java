package levenshtein;

import java.util.Arrays;

public class Levenshtein {
    public static void main(String[] args) {
        levenshtein("big data","bigdata");
    }
    public static int levenshtein(String s1, String s2){
        int[][] mat = new int[s2.length()+1][s1.length()+1];
        for(int i=0;i<=s1.length();i++){
            mat[0][i]=i;
        }
        for(int i=0;i<=s2.length();i++){
            mat[i][0]=i;
        }

        for(int i = 1; i<mat.length;i++){
            for(int j=1;j<mat[i].length;j++) {
                mat[i][j]=Math.min(Math.min(
                        mat[i-1][j-1]+(s1.charAt(j-1)==s2.charAt(i-1)?0:1),
                        mat[i-1][j]+1),
                        mat[i][j-1]+1);
            }
        }

        printMat(mat);
        return mat[s2.length()][s1.length()];
    }

    public static void printMat(int[][] mat){
        for(int i = 0; i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
