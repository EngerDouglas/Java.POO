package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logical.Queso;
import logical.QuesoCilindrico;
import logical.QuesoCilindricoH;
import logical.QuesoEsferico;
import logical.TiendaQueso;
import logical.Cliente;
import logical.Factura;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListadoFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoQueso dialog = new ListadoQueso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoFactura() {
		setBounds(100, 100, 581, 345);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String[] headers = { "Código", "Nombre", "Precio Factura", "Cantidad de Quesos" };

					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);

					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadfactura(0);
	}

	private void loadfactura(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if (index == 0) {
			for (Factura aux : TiendaQueso.getInstance().getMisfacturas()) {
				rows[0] = aux.getCodigo();
				rows[1] = aux.getCliente().getNombre();
				rows[2] = aux.PrecioFactura();
				rows[3] = aux.cantQuesos();
				model.addRow(rows);
			}
		}
	}

}
