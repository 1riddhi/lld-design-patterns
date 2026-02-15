//Bridge pattern decouples an abstraction from its implementation
//  so that the two can vary independently.

//remotedevice -->bridge--> device
// ================= IMPLEMENTOR =================
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}

// ================= CONCRETE IMPLEMENTATIONS =================
class TV implements Device {

    public void turnOn() {
        System.out.println("TV is ON");
    }

    public void turnOff() {
        System.out.println("TV is OFF");
    }

    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }
}

class Radio implements Device {

    public void turnOn() {
        System.out.println("Radio is ON");
    }

    public void turnOff() {
        System.out.println("Radio is OFF");
    }

    public void setVolume(int volume) {
        System.out.println("Radio volume set to " + volume);
    }
}

// ================= ABSTRACTION =================
abstract class RemoteControl {

    protected Device device;

    protected RemoteControl(Device device) {
        this.device = device; // <-- Bridge connection
    }

    abstract void powerOn();
    abstract void powerOff();
}

// ================= REFINED ABSTRACTIONS =================
class BasicRemote extends RemoteControl {

    public BasicRemote(Device device) {
        super(device);
    }

    void powerOn() {
        device.turnOn();
    }

    void powerOff() {
        device.turnOff();
    }
}

class AdvancedRemote extends RemoteControl {

    public AdvancedRemote(Device device) {
        super(device);
    }

    void powerOn() {
        device.turnOn();
    }

    void powerOff() {
        device.turnOff();
    }

    void mute() {
        device.setVolume(0);
        System.out.println("Device muted");
    }
}

// ================= CLIENT =================
public class BridgePattern{

    public static void main(String[] args) {

        // Basic Remote controlling TV
        Device tv = new TV();
        RemoteControl basicRemote = new BasicRemote(tv);
        basicRemote.powerOn();
        basicRemote.powerOff();

        System.out.println();

        // Advanced Remote controlling Radio
        Device radio = new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);
        advancedRemote.powerOn();
        advancedRemote.mute();
        advancedRemote.powerOff();
    }
}
