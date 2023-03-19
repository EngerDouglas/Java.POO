package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.TiendaQueso;
import logical.Factura;
import logical.Queso;

import jdk.management.resource.internal.TotalResourceContext;


import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class reporteQueso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtquesoCilindricoHueco;
	private JTextField txtquesoCilindrico;
	private JTextField txtquesoEsferico;
	private JTextField txttotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			reporteQueso dialog = new reporteQueso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public reporteQueso() {
		setTitle("Reporte de Quesos Vendidos\r\n");
		setBounds(100, 100, 266, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 230, 356);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad de Queso Esferico:\r\n");
		lblNewLabel.setBounds(10, 11, 197, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCantidadDeQueso = new JLabel("Cantidad de Queso Cilindrico:\r\n\r\n");
		lblCantidadDeQueso.setBounds(10, 111, 197, 14);
		panel.add(lblCantidadDeQueso);
		
		JLabel lblCantidadDeQueso_1 = new JLabel("Queso Cilindrico Hueco:\r\n\r\n");
		lblCantidadDeQueso_1.setBounds(10, 217, 197, 14);
		panel.add(lblCantidadDeQueso_1);
		
		txtquesoCilindricoHueco = new JTextField();
		txtquesoCilindricoHueco.setEditable(false);
		txtquesoCilindricoHueco.setBounds(67, 254, 140, 20);
		panel.add(txtquesoCilindricoHueco);
		txtquesoCilindricoHueco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad :\r\n");
		lblNewLabel_1.setBounds(10, 257, 57, 14);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("Cantidad :\r\n");
		label.setBounds(10, 161, 57, 14);
		panel.add(label);
		
		txtquesoCilindrico = new JTextField();
		txtquesoCilindrico.setEditable(false);
		txtquesoCilindrico.setColumns(10);
		txtquesoCilindrico.setBounds(67, 158, 140, 20);
		panel.add(txtquesoCilindrico);
		
		JLabel label_1 = new JLabel("Cantidad :\r\n");
		label_1.setBounds(10, 59, 57, 14);
		panel.add(label_1);
		
		txtquesoEsferico = new JTextField();
		txtquesoEsferico.setEditable(false);
		txtquesoEsferico.setColumns(10);
		txtquesoEsferico.setBounds(67, 56, 140, 20);
		panel.add(txtquesoEsferico);
		
		JLabel lblNewLabel_2 = new JLabel("Total:\r\n");
		lblNewLabel_2.setBounds(10, 317, 46, 14);
		panel.add(lblNewLabel_2);
		
		txttotal = new JTextField();
		txttotal.setEditable(false);
		txttotal.setBounds(67, 314, 140, 20);
		panel.add(txttotal);
		txttotal.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
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
		loadquesosVendidos();
	}
	public void loadquesosVendidos() {
		int QC = 0,QE = 0,QCH = 0;
		for(Factura aux: TiendaQueso.getInstance().getMisfacturas()) {
			QC += aux.cantCilindrico();
			QE += aux.cantEsferico();
			QCH += aux.cantCilindricoHueco();
		}
		txtquesoEsferico.setText((String.valueOf(QE)));
		txtquesoCilindrico.setText(String.valueOf(QC));
		txtquesoCilindricoHueco.setText(String.valueOf(QCH));
		txttotal.setText(String.valueOf(QC+QE+QCH));
	}
}
