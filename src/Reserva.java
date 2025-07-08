//Classe resserva, contem os dados das reservas.

public class Reserva {
    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valordiaria;

    public Reserva(String nomeHospede , String tipoQuarto ,  int numeroDias , double valordiaria){

        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.numeroDias = numeroDias;
        this.valordiaria = valordiaria;

    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public int getNumeroDias() {
        return numeroDias;
    }
    public double getValordiaria() {
        return valordiaria;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    @Override
    public String toString() {
        return "\nNome: " + nomeHospede + "\nQuarto: " + tipoQuarto;
    }
}
