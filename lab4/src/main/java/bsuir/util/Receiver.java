package bsuir.util;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class Receiver {

    @JmsListener(destination = "world", containerFactory = "myFactory")
    public void receiveMessage(Message message) throws IOException {
        System.out.println("Received \n<" + message + ">");

        List<String> info = message.getMessage();

        File file = new File("D:\\БГУИР\\3 курс\\6 семестр\\RIS\\ЛР4\\lab4\\src\\main\\resources\\lab4.txt");
        FileWriter resultWriter = new FileWriter(file, false);

        Collections.sort(info);

        System.out.println();
        System.out.println(info);

        resultWriter.write(info.toString());
        resultWriter.write("\n");
        resultWriter.flush();

        resultWriter.close();

    }
}