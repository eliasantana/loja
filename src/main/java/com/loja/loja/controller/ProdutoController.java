package com.loja.loja.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.result.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriBuilder;
import org.thymeleaf.exceptions.TemplateAssertionException;

import com.google.gson.Gson;
import com.itextpdf.kernel.crypto.securityhandler.PubKeySecurityHandler;
import com.loja.loja.model.Produto;
import com.loja.loja.webservices.EndPoints;

import io.micrometer.prometheus.PrometheusDurationNamingConvention;





@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	RestTemplate restTemplate;
	
		
	@RequestMapping("/listar")
    public String listartProdutos(String json, Model model) {    	
    	RestTemplate template = new RestTemplate();
    	URI uri;
    	Produto produto = new Produto(); 
    	try {
    		uri = new URI(EndPoints.getPRODUTO_LISTAR());
			ResponseEntity<Produto[]> response = template.getForEntity(uri, Produto[].class);
			Produto[] produtos = response.getBody();
			List<Produto> produtoAsList = Arrays.asList(produtos);
			model.addAttribute("produtos",produtoAsList);
			model.addAttribute("titulo","Produtos Cadastrados");
		} catch (URISyntaxException e) {			
			e.printStackTrace();
		}    	
    	return "index";
	   }
		
	@RequestMapping("/listar/{id}")
    public String listartProdutos2(String json, @PathVariable Long id, Model model) {    	
    	RestTemplate template = new RestTemplate();
    	URI uri;
    	Produto produto = new Produto(); 
    	try {
			uri = new URI("http://localhost:8084/produto/listar/"+id);
			produto = template.getForObject(uri, Produto.class);			
			model.addAttribute("produto",produto);
		} catch (URISyntaxException e) {			
			e.printStackTrace();
		}   
    	return "index";
	   }

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes ra) {
		RestTemplate template = new RestTemplate();
    	URI uri;   	 
    	try {
    		uri = new URI(EndPoints.getPRODUTO_DELETE()+id);
			template.delete(uri);
			ra.addFlashAttribute("msg", "Produto excluído com sucesso!");			
		} catch (URISyntaxException e) {			
			e.printStackTrace();
		}
		return "redirect:/produto/listar";	
	}
	
	@GetMapping("/alterar/{id}")
	public String alterar(@PathVariable Long id, Model model) {
		RestTemplate template = new RestTemplate();
    	URI uri;
    	Produto produto = new Produto(); 
    	try {
    		uri = new URI(EndPoints.getPRODUTO_LISTAR().concat("/")+id);
			produto = template.getForObject(uri, Produto.class);			
			model.addAttribute("produto",produto);
			model.addAttribute("titulo","Alterar Produto");
		} catch (URISyntaxException e) {			
			e.printStackTrace();
		}
		return "alterar-produto"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Produto p) {
		RestTemplate template = new RestTemplate();		
		URI uri;
		try {
			//uri = new URI("http://localhost:8084/produto/adicionar");
			uri = new URI(EndPoints.getPRODUTO_ADICIONAR());
			Produto postForObject = template.postForObject(uri, p, Produto.class);			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}		
		return "redirect:/produto/listar";
	}
	
	@GetMapping("/adicionar")
	public String adicionar(Model model) {
		
    	Produto produto = new Produto(); 
    	try {
			model.addAttribute("produto",produto);
			model.addAttribute("titulo","Novo Produto");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return "alterar-produto"; 
	}
}
