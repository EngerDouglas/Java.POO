package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	private  Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Queseria Pucmm");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/icon queso.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.ORANGE);
		menuBar.setForeground(Color.ORANGE);
		setJMenuBar(menuBar);
		
		JMenu mnQuesos = new JMenu("Quesos");
		menuBar.add(mnQuesos);
		
		JMenuItem mntmFabricarQueso = new JMenuItem("Fabricar Queso");
		mntmFabricarQueso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regQueso regQ = new regQueso();
				regQ.setModal(true);
				regQ.setVisible(true);
			}
		});
		mnQuesos.add(mntmFabricarQueso);
		
		JMenuItem mntmListadoDeQuesos = new JMenuItem("Listado de Quesos");
		mntmListadoDeQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoQueso list = new ListadoQueso();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnQuesos.add(mntmListadoDeQuesos);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mntmListadoDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoCliente lc = new ListadoCliente();
				lc.setModal(true);
				lc.setVisible(true);
			}
		});
		mnClientes.add(mntmListadoDeClientes);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar fact = new Facturar();
				fact.setModal(true);
				fact.setVisible(true);
			}
		});
		mnVentas.add(mntmFacturar);
		
		JMenuItem mntmListaFactura = new JMenuItem("Lista de Facturas\r\n");
		mntmListaFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoFactura lf = new ListadoFactura();
				lf.setModal(true);
				lf.setVisible(true);
			}
		});
		mnVentas.add(mntmListaFactura);
		
		JMenu mnNewMenu = new JMenu("Administracion\r\n");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Dinero Generado\r\n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DineroGenerado dineG = new DineroGenerado();
				dineG.setModal(true);
				dineG.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmReporteQuesos = new JMenuItem("Reporte de Quesos\r\n");
		mntmReporteQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporteQueso rq = new reporteQueso();
				rq.setModal(true);
				rq.setVisible(true);
			}
		});
		mnNewMenu.add(mntmReporteQuesos);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/logo queseria.png")));
		lblNewLabel.setBounds(0, 0, 1894, 960);
		panel.add(lblNewLabel);
	}
}
