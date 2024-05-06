import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class DnD {

	private JFrame frmDd;
	private JTextField cajaVida;
	private JTextField cajaIni;
	private JTextField cajaAC;
	private JTextField cajaVel;
	private JButton botonEne;
	private JComboBox<Object> combo1;
	private JLabel lblEnemigo;
	private JLabel lblVida;
	private JLabel lblIniciativa;
	private JLabel lblArmorClass;
	private JLabel lblSpeed;
	private int selIndex;
	private int index;
	private Object valorNuevo;
	private String valorCajaVida;
	private String valorCajaIniciativa;
	private String valorCajaAC;
	private String valorCajaVel;
	private int count=0;
	private String key;
	private Map<String, List<String>> values;
	private String itemSel;
	private DocumentListener documentListener;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DnD window = new DnD();
					window.frmDd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DnD() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		values = new HashMap<>();
		frmDd = new JFrame();
		frmDd.setFont(new Font("Viner Hand ITC", Font.PLAIN, 12));
		frmDd.setTitle("D&D");
		frmDd.setBounds(100, 100, 801, 621);
		frmDd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDd.getContentPane().setLayout(null);
		
		combo1 = new JComboBox<Object>();
		combo1.setEditable(true);
		combo1.setBounds(20, 61, 143, 22);
		frmDd.getContentPane().add(combo1);
		
		lblEnemigo = new JLabel("Enemy");
		lblEnemigo.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		lblEnemigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemigo.setBounds(20, 23, 143, 22);
		frmDd.getContentPane().add(lblEnemigo);		
		
		cajaVida = new JTextField();
		cajaVida.setBounds(173, 62, 65, 20);
		frmDd.getContentPane().add(cajaVida);
		cajaVida.setColumns(10);
		
		lblVida = new JLabel("Hit Points");
		lblVida.setHorizontalAlignment(SwingConstants.CENTER);
		lblVida.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		lblVida.setBounds(154, 24, 107, 22);
		frmDd.getContentPane().add(lblVida);
				
		cajaIni = new JTextField();
		cajaIni.setColumns(10);
		cajaIni.setBounds(272, 62, 65, 20);
		frmDd.getContentPane().add(cajaIni);
		
		lblIniciativa = new JLabel("Initiative");
		lblIniciativa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciativa.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		lblIniciativa.setBounds(248, 24, 111, 22);
		frmDd.getContentPane().add(lblIniciativa);
	
		cajaAC = new JTextField();
		cajaAC.setBounds(370, 62, 86, 20);
		frmDd.getContentPane().add(cajaAC);
		cajaAC.setColumns(10);
		
		lblArmorClass = new JLabel("Armor Class");
		lblArmorClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblArmorClass.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		lblArmorClass.setBounds(359, 24, 111, 22);
		frmDd.getContentPane().add(lblArmorClass);
		
		cajaVel = new JTextField();
		cajaVel.setBounds(480, 62, 86, 20);
		frmDd.getContentPane().add(cajaVel);
		cajaVel.setColumns(10);
				
		lblSpeed = new JLabel("Speed");
		lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpeed.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		lblSpeed.setBounds(470, 24, 96, 22);
		frmDd.getContentPane().add(lblSpeed);
		
		
		//Usuario introduce enemigos
		combo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					//IF cuando usuario selecciona item
				index=combo1.getSelectedIndex();
				if (index>=0) {
					selIndex = index;
					
				}  //ELSE IF cuando usuario modifica ítem (index = (-1))
				else if ("comboBoxEdited".equals(e.getActionCommand())){
					valorNuevo=combo1.getSelectedItem();
					//Si se añade item antes que dar al botón
					try 
					{
					combo1.removeItemAt(selIndex);
					combo1.insertItemAt(valorNuevo,selIndex );
					combo1.setSelectedItem(valorNuevo);	
					}
					catch (ArrayIndexOutOfBoundsException err)
					{
						combo1.insertItemAt(valorNuevo,selIndex );
						combo1.setSelectedItem(valorNuevo);	
					}
					//eliminar enemigo por usuario
		          	  if(valorNuevo.equals("")) 
					       {
					    	   combo1.removeItemAt(selIndex);
					       }					
				}																
			
			}	
		});
		
		
		botonEne = new JButton("Add Enemy");
		botonEne.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
		botonEne.setToolTipText("Añade un enemigo a la lista");
		botonEne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Usamos un map para dar una lista de valores a la clave (necesario para conectarlo a los textfields
				 key = "Enemy " + count;
	              String[] valorLista = {"Valor 1", "Valor 2", "Valor 3", "Valor 4"};
	                values.put(key, Arrays.asList(valorLista));
	                combo1.addItem(key);
	                count++;
	            
	          /*  catch (Exception err) {
	            	System.out.println("Map error");
	            }*/
			}
		});
		botonEne.setBounds(641, 55, 121, 37);
		frmDd.getContentPane().add(botonEne);
		//pendiente
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(657, 149, 89, 23);
		frmDd.getContentPane().add(btnNewButton);
		
		
	
		// Unir el combobox a los textfields
				combo1.addItemListener(new ItemListener() 
				{
					public void itemStateChanged(ItemEvent e) 
					{
						if (e.getStateChange()== ItemEvent.SELECTED) 
						{
							
							itemSel = (String)combo1.getSelectedItem();
							
							if (values.containsKey(itemSel)) 
							{
								
								List<String> selectedValues= values.get(itemSel);
								
								cajaVida.setText(selectedValues.get(0));
								cajaIni.setText(selectedValues.get(1));
								cajaAC.setText(selectedValues.get(2));
								cajaVel.setText(selectedValues.get(3));
																
							}
							else 
							{
								cajaVida.setText("");
								cajaIni.setText("");
								cajaAC.setText("");
								cajaVel.setText("");
								
							}															
						}												
					}
				});
				
				
				documentListener= new DocumentListener() 
				{
					@Override
					
					public void insertUpdate(DocumentEvent e) 
					{
						  updateValue();
					}

					@Override
					public void removeUpdate(DocumentEvent e) 
					{
						// TODO Auto-generated method stub
						updateValue();
					}

					@Override
					public void changedUpdate(DocumentEvent e) 
					{
						// TODO Auto-generated method stub
						updateValue();
					}
					
					private void updateValue() 
					{
						System.out.println("updateValue() called");
						itemSel = (String) combo1.getSelectedItem().toString();
						valorCajaVida=cajaVida.getText();
						valorCajaIniciativa=cajaIni.getText();
						valorCajaAC=cajaAC.getText();
						valorCajaVel=cajaVel.getText();
						values.put(itemSel, Arrays.asList(valorCajaVida, valorCajaIniciativa, valorCajaAC, valorCajaVel));
					}
				};
				
				cajaVida.getDocument().addDocumentListener(documentListener);
				cajaIni.getDocument().addDocumentListener(documentListener);
				cajaAC.getDocument().addDocumentListener(documentListener);
				cajaVel.getDocument().addDocumentListener(documentListener);
				
	
	}
}
