
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        //frame.setLayout(new java.awt.FlowLayout());
        frame.setLayout(new java.awt.GridLayout(2, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome to Java Swing!");
        frame.getContentPane().add(label);

        JTextField textField = new JTextField(20);
        textField.setText("Type here...");
        frame.getContentPane().add(textField);

        JButton button = new JButton("Click Me!");
        // button.addActionListener(new java.awt.event.ActionListener() {
        //     @Override
        //     public void actionPerformed(java.awt.event.ActionEvent e) {
        //         System.out.println("Button clicked!");
        //     }
        // });
        button.addActionListener(e -> System.out.println("Button clicked!"));
        frame.getContentPane().add(button);

        JButton exitButton = new JButton("Exit");
        // exitButton.addActionListener(new java.awt.event.ActionListener() {
        //     @Override
        //     public void actionPerformed(java.awt.event.ActionEvent e) {
        //         System.exit(0);
        //     }
        // });
        exitButton.addActionListener(e -> System.exit(0));
        frame.getContentPane().add(exitButton);

        frame.setVisible(true);
    }
}
