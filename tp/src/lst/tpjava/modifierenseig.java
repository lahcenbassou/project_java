
package lst.tpjava;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javafx.application.Application.launch;

public class modifierenseig extends Application {

    private Connection connection;

    private ObservableList<String> enseignentList = FXCollections.observableArrayList();

    private TextField tfNom = new TextField();
    private TextField tfPrenom = new TextField();
    private TextField tfemail = new TextField();
     private TextField tfgrade = new TextField();
     private TextField tfdepart = new TextField();
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initUI(primaryStage);
        initDatabase();
    }

    private void initUI(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label lblNom = new Label("nom:");
        ComboBox<String> cbEtudiants = new ComboBox<>(enseignentList );
        cbEtudiants.setPromptText("Sélectionnez un enseignant");

        

        Label lblPrenom = new Label("prenom:");
        TextField tfPrenom = new TextField();

        Label lblemail = new Label("email:");
        TextField tfemail = new TextField();
        
        Label lblgrade = new Label("grade:");
        TextField tfgrade = new TextField();
        
        Label lbldepart = new Label("departement:");
        TextField tfdepart = new TextField();
        
        
        
        Button btnModifier = new Button("Modifier");
        btnModifier.setOnAction(event -> modifierInformation(tfdepart.getText(),tfgrade.getText(),tfemail.getText(),tfPrenom.getText(),cbEtudiants.getValue()));

        gridPane.add(lblNom, 0, 0);
        gridPane.add(cbEtudiants, 1, 0);
       
        gridPane.add(lblPrenom, 0, 1);
        gridPane.add(tfPrenom, 1, 1);
     
        gridPane.add(lblemail, 0,2);
        gridPane.add(tfemail, 1, 2);
        
        gridPane.add(lblgrade, 0,3);
        gridPane.add(tfgrade, 1, 3);
        
        gridPane.add(lbldepart, 0,4);
        gridPane.add(tfdepart, 1, 4);
        
        gridPane.add(btnModifier, 1, 5);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Modification des informations du enseiganat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initDatabase() {
        // Remplacez les informations de connexion avec les vôtres
        String url = "jdbc:mysql://localhost:3306/gestionunive";
        String utilisateur = "root";
        String motDePasse = "";

        try {
            connection = DriverManager.getConnection(url, utilisateur, motDePasse);
            chargerListeEtudiants();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void chargerListeEtudiants() {
        String query = "SELECT nom FROM   enseignant   ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                enseignentList.add(resultSet.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    private void modifierInformation(String departement,String grade,String email,String prenom,String nomEtudiant) {
        String query = "UPDATE  enseignant    SET departem = ? ,  grade = ? , email= ? , prenom= ?     WHERE nom = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setString(1, departement);
            preparedStatement.setString(2, grade);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, prenom);
            preparedStatement.setString(5, nomEtudiant);
            preparedStatement.executeUpdate();

            // Mise à jour de la liste des étudiants après modification
          enseignentList.clear();
            chargerListeEtudiants();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

