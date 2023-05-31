/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Account;
import Model.User;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class CreateAccountController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button saveNewAccountsBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField AccountsNumTF;
    @FXML
    private TextField UserNameTF;
    @FXML
    private TextField CarrencyTF;
    @FXML
    private TextField BalanceTF;
    @FXML
    private TextField CreationDateBTN;
    @FXML
    private TextField useridTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void saveNewAccounts(ActionEvent event) throws SQLException, ClassNotFoundException {
        int AccountsNum = Integer.parseInt(AccountsNumTF.getText());
        String UserName = UserNameTF.getText();
        String Carrency = CarrencyTF.getText();
        double Balance = Double.parseDouble(BalanceTF.getText());
        String CreationDatString = CreationDateBTN.getText();
        int userid =Integer.parseInt(useridTF.getText());
        
        // make an user object having this data
        Account account = new Account(userid, AccountsNum, UserName, Carrency, Balance, CreationDatString);
        // save the user in database by save method
        account.save();
        
        //after saving should return to the back scene and show an alert
        ViewManager.adminPage.changeSceneToUsersManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("account inserted");
        alert.setContentText("account inserted");
        alert.showAndWait();
    }

    @FXML
    private void cancelAccountsCreation(ActionEvent event) {
      ViewManager.adminPage.changeSceneToAccountsManagment();

    }

    @FXML
    private void CreationDateBTN(ActionEvent event) {
    }

    
    
}
