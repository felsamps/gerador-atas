package ifrs.apps.geradoratas.controllers;

import ifrs.apps.geradoratas.app.PrincipalView;
import ifrs.apps.geradoratas.models.Participante;
import java.util.ArrayList;

public class PrincipalController {

    private PrincipalView view;
    
    public PrincipalController(PrincipalView view) {
        this.view = view;
    }

    public ArrayList<String> getForuns() {
        ArrayList<String> foruns = new ArrayList<>();
        foruns.add("Curso");
        foruns.add("Conselho do Curso");
        foruns.add("Conselho de Classe (1º Ano)");
        foruns.add("Conselho de Classe (2º Ano)");
        foruns.add("Conselho de Classe (3º Ano)");
        foruns.add("Conselho de Classe (4º Ano)");
        return foruns;
    }

    public ArrayList<Participante> getParticipantes() {
        ArrayList<Participante> parts = new ArrayList<>();
        parts.add(new Participante("Felipe Martin Sampaio", "Coordenador do Curso"));
        parts.add(new Participante("Rafael Vieira Coelho", "Professor"));
        parts.add(new Participante("Daniela de Campos", "Professor"));
        parts.add(new Participante("Graciele Rosa da Costa Soares", "Setor Pedagógico"));       
        return parts;
    }

    public void tratarAdicionaParticipante() {
        
    }
    
}
