interface Switchable {

    void on();

    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {

    public void on() {
        System.out.println("Fan ON");
    }

    public void off() {
        System.out.println("Fan OFF");
    }
}

class Light implements Switchable {

    public void on() {
        System.out.println("Light ON");
    }

    public void off() {
        System.out.println("Light OFF");
    }
}

interface SwitchRule {
    boolean canSwitch(String device, int hour);
}

public class RemoteControl {

    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        for (Switchable device : devices) {
            device.toggle();
        }

        SwitchRule rule = new SwitchRule() {
            public boolean canSwitch(String device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        System.out.println(rule.canSwitch("Fan", 10));

        SwitchRule rule2 = (device, hour) -> hour >= 6 && hour <= 22;

        System.out.println(rule2.canSwitch("Light", 23));
    }
}