interface Notifier {
    void send(String message);
}

interface Urgent {
}

class EmailSender implements Urgent {
}

class SmsSender {
}

public class Notification {

    public static void main(String[] args) {

        Notifier email = message ->
            System.out.println("Email: " + message);

        Notifier sms = message ->
            System.out.println("SMS: " + message);

        Notifier[] senders = {
            email,
            sms
        };

        String message = "Meeting at 10 AM";

        for (Notifier sender : senders) {
            sender.send(message);
        }

        System.out.println("Urgent email:");

        email.send(message);
        email.send(message);
    }
}