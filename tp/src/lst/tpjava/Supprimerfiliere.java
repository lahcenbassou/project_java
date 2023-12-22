
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

public class Supprimerfiliere extends Application {

    private Connection connection;

    private ObservableList<String> filieretList = FXCollections.observableArrayList();

    private TextField tfNom = new TextField();
    private TextField tfPrenom = new TextField();
    

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

        Label lblNom = new Label("intitule:");
        ComboBox<String> cbEtudiants = new ComboBox<>(filieretList );
        cbEtudiants.setPromptText("Sélectionnez un departement");

        

       

        Button btnModifier = new Button("Supprimer");
        btnModifier.setOnAction(event -> modifierInformation(cbEtudiants.getValue()));

        gridPane.add(lblNom, 0, 0);
        gridPane.add(cbEtudiants, 1, 0);
       
        
     
        
        gridPane.add(btnModifier, 1, 3);

        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setTitle("Supprimer une filiere");
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
        String query = "SELECT intitule FROM  filiere  ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                filieretList.add(resultSet.getString("intitule"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    private void modifierInformation(String nomEtudiant) {
        String query = "delete from filiere    WHERE intitule = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, nomEtudiant);
            preparedStatement.executeUpdate();

            // Mise à jour de la liste des étudiants après modification
            filieretList.clear();
            chargerListeEtudiants();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
