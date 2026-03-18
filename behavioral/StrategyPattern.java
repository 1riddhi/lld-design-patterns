// Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class,
//  and make their objects interchangeable.

// Strategy means: Same task, different ways, and we can choose the way at runtime.

// There are 3 parts:

// Strategy Interface
// Concrete Strategies
// Context has a reference to the strategy (uses the strategy)

// Strategy Interface
interface RouteStrategy {
    void buildRoute(String from, String to);
}

// Concrete Strategies
class CarRouteStrategy implements RouteStrategy {
    public void buildRoute(String from, String to) {
        System.out.println("Building route for CAR with traffic analysis.");
    }
}

class WalkingRouteStrategy implements RouteStrategy {
    public void buildRoute(String from, String to) {
        System.out.println("Building route for WALKING using pedestrian paths.");
    }
}

class BikeRouteStrategy implements RouteStrategy {
    public void buildRoute(String from, String to) {
        System.out.println("Building route for BIKE using cycle tracks.");
    }
}

// Context
class GoogleMap {

    private RouteStrategy routeStrategy;

    public GoogleMap(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void buildRoute(String from, String to) {
        //estimated time returned by the strategy
        routeStrategy.buildRoute(from, to);
    }
}

// Main
public class StrategyPattern {
    public static void main(String[] args) {

        GoogleMap map = new GoogleMap(new CarRouteStrategy());
        map.buildRoute("Home", "Office");

        map.setRouteStrategy(new WalkingRouteStrategy());
        map.buildRoute("Home", "Office");
    }
}
