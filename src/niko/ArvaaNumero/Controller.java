/**
 * Sample Skeleton for 'Untitled' Controller Class
 */

package niko.ArvaaNumero;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ohjeLabel"
    private Label ohjeLabel; // Value injected by FXMLLoader

    @FXML // fx:id="arvausTextField"
    private TextField arvausTextField; // Value injected by FXMLLoader

    @FXML // fx:id="uusipeliButton"
    private Button uusipeliButton; // Value injected by FXMLLoader

    @FXML // fx:id="palauteLabel"
    private Label palauteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="arvaaButton"
    private Button arvaaButton; // Value injected by FXMLLoader

    @FXML // fx:id="rootnode"
    private BorderPane rootnode; // Value injected by FXMLLoader

    @FXML // fx:id="gridpane"
    private GridPane gridpane; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ohjeLabel != null : "fx:id=\"ohjeLabel\" was not injected: check your FXML file 'main.fxml'.";
        assert arvausTextField != null : "fx:id=\"arvausTextField\" was not injected: check your FXML file 'main.fxml'.";
        assert uusipeliButton != null : "fx:id=\"uusipeliButton\" was not injected: check your FXML file 'main.fxml'.";
        assert palauteLabel != null : "fx:id=\"palauteLabel\" was not injected: check your FXML file 'main.fxml'.";
        assert arvaaButton != null : "fx:id=\"arvaaButton\" was not injected: check your FXML file 'main.fxml'.";
        assert rootnode != null : "fx:id=\"rootnode\" was not injected: check your FXML file 'main.fxml'.";
        assert gridpane != null : "fx:id=\"gridpane\" was not injected: check your FXML file 'main.fxml'.";

    }


    private int oikeaNumero;
    private int edellinenVastaus;

    public Controller(Stage stage) {

    }

    public void BindEvents() {
        arvaaButton.setOnMouseClicked(this::tarkistaVastaus);
        rootnode.setOnKeyPressed(this::keyPressHandler);
        uusipeliButton.setOnMouseClicked(this::uusiPeli);

        uusiPeli(null);
    }

    private void uusiPeli(MouseEvent event){
        oikeaNumero = new Random().nextInt(1000);
        oikeaNumero++;
        edellinenVastaus = 0;
        arvausTextField.setText("");
        palauteLabel.setText("");
        rootnode.setStyle("-fx-background: white;");
    }


    private void keyPressHandler(KeyEvent keyEvent) {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                tarkistaVastaus(null);
            }
            else if(keyEvent.getCode() == KeyCode.ESCAPE) {
                System.exit(0);
            }
        }


    private void tarkistaVastaus(MouseEvent event) {
        int vastaus = 0;
        try {
            vastaus = Integer.parseInt(arvausTextField.getText());
        } catch (NumberFormatException ex) {
            palauteLabel.setText("Anna luku välillä: 1 - 1000");
            return;
        }
        if(vastaus < 0 || vastaus > 1000) {
            palauteLabel.setText("Anna luku välillä: 1 - 1000");
            arvausTextField.setText("");
        }
        else {
            if (vastaus == oikeaNumero) {
                //oikein
                palauteLabel.setText("Oikein!");
                rootnode.setStyle("-fx-background: green;");
            }
            else if(vastaus > oikeaNumero) {
                //suuri
                palauteLabel.setText("Liian suuri");
                asetaVari(vastaus);
            }
            else {
                //pieni
                palauteLabel.setText("Liian pieni");
                asetaVari(vastaus);
            }


        }


    }

    private void asetaVari(int vastaus) {
        if(Math.abs(oikeaNumero - edellinenVastaus) > Math.abs(oikeaNumero - vastaus)) {
            // closer
            rootnode.setStyle("-fx-background: blue;");
        }
        else {
            // further
            rootnode.setStyle("-fx-background: red;");
        }
    }
}
