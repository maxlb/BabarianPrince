import javax.swing.*;

public class BoutonPanel extends JPanel {

    private JButton btn;

    public BoutonPanel(String btn) {
        this(new JButton(btn));
    }

    public BoutonPanel(JButton btn) {
        this.btn = btn;
    }
}