package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import logical.Cliente;
import logical.TiendaQueso;
import logical.Factura;
import logical.Queso;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sun.glass.events.MouseEvent;import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.Toolkit;

public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcedula;
	private JButton btnBuscar;
	private JTextField txtnombreC;
	private JTextField txttelefC;
	private JTextField txtdirC;
	private JScrollPane scrDisp;
	private JList listquesolDispo;
	private JList listcarritoCompra;
	private JScrollPane scrOrd;
	private JTextField txttotal;
	private ArrayList<String> orden;
	private ArrayList<String> disponibles;
	private DefaultListModel<String> modelDisp;
	private DefaultListModel<String> modelOrd;
	private float total = 0;
	private int indx = 0;
	private int selected = -1;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private JTextField txtcodigoFact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/img/icon queso.png")));
		orden = new ArrayList<>();
		disponibles = new ArrayList<>();
		setLocationRelativeTo(null);
		setTitle("Facturar\r\n");
		setBounds(100, 100, 522, 514);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 486, 146);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 44, 46, 14);
		panel.add(lblCdula);

		txtcedula = new JTextField();
		txtcedula.setBounds(70, 41, 216, 23);
		panel.add(txtcedula);
		txtcedula.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Cliente aux2 : TiendaQueso.getInstance().getMisCliente()) {
					if (aux2.getCedula().equalsIgnoreCase(txtcedula.getText())) {
						JOptionPane.showMessageDialog(null, "Este Usuario ya esta registrado", "Usuario no encontrado",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

				Cliente aux = TiendaQueso.getInstance().clienteEcontrado(txtcedula.getText());

				if (aux != null) {
					txtnombreC.setText(aux.getNombre());
					txtdirC.setText(aux.getDir());
					txttelefC.setText(aux.getTelefono());
				} else {
					JOptionPane.showMessageDialog(null, "Usuario no registrado, Registre este usuario",
							"Usuario no encontrado", JOptionPane.INFORMATION_MESSAGE);
					txtnombreC.setEditable(true);
					txtdirC.setEditable(true);
					txttelefC.setEditable(true);

				}
			}
		});
		btnBuscar.setBounds(298, 40, 81, 23);
		panel.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 78, 52, 14);
		panel.add(lblNombre);

		txtnombreC = new JTextField();
		txtnombreC.setEditable(false);
		txtnombreC.setBounds(70, 75, 216, 23);
		panel.add(txtnombreC);
		txtnombreC.setColumns(10);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(298, 78, 61, 14);
		panel.add(lblTelfono);

		txttelefC = new JTextField();
		txttelefC.setEditable(false);
		txttelefC.setBounds(361, 75, 115, 23);
		panel.add(txttelefC);
		txttelefC.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 115, 61, 14);
		panel.add(lblDireccin);

		txtdirC = new JTextField();
		txtdirC.setEditable(false);
		txtdirC.setBounds(70, 112, 406, 23);
		panel.add(txtdirC);
		txtdirC.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo:\r\n");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		txtcodigoFact = new JTextField();
		txtcodigoFact.setEditable(false);
		txtcodigoFact.setText("F-" +TiendaQueso.getInstance().codigoFactura);
		txtcodigoFact.setBounds(70, 8, 216, 20);
		panel.add(txtcodigoFact);
		txtcodigoFact.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 168, 486, 219);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 34, 177, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrDisp = new JScrollPane();
		panel_2.add(scrDisp, BorderLayout.CENTER);
		
		listquesolDispo = new JList<>();
		listquesolDispo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {

				selected = listquesolDispo.getSelectedIndex();

				if(selected >= 0)
				{
					btnIzquierda.setEnabled(true);
				}

			}
		});
		modelDisp = new DefaultListModel<String>();
		listquesolDispo.setModel(modelDisp);
		scrDisp.setViewportView(listquesolDispo);

		scrDisp.setViewportView(listquesolDispo);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(299, 34, 177, 174);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrOrd = new JScrollPane();
		panel_3.add(scrOrd, BorderLayout.CENTER);

		listcarritoCompra = new JList<>();
		listcarritoCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				selected = listcarritoCompra.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnDerecha.setEnabled(true);
				}

			}

		});
		modelOrd = new DefaultListModel<String>();
		listcarritoCompra.setModel(modelOrd);
		listcarritoCompra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrOrd.setViewportView(listcarritoCompra);

		scrOrd.setViewportView(listcarritoCompra);

		btnDerecha = new JButton(">>");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = disponibles.get(selected);
				orden.add(temp);
				modelOrd.addElement(temp);
				btnIzquierda.setEnabled(false);
				disponibles.remove(selected);
				reloadDisp();
				total += Float
						.valueOf(orden.get(indx).substring(orden.get(indx).indexOf(':') + 1, orden.get(indx).length()));
				txttotal.setText(Float.toString(total));
				indx++;

			}
		});
		btnDerecha.setBounds(200, 83, 89, 25);
		panel_1.add(btnDerecha);

		btnIzquierda = new JButton("<<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				String temp = orden.get(selected);
				disponibles.add(temp);
				modelDisp.addElement(temp);
				btnDerecha.setEnabled(false);
				total -= Float.valueOf(orden.get(selected).substring(orden.get(selected).indexOf(':') + 1,
						orden.get(selected).length()));
				txttotal.setText(Float.toString(total));
				orden.remove(selected);
				reloadOrden();
				indx--;
			}
		});
		btnIzquierda.setBounds(200, 119, 89, 23);
		panel_1.add(btnIzquierda);

		JLabel lblQuesosDisponibles = new JLabel("Quesos Disponibles");
		lblQuesosDisponibles.setBounds(10, 11, 177, 14);
		panel_1.add(lblQuesosDisponibles);

		JLabel lblCarritoDeCompra = new JLabel("Carrito de Compra");
		lblCarritoDeCompra.setBounds(299, 9, 177, 14);
		panel_1.add(lblCarritoDeCompra);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(311, 398, 46, 14);
		contentPanel.add(lblTotal);

		txttotal = new JTextField();
		txttotal.setEditable(false);
		txttotal.setBounds(354, 395, 130, 20);
		contentPanel.add(txttotal);
		txttotal.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnFacturar = new JButton("Facturar");
				btnFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Cliente aux = TiendaQueso.getInstance().clienteEcontrado(txtcedula.getText());
						if (aux == null) {
							aux = new Cliente(txtcedula.getText(), txtnombreC.getText(), txtdirC.getText(),
									txttelefC.getText());
							TiendaQueso.getInstance().getMisCliente().add(aux);
						}
						ArrayList<Queso> carritoCompra = new ArrayList<>();
						
						for (int i = 0; i < orden.size(); i++) {
							String codChs = orden.get(i).substring(0, orden.get(i).indexOf(':'));
							Queso chs = TiendaQueso.getInstance().buscarQueso(codChs);
							int posicion = TiendaQueso.getInstance().IndexQueso(chs.getCodigo());
							carritoCompra.add(TiendaQueso.getInstance().getMisQuesos().remove(posicion));
						}
						
						Factura auxF = new Factura(aux,"F-" + String.valueOf(TiendaQueso.getInstance().codigoFactura),carritoCompra);
						TiendaQueso.getInstance().insertarFactura(auxF);
						JOptionPane.showMessageDialog(null, "Operación Satisfactoria", "Factura realizada",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
				btnFacturar.setActionCommand("OK");
				buttonPane.add(btnFacturar);
				getRootPane().setDefaultButton(btnFacturar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadDisp();
		loadOrden();
	}
	
	private void clean()
	{
		
		txtcedula.setText("");
		txtdirC.setText("");
		txttelefC.setText("");
		txtnombreC.setText("");
		txtnombreC.setEditable(false);
		txttelefC.setEditable(false);
		txtdirC.setEditable(false);
		txttotal.setText("0");
		disponibles = new ArrayList<>();
		orden = new ArrayList<>();
		modelOrd.removeAllElements();
		total = 0;
		loadDisp();
	}

	private void reloadOrden() {
		modelOrd.removeAllElements();
		String aux = "";
		for (String ord : orden) {
			aux = ord;
			modelOrd.addElement(aux);
		}
	}

	private void reloadDisp() {
		modelDisp.removeAllElements();
		String aux = "";
		for (String disp : disponibles) {
			aux = disp;
			modelDisp.addElement(aux);
		}
	}

	private void loadOrden() {
		modelOrd.removeAllElements();
	}

	private void clear() {
		txtcedula.setText("");
		txtdirC.setText("");
		txtnombreC.setText("");
		txttelefC.setText("");
	}
	private void loadDisp()
	{
		modelDisp.removeAllElements();
		String aux = "";
		for(Queso cheese: TiendaQueso.getInstance().getMisQuesos())
		{
			aux = cheese.getCodigo()+": "+cheese.precioT();
			disponibles.add(aux);
			modelDisp.addElement(aux);
		}
	}
}
