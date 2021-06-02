package service;

import javax.jws.WebService;
import java.util.*;

@WebService(endpointInterface = "service.WebServiceImpl")
public class WebServiceImpl implements MyWebService {

    private static Map<String, String> table = new HashMap<>();

    static {
        table.put("Гагарина", "дом 45");
        table.put("Горобца", "дом 24");
        table.put("Медицинская ", "дом 45");
        table.put("Ботаническая", "дом 45");
        table.put("Незавасимости", "дом 23");
        table.put("Гикало", "дом 1");
        table.put("Держинского", "дом 6");
    }
    public String getStreet(String street) {

        return table.get(street);
    }

    public List<String> getStructure(String str) {

        List<String> tourList = new ArrayList<>();

        final Set<String> keySet = table.keySet();

        keySet.forEach(s -> {
            if(table.get(s).equals(str)){
                tourList.add(s);
            }
        });

        return tourList;
    }
}