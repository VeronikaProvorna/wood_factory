package view;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

import event.IProductListener;
import event.ProductEvent;
import model.Cilinder;
import model.IWeight;
import model.Timber;
import model.Waste;
import model.Wood;
import store.ProductStore;
import store.WasteStore;
import store.WoodDirectory;
import threads.CilinderShop;
import threads.TimberShop;

import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Predicate;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainView {
    private infoFrame infoFrame=new infoFrame();
	private JFrame frmProvornaVeronikaKi;
	private JMenuItem menuItemInfo;
    static WoodDirectory wd=new WoodDirectory();
    static ProductStore ps = new ProductStore();
    private JMenu menuWood;
    private JTextArea textArea;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemTextAreaClear;
	private DlgWood dlgWood=new DlgWood();
	private DlgTimber dlgTimber=new DlgTimber();
	private DlgCilinder dlgCilinder=new DlgCilinder();
	private DlgWaste dlgWaste=new DlgWaste();
	private DlgStore dlgStore= new DlgStore();
	private DlgRestore dlgRestore= new DlgRestore();
	private ProtocolFrame pFrame = new ProtocolFrame();
    private ProtocolListener protocolFrame=new ProtocolListener();
	public ProductStore cilinderStore = new ProductStore();
	static WasteStore ws = new WasteStore(3);
	public ProductStore longTimberStore = new ProductStore();
	private DlgShop dlgShop= new DlgShop();
    
    BufferedWriter write = null;
    private JMenuItem menuItemAddListener;
IProductListener pLis = new IProductListener() {
		
		public void onProductEvent(ProductEvent e) {
			try {
				writeToString(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
private JMenuItem menuItemShowLambda;
private JMenuItem menuitemRemoveLambda;
private JMenuItem menuItemTransferLambda;

	public void writeString(String str) throws Exception {
		BufferedWriter write = new BufferedWriter(new FileWriter("LogProvorna.txt",true));
		write.append(str);
   	    DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    String time = dateF.format(cal.getTime());
		write.append(" " + time + "\n");
		write.close();
	}	
	public void writeToString(ProductEvent e) throws Exception {
		BufferedWriter write = new BufferedWriter(new FileWriter("Log.txt",true));
		write.append(e.toString());
   	    DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    String time = dateF.format(cal.getTime());
		write.append(" " + time + "\n");
		write.close();
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frmProvornaVeronikaKi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProvornaVeronikaKi = new JFrame();
		frmProvornaVeronikaKi.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					writeString("[Provorna KI-201] Application was opened at ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		

		frmProvornaVeronikaKi.setTitle("Provorna Veronika KI-201 Lab-4");
		frmProvornaVeronikaKi.setBounds(100, 100, 390, 382);
		frmProvornaVeronikaKi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProvornaVeronikaKi.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		frmProvornaVeronikaKi.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		popupMenu = new JPopupMenu();
		addPopup(textArea, popupMenu);
		
		menuItemTextAreaClear = new JMenuItem("Clear");
		menuItemTextAreaClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClearTextArea();
				menuItemTextAreaClear.setVisible(true);
			}
		});
		popupMenu.add(menuItemTextAreaClear);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		scrollPane.setColumnHeaderView(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(menuFile);
		
		JMenuItem menuItemStore = new JMenuItem("Store");
		menuItemStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onStore();
			}
		});
		menuFile.add(menuItemStore);
		
		JMenuItem menuItemRestore = new JMenuItem("Restore");
		menuItemRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     onRestore();
			}
		});
		menuFile.add(menuItemRestore);
		
		JMenuItem menuItemShowProtocol = new JMenuItem("Show Protocol");
		menuItemShowProtocol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onShowProtocol();
			}
		});
		menuFile.add(menuItemShowProtocol);
		
		menuWood = new JMenu("Wood");
		menuWood.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(menuWood);
		
		JMenuItem menuItemShow = new JMenuItem("Show");
		menuItemShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onWoodShowClick();
			}
		});
		menuWood.add(menuItemShow);
		
		JMenuItem menuItemAdd = new JMenuItem("Add");
		menuItemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textArea.setText("");
				try {
					onAddWood();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuWood.add(menuItemAdd);
		
		JMenuItem menuItemDelete = new JMenuItem("Delete");
		menuWood.add(menuItemDelete);
		
		JMenuItem menuItemEdit = new JMenuItem("Edit");
		menuWood.add(menuItemEdit);
		
		JMenu menuProduct = new JMenu("Product");
		menuProduct.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(menuProduct);
		
		JMenuItem menuItemShowAllPr = new JMenuItem("Show all products");
		menuItemShowAllPr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onProductShowClick();
			}
		});
		menuProduct.add(menuItemShowAllPr);
		
		JMenu menuAdd = new JMenu("Add");
		menuProduct.add(menuAdd);
		
		JMenuItem menuItemAddTimber = new JMenuItem("Timber");
		menuItemAddTimber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					onAddTimber();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuAdd.add(menuItemAddTimber);
		
		JMenuItem menuItemAddCilinder = new JMenuItem("Cilinder");
		menuItemAddCilinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onAddCilinder();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuAdd.add(menuItemAddCilinder);
		
		JMenuItem menuItemAddWaste = new JMenuItem("Waste");
		menuItemAddWaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onAddWaste();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuAdd.add(menuItemAddWaste);
		
		JMenuItem menuItemRnd = new JMenuItem("Create random products");
		menuItemRnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRnd();
			}
		});
		menuProduct.add(menuItemRnd);
		
		menuItemInfo = new JMenuItem("Info");
		menuItemInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onInfoClick();
			}
		});
		
		JMenu menuEvent = new JMenu("Event");
		menuEvent.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(menuEvent);
		
		menuItemAddListener = new JMenuItem("Add listener");
		menuItemAddListener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAddListener();
			}
		});
		menuEvent.add(menuItemAddListener);
		
		JMenuItem menuItemRemoveListener = new JMenuItem("Remove listener");
		menuItemRemoveListener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRemoveListener();
			}
		});
		menuEvent.add(menuItemRemoveListener);
		
		JMenuItem menuItemShowPrListener = new JMenuItem("Show listener's protocol\r\n");
		menuItemShowPrListener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onShowListenerProtocol();
			}
		});
		menuEvent.add(menuItemShowPrListener);
		
		JMenu menuLambda = new JMenu("Lambda");
		menuLambda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(menuLambda);
		
		menuItemShowLambda = new JMenuItem("Show overweight products");
		menuItemShowLambda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onShowLambda();
			}
		});
		menuLambda.add(menuItemShowLambda);
		
		menuitemRemoveLambda = new JMenuItem("Remove overweight products");
		menuitemRemoveLambda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRemoveLambda();
			}
		});
		menuLambda.add(menuitemRemoveLambda);
		
		menuItemTransferLambda = new JMenuItem("Transfer long timbers\r\nand cilinders");
		menuItemTransferLambda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onTransferTimbersAndCilinders();
			}
		});
		menuLambda.add(menuItemTransferLambda);
		menuItemInfo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(menuItemInfo);	
	}
	public void onTransferTimbersAndCilinders() {
			Predicate<Object> prd = new Predicate<Object>() {
				@Override
				public boolean test(Object t) {
					float f = 2f;
					if(t instanceof Timber && ((Timber) t).getLength() > f) {
						longTimberStore.add((Timber) t);
					}
					return t instanceof Timber && ((Timber) t).getLength() > f;
				}			
			};
			textArea.append("\nThe list of long timbers:\n");
			ps.remove(prd);
			longTimberStore.doForAll((t) ->textArea.append("\n"+ t.toString()));
			
			Predicate<Object> prd1 = new Predicate<Object>() {
				@Override
				public boolean test(Object t) {
					float f = 2f;
					if(t instanceof Cilinder && ((Cilinder) t).getLength() > f) {
						cilinderStore.add((Cilinder) t);
					}
					return t instanceof Cilinder && ((Cilinder) t).getLength() > f;
				}			
			};
			textArea.append("\nThe list of long cilinders:\n");
			ps.remove(prd1);
			cilinderStore.doForAll((t) ->textArea.append("\n" + t.toString()));
		}
	private void onProductShowClick() {
		textArea.setText("");
		textArea.append(ps.sortedProdustStore());
		textArea.append("Total weight: "+
				+ps.calcTotalWeight());
		
	}
   protected void onRnd() {
	   dlgShop.getTextArea().setText("");
	   dlgShop.getTextFieldTim().setText("");
	   dlgShop.getTextFieldCil().setText("");
	   dlgShop.setVisible(true);
	   this.textArea.setText("Product store got new products\n");
   }
	protected void onRemoveLambda() {
		Predicate<Object> prd = new Predicate<Object>() {
			String maxWeigt=JOptionPane.showInputDialog(textArea,"Input the max weight:");

			@Override
			public boolean test(Object t) {
				float max=Float.parseFloat(maxWeigt);
				return t instanceof Object && ((IWeight)t).weight()>max;
			}
		};
		textArea.append("\nThe List of timbers after removing");
		ps.doOnlyFor2((t) ->textArea.append("\n" + t.toString()), prd);
	}
	protected void onShowLambda() {
		Predicate<Object> prd = new Predicate<Object>() {
			String maxWeigt=JOptionPane.showInputDialog(textArea,"Input the max weight:");
          
			@Override
			public boolean test(Object t) {
				float max=Float.parseFloat(maxWeigt);
				return t instanceof Object && ((IWeight)t).weight()>max;
			}
		};
        textArea.append("\nThe list of overweight timbers:");
		ps.doOnlyFor((t)->textArea.append("\n"+t.toString()), prd);
	}
	 protected void onInfoClick() {
			infoFrame.setLocation(frmProvornaVeronikaKi.getLocation().x+frmProvornaVeronikaKi.getWidth(),
			frmProvornaVeronikaKi.getLocation().y);
			infoFrame.setVisible(true);
		}	
	protected void onWoodShowClick() {
		textArea.setText("");
		textArea.setText(wd.toString());;
		
	}
    protected void onClearTextArea() {
    	textArea.setText("");
    }
    protected void onShowProtocol() {
		pFrame.setVisible(true);
	}

	protected void onRestore() {
		textArea.setText("");
		//dlgRestore.setVisible(true);
		FileDialog fileDialog = new FileDialog(this.frmProvornaVeronikaKi);
		fileDialog.setMode(FileDialog.LOAD);
		fileDialog.setVisible(true);
		String dir=fileDialog.getDirectory();
		String file = fileDialog.getFile();
		wd=null;
		ps=null;
		if(dir == null || file == null)
			return;
		String fName=dir+file;
		try {
			ObjectInputStream ois=new ObjectInputStream(
					new FileInputStream(fName));
			wd = (WoodDirectory) ois.readObject();
			ps = (ProductStore) ois.readObject();
			ois.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(wd != null) {
			    textArea.append("\n");
				onWoodShowClick();
		}
		if(ps != null) {
		    textArea.append("\n");
				onProductShowClick();
		}
	}

    protected void onStore() {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFileChooser dialog = new JFileChooser();
		dialog.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Файли типу .object";
			}
			
			@Override
			public boolean accept(File f) {
				if(f!=null) {
					return f.isDirectory() || f.toString().endsWith(".object");
				}
				return false;
			}
		});
		dialog.showOpenDialog(null);
		File f =dialog.getSelectedFile();
		if(f != null) {
			System.out.println(f.getName());
			System.out.println(f.getAbsolutePath());
		}
    	dlgStore.setVisible(true);
    	WoodDirectory wd1=wd;
    	ProductStore ps1=ps;
    	try {
    		FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(wd1);
			oos.writeObject(ps1);
			oos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

    	
    }
    public void onAddListener() {
    	ps.addProductListener(pLis);
    }
    public void onRemoveListener() {
    	ps.removeProductListener(pLis);
    }
    public void onShowListenerProtocol() {
    	protocolFrame.setVisible(true);
    }
	protected void onAddWood() throws Exception {
		writeString("Wood was added at ");
		dlgWood.clear();
		int newId=wd.maxId()+1;
		dlgWood.getTextWoodId().setText(String.valueOf(newId));
		dlgWood.setVisible(true);
		Wood newWood = dlgWood.getObject();
		if(newWood!=null)
			wd.add(newWood);
		onWoodShowClick();
	}
	protected void onAddCilinder() throws Exception {
		writeString("Cilinder was added at ");
    	dlgCilinder.clear();
    	dlgCilinder.setWoodDirectory(wd);
    	dlgCilinder.setVisible(true);
    	Cilinder newCilinder= dlgCilinder.getObject();
    	if(newCilinder !=null)
    		ps.add(newCilinder);
    	onProductShowClick();
    }
    protected void onAddTimber() throws Exception {
		writeString("Timber was added at ");
    	dlgTimber.clear();
    	dlgTimber.setWoodDirectory(wd);
    	dlgTimber.setVisible(true);
    	Timber newTimber= dlgTimber.getObject();
    	if(newTimber !=null)
    		ps.add(newTimber);
    	onProductShowClick();
    }
    protected void onAddWaste() throws Exception {
    	dlgWaste.clear();
    	dlgWaste.setVisible(true);
    	Waste newWaste=dlgWaste.getObject();
    	if(newWaste!=null)
    		ps.add(newWaste);
    	onProductShowClick();
		writeString("Waste was added at ");
    }
	

	public JMenu getMenuWood() {
		return menuWood;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	public JMenuItem getMenuItemTextAreaClear() {
		return menuItemTextAreaClear;
	}
	public JMenuItem getMenuItemAddListener() {
		return menuItemAddListener;
	}
	public JMenuItem getMenuItemShowLambda() {
		return menuItemShowLambda;
	}
	public JMenuItem getMenuitemRemoveLambda() {
		return menuitemRemoveLambda;
	}
	public JMenuItem getMenuItemTransferLambda() {
		return menuItemTransferLambda;
	}
}
