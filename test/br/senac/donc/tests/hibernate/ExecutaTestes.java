package br.senac.donc.tests.hibernate;

import br.senac.donc.dao.VereadorDAO;
import br.senac.donc.dao.VereadorDAOImpl;
import br.senac.donc.model.Vereador;
import br.senac.donc.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author danilosetubal
 */
public class ExecutaTestes {
      
        public static void main(String[] args) { 
            
            TestesVereador testVereador;
            testVereador = new TestesVereador();
            
            Vereador v1 = new Vereador("Danilo Gentil Setúbal");
            
           testVereador.salvarVereador(v1);
            
        }
        
         
}
