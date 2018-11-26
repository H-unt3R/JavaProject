package model;
import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.*;
public class SiteTableModel extends AbstractTableModel{
    String[] columnNames;
    Object[][] data;
    
    public SiteTableModel(){
        columnNames = new String[]{"Address", "Type", "Domen", "Price", "Site Alive", "Main Topic"};
        ArrayList<Site> site = new ArrayList<>();
        try{
            Scanner input = new Scanner(new File("C:\\Users\\Абзал\\Documents\\NetBeansProjects\\CitiesStore\\src\\sitedatabase.db"));
            
            while(input.hasNextLine()){
                String line;
                Site s1te = new Site();
                
                line = input.nextLine();
                
                try{
                    Scanner data = new Scanner(line);
                    if(data.hasNext()){
                        String address = data.next().trim();
                        s1te.setAddress(address);
                    }
                    if(data.hasNext()){
                     SiteType siteType = new SiteType();
                     siteType.setTypeName(data.next().trim());
                     s1te.setSiteType(siteType);
                 }
                 if(data.hasNext()){
                     String domen = data.next().trim();
                     s1te.setDomen(domen);
                 }
                 if(data.hasNextInt()){
                     int price = data.nextInt();
                     s1te.setPrice(price);
                 }
                 if(data.hasNextInt()){
                     int siteAlive = data.nextInt();
                     s1te.setSiteAlive(siteAlive);
                 }
                 if(data.hasNext()){
                     String signs = data.next();
                     for(int i = 0; i<signs.split(",").length; i++){
                     s1te.addMainTopic(signs.split(",")[i]);
                     }
                 }
                }catch(Exception e){
                    System.out.println(e);
                }
                
                site.add(s1te);
            }
        }catch(IOException e){
            System.out.println(e);
        }
    data = new Object[site.size()][7];
    
    for(int i = 0; i < site.size(); i++){
        data[i][0] = site.get(i).getAddress();
        data[i][1] = site.get(i).getSiteType();
        data[i][2] = site.get(i).getDomen();
        data[i][3] = site.get(i).getPrice();
        data[i][4] = site.get(i).getSiteAlive();
        data[i][5] = site.get(i).getMainTopic();
    }
    }
    @Override
    public int getRowCount(){
        return data.length;
    }
    public String getColumnName(int col){
        return columnNames[col];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        return data[rowIndex][columnIndex];
    }
    public void setValueAt(Object value, int row, int col){
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
