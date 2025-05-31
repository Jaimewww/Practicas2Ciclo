package service;

public class ConsoleService implements MessageService {
    @Override
    public void sendMessage(String message) throws IllegalArgumentException {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        System.out.println(message);
    }
}
