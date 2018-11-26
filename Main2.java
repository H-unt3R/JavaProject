import model.Site;
import model.SiteType;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.lang.Double;

public class Main2 {
    public static void main(String [] args){
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
        }catch(Exception e){
            System.out.println(e);
    }
        for(int i = 0; i<site.size(); i++){
            System.out.println(site.get(i));
        }
        
        try{
            File file = new File("outputpets.db");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            
            for(int i = 0; i<site.size(); i++){
                pw.append("\n" + site.get(i).getAddress());
                pw.append("\n" + site.get(i).getSiteType());
                pw.append("\n" + site.get(i).getDomen());
                pw.append("\n" + site.get(i).getPrice());
                pw.append("\n" + site.get(i).getSiteAlive());
                pw.append("\n" + site.get(i).getMainTopic());
            }
            pw.close();
        }catch(Exception e){
            
        }
}
}
