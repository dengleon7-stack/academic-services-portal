import javax.swing.*;
import java.awt.*;

// PANEL 4: EXAM RESULTS
// Owner: registration-results-team

public class ExamResultsPanel extends JPanel {

    public ExamResultsPanel(JFrame frame) {
        super(new BorderLayout(10, 10));

        JLabel title = new JLabel("Examination Results");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // GPA
        JPanel gpa = new JPanel(new GridLayout(1, 3));

        gpa.add(new JLabel("Semester GPA: 3.72"));
        gpa.add(new JLabel("Cumulative GPA: 3.65"));
        gpa.add(new JLabel("Class: 2nd Upper"));

        // Results table
        String[] columns = {
                "Unit Code", "Unit Name", "CAT", "Exam", "Total", "Grade"
        };

        Object[][] data = {
                {"CS301", "Data Structures", 24, 55, 79, "A-"},
                {"CS302", "Operating Systems", 26, 52, 78, "A-"},
                {"CS303", "Database Systems", 28, 58, 86, "A"},
                {"CS304", "Software Engineering", 22, 50, 72, "B+"},
                {"CS305", "Computer Networks", 19, 45, 64, "B-"},
                {"MATH301", "Numerical Analysis", 25, 47, 72, "B+"}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        // Print button
        JButton print = new JButton("Print Transcript");

        print.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        frame,
                        "Transcript sent to printer."
                )
        );

        JPanel center = new JPanel(new BorderLayout(10, 10));
        center.add(gpa, BorderLayout.NORTH);
        center.add(scroll, BorderLayout.CENTER);
        center.add(print, BorderLayout.SOUTH);

        add(center, BorderLayout.CENTER);
    }
}
