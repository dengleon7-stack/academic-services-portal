import javax.swing.*;
import java.awt.*;

// PANEL 5: HOSTEL APPLICATION
// Owner: fees-hostel-team

public class HostelPanel extends JPanel {

    public HostelPanel(JFrame frame) {
        super(new BorderLayout(10, 10));

        JLabel title = new JLabel("Hostel Application");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(7, 2, 5, 5));

        JTextField name = new JTextField("Mohammed Omer");
        JTextField id = new JTextField("24/567/BIT-M");
        JTextField programme = new JTextField("BIT");

        JComboBox<String> year = new JComboBox<>(
                new String[]{"Year 1", "Year 2", "Year 3", "Year 4"}
        );

        JComboBox<String> room = new JComboBox<>(
                new String[]{"Single Room - $120", "Double Room - $80", "Triple Room - $60"}
        );

        JComboBox<String> priority = new JComboBox<>(
                new String[]{"Financial Need", "Distance", "Medical", "General"}
        );

        JTextField remarks = new JTextField();

        form.add(new JLabel("Full Name:"));
        form.add(name);

        form.add(new JLabel("Student ID:"));
        form.add(id);

        form.add(new JLabel("Programme:"));
        form.add(programme);

        form.add(new JLabel("Study Year:"));
        form.add(year);

        form.add(new JLabel("Room:"));
        form.add(room);

        form.add(new JLabel("Priority:"));
        form.add(priority);

        form.add(new JLabel("Remarks:"));
        form.add(remarks);

        JButton submit = new JButton("Submit Application");

        submit.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        frame,
                        "Application submitted successfully!"
                )
        );

        JPanel center = new JPanel(new BorderLayout(10, 10));
        center.add(form, BorderLayout.CENTER);
        center.add(submit, BorderLayout.SOUTH);

        add(center, BorderLayout.CENTER);
    }

    // helper to add a label + field row in GridBagLayout
    void addRow(JPanel p, GridBagConstraints gbc, int row, String label, JComponent field) {
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        p.add(new JLabel(label), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        field.setPreferredSize(new Dimension(250, 30));
        p.add(field, gbc);
    }
}
