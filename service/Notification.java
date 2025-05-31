package service;

public class Notification {
    private final MessageService service;

    public Notification(MessageService service) {
        this.service = service;
    }

    public void NotifyUser(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        service.sendMessage(message);
    }
}
