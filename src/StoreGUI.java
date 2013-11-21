import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class StoreGUI extends JPanel implements ListSelectionListener {
	  JLabel label;
	  JLabel picture;
	  JFrame frame;
	  JList itemList;
	  JScrollPane itemScroll;
	  JSplitPane splitPane;
	  JTextArea infoText;
	  JRadioButton radioButtons;
	  JButton viewButton;
	  JPanel buttonPane;
	  String simpleDialogDesc = "Some simple message dialogs";
	  String menuHoverDesc = "SmartStore.com Command Menu";
	  String detailsHoverDesc = "Item Descriptions and Images";
	  String[] name = {"Pirate Latitudes", "The Complete Sherlock Holmes", "Harry Potter and the Deathly Hallows", "Here We Go Again", "McCartney", "The King's Speech",
	            "The Horse Whisperer", "Rocky Horror Picture Show", "The Lord of the Rings"};
	  
	  Controller ctrl = new Controller();
	  
	/** Creates the GUI shown inside the frame's content pane.  */
	public StoreGUI() {
		 
		super(new BorderLayout());
		JFrame frame = new JFrame();
	    this.frame = frame;
		JFrame welcomeFrame = new JFrame("SmartStore.com");
		JOptionPane.showMessageDialog(welcomeFrame, 
				"Welcome to SmartStore.com!", 
				"SmartStore.com", 
				JOptionPane.INFORMATION_MESSAGE);
		
	    
	//Create the components.
      JPanel menuHomePanel = menuTab();
      JSplitPane detailsPanel = itemTab();
      label = new JLabel("Choose a command",
                         JLabel.CENTER);
	

      JTabbedPane tabbedPane = new JTabbedPane();
      tabbedPane.addTab("Menu", null,
                        menuHomePanel,
                        menuHoverDesc);
      tabbedPane.addTab("Item Details", null,
                        detailsPanel,
                        detailsHoverDesc);

      add(tabbedPane, BorderLayout.CENTER);
      add(label, BorderLayout.PAGE_END);
      label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
  }

  /** Sets the text displayed at the bottom of the frame. */
  void setLabel(String newText) {
      label.setText(newText);
  }

      
      /** Creates the panel shown by the first tab. */
      private JPanel menuTab() {
          final int numButtons = 6;
          JRadioButton[] radioButtons = new JRadioButton[numButtons];
          final ButtonGroup group = new ButtonGroup();
       

          JButton selectButton = null;

          final String cartCommand = "cart";
          final String inventoryCommand = "inventory";
          final String yesNoCommand = "yesno";
          final String addCommand = "add";
          final String removeCommand = "remove";
          final String helpCommand = "okay";
          

          radioButtons[0] = new JRadioButton("Cart");
          radioButtons[0].setActionCommand(cartCommand);
          
          radioButtons[1] = new JRadioButton("Inventory");
          radioButtons[1].setActionCommand(inventoryCommand);

          radioButtons[2] = new JRadioButton("Add");
          radioButtons[2].setActionCommand(addCommand);
          
          radioButtons[3] = new JRadioButton("Remove");
          radioButtons[3].setActionCommand(removeCommand);
          
          radioButtons[4] = new JRadioButton("Help");
          radioButtons[4].setActionCommand(helpCommand);

          radioButtons[5] = new JRadioButton("Quit");
          radioButtons[5].setActionCommand(yesNoCommand);

          for (int i = 0; i < numButtons; i++) {
              group.add(radioButtons[i]);
          }
          radioButtons[0].setSelected(true);

          selectButton = new JButton("Select");
          selectButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  String command = group.getSelection().getActionCommand();

                  
                  if (command == cartCommand) {
                      JOptionPane.showMessageDialog(frame,
                                  "Your Cart Contains: " + "\n" + ctrl.getCartInventory());
                  } else if (command == inventoryCommand){
                	  JOptionPane.showMessageDialog(frame,
                			  "Store Inventory: " + "\n" + ctrl.getItemInventory());
                  } else if (command == helpCommand){
                	  JOptionPane.showMessageDialog(frame,
                			  "I need somebody.",
                			  "HELP!",
                			  JOptionPane.INFORMATION_MESSAGE);
                  } else if (command == yesNoCommand) {
                      int n = JOptionPane.showConfirmDialog(
                              frame, "Are you sure you'd like to leave SmartStore.com?",
                              "Quit",
                              JOptionPane.YES_NO_OPTION);
                      if (n == JOptionPane.YES_OPTION) {
                          setLabel("Thank you for shopping with SmartStore.com!");
                          JOptionPane.showMessageDialog(frame,
                        		  "Thank you for shopping with SmartStore.com!",
                        		  "Now Leaving SmartStore.com",
                        		  JOptionPane.PLAIN_MESSAGE);
                          		  System.exit(0);
                      } else if (n == JOptionPane.NO_OPTION) {
                          setLabel("Choose a command");
                      } 
                  } else if (command == addCommand) {
                      String date = (String)JOptionPane.showInputDialog(
                                          frame,
                                          "Enter Date"
                                          + "Please Enter Transaction Date: ",
                                          "(mm/dd/yyyy)");

                      //If a string was returned, say so.
                      if ((date != null) && (date.length() > 0)) {
                    	  Transaction.isValidDate(date);{
                        		if (Transaction.isValidDate(date) == true){
                      			setLabel("Valid Date");
                      			String productID = (String)JOptionPane.showInputDialog(frame,
                      					"Enter Item"
                      					+"What Item Would You Like to Add?",
                      					"Item Name");{
                      						if(ctrl.addToCart(productID) == true){
                      							setLabel("Item Added");
                      						} else {
                      							setLabel("Invalid Item. Item not added");
                      						}
                      					}
                        		}  else {
                                    setLabel("Invalid Date. You entered:  '" + date + "'");
                                    return;
                        		}
                      		} 
                     
                      }
                  } else if (command == removeCommand) {
                	  String date = (String)JOptionPane.showInputDialog(
                              frame,
                              "Enter Date"
                              + "Please Enter Transaction Date: ",
                              "(mm/dd/yyyy)");

                	  //If a string was returned, say so.
                      if ((date != null) && (date.length() > 0)){
                    	  //Transaction.isValidDate(date);{
                  		if (Transaction.isValidDate(date) == true){
                			setLabel("Valid Date");
                  			String productID = (String)JOptionPane.showInputDialog(frame,
                  					"Enter Item"
                  					+ "What Item Would You Like to Remove?",
                  					"Item Name");{
                  						if(ctrl.removeFromCart(productID) == true){
                  							setLabel("Item Removed");
                  						} else {
                  							setLabel("Invalid Item. Item not removed");
                  						}
                  			}
                  		} else {
                          setLabel("Invalid Date. You entered:  '" + date + "'");
                          return;
                  		}
                      } 
                  } 
                  return;
              }
          });
		return createPane1(menuHoverDesc + ":",
                  radioButtons,
                  selectButton);
      }
      
    
      /**I created this**/
      private JSplitPane itemTab(){
    	  JSplitPane itemSplit = new JSplitPane();
    	    JLabel picture = new JLabel();
    	    JList itemList = new JList(); 
    	    JScrollPane itemScroll = new JScrollPane();
    	    JButton viewButton = new JButton();
    	    //JPanel buttonPane = new JPanel();

     
	return createPane2(detailsHoverDesc + ":",
    		  itemSplit,
    		  itemList,
              itemScroll,
              viewButton
              //buttonPane
              );
	
      }

       
      //Renders the selected image
      protected void updateLabel (String name) {
          ImageIcon icon = createImageIcon(name + ".jpg");
          picture.setIcon(icon);
          if  (icon != null) {
              picture.setText(null);
          } else {
              picture.setText("Image not found");
          }
      }
   
      /** Returns an ImageIcon, or null if the path was invalid. */
      protected static ImageIcon createImageIcon(String path) {
         java.net.URL imgURL = StoreGUI.class.getResource(path);
          if (imgURL != null) {
              return new ImageIcon(imgURL);
          } else {
              System.err.println("Couldn't find file: " + path);
              return null;
          }
      }
      
      public JList getImageList() {
          return itemList;
      }

      
      private JSplitPane createPane2(String description,
    		  					 JSplitPane itemSplit,
    		  					 JList itemList,
    		  					 JScrollPane itemScroll,
    		  					 JButton showButton
    		  					 ){
    	  JButton viewButton = null;
      
  	    //Create the list of images and put it in a scroll pane.
          
          itemList = new JList(name);
          itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          itemList.setSelectedIndex(0);
          itemList.addListSelectionListener(this);
           
          
          JScrollPane listScrollPane = new JScrollPane(itemList);
          picture = new JLabel();
          picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
          picture.setHorizontalAlignment(JLabel.CENTER);
          
          
          
          
          JScrollPane pictureScrollPane = new JScrollPane(picture);
          
          
          //Create a split pane with the two scroll panes in it.
          itemSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                     listScrollPane, pictureScrollPane);
          itemSplit.setOneTouchExpandable(true);
          itemSplit.setDividerLocation(150);

          
          
   
          //Provide minimum sizes for the two components in the split pane.
          Dimension minimumSize = new Dimension(300, 200);
          listScrollPane.setMinimumSize(minimumSize);
          pictureScrollPane.setMinimumSize(minimumSize);
   
          //Provide a preferred size for the split pane.
          itemSplit.setPreferredSize(new Dimension(600, 400));
          updateLabel(name[itemList.getSelectedIndex()]);
        
    
          return itemSplit;
     
      }
  
      private JPanel createPane1(String description,
                                JRadioButton[] radioButtons,
                                JButton showButton) {

          int numChoices = radioButtons.length;
          JPanel box = new JPanel();
          JLabel label = new JLabel(description);

          box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
          box.add(label);

          for (int i = 0; i < numChoices; i++) {
              box.add(radioButtons[i]);
          }

          JPanel pane = new JPanel(new BorderLayout());
          pane.add(box, BorderLayout.PAGE_START);
          pane.add(showButton, BorderLayout.PAGE_END);
          return pane;
      }
    

	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("SmartStore.com");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Create and set up the content pane.
	        StoreGUI newContentPane = new StoreGUI();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);

	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }

		public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	}


		
	     public void valueChanged(ListSelectionEvent e) {
			    if (e.getValueIsAdjusting())
		            return;

		        JList itemList = (JList)e.getSource();
		        updateLabel(name[itemList.getSelectedIndex()]);
		        if (itemList.isSelectionEmpty()) {
		            label.setText("Nothing selected.");
		        } else {
		            int index = itemList.getSelectedIndex();
		            //label.setText(name[itemList.getSelectedIndex()]);
		            label.setText(ctrl.getItemInventory());
		        }
				
			}

		
}
