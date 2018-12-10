package view;
import model.SiteTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Site;
import model.SiteType;
public class SiteJTable extends JFrame{
    private SiteTableModel sites;
    private JTable table;
    private TableRowSorter<TableModel> rowSorter;
    public SiteJTable(){
        super("My sites store");
        
        sites = new SiteTableModel();
        
        table = new JTable(sites);
        
        
        final JButton addButton = new JButton("Add site");
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        addButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       String[] pet = {"", "", "", "", "", "", ""};
                    JInternalFrame newFrame = new JInternalFrame("Adding", true, true, true, true);
                    GridLayout gridLay = new GridLayout(0,2);
                    gridLay.setHgap(5);
                    gridLay.setVgap(5);
                    newFrame.setLayout(gridLay);
                    newFrame.setVisible(true);
                    newFrame.pack();
                    table.add(newFrame);
                    
                    newFrame.add(new JLabel(getColumnTitle(0)));
                    final JTextField address = new JTextField(20);
                    address.setText("");
                    newFrame.add(address);
                    
                    newFrame.add(new JLabel(getColumnTitle(1)));
                    final JTextField type = new JTextField(20);
                    address.setText("");
                    newFrame.add(type);
                    
                    newFrame.add(new JLabel(getColumnTitle(2)));
                    final JTextField domen = new JTextField(20);
                    address.setText("");
                    newFrame.add(domen);
                    
                    newFrame.add(new JLabel(getColumnTitle(3)));
                    final JTextField price = new JTextField(20);
                    address.setText("");
                    newFrame.add(price);
                    
                    newFrame.add(new JLabel(getColumnTitle(4)));
                    final JTextField siteAlive = new JTextField(20);
                    address.setText("");
                    newFrame.add(siteAlive);
                    
                    newFrame.add(new JLabel(getColumnTitle(5)));
                    final JTextField mainTopic = new JTextField(20);
                    address.setText("");
                    newFrame.add(mainTopic);
                    
                    JButton save = new JButton("Save");
                    save.addActionListener(new ActionListener(){

                           @Override
                           public void actionPerformed(ActionEvent e) {
                               Site site = new Site();
                               site.setAddress(address.getText());
                               SiteType st = new SiteType();
                               st.setTypeName(type.getText());
                               site.setSiteType(st);
                               site.setDomen(domen.getText());
                               site.setPrice(price.getX());
                               site.setSiteAlive(siteAlive.getX());
                               site.addMainTopic(mainTopic.getText());
                               
                               sites.addSite(site);
                               
                           }
                        
                    });
                    newFrame.add(save);
                    JButton cancel = new JButton("Cancel");
                    cancel.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            newFrame.hide();
                        }
                    });
                    newFrame.add(cancel);
                    }
                }
        );
        final JButton removeButton = new JButton("Remove selected site");
        removeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(table.getSelectedRow()!=-1){
                    ((SiteTableModel)table.getModel()).removeSite(table.getSelectedRow());
                    table.updateUI();
                }
            }
        });
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    JTable target = (JTable) e.getSource();
                    final int row = target.getSelectedRow();
                    int colmun = target.getSelectedColumn();
                    final JInternalFrame editorPopup = new JInternalFrame("EDITOR", true, true, true, true);
                    GridLayout gridLayout = new GridLayout(0,2);
                    gridLayout.setHgap(5);
                    gridLayout.setVgap(5);
                    editorPopup.setLayout(gridLayout);
                    
                    
                    
                    editorPopup.add(new JLabel(getColumnTitle(0)));
                    final JTextField addressTf = new JTextField(target.getValueAt(row, 0).toString());
                    editorPopup.add(addressTf);
                    
                    editorPopup.add(new JLabel(getColumnTitle(1)));
                    final JTextField typeTf = new JTextField(target.getValueAt(row, 1).toString());
                    editorPopup.add(typeTf);
                    
                    editorPopup.add(new JLabel(getColumnTitle(2)));
                    final JTextField domenTf = new JTextField(target.getValueAt(row, 2).toString());
                    editorPopup.add(domenTf);
                    
                    editorPopup.add(new JLabel(getColumnTitle(3)));
                    final JTextField priceTf = new JTextField(target.getValueAt(row, 3).toString());
                    editorPopup.add(priceTf);
                    
                    editorPopup.add(new JLabel(getColumnTitle(4)));
                    final JTextField siteAliveTf = new JTextField(target.getValueAt(row, 4).toString());
                    editorPopup.add(siteAliveTf);
                    
                    editorPopup.add(new JLabel(getColumnTitle(5)));
                    final JTextField mainTopicTf = new JTextField(target.getValueAt(row, 5).toString());
                    editorPopup.add(mainTopicTf);
                    
                    JButton ok = new JButton("OK");
                    ok.addMouseListener(new MouseAdapter(){
                          //getsetValueAt(addressTf.getText(), row, 0);
                            public void mouseClicked(MouseEvent e){
                            table.getModel().setValueAt(addressTf.getText(), row, 0);
                            table.getModel().setValueAt(typeTf.getText(), row, 1);
                            table.getModel().setValueAt(domenTf.getText(), row, 2);
                            table.getModel().setValueAt(priceTf.getText(), row, 3);
                            table.getModel().setValueAt(siteAliveTf.getText(), row, 4);
                            table.getModel().setValueAt(mainTopicTf.getText(), row, 5);
                            
                            JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), "Record Saved!");
                        }
                    });
                    editorPopup.add(ok);
                    JButton c = new JButton("Cancel");
                    c.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            editorPopup.hide();
                        }
                    });
                    editorPopup.add(c);
                    editorPopup.pack();
                    target.add(editorPopup);
                    editorPopup.setVisible(true);
                }
            }
        });
        JButton saveToDB = new JButton("Save to DB");
        saveToDB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.print("hello");
                sites.saveToDB();
           
            }
        });
        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table.setFillsViewportHeight(true);

        JPanel inputPanel = new JPanel();
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(saveToDB);
        JTextField tfForSearch = new JTextField();
        Container container = getContentPane();
        container.add(new JScrollPane(table), BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.NORTH);
        JPanel panel = new JPanel(new BorderLayout());
        
        
        JButton search = new JButton("Click to search");        
        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text = tfForSearch.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tfForSearch.getText()));
                }
            }
        });
        
        panel.add(new JLabel("Search:"), BorderLayout.WEST);
        panel.add(tfForSearch, BorderLayout.CENTER);
        panel.add(search, BorderLayout.EAST);
        container.add(panel, BorderLayout.SOUTH);
        
//        tfForSearch.getDocument().addDocumentListener(new DocumentListener(){
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                String text = tfForSearch.getText();
//                if(text.trim().length() == 0){
//                    rowSorter.setRowFilter(null);
//                }
//                else{
//                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                }
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                String text = tfForSearch.getText();
//                if(text.trim().length() == 0){
//                    rowSorter.setRowFilter(null);
//                }
//                else{
//                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                }
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//            
//        });
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
    
        private String getColumnTitle(int index) {

        String title = null;

        switch (index) {
            case 0:
                title = "Address";
                break;
            case 1:
                title = "Type";
                break;
            case 2:
                title = "Domen";
                break;
            case 3:
                title = "Price";
                break;
            case 4:
                title = "Site Alive";
                break;
            case 5:
                title = "Main Topic";
                break;
        }

        return title;
    }
}
