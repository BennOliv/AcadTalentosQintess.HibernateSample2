package com.qintess.desafio0604.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.desafio0604.model.Cerveja;
import com.qintess.desafio0604.model.Cidade;
import com.qintess.desafio0604.model.Cliente;
import com.qintess.desafio0604.model.Estado;
import com.qintess.desafio0604.model.Estilo;
import com.qintess.desafio0604.model.Grupo;
import com.qintess.desafio0604.model.ItemVenda;
import com.qintess.desafio0604.model.Permissao;
import com.qintess.desafio0604.model.Usuario;
import com.qintess.desafio0604.model.Venda;

public class HibernateConfig {
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				
				Configuration config = new Configuration();
				
				Properties prop = new Properties();
				
				//prop do bd
				prop.put(Environment.DRIVER, "org.h2.Driver");
				prop.put(Environment.URL, "jdbc:h2:~/desafio0604");
				prop.put(Environment.USER, "sa");
				prop.put(Environment.PASS, "");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				config.setProperties(prop);
				
				config.addAnnotatedClass(Cerveja.class);
				config.addAnnotatedClass(Cidade.class);
				config.addAnnotatedClass(Cliente.class);
				config.addAnnotatedClass(Estado.class);
				config.addAnnotatedClass(Estilo.class);
				config.addAnnotatedClass(Grupo.class);
				config.addAnnotatedClass(ItemVenda.class);
				config.addAnnotatedClass(Permissao.class);
				config.addAnnotatedClass(Usuario.class);
				config.addAnnotatedClass(Venda.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
														.applySettings(config.getProperties())
														.build();
				
				sessionFactory = config.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
