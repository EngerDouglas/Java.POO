package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.TiendaQueso;
import logical.Cliente;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];
	private Cliente selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoCliente dialog = new ListadoCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoCliente() {
		setTitle("Lista de Clientes\r\n");
		setBounds(100, 100, 554, 383);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 int rowSelected = -1;
                     rowSelected = table.getSelectedRow();
                     if (rowSelected >= 0)
                     {
                         selected = TiendaQueso.getInstance().buscarClienteByCedula(table.getValueAt(rowSelected, 1).toString());
                     }
				}
			});
			scrollPane.setBounds(0, 0, 538, 304);
			panel.add(scrollPane);
			{
				String[] headers = {"Cedula","Nombre","Telefono"};
				table = new JTable();
				scrollPane.setViewportView(table);
				
				
				table = new JTable();
				scrollPane.setViewportView(table) ;

				model = new DefaultTableModel();
				model.setColumnIdentifiers(headers);
				table.setModel (model) ;
				
			}
		}
		{
			
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadClientes();
	}
	private void loadClientes() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for(Cliente aux: TiendaQueso.getInstance().getMisCliente()) {
			rows[0] = aux.getCedula();
			rows[1] = aux.getNombre();
			rows[2] = aux.getTelefono();
			model.addRow(rows);
		}
	}
}
