package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import junit.framework.Assert;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.modelo.Projeto;

import com.thoughtworks.xstream.XStream;

public class ProjetoTest {
	
private HttpServer server;
	
	@Before
	public void before(){
		this.server = Server.inicializarServer();
	}
	
	@After
	public void after(){
		this.server.stop();
	}

	@Test
	public void testQueAConexaoComServidorFunciona(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos").request().get(String.class);
		Assert.assertTrue(conteudo.contains("Minha loja"));
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
	    Assert.assertEquals("Minha loja", projeto.getDescricao());
	}
}
