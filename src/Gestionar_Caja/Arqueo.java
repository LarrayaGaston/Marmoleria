package arqueo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class Arqueo extends JFrame{

	private double totalVentas;
	private double conteo;
	private double diferencia;
	private MiTabla tablaBilletes;
	private MiTabla tablaMonedas;
	private PanelSur panelSur;
	private JLabel lb_conteo;
	private JLabel lb_diferencia;

	public Arqueo() {
		super("Arqueo de Caja");
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new PanelNorte(), BorderLayout.NORTH);
		getContentPane().add(new PanelCentral(), BorderLayout.CENTER);
		panelSur = new PanelSur();
		getContentPane().add(new PanelSur(), BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private class PanelNorte extends JPanel {
		public PanelNorte() {
			totalVentas = redondearDecimales(Math.random() * 500 + 200 , 2);

			JLabel lb_total = new JLabel("Total ventas: ");
			lb_total.setFont(new Font("Verdana", Font.PLAIN, 22));
			JLabel lb_venta = new JLabel(Double.toString(totalVentas));
			lb_venta.setFont(new Font("Verdana", Font.BOLD, 22));
			lb_venta.setForeground(Color.BLUE);
			add(lb_total);
			add(lb_venta);
		}
	}

	private class PanelCentral extends JPanel {

		public PanelCentral() {
			String[] cabecera = new String[] {"Valor", "Cantidad", "Importe"};

			String[][] datosBilletes = new String[][] {{"500", "", "0"}, {"200", "", "0"},
				{"100", "", "0"}, {"50", "", "0"}, {"20", "", "0"}, {"10", "", "0"}, {"5", "", "0"}};

				String[][] datosMonedas = new String[][] {{"2", "", "0"}, {"1", "", "0"},
					{"0.5", "", "0"}, {"0.2", "", "0"}, {"0.1", "", "0"}, {"0.05", "", "0"}, {"0.02", "", "0"},
					{"0.01", "", "0"}};

					tablaBilletes = new MiTabla(datosBilletes, cabecera);
					tablaBilletes.getModel().addTableModelListener(new CambiosBilletes());
					JScrollPane spBilletes = new JScrollPane(tablaBilletes);
					spBilletes.setPreferredSize(new Dimension(200, 135));
					tablaMonedas = new MiTabla(datosMonedas, cabecera);
					tablaMonedas.getModel().addTableModelListener(new CambiosMonedas());
					JScrollPane spMonedas = new JScrollPane(tablaMonedas);
					spMonedas.setPreferredSize(new Dimension(200, 153));

					JPanel panelBilletes = new JPanel();
					panelBilletes.setBorder(
							BorderFactory.createCompoundBorder(
									new TitledBorder(
											new LineBorder(Color.BLACK, 2), "Billetes"), new EmptyBorder(19, 10, 19, 10)));
					panelBilletes.add(spBilletes);

					JPanel panelMonedas = new JPanel();
					panelMonedas.setBorder(
							BorderFactory.createCompoundBorder(
									new TitledBorder(
											new LineBorder(Color.BLACK, 2), "Monedas"), new EmptyBorder(10, 10, 10, 10)));
					panelMonedas.add(spMonedas);

					add(panelBilletes);
					add(panelMonedas);
		}

	}

	private class PanelSur extends JPanel {

		public PanelSur() {
			conteo = 0;
			diferencia = conteo - totalVentas;
			lb_conteo = new JLabel(Double.toString(conteo));
			lb_conteo.setFont(new Font("Verdana", Font.BOLD, 22));
			lb_conteo.setForeground(Color.BLUE);
			lb_diferencia = new JLabel(Double.toString(diferencia));
			lb_diferencia.setFont(new Font("Verdana", Font.BOLD, 22));
			lb_diferencia.setForeground(Color.BLUE);

			JPanel panelConteo = new JPanel();
			JLabel et_conteo = new JLabel("Conteo: ");
			et_conteo.setFont(new Font("Verdana", Font.PLAIN, 22));
			panelConteo.add(et_conteo);
			panelConteo.add(lb_conteo);

			JPanel panelDiferencia = new JPanel();
			JLabel et_diferencia = new JLabel("Diferencia: ");
			et_diferencia.setFont(new Font("Verdana", Font.PLAIN, 22));
			panelDiferencia.add(et_diferencia);
			panelDiferencia.add(lb_diferencia);

			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(panelConteo);
			add(panelDiferencia);
		}

		public void actualizar(double conteoTablas) {
			conteo = conteoTablas;
			diferencia = conteo - totalVentas;
			lb_conteo.setText(Double.toString(conteo));
			lb_diferencia.setText(String.format("%.2f", redondearDecimales(diferencia, 2)));
		}
	}

	private class MiTabla extends JTable {
		
		int filas;

		public MiTabla(String[][] datos, String[] cabecera) {
			super(datos, cabecera);
			filas = datos.length; //La tabla billetes y la tabla monedas tienen distinto numero de filas
		}

		public double conteoTabla() {

			double conteo = 0d;
			for (int i = 0; i < filas; i++)
				conteo += Double.parseDouble((String)getValueAt(i, 2));
			return conteo;
		}

		//Aquí indico que celdas son editables y cuáles no
		@Override
		public boolean isCellEditable(int row, int column) {
			if (column == 1) //Solo quiero que sea editable la columna central
				return true;
			else
				return false;
		}

	}

	 private class CambiosBilletes implements TableModelListener {
		@Override
		public void tableChanged(TableModelEvent evento) {
			if (evento.getType() == TableModelEvent.UPDATE) {
				int fila = evento.getFirstRow();
				int columna = evento.getColumn();
				if (columna == 1) { //Solo actuamos cuando "escuchamos" cambios en columna 1
					try {
						int cantidad = Integer.parseInt((String)tablaBilletes.getValueAt(fila, 1));
						int valor = Integer.parseInt((String)tablaBilletes.getValueAt(fila, 0));
						tablaBilletes.setValueAt(Integer.toString(cantidad * valor), fila, 2);
						panelSur.actualizar(tablaBilletes.conteoTabla() + tablaMonedas.conteoTabla());
					}catch (Exception e){
						System.out.println(e.getLocalizedMessage());
						JOptionPane.showMessageDialog(null, "Introduzca solo valores numéricos enteros",
								"Tabla Billetes", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
	}

	private class CambiosMonedas implements TableModelListener {
		@Override
		public void tableChanged(TableModelEvent evento) {
			if (evento.getType() == TableModelEvent.UPDATE) {
				int fila = evento.getFirstRow();
				int columna = evento.getColumn();
				if (columna == 1) {
					try {
						int cantidad = Integer.parseInt((String)tablaMonedas.getValueAt(fila, 1));
						Double valor = Double.parseDouble((String)tablaMonedas.getValueAt(fila, 0));
						if (fila < 2) //En estas filas, no son monedas fraccionarias con decimales
							tablaMonedas.setValueAt(Integer.toString(cantidad * valor.intValue()), fila, 2);
						else
							tablaMonedas.setValueAt(Double.toString(redondearDecimales(cantidad * valor, 2)), fila, 2);
						panelSur.actualizar(tablaBilletes.conteoTabla() + tablaMonedas.conteoTabla());
					}catch (Exception e){
						JOptionPane.showMessageDialog(null, "Introduzca solo valores numéricos enteros",
								"Tabla Monedas", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
	}

		private double redondearDecimales(double valorInicial, int numeroDecimales) {
			double parteEntera, resultado;
			resultado = valorInicial;
			parteEntera = Math.floor(resultado);
			resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
			resultado=Math.round(resultado);
			resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
			return resultado;
		}

		public static void main(String[] args) {
			java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {	new Arqueo();}
					});
		}

	}
