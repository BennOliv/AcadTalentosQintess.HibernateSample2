package com.qintess.desafio0604.controller;

import com.qintess.desafio0604.dao.DaoGenerico;
import com.qintess.desafio0604.model.Estado;

public class Principal 
{
    public static void main( String[] args ){
    	Estado estado = new Estado();
    	Estado estadoX = new Estado();
    	Estado estadoY = new Estado();
    	
    	estadoX.setNome("São Paulo");
    	estadoX.setSigla("SP");
    	
    	estadoY.setNome("Minas Gerais");
    	estadoY.setSigla("MG");
    	
    	
    	DaoGenerico<Estado> daoEstado = new DaoGenerico<>();
    	
    	daoEstado.salva(estadoX);
    	daoEstado.salva(estadoY);
    	
    	estado = daoEstado.buscaPorId(Estado.class, 1);
    	
    	System.out.println("Após Buscar: " + estado);

    	estado.setNome("Pernambuco");
    	estado.setSigla("PE");
    	
    	daoEstado.atualiza(estado);
    	
    	estado = daoEstado.buscaPorId(Estado.class, 1);
    	
    	System.out.println("Apos Update: " + estado);
    	
    	daoEstado.deleta(estado);
    	
    	System.out.println("Lista após Delete:\n" + daoEstado.buscaTodos(Estado.class));
    }
}
