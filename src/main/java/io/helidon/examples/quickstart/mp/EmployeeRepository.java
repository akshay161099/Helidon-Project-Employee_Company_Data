package io.helidon.examples.quickstart.mp;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class EmployeeRepository {

    static Map<Integer,Company> data = new ConcurrentHashMap<>();

    static {
        Company first = Company.of(1,"abc",1992);
        Company second = Company.of(2,"def",1994);
        Company third = Company.of(3,"jhi",1997);
        Company fourth = Company.of(4,"klm",2003);
        Company fifth = Company.of(5,"mno",2004);
        Company sixth = Company.of(6,"qrs",2009);
        Company seventh = Company.of(7,"akshay",2012);
        Company eighth= Company.of(8,"manas",2015);
        Company ninth = Company.of(9,"kumar",2019);
        data.put(first.getId(),first);
        data.put(second.getId(),second);
        data.put(third.getId(),third);
        data.put(fourth.getId(),fourth);
        data.put(fifth.getId(),fifth);
        data.put(sixth.getId(),sixth);
        data.put(seventh.getId(),seventh);
        data.put(eighth.getId(),eighth);
        data.put(ninth.getId(),ninth);
    }

    public List<Company> all() {
        return new ArrayList<>(data.values());
    }

    public Company getById(int id) {
        return data.get(id);
    }

    public Company save(Company company) {
        data.put(company.getId(),company);
        return company;
    }

    public void deleteById(int id) {
        data.remove(id);
    }
}