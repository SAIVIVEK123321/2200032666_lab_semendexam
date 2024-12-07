package com.klef.jfsd.exam.vehical;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Device.class)
            .addAnnotatedClass(Smartphone.class)
            .addAnnotatedClass(Tablet.class)
            .buildSessionFactory();

        // Create a session
        Session session = factory.getCurrentSession();

        try {
            // Create Device, Smartphone, and Tablet objects
            Device device = new Device();
            device.setBrand("Generic Brand");
            device.setModel("D100");
            device.setPrice(1000);

            Smartphone smartphone = new Smartphone();
            smartphone.setBrand("Samsung");
            smartphone.setModel("Galaxy S21");
            smartphone.setPrice(1200);
            smartphone.setOperatingSystem("Android");
            smartphone.setCameraResolution(108.0);

            Tablet tablet = new Tablet();
            tablet.setBrand("Apple");
            tablet.setModel("iPad Pro");
            tablet.setPrice(900);
            tablet.setScreenSize(12.9);
            tablet.setBatteryLife(10);

            // Start a transaction
            session.beginTransaction();

            // Save the objects
            session.save(device);
            session.save(smartphone);
            session.save(tablet);

            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
