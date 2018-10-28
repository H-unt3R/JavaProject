package javaapplication2;
import java.util.ArrayList;
public class SiteStore {
    private String address;
    private String domen;
    private int siteAlive;
    private int price;
    private ArrayList<String> mainTopic = new ArrayList<>();
 
    public SiteStore(String address, String domen, int price, int siteAlive){
        this.address = address;
        this.domen = domen;
        this.price = price;
        this.siteAlive = siteAlive;
    } 
    public SiteStore(){
        
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setDomen(String domen){
        this.domen = domen;
    }
    public String getDomen(){
        return this.domen;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public void setSiteAlive(int siteAlive){
        this.siteAlive = siteAlive;
    }
    public int getSiteAlive(){
        return this.siteAlive;
    }
    public ArrayList<String> getMainTopic(){
        return mainTopic;
    }
    public void addMainTopic(String mainTopic){
        this.mainTopic.add(mainTopic);
    }
    public String toString(){
        String signs = "";
        for(String sign : this.mainTopic){
            signs = signs + sign + ",";
        }
        return "Address:" + this.address
                +"\nDomen:" + this.domen
                +"\nSite is Alive for:" + this.siteAlive+"days"
                +"\nPirce:" + this.price + "$"
                +"\nMain Topics:" + signs;
    }
}
