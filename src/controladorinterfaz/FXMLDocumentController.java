/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import datos.Lanzamiento;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;
import pilas.Pila;
import pilas.Tools;
import sun.net.www.content.image.png;
import pilas.OperacionesPilas;

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
    @FXML
    private WebEngine engine;
    @FXML
    private Label ultimoLanza;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem lanzar;
    public Timer timer;
    
    int dado2;
    int dado1;
    Pila<Lanzamiento> pilad;
    Pila<Lanzamiento> ultValor;
    
    Timer timer1;
    Toolkit toolkit;

    @FXML
    private void lanzar(ActionEvent event) {
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
        Random rnd = new Random();

        dado1 = ((int) (rnd.nextDouble() * 6 + 1));
//        System.out.println("numero 1" + dado1);

        dado2 = ((int) (rnd.nextDouble() * 6 + 1));
//        System.out.println("numero 2" + dado2);
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
        else if (dado1 == 6) {
            Image imagen = new Image("/imagenes/6.png");
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
        else if (dado2 == 6) {
            Image imagen = new Image("/imagenes/6.png");
            dadodos.setImage(imagen);
        }
        

        pilad.apilar(new Lanzamiento(dado1, dado2));

        engine.loadContent(Tools.convertirPilaAHtml(pilad));
        
                });
                }
                }, 3000, 4000);
                        

    }
    @FXML
    private void detener(ActionEvent event){
    timer.cancel();
    
    }
    @FXML
    private void ultimoLanzamiento(ActionEvent event){
        Lanzamiento ultimo = pilad.primero();
       JOptionPane.showMessageDialog(null, ultimo.toString());
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
