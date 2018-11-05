package javaapplication3; 
import java.time.LocalDate; 
import java.util.Scanner; 
import java.time.format.DateTimeFormatter; 
import java.util.ArrayList; 
import java.lang.Double; 
import java.io.*; 
public class Main2 { 
public static void main(String []args){ 
ArrayList <SiteStore> listSite = new ArrayList<SiteStore>(); 
DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 

try{ 
Scanner input = new Scanner(new File("./src/javaapplication3/bd.txt")); 
while(input.hasNextLine()){ 
String line; 
SiteStore site = new SiteStore(); 

line = input.nextLine(); 
try{ 
Scanner data = new Scanner(line); 
if(data.hasNext()){ 
String address = data.next().trim(); 
site.setAddress(address); 
} 
if(data.hasNext()){ 
String domen = data.next().trim(); 
site.setAddress(domen); 
} 
if(data.hasNextInt()){ 
int price = data.nextInt(); 
site.setPrice(price); 
} 
if(data.hasNext()){ 
LocalDate dateOfCreation = LocalDate.parse(data.next(), f); 
site.setdateOfCreation(dateOfCreation); 
} 
if(data.hasNextInt()){ 
int siteAlive = data.nextInt(); 
site.setSiteAlive(siteAlive); 
} 
if(data.hasNext()){ 
String signs = data.next(); 
for(int i = 0; i<signs.split(",").length; i++){ 
site.addMainTopic(signs.split(",")[i]); 
} 
} 
}catch(Exception c){ 
System.out.println(c); 
} 
listSite.add(site); 
} 
}catch(Exception e){ 
System.out.println(e); 
} 
for(int i = 0; i<listSite.size(); i++){ 
System.out.println(listSite.get(i)); 
} 
} 
}
