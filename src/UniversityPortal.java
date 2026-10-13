import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main class - University Portal using CardLayout
// CardLayout lets us switch between panels without opening new windows
// This is good for a portal because all screens stay in one place
//
// Each service screen lives in its own file (see the *Panel classes) so that
// different teams can work on different screens without editing the same file.
// This class is the shared "shell" and is owned by the maintainers.

public class UniversityPortal  implements ActionListener {

    private JFrame frame;

    // CardLayout to switch between panels
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    // Buttons for navigation
    JButton btnDashboard, btnCourses, btnFees, btnResults, btnHostel, btnLibrary;

    // Constructor
    public UniversityPortal() {

        frame = new JFrame("University Student Portal");
        frame.setSize(1000, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Add top bar
        frame.add(createTopBar(), BorderLayout.NORTH);

        // Add navigation sidebar
        frame.add(createSidebar(), BorderLayout.WEST);

        // Add all the service panels to the main panel
        mainPanel.add(new DashboardPanel(),                 "dashboard");
        mainPanel.add(new CourseRegistrationPanel(frame),   "courses");
        mainPanel.add(new FeePaymentPanel(frame),           "fees");
        mainPanel.add(new ExamResultsPanel(frame),          "results");
        mainPanel.add(new HostelPanel(frame),               "hostel");
        mainPanel.add(new LibraryPanel(frame),              "library");

        frame.add(mainPanel, BorderLayout.CENTER);

        // Add status bar at the bottom
        frame.add(createStatusBar(), BorderLayout.SOUTH);

        // Show dashboard first
        cardLayout.show(mainPanel, "dashboard");

        frame.setVisible(true);
    }

    // Top bar with university name
    JPanel createTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(255, 255, 255));
        topBar.setPreferredSize(new Dimension(0, 50));
        topBar.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        JLabel title = new JLabel("University Academic Services Portal");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.black);

        // Load the logo image from the same folder as the program
        ImageIcon logoIcon = new ImageIcon("IUEA LOGO.png");

        // Resize it to fit the top bar (40x40 pixels)
        Image scaled = logoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(scaled);

        // Put the logo inside a JLabel
        JLabel logoImg = new JLabel(logoIcon);
        logoImg.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // small gap on right

        JLabel student = new JLabel("Student: Mohammed Abdelbagi Omer |  ID: 24/567/BIT-M  |  Sem IV 2026/27");
        student.setFont(new Font("Arial", Font.PLAIN, 12));
        student.setForeground(Color.LIGHT_GRAY);

        // Put logo and title side by side in one small panel
        JPanel leftSide = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        leftSide.setOpaque(false);
        leftSide.add(logoImg);
        leftSide.add(title);

        topBar.add(leftSide, BorderLayout.WEST);
        topBar.add(student, BorderLayout.EAST);

        return topBar;
    }

    // Sidebar with navigation buttons
    JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(255, 255, 255));
        sidebar.setPreferredSize(new Dimension(190, 0));
        sidebar.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JLabel menuLabel = new JLabel("  MAIN MENU");
        menuLabel.setFont(new Font("Arial", Font.BOLD, 11));
        menuLabel.setForeground(Color.GRAY);
        menuLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(menuLabel);
        sidebar.add(Box.createVerticalStrut(8));

        btnDashboard = makeNavButton("  Dashboard");
        btnCourses   = makeNavButton("  Course Registration");
        btnFees      = makeNavButton("  Fee Payment");
        btnResults   = makeNavButton("  Exam Results");
        btnHostel    = makeNavButton("  Hostel Application");
        btnLibrary   = makeNavButton("  Library Services");

        sidebar.add(btnDashboard);
        sidebar.add(btnCourses);
        sidebar.add(btnFees);
        sidebar.add(btnResults);
        sidebar.add(btnHostel);
        sidebar.add(btnLibrary);

        sidebar.add(Box.createVerticalGlue());

        return sidebar;
    }

    // Helper to create sidebar nav buttons
    JButton makeNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.PLAIN, 13));
        btn.setForeground(Color.gray);
        btn.setBackground(new Color(251, 251, 253));
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btn.addActionListener(this);
        return btn;
    }

    // Status bar at the bottom
    JPanel createStatusBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(new Color(230, 230, 230));
        bar.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));

        JLabel left  = new JLabel("Status: Connected | Session Active");
        JLabel right = new JLabel("Help: ict@university.ac.ke");
        left.setFont(new Font("Arial", Font.PLAIN, 11));
        right.setFont(new Font("Arial", Font.PLAIN, 11));

        bar.add(left,  BorderLayout.WEST);
        bar.add(right, BorderLayout.EAST);
        return bar;
    }


    // ActionListener - handles all navigation button clicks

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDashboard) cardLayout.show(mainPanel, "dashboard");
        if (e.getSource() == btnCourses)   cardLayout.show(mainPanel, "courses");
        if (e.getSource() == btnFees)      cardLayout.show(mainPanel, "fees");
        if (e.getSource() == btnResults)   cardLayout.show(mainPanel, "results");
        if (e.getSource() == btnHostel)    cardLayout.show(mainPanel, "hostel");
        if (e.getSource() == btnLibrary)   cardLayout.show(mainPanel, "library");
    }


    // MAIN METHOD

    public static void main(String[] args) {
        // Use system look and feel so it looks like a normal desktop app
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Run on the Event Dispatch Thread as required by Swing
        SwingUtilities.invokeLater(() -> new UniversityPortal());
    }
}
