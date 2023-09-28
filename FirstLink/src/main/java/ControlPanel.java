import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.Manipulator;
import visual.MyFrame;

import javax.swing.*;

public class ControlPanel {
    private final static String path = "C:\\Users\\sara.molnar\\OneDrive - ACCESA\\Documents\\credentials.json";
    private final static Logger logger = LogManager.getLogger("shop");
    static Connection connection;

    public static void main(String[] args) throws SQLException, IOException, ParseException {

        MyFrame frame = new MyFrame();

        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(0,0, 750, 100);
        inputPanel.setBackground(new Color(0x36c771));
        inputPanel.setVisible(true);
        JLabel idLabel = new JLabel("Provide the id of the product: ");

        JLabel resultLabel = new JLabel();
        resultLabel.setVisible(false);
        resultLabel.setBounds(100,100,300,25);
        frame.add(resultLabel);

        JTextField idField = new JTextField();
        idField.setColumns(10);

        inputPanel.add(idLabel);
        inputPanel.add(idField);

        Button searchButton = new Button("Search");
        searchButton.setBounds(600, 50, 75, 25);
        frame.add(searchButton);

        frame.add(inputPanel);
        frame.setVisible(true);

        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(path);
        Object object = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) object;
        String url = (String) jsonObject.get("url");
        String user = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        char[] s = password.toCharArray();
        for(int i=0; i<s.length; i++)
            s[i] -= 7;
        password = new String(s);
        System.out.println(password);
        try {
            connection = DriverManager.getConnection(url, user, password);
            logger.info("Connected");
            System.out.println("Connected");
            Statement statement = connection.createStatement();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE product_id = " + idField.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                ResultSet resultSet = null;
                try {
                    resultSet = preparedStatement.executeQuery();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String message = "";
                while(true){
                    try {
                        if (!resultSet.next()) break;
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        message += resultSet.getInt(1) + "; ";
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        message += resultSet.getString(2) + "; ";
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        message += resultSet.getInt(3) + "; ";
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        message += resultSet.getDouble(4) + " ";
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    resultLabel.setText(message);
                    resultLabel.setVisible(true);
                    resultLabel.setOpaque(true);
                    resultLabel.setBackground( new Color(0x36c771));
                }
            }
        });
    }
}
