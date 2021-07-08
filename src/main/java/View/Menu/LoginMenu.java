package View.Menu;

import Controller.Regex;
import Model.User;
import View.GUI.*;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;

public class LoginMenu extends Menu {

    public static Stage mainStage;
    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField nicknameTextField;
    @FXML
    public TextField passwordTextField;
    @FXML
    public TextField loginUsernameTextField;
    @FXML
    public TextField loginPasswordTextField;


    String username, nickname, password;


    public LoginMenu() {
        super("Login Menu", null);
        this.getSubMenus().add(new MainMenu(this));
    }

    @Override
    public void execute() {
    }


    private boolean login(String username, String password) {
        User user = User.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            String header = "No Match";
            String content = "Username and password didn't match!";
            Login.createAlert(Alert.AlertType.ERROR, header, content);
            return false;
        }
        loggedUser = user;
        return true;
    }


    public void login(ActionEvent actionEvent) throws Exception {
        String username = loginUsernameTextField.getText();
        String password = loginPasswordTextField.getText();
        if (!login(username, password)) {
            return;
        }
        MainMenuGraphic mainMenuGraphic = new MainMenuGraphic();
        mainMenuGraphic.start(mainStage);
    }

    public void back(ActionEvent actionEvent) throws Exception {
        SignUpAndLoginGraphic signUpAndLoginGraphic = new SignUpAndLoginGraphic();
        signUpAndLoginGraphic.start(mainStage);
    }

    public void openRegisterMenu(ActionEvent actionEvent) throws Exception {
        RegisterMenu.mainStage = mainStage;
        Register register = new Register();
        register.start(mainStage);
    }

    public void openLoginMenu(ActionEvent actionEvent) throws Exception {
        Login login = new Login();
        login.start(mainStage);
    }

    public void backToFirstPage(ActionEvent actionEvent) throws Exception {
        SignUpAndLoginGraphic signUpAndLoginGraphic = new SignUpAndLoginGraphic();
        signUpAndLoginGraphic.start(mainStage);
    }

    public void openProfileMenu(ActionEvent actionEvent) throws Exception {
        openProfile();
    }

    public void openProfile() throws Exception {
        ProfileGraphic profileGraphic = new ProfileGraphic();
        profileGraphic.start(mainStage);
    }

    public void openScoreBoard(ActionEvent actionEvent) throws Exception {
        ScoreBoardGraphic scoreBoardGraphic = new ScoreBoardGraphic();
        scoreBoardGraphic.start(mainStage);
    }

    public void openShopMenu(ActionEvent actionEvent) throws Exception {
        ShopGraphic shopGraphic = new ShopGraphic();
        shopGraphic.start(mainStage);
    }

}
