package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HuespedController;
import controller.ReservasController;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modeloReserva;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
    
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
        
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
				
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE RESERVACIONES / HUESPEDES");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(221, 62, 547, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloReserva = (DefaultTableModel) tbReservas.getModel();
		modeloReserva.addColumn("Numero de Reserva");
		modeloReserva.addColumn("Fecha Check In");
		modeloReserva.addColumn("Fecha Check Out");
		modeloReserva.addColumn("Valor");
		modeloReserva.addColumn("Forma de Pago");
		modeloReserva.addColumn("Id Huesped");
		modeloReserva.addColumn("Nombre Huesped");
		modeloReserva.addColumn("Apellido Huesped");
		
		JScrollPane scroll_reservas = new JScrollPane(tbReservas);
		
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_reservas, null);
		scroll_reservas.setVisible(true);
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		JScrollPane scroll_huespedes = new JScrollPane(tbHuespedes);
		
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_huespedes, null);
		scroll_huespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		
		
		/*
		 * 
		 * EVENTOS / ACTION LISTENER / ETC
		 * 
		 */
		
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		
		
		/*
		 * EVENTS PRINCIPALES
		 */
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarTablaReservas();
				cargarTablaHuespedes();
			}
		});
		
		scroll_huespedes.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				tbReservas.clearSelection(); //limpia la seleccion de la tabla
			}
		});
		
		scroll_reservas.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				tbHuespedes.clearSelection(); //limpia la seleccion de la tabla
			}
		});
		
		lblEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((tbReservas.getSelectedRowCount() != 0 || tbReservas.getSelectedColumnCount() != 0))
					modificarReserva();
				
				if((tbHuespedes.getSelectedRowCount() != 0 || tbHuespedes.getSelectedColumnCount() != 0))
					modificarHuesped();
			}
		});
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if((tbReservas.getSelectedRowCount() != 0 || tbReservas.getSelectedColumnCount() != 0))
					eliminarReserva();
				
				if((tbHuespedes.getSelectedRowCount() != 0 || tbHuespedes.getSelectedColumnCount() != 0))
					eliminarHuesped();
			}
		});
	}
	
	
	
	/*
	 * 
	 * INICIO METODOS
	 * 
	 */
	
	private void cargarTablaHuespedes() {
    	var huespedes = new HuespedController().listarHuesped();
    	
        huespedes.forEach(huesped -> modeloHuesped.addRow(
        		new Object[] { 
        				huesped.getId(),
        				huesped.getNombre(),
        				huesped.getApellido(),
        				huesped.getFechaNacimiento(),
        				huesped.getNacionalidad(),
        				huesped.getTelefono(),}));
    }
	
	private void cargarTablaReservas() {
    	var reservas = new ReservasController().listarReservas();
    	
        reservas.forEach(reserva -> modeloReserva.addRow(
        		new Object[] { 
        				reserva.getId(),
        				reserva.getFechaEntrada(),
        				reserva.getFechaSalida(),
        				reserva.getValor(),
        				reserva.getFormaPago(),
        				reserva.getIdHuesped(),
        				reserva.getNombreHuesped(),
        				reserva.getApellidoHuesped()}));
    }	
	
	private void eliminarReserva() {
		
		Optional.ofNullable(modeloReserva.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
        .ifPresentOrElse(fila -> {
            Integer id = Integer.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 0).toString());
            int cantidadEliminada = 0;
            cantidadEliminada = new ReservasController().eliminarReserva(id);
            modeloReserva.removeRow(tbReservas.getSelectedRow());

            JOptionPane.showMessageDialog(this,cantidadEliminada + " item eliminado con éxito!");
        }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
		
	}
	
	private void eliminarHuesped() {
		
		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
        .ifPresentOrElse(fila -> {
            Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
            int cantidadEliminada = 0;
            cantidadEliminada = new HuespedController().eliminarHuesped(id);
            modeloHuesped.removeRow(tbHuespedes.getSelectedRow());

            JOptionPane.showMessageDialog(this,cantidadEliminada + " item eliminado con éxito!");
        }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
		
	}
	
	private void modificarReserva() {
		
		Optional.ofNullable(modeloReserva.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
        .ifPresentOrElse(fila -> {
            Integer id = Integer.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 0).toString());
            Date fechaEntrada = Date.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 1).toString());
            Date fechaSalida = Date.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 2).toString());
            Integer valor = Integer.valueOf( modeloReserva.getValueAt(tbReservas.getSelectedRow(), 3).toString());
            String formaPago = String.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 4).toString());
            int cantidadModificada = 0;
            cantidadModificada = new ReservasController().modificarReserva(fechaEntrada, fechaSalida, id, valor, formaPago);
            System.out.println(fechaEntrada);

            JOptionPane.showMessageDialog(this,cantidadModificada + " item modificado con éxito!");
        }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
		
	}
	
	private void modificarHuesped() {
		
		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
        .ifPresentOrElse(fila -> {
			
            Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
            String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
            String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
            Date fechaNacimiento = Date.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
            String nacionalidad = String.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4));
            String telefono = String.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5).toString().toString());
            int cantidadModificada = 0;
            cantidadModificada = new HuespedController().modificarHuesped(nombre, apellido, fechaNacimiento, nacionalidad,
            		telefono, id);


            JOptionPane.showMessageDialog(this,cantidadModificada + " item modificado con éxito!");
        }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
		
	}
	
	
	
	/*
	 * 
	 * Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 * 
	 */
	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	 }
	 
	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
