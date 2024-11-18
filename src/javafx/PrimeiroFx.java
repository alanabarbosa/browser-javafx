package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class PrimeiroFx extends Application {
    @Override
    public void start(Stage palco) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        TextField barraEndereco = new TextField();
        barraEndereco.setPromptText("Digite o URL aqui...");

        Button btnVoltar = new Button("Voltar");
        Button btnAvancar = new Button("Avançar");
        Button btnAtualizar = new Button("Atualizar");
        
        btnVoltar.setOnAction(e -> webEngine.getHistory().go(-1));
        btnAvancar.setOnAction(e -> webEngine.getHistory().go(1));
        btnAtualizar.setOnAction(e -> webEngine.reload());
        
        barraEndereco.setOnAction(e -> webEngine.load(barraEndereco.getText()));

        HBox hBoxNavegacao = new HBox(10, btnVoltar, btnAvancar, btnAtualizar, barraEndereco);
        VBox vBoxPrincipal = new VBox(10, hBoxNavegacao, webView);

        Scene cena = new Scene(vBoxPrincipal, 800, 600);
        
        palco.setTitle("Navegador Simples");
        palco.setScene(cena);
        palco.show();

        webEngine.load("https://www.google.com");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
