/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfaz;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private void handleButtonAction(ActionEvent event) {
        Random rnd = new Random();
        int dado1 = 0;
        dado1 = ((int)(rnd.nextDouble()*6));
        int dado2 = 0;
        dado2 = ((int)(rnd.nextDouble()*6));
        
        if (dado1==0){
            dadouno.setImage(new Image(getClass().getResourceAsStream("imagenes/1.png")));
        }
        else if (dado1==1)
        {
            dadouno.setImage(new Image(getClass().getResourceAsStream("imagenes/2.png")));
        }
        else if (dado1==2)
        {
            dadouno.setImage(new Image(getClass().getResourceAsStream("imagenes/3.png")));
        }
        else if (dado1==3)
        {
            dadouno.setImage(new Image(getClass().getResourceAsStream("imagenes/4.png")));
        }
        else if (dado1==4)
        {
            dadouno.setImage(new Image(getClass().getResourceAsStream("imagenes/5.png")));
        }
        else if (dado1==5)
        {
            dadouno.setImage(new Image(getClass().getResourceAsStream("imagenes/6.png")));
        }
        
        
        if (dado2==0){
            dadodos.setImage(new Image(getClass().getResourceAsStream("imagenes/1.png")));
        }
        else if (dado2==1)
        {
            dadodos.setImage(new Image(getClass().getResourceAsStream("imagenes/2.png")));
        }
        else if (dado2==2)
        {
            dadodos.setImage(new Image(getClass().getResourceAsStream("imagenes/3.png")));
        }
        else if (dado2==3)
        {
            dadodos.setImage(new Image(getClass().getResourceAsStream("imagenes/4.png")));
        }
        else if (dado2==4)
        {
            dadodos.setImage(new Image(getClass().getResourceAsStream("imagenes/5.png")));
        }
        else if (dado2==5)
        {
            dadodos.setImage(new Image(getClass().getResourceAsStream("imagenes/6.png")));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
