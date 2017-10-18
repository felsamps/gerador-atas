package ifrs.apps.geradoratas.models;

import br.com.caelum.stella.inwords.FormatoDeInteiro;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public class GeradorAta {
    private final String[] meses = {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
    
    private String forum;
    private int numero;
    private int dia, mes, ano;
    private int hora, minuto;
    
    private ObservableList<Participante> participantes;
    private ObservableList<String> pauta, encaminhamentos;
    
    public GeradorAta(String forum, int numero, int dia, int mes, int ano, int hora, int minuto, ObservableList<Participante> participantes, ObservableList<String> pauta, ObservableList<String> encaminhamentos) {
        this.forum = forum;
        this.numero = numero;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minuto = minuto;
        this.participantes = participantes;
        this.pauta = pauta;
        this.encaminhamentos = encaminhamentos;
    }

    public String geraAta() {
        String ata = "";
        ata += this.geraApresentacao();
        
        return ata;
    }

    private String geraApresentacao() {
        NumericToWordsConverter converter;  
        converter = new NumericToWordsConverter(new InteiroSemFormato());  

        String retorno = "";
        retorno += ((this.dia > 1) ? "Aos " : "Ao ") + converter.toWords(this.dia) + " dias ";
        retorno += "do mês de " + this.meses[this.mes] + " ";
        retorno += "do ano de " + converter.toWords(this.ano) + ".";
        return retorno;
    }

}
