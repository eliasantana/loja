package com.loja.loja.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.loja.loja.model.Email;
import com.loja.loja.model.Produto;
 

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		RestTemplate template = new RestTemplate();
		URI uri;
		try {
			uri = new URI("http://localhost:8084/produto/listar");
			ResponseEntity<Produto[]> response = template.getForEntity(uri, Produto[].class);
			Produto[] produtos = response.getBody();
			List<Produto> produtoList = Arrays.asList(produtos);
			model.addAttribute("produtos", produtoList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "index";
	}
	
	@GetMapping("/form")
	public String emailForm(Model model, RedirectAttributes ra) {
		
		return "emailform";
	}
	
	@PostMapping("/send")
	@ResponseBody
	public RedirectView send(Model model, Email emailForm, RedirectAttributes ra) {
		
		String uri="/send/{de}/{para}/{assunto}/{texto}";
		String url="http://localhost:8081";
		Email email = new Email();
		String msg="";
		try {
		
			 email = WebClient
						  .create(url)
						  .get()
						  .uri(uri,emailForm.getDe(),emailForm.getPara(),emailForm.getAssunto(),emailForm.getTexto())
						  .retrieve()
						  .bodyToMono(Email.class).block();
			
			msg="E-mail enviado com sucesso, para "+email.getPara() ;
		} catch (Exception e) {
			e.printStackTrace();
			msg="Erro ao tentar enviar e-mail para " + emailForm.getPara();
		}
		
		ra.addFlashAttribute("msg",msg);	
		return new RedirectView("/form");
	}
	
	
	
}
