// нужно, чтобы получить wsdl описание и через него
// дотянуться до самого веб-сервиса

import service.MyWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:1986/wss/hello?wsdl");

        QName qname = new QName("http://service/", "WebServiceImplService");
        QName qport = new QName("http://service/", "WebServiceImplPort");

        Service service = Service.create(url, qname);

        MyWebService hello = service.getPort(qport, MyWebService.class);

        System.out.println(
                "[1] - Найти по улице.\n" +
                        "[2] - Найти по строению\n");
        Scanner in = new Scanner(System.in);
        int choose = in.nextInt();

        switch (choose) {
            case 1:
                System.out.println("Введите наименование улицы: ");
                in = new Scanner(System.in);
                final String tour = hello.getStreet(in.nextLine());
                if (tour == null) {
                    System.out.println("Ничего не найдено!");
                } else {
                    System.out.println(tour);
                }
                break;
            case 2:
                System.out.println("Введите строение: ");
                in = new Scanner(System.in);
                final List<String> cost = hello.getStructure(in.nextLine());
                if (cost.isEmpty()) {
                    System.out.println("Ничего не найдено!");
                } else {
                    System.out.println(cost);
                }
                break;

        }
    }
}