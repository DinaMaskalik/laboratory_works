package bsuir.util;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private List<String> message = new ArrayList<>();

    public Message() {
        int count = (int) (Math.random() * 15 + 1);
        char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            int quantity = (int) (Math.random() * 100);
            for (int j = 0; j < quantity; j++) {
                sb.append(alphabet[(int) (Math.random()*alphabet.length)]);
            }
            message.add(sb.toString());
        }

    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
