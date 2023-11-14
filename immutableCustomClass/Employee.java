package immutableCustomClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Employee {
    private final String employeeName;
    private final int employeeAge;
    private final Address address;
    private final List<String> phoneNumbers;
    private final Map<String, String> metaData;

    public Employee(String employeeName, int employeeAge, Address address, List<String> phoneNumbers, Map<String, String> metaData){
        this.employeeName=employeeName;
        this.employeeAge=employeeAge;
        this.address=address;
        this.phoneNumbers=phoneNumbers;
        // this.phoneNumbers=Collections.unmodifiableList(phoneNumbers);
        this.metaData=metaData;
        // this.metaData=Collections.unmodifiableMap(metaData);
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public int getEmployeeAgae() {
        return this.employeeAge;
    }

    public Address getAddress() throws CloneNotSupportedException{
        // return this.address;
        return (Address) this.address.clone();
    }

    public List<String> getPhoneNumbers() {
        // return this.phoneNumbers;
        return new ArrayList<>(this.phoneNumbers);
    }

    public Map<String, String> getMetadata() {
        // return this.metaData;
        return new HashMap<>(this.metaData);
    }
    
}
