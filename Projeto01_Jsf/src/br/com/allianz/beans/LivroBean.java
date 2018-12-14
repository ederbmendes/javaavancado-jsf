package br.com.allianz.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.allianz.dao.LivroDao;
import br.com.allianz.models.Livro;

@ManagedBean(name = "beanLivro")
@RequestScoped
public class LivroBean  {

	private Livro livro;
	
	public LivroBean() {
		
		if(livro == null) {
			livro = new Livro();
		}
		
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	//metodo de acao action
	public String incluirLivro() {
		
		try {
			
			new LivroDao().IncluirLivro(livro);
			return "sucesso";
			
		}catch(Exception e) {
			return "erro";
		}
		
	}
	
	//lista de livros
	public List<Livro> getListarLivros() throws Exception{
		
		return new LivroDao().listarLivros();
	}
}
