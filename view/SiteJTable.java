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
public class SiteJTable extends JFrame{
    private SiteTableModel site;
    private JTable table;
    
    public SiteJTable(){
        super("My sites store");
        
        site = new SiteTableModel();
        table = new JTable(site);
        
        final JButton addButton = new JButton("Add site");
        
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String[] s1te = {"", "", "", "", "", ""};
                //site.addRow(s1te);
            }
        });
        final JButton removeButton = new JButton("Remove selected site");
        removeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //site.removeRow(table.getSelectedRow());
            }
        });
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    JTable target = (JTable) e.getSource();
                    final int row = target.getSelectedRow();
                    int column  = target.getSelectedColumn();
                    
                    final JInternalFrame editorPopup = new JInternalFrame(
                    "Edit Record", true, true, true, true);
                    
                    GridLayout gridLayout = new GridLayout(0,2);
                    gridLayout.setHgap(5);
                    gridLayout.setVgap(5);
                    editorPopup.setLayout(gridLayout);
                    editorPopup.add(new JLabel(getColumnTitle(0)));
                    final JTextField address = new JTextField(20);
                    address.setText(target.getValueAt(row, 0).toString());
                    editorPopup.add(address);

                    editorPopup.add(new JLabel(getColumnTitle(1)));
                    final JTextField type = new JTextField(20);
                    type.setText(target.getValueAt(row, 1).toString());
                    editorPopup.add(type);

                    editorPopup.add(new JLabel(getColumnTitle(2)));
                    final JTextField domen = new JTextField(20);
                    domen.setText(target.getValueAt(row, 2).toString());
                    editorPopup.add(domen);

                    editorPopup.add(new JLabel(getColumnTitle(3)));
                    final JTextField price = new JTextField(20);
                    price.setText(target.getValueAt(row, 3).toString());
                    editorPopup.add(price);

                    editorPopup.add(new JLabel(getColumnTitle(4)));
                    final JTextField siteAlive = new JTextField(20);
                    siteAlive.setText(target.getValueAt(row, 4).toString());
                    editorPopup.add(siteAlive);

                    editorPopup.add(new JLabel(getColumnTitle(6)));
                    final JTextField mainTopic = new JTextField(20);
                    mainTopic.setText(target.getValueAt(row, 6).toString());
                    editorPopup.add(mainTopic);

                    JButton okButton = new JButton("Ok");
                    okButton.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {

                            table.getModel().setValueAt(address.getText(), row, 0);
                            table.getModel().setValueAt(type.getText(), row, 1);
                            table.getModel().setValueAt(domen.getText(), row, 2);
                            table.getModel().setValueAt(price.getText(), row, 3);
                            table.getModel().setValueAt(siteAlive.getText(), row, 4);
                            table.getModel().setValueAt(mainTopic.getText(), row, 6);

                            JOptionPane.showMessageDialog(((JButton) e
                                    .getSource()).getParent(), "Record Saved!");
                    
                    
                }
                    });
            
                    editorPopup.add(okButton);
                    JButton cancelButton = new JButton("Cancel");
                    cancelButton.addMouseListener(new MouseAdapter(){
                       public void mouseClicked(MouseEvent e){
                           editorPopup.hide();
                       } 
                    });
                    editorPopup.add(cancelButton);
                    editorPopup.pack();
                    target.add(editorPopup);
                    editorPopup.setVisible(true);
                    editorPopup.setClosable(true);
                }
            }
        });
        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table.setFillsViewportHeight(true);

        JPanel inputPanel = new JPanel();
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        Container container = getContentPane();
        container.add(new JScrollPane(table), BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.NORTH);

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