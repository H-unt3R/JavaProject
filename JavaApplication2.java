package javaapplication2;
import java.util.ArrayList;
public class JavaApplication2 {
    public static void main(String[] args) {
        ArrayList<SiteStore> sitesStore = new ArrayList<>();
        SiteStore kinoGo = new SiteStore();
        kinoGo.setAddress("Kinogo.net");
        kinoGo.setDomen(".net");
        kinoGo.setPrice(1500);
        kinoGo.setSiteAlive(900);
        kinoGo.addMainTopic("movies");
        kinoGo.addMainTopic("watching online");
        kinoGo.addMainTopic("Avengers");
        System.out.println(kinoGo);
        
        SiteStore vk = new SiteStore();
        vk.setAddress("vk.com");
        vk.setDomen(".com");
        vk.setPrice(90000);
        vk.setSiteAlive(1500);
        vk.addMainTopic("chatting");
        vk.addMainTopic("comunication");
        vk.addMainTopic("social network");
        vk.addMainTopic("find new friends");
        System.out.println(vk);
        
        SiteStore hackerRank = new SiteStore();
        hackerRank.setAddress("Hackerrank.com");
        hackerRank.setDomen(".com");
        hackerRank.setPrice(20000);
        hackerRank.setSiteAlive(4500);
        hackerRank.addMainTopic("Java Tasks");
        hackerRank.addMainTopic("solving tasks");
        hackerRank.addMainTopic("computer languages");
        System.out.println(hackerRank);
        
        sitesStore.add(kinoGo);
        sitesStore.add(vk);
        sitesStore.add(hackerRank);
        
        System.out.println("Accessing elements from an Array list");
        System.out.println("First site: " + sitesStore.get(0));
        System.out.println("Second site: " + sitesStore.get(1));
        System.out.println("Last site: " + sitesStore.get(sitesStore.size() - 1));
        
        System.out.println("Removing");
        sitesStore.remove(1);
        System.out.println("Size of an ArrayList = " + sitesStore.size());
        
      
    }
}
