package portalCalculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.net.http.WebSocket.Listener;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Random;

public class snake extends JFrame {
    
	
    Imagensnake imagensnake;
    Point snake;
    //Point lastsnake;
    Point comida;
    ArrayList<Point> listaPosiciones = new ArrayList<Point>();

    int longitud = 2;

    int width = 550;
    int height = 550;

    int widthPoint = 10;
    int heightPoint = 10;

	String direccion = "RIGHT";
	long frequency = 50;

    boolean gameOver = false;

    public snake() {
        setTitle("snake");

        startGame();
        imagensnake = new Imagensnake();
        setResizable(false);
        // Establecer el tamaño del panel imagensnake
        imagensnake.setPreferredSize(new Dimension(width, height));
        this.getContentPane().setLayout(new BorderLayout()); // Establecer el layout del JFrame
        this.getContentPane().add(imagensnake, BorderLayout.CENTER); // Agregar el panel al centro

        // Establecer el tamaño del JFrame
        setSize(width, height);

        this.addKeyListener(new Teclas());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        setVisible(true);

        Momento momento = new Momento();
        Thread trid = new Thread(momento);
        trid.start();

        //cuando se cierra la ventana vuelves al PORTAL
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cerrando...");
                dispose(); // Cerrar la ventana de snake
                
                // Crear e inicializar la ventana del portal
                portal portal = new portal();
                portal.setVisible(true); // Mostrar la ventana del portal
            }
        });
    }



    public void startGame() {
		comida = new Point(200,100);	
        snake = new Point(320,240);
		listaPosiciones = new ArrayList<Point>();
        listaPosiciones.add(snake);

		longitud = listaPosiciones.size();        
    }

    public void generarComida() {
        Random rnd = new Random();
        
        // Generar coordenadas dentro de los límites de la pantalla
        comida.x = rnd.nextInt(width - 30) + 15; // Asegura que la comida esté dentro de 15 píxeles del borde
        comida.y = rnd.nextInt(height - 30) + 15; // Asegura que la comida esté dentro de 15 píxeles del borde

        // Ajustar las coordenadas para que estén en múltiplos de 10
        comida.x = comida.x - (comida.x % 10);
        comida.y = comida.y - (comida.y % 10);
    }



	public void actualizar() {

        listaPosiciones.add(0,new Point(snake.x,snake.y));
		listaPosiciones.remove(listaPosiciones.size()-1);

        for (int i=1;i<listaPosiciones.size();i++) {
            Point point = listaPosiciones.get(i);
            if(snake.x == point.x && snake.y  == point.y) {
                gameOver = true;
            }
        }

		if((snake.x > (comida.x-10) && snake.x < (comida.x+10)) && (snake.y > (comida.y-10) && snake.y < (comida.y+10))) {
            listaPosiciones.add(0,new Point(snake.x,snake.y));
			//System.out.println(listaPosiciones.size());
			generarComida();
		}
        imagensnake.repaint();

	}

	public static void main(String[] args) {
		snake snake1 = new snake();
	}

    public class Imagensnake extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            if(gameOver) {
                g.setColor(new Color(0,0,0));
            } else {
                g.setColor(new Color(203, 255, 225));
            }
            g.fillRect(0,0, width, height);
            g.setColor(new Color(0,0,255));
    
            if(listaPosiciones.size() > 0) {
                for(int i=0;i<listaPosiciones.size();i++) {
                    Point p = (Point)listaPosiciones.get(i);
                    g.fillRect(p.x,p.y,widthPoint,heightPoint);
                }
            }
    
            g.setColor(new Color(255,0,0));
            g.fillRect(comida.x,comida.y,widthPoint,heightPoint);    
            
            if(gameOver) {
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString("GAME OVER", 300, 200);
                g.drawString("PUNTUACIÓN: "+(listaPosiciones.size()-1), 300, 240);

                g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                g.drawString("N para empezar", 100, 320);
                g.drawString("ESC to Exit", 100, 340);
            }

        }
    }

	public class Teclas extends java.awt.event.KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {

			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				portal port = new portal();
				port.setVisible(true);
				dispose();
			} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {

				if(direccion != "LEFT") {
                    direccion = "RIGHT";

				}
			} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(direccion != "RIGHT") {
                    direccion = "LEFT";
				}
			} else if(e.getKeyCode() == KeyEvent.VK_UP) {
				if(direccion != "DOWN") {
                    direccion = "UP";
				}
			} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				if(direccion != "UP") {
                    direccion = "DOWN";
				}				
			
			} else if(e.getKeyCode() == KeyEvent.VK_N) {
                gameOver = false;
                startGame();				
			}
		}

	}

	public class Momento extends Thread {
		
		private long last = 0;
		
		public Momento() {
			
		}

		public void run() {
			while(true) {
				if((java.lang.System.currentTimeMillis() - last) > frequency) {
					if(!gameOver) {

                        if(direccion == "RIGHT") {
                            snake.x = snake.x + widthPoint;
                            if(snake.x > width) {
                                snake.x = 0;
                            }
                        } else if(direccion == "LEFT") {
                            snake.x = snake.x - widthPoint;
                            if(snake.x < 0) {
                                snake.x = width - widthPoint;
                            }                        
                        } else if(direccion == "UP") {
                            snake.y = snake.y - heightPoint;
                            if(snake.y < 0) {
                                snake.y = height;
                            }                        
                        } else if(direccion == "DOWN") {
                            snake.y = snake.y + heightPoint;
                            if(snake.y > height) {
                                snake.y = 0;
                            }                        
                        }
                    }
                    actualizar();
					
					last = java.lang.System.currentTimeMillis();
				}

			}
		}
	}
}
