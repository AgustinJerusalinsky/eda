package Qgrams;

public class main {
    public static void main(String[] args) {
        QGram g = new QGram(2);
        g.printTokens("alal");
        double value = g.similarity("salesal","alal");
        System.out.println(value);
    }
}
