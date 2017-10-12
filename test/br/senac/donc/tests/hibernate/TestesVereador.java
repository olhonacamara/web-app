package br.senac.donc.tests.hibernate;

import br.senac.donc.dao.VereadorDAO;
import br.senac.donc.dao.VereadorDAOImpl;
import br.senac.donc.model.Vereador;
import br.senac.donc.util.HibernateUtil;
import org.hibernate.Session;

public class TestesVereador {
    
        private Session session;
        private VereadorDAO vereadorDao;

        public TestesVereador() {
            session = HibernateUtil.abrirSessao();
            vereadorDao = new VereadorDAOImpl();       
        }
        
         public void salvarVereador(Vereador vereador) {
            System.out.println("Salvar...");
            vereadorDao.salvarOuAlterar(vereador, session);            
        }
    
}
