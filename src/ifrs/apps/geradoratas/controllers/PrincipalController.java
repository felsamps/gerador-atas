package ifrs.apps.geradoratas.controllers;

import ifrs.apps.geradoratas.app.PrincipalView;
import ifrs.apps.geradoratas.models.Participante;
import java.util.ArrayList;

public class PrincipalController {

    private PrincipalView view;
    private ArrayList<Participante> todosParticipantes;
    
    public PrincipalController(PrincipalView view) {
        this.view = view;
        
        this.todosParticipantes = new ArrayList<>();
        this.todosParticipantes.add(new Participante("Felipe Martin Sampaio", "Coordenador do Curso"));
        this.todosParticipantes.add(new Participante("Rafael Vieira Coelho", "Professor"));
        this.todosParticipantes.add(new Participante("Daniela de Campos", "Professor"));
        this.todosParticipantes.add(new Participante("Graciele Rosa da Costa Soares", "Setor Pedagógico"));       
        
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

    public ArrayList<Participante> getParticipantes(String filtro) {
        ArrayList<Participante> retorno = new ArrayList<>();
        for(Participante participante :this.todosParticipantes) {
            if(participante.toString().contains(filtro)) {
                retorno.add(participante);
            }
        }
        return retorno;
    }

    public void tratarAdicionaParticipante() {
        
    }
    
}
