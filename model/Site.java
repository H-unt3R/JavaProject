package model;
import java.util.ArrayList;
public class Site {
    private String address;
    private SiteType siteType;
    private String domen;
    private int siteAlive;
    private int price;
    private ArrayList<String> mainTopic = new ArrayList<>();
    public Site(String address, SiteType siteType, String domen, int siteAlive, int price){
        this.address = address;
        this.siteType = siteType;
        this.domen = domen;
        this.siteAlive = siteAlive;
        this.price = price;
    }
    public Site(){
        
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setSiteType(SiteType siteType){
        this.siteType = siteType;
    }
    public SiteType getSiteType(){
        return siteType;
    }
    public void setDomen(String domen){
        this.domen = domen;
    }
    public String getDomen(){
        return domen;
    }
    public void setSiteAlive(int siteAlive){
        this.siteAlive = siteAlive;
    }
    public int getSiteAlive(){
        return siteAlive;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    public ArrayList<String> getMainTopic(){
        return mainTopic;
    }
    public void addMainTopic(String mainTopic){
        this.mainTopic.add(mainTopic);
    }
        public String toString(){
        String sSigns = "";
        for(String sign : this.mainTopic){
            sSigns = sSigns + sign + ",";
        }

        return "Address:" + this.address
        +"\nSite Type:" + this.siteType.getTypeName()
        +"\nSite alive:" + this.siteAlive
        +"\ndomen:" + this.domen
        +"\nprice:" + this.price
        +"\nMain topic:" + sSigns;
    }

}
