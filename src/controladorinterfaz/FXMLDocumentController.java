/**
* Se encarga de establecer las acciones que deben realizar los elementos que forman la ventana.
* @author juan_san.erazo@uao.edu.co Juan Pablo Sandoval Erazo 2195823
* @author miguel.sanabria@uao.edu.co Miguel Angel Sanabria Rodriguez 2167228
* 
* 
* @date 8 Marzo 2021
* @version 1.0
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
                    } else if (dado1 == 6) {
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
                    } else if (dado2 == 6) {
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
    private void detener(ActionEvent event) {
        timer.cancel();

    }

    @FXML
    private void ultimoLanzamiento(ActionEvent event) {
        Lanzamiento ultimo = pilad.primero();
        JOptionPane.showMessageDialog(null, ultimo.toString());
    }

    @FXML
    private void repetidos(ActionEvent event) {
        Pila<Lanzamiento> repetidos = OperacionesPilas.duplicarPila(pilad);
        int valor11 = 0;
        int valor12 = 0;
        int valor13 = 0;
        int valor14 = 0;
        int valor15 = 0;
        int valor16 = 0;

        int valor21 = 0;
        int valor22 = 0;
        int valor23 = 0;
        int valor24 = 0;
        int valor25 = 0;
        int valor26 = 0;

        while (!repetidos.estaVacia()) {
            Lanzamiento rep = repetidos.desapilar();
            int valordado1 = rep.getDado1();
            int valordado2 = rep.getDado2();

            if (valordado1 == 1) {
                valor11++;

            }
            if (valordado1 == 2) {
                valor12++;

            }
            if (valordado1 == 3) {
                valor13++;

            }
            if (valordado1 == 4) {
                valor14++;

            }
            if (valordado1 == 5) {
                valor15++;

            }
            if (valordado1 == 6) {
                valor16++;

            }
            if (valordado2 == 1) {
                valor21++;

            }
            if (valordado2 == 2) {
                valor22++;

            }
            if (valordado2 == 3) {
                valor23++;

            }
            if (valordado2 == 4) {
                valor24++;

            }
            if (valordado2 == 5) {
                valor25++;

            }
            if (valordado2 == 6) {
                valor26++;

            }
        }

        String ver = repetidos.toString();

        JOptionPane.showMessageDialog(null, "Dado 1: " + '\n' + "Valor 1 repetido: " + valor11 + " veces, "
                + "Valor 2 repetido: " + valor12 + " veces, " + "Valor 3 repetido: " + valor13 + " veces, " + "Valor 4 repetido: " + valor14 + " veces, "
                + "Valor 5 repetido: " + valor15 + " veces, " + "Valor 6 repetido: " + valor16 + " veces." + '\n'
                + "Dado 2: " + '\n' + "Valor 1 repetido: " + valor21 + " veces, "
                + "Valor 2 repetido: " + valor22 + " veces, " + "Valor 3 repetido: " + valor23 + " veces, " + "Valor 4 repetido: " + valor24 + " veces, "
                + "Valor 5 repetido: " + valor25 + " veces, " + "Valor 6 repetido: " + valor26 + " veces.");
    }

    @FXML
    private void paresrepetidos(ActionEvent event) {
        Object seleccion = JOptionPane.showInputDialog(
                null,
                "Seleccione un Par",
                "Selector de opciones",
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono defecto
                new Object[]{"Par 1-1", "Par 2-2", "Par 3-3", "Par 4-4", "Par 5-5", "Par 6-6"},
                "Par1-1");

        Pila<Lanzamiento> parrepetidos = OperacionesPilas.duplicarPila(pilad);

        int rep1 = 0;
        int rep2 = 0;
        int rep3 = 0;
        int rep4 = 0;
        int rep5 = 0;
        int rep6 = 0;
        int msg = 0;

        while (!parrepetidos.estaVacia()) {
            Lanzamiento pares = parrepetidos.desapilar();
            int valordado1 = pares.getDado1();
            int valordado2 = pares.getDado2();

            if (valordado1 == 1 && valordado2 == 1) {
                rep1++;
            }
            if (valordado1 == 2 && valordado2 == 2) {
                rep2++;
            }
            if (valordado1 == 3 && valordado2 == 3) {
                rep3++;
            }
            if (valordado1 == 4 && valordado2 == 4) {
                rep4++;
            }
            if (valordado1 == 5 && valordado2 == 5) {
                rep5++;
            }
            if (valordado1 == 6 && valordado2 == 6) {
                rep6++;
            }

            if (seleccion == "Par 1-1") {
                msg = rep1;
            }
            if (seleccion == "Par 2-2") {
                msg = rep2;
            }
            if (seleccion == "Par 3-3") {
                msg = rep3;
            }
            if (seleccion == "Par 4-4") {
                msg = rep4;
            }
            if (seleccion == "Par 5-5") {
                msg = rep5;
            }
            if (seleccion == "Par 6-6") {
                msg = rep6;
            }
        }
        JOptionPane.showMessageDialog(null, "Repetido " + msg + " Veces");
    }
    
    @FXML
    private void probabilidad(ActionEvent event) {
        
//        double prob = 
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
        pilad = new Pila<>();
        engine = tabla.getEngine();
        dado2 = 1;
        dado1 = 1;
    }

}
