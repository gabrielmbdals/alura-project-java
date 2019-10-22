package br.com.casadocodigo.loja.controllers;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.controllers.dto.UsuarioDTO;
import br.com.casadocodigo.loja.service.UsuarioService;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping(path = "/usuarios")
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 5113012734419061651L;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioValidation userValidation;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidation);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView form(HttpServletRequest request, @Valid UsuarioDTO usuario, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return cadastrar();
		}
		usuarioService.save(usuario);

		redirectAttributes.addFlashAttribute("message", "Usuário cadastrado com sucesso");

		return new ModelAndView("redirect:/usuarios");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/form")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("/usuarios/form");
		modelAndView.addObject("message", "");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView modelAndView = new ModelAndView("/usuarios/lista");
		modelAndView.addObject("usuarios", usuarioService.findAll());
		return modelAndView;
	}

	@RequestMapping(path = "/rolesForm")
	public ModelAndView rolesForm(String email) {
		ModelAndView modelAndView = new ModelAndView("/usuarios/roleform");
		UsuarioDTO usuarioDTO = usuarioService.findByEmail(email);
		modelAndView.addObject("usuario", usuarioDTO);
		modelAndView.addObject("allRoles", usuarioService.findAllRoles());
		modelAndView.addObject("roles", usuarioDTO.getRoles());
		return modelAndView;
	}

	@RequestMapping(path = "/adicionarRole", method = RequestMethod.POST)
	public ModelAndView adicionarRole(UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		try {
			usuarioService.addRolesToUser(usuarioDTO);
			redirectAttributes.addFlashAttribute("message", "Permissões alteradas com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Error ao salvar as permissões!");
		}
		return modelAndView;
	}
}
