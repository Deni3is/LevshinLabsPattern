package view;

import controller.DrawingController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ColorDialog extends JDialog {
    private static final long serialVersionUID = 0;
    private DrawingController c;
    private JColorChooser colorChooser = new JColorChooser();
    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("Cancel");

    public ColorDialog(final ToolBox tb) {
        setTitle("Color Dialog");
        setLayout(new BorderLayout());
        add(colorChooser, BorderLayout.NORTH);
        JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jp.add(okButton);
        jp.add(cancelButton);
        add(jp, BorderLayout.SOUTH);
        pack();
        setVisible(true);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                setVisible(false);
                tb.setColor(colorChooser.getColor());
                c.colorSelectedShapes(colorChooser.getColor());
                c.getDrawing().repaint();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                setVisible(false);
            }
        });
    }
}
