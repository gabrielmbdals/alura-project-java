package br.com.casadocodigo.loja.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.controllers.dto.UsuarioDTO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;

@Component
public class UsuarioValidation implements Validator {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "password", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "repassword", "field.required");

		UsuarioDTO dto = (UsuarioDTO) target;

		if (dto.getPassword() != null && dto.getPassword().length() <= 5) {
			errors.rejectValue("repassword", "field.required.character.min.length",
					"A senha deve conter no mínimo 5 caracteres");
		}

		if (!dto.getPassword().equals(dto.getRepassword())) {
			errors.rejectValue("repassword", "field.required.notequals", "Campo deve ser igual ao Password");
		}

		try {
			Usuario user = usuarioDAO.loadUserByUsername(dto.getEmail());
			if(user != null) 
				errors.rejectValue("email", "field.required.hasExists");
		} catch (UsernameNotFoundException e) {

		}
	}

}
