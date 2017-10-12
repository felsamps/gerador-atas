package ifrs.apps.geradoratas.app;

import ifrs.apps.geradoratas.controllers.PrincipalController;
import ifrs.apps.geradoratas.models.Participante;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalView implements Initializable {
    @FXML private ComboBox<String> forumComboBox;
    @FXML private TextField diaTextField, mesTextField, anoTextField, horaTextField, minutoField, filtroTextField;
    @FXML private TextArea pautaTextArea, encaminhamentoTextArea;
    @FXML private ListView<String> pautasListView, encaminhamentosListView;
    @FXML private ListView<Participante> todosListView, participantesListView;
    @FXML private Button adicionaButton, removeButton, inserePautaButton, insereEncaminhamentoButton;
            
    private PrincipalController controller;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new PrincipalController(this);
        
        this.initForumChoices();
        this.atualizaParticipantes();
        
        this.todosListView.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                adicionaParticipante();
            }
        });
        
        this.filtroTextField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                atualizaParticipantes();
            }
        });
        
    }    

    private void initForumChoices() {
        ArrayList<String> foruns = this.controller.getForuns();
        ObservableList<String> opcoes = FXCollections.observableArrayList(foruns);
        this.forumComboBox.setItems(opcoes);
    }

    private void atualizaParticipantes() {
        ArrayList<Participante> participantes = this.controller.getParticipantes(this.filtroTextField.getText());
        ObservableList<Participante> opcoes = FXCollections.observableArrayList(participantes);
        this.todosListView.setItems(opcoes);
    }
    
    @FXML private void acaoBtnAdicionaParticipante(ActionEvent evt) {
        this.adicionaParticipante();
    }
    
    @FXML private void acaoBtnRemoveParticipante(ActionEvent evt) {
        this.removeParticipante();
    }
    
    private void adicionaParticipante() {
        ObservableList<Participante> selecionados = this.todosListView.getSelectionModel().getSelectedItems();
        for (Participante selecionado : selecionados) {
            if(!this.participantesListView.getItems().contains(selecionado)) {
                this.participantesListView.getItems().add(selecionado);
            }
        }
    }

    private void removeParticipante() {
        ObservableList<Integer> selecionados = this.participantesListView.getSelectionModel().getSelectedIndices();
        for (Integer selecionado : selecionados) {
            int idx = selecionado;
            this.participantesListView.getItems().remove(idx); 
        }
    }
    
}
