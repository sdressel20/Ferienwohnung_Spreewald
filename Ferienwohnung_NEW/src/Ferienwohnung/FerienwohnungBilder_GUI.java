package Ferienwohnung;

	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JButton;
	import java.awt.BorderLayout;
	import java.awt.Button;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JLabel;
	import javax.swing.JTextArea;
	import javax.swing.JPanel;
	import javax.swing.ImageIcon;
	import javax.swing.SwingConstants;
	import java.awt.Color;
	import java.awt.Font;
	import javax.swing.JTextPane;
	import java.awt.Component;
	import javax.swing.Box;
import javax.swing.Icon;

import java.awt.Dimension;
	import javax.swing.JMenuBar;
	import javax.swing.JTable;
	import javax.swing.JDesktopPane;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
import java.net.URL;

	public class FerienwohnungBilder_GUI {

		private JFrame class1;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FerienwohnungBilder_GUI window = new FerienwohnungBilder_GUI();
						window.class1.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public FerienwohnungBilder_GUI() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			class1 = new JFrame("Ferienwohnung Spreewald zur grünen Gurke"); 
			class1.setBounds(40, 40, 1600, 1000);
			class1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			class1.getContentPane().setLayout(null);

			JTextArea txtrFerienwohnung = new JTextArea(); //Textfeld Überschrit
			txtrFerienwohnung.setEditable(false);
			txtrFerienwohnung.setBounds(0, 0, 1584, 51);
			txtrFerienwohnung.setFont(new Font("Microsoft YaHei", Font.BOLD, 39)); //Schriftgröße und Dicke Schrift
			txtrFerienwohnung.setForeground(Color.BLACK); //Schriftfarbe
			txtrFerienwohnung.setTabSize(30);
			txtrFerienwohnung.setText("Ferienwohnung zur grünen Gurke");
			class1.getContentPane().add(txtrFerienwohnung);

			JLabel jl1 = new JLabel("");
			URL url1 = FerienwohnungBilder_GUI.class.getResource("Fewo11.jpg"); //Bild Haus
			Icon icon1 = new ImageIcon(url1);
			jl1.setIcon(icon1);
			jl1.setBounds(10, 62, 640, 419);
			class1.getContentPane().add(jl1);

			JLabel jl2 = new JLabel("");
			URL url2 = FerienwohnungBilder_GUI.class.getResource("Fewo12.jpg"); //Bild Haus
			Icon icon2 = new ImageIcon(url2);
			jl2.setIcon(icon2);
			jl2.setBounds(10, 62, 640, 419);
			class1.getContentPane().add(jl2);

			JLabel jl3 = new JLabel("");
			URL url3 = FerienwohnungBilder_GUI.class.getResource("Fewo13.jpg"); //Bild Haus
			Icon icon3 = new ImageIcon(url3);
			jl3.setIcon(icon3);
			jl3.setBounds(10, 62, 640, 419);
			class1.getContentPane().add(jl3);

			JTextPane txtpnAllgemeineInformationen = new JTextPane();
			txtpnAllgemeineInformationen.setEditable(false);
			txtpnAllgemeineInformationen.setFont(new Font("Tahoma", Font.PLAIN, 26));
			txtpnAllgemeineInformationen
					.setText("Allgemeine Informationen:\r\n\r\nZimmer: 3\r\nK\u00FCche: ja\r\nBadewanne: nein\r\n"); //Allgemeine Informationen
			txtpnAllgemeineInformationen.setBounds(696, 62, 620, 183);
			class1.getContentPane().add(txtpnAllgemeineInformationen);

			JDesktopPane desktopPane = new JDesktopPane();
			desktopPane.setBounds(884, 314, 79, -42);
			class1.getContentPane().add(desktopPane);
		}
	}



