package com.zaurtregulov.hibernate_test2;

import com.zaurtregulov.hibernate_test2.entity.Detail;
import com.zaurtregulov.hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
              session = factory.getCurrentSession();

            Employee employee = new Employee("Zaur", "Tregulov", "IT", 500);
            Detail detail = new Detail("Baku", "123456789", "zaurtregulov@gmail.com");
            employee.setEmpDetail(detail);
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            System.out.println(emp.getEmpDetail());

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
