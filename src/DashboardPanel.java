import javax.swing.*;
import java.awt.*;

// PANEL 1: DASHBOARD
// Landing page with quick-access tiles and alerts.
// Owner: maintainers (shared landing page)

public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        super(new BorderLayout(10, 10));
        setBackground(new Color(245, 245, 250));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Page title
        JLabel heading = new JLabel("Welcome, Mohammed Omer !");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading, BorderLayout.NORTH);

        // Grid of quick-access cards
        JPanel grid = new JPanel(new GridLayout(2, 3, 12, 12));
        grid.setBackground(new Color(245, 245, 250));

        grid.add(makeTile("Course Registration", "Register for units this semester",   new Color(0, 0, 0)));
        grid.add(makeTile("Fee Payment",         "View balance and pay fees",           new Color(0, 0, 0)));
        grid.add(makeTile("Exam Results",        "Check your grades and transcript",    new Color(0, 0, 0)));
        grid.add(makeTile("Hostel Application",  "Apply for campus accommodation",      new Color(0, 0, 0)));
        grid.add(makeTile("Library Services",    "Borrow books and e-resources",        new Color(0, 0, 0)));
        grid.add(makeTile("Notifications",       "3 items need your attention",         new Color(0, 0, 0)));

        add(grid, BorderLayout.CENTER);

        // Alerts at bottom
        JPanel alerts = new JPanel(new GridLayout(1, 3, 10, 0));
        alerts.setBackground(new Color(245, 245, 250));
        alerts.add(makeAlert("Fee balance USD 350  due 31 Oct", new Color(255, 243, 205)));
        alerts.add(makeAlert("Course registration closes 15 Oct",  new Color(204, 229, 255)));
        alerts.add(makeAlert("Semester IV results have been released", new Color(212, 237, 218)));

        add(alerts, BorderLayout.SOUTH);
    }

    private JPanel makeTile(String title, String desc, Color color) {
        JPanel tile = new JPanel(new BorderLayout());
        tile.setBackground(Color.WHITE);
        tile.setBorder(BorderFactory.createLineBorder(color, 2));

        JPanel top = new JPanel();
        top.setBackground(color);
        JLabel t = new JLabel(title);
        t.setFont(new Font("Arial", Font.BOLD, 13));
        t.setForeground(Color.WHITE);
        t.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        top.add(t);

        JLabel d = new JLabel("<html><center>" + desc + "</center></html>");
        d.setFont(new Font("Arial", Font.PLAIN, 12));
        d.setForeground(Color.DARK_GRAY);
        d.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        d.setHorizontalAlignment(SwingConstants.CENTER);

        tile.add(top, BorderLayout.NORTH);
        tile.add(d,   BorderLayout.CENTER);
        return tile;
    }

    private JPanel makeAlert(String msg, Color bg) {
        JPanel p = new JPanel();
        p.setBackground(bg);
        p.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
        JLabel l = new JLabel("<html>" + msg + "</html>");
        l.setFont(new Font("Arial", Font.PLAIN, 11));
        p.add(l);
        return p;
    }
}
