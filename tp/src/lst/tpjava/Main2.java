
package lst.tpjava;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
 
public class Main2 extends Application {
 
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	//  Initialize the Stage, groups, and scene
        primaryStage.setTitle("chose");
        
        Group group1 = new Group();
        Scene scene1 = new Scene(group1, 300, 300);
        
        Group group2 = new Group();
        Scene scene2 = new Scene(group2, 300, 250);
        
        Group group3 = new Group();
        Scene scene3 = new Scene(group3, 300, 250);
        
        Group group4 = new Group();
        Scene scene4 = new Scene(group4, 300, 250);
        
         Group group5 = new Group();
        Scene scene5 = new Scene(group5, 300, 250);
        
        Group group6 = new Group();
        Scene scene6 = new Scene(group6, 300, 250);
        // Fill in the scene1
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(0);
        btn.setText("Departement");
        btn.setOnAction(e -> primaryStage.setScene(scene2));   
        group1.getChildren().add(btn);
        
        Button btn1 = new Button();
        btn1.setLayoutX(100);
        btn1.setLayoutY(40);  
        btn1.setText("Filiere ");
        btn1.setOnAction(e -> primaryStage.setScene(scene3));   
        group1.getChildren().add(btn1);
        
        Button btn2 = new Button();
        btn2.setLayoutX(100);
        btn2.setLayoutY(80);
        btn2.setText("enseignant ");
        btn2.setOnAction(e -> primaryStage.setScene(scene4));   
        group1.getChildren().add(btn2);
        
        Button btn3 = new Button();
        btn3.setLayoutX(100);
        btn3.setLayoutY(120);
        btn3.setText("etudiant ");
        btn3.setOnAction(e -> primaryStage.setScene(scene5));   
        group1.getChildren().add(btn3);
        
        Button btn4 = new Button();
        btn4.setLayoutX(100);
        btn4.setLayoutY(160);
        btn4.setText("Module ");
        btn4.setOnAction(e -> primaryStage.setScene(scene6));   
        group1.getChildren().add(btn4);
        
        // Fill in scene 2
        Button btnc = new Button();
        btnc.setLayoutX(00);
        btnc.setLayoutY(0);
        btnc.setText("Ajouter un departement");
        btnc.setOnAction(e -> openajdepScene(primaryStage));   
        group2.getChildren().add(btnc);
        
        Button btnc1 = new Button();
        btnc1.setLayoutX(0);
        btnc1.setLayoutY(40);
        btnc1.setText("Modifier un departement");
        btnc1.setOnAction(e -> openmoddepScene(primaryStage));   
        group2.getChildren().add(btnc1);
        
        Button btnc2 = new Button();
        btnc2.setLayoutX(0);
        btnc2.setLayoutY(80);
        btnc2.setText("Supprimer un departement");
        btnc2.setOnAction(e -> opensupdepScene(primaryStage));   
        group2.getChildren().add(btnc2);
        
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        //fill in scene 3
        Button btnf = new Button();
        btnf.setLayoutX(00);
        btnf.setLayoutY(0);
        btnf.setText("Ajouter une filiere");
        btnf.setOnAction(e -> openajfilScene(primaryStage));   
        group3.getChildren().add(btnf);
        
        Button btnf1 = new Button();
        btnf1.setLayoutX(00);
        btnf1.setLayoutY(40);
        btnf1.setText("Modifier une filiere");
        btnf1.setOnAction(e -> openmodfiliScene(primaryStage));   
        group3.getChildren().add(btnf1);
        
        Button btnf2 = new Button();
        btnf2.setLayoutX(00);
        btnf2.setLayoutY(80);
        btnf2.setText("Supprimer une filiere");
        btnf2.setOnAction(e ->opensupfiliScene(primaryStage));   
        group3.getChildren().add(btnf2);
        
        //scene 4
        Button btne = new Button();
        btne.setLayoutX(00);
        btne.setLayoutY(0);
        btne.setText("Ajouter un enseignat");
        btne.setOnAction(e -> openajouenseiScene(primaryStage));   
        group4.getChildren().add(btne);
        
        Button btne1 = new Button();
        btne1.setLayoutX(00);
        btne1.setLayoutY(40);
        btne1.setText("Modifier un enseignat");
        btne1.setOnAction(e -> openmodienseiScene(primaryStage));   
        group4.getChildren().add(btne1);
        
