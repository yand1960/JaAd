package my.desktop;

import my.buslog.ProductService;
import my.buslog.ProductServiceImpl;
import my.dal.RepositoryJDBC;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ProductsFrame extends JFrame {

    private ProductService service = new ProductServiceImpl(
            new RepositoryJDBC()
    );

    public ProductsFrame() {
        this.setLayout(null);
        this.setBounds(50,50, 300, 300);

        JTextArea area = new JTextArea();

        JTextField txt = new JTextField();
        txt.setBounds(10, 10, 260, 20);
        txt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //area.setText(txt.getText());
                String out = "";
                for(var p: service.productsByFirstLetters(txt.getText())){
                    out += p.getName() + "\n";
                }
                area.setText(out);
            }
        });

        JScrollPane pane = new JScrollPane(area);
        pane.setBounds(10, 40, 260, 210);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(txt);
        this.add(pane);

    }


    public static void main(String[] args) {
        ProductsFrame frame = new ProductsFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
