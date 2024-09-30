package portalCalculadora;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;

public class calculadora extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	calculadora frame = new calculadora();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public calculadora() {
    	setTitle("Calculadora");
    	setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(550, 200, 350, 500);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("Archivo");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("No");
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem1 = new JMenuItem("Funciona");
        mnNewMenu.add(mntmNewMenuItem1);

        JMenuItem mntmNewMenuItem2 = new JMenuItem("Nada");
        mnNewMenu.add(mntmNewMenuItem2);

        JMenu mnNewMenu_1 = new JMenu("Edición");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmmnNewMenu1 = new JMenuItem("Esto");
        mnNewMenu_1.add(mntmmnNewMenu1);

        JMenuItem mntmmnNewMenu2 = new JMenuItem("Tampoco");
        mnNewMenu_1.add(mntmmnNewMenu2);

        JMenu mnNewMenu_2 = new JMenu("Ayuda");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmmnmnNewMenu1 = new JMenuItem("Ni");
        mnNewMenu_2.add(mntmmnmnNewMenu1);


        JMenuItem mntmmnmnNewMenu2 = new JMenuItem("Esto");
        mnNewMenu_2.add(mntmmnmnNewMenu2);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setEditable(false); // Hacer que el campo de texto no sea editable
        textField.setBackground(new Color(224, 197, 254));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField.setBounds(10, 11, 314, 56);
        contentPane.add(textField);
        textField.setColumns(10);
        textField.setFocusable(false); // Desactivar el enfoque del campo de texto



        /*We create the buttons*/

        JButton btn1 = new JButton("7");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "7");
            }
        });
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1.setBounds(10, 245, 65, 65);
        btn1.setFocusable(false);
        contentPane.add(btn1);

        JButton btn1_1 = new JButton("8");
        btn1_1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "8");
        }
        });
        btn1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_1.setBounds(92, 245, 65, 65);
        btn1_1.setFocusable(false);
        contentPane.add(btn1_1);

        JButton btn1_2 = new JButton("9");
        btn1_2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "9");
        }
        });
        btn1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_2.setBounds(174, 245, 65, 65);
        btn1_2.setFocusable(false);
        contentPane.add(btn1_2);

        JButton btn1_3 = new JButton("4");
        btn1_3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "4");
        }
        });
        btn1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_3.setBounds(10, 159, 65, 65);
        btn1_3.setFocusable(false);
        contentPane.add(btn1_3);

        JButton btn1_4 = new JButton("5");
        btn1_4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "5");
        }
        });
        btn1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_4.setBounds(92, 159, 65, 65);
        btn1_4.setFocusable(false);
        contentPane.add(btn1_4);

        JButton btn1_5 = new JButton("6");
        btn1_5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "6");
        }
        });
        btn1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_5.setBounds(174, 159, 65, 65);
        btn1_5.setFocusable(false);
        contentPane.add(btn1_5);

        JButton btn1_6 = new JButton("1");
        btn1_6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "1");
        }
        });
        btn1_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_6.setBounds(10, 78, 65, 65);
        btn1_6.setFocusable(false);
        contentPane.add(btn1_6);

        JButton btn1_7 = new JButton("2");
        btn1_7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "2");
        }
        });
        btn1_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_7.setBounds(92, 78, 65, 65);
        btn1_7.setFocusable(false);
        contentPane.add(btn1_7);

        JButton btn1_8 = new JButton("3");
        btn1_8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "3");
        }
        });
        btn1_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_8.setBounds(174, 78, 65, 65);
        btn1_8.setFocusable(false);
        contentPane.add(btn1_8);

        JButton btn1_9 = new JButton("C");
        btn1_9.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText("");
        }
        });
        btn1_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_9.setBounds(10, 331, 65, 65);
        btn1_9.setFocusable(false);
        contentPane.add(btn1_9);

        JButton btn1_10 = new JButton("0");
        btn1_10.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "0");
        }
        });
        btn1_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_10.setBounds(92, 331, 65, 65);
        btn1_10.setFocusable(false);
        contentPane.add(btn1_10);

        JButton btn1_11 = new JButton("=");
        btn1_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String expression = textField.getText();
            double result = evaluateExpression(expression);
            textField.setText(Double.toString(result));
            }
        });
        btn1_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_11.setBounds(170, 331, 65, 65);
        btn1_11.setFocusable(false);
        contentPane.add(btn1_11);

        JButton btn1_12 = new JButton("+");
        btn1_12.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + "+");
        }
        });
        btn1_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_12.setBounds(259, 331, 65, 65);
        btn1_12.setFocusable(false);
        contentPane.add(btn1_12);

        JButton btn1_13 = new JButton("-");
        btn1_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            textField.setText(textField.getText() + "-");
            }
        });
        btn1_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_13.setBounds(259, 245, 65, 65);
        btn1_13.setFocusable(false);
        contentPane.add(btn1_13);

        JButton btn1_14 = new JButton("x");
        btn1_14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            textField.setText(textField.getText() + "x");
            }
        });
        btn1_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_14.setBounds(259, 78, 65, 65);
        btn1_14.setFocusable(false);
        contentPane.add(btn1_14);

        JButton btn1_15 = new JButton("÷");
        btn1_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            textField.setText(textField.getText() + "÷");
            }
        });
        btn1_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn1_15.setBounds(259, 159, 65, 65);
        btn1_15.setFocusable(false);
        contentPane.add(btn1_15);
        }


    /*Exceptions*/
    
    
    
        private double evaluateExpression(String expression) {
        double result = 0;
        try {
            result = eval(expression);
        } catch (Exception e) {
            textField.setText("Error");
        }
        return result;
        }

        private double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
            }

            double parse() {
            nextChar();
            double x = parseExpression();
            if (pos < str.length()) throw new
RuntimeException("Unexpected: " + (char) ch);
            return x;
            }


            /*We create the functions for each button*/
            double parseExpression() {
            double x = parseTerm();
            for (; ; ) {
                if (eat('+')) x += parseTerm();
                else if (eat('-')) x -= parseTerm();
                else return x;
            }
            }

            double parseTerm() {
            double x = parseFactor();
            for (; ; ) {
                if (eat('x')) x *= parseFactor();
                else if (eat('÷')) x /= parseFactor();
                else return x;
            }
            }

            double parseFactor() {
            if (eat('+')) return parseFactor();
            if (eat('-')) return -parseFactor();

            double x;
            int startPos = this.pos;
            if (eat('(')) {
                x = parseExpression();
                eat(')');
            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                x = Double.parseDouble(str.substring(startPos, this.pos));
            } else {
                throw new RuntimeException("Unexpected: " + (char) ch);
            }

            return x;
            }
        }.parse();
        }
    }
