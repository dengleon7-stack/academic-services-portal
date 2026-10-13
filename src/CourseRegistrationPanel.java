import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// PANEL 2: COURSE REGISTRATION
// Owner: registration-results-team

public class CourseRegistrationPanel extends JPanel {

    public CourseRegistrationPanel(JFrame frame) {
        super(new BorderLayout(10, 10));
        setBackground(new Color(245, 245, 250));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel heading = new JLabel("Course Registration - Semester IV 2026/27");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        // Table of available courses
        String[] columns = {"Code", "Unit Name", "Credit Hrs", "Lecturer", "Status"};
        Object[][] data = {
                {"CS301", "Data Structures & Algorithms",  3, "Dr. A. Mwangi",  "Available"},
                {"CS302", "Operating Systems",             3, "Prof. J. Ochieng","Available"},
                {"CS303", "Database Systems",              3, "Dr. M. Kariuki",  "Available"},
                {"CS304", "Software Engineering",          3, "Dr. S. Njoroge",  "Available"},
                {"CS305", "Computer Networks",             3, "Prof. P. Wambua", "Full"},
                {"CS306", "Artificial Intelligence",       3, "Dr. L. Mutua",    "Available"},
                {"CS307", "Mobile App Development",        3, "Mr. D. Otieno",   "Available"},
                {"MATH301","Numerical Analysis",           3, "Dr. R. Gacheru",  "Available"},
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            public boolean isCellEditable(int r, int c) { return false; }
        };

        JTable table = new JTable(model);
        table.setRowHeight(28);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        table.setSelectionBackground(new Color(173, 216, 230));

        JScrollPane scroll = new JScrollPane(table);

        // Right side summary panel
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBackground(Color.WHITE);
        right.setBorder(BorderFactory.createTitledBorder("Registration Summary"));
        right.setPreferredSize(new Dimension(220, 0));

        right.add(new JLabel("Max credit hours: 10"));
        right.add(Box.createVerticalStrut(5));
        right.add(new JLabel("Registered so far: 6"));
        right.add(Box.createVerticalStrut(5));
        right.add(new JLabel("Remaining: 4"));
        right.add(Box.createVerticalStrut(12));
        right.add(new JLabel("Already registered:"));
        right.add(Box.createVerticalStrut(4));
        right.add(new JLabel("  CS301 - Data Structures"));
        right.add(new JLabel("  CS302 - Operating Systems"));
        right.add(Box.createVerticalGlue());

        JButton registerBtn = new JButton("Register Selected Unit");
        registerBtn.setBackground(new Color(41, 128, 185));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(new Font("Arial", Font.BOLD, 12));
        registerBtn.setFocusPainted(false);
        registerBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a unit first.");
                return;
            }
            String status = (String) model.getValueAt(row, 4);
            String name   = (String) model.getValueAt(row, 1);
            if (status.equals("Full")) {
                JOptionPane.showMessageDialog(frame, name + " is full. Choose another.");
                return;
            }
            int choice = JOptionPane.showConfirmDialog(frame,
                    "Register for " + name + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
                JOptionPane.showMessageDialog(frame, "Successfully registered for " + name + "!");
        });
        right.add(registerBtn);

        JPanel centre = new JPanel(new BorderLayout(10, 0));
        centre.setBackground(new Color(245, 245, 250));
        centre.add(scroll, BorderLayout.CENTER);
        centre.add(right,  BorderLayout.EAST);

        add(centre, BorderLayout.CENTER);
    }
}
