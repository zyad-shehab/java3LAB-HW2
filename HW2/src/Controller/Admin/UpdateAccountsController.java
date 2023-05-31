/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Account;
import Model.User;
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
public class UpdateAccountsController implements Initializable {
    private Account oldAccount;

    @FXML
    private Button updateUserBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField BalanceTF;
    @FXML
    private TextField UserNameTF;
    @FXML
    private TextField AccountsNumTF;
    @FXML
    private TextField CarrencyTF;
    @FXML
    private TextField CreationDateTF;
    @FXML
    private TextField useridTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.oldAccount = Controller.Admin.AccountsManagmentController.selectedUserToUpdate;
        
        //set text field's data the same as updatedUser data
        BalanceTF.setText(String.valueOf(oldAccount.getBalance()));
        UserNameTF.setText(oldAccount.getUserName());
        AccountsNumTF.setText(String.valueOf(oldAccount.getAccountNumber()));
        CarrencyTF.setText(oldAccount.getCarrency());
        CreationDateTF.setText(oldAccount.getCarrency());
        useridTF.setText(String.valueOf( oldAccount.getUserid()));
    }    

    @FXML
    private void updateUser(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        //get the new data from text field's and store it in new user object
        double Balance = Double.parseDouble(BalanceTF.getText());
        String UserName = UserNameTF.getText();
        int AccountsNum =Integer.parseInt( AccountsNumTF.getText());
        String Carrency = CarrencyTF.getText();
        String CreationDate = CreationDateTF.getText();
        int userid = Integer.parseInt(useridTF.getText());
        
        
        //make an new user object having this data
        Account newAccount = new Account(userid, AccountsNum, UserName, Carrency, Balance, CreationDate);
        
        //set the new user id the same as the old user
        newAccount.setId(oldAccount.getId());
        
        // update the user in database by update method
        newAccount.update();
        
        //close the update stage using our global stage var in UsersManagmentController and show an alert
        Controller.Admin.AccountsManagmentController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account updated");
        alert.setContentText("Account updated");
        alert.showAndWait();
    }

    @FXML
    private void cancelCreation(ActionEvent event) {
        Controller.Admin.AccountsManagmentController.updateStage.close();
    }

    @FXML
    private void CreationDateTF(ActionEvent event) {
    }
    
}
