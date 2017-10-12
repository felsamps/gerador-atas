package ifrs.apps.geradoratas.models;

public class Participante {
    private String nome;
    private String segmento;
    
    public Participante(String nome, String segmento) {
        this.nome = nome;
        this.segmento = segmento;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
