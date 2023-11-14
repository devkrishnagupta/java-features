package immutableCustomClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmutableClassDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Street 1", "City 1");
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("12345");
        phoneNumbers.add("23456");
        Map<String, String> metaData = new HashMap<>();
        metaData.put("hobby", "Watching Movies");

        Employee employee = new Employee("Dev", 28, address, phoneNumbers, metaData);

        // Update details
        employee.getPhoneNumbers().add("345123");
        employee.getMetadata().put("skill", "Java");
        employee.getMetadata().put("designation", "HR");

        System.out.println(employee.getPhoneNumbers());
        System.out.println(employee.getMetadata());

        employee.getAddress().setStreet("s3");
        employee.getAddress().setCity("Delhi");

        System.out.println(employee.getAddress());
    }
}
