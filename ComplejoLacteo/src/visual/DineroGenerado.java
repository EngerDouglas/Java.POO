package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import logical.TiendaQueso;
import logical.Factura;
import logical.QuesoCilindrico;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DineroGenerado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txttotal;
	private JTextField txtQuesoCiliH;
	private JTextField txtQuesoEsferico;
	private JTextField txtQuesoCilindrico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DineroGenerado dialog = new DineroGenerado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DineroGenerado() {
		setTitle("Dinero Generado");
		setBounds(100, 100, 475, 323);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 439, 229);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Generado:");
		lblNewLabel.setBounds(10, 201, 108, 14);
		panel.add(lblNewLabel);
		
		txttotal = new JTextField();
		txttotal.setEditable(false);
		txttotal.setBounds(152, 198, 244, 20);
		panel.add(txttotal);
		txttotal.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Queso Cilindrico:");
		lblNewLabel_1.setBounds(10, 11, 98, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Queso Esferico:");
		lblNewLabel_2.setBounds(10, 70, 98, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Queso Cilindrico Hueco:");
		lblNewLabel_3.setBounds(10, 132, 132, 14);
		panel.add(lblNewLabel_3);
		
		txtQuesoCiliH = new JTextField();
		txtQuesoCiliH.setText("0.0");
		txtQuesoCiliH.setEditable(false);
		txtQuesoCiliH.setColumns(10);
		txtQuesoCiliH.setBounds(152, 129, 244, 20);
		panel.add(txtQuesoCiliH);
		
		txtQuesoEsferico = new JTextField();
		txtQuesoEsferico.setText("0.0");
		txtQuesoEsferico.setEditable(false);
		txtQuesoEsferico.setColumns(10);
		txtQuesoEsferico.setBounds(152, 67, 244, 20);
		panel.add(txtQuesoEsferico);
		
		txtQuesoCilindrico = new JTextField();
		txtQuesoCilindrico.setText("0.0");
		txtQuesoCilindrico.setEditable(false);
		txtQuesoCilindrico.setColumns(10);
		txtQuesoCilindrico.setBounds(152, 8, 244, 20);
		panel.add(txtQuesoCilindrico);
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
		loadTotal();
	}
	public void loadTotal() {
		float total = 0 ,TQC = 0,TQE =0 , TQCH = 0;
	
		for(Factura aux: TiendaQueso.getInstance().getMisfacturas()) {
			total += aux.PrecioFactura();
			TQC += aux.precioCilindrico();
			TQE += aux.precioEsferico();
			TQCH += aux.precioCilindricoHueco();
		}
		
		txttotal.setText(String.valueOf(total));
		txtQuesoEsferico.setText(String.valueOf(TQE));
		txtQuesoCilindrico.setText(String.valueOf(TQC));
		txtQuesoCiliH.setText(String.valueOf(TQCH));
	}
}