        Button btne2 = new Button();
        btne2.setLayoutX(00);
        btne2.setLayoutY(80);
        btne2.setText("Supprimer un enseignat");
        btne2.setOnAction(e -> opensuppenseigScene(primaryStage));   
        group4.getChildren().add(btne2);
        //scene 5
        
        Button btnee = new Button();
        btnee.setLayoutX(00);
        btnee.setLayoutY(0);
        btnee.setText("Ajouter un etudiant");
        btnee.setOnAction(e -> opensjoutetudScene(primaryStage));   
        group5.getChildren().add(btnee);
        
        Button btnee1 = new Button();
        btnee1.setLayoutX(00);
        btnee1.setLayoutY(40);
        btnee1.setText("Modifier un etudiant");
        btnee1.setOnAction(e -> opensmodifetudScene(primaryStage));   
        group5.getChildren().add(btnee1);
        
        Button btnee2 = new Button();
        btnee2.setLayoutX(00);
        btnee2.setLayoutY(80);
        btnee2.setText("Supprimer un etudiant");
        btnee2.setOnAction(e -> opensuppetudScene(primaryStage));   
        group5.getChildren().add(btnee2);
        //scene 6
        
        Button btnm = new Button();
        btnm.setLayoutX(00);
        btnm.setLayoutY(0);
        btnm.setText("Ajouter un module");
        btnm.setOnAction(e -> opensajoutmodulScene(primaryStage));   
        group6.getChildren().add(btnm);
        
        Button btnm1 = new Button();
        btnm1.setLayoutX(00);
        btnm1.setLayoutY(40);
        btnm1.setText("Modifier un module");
        btnm1.setOnAction(e -> opensmodifmodulScene(primaryStage));   
        group6.getChildren().add(btnm1);
        
        Button btnm2 = new Button();
        btnm2.setLayoutX(00);
        btnm2.setLayoutY(80);
        btnm2.setText("Supprimer un module");
        btnm2.setOnAction(e ->  openssuprmmodulScene(primaryStage));   
        group6.getChildren().add(btnm2);
    }
    
    
    private void openajdepScene(Stage primaryStage) {
        Ajouterdepart aj = new Ajouterdepart();
        aj.start(primaryStage);
    }
    
    private void openmoddepScene(Stage primaryStage) {
       Modifierdepart aj = new Modifierdepart();
        aj.start(primaryStage);
    }
    
    private void opensupdepScene(Stage primaryStage) {
       supprimerdepart aj = new supprimerdepart();
        aj.start(primaryStage);
    }
    
    
    private void openajfilScene(Stage primaryStage) {
       ajouterfiliere aj = new ajouterfiliere();
        aj.start(primaryStage);
    }
    
    
    private void openmodfiliScene(Stage primaryStage) {
      Modifierfiliere aj = new Modifierfiliere();
        aj.start(primaryStage);
    }
    
    
    private void opensupfiliScene(Stage primaryStage) {
       Supprimerfiliere aj = new Supprimerfiliere();
        aj.start(primaryStage);
    }
    
    private void openajouenseiScene(Stage primaryStage) {
       ajouterenseig aj = new ajouterenseig();
        aj.start(primaryStage);
    }
    
    private void openmodienseiScene(Stage primaryStage) {
      modifierenseig aj = new modifierenseig();
        aj.start(primaryStage);
    }
    
    private void opensuppenseigScene(Stage primaryStage) {
      supprimerenseig aj = new supprimerenseig();
        aj.start(primaryStage);
    }
    
    private void opensjoutetudScene(Stage primaryStage) {
      ajouteretudiant aj = new ajouteretudiant();
        aj.start(primaryStage);
    }
    
    private void opensmodifetudScene(Stage primaryStage) {
      modifieretudiant aj = new modifieretudiant();
        aj.start(primaryStage);
    }
    
    private void opensuppetudScene(Stage primaryStage) {
      suppretudiant aj = new suppretudiant();
        aj.start(primaryStage);
    }
    
    private void opensajoutmodulScene(Stage primaryStage) {
      ajoutermodule aj = new ajoutermodule();
        aj.start(primaryStage);
    }
    
    private void opensmodifmodulScene(Stage primaryStage) {
      modifiermodule aj = new modifiermodule();
        aj.start(primaryStage);
    }
    
    private void openssuprmmodulScene(Stage primaryStage) {
     supprimermodule aj = new supprimermodule();
        aj.start(primaryStage);
    }
    
}
