import java.util.Random;

public class Registro {
    private int codigoRegistro;

    public Registro(int codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public int getCodigoRegistro() {
        return codigoRegistro;
    }

    public static int generateRandomCodigoRegistro() {

        Random rand = new Random();
        int min = 100_000_000;
        int max = 999_999_999;
        return rand.nextInt((max - min) + 1) + min;
    }
}