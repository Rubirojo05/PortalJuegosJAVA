package portalCalculadora;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class portal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel;
    private int contador=0;
    private JButton btnJuego;
    private JButton btnJuego2;
    private JButton btnJuego3;
    private JButton btnJuego4;
    private int resultado = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    portal frame = new portal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public portal() {
        setResizable(false);
        setTitle("Portal de juegos");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(400, 100, 1100, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        //CERRAR
       
         
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (contador == 0) {
                    contador++;

                    btnJuego.setEnabled(false);
                    btnJuego2.setEnabled(false);
                    btnJuego3.setEnabled(false);
                    btnJuego4.setEnabled(false);

                    int opcion = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro de que quieres cerrar la ventana?", "Confirmación",
                            JOptionPane.YES_NO_OPTION);
                    if (opcion == JOptionPane.YES_OPTION) {

                        JFrame frame = new JFrame("Contador de 30 segundos");
                        JLabel label = new JLabel("Tiempo restante: 30 segundos");
                        frame.add(label);
                        frame.setEnabled(false);
                        frame.setSize(300, 200);
                        frame.setLocation(900, 240);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);

                        // Lanzar la calculadora
                        calculadora calcu = new calculadora();
                        calcu.setVisible(true);
                        
                        // Panel para contener los elementos
                        // Crear la ventana de respuesta
                        JFrame ventanaRespuesta = new JFrame("Resolver Operación");
                        ventanaRespuesta.setSize(300, 200); // Establecer tamaño de la ventana
                        ventanaRespuesta.setLocation(900, 450); // Establecer posición de la ventana
                        ventanaRespuesta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
                        ventanaRespuesta.setResizable(false); // Evitar que el usuario redimensione la ventana
                        ventanaRespuesta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        
                        //temporizador
                        Timer timer = new Timer(1000, new ActionListener() {
                            int segundos = 30;

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                segundos--;
                                label.setText("Tiempo restante: " + segundos + " segundos");
                                if (segundos == 0) {
                                    ((Timer) e.getSource()).stop();
                                    JOptionPane.showMessageDialog(null, "¡Tiempo agotado!");
                                    btnJuego.setEnabled(true);
                                    btnJuego2.setEnabled(true);
                                    btnJuego3.setEnabled(true);
                                    btnJuego4.setEnabled(true);
                                    calcu.dispose();
                                    ventanaRespuesta.dispose();
                                    frame.dispose();
                                }
                            }
                        });
                        timer.start();

                        // Panel para contener los elementos
                        JPanel panelRespuesta = new JPanel();
                        ventanaRespuesta.getContentPane().add(panelRespuesta, BorderLayout.CENTER);
                        panelRespuesta.setLayout(new GridLayout(3, 1));

                        // Generar la operación aleatoria nuevamente
                        Random random = new Random();
                        int num1 = random.nextInt(100);
                        int num2 = random.nextInt(100);
                        String[] operaciones = {"+", "-", "*", "/"};
                        String operacion = operaciones[random.nextInt(operaciones.length)];

                        
                        switch (operacion) {
                            case "+":
                                resultado = num1 + num2;
                                break;
                            case "-":
                                resultado = num1 - num2;
                                break;
                            case "*":
                                resultado = num1 * num2;
                                break;
                            case "/":
                                resultado = num1 / (num2 != 0 ? num2 : 1); // Evitar división por cero
                                break;
                        }

                        // Etiqueta con la operación para que el usuario la vea
                        JLabel lblOperacion = new JLabel("Resuelve la operación: " + num1 + " " + operacion + " " + num2);
                        lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
                        panelRespuesta.add(lblOperacion);

                        // Campo de texto para que el usuario ingrese su respuesta
                        JTextField txtRespuesta = new JTextField();
                        txtRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
                        panelRespuesta.add(txtRespuesta);

                        // Botón para verificar la respuesta
                        JButton btnVerificar = new JButton("Verificar");
                        panelRespuesta.add(btnVerificar);

                        ventanaRespuesta.setVisible(true);

                     // Acción del botón Verificar
                        btnVerificar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    // Obtener la respuesta ingresada por el usuario y convertirla a entero
                                    int respuestaUsuario = Integer.parseInt(txtRespuesta.getText());

                                    // Verificar si la respuesta del usuario es correcta
                                    if (respuestaUsuario == resultado) {
                                        JOptionPane.showMessageDialog(null, "¡Respuesta Correcta!");
                                        // Cerrar la ventana después de verificar la respuesta
                                        //ventanaRespuesta.dispose();
                                        
                                        // Detener el temporizador
                                        timer.stop();
                                        
                                        // Crear la ventana emergente para mostrar las felicitaciones
                                        JFrame ventanaFelicidades = new JFrame("¡Felicidades!");
                                        ventanaFelicidades.setSize(300, 200); // Establecer el tamaño de la ventana
                                        ventanaFelicidades.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
                                        ventanaFelicidades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
                                        ventanaFelicidades.setLayout(new FlowLayout()); // Establecer el diseño de la ventana
                                        ventanaFelicidades.setAlwaysOnTop(true); // Mantener la ventana siempre al frente

                                        // Crear el botón de felicitaciones
                                        JButton btnFelicidades = new JButton("¡Felicidades!");
                                        btnFelicidades.setPreferredSize(new Dimension(200, 100)); // Establecer el tamaño del botón
                                        btnFelicidades.setFont(new Font("Tahoma", Font.BOLD, 20)); // Establecer la fuente del texto del botón
                                        
                                        // Acción del botón de felicitaciones
                                        btnFelicidades.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                // Cerrar todas las ventanas
                                                for (Window window : Window.getWindows()) {
                                                    window.dispose();
                                                }
                                            }
                                        });

                                        // Agregar el botón a la ventana
                                        ventanaFelicidades.add(btnFelicidades);

                                        // Hacer visible la ventana de felicitaciones
                                        ventanaFelicidades.setVisible(true);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Respuesta Incorrecta. Vuelve a probar con otro número entero.");
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
                                }
                            }
                        });


                        //ventana ususario respuesta FIN

                    } else {
                        btnJuego.setEnabled(true);
                        btnJuego2.setEnabled(true);
                        btnJuego3.setEnabled(true);
                        btnJuego4.setEnabled(true);
                        contador = 0;
                    }
                }
            }
        });
		
        

        //PANELES

        panel = new JPanel();
        panel.setBackground(new Color(0, 0, 128));
        panel.setBounds(0, 0, 1084, 611);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1084, 68);
        panel_1.setBackground(new Color(183, 0, 183));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 185, 220));
        panel_2.setBounds(10, 11, 115, 46);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(200, 179, 17));
        panel_4.setBounds(10, 11, 115, 46);
        panel_4.setLayout(null);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(200, 129, 17));
        panel_5.setBounds(10, 11, 115, 46);
        panel_5.setLayout(null);

        JLabel lblNewLabel = new JLabel("RSJ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel.setBounds(35, 11, 95, 24);
        panel_2.add(lblNewLabel);

        //scrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 85, 1039, 515);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(128, 128, 255));
        scrollPane.setViewportView(panel_3);
        panel_3.setLayout(new GridLayout(0, 1));

        // Obtener el modelo de desplazamiento vertical del JScrollPane
        BoundedRangeModel verticalModel = scrollPane.getVerticalScrollBar().getModel();

        // Cambiar la velocidad de desplazamiento vertical
        verticalModel.setExtent(10); // Cambia el tamaño de la ventana visible (scroll unit increment)

        
        //------------- BOTONES JUEGOS ------------------
        //JUEGO 1 snake
        JPanel panel_J1 = new JPanel();
        panel_J1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel_J1.setPreferredSize(new Dimension(50, 200));
        panel_J1.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_J1);
        panel_J1.setLayout(null);
        
        btnJuego = new JButton();
        btnJuego.setBounds(3, 3, 1013, 194);
        btnJuego.setBackground(Color.WHITE);
        btnJuego.setPreferredSize(new Dimension(1000, 210));
        panel_J1.add(btnJuego);
        btnJuego.setContentAreaFilled(false);
        btnJuego.setBorderPainted(false);
        btnJuego.setOpaque(false);
        
        JLabel nomJ1 = new JLabel("SNAKE");
        nomJ1.setFont(new Font("Tahoma", Font.BOLD, 55));
        nomJ1.setBounds(525, 60, 405, 95);
        panel_J1.add(nomJ1);
        
        JPanel img1 = new JPanel();
        img1.setBackground(new Color(255, 255, 255));
        img1.setBounds(170, 27, 230, 150);

     // Carga la imagen desde un archivo
        try {
            // Carga la imagen utilizando la ruta relativa al proyecto (puede variar según cómo esté organizado tu proyecto)
            ImageIcon icon = new ImageIcon(getClass().getResource("/portalCalculadora/snakePortada.png"));
            
            // Escala la imagen para que se ajuste al tamaño del JPanel
            Image scaledImage = icon.getImage().getScaledInstance(img1.getWidth(), img1.getHeight(), Image.SCALE_SMOOTH);
            
            // Crea un JLabel para mostrar la imagen escalada
            JLabel imgLabel = new JLabel(new ImageIcon(scaledImage));
            
            // Agrega el JLabel al JPanel
            img1.add(imgLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        panel_J1.add(img1);
       
        btnJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("HAS SELECCIONADO JUEGO UNO");
                snake snake = new snake();//abre snake
	            snake.setVisible(true);
                dispose(); //cierra portal
            }
        });

        
        //JUEGO 2 tres en raya
        JPanel panel_J2 = new JPanel();
        panel_J2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel_J2.setPreferredSize(new Dimension(50, 200));
        panel_J2.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_J2);
        panel_J2.setLayout(null);

        btnJuego2 = new JButton();
        btnJuego2.setBounds(3, 3, 1013, 194);
        btnJuego2.setBackground(Color.WHITE);
        btnJuego2.setPreferredSize(new Dimension(1000, 210));
        panel_J2.add(btnJuego2);
        btnJuego2.setContentAreaFilled(false);
        btnJuego2.setBorderPainted(false);
        btnJuego2.setOpaque(false);
        
        JLabel nomJ2 = new JLabel("3 EN RAYA");
        nomJ2.setFont(new Font("Tahoma", Font.BOLD, 55));
        nomJ2.setBounds(525, 60, 405, 95);
        panel_J2.add(nomJ2);
        JPanel img2 = new JPanel();;
        img2.setBackground(new Color(255, 255, 255));
        img2.setBounds(170, 27, 230, 150);
        
        try {
            // Carga la imagen utilizando la ruta relativa al proyecto (puede variar según cómo esté organizado tu proyecto)
            ImageIcon icon = new ImageIcon(getClass().getResource("/portalCalculadora/TicTacToe.png"));
            
            // Escala la imagen para que se ajuste al tamaño del JPanel
            Image scaledImage = icon.getImage().getScaledInstance(img2.getWidth(), img2.getHeight(), Image.SCALE_SMOOTH);
            
            // Crea un JLabel para mostrar la imagen escalada
            JLabel imgLabel = new JLabel(new ImageIcon(scaledImage));
            
            // Agrega el JLabel al JPanel
            img2.add(imgLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        panel_J2.add(img2);
        btnJuego2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("HAS SELECCIONADO JUEGO DOS");
                ticTacToe game = new ticTacToe();
                game.frame.setVisible(true);
                dispose();
            }
        });
        
        //JUEGO 3 buscaminas
        JLabel nomJ3 = new JLabel("BUSCAMINAS");
        nomJ3.setFont(new Font("Tahoma", Font.BOLD, 55));
        nomJ3.setBounds(525, 60, 405, 95);
        JPanel panel_J3 = new JPanel();
        panel_J3.add(nomJ3);
        panel_J3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel_J3.setPreferredSize(new Dimension(50, 200));
        panel_J3.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_J3);
        panel_J3.setLayout(null);
        

        btnJuego3 = new JButton();
        btnJuego3.setBounds(3, 3, 1013, 194);
        btnJuego3.setBackground(Color.WHITE);
        btnJuego3.setPreferredSize(new Dimension(1000, 210));
        panel_J3.add(btnJuego3);
        btnJuego3.setContentAreaFilled(false);
        btnJuego3.setBorderPainted(false);
        btnJuego3.setOpaque(false);
        JPanel img3 = new JPanel();
        img3.setBackground(new Color(255, 255, 255));

        img3.setBounds(170, 27, 230, 150);
     // Carga la imagen desde un archivo
        try {
            // Carga la imagen utilizando la ruta relativa al proyecto (puede variar según cómo esté organizado tu proyecto)
            ImageIcon icon = new ImageIcon(getClass().getResource("/portalCalculadora/buscaminasLogo.png"));
            
            // Escala la imagen para que se ajuste al tamaño del JPanel
            Image scaledImage = icon.getImage().getScaledInstance(img3.getWidth(), img3.getHeight(), Image.SCALE_SMOOTH);
            
            // Crea un JLabel para mostrar la imagen escalada
            JLabel imgLabel = new JLabel(new ImageIcon(scaledImage));
            
            // Agrega el JLabel al JPanel
            img3.add(imgLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        panel_J3.add(img3);
        btnJuego3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("HAS SELECCIONADO JUEGO TRES");
                Minesweeper game = new Minesweeper();
                game.frame.setVisible(true);
                dispose();
            }
        });
        
        //JUEGO 4 pong
        JLabel nomJ4 = new JLabel("PONG");
        nomJ4.setFont(new Font("Tahoma", Font.BOLD, 55));
        nomJ4.setBounds(525, 60, 405, 95);
        JPanel panel_J4 = new JPanel();
        panel_J4.add(nomJ4);
        panel_J4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel_J4.setPreferredSize(new Dimension(50, 200));
        panel_J4.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_J4);
        panel_J4.setLayout(null);

        btnJuego4 = new JButton();
        btnJuego4.setBounds(3, 3, 1013, 194);
        btnJuego4.setBackground(Color.WHITE);
        btnJuego4.setPreferredSize(new Dimension(1000, 189));
        panel_J4.add(btnJuego4);
        btnJuego4.setContentAreaFilled(false);
        btnJuego4.setBorderPainted(false);
        btnJuego4.setOpaque(false);
        JPanel img4 = new JPanel();
        img4.setBackground(new Color(255, 255, 255));
        img4.setBounds(170, 27, 230, 150);
        
        // Carga la imagen desde un archivo
        try {
            // Carga la imagen utilizando la ruta relativa al proyecto (puede variar según cómo esté organizado tu proyecto)
            ImageIcon icon = new ImageIcon(getClass().getResource("/portalCalculadora/pongLogo.png"));
            
            // Escala la imagen para que se ajuste al tamaño del JPanel
            Image scaledImage = icon.getImage().getScaledInstance(img4.getWidth(), img4.getHeight(), Image.SCALE_SMOOTH);
            
            // Crea un JLabel para mostrar la imagen escalada
            JLabel imgLabel = new JLabel(new ImageIcon(scaledImage));
            
            // Agrega el JLabel al JPanel
            img4.add(imgLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Dentro del ActionListener del botón btnJuego4 en portal.java
        panel_J4.add(img4);
        btnJuego4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("HAS SELECCIONADO JUEGO CUATRO");
                Main game = new Main();
                game.setVisible(true); // Mostrar la ventana de Main
                dispose(); // Cerrar la ventana de portal
                
                // Iniciar el ciclo de juego de Main en un hilo separado
                Thread t = new Thread(game);
                t.start();
            }
        });

        // Botón para felicitaciones
        JButton btnFelicidades = new JButton("¡Felicidades!");
        btnFelicidades.setBounds(400, 250, 300, 100); // Ajusta la posición y tamaño del botón como desees
        btnFelicidades.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnFelicidades.setVisible(false); // Lo hacemos invisible inicialmente
        panel.add(btnFelicidades);
        btnFelicidades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar todas las ventanas
                for (Window window : Window.getWindows()) {
                    window.dispose();
                }
            }
        });
    }
}
