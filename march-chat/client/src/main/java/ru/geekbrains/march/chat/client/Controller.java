package ru.geekbrains.march.chat.client;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    TextField msgField, loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    TextArea msgArea;

    @FXML
    HBox loginPanel, msgPanel;

    @FXML
    ListView<String> clientsList;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;
    private boolean authentificated;

    public void setAuthentificated(boolean authentificated) {
        this.authentificated = authentificated;
        loginPanel.setVisible(!authentificated);
        loginPanel.setManaged(!authentificated);
        msgPanel.setVisible(authentificated);
        msgPanel.setManaged(authentificated);
        clientsList.setManaged(authentificated);
        clientsList.setVisible(authentificated);
        if (!authentificated) {
            username = "";
        }
    }

    public void setUsername(String username) {
        this.username = username;
        boolean usernameIsNull = username == null;
        loginPanel.setVisible(usernameIsNull);
        loginPanel.setManaged(usernameIsNull);
        msgPanel.setVisible(!usernameIsNull);
        msgPanel.setManaged(!usernameIsNull);
        clientsList.setVisible(!usernameIsNull);
        clientsList.setManaged(!usernameIsNull);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUsername(null);
    }

    public void login() {
        if (loginField.getText().isEmpty()) {
            showErrorAlert("Имя пользователя не может быть пустым");
            return;
        }

        if (socket == null || socket.isClosed()) {
            connect();
        }

        try {
            out.writeUTF("/login " + loginField.getText() + " " + passwordField.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread t = new Thread(() -> {
                try {
                    // Цикл авторизации
                    while (true) {
                        String msg = in.readUTF();
                        if (msg.startsWith("/login_ok ")) {
                            setUsername(msg.split("\\s")[1]);
                            break;
                        }
                        if (msg.startsWith("/login_failed ")) {
                            String cause = msg.split("\\s", 2)[1];
                            msgArea.appendText(cause + "\n");
                        }
                    }
                    // Цикл общения
                    while (true) {
                        String msg = in.readUTF();
                        if (msg.startsWith("/")) {
                            if (msg.startsWith("/clients_list ")) {
                                // /clients_list Bob Max Jack
                                String[] tokens = msg.split("\\s");
                                Platform.runLater(() -> {
                                    clientsList.getItems().clear();
                                    for (int i = 1; i < tokens.length; i++) {
                                        clientsList.getItems().add(tokens[i]);
                                    }
                                });
                            }
                            continue;
                        } else {
                            msgArea.appendText(msg + "\n");
                       saveHistory();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    disconnect();
                }
            });
            t.start();
        } catch (IOException e) {
            showErrorAlert("Невозможно подключиться к серверу");
        }
    }

    public void sendMsg() {
        try {
            out.writeUTF(msgField.getText());
            msgField.clear();
            msgField.requestFocus();
            saveHistory();

        } catch (IOException e) {
            showErrorAlert("Невозможно отправить сообщение");
        }
    }

    private void disconnect() {
        setUsername(null);
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle("March Chat FX");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    private void saveHistory() throws IOException {
        try {
            File history = new File("history.txt");
            PrintWriter fileWriter = new PrintWriter(new FileWriter(history, false));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(msgArea.getText());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //   С сохранением истории всё получилось, но с загрузкой её не получилось внизу код попыток, плюс еще попытался вопреки вашим
    //   словам попробовать задание про 100 последних сообщений, но ни так ни так не вышло. Туговато с пониманием как именно
    //   доставать текст из файла.



//    private void loadHistory() throws IOException {
//
//        try(OutputStream out = new BufferedOutputStream(new FileOutputStream("history.txt"))) {
//            List<String> historyList = new ArrayList<>();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       FileInputStream in = new FileInputStream(history);
//       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//       String temp;
//      while ((temp = bufferedReader.readLine()) != null) {
//           historyList.add(temp);
//       }
//    }
//    }
//        if (historyList.size() > posHistory) {
//            for(int i = historyList.size() - posHistory; i <= (historyList.size() - 1); i++) {
//                msgArea.appendText(historyList.get(i) + "\n");
//            }
//        } else {
//            for (int i = 0; i < posHistory; i++) {
//                System.out.println(historyList.get(i));
//            }
//        }
//    }
}
