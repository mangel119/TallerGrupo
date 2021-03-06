/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import datos.Lanzamiento;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import pilas.Pila;
import pilas.Tools;
import sun.net.www.content.image.png;

/**
 *
 * @author Familia Sanabria
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label labeltitulo;
    @FXML
    private ImageView dadouno;
    @FXML
    private ImageView dadodos;
    @FXML
    private WebView tabla;
    private WebEngine engine;
    int dado2;
    int dado1;
    Pila<Lanzamiento> pilad;

    @FXML
    private void lanzar(ActionEvent event) {
        Random rnd = new Random();

        dado1 = ((int) (rnd.nextDouble() * 6));
        System.out.println("numero 1" + dado1);

        dado2 = ((int) (rnd.nextDouble() * 6));
        System.out.println("numero 2" + dado2);
        if (dado1 == 1) {
            Image imagen = new Image("/imagenes/1.png");
            dadouno.setImage(imagen);
        } else if (dado1 == 2) {
            Image imagen = new Image("/imagenes/2.png");
            dadouno.setImage(imagen);
        } else if (dado1 == 3) {
            Image imagen = new Image("/imagenes/3.png");
            dadouno.setImage(imagen);
        } else if (dado1 == 4) {
            Image imagen = new Image("/imagenes/4.png");
            dadouno.setImage(imagen);
        } else if (dado1 == 5) {
            Image imagen = new Image("/imagenes/5.png");
            dadouno.setImage(imagen);
        }

        if (dado2 == 1) {
            Image imagen = new Image("/imagenes/1.png");
            dadodos.setImage(imagen);
        } else if (dado2 == 2) {
            Image imagen = new Image("/imagenes/2.png");
            dadodos.setImage(imagen);
        } else if (dado2 == 3) {
            Image imagen = new Image("/imagenes/3.png");
            dadodos.setImage(imagen);
        } else if (dado2 == 4) {
            Image imagen = new Image("/imagenes/4.png");
            dadodos.setImage(imagen);
        } else if (dado2 == 5) {
            Image imagen = new Image("/imagenes/5.png");
            dadodos.setImage(imagen);
        }

        pilad.apilar(new Lanzamiento(dado1, dado2));

        engine.loadContent(Tools.convertirPilaAHtml(pilad));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pilad = new Pila<>();
        engine = tabla.getEngine();
        dado2 = 1;
        dado1 = 1;
    }

}
