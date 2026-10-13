import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// PANEL 3: FEE PAYMENT
// Handles money-related screens, so changes need extra care.
// Owner: fees-hostel-team (maintainers can also approve)

public class FeePaymentPanel extends JPanel {

    public FeePaymentPanel(JFrame frame) {
        super(new BorderLayout(10, 10));
        setBackground(new Color(245, 245, 250));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel heading = new JLabel("Fee Payment - Semester IV 2026/27");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        // Summary at the top
        JPanel summary = new JPanel(new GridLayout(1, 3, 10, 0));
        summary.setBackground(new Color(245, 245, 250));
        summary.setPreferredSize(new Dimension(0, 80));

        summary.add(makeFeeBox("Total Fees",  "$1,000", Color.DARK_GRAY));
        summary.add(makeFeeBox("Amount Paid", "$650", new Color(39, 174, 96)));
        summary.add(makeFeeBox("Balance Due", "$350", new Color(192, 57, 43)));

        // Fee breakdown table
        String[] cols = {"Fee Item", "Amount (USD)", "Paid (USD)", "Balance (USD)"};

        Object[][] rows = {
                {"Tuition Fee",       "$600", "$400", "$200"},
                {"Examination Fee",   "$50",  "$50",  "$0"},
                {"Registration Fee",  "$30",  "$30",  "$0"},
                {"Caution Fee",       "$80",  "$50",  "$30"},
                {"ICT Fee",           "$40",  "$0",   "$40"},
                {"Library Fee",       "$30",  "$0",   "$30"},
                {"Student Union Fee", "$20",  "$0",   "$20"},
                {"Medical Cover",     "$50",  "$0",   "$50"},
                {"Activity Fee",      "$30",  "$0",   "$30"},
                {"Accommodation",     "$70",  "$0",   "$70"},
        };

        JTable table = new JTable(new DefaultTableModel(rows, cols) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        });

        table.setRowHeight(27);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));

        JScrollPane scroll = new JScrollPane(table);

        // Payment form on the right
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createTitledBorder("Make a Payment"));
        form.setPreferredSize(new Dimension(230, 0));

        String[] methods = {
                "Bank Transfer",
                "Credit Card",
                "Debit Card",
                "Mobile Money"
        };

        JComboBox<String> methodBox = new JComboBox<>(methods);

        // Default payment amount is the current balance
        JTextField amountField = new JTextField("350");

        JTextField refField = new JTextField();

        methodBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        amountField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        refField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        form.add(new JLabel("Payment Method:"));
        form.add(Box.createVerticalStrut(3));
        form.add(methodBox);

        form.add(Box.createVerticalStrut(8));
        form.add(new JLabel("Amount (USD):"));
        form.add(Box.createVerticalStrut(3));
        form.add(amountField);

        form.add(Box.createVerticalStrut(8));
        form.add(new JLabel("Reference Code:"));
        form.add(Box.createVerticalStrut(3));
        form.add(refField);

        form.add(Box.createVerticalStrut(12));

        JButton payBtn = new JButton("Submit Payment");
        payBtn.setBackground(new Color(39, 174, 96));
        payBtn.setForeground(Color.WHITE);
        payBtn.setFont(new Font("Arial", Font.BOLD, 12));
        payBtn.setFocusPainted(false);
        payBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        payBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        payBtn.addActionListener(e -> {
            String amt = amountField.getText().trim();
            String ref = refField.getText().trim();

            if (amt.isEmpty() || ref.isEmpty()) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Please fill in all fields."
                );
                return;
            }

            JOptionPane.showMessageDialog(
                    frame,
                    "Payment of $" + amt + " submitted!\nReference: " + ref
            );
        });

        form.add(payBtn);

        JPanel centre = new JPanel(new BorderLayout(10, 0));
        centre.setBackground(new Color(245, 245, 250));
        centre.add(scroll, BorderLayout.CENTER);
        centre.add(form, BorderLayout.EAST);

        JPanel inner = new JPanel(new BorderLayout(0, 10));
        inner.setBackground(new Color(245, 245, 250));
        inner.add(summary, BorderLayout.NORTH);
        inner.add(centre, BorderLayout.CENTER);

        add(inner, BorderLayout.CENTER);
    }

    private JPanel makeFeeBox(String label, String amount, Color color) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JLabel lbl = new JLabel(label, SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.PLAIN, 12));
        lbl.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        JLabel amt = new JLabel(amount, SwingConstants.CENTER);
        amt.setFont(new Font("Arial", Font.BOLD, 18));
        amt.setForeground(color);
        p.add(lbl, BorderLayout.NORTH);
        p.add(amt, BorderLayout.CENTER);
        return p;
    }
}
