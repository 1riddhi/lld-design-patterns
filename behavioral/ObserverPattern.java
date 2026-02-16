//Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects 
// about any events that happen to the object they’re observing.

import java.util.*;

// Observer
interface Subscriber {
    void update(String videoTitle);
}

// Subject
interface Channel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers();
}

// Concrete Subject
class YouTubeChannel implements Channel {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestVideo;

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void uploadVideo(String title) {
        this.latestVideo = title;
        notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(latestVideo);
        }
    }
}

// Concrete Observer
class UserSubscriber implements Subscriber {

    private String name;

    public UserSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + 
            " received notification: New video - " + videoTitle);
    }
}

// Driver
public class ObserverPattern {
    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel();

        Subscriber user1 = new UserSubscriber("Riddhi");
        Subscriber user2 = new UserSubscriber("Rahul");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.uploadVideo("Observer Pattern Explained");
    }
}
