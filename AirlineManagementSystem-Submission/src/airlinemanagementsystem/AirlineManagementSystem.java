package airlinemanagementsystem;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/** Application entry point for the Airline Management System. */
public final class AirlineManagementSystem {
    private AirlineManagementSystem() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
                // The default Swing look and feel remains a safe fallback.
            }
            new Login();
        });
    }
}
