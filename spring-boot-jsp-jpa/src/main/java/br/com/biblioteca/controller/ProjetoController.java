package br.com.biblioteca.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.model.MembroData;
import br.com.biblioteca.service.PessoaService;
import br.com.biblioteca.service.ProjetoService;

@Controller
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@Autowired
	private PessoaService pessoaService;

	@InitBinder("projeto")
	public void customizeBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatter.setLenient(false);
		binder.registerCustomEditor(Date.class, "dataInicio", new CustomDateEditor(dateFormatter, true));
		binder.registerCustomEditor(Date.class, "dataFim", new CustomDateEditor(dateFormatter, true));
		binder.registerCustomEditor(Date.class, "dataPrevisaoFim", new CustomDateEditor(dateFormatter, true));
		binder.registerCustomEditor(Pessoa.class, "gerente", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (text.equals("") || text.equals(null)) {
					setValue(null);
				} else {
					Long id = Long.parseLong(text);
					Pessoa pessoa = pessoaService.getOne(id);
					setValue(pessoa);
				}
			}
		});
	}

	@RequestMapping({ "/", "/index" })
	String home(Model model) {
		return "redirect:/projetos/listar";
	}

	@RequestMapping("/projetos/listar")
	String list(Model model) {
		model.addAttribute("projetos", projetoService.findAll());
		return "listar-projetos";
	}

	@RequestMapping("/projetos/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) throws ResourceNotFoundException {
		projetoService.delete(projetoService.getOne(id));
		return "redirect:/index";
	}

	@RequestMapping(value = "/projetos/salvar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("projeto") Projeto projeto) {
		projetoService.save(projeto);
		return "redirect:/projetos/listar";
	}

	@RequestMapping("/projetos/criar")
	String criar(Model model) {
		model.addAttribute("pessoas", pessoaService.findAll());
		model.addAttribute("projeto", new Projeto());
		model.addAttribute("title", "Criação de Projeto");
		return "form-projeto";
	}

	@RequestMapping("/projetos/editar/{id}")
	String editar(@PathVariable("id") Long id, Model model) throws ResourceNotFoundException {
		Projeto p = projetoService.getOne(id);
		model.addAttribute("pessoas", pessoaService.findAll());
		model.addAttribute("projeto", p);
		model.addAttribute("title", "Edição de Projeto");
		return "form-projeto";
	}

	@RequestMapping(value = "/projetos/{idprojeto}/membros", method = RequestMethod.POST)
	@ResponseBody
	String adicionarMembro(@PathVariable("idprojeto") Long idprojeto, @RequestBody MembroData membro)
			throws ResourceNotFoundException {
		Projeto projeto = projetoService.getOne(idprojeto);
		Pessoa pessoa = pessoaService.getOne(membro.getNome());
		if (pessoa.isFuncionario()) {
			projeto.getMembros().add(pessoa);
			projetoService.save(projeto);
			return "O membro " + membro.getNome() + " foi adicionado ao projeto " + projeto.getNome() + " com sucesso";
		} else {
			return "O membro " + membro.getNome() + " não pode ser adicionado ao projeto " + projeto.getNome()
					+ " pois não possuí atribuição de funcionário";
		}
	}

	@RequestMapping("/projetos/{id}")
	@ResponseBody
	Projeto getProjeto(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return projetoService.getOne(id);
	}

	@RequestMapping("/projetos")
	@ResponseBody
	List<Projeto> getProjeto() throws ResourceNotFoundException {
		return projetoService.findAll();
	}


}
