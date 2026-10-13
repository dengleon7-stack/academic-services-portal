import javax.swing.*;
import java.awt.*;

// PANEL 6: LIBRARY SERVICES
// Owner: library-team

public class LibraryPanel extends JPanel {

    public LibraryPanel(JFrame frame) {
        super(new BorderLayout(10, 10));

        JLabel title = new JLabel("Library Services");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // Search
        JPanel search = new JPanel(new BorderLayout());

        JTextField searchBox = new JTextField();
        JButton searchButton = new JButton("Search");

        search.add(new JLabel("Search: "), BorderLayout.WEST);
        search.add(searchBox, BorderLayout.CENTER);
        search.add(searchButton, BorderLayout.EAST);

        // Books
        String[] columns = {
                "ISBN", "Title", "Author", "Available"
        };

        Object[][] data = {
                {"978-0262046305", "Introduction to Algorithms", "Cormen", "3/5"},
                {"978-0134685991", "Effective Java", "Bloch", "2/3"},
                {"978-0596517748", "JavaScript", "Crockford", "1/2"},
                {"978-0135957059", "Pragmatic Programmer", "Thomas", "2/3"},
                {"978-0135166307", "Clean Code", "Martin", "1/3"}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JButton borrow = new JButton("Borrow Book");

        borrow.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a book."
                );
            } else {
                String book = table.getValueAt(row, 1).toString();

                JOptionPane.showMessageDialog(
                        frame,
                        "You borrowed: " + book
                );
            }
        });

        JPanel center = new JPanel(new BorderLayout(10, 10));
        center.add(search, BorderLayout.NORTH);
        center.add(scroll, BorderLayout.CENTER);
        center.add(borrow, BorderLayout.SOUTH);

        add(center, BorderLayout.CENTER);
    }
}
