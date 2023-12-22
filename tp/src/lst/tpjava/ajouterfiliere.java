package lst.tpjava;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javafx.application.Application.launch;

public class ajouterfiliere extends Application {

    // Mettez à jour ces informations en fonction de votre configuration MySQL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gestionunive";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX MySQL Example");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // Labels
        Label nameLabel = new Label("Intitule:");
        Label ageLabel = new Label("Responsable:");
        Label resLabel = new Label("Departement");
        // TextFields
        TextField nameField = new TextField();
        TextField ageField = new TextField();
        TextField resField = new TextField();
        // Button
        Button addButton = new Button("Ajouter");
        addButton.setOnAction(e -> insertData(nameField.getText(),ageField.getText(),resField.getText()));

        // Ajout des éléments à la grille
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(ageLabel, 0, 1);
        grid.add(ageField, 1, 1);
        grid.add(resLabel, 0, 2);
        grid.add(resField, 1, 2);
        grid.add(addButton, 1, 3);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void insertData(String intitule, String responsable,String departement) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Utilisation d'une requête préparée pour éviter les attaques par injection SQL
            String query = "INSERT INTO filiere   (intitule, respons, depart) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, intitule);
            preparedStatement.setString(2, responsable);
            preparedStatement.setString(3, departement);
            // Exécution de la requête
            preparedStatement.executeUpdate();

            // Fermeture des ressources
            preparedStatement.close();
            connection.close();

            System.out.println("Données insérées avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
