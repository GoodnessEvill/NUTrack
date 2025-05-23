package view;

import model.DBManager;
import model.User;

import javax.swing.*;
import java.awt.*;

// This class creates a dialog to update user's height and weight
public class UpdateUserInfoDialog extends JDialog {

    // Constructor
    public UpdateUserInfoDialog(JFrame parent, User user, DBManager dbManager) {
        super(parent, "Bilgileri Güncelle", true); // modal dialog with parent frame
        setSize(300, 200);
        setLocationRelativeTo(parent); // center the dialog
        setLayout(new GridLayout(4, 2, 10, 10)); // grid layout

        // Height input label and field
        JLabel heightLabel = new JLabel("Yeni Boy (cm):");
        JTextField heightField = new JTextField(String.valueOf(user.getHeight()));

        // Weight input label and field
        JLabel weightLabel = new JLabel("Yeni Kilo (kg):");
        JTextField weightField = new JTextField(String.valueOf(user.getWeight()));

        // Update and Cancel buttons
        JButton updateButton = new JButton("Güncelle");
        JButton cancelButton = new JButton("İptal");

        // When Update button is clicked
        updateButton.addActionListener(e -> {
            try {
                // Read new values from fields
                double newHeight = Double.parseDouble(heightField.getText().trim());
                double newWeight = Double.parseDouble(weightField.getText().trim());

                // Try to update in database
                boolean updated = dbManager.updateUserHeightWeight(user.getId(), newHeight, newWeight);
                if (updated) {
                    JOptionPane.showMessageDialog(this, "Bilgiler güncellendi.");

                    // 🔁 Get updated user from database
                    User updatedUser = dbManager.validateLogin(user.getUsername(), user.getPassword());

                    // ❌ Close current info screen if any
                    Window parentWindow = SwingUtilities.getWindowAncestor(this);
                    parentWindow.dispose();

                    // Open updated info screen
                    dispose(); // close this dialog
                    new UserInfoDisplay(updatedUser, dbManager);

                } else {
                    // Show error if update failed
                    JOptionPane.showMessageDialog(this, "Güncelleme başarısız.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                // Show warning if inputs are not valid numbers
                JOptionPane.showMessageDialog(this, "Lütfen geçerli sayılar girin.", "Hatalı Giriş", JOptionPane.ERROR_MESSAGE);
            }
        });

        // When Cancel button is clicked
        cancelButton.addActionListener(e -> dispose());

        // Add all components to the dialog
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(updateButton);
        add(cancelButton);

        setVisible(true); // show the dialog
    }
}
