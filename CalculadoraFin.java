import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;


public class CalculadoraFin extends JFrame {
	
	/**
	 * @author Estefany Mamani Gutierrez
	 */
	private static final long serialVersionUID = -5908881500455864890L;
	public boolean igual,inicio=true,operacion1,operacion2, modoOscuro=false;
	public double resultado,valor1,valor2;
	public String funciones,tipoOperacion;
	public int xx,xy;
	


	private JPanel contentPane;

	/**
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraFin frame = new CalculadoraFin();
					frame.setLocationRelativeTo(null);
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
	public CalculadoraFin() {
		setResizable(false);
		setBackground(new Color(204, 204, 255));
		setUndecorated(true);
		setFocusTraversalKeysEnabled(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\IconoMax1.png"));
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 593);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setFont(new Font("Roboto", Font.PLAIN, 16));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-xx,y-xy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 352, 196);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JLabel txtOperacion = new JLabel("");
		txtOperacion.setBorder(null);
		txtOperacion.setBackground(UIManager.getColor("Button.disabledShadow"));
		txtOperacion.setFocusable(false);
		txtOperacion.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtOperacion.setForeground(new Color(0, 0, 51));
		txtOperacion.setHorizontalAlignment(SwingConstants.RIGHT);
		txtOperacion.setFont(new Font("Montserrat", Font.PLAIN, 18));
		txtOperacion.setBounds(30, 79, 306, 47);
		panel.add(txtOperacion);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(0, 195, 352, 398);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JLabel txtResultado = new JLabel("0");
		txtResultado.setPreferredSize(new Dimension(13, 30));
		txtResultado.setHorizontalAlignment(SwingConstants.TRAILING);
		txtResultado.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtResultado.setBorder(null);
		txtResultado.setFocusable(false);
		txtResultado.setBackground(new Color(230, 230, 250));
		txtResultado.setForeground(new Color(0, 0, 51));
		txtResultado.setFont(new Font("Montserrat", Font.BOLD, 36));
		txtResultado.setBounds(22, 126, 314, 59);
		panel.add(txtResultado);
		
		final JButton btnporc = new JButton("%");
		btnporc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor2=Double.parseDouble(txtResultado.getText());
				txtOperacion.setText(txtOperacion.getText()+txtResultado.getText());
				DecimalFormat format = new DecimalFormat("0.##########");
				txtResultado.setText(format.format((valor1*valor2)/100)+ " ");
				igual=true;
			}
		});
		btnporc.setContentAreaFilled(false);
		btnporc.setOpaque(false);
		btnporc.setBorderPainted(false);
		btnporc.setFocusPainted(false);
		btnporc.setPreferredSize(new Dimension(50, 50));
		btnporc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnporc.setFont(new Font("Montserrat", Font.PLAIN, 20));
		btnporc.setForeground(new Color(0, 0, 51));
		btnporc.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnporc.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnporc.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnporc.setBounds(31, 12, 50, 50);
		panel_1.add(btnporc);
		
		final JButton btnExp = new JButton("^");
		btnExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicio=true;
				valor1=Double.parseDouble(txtResultado.getText());
				DecimalFormat format = new DecimalFormat("0.##########");
				txtOperacion.setText(format.format(valor1) +"^");
				tipoOperacion="potencia";
				operacion1=false;
				igual=true;
			
				switch(tipoOperacion) {
				case"+":
					resultado=valor1+valor2;
					txtResultado.setText(resultado+" ");
					valor1=Double.parseDouble(txtResultado.getText());
					break;
				case"-":
					resultado=valor1-valor2;
					txtResultado.setText(resultado+" ");
					valor1=Double.parseDouble(txtResultado.getText());
					break;
				case"*":
					resultado=valor1*valor2;
					txtResultado.setText(resultado+" ");
					valor1=Double.parseDouble(txtResultado.getText());
					break;
				case "/":
					if(valor2==0) {
						txtResultado.setText("No se puede dividir entre cero");
						break;
					}
					else {
						resultado=valor1/valor2;
						txtResultado.setText(resultado+" ");
						valor1=Double.parseDouble(txtResultado.getText());
						break;
					}
				case"potencia":
					resultado=Math.pow(valor1, valor2);
					txtResultado.setText(resultado+" ");
					break;
					}
				}
		});
		btnExp.setContentAreaFilled(false);
		btnExp.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnExp.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnExp.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnExp.setPreferredSize(new Dimension(50, 50));
		btnExp.setOpaque(false);
		btnExp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExp.setForeground(new Color(0, 0, 51));
		btnExp.setFont(new Font("Roboto Bk", Font.PLAIN, 24));
		btnExp.setFocusPainted(false);
		btnExp.setBorderPainted(false);
		btnExp.setBounds(111, 12, 50, 50);
		panel_1.add(btnExp);
		
		final JButton btnDel = new JButton("DEL");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().length()>0) {
					txtResultado.setText(txtResultado.getText().substring(0,txtResultado.getText().length()-1));
					if(txtResultado.getText().length()==0) {
						txtResultado.setText("0");
						inicio=true;
					}
				}
			}
		});
		btnDel.setContentAreaFilled(false);
		btnDel.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnDel.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnDel.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnDel.setPreferredSize(new Dimension(50, 50));
		btnDel.setOpaque(false);
		btnDel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDel.setForeground(new Color(0, 0, 51));
		btnDel.setFont(new Font("Montserrat", Font.BOLD, 7));
		btnDel.setFocusPainted(false);
		btnDel.setBorderPainted(false);
		btnDel.setBounds(271, 12, 50, 50);
		panel_1.add(btnDel);
		
		final JButton btnBorrar = new JButton("C");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOperacion.setText("");
				txtResultado.setText("0");
				inicio=true;
				funciones="";
				operacion1=true;
				operacion2=true;
				igual=true;
				valor1=0;
				valor2=0;
				resultado=0;
			}
		});
		btnBorrar.setContentAreaFilled(false);
		btnBorrar.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnBorrar.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnBorrar.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnBorrar.setPreferredSize(new Dimension(50, 50));
		btnBorrar.setOpaque(false);
		btnBorrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBorrar.setForeground(new Color(0, 0, 51));
		btnBorrar.setFont(new Font("Montserrat", Font.PLAIN, 22));
		btnBorrar.setFocusPainted(false);
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBounds(191, 12, 50, 50);
		panel_1.add(btnBorrar);
		
		final JButton btnRaiz = new JButton("\u221Ax");
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1=Double.parseDouble(txtResultado.getText());
				if(valor1>=0) {
					DecimalFormat format = new DecimalFormat("0.##########");
					txtOperacion.setText("sqrt( "+format.format(valor1)+" )");
					txtResultado.setText(format.format(Math.sqrt(valor1))+"");
				}
				else {
					txtResultado.setText("No valido");
				}
			}
		});
		btnRaiz.setContentAreaFilled(false);
		btnRaiz.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnRaiz.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnRaiz.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnRaiz.setPreferredSize(new Dimension(50, 50));
		btnRaiz.setOpaque(false);
		btnRaiz.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRaiz.setForeground(new Color(0, 0, 51));
		btnRaiz.setFont(new Font("Montserrat", Font.BOLD, 12));
		btnRaiz.setFocusPainted(false);
		btnRaiz.setBorderPainted(false);
		btnRaiz.setBounds(191, 77, 50, 50);
		panel_1.add(btnRaiz);
		
		final JButton btnDivision = new JButton("\u00F7");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {igual=true;
			inicio=true;
			if(operacion1=true) {
				valor1=Double.parseDouble(txtResultado.getText());
				txtOperacion.setText("");
				txtOperacion.setText(txtResultado.getText() +"/");
				operacion1=false;
			}
			else {
				if(operacion2=true) {
					valor2=Double.parseDouble(txtResultado.getText());
					txtOperacion.setText(txtResultado.getText() +"/");
					operacion2=false;
				}
				else {
					txtOperacion.setText(txtResultado.getText() +"/");
					Operaciones(resultado,valor2);
				}
				
			}
			tipoOperacion = "/";
			}
			public void Operaciones(double valor1, double valor2) {
				if(valor2==0) {
					txtResultado.setText("No es posible");
				}
				else {
					resultado=valor1/valor2;
					txtResultado.setText(resultado+" ");
					valor1=Double.parseDouble(txtResultado.getText());
				}}
		});
		btnDivision.setContentAreaFilled(false);
		btnDivision.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnDivision.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnDivision.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnDivision.setPreferredSize(new Dimension(50, 50));
		btnDivision.setOpaque(false);
		btnDivision.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDivision.setForeground(new Color(0, 0, 51));
		btnDivision.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnDivision.setFocusPainted(false);
		btnDivision.setBorderPainted(false);
		btnDivision.setBounds(271, 77, 50, 50);
		panel_1.add(btnDivision);
		
		final JButton btnCuadrado = new JButton("x\u00B2");
		btnCuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1=Double.parseDouble(txtResultado.getText());
				DecimalFormat format = new DecimalFormat("0.##########");
				txtOperacion.setText(format.format(valor1)+"\u00B2");
				txtResultado.setText(format.format(Math.pow(valor1, 2))+" ");
			}
		});
		btnCuadrado.setContentAreaFilled(false);
		btnCuadrado.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnCuadrado.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnCuadrado.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnCuadrado.setPreferredSize(new Dimension(50, 50));
		btnCuadrado.setOpaque(false);
		btnCuadrado.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuadrado.setForeground(new Color(0, 0, 51));
		btnCuadrado.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnCuadrado.setFocusPainted(false);
		btnCuadrado.setBorderPainted(false);
		btnCuadrado.setBounds(111, 77, 50, 50);
		panel_1.add(btnCuadrado);
		
		final JButton btnUnosobre = new JButton("1/x");
		btnUnosobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1=Double.parseDouble(txtResultado.getText());
				DecimalFormat format = new DecimalFormat("0.##########");
				txtOperacion.setText("1/( "+format.format(valor1)+" )");
				txtResultado.setText(format.format(1/valor1)+"");
			}
		});
		btnUnosobre.setContentAreaFilled(false);
		btnUnosobre.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnUnosobre.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnUnosobre.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnUnosobre.setPreferredSize(new Dimension(50, 50));
		btnUnosobre.setOpaque(false);
		btnUnosobre.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUnosobre.setForeground(new Color(0, 0, 51));
		btnUnosobre.setFont(new Font("Montserrat", Font.BOLD, 9));
		btnUnosobre.setFocusPainted(false);
		btnUnosobre.setBorderPainted(false);
		btnUnosobre.setBounds(31, 77, 50, 50);
		panel_1.add(btnUnosobre);
		
		final JButton btnMultiplicar = new JButton("x");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {igual=true;
			inicio=true;
			if(operacion1=true) {
				valor1=Double.parseDouble(txtResultado.getText());
				txtOperacion.setText("");
				txtOperacion.setText(txtResultado.getText() +"x");
				operacion1=false;
			}
			else {
				if(operacion2=true) {
					valor2=Double.parseDouble(txtResultado.getText());
					txtOperacion.setText(txtResultado.getText() +"x");
					operacion2=false;
				}
				else {
					txtOperacion.setText(txtResultado.getText() +"x");
					Operaciones(resultado,valor2);
				}
				
			}
			tipoOperacion = "*";
			}
			public void Operaciones(double valor1, double valor2) {

				switch(tipoOperacion) {
				case"*":
					resultado=valor1*valor2;
					txtResultado.setText(resultado+"");
					valor1=Double.parseDouble(txtResultado.getText());
					break;
				}}
		});
		btnMultiplicar.setContentAreaFilled(false);
		btnMultiplicar.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnMultiplicar.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnMultiplicar.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnMultiplicar.setPreferredSize(new Dimension(50, 50));
		btnMultiplicar.setOpaque(false);
		btnMultiplicar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMultiplicar.setForeground(new Color(0, 0, 51));
		btnMultiplicar.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnMultiplicar.setFocusPainted(false);
		btnMultiplicar.setBorderPainted(false);
		btnMultiplicar.setBounds(271, 142, 50, 50);
		panel_1.add(btnMultiplicar);
		
		final JButton btnResta = new JButton("-");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {igual=true;
			inicio=true;
			if(operacion1=true) {
				valor1=Double.parseDouble(txtResultado.getText());
				txtOperacion.setText("");
				txtOperacion.setText(txtResultado.getText() +"-");
				operacion1=false;
			}
			else {
				if(operacion2=true) {
					valor2=Double.parseDouble(txtResultado.getText());
					txtOperacion.setText(txtResultado.getText() +"-");
					operacion2=false;
				}
				else {
					txtOperacion.setText(txtResultado.getText() +"-");
					Operaciones(resultado,valor2);
				}
				
			}
			tipoOperacion = "-";
			}
			public void Operaciones(double valor1, double valor2) {

				switch(tipoOperacion) {
				case"-":
					resultado=valor1-valor2;
					txtResultado.setText(resultado+"");
					valor1=Double.parseDouble(txtResultado.getText());
					break;
				}}
		});
		btnResta.setContentAreaFilled(false);
		btnResta.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnResta.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnResta.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnResta.setPreferredSize(new Dimension(50, 50));
		btnResta.setOpaque(false);
		btnResta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnResta.setForeground(new Color(0, 0, 51));
		btnResta.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnResta.setFocusPainted(false);
		btnResta.setBorderPainted(false);
		btnResta.setBounds(271, 207, 50, 50);
		panel_1.add(btnResta);
		
		final JButton btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				igual=true;
				inicio=true;
				if(operacion1=true) {
					valor1=Double.parseDouble(txtResultado.getText());
					txtOperacion.setText("");
					txtOperacion.setText(txtResultado.getText() +"+");
					operacion1=false;
				}
				else {
					if(operacion2=true) {
						valor2=Double.parseDouble(txtResultado.getText());
						txtOperacion.setText(txtResultado.getText() +"+");
						operacion2=false;
					}
					else {
						txtOperacion.setText(txtResultado.getText() +"+");
						Operaciones(resultado,valor2);
					}
					
				}
				tipoOperacion = "+";
				
				
			}

			public void Operaciones(double valor1, double valor2) {

		switch(tipoOperacion) {
		case"+":
			resultado=valor1+valor2;
			DecimalFormat format = new DecimalFormat("0.##########");
			txtResultado.setText(format.format(resultado)+"");
			valor1=Double.parseDouble(txtResultado.getText());
			break;
		}}
			
		});
		btnSuma.setContentAreaFilled(false);
		btnSuma.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnSuma.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnSuma.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
		btnSuma.setPreferredSize(new Dimension(50, 50));
		btnSuma.setOpaque(false);
		btnSuma.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSuma.setForeground(new Color(0, 0, 51));
		btnSuma.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnSuma.setFocusPainted(false);
		btnSuma.setBorderPainted(false);
		btnSuma.setBounds(271, 272, 50, 50);
		panel_1.add(btnSuma);
		
		final JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					inicio=true;
					operacion1=true;
					if(igual==true) {
						if(tipoOperacion== null) {
					}else {
						valor2=Double.parseDouble(txtResultado.getText());
						txtOperacion.setText(txtOperacion.getText()+txtResultado.getText());
						Operaciones(valor1,valor2);
						igual=false;
					}}else{
							txtOperacion.setText("");
							Operaciones(valor1,valor2);
							}}

			public void Operaciones(double valor1, double valor2) {

		switch(tipoOperacion) {
		case"+":
			resultado=valor1+valor2;
			DecimalFormat format = new DecimalFormat("0.##########");
			txtResultado.setText(format.format(resultado)+"");
			valor1=Double.parseDouble(txtResultado.getText());
			break;
		case"-":
			resultado=valor1-valor2;
			DecimalFormat format1 = new DecimalFormat("0.##########");
			txtResultado.setText(format1.format(resultado)+"");
			valor1=Double.parseDouble(txtResultado.getText());
			break;
		case"*":
			resultado=valor1*valor2;
			DecimalFormat format11 = new DecimalFormat("0.##########");
			txtResultado.setText(format11.format(resultado)+"");
			valor1=Double.parseDouble(txtResultado.getText());
			break;
		case "/":
			if(valor2==0) {
				txtResultado.setText("Indeterminado");
				break;
			}
			else {
				resultado=valor1/valor2;
				DecimalFormat format12 = new DecimalFormat("0.##########");
				txtResultado.setText(format12.format(resultado)+"");
				valor1=Double.parseDouble(txtResultado.getText());
				break;
			}
		case"potencia":
			resultado=Math.pow(valor1, valor2);
			DecimalFormat format2 = new DecimalFormat("0.##########");
			txtResultado.setText(format2.format(resultado)+"");
			break;
			}
		}	
		});
		btnIgual.setContentAreaFilled(false);
		btnIgual.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnIgual.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton3.png"));
		btnIgual.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnIgual.setPreferredSize(new Dimension(50, 50));
		btnIgual.setOpaque(false);
		btnIgual.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIgual.setForeground(new Color(0, 0, 51));
		btnIgual.setFont(new Font("Montserrat", Font.PLAIN, 26));
		btnIgual.setFocusPainted(false);
		btnIgual.setBorderPainted(false);
		btnIgual.setBounds(271, 337, 50, 50);
		panel_1.add(btnIgual);
		
		final JButton btnSiete = new JButton("7");
		btnSiete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio==true) {
					txtResultado.setText(" ");
					txtResultado.setText("7");
					inicio=false;
				}else {
				txtResultado.setText(txtResultado.getText() +"7");}
			}
		});
		btnSiete.setContentAreaFilled(false);
		btnSiete.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnSiete.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnSiete.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnSiete.setPreferredSize(new Dimension(50, 50));
		btnSiete.setOpaque(false);
		btnSiete.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSiete.setForeground(new Color(0, 0, 51));
		btnSiete.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnSiete.setFocusPainted(false);
		btnSiete.setBorderPainted(false);
		btnSiete.setBounds(31, 142, 50, 50);
		panel_1.add(btnSiete);
		
		final JButton btnOcho = new JButton("8");
		btnOcho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {if(inicio==true) {
				txtResultado.setText(" ");
				txtResultado.setText("8");
				inicio=false;
			}else {
				txtResultado.setText(txtResultado.getText() +"8");}
		}
		});
		btnOcho.setContentAreaFilled(false);
		btnOcho.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnOcho.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnOcho.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnOcho.setPreferredSize(new Dimension(50, 50));
		btnOcho.setOpaque(false);
		btnOcho.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOcho.setForeground(new Color(0, 0, 51));
		btnOcho.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnOcho.setFocusPainted(false);
		btnOcho.setBorderPainted(false);
		btnOcho.setBounds(111, 142, 50, 50);
		panel_1.add(btnOcho);
		
		final JButton btnNueve = new JButton("9");
		btnNueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio==true) {
					txtResultado.setText(" ");
					txtResultado.setText("9");
					inicio=false;
				}else {
					txtResultado.setText(txtResultado.getText() +"9");}
			}
		});
		btnNueve.setContentAreaFilled(false);
		btnNueve.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnNueve.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnNueve.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnNueve.setPreferredSize(new Dimension(50, 50));
		btnNueve.setOpaque(false);
		btnNueve.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNueve.setForeground(new Color(0, 0, 51));
		btnNueve.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnNueve.setFocusPainted(false);
		btnNueve.setBorderPainted(false);
		btnNueve.setBounds(191, 142, 50, 50);
		panel_1.add(btnNueve);
		
		final JButton btnCuatro = new JButton("4");
		btnCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio==true) {
					txtResultado.setText(" ");
					txtResultado.setText("4");
					inicio=false;
				}else {
					txtResultado.setText(txtResultado.getText() +"4");}
			}
		});
		btnCuatro.setContentAreaFilled(false);
		btnCuatro.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnCuatro.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnCuatro.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnCuatro.setPreferredSize(new Dimension(50, 50));
		btnCuatro.setOpaque(false);
		btnCuatro.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuatro.setForeground(new Color(0, 0, 51));
		btnCuatro.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnCuatro.setFocusPainted(false);
		btnCuatro.setBorderPainted(false);
		btnCuatro.setBounds(31, 207, 50, 50);
		panel_1.add(btnCuatro);
		
		final JButton btnCinco = new JButton("5");
		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio==true) {
					txtResultado.setText(" ");
					txtResultado.setText("5");
					inicio=false;
				}else {
					txtResultado.setText(txtResultado.getText() +"5");}
			}
		});
		btnCinco.setContentAreaFilled(false);
		btnCinco.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnCinco.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnCinco.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnCinco.setPreferredSize(new Dimension(50, 50));
		btnCinco.setOpaque(false);
		btnCinco.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCinco.setForeground(new Color(0, 0, 51));
		btnCinco.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnCinco.setFocusPainted(false);
		btnCinco.setBorderPainted(false);
		btnCinco.setBounds(111, 207, 50, 50);
		panel_1.add(btnCinco);
		
		final JButton btnSeis = new JButton("6");
		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio==true) {
					txtResultado.setText(" ");
					txtResultado.setText("6");
					inicio=false;
				}else {
					txtResultado.setText(txtResultado.getText() +"6");}
			}
		});
		btnSeis.setContentAreaFilled(false);
		btnSeis.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnSeis.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnSeis.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnSeis.setPreferredSize(new Dimension(50, 50));
		btnSeis.setOpaque(false);
		btnSeis.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSeis.setForeground(new Color(0, 0, 51));
		btnSeis.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnSeis.setFocusPainted(false);
		btnSeis.setBorderPainted(false);
		btnSeis.setBounds(191, 207, 50, 50);
		panel_1.add(btnSeis);
		
		final JButton btnUno = new JButton("1");
		btnUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio==true) {
					txtResultado.setText(" ");
					txtResultado.setText("1");
					inicio=false;
				}else {
					txtResultado.setText(txtResultado.getText() +"1");}
			}
		});
		btnUno.setContentAreaFilled(false);
		btnUno.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnUno.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnUno.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnUno.setPreferredSize(new Dimension(50, 50));
		btnUno.setOpaque(false);
		btnUno.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUno.setForeground(new Color(0, 0, 51));
		btnUno.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnUno.setFocusPainted(false);
		btnUno.setBorderPainted(false);
		btnUno.setBounds(31, 272, 50, 50);
		panel_1.add(btnUno);
		
		final JButton btnDos = new JButton("2");
		btnDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio==true) {
					txtResultado.setText(" ");
					txtResultado.setText("2");
					inicio=false;
				}else {
					txtResultado.setText(txtResultado.getText() +"2");}
			}
		});
		btnDos.setContentAreaFilled(false);
		btnDos.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnDos.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnDos.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnDos.setPreferredSize(new Dimension(50, 50));
		btnDos.setOpaque(false);
		btnDos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDos.setForeground(new Color(0, 0, 51));
		btnDos.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnDos.setFocusPainted(false);
		btnDos.setBorderPainted(false);
		btnDos.setBounds(111, 272, 50, 50);
		panel_1.add(btnDos);
		
		final JButton btnTres = new JButton("3");
		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio==true) {
					txtResultado.setText(" ");
					txtResultado.setText("3");
					inicio=false;
				}else {
					txtResultado.setText(txtResultado.getText() +"3");}
			}
		});
		btnTres.setContentAreaFilled(false);
		btnTres.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnTres.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnTres.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnTres.setPreferredSize(new Dimension(50, 50));
		btnTres.setOpaque(false);
		btnTres.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTres.setForeground(new Color(0, 0, 51));
		btnTres.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnTres.setFocusPainted(false);
		btnTres.setBorderPainted(false);
		btnTres.setBounds(191, 272, 50, 50);
		panel_1.add(btnTres);
		
		final JButton btnMasMenos = new JButton("+/-");
		btnMasMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double nu1=0,nu2,nu3;
				DecimalFormat format2 = new DecimalFormat("0.##########");
				nu2=Double.parseDouble(txtResultado.getText());
				nu3=nu1-nu2;
				txtResultado.setText(format2.format(nu3)+" ");
			}
		});
		btnMasMenos.setContentAreaFilled(false);
		btnMasMenos.setToolTipText("");
		btnMasMenos.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnMasMenos.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnMasMenos.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnMasMenos.setPreferredSize(new Dimension(50, 50));
		btnMasMenos.setOpaque(false);
		btnMasMenos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMasMenos.setForeground(new Color(0, 0, 51));
		btnMasMenos.setFont(new Font("Montserrat", Font.PLAIN, 9));
		btnMasMenos.setFocusPainted(false);
		btnMasMenos.setBorderPainted(false);
		btnMasMenos.setBounds(31, 337, 50, 50);
		panel_1.add(btnMasMenos);
		
		final JButton btnCero = new JButton("0");
		btnCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio==true) {
					txtResultado.setText(" ");
					txtResultado.setText("0");
					inicio=false;
				}else {
				txtResultado.setText(txtResultado.getText() +"0");}
			}
		});
		btnCero.setContentAreaFilled(false);
		btnCero.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnCero.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnCero.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnCero.setPreferredSize(new Dimension(50, 50));
		btnCero.setOpaque(false);
		btnCero.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCero.setForeground(new Color(0, 0, 51));
		btnCero.setFont(new Font("Montserrat", Font.PLAIN, 22));
		btnCero.setFocusPainted(false);
		btnCero.setBorderPainted(false);
		btnCero.setBounds(111, 337, 50, 50);
		panel_1.add(btnCero);
		
		final JButton btnPunto = new JButton(".");
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().contains(".")) {}
				else {
				txtResultado.setText(txtResultado.getText() +".");
				inicio=false;}
			}
		});
		btnPunto.setContentAreaFilled(false);
		btnPunto.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
		btnPunto.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnPunto.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
		btnPunto.setPreferredSize(new Dimension(50, 50));
		btnPunto.setOpaque(false);
		btnPunto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPunto.setForeground(new Color(0, 0, 51));
		btnPunto.setFont(new Font("Montserrat", Font.PLAIN, 24));
		btnPunto.setFocusPainted(false);
		btnPunto.setBorderPainted(false);
		btnPunto.setBounds(191, 337, 50, 50);
		panel_1.add(btnPunto);
		
		final JLabel lblNewLabel_2 = new JLabel("Calculadora Basica");
		lblNewLabel_2.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(15, 10, 159, 20);
		panel.add(lblNewLabel_2);
		
		final JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Modo");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnOff.png"));
		btnNewButton.addActionListener(new ActionListener() {  //modo oscuro boton
			public void actionPerformed(ActionEvent e) {
				if(!modoOscuro) {
					panel.setBackground(Color.decode("#212b41"));
					panel_1.setBackground(Color.decode("#2e3951"));
					txtOperacion.setForeground(Color.decode("#cbb9dc"));
					txtResultado.setForeground(Color.decode("#cbb9dc"));
					lblNewLabel_2.setForeground(Color.decode("#cbb9dc"));
					btnUno.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnUno.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnUno.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnUno.setForeground(Color.decode("#ffffff"));
					
					btnNewButton.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnOn.png"));
					btnDos.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnDos.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnDos.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnDos.setForeground(Color.decode("#ffffff"));
					
					btnTres.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnTres.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnTres.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnTres.setForeground(Color.decode("#ffffff"));
					
					btnCuatro.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnCuatro.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnCuatro.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnCuatro.setForeground(Color.decode("#ffffff"));
					
					btnCinco.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnCinco.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnCinco.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnCinco.setForeground(Color.decode("#ffffff"));
					
					btnSeis.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnSeis.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnSeis.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnSeis.setForeground(Color.decode("#ffffff"));
					
					btnSiete.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnSiete.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnSiete.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnSiete.setForeground(Color.decode("#ffffff"));
					
					btnOcho.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnOcho.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnOcho.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnOcho.setForeground(Color.decode("#ffffff"));
					
					btnNueve.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnNueve.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnNueve.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnNueve.setForeground(Color.decode("#ffffff"));
					
					btnCero.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnCero.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnCero.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnCero.setForeground(Color.decode("#ffffff"));
					
					btnPunto.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnPunto.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnPunto.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnPunto.setForeground(Color.decode("#ffffff"));
					
					btnMasMenos.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnMasMenos.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn1_Dark.png"));
					btnMasMenos.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnMasMenos.setForeground(Color.decode("#ffffff"));
					
					btnporc.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnporc.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnporc.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnporc.setForeground(Color.decode("#cbb9dc"));
					
					btnExp.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnExp.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnExp.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnExp.setForeground(Color.decode("#cbb9dc"));
					
					btnBorrar.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnBorrar.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnBorrar.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnBorrar.setForeground(Color.decode("#cbb9dc"));
					
					btnDel.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnDel.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnDel.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnDel.setForeground(Color.decode("#cbb9dc"));
					
					btnRaiz.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnRaiz.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnRaiz.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnRaiz.setForeground(Color.decode("#cbb9dc"));
					
					btnDivision.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnDivision.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnDivision.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnDivision.setForeground(Color.decode("#cbb9dc"));
					
					btnCuadrado.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnCuadrado.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnCuadrado.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnCuadrado.setForeground(Color.decode("#cbb9dc"));
					
					btnUnosobre.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnUnosobre.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnUnosobre.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnUnosobre.setForeground(Color.decode("#cbb9dc"));
					
					btnSuma.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnSuma.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnSuma.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnSuma.setForeground(Color.decode("#cbb9dc"));
					
					btnResta.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnResta.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnResta.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnResta.setForeground(Color.decode("#cbb9dc"));
					
					btnMultiplicar.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnMultiplicar.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btn2_Dark.png"));
					btnMultiplicar.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnMultiplicar.setForeground(Color.decode("#cbb9dc"));
					
					btnIgual.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnIgual.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnPressDark.png"));
					btnIgual.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnIgual.png"));
					btnIgual.setForeground(Color.decode("#ffffff"));
					modoOscuro=true;}
				else {
					panel.setBackground(new Color(230, 230, 250));
					panel_1.setBackground(new Color(245, 245, 245));
					txtOperacion.setForeground(new Color(0, 0, 51));
					txtResultado.setForeground(new Color(0, 0, 51));
					lblNewLabel_2.setForeground(new Color(0, 0, 0));
					btnNewButton.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\btnOff.png"));
					btnUno.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnUno.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.pngg"));
					btnUno.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnUno.setForeground(new Color(0, 0, 51));
					
					btnDos.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnDos.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnDos.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnDos.setForeground(new Color(0, 0, 51));
					
					btnTres.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnTres.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnTres.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnTres.setForeground(new Color(0, 0, 51));
					
					btnCuatro.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnCuatro.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnCuatro.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnCuatro.setForeground(new Color(0, 0, 51));
					
					btnCinco.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnCinco.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnCinco.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnCinco.setForeground(new Color(0, 0, 51));
					
					btnSeis.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnSeis.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnSeis.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnSeis.setForeground(new Color(0, 0, 51));
					
					btnSiete.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnSiete.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnSiete.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnSiete.setForeground(new Color(0, 0, 51));
					
					btnOcho.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnOcho.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnOcho.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnOcho.setForeground(new Color(0, 0, 51));
					
					btnNueve.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnNueve.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnNueve.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnNueve.setForeground(new Color(0, 0, 51));
					
					btnCero.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnCero.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton2.png"));
					btnCero.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnCero.setForeground(new Color(0, 0, 51));
					
					btnPunto.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnPunto.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnPunto.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnPunto.setForeground(new Color(0, 0, 51));
					
					btnMasMenos.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnMasMenos.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnMasMenos.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnMasMenos.setForeground(new Color(0, 0, 51));
					
					btnporc.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnporc.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnporc.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnporc.setForeground(new Color(0, 0, 51));
					
					btnExp.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnExp.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnExp.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnExp.setForeground(new Color(0, 0, 51));
					
					btnBorrar.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnBorrar.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnBorrar.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnBorrar.setForeground(new Color(0, 0, 51));
					
					btnDel.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnDel.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnDel.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnDel.setForeground(new Color(0, 0, 51));
					
					btnRaiz.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnRaiz.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnRaiz.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnRaiz.setForeground(new Color(0, 0, 51));
					
					btnDivision.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnDivision.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnDivision.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnDivision.setForeground(new Color(0, 0, 51));
					
					btnCuadrado.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnCuadrado.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnCuadrado.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnCuadrado.setForeground(new Color(0, 0, 51));
					
					btnUnosobre.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnUnosobre.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnUnosobre.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnUnosobre.setForeground(new Color(0, 0, 51));
					
					btnSuma.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnSuma.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnSuma.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnSuma.setForeground(new Color(0, 0, 51));
					
					btnResta.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnResta.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnResta.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnResta.setForeground(new Color(0, 0, 51));
					
					btnMultiplicar.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnMultiplicar.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1.png"));
					btnMultiplicar.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnMultiplicar.setForeground(new Color(0, 0, 51));
					
					btnIgual.setIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnIgual.setPressedIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton1_pres.png"));
					btnIgual.setRolloverIcon(new ImageIcon("E:\\DATOS\\ING. SISTEMAS E INFORMATICA\\III CICLO\\PROGRAMACION ORIENTADA A OBJETOS II\\CALCULADORA\\CalculadoraFin\\src\\images\\boton3.png"));
					btnIgual.setForeground(new Color(0, 0, 51));
					modoOscuro=false;}
				}

		});
		
		btnNewButton.setBounds(15, 48, 40, 20);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u2022");
		lblNewLabel.setToolTipText("Cerrar");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(WIDTH);
				}

		});
		lblNewLabel.setForeground(new Color(153, 51, 51));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 34));
		lblNewLabel.setBounds(313, 0, 29, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u2022");
		lblNewLabel_1.setToolTipText("Minimizar");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.CROSSHAIR_CURSOR);
			}
		});
		lblNewLabel_1.setForeground(new Color(153, 102, 153));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(284, 0, 29, 33);
		panel.add(lblNewLabel_1);
		

	}
		}


		
	


