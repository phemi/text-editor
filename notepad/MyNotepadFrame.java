/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package works;

/**
 *
 * @author methodmain
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.undo.UndoManager;

public class MyNotepadFrame extends JFrame{
    private Box box;
    private JPopupMenu popupMenu;
    private String pendingText = null;
    private JScrollPane jScrollPane;
    private JCheckBox showFontMenu ;
    private JCheckBox previewColor;
    private JCheckBox matchCaseCheckBox;
    private JFrame replaceFrame = new JFrame("Replace");
    private JFrame findFrame = new JFrame("Find");
    private JPanel northPanel ;
    private JPanel southPanel;
    private JPanel textAreaPanel ;
    private JPanel replacePanel ;
    private JComboBox fontNameComboBox;
    private JComboBox fontSizeComboBox;
    private JButton replaceJbutton;
    private JButton findJButton;
    private JButton findNextJButton;
    private JButton replaceJButton;
    private JButton replaceAllJButton;
    private JButton cancelJButton;
    private JButton boldButton;
    private JButton italicsButton;
    private JButton underlineButton;
    private JButton colorButton;
    private JTextArea textArea;
    private JTextField findJTextField;
    private JTextField replaceJTextField;
    private JMenuItem selectAllItem;
    private JMenuItem undoItem;
    private JMenuItem redoItem;
    private JMenuItem cutItem;
    private JMenuItem copyItem ;
    private JMenuItem deleteItem;
    private JMenuItem findItem;
    private JMenuItem findNextItem;
    private JMenuItem time_dateItem ;
    private JMenuItem saveAsMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem newMenuItem;
    private JMenuItem openMenuItem;
    private JProgressBar progressBar = new JProgressBar(0, 100);
    private JFileChooser fileChooser;
    private UndoManager undoManager;
    private JFrame colorFrame = new JFrame("Set Color");//i ad to intialize it here cos i needed it @apply button b4 d callin its method
    private JPanel colorPanel;
    private JPanel colorShowPanel;
    private JLabel greenLabel = new JLabel("Green");
    private JLabel blueLabel = new JLabel("Blue");
    private JLabel redLabel = new JLabel("Red");
    private JTextField greenTextField;
    private JTextField blueTextField;
    private JTextField redTextField;        
    private JSlider greenSlider;
    private JSlider blueSlider;
    private JSlider redSlider;
    private int greenSliderPosition = 0;
    private int redSliderPosition = 0;
    private int blueSliderPosition = 0;
    private JButton applyColorButton;
    private boolean isDocSaved = true; // to notify if the doc is saved
    private File file = new File("*.txt");
    private File currentOpenFile = new File(file.getPath());//gets current opened file in text area
    private String defaultFileName = "Document";
    private String[] fontNames = {"Agency FB","Aharoni","Algerian","Anadalus","Andy","Angsana New","AngsanaUPC","Aparajita",
                            "Arabic Typesetting","Arial","Arial Black","Arial Narrow","Arial Rounded MT Bold","Arial Unicode MS",
        "Baltica","Baskerville Old Face","Batang","BatangChe","Bauhaus 93",
        "Bell MT","Berlin Sans FB","Berlin Sans FB Demi","Bernard MT Condensed","Blackadder ITC","Bodoni MT",
        "Bodoni MT Black","Bodoni MT Poster Compressed","Book Antiqua","Bookman Old Style","Bookshelf Symbol 7",
        "Bradley Hand ITC","Britannic Bold","Broadway","Browallia New","BrowalliaUPC","Brush Script MT","BSTGreek","BSTHebrew",
        "Buxton Sketch","Calibri","Calibri Light","Californian FB","Calisto MT","Cambria","Cambria Math","Candara","Castellar",
        "Centaur","Century","Century Gothic","Century Schoolbook","Chiller","Colonna MT","Comic Sans MS","Consolas","Constantia",
        "Cooper Black","Copperplate Gothic Bold","Copperplate Gothic Light","Corbel","Cordia New","CordiaUPC","Courier New",
        "Curlz MT","DaunPenh","David","DFKai-SB","Dialog","DialogInput","DilleniaUPC","DokChampa","Dotum","DotumChe","Ebrima",
        "Edwardian Script ITC","Elephant","Engravers MT","Eras Bold ITC","Eras Demi ITC","Eras Light ITC","Eras Medium ITC","Estrangelo Edessa",
        "EucrosiaUPC","Euphemia","FangSong","Felix Titling","Footlight MT Light","Forte",
//        Franklin Gothic Book
//Franklin Gothic Demi
//Franklin Gothic Demi Cond
//Franklin Gothic Heavy
//Franklin Gothic Medium
//Franklin Gothic Medium Cond
//FrankRuehl
//FreesiaUPC
//Freestyle Script
//French Script MT
//Gabriola
//Garamond
//Gautami
//Georgia
//Gigi
//Gill Sans MT
//Gill Sans MT Condensed
//Gill Sans MT Ext Condensed Bold
//Gill Sans Ultra Bold
//Gill Sans Ultra Bold Condensed
//Gisha
//Gloucester MT Extra Condensed
//Goudy Old Style
//Goudy Stout
//Gulim
//GulimChe
//Gungsuh
//GungsuhChe
//Haettenschweiler
//Harlow Solid Italic
//Harrington
//High Tower Text
//Impact
//Imprint MT Shadow
//Informal Roman
//IrisUPC
//Iskoola Pota
//JasmineUPC
//Jing Jing
//Jokerman
//Juice ITC
//KaiTi
//Kalinga
//Kartika
//Khmer UI
//KodchiangUPC
//Kokila
//Kootenay
//Kristen ITC
//Kunstler Script
//Lao UI
//Latha
//Leelawadee
//Levenim MT
//LilyUPC
//Lindsey
//Lucida Bright
//Lucida Calligraphy
//Lucida Console
//Lucida Fax
//Lucida Handwriting
//Lucida Sans
//Lucida Sans Typewriter
//Lucida Sans Unicode
//Magneto
//Maiandra GD
//Malgun Gothic
//Mangal
//Marlett
//Matura MT Script Capitals
//Meiryo
//Meiryo UI
//Microsoft Himalaya
//Microsoft JhengHei
//Microsoft New Tai Lue
//Microsoft PhagsPa
//Microsoft Sans Serif
//Microsoft Tai Le
//Microsoft Uighur
//Microsoft YaHei
//Microsoft Yi Baiti
//MingLiU
//MingLiU-ExtB
//MingLiU_HKSCS
//MingLiU_HKSCS-ExtB
//Miramonte
//Miriam
//Miriam Fixed
//Mistral
//Modern No. 20
//Moire
        "Serif","Times New Roman", "Tahoma"};
    private Integer[] fontSizes= {8,9,10,11,12,14,16,18,20,22,24,26,28,36,48,72};
    private int fontStyle = Font.PLAIN;
    private int fontSize = fontSizes[5];
    private String fontName = fontNames[0];
    private Font font;
    private int greenIntensity =0;
    private int redIntensity =0;
    private int blueIntensity =0;
    private Color presentFontColor= new Color(redIntensity, greenIntensity, blueIntensity);
    private Color prevFontColor = new Color(presentFontColor.getRed(), presentFontColor.getGreen(), presentFontColor.getBlue());
    private JFrame findFrame2 = new JFrame("Find");
    private JTextField findTextField2;
    private JLabel findJLabel2;
    private JPanel directionPanel2;
    private JButton findNextButton2;
    private JButton cancelButton2;
    private JRadioButton upRadioButton2;
    private JRadioButton downRadioButton2;
    private ButtonGroup buttonGroup2;
    private JCheckBox matchCaseComboBox2;
    
    
    public MyNotepadFrame(){
        
        super("My Notepad");
        setTitle(defaultFileName+" - Notepad Love!");
        setLayout(new BorderLayout());
        box  = new Box(BoxLayout.PAGE_AXIS);
        
        //creates text Area
        textArea = new JTextArea();
        textArea.setEditable(true);
        font = new Font(fontName,fontStyle,fontSize);
        presentFontColor = new Color(redIntensity, greenIntensity, blueIntensity);
        textArea.setForeground(presentFontColor);
        textArea.setFont(font);
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setMargin(new Insets(5, 10, 10, 5));
        textArea.setCaretColor(Color.RED);
        //textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        //adds text area with Jscrollpane an its policies
     
        //add(, BorderLayout.CENTER);
        jScrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //Creates the menu bar
        JMenuBar menuBar = new JMenuBar();
        
        
        //creates the menu file and its menu item
        JMenu fileMenu = new JMenu("File");
        newMenuItem = new JMenuItem("New"); //new menu item
        openMenuItem = new JMenuItem("Open");//open menu item
        saveMenuItem = new JMenuItem("Save");//save menu item
        saveAsMenuItem = new JMenuItem("Save As");//save as menu item
        JMenuItem printMenuItem = new JMenuItem("Print");//print menu item
        
        JMenuItem exitMenuItem = new JMenuItem("Exit");//print menu item
        //creates shortcuts for  the file menu's item
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        
        //adds to file menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.addSeparator();// adds seperator
        fileMenu.add(printMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        
        
        //creates the menu Edit
        JMenu editMenu = new JMenu("Edit");
        //creates the menu item for edit
        undoItem = new JMenuItem("Undo");// new undo menu item
        undoItem.setEnabled(false);//sets enablement false
        redoItem = new JMenuItem("Redo");// new undo menu item
        redoItem.setEnabled(false);//sets enablement false
        cutItem = new JMenuItem("Cut");// new undo menu item
        cutItem.setEnabled(false);//sets enablement false
        copyItem = new JMenuItem("Copy");// new undo menu item
        copyItem.setEnabled(false);//sets enablement false
        JMenuItem pasteItem = new JMenuItem("Paste");// new undo menu item
        deleteItem = new JMenuItem("Delete");// new undo menu item
        deleteItem.setEnabled(false);//sets enablement false
        findItem = new JMenuItem("Find...");// new undo menu item
        findItem.setEnabled(false);
        findNextItem = new JMenuItem("Find Next");// new undo menu item
        JMenuItem replaceItem = new JMenuItem("Replace...");// new undo menu item
        findNextItem.setEnabled(false);
        selectAllItem = new JMenuItem("Select All");// new undo menu item
        time_dateItem = new JMenuItem("Time/Date");// new undo menu item
        
        //creates shortcuts
        undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
        redoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK));
        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        findItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
        selectAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        time_dateItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
        
        //adds to edit menu
        editMenu.add(undoItem);
        editMenu.add(redoItem);
        editMenu.addSeparator();//adds separator
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.addSeparator();//adds separator
        editMenu.add(deleteItem);
        editMenu.add(findItem);
        editMenu.add(findNextItem);
        editMenu.add(replaceItem);
        editMenu.addSeparator();//adds separator
        editMenu.add(selectAllItem);
        editMenu.add(time_dateItem);
        
        //creates format menu
        JMenu viewMenu = new JMenu("View");
        
        //creates menu item
        showFontMenu = new JCheckBox("Show font...");
        showFontMenu.setSelected(true);
        viewMenu.add(showFontMenu);
        
        menuBar.add(fileMenu);//adds file menu to menu bar
        menuBar.add(editMenu);//adds edit menu to menu bar
        menuBar.add(viewMenu);
        setJMenuBar(menuBar);//sets menu Bar
        
        //now for the north panel
        northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.X_AXIS));
        fontNameComboBox = new JComboBox(fontNames);
        fontSizeComboBox = new JComboBox(fontSizes);
        fontSizeComboBox.setSelectedIndex(5);
        boldButton = new JButton("B");
        italicsButton = new JButton("I");
        underlineButton = new JButton("U");
        colorButton = new JButton("");
        colorButton.setBackground(presentFontColor);
        northPanel.add(fontNameComboBox);
        northPanel.add(Box.createHorizontalStrut(5));
        northPanel.add(fontSizeComboBox);
        northPanel.add(boldButton);
        northPanel.add(Box.createHorizontalStrut(5));
        northPanel.add(italicsButton);
        northPanel.add(Box.createHorizontalStrut(5));
        northPanel.add(underlineButton);
        northPanel.add(Box.createHorizontalStrut(5));
        northPanel.add(colorButton);
        
        //now for the southPanel
        southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel,BoxLayout.X_AXIS));
        progressBar.setStringPainted(true);
        southPanel.add(progressBar);
        
        //for the poop menu
        popupMenu = new JPopupMenu();
//        popupMenu.add(undoItem);
//        popupMenu.add(redoItem);
//        popupMenu.addSeparator();
//        popupMenu.add(cutItem);
//        popupMenu.add(copyItem);
//        popupMenu.add(pasteItem);
//        popupMenu.add(deleteItem);
//        popupMenu.addSeparator();
//        popupMenu.add(selectAllItem);
//        popupMenu.addSeparator();
     
        //now the main work begins...
        //textArea's listener
        //mouse listener for the text area to show pop up
        
        textArea.addMouseListener(
                new MouseAdapter() {
                public void mouseClicked(MouseEvent evt){
                    if(evt.isMetaDown()){//when d mouse is left clicked
                        popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }
                });
        
        textArea.addCaretListener(
                new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                //System.out.println(textArea.getCaret()+"  "+textArea.getCaretPosition());
                if(textArea.getSelectedText()== null){
                    //enables the ffg item if text area is highlighted
                    cutItem.setEnabled(false);
                    copyItem.setEnabled(false);
                    deleteItem.setEnabled(false);
                    selectAllItem.setEnabled(true);
                }else{
                    ////else, disables them
                    cutItem.setEnabled(true);
                    copyItem.setEnabled(true);
                    deleteItem.setEnabled(true);
                    selectAllItem.setEnabled(false);
                }
                
               
            }
            
        });
        
        undoManager = new UndoManager();
        textArea.getDocument().addUndoableEditListener(undoManager);
        textArea.getDocument().addDocumentListener(
                new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                // does the ffg if the doc is tampered with
                if(textArea.getDocument().getLength()> 0){
                   findItem.setEnabled(true);
                   findNextItem.setEnabled(true);
                }else{
                    findItem.setEnabled(false);
                   findNextItem.setEnabled(false);
                }
                
                //if doc is tampered with and text within is not null
                if(textArea.getText().isEmpty() && file.getName().equals("*.txt")){
                    //i.e if text area is empty and it is a new file i.e not yet saved
                    isDocSaved = true;//re-intializes isDocSaved to true
                }else{
                    isDocSaved = false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //once the doc is tampered with 
                if(textArea.getDocument().getLength()> 0){
                    //does the ffg if there're xters in the text area
                   findItem.setEnabled(true);
                   findNextItem.setEnabled(true);
                }else{
                    //does d ffg if there're no xters int teh text area
                    findItem.setEnabled(false);// i.e nothing to find
                   findNextItem.setEnabled(false);
                }
                
                //if doc is tampered with and text within is not null
                if(textArea.getText().isEmpty() && file.getName().equals("*.txt")){
                    //i.e if text area is empty and it is a new file i.e not yet saved
                    isDocSaved = true;//re-intializes isDocSaved to true
                }else{
                    isDocSaved = false;
                }
            }
            
           

            @Override
            public void changedUpdate(DocumentEvent e) {
                    
               System.out.println("Text area has change update");
            }
        });
        
        
        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {

            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                if(e.getEdit() != null){
                    //as soon as there is an undo bt necessarily a redo
                    undoItem.setEnabled(true);
                    if(undoManager.canRedo()){
                        redoItem.setEnabled(true);
                    }
                }else{
                    //if no undoable edit disables undo and redo e.g 4 new documents
                    undoItem.setEnabled(false);
                    redoItem.setEnabled(true);
                }
                
            }
        });
        
        
        undoItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(undoManager.canUndo()){
                    undoManager.undo();
                    //as long as manager can undo there is a redo there4 sets redo enabled
                    if(undoManager.canRedo()){
                        redoItem.setEnabled(true);
                    }
                }else{
                    undoItem.setEnabled(false);
                }
            }
        });
        
        redoItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(undoManager.canRedo()){
                    undoManager.redo();
                    textArea.select(fontStyle, redIntensity);
                    //as long as manager can redo there is an undo there4 sets undo enabled
                    if(undoManager.canUndo()){
                        undoItem.setEnabled(true);
                    }
                }else{
                    redoItem.setEnabled(false);//if no redo to do sets disables redoItem
                }
            }
        });
        copyItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        });
        cutItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        });
        
        pasteItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });
        
        //selectAllItem's listener
        selectAllItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(textArea.getSelectedText()== null){
                    textArea.selectAll();//performs action of selecting all
                   
                }
            }
        });
        
        
        deleteItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.replaceSelection("");
            }
        });
        findItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(findFrame2.isVisible()){
                    //makes the frame visible
                    findFrame2.setExtendedState(JFrame.NORMAL);
                }
                else{
                    //else the frame is not visible , hence calls method
                    findFrameMethod();
                }
                
                
            }
        });
        
        time_dateItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar calendar = new GregorianCalendar();
                System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
                JFrame frame = new JFrame();
//                try{
//                    //if text area is selected replace the selected stuff with time
//                    if((textArea.getSelectionEnd()-textArea.getSelectionStart()) != 0){
//                        textArea.replaceSelection("23/05/95");
//                    }else{
//                       textArea.getDocument().insertString(textArea.getCaretPosition(), "23/05/95", null); 
//                    }
//                }catch(BadLocationException ex){
//                    ex.printStackTrace();
//                }
                
                //textArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                System.out.println(textArea.getSelectionStart() +" "+textArea.getSelectionEnd());
                //textArea.getDocument().insertString(, "23/05/1994", null);
            }
        });
        
        
        replaceItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(replaceFrame.isVisible()){
                    replaceFrame.setExtendedState(JFrame.NORMAL);
                }
                else{
                    replaceFrameMethod();
                }
                
            }
        });
        
        
        openMenuItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //if document is not tampered with or if its saved, it opes a new doc
                if(isDocSaved){
                    
                    fileChooser = new JFileChooser();
                    FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text", "txt");
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setFileFilter(fileFilter);
                    int returnVal = fileChooser.showOpenDialog(jScrollPane);
                    
                    
                    // if he approves a doc
                    if(returnVal== JFileChooser.APPROVE_OPTION){
                        file = fileChooser.getSelectedFile(); 
                    //next checks if file exists else...
                    if(file.exists()){
                        try{
                            //remeber to try using JEditor pane to open document
                            BufferedReader in = new BufferedReader(new FileReader(file));
                            String line = in.readLine();
                            String storeAllString="";
                            while(line!=null){
                                 String temp = line + "\n";
                                  storeAllString+=temp;
                                  line = in.readLine();
                            }
                            textArea.setText("");//clears text Area
                            textArea.setText(storeAllString);//sets storeAllString
                            //as soon as another file is opened in the text area, frame name has to change
                            defaultFileName = file.getName();
                            setTitle(defaultFileName+" - Notepad Love!");
                            currentOpenFile = new File(file.getPath());//changes current open file
                            //as soon  as another file gets to text area... previous undo edits should vanish
                            undoManager.die();
                            undoItem.setEnabled(false);//disables since no edit
                            redoItem.setEnabled(false);//disables since no edit
                        }catch(IOException ex){
                            
                        }
                            
                    }else{
                        //the file doesnt exist!
                        JOptionPane.showMessageDialog(jScrollPane, file.getName()+"\nfile not found\nCheck the file name and try again.",
                                "Open",JOptionPane.ERROR_MESSAGE);
                        openMenuItem.doClick();//re- clicks open/ reopens open dialog
                    }
                        
                    
                    }
                    
                    //if he doesnt approve or closes open dialog
                    if(returnVal == JFileChooser.CANCEL_OPTION){
                        file = new File(currentOpenFile.getPath());//re- intializes file to the current open file
                        
                    }
                    
                }//the doc is nt saved and wants to open a new one
                else{
                    //asks if he wanna save
                    //the doc is not saved
                    int returnVal = JOptionPane.showConfirmDialog(jScrollPane, "Do you want to save changes to "+defaultFileName+"?", "Notepad Love!", JOptionPane.YES_NO_CANCEL_OPTION
                            ,JOptionPane.QUESTION_MESSAGE);
                    if(returnVal==JOptionPane.YES_OPTION){
                        //yes he wants to save
                        saveMenuItem.doClick();
                        openMenuItem.doClick();//then opens open dialog
                    }
                    if(returnVal == JOptionPane.NO_OPTION){
                        //doesn't want to save so...
                        isDocSaved = true;//set isDocSaved to true i.e assume it is saved
                        openMenuItem.doClick();//re-clicks open menu item i.e goes ahead to open
                        
                    }
                }
            }
        });
        newMenuItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //if doc in text area is saved 
                if(isDocSaved){
                    //and the file is not default, creates a new doc
                        textArea.setText("");//resets txt area
                    defaultFileName = "Document"; //sets default file name
                    file = new File("*.txt"); //resets file to default
                    setTitle(defaultFileName + " - Notepad Love!");//resets frame's title
                     //clears edits
                    undoManager.die();
                    undoItem.setEnabled(false);//disables since no edit
                    redoItem.setEnabled(false);//disables since no edit
                    
                }else{
                    //the doc is not saved
                    int returnVal = JOptionPane.showConfirmDialog(jScrollPane, "Do you want to save changes to "+defaultFileName+"?", "Notepad Love!", JOptionPane.YES_NO_CANCEL_OPTION
                            ,JOptionPane.QUESTION_MESSAGE);
                    if(returnVal==JOptionPane.YES_OPTION){
                        saveMenuItem.doClick();
                        newMenuItem.doClick();//re-clicks new menu item
                    }
                    if(returnVal == JOptionPane.NO_OPTION){
                        //doesn't want to save so...
                        isDocSaved = true;//set isDocSaved to true
                        newMenuItem.doClick();//re-clicks new menu item
                        
                    }
                }
            }
        });
        saveMenuItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //if file is new i.e filename is default:  "*.txt"
                if(file.getName().equals("*.txt")){
                    saveAsMenuItem.doClick();//clicks saveAsMenuItem... hahaha! Badtguy
                }else{
                    //just saves it automatically
                    try{
                        FileWriter fileWriter = new FileWriter(file);
                        PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter));
                        printWriter.write(textArea.getText());
                        printWriter.close();
                        
                        isDocSaved = true; //intializin isDocSaved to true i.e doc is saved
                        //file name remains the same so no need changing the frame's title
                    }catch(IOException ex){
                        JOptionPane.showMessageDialog(jScrollPane,ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        //two issues to check out
        //when it wants to file wants to replace a file already existing
        //saving in some other formats e.g .java, .php, .rtf,.doc,.docx,.ini,.log , .pdf, .txt, 
        //.png, .jpg,.jpeg ,.psd
        saveAsMenuItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    fileChooser = new JFileChooser();
                    FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text", "*.txt");
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setFileFilter(fileFilter);
                    fileChooser.setSelectedFile(file);
                    int returnVal = fileChooser.showSaveDialog(jScrollPane);
                    if(returnVal == JFileChooser.APPROVE_OPTION){
                        file = fileChooser.getSelectedFile();
                        //if the selected file is fresh i.e doesnt exist and the user doesnt end it with .txt...
                        if(!file.exists() && !file.getName().endsWith(".txt")){
                            file = new File(file.getPath()+".txt");//re-instantiate the file with the correct path
                        }
                        //System.out.println(file.getName());
                        FileWriter fileWriter = new FileWriter(file);
                        PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter));
                        printWriter.write(textArea.getText());
                        printWriter.close();
                        isDocSaved = true; //intializin isDocSaved to true i.e doc is saved
                        
                        //as soon as the file is saved it is automatically meant to b opened in the text area, frame name has to change
                        defaultFileName = file.getName();
                        setTitle(defaultFileName+" - Notepad Love!");
                        //as soon  as it is saved as... previous undo edits should vanish
                        undoManager.die();
                        undoItem.setEnabled(false);//disables since no edit
                        redoItem.setEnabled(false);//disables since no edit
                    } 
                    if(returnVal==JOptionPane.CANCEL_OPTION || returnVal==JOptionPane.CLOSED_OPTION){
                        setState(JFrame.DO_NOTHING_ON_CLOSE);
                    }
                }catch(IOException ex){
                    JOptionPane.showMessageDialog(jScrollPane,ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                }
                
                
            }
        });
        
        printMenuItem.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    textArea.print();
                }catch(PrinterException ex){
                    
                }
            }
        });
        showFontMenu.addItemListener(
                new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()== ItemEvent.SELECTED){
                    northPanel.setVisible(true);//sets it visible
                }else{
                    northPanel.setVisible(false);//sets it visible
                }
            }
        });
        
        
        colorButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(colorFrame.isVisible()){
                    colorFrame.setExtendedState(JFrame.NORMAL);
                }
                else{
                    colorFrameMethod();
                }
            }
        });
        
        boldButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Notes: the index of a alphahbet == the caret position when the cursor is b4 the word if it is the first line
                //line of offset returns an int representin the line at the offset e.g line no of the cursor position (note: uses java numbering)
                //also note caret position, lineStartOffset, lineEndOffset counts "\n" as a position
                //lineStartOfOffset returns  an int rep the position of the cursor b4 the first letter on that line
                //lineEndOfOffset returns an int rep the position of the cursor after the last letter on that line
                //so i came up with the formular:
                //the index of a letter in a text area = textArea.getCaretPosition  - textArea.getLineOfOffset(textArea. getCaretPosition)
                //kudos!
                //if font style is not bold sets it to bold else back to plain
               if(fontStyle != Font.BOLD){
                   fontStyle = Font.BOLD;
                   font = new Font(fontName, fontStyle, fontSize);//sets the font style to Bold
                   textArea.setFont(font);//sets the new font
               }else{
                   fontStyle = Font.PLAIN;
                   font = new Font(fontName, fontStyle, fontSize);//sets the font style to plain
                   textArea.setFont(font);//sets the new font
               }
                
            }
        });
        
        italicsButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //if font style is not ITALIC sets it to ITALIC else back to plain
                if(fontStyle != Font.ITALIC){
                   fontStyle = Font.ITALIC;
                   font = new Font(fontName, fontStyle, fontSize);//sets the font style to italic
                   textArea.setFont(font);//sets the new font
               }else{
                   fontStyle = Font.PLAIN;
                   font = new Font(fontName, fontStyle, fontSize);//sets the font style to plain
                   textArea.setFont(font);//sets the new font
               }
            }
        });
        
        fontSizeComboBox.addItemListener(
                new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                //if there is a state change it changes the font size to the current selection change
                if(e.getStateChange() == ItemEvent.SELECTED){
                    fontSize = fontSizes[fontSizeComboBox.getSelectedIndex()];//sets the font size to the current selection change
                    font = new Font(fontName, fontStyle, fontSize);//re-instantiates font
                    textArea.setFont(font);//sets the new font
                }
            }
        });
        
        fontNameComboBox.addItemListener(
                new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    fontName = fontNames[fontNameComboBox.getSelectedIndex()];
                    font = new Font(fontName, fontStyle, fontSize);
                    textArea.setFont(font);
                }
            }
        });
        
        box.add(northPanel);
        add(northPanel, BorderLayout.NORTH);
        add(jScrollPane);
        add(southPanel, BorderLayout.SOUTH);
        
        
        
        //window listener for the Notepad frame
        addWindowListener(
                new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //when window is about to close
                //if doc in text area is not saved 
                if(!isDocSaved){
                    //the doc is not saved
                    int returnVal = JOptionPane.showConfirmDialog(jScrollPane, "Do you want to save changes to "+defaultFileName+"?", "Notepad Love!", JOptionPane.YES_NO_CANCEL_OPTION
                            ,JOptionPane.QUESTION_MESSAGE);
                    if(returnVal==JOptionPane.YES_OPTION){
                        //if yes wnta to save...
                        saveMenuItem.doClick();//saves b4 shutting down
                    }
                    if(returnVal == JOptionPane.NO_OPTION){
                        //shuts down as usual
                    } 
                    if(returnVal == JOptionPane.CANCEL_OPTION){
                      setState(JFrame.NORMAL);
                      e.setSource(JFrame.DO_NOTHING_ON_CLOSE);
                    }
                    
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //when app is iconified
                if(replaceFrame.isVisible()){
                    replaceFrame.setState(JFrame.ICONIFIED);
                }
                if(colorFrame.isVisible()){
                    colorFrame.setState(JFrame.ICONIFIED);
                }
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                
            }

            @Override
            public void windowActivated(WindowEvent e) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }
        });
        
//        //MY NOTES!!!
        //using highlighter
//        Highlighter highlighter = new DefaultHighlighter();
//                HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.BLUE);
//                textArea.setHighlighter(highlighter);
//                
//                //remeba to include toUppercase and to lower case features when selected or not
//                //i will use this for the find and replace stuff
//                String content = textArea.getText();
//                String highlitText = "femi";
//                int start = content.indexOf(highlitText);
//                int end = start+highlitText.length();
//                textArea.select(start, end);
//                textArea.replaceSelection("OluwANiran");
                //coming back to this
//                try{
//                    int end = start+highlitText.length();
//                    highlighter.addHighlight(start, end,painter);
//                    System.out.print(textArea.getSelectedText());
//                }
//                catch(BadLocationException ex){
//                    ex.printStackTrace();
//                }
    }
    
    
    
    private void replaceFrameMethod() {
        replaceFrame = new JFrame("");
                
                
                replacePanel = new JPanel();
        GridBagLayout replacePanelLayout = new GridBagLayout();
        replacePanel.setLayout(replacePanelLayout);//sets layout
        GridBagConstraints replacePanelConstraints = new GridBagConstraints();
        
        JLabel findJLabel = new JLabel("Find what:");
        replacePanelConstraints.gridx=0;//sets column
        replacePanelConstraints.gridy=0;//sets row
        replacePanelLayout.setConstraints(findJLabel, replacePanelConstraints);
        replacePanel.add(findJLabel);
                
        JLabel replaceJLabel = new JLabel("Replace with:");
        replacePanelConstraints.gridx=0;//sets column
        replacePanelConstraints.gridy=1;//sets row
        replacePanelLayout.setConstraints(replaceJLabel, replacePanelConstraints);
        replacePanel.add(replaceJLabel);
                
        
        //findJTextField.setEditable(true);
        findJTextField = new JTextField(15);
        replacePanelConstraints.gridx=1;//sets column
        replacePanelConstraints.gridy=0;//sets row
        replacePanelLayout.setConstraints(findJTextField, replacePanelConstraints);
        replacePanel.add(findJTextField);
                
        replaceJTextField = new JTextField(15);
        //replaceJTextField.setEditable(true);
        replacePanelConstraints.gridx=1;//sets column
        replacePanelConstraints.gridy=1;//sets row
        replacePanelLayout.setConstraints(replaceJTextField, replacePanelConstraints);
        replacePanel.add(replaceJTextField);
                
        
        findNextJButton = new JButton("  Find Next  ");
        findNextJButton.setEnabled(true);
        replacePanelConstraints.gridx=2;//sets column
        replacePanelConstraints.gridy=0;//sets row
        replacePanelConstraints.weightx=2;
        replacePanelConstraints.weighty=0;
        replacePanelLayout.setConstraints(findNextJButton, replacePanelConstraints);
        replacePanel.add(findNextJButton);
                
        replaceJButton = new JButton("   Replace   ");
        replaceJButton.setSize(56,5);
        replaceJButton.setEnabled(true);
        replacePanelConstraints.gridx=2;//sets column
        replacePanelConstraints.gridy=1;//sets row
        replacePanelLayout.setConstraints(replaceJButton, replacePanelConstraints);
        replacePanel.add(replaceJButton);
                
        replaceAllJButton = new JButton("Replace All");
        replaceAllJButton.setEnabled(true);
        replacePanelConstraints.gridx=2;//sets column
        replacePanelConstraints.gridy=2;//sets row
        replacePanelLayout.setConstraints(replaceAllJButton, replacePanelConstraints);
        replacePanel.add(replaceAllJButton);
        //System.out.print(replaceAllJButton.getSize());
                
        cancelJButton = new JButton("     Cancel   ");
        replacePanelConstraints.gridx=2;//sets column
        replacePanelConstraints.gridy=3;//sets row
        replacePanelLayout.setConstraints(cancelJButton, replacePanelConstraints);
        replacePanel.add(cancelJButton);
                
        matchCaseCheckBox = new JCheckBox("Match Case");
        replacePanelConstraints.gridx=0;//sets column
        replacePanelConstraints.gridy=4;//sets row
        replacePanelLayout.setConstraints(matchCaseCheckBox, replacePanelConstraints);
        replacePanel.add(matchCaseCheckBox);
        
        //findNExt button's listener
        findNextJButton.addActionListener(
                new ActionListener() {
                    int indexFoundAt=-1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                            String searchString = findJTextField.getText();
                            int cursorPosition = textArea.getCaretPosition();//gets cursor's position
                            if(!searchString.equals("")){
                                String stringToBeSearched = textArea.getText().substring(cursorPosition);
                                
                                if(matchCaseCheckBox.isSelected()){
                                    //if match case is selected searches takin note of the Case
                                    indexFoundAt = stringToBeSearched.indexOf(searchString);
                                }else{
                                    //it searches not takin  note of the case
                                    String lowerCaseSearchString = searchString.toLowerCase();
                                    String lowerCaseStringToBeSearched = stringToBeSearched.toLowerCase();
                                    indexFoundAt = lowerCaseStringToBeSearched.indexOf(lowerCaseSearchString);
                                }
                                
                                //if it is found
                                if(indexFoundAt>=0){
                                    //System.out.println("Extracted text:"+ stringToBeSearched);
                                    System.out.println("Index found at:"+ indexFoundAt);
                                    int posWithinTextArea = cursorPosition+indexFoundAt;
                                    textArea.select(posWithinTextArea, posWithinTextArea+searchString.length());
                                }else{
                                    //not found
                                    System.out.println("Index not found:"+ indexFoundAt);
                                    JOptionPane.showMessageDialog(replaceFrame, "Cannot find \""+searchString+"\"", "Notepad love!", JOptionPane.INFORMATION_MESSAGE);
                                }
                                
                            }
                        
                    }
                });
        replaceJButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String searchString = findJTextField.getText();
                            int cursorPosition = textArea.getCaretPosition();//gets cursor's position
                            if(!searchString.equals("")){
                                String stringToBeSearched = textArea.getText().substring(cursorPosition);
                                int indexFoundAt= -1;
                                if(matchCaseCheckBox.isSelected()){
                                    //if match case is selected searches takin note of the Case
                                    indexFoundAt = stringToBeSearched.indexOf(searchString);
                                }else{
                                    //it searches not takin  note of the case
                                    String lowerCaseSearchString = searchString.toLowerCase();
                                    String lowerCaseStringToBeSearched = stringToBeSearched.toLowerCase();
                                    indexFoundAt = lowerCaseStringToBeSearched.indexOf(lowerCaseSearchString);
                                }
                                //if it is found
                                if(indexFoundAt>=0){
                                    //System.out.println("Extracted text:"+ stringToBeSearched);
                                    //System.out.println("Index found at:"+ indexFoundAt);
                                    int posWithinTextArea = cursorPosition+indexFoundAt;
                                    textArea.select(posWithinTextArea, posWithinTextArea+searchString.length());
                                    textArea.replaceSelection(replaceJTextField.getText());
                                }else{
                                    //not found
                                    JOptionPane.showMessageDialog(replaceFrame, "Cannot find \""+searchString+"\"", "Notepad love!", JOptionPane.INFORMATION_MESSAGE);
                                }
                                
                            }
                    }
                });
        replaceAllJButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String searchString = findJTextField.getText();
                            int cursorPosition = textArea.getCaretPosition();//gets cursor's position
                            if(!searchString.equals("")){
                                String stringToBeSearched = textArea.getText().substring(cursorPosition);
                                int indexFoundAt= -1;
                                if(matchCaseCheckBox.isSelected()){
                                    //if match case is selected searches takin note of the Case
                                    indexFoundAt = stringToBeSearched.indexOf(searchString);
                                    while(indexFoundAt>=0){
                                        //if it is found
                                        if(indexFoundAt>=0){
                                            //System.out.println("Extracted text:"+ stringToBeSearched);
                                            //System.out.println("Index found at:"+ indexFoundAt);
                                            int posWithinTextArea = cursorPosition+indexFoundAt;
                                            textArea.select(posWithinTextArea, posWithinTextArea+searchString.length());
                                            textArea.replaceSelection(replaceJTextField.getText());
                                            stringToBeSearched = textArea.getText().substring(cursorPosition);
                                            indexFoundAt = stringToBeSearched.indexOf(searchString);
                                        }else{
                                            break;
                                        }
                                    }
                                }else{
                                    //it searches not takin  note of the case
                                    String lowerCaseStringToBeSearched= stringToBeSearched.toLowerCase();
                                    String lowerCaseSearchString = searchString.toLowerCase();
                                    indexFoundAt = lowerCaseStringToBeSearched.indexOf(lowerCaseSearchString);
                                    while(indexFoundAt>=0){
                                        //if it is found
                                        if(indexFoundAt>=0){
                                            //System.out.println("Extracted text:"+ stringToBeSearched);
                                            //System.out.println("Index found at:"+ indexFoundAt);
                                            int posWithinTextArea = cursorPosition+indexFoundAt;
                                            textArea.select(posWithinTextArea, posWithinTextArea+searchString.length());
                                            textArea.replaceSelection(replaceJTextField.getText());
                                            stringToBeSearched = textArea.getText().substring(cursorPosition);
                                            lowerCaseStringToBeSearched= stringToBeSearched.toLowerCase();
                                            lowerCaseSearchString = searchString.toLowerCase();
                                            indexFoundAt = lowerCaseStringToBeSearched.indexOf(lowerCaseSearchString);
                                        }else{
                                            break;
                                        }
                                    }
                               }
                                
                            }
            }
        });
        
        findJTextField.getDocument().addDocumentListener(
                new DocumentListener() {

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        if(findJTextField.getText().isEmpty()){
                            //System.out.println("I'm empty!"+findJTextField.getText().length());
                            
//                            findJButton.setEnabled(false);
//                            findNextJButton.setEnabled(false);
//                            replaceJButton.setEnabled(false);
//                            replaceAllJButton.setEnabled(false);
                        }else{
                           // System.out.println("I'm not empty!"+findJTextField.getText().length());
//                            findJButton.setEnabled(true);
//                            findNextJButton.setEnabled(true);
//                            replaceJButton.setEnabled(true);
//                            replaceAllJButton.setEnabled(true);
                        }
                       // System.out.println("I got here!-insert update"+findJTextField.getText());
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        if(findJTextField.getText().isEmpty()){
                            //System.out.println("I'm empty!"+findJTextField.getText().length());
                            //findJButton.setEnabled(false);
//                            findNextJButton.setEnabled(false);
//                            replaceJButton.setEnabled(false);
//                            replaceAllJButton.setEnabled(false);
                            //textArea.getLineStartOffset(textArea.getLineOfOffset(WIDTH));
                        }else{
                            //System.out.println("I'm not empty!"+findJTextField.getText().length());
//                            findJButton.setEnabled(true);
//                            findNextJButton.setEnabled(true);
//                            replaceJButton.setEnabled(true);
//                            replaceAllJButton.setEnabled(true);
                        }
                        //System.out.println("I got here!-remove update"+findJTextField.getText());
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        System.out.println("I got here!-change update");
                    }
                });
        cancelJButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                replaceFrame.dispose();
            }
        });
        replaceFrame.add(replacePanel);
        replaceFrame.setAlwaysOnTop(true);
        replaceFrame.setLocationRelativeTo(jScrollPane);
        replaceFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        replaceFrame.setSize(400, 200);
        replaceFrame.setResizable(false);
                replaceFrame.setVisible(true);
                //replaceFrame.pack(); //dis makes d stuff jam packed
        
        
        
               
            }
    
    //find frame method
    private void findFrameMethod(){
        findFrame2 = new JFrame("Find");
        
        GridBagLayout findGridBagLayout= new GridBagLayout();
        GridBagConstraints findConstraints = new GridBagConstraints();
        
        findFrame2.setLayout(findGridBagLayout);
        
        findJLabel2 = new JLabel("Find what:");
        findConstraints.gridx= 0;//sets column
        findConstraints.gridy = 0;//sets row
        findFrame2.add(findJLabel2, findConstraints);
        
        findTextField2 = new JTextField(15);
        findConstraints.gridx= 1;//sets column
        findConstraints.gridy = 0;//sets row
        findConstraints.gridwidth=2;//no of cols it occupies
        findFrame2.add(findTextField2, findConstraints);
        
        findNextButton2 = new JButton(" Find Next");
        findConstraints.gridx= 3;//sets column
        findConstraints.gridy = 0;//sets row
        findConstraints.weightx= 0.000000001;
        findConstraints.weighty=0.0000000000001;
        findConstraints.gridwidth=1;//no of cols it occupies
        findFrame2.add(findNextButton2, findConstraints);
        
        directionPanel2 = new JPanel(new FlowLayout());
        directionPanel2.setBorder(BorderFactory.createTitledBorder("Direction"));
        
        
        upRadioButton2 = new JRadioButton("Up");
        downRadioButton2 = new JRadioButton("Down");
        
        directionPanel2.add(upRadioButton2);
        directionPanel2.add(downRadioButton2);
        findConstraints.weightx= 0;
        findConstraints.weighty=0;
        findConstraints.gridx= 2;//sets column
        findConstraints.gridy = 1;//sets row
        findConstraints.gridheight=2;//no of cols it occupies
        findConstraints.gridwidth=1;//no of rows it occupies
        findFrame2.add(directionPanel2, findConstraints);
//        
        cancelButton2 = new JButton("  Cancel  ");
        findConstraints.gridx= 3;//sets column
        findConstraints.gridy = 1;//sets row
        findConstraints.gridheight=1;//no of cols it occupies
        findConstraints.gridwidth=1;//no of rows it occupies
        findFrame2.add(cancelButton2, findConstraints);
        
        matchCaseComboBox2 = new JCheckBox("Match Case");
        findConstraints.gridx= 0;//sets column
        findConstraints.gridy = 3;//sets row
        findConstraints.gridheight=1;//no of cols it occupies
        findConstraints.gridwidth=1;//no of rows it occupies
        findFrame2.add(matchCaseComboBox2, findConstraints);
        
        //find nextbutton2's action listener
        findNextButton2.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String searchString = findTextField2.getText();
                int cursorPosition = textArea.getCaretPosition();//gets cursor's position
                
                if(!searchString.equals("")){
                    String stringToBeSearched = textArea.getText();
                    int indexFoundAt= -1;
                    
                    //if down radio button is selected searches from that portion downwards
                    if(downRadioButton2.isSelected()){
                        try{
                            if(textArea.getSelectedText() != null){
                                //i did so that incase a word is selected when moving upward and changes doenward
                                //it doesnt read the word again, instead it skips it
                                //by moving d cursor to it's end
                                cursorPosition=textArea.getSelectionEnd();
                            }
                            
                            
                            stringToBeSearched= stringToBeSearched.substring(cursorPosition, textArea.getLineEndOffset(textArea.getLineCount()-1));
                            if(matchCaseComboBox2.isSelected()){
                                //if match case is selected searches takin note of the Case
                                indexFoundAt = stringToBeSearched.indexOf(searchString);
                            }else{
                                //it searches not takin  note of the case
                                String lowerCaseSearchString = searchString.toLowerCase();
                                String lowerCaseStringToBeSearched = stringToBeSearched.toLowerCase();
                                indexFoundAt = lowerCaseStringToBeSearched.indexOf(lowerCaseSearchString);
                            }
                                
                        //if it is found
                        if(indexFoundAt>=0){
                            System.out.println("Index found at:"+ indexFoundAt);
                            int posWithinTextArea = cursorPosition+indexFoundAt;
                            textArea.select(posWithinTextArea, posWithinTextArea+searchString.length());
                        }else{
                            //not found
                            JOptionPane.showMessageDialog(findFrame2, "Cannot find \""+searchString+"\"", "Notepad love!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                    }catch(BadLocationException ex){
                        ex.printStackTrace();
                    }
                }
                    
                    
                //if up radio button is selected searches from that portion upwards
                if(upRadioButton2.isSelected()){
                    if(textArea.getSelectedText()!=(null)){
                        //i did so that incase a word is selected when moving downward and changes upward
                        //it doesnt read the word again, instead it skips it
                        //by moving d cursor to words beginning
                        cursorPosition=textArea.getSelectionStart();
                    }
                       stringToBeSearched= stringToBeSearched.substring(0, cursorPosition);
//                    
                       if(matchCaseComboBox2.isSelected()){
                            //if match case is selected searches takin note of the Case
                            indexFoundAt = stringToBeSearched.lastIndexOf(searchString, cursorPosition);
                        }else{
                            //it searches not takin  note of the case
                            String lowerCaseSearchString = searchString.toLowerCase();
                            String lowerCaseStringToBeSearched = stringToBeSearched.toLowerCase();
                            indexFoundAt = lowerCaseStringToBeSearched.lastIndexOf(lowerCaseSearchString, cursorPosition);
                        }
                                
                        //if it is found
                        if(indexFoundAt>=0){
                            //marks text from that position backwards
                            textArea.setCaretPosition(indexFoundAt+searchString.length());
                            textArea.moveCaretPosition(indexFoundAt);
                    
                        }else{
                            //not found
                            JOptionPane.showMessageDialog(findFrame2, "Cannot find \""+searchString+"\"", "Notepad love!", JOptionPane.INFORMATION_MESSAGE);
                        }
                }
                
           }
       }
        });
      
        //Cancel's button action listener
        cancelButton2.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                findFrame2.dispose();
            }
        });
        
        buttonGroup2 = new ButtonGroup();
        downRadioButton2.setSelected(true);
        buttonGroup2.add(upRadioButton2);
        buttonGroup2.add(downRadioButton2);
        
        
        
        findFrame2.setLocationRelativeTo(jScrollPane);
        findFrame2.setAlwaysOnTop(true);
        findFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        findFrame2.setSize(390, 150);
        findFrame2.setResizable(false);
        findFrame2.setVisible(true);
        
    }
    private void colorFrameMethod(){
         //as soon s the color button is cicked it saves the prev settings of the fontcolor
                prevFontColor = presentFontColor;
                colorFrame = new JFrame("Set Color");//if i dnt re-intialize it the components within this frame wldnt work
                
                colorFrame.setLayout(new BorderLayout());
                
                colorPanel = new JPanel();
                GridBagLayout colorLayout = new GridBagLayout();
                GridBagConstraints colorConstraints = new GridBagConstraints();
                //colorLayout.setConstraints(colorPanel, colorConstraints);
                colorPanel.setLayout(colorLayout);
                
                colorShowPanel = new JPanel();
                colorShowPanel.setMinimumSize(new Dimension(50, 50));
                colorShowPanel.setPreferredSize(new Dimension(50, 50));
                colorShowPanel.setBackground(presentFontColor);
                
                greenSlider = new JSlider(0, 255, presentFontColor.getGreen());//sets slider to the current green intensity
                blueSlider =  new JSlider(0, 255, presentFontColor.getBlue());//sets slider to the current blue intensity
                redSlider = new JSlider(0, 255, presentFontColor.getRed());//sets slider to the current red intensity
                
                greenSlider.setValueIsAdjusting(true);
                redSlider.setValueIsAdjusting(true);
                blueSlider.setValueIsAdjusting(true);
                
                redSlider.addChangeListener(
                        new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        redIntensity = redSlider.getValue();//sets the red intensity
                        redTextField.setText(String.valueOf(redIntensity));
                        presentFontColor = new Color(redIntensity, greenIntensity, blueIntensity);//re instantiate font color
                        colorShowPanel.setBackground(presentFontColor);//sets colorshowpanel's color
                    }
                });
                
                greenSlider.addChangeListener(
                        new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        greenIntensity = greenSlider.getValue();
                        greenTextField.setText(String.valueOf(greenIntensity));
                        presentFontColor = new Color(redIntensity, greenIntensity, blueIntensity);
                        colorShowPanel.setBackground(presentFontColor);
                    }
                });
                
                blueSlider.addChangeListener(
                        new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        blueIntensity = blueSlider.getValue();
                        blueTextField.setText(String.valueOf(blueIntensity));
                        presentFontColor = new Color(redIntensity, greenIntensity, blueIntensity);
                        colorShowPanel.setBackground(presentFontColor);
                    }
                });
                
                
                
                redTextField = new JTextField((String.valueOf(redIntensity)),3); redTextField.setEditable(false);
                blueTextField = new JTextField((String.valueOf(blueIntensity)),3); blueTextField.setEditable(false);
                greenTextField = new JTextField((String.valueOf(greenIntensity)),3);  greenTextField.setEditable(false);
                
                colorConstraints.gridx = 0;//sets column
                colorConstraints.gridy =0; //sets row
                //colorConstraints.weightx=0;//sets space
                colorPanel.add(redLabel, colorConstraints);
                
                colorConstraints.gridx = 1;//sets column
                colorConstraints.gridy =0; //sets row
                //colorConstraints.weightx=0;
                //colorConstraints.gridheight=0;
                colorPanel.add(redSlider, colorConstraints);
                
                colorConstraints.gridx = 2;//sets column
                colorConstraints.gridy =0; //sets row
                //colorConstraints.weightx=0;
                //colorConstraints.gridheight=0;
                colorPanel.add(redTextField, colorConstraints);
                
                colorConstraints.gridx = 3;//sets column
                colorConstraints.gridy =0; //sets row
                //colorConstraints.weightx=0;
                colorConstraints.gridheight=4;
                colorConstraints.gridwidth=3;
                colorPanel.add(colorShowPanel, colorConstraints);
                
                colorConstraints.gridx = 0;//sets column
                colorConstraints.gridy =1; //sets row
               // colorConstraints.weightx=0.01;//sets space
                colorConstraints.gridheight=1;
                colorConstraints.gridwidth=1;
                colorPanel.add(greenLabel, colorConstraints);
                
                colorConstraints.gridx = 1;//sets column
                colorConstraints.gridy =1; //sets row
                //colorConstraints.weightx=0;
                //colorConstraints.gridheight=0;
                colorPanel.add(greenSlider, colorConstraints);
                
                colorConstraints.gridx = 2;//sets column
                colorConstraints.gridy =1; //sets row
                //colorConstraints.weightx=0;
                //colorConstraints.gridheight=0;
                colorPanel.add(greenTextField, colorConstraints);
                
                colorConstraints.gridx = 0;//sets column
                colorConstraints.gridy =3; //sets row
                //colorConstraints.weightx=0;
                //colorConstraints.gridheight=0;
                colorPanel.add(blueLabel, colorConstraints);
                
                colorConstraints.gridx = 1;//sets column
                colorConstraints.gridy =3; //sets row
                //colorConstraints.weightx=0;
                //colorConstraints.gridheight=0;
                colorPanel.add(blueSlider, colorConstraints);
                
                colorConstraints.gridx = 2;//sets column
                colorConstraints.gridy =3; //sets row
                //colorConstraints.weightx=0;
                //colorConstraints.gridheight=0;
                colorPanel.add(blueTextField, colorConstraints);
                
                applyColorButton = new JButton("Apply");
                
                //apply button listner
                applyColorButton.addActionListener(
                        new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //on clicl apply it sets previous color to the new font color then applies it
                        prevFontColor = presentFontColor;
                        textArea.setForeground(prevFontColor);
                        colorButton.setBackground(prevFontColor);//sets the original color button to the new font color
                        colorFrame.dispose();//close the color frame
                    }
                });
                
                colorConstraints.gridx = 3;//sets column
                colorConstraints.gridy =4; //sets row
                colorPanel.add(applyColorButton, colorConstraints);
                
               previewColor = new JCheckBox("Preview");
               
               //prieveiwColor item's listener
               previewColor.addItemListener(
                       new ItemListener() {

                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange()== ItemEvent.SELECTED){
                            textArea.setForeground(presentFontColor);
                            redTextField.setText(String.valueOf(presentFontColor.getRed()));//sets the red text field to the current red intensity
                            greenTextField.setText(String.valueOf(presentFontColor.getGreen()));//sets the green text field to the current green intensity
                            blueTextField.setText(String.valueOf(presentFontColor.getBlue()));//sets the blue text field to the current blue intensity
                            
                            
//                            redSlider.setValue(presentFontColor.getRed());//sets the slider to the current red intensity
//                            greenSlider.setValue(presentFontColor.getGreen());//sets the slider to the current red intensity
//                            blueSlider.setValue(presentFontColor.getBlue());//sets the slider to the current red intensity
                            
                            colorButton.setBackground(presentFontColor);//sets the new font color when selected
                        }
                        else{
                            textArea.setForeground(prevFontColor);
                            redTextField.setText(String.valueOf(prevFontColor.getRed()));//sets the red text field to the previous red intensity
                            greenTextField.setText(String.valueOf(prevFontColor.getGreen()));//sets the green text field to the previous green intensity
                            blueTextField.setText(String.valueOf(prevFontColor.getBlue()));//sets the blue text field to the previous blue intensity
                            
//                            redSlider.setValue(prevFontColor.getRed());//sets the slider to the previous red intensity
//                            greenSlider.setValue(prevFontColor.getGreen());//sets the slider to the previous red intensity
//                            blueSlider.setValue(prevFontColor.getBlue());//sets the slider to the previous red intensity
                             
                            colorButton.setBackground(prevFontColor);//sets the original color button to the new font color 
                         }
                    }
                });
               colorConstraints.gridx=0;//sets Column
               colorConstraints.gridy=5;
               colorPanel.add(previewColor, colorConstraints);
                
               
               //on shutting colorFrame
               colorFrame.addWindowListener(
                       new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                //System.out.println("I'm opening "+ colorFrame.isVisible());
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //when the window is about closing
                //wen it is abt closing sets to the prev color(applie or non applied)
                textArea.setForeground(prevFontColor);
                colorButton.setBackground(prevFontColor);//sets the original color button to the new font color
                presentFontColor = prevFontColor;//sets the general font color to previous color
//                System.out.println("I'm closing "+ colorFrame.isVisible());
//                System.out.println("I'm enabled? "+ colorFrame.isEnabled());
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //whe the window is closed
//                System.out.println("I'm closed "+ colorFrame.isVisible());
//                System.out.println("I'm enabled? "+ colorFrame.isEnabled());
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //it is iconified wen it is restored down
//                System.out.println("I'm Iconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //wen it'snt restored down
                //System.out.println("I'm deiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //when the window becomes visible on screen
//                System.out.println("I'm activated " + colorFrame.isVisible());
//                System.out.println("I'm enabled? "+ colorFrame.isEnabled());
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //when it is nt visible on screen
//                System.out.println("I'm deactivated "+ colorFrame.isVisible());
//                System.out.println("I'm enabled? "+ colorFrame.isEnabled());
            }
        });
                colorPanel.setBorder(BorderFactory.createTitledBorder("Adjust Color"));
                colorFrame.add(colorPanel, BorderLayout.CENTER);
                colorFrame.setLocationRelativeTo(jScrollPane);
                colorFrame.setAlwaysOnTop(true);
                colorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                colorFrame.setSize(400, 200);
                colorFrame.setResizable(false);
                colorFrame.setVisible(true);
    }
    
}
