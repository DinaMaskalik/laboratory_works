package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface MyWebService {

    @WebMethod
    String getStreet(String street);

    @WebMethod
    List<String> getStructure(String structure);

}