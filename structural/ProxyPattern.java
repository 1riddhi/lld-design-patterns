// Proxy Pattern provides a substitute or placeholder for another object to control access to it.
// It is used to create a proxy class that can control access to the real object.


// =======================
// 1. Subject Interface
// =======================
interface Internet {
    void connectTo(String serverHost);
}

// =======================
// 2. Real Object
// =======================
class RealInternet implements Internet {

    @Override
    public void connectTo(String serverHost) {
        System.out.println("Connecting to " + serverHost);
    }
}

// =======================
// 3. Proxy Class
// =======================
import java.util.Arrays;
import java.util.List;

class ProxyInternet implements Internet {

    private RealInternet realInternet = new RealInternet();

    private static List<String> bannedSites =
            Arrays.asList("facebook.com", "instagram.com");

    @Override
    public void connectTo(String serverHost) {

        if (bannedSites.contains(serverHost.toLowerCase())) {
            System.out.println("Access Denied to " + serverHost);
        } else {
            realInternet.connectTo(serverHost);
        }
    }
}

// =======================
// 4. Client
// =======================
public class Main {

    public static void main(String[] args) {

        Internet internet = new ProxyInternet();

        internet.connectTo("google.com");
        internet.connectTo("facebook.com");
    }
}
