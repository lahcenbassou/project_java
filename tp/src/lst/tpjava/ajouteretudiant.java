
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

public class ajouteretudiant extends Application {

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
        Label nameLabel = new Label("nom:");
        Label prenLabel = new Label("prenom:");
        Label emailLabel = new Label("email");
        Label gradLabel = new Label("apogee");
        Label departLabel = new Label("filiere");
        
        // TextFields
        TextField nameField = new TextField();
        TextField prenField = new TextField();
        TextField emailField = new TextField();
        TextField gradeField = new TextField();
         TextField departField = new TextField();
        // Button
        Button addButton = new Button("Ajouter");
        addButton.setOnAction(e -> insertData(nameField.getText(),prenField.getText(),emailField.getText(),gradeField.getText(),departField.getText()));

        // Ajout des éléments à la grille
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(prenLabel, 0, 1);
        grid.add(prenField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(gradLabel, 0, 3);
        grid.add(gradeField, 1, 3);
        grid.add(departLabel, 0, 4);
        grid.add(departField, 1, 4);
        
        grid.add(addButton, 1, 5);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void insertData(String nom, String prenom,String email,String grade,String departement) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Utilisation d'une requête préparée pour éviter les attaques par injection SQL
            String query = "INSERT INTO etudiant     (nom, prenom, email, apogee, filiere) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, grade);
            preparedStatement.setString(5, departement);
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

