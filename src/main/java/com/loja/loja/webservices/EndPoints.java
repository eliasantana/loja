package com.loja.loja.webservices;

public class EndPoints {
	private static String URL_BASE="http://localhost:8084/";
	private static String PRODUTO_ALTERAR=URL_BASE.concat("produto/alterar/");
	private static String PRODUTO_LISTAR=URL_BASE.concat("produto/listar");
	private static String PRODUTO_DELETE=URL_BASE.concat("produto/delete/");
	private static String PRODUTO_ADICIONAR=URL_BASE.concat("/produto/adicionar");
	
	public EndPoints() {
	
	}
	
	public static String getPRODUTO_ALTERAR() {
		return PRODUTO_ALTERAR;
	}
	
	public static String getPRODUTO_LISTAR() {
		return PRODUTO_LISTAR;
	}
	
	public static String getPRODUTO_ADICIONAR() {
		return PRODUTO_ADICIONAR;
	}
	
	public static String getPRODUTO_DELETE() {
		return PRODUTO_DELETE;
	}
	
}
