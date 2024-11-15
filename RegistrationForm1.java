package RegistrationForm1;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableApplet extends JApplet {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField addressField;
    private JTextField contactField;

    public void init() {
        // Initialize the table model with column headers
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"Name", "Age", "Gender", "Address", "Contact"});

        // Create and set up the table
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create input fields
        nameField = new JTextField(10);
        ageField = new JTextField(10);
        addressField = new JTextField(10);
        contactField = new JTextField(10);

        // Create gender combo box for selection
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});

        // Create the Add button
        JButton addButton = new JButton("Add");

        // Add ActionListener to the button to add data to the table
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from the input fields and combo box
                String name = nameField.getText();
                String age = ageField.getText();
                String gender = (String) genderComboBox.getSelectedItem();
                String address = addressField.getText();
                String contact = contactField.getText();

                // Add the data as a new row to the table
                tableModel.addRow(new Object[]{name, age, gender, address, contact});

                // Clear the input fields for the next entry
                nameField.setText("");
                ageField.setText("");
                addressField.setText("");
                contactField.setText("");
            }
        });

        // Layout setup
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        // Panel for input fields and button
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Gender:"));
        inputPanel.add(genderComboBox);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Contact:"));
        inputPanel.add(contactField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.SOUTH);
    }
}