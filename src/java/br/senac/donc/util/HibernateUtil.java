package br.senac.donc.util;

import br.senac.donc.model.Balancete;
import br.senac.donc.model.Vereador;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author danilosetubal
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static Session session;
    
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Vereador.class);
            cfg.addAnnotatedClass(Balancete.class);
            cfg.configure("/br/senac/donc/util/hibernate.cfg.xml");
             
            ServiceRegistryBuilder build = new ServiceRegistryBuilder().applySettings(cfg.getProperties());
            ServiceRegistry serviceRegistry = build.build();
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Erro ao criar configuração do Hibernate: " + ex);
           throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session abrirSessao() {
        session = sessionFactory.openSession();
        return session;
    }
}
