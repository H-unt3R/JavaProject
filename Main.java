import model.Site;
import model.SiteType;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
public static void main(String[] args){
    ArrayList<Site> site = new ArrayList<>();
    Site vk = new Site();
    vk.setAddress("VK.ru");
    SiteType socialNetwork = new SiteType("Social Network");
    vk.setSiteType(socialNetwork);
    vk.setDomen(".ru");
    vk.setPrice(60000);
    vk.setSiteAlive(1500);
    vk.addMainTopic("soc.network");
    vk.addMainTopic("chatting");
    vk.addMainTopic("friends");
    System.out.println(vk);
    
    Site youtube = new Site();
    youtube.setAddress("Youtube.com");
    SiteType video = new SiteType("Videos");
    youtube.setSiteType(video);
    youtube.setDomen(".com");
    youtube.setPrice(120000);
    youtube.setSiteAlive(6000);
    youtube.addMainTopic("Videos");
    youtube.addMainTopic("funny");
    youtube.addMainTopic("education");
    System.out.println(youtube);
    
    Site wiki = new Site();
    wiki.setAddress("wikipedia.org");
    SiteType enc = new SiteType("Encyclopedia");
    wiki.setSiteType(enc);
    wiki.setDomen(".org");
    wiki.setPrice(350000);
    wiki.setSiteAlive(7000);
    wiki.addMainTopic("library");
    wiki.addMainTopic("information");
    wiki.addMainTopic("encyclopedia");
    System.out.println(wiki);
    
    site.add(vk);
    site.add(youtube);
    site.add(wiki);
    
    System.out.println("First site: " + site.get(0));
    System.out.println("Second site: " + site.get(1));
    System.out.println("Third site: " + site.get(2));
    
    site.remove(2);
    System.out.println("sites size: " + site.size());
    
    for(int i = 0; i<site.size(); i++){
        System.out.println(site.get(i));
    }
    
    
}    
}
