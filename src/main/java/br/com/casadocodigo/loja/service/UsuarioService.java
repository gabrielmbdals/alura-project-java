package br.com.casadocodigo.loja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.casadocodigo.loja.controllers.dto.Role;
import br.com.casadocodigo.loja.controllers.dto.UsuarioDTO;
import br.com.casadocodigo.loja.controllers.dto.UsuarioSimplesDTO;
import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.infra.GeraSenha;
import br.com.casadocodigo.loja.models.Usuario;

@Service
public class UsuarioService {

	private static final String USUARIO_SALVO_COM_SUCESSO = "Usuário salvo com sucesso";
	public static final String EMAIL_JA_CADASTRADO_NA_BASE_DE_DADOS = "Email já cadastrado na base de dados!";

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private RoleDAO roleDAO;

	public String save(UsuarioDTO dto) {

		if (isValid(dto)) {
			try {
				Usuario usuario = usuarioDAO.loadUserByUsername(dto.getEmail());
				if (usuario != null)
					return EMAIL_JA_CADASTRADO_NA_BASE_DE_DADOS;
			} catch (UsernameNotFoundException e) {
				Usuario user = new Usuario();
				user.setEmail(dto.getEmail());
				user.setNome(dto.getNome());
				user.setSenha(GeraSenha.geradorDeSenha(dto.getPassword()));
				usuarioDAO.gravar(user);
			}
		}

		return USUARIO_SALVO_COM_SUCESSO;
	}

	private boolean isValid(UsuarioDTO usuario) {

		if (usuario == null || null == usuario.getEmail() || null == usuario.getNome() || usuario.getPassword() == null
				|| usuario.getRepassword() == null)
			return false;

		if (!usuario.getPassword().equals(usuario.getRepassword())) {
			return false;
		}

		if (usuario.getPassword().length() < 5) {
			return false;
		}

		return true;
	}

	public List<UsuarioSimplesDTO> findAll() {
		List<UsuarioSimplesDTO> usuarios = new ArrayList<>();
		List<Usuario> findAll = usuarioDAO.findAll();
		if (findAll != null) {
			findAll.forEach(u -> {
				UsuarioSimplesDTO dto = new UsuarioSimplesDTO();
				dto.setEmail(u.getEmail());
				dto.setNome(u.getNome());
				dto.setRegras(u.getRoles().stream().map(r -> new Role(r.getNome())).collect(Collectors.toList()));
				usuarios.add(dto);
			});
		}
		return usuarios;
	}

	public List<Role> findAllRoles() {
		List<Role> roles = new ArrayList<>();

		List<br.com.casadocodigo.loja.models.Role> result = roleDAO.findAll();

		result.forEach(r -> {
			roles.add(new Role(r.getNome()));
		});

		return roles;
	}

	public UsuarioDTO findByEmail(String email) {
		Usuario usuario = usuarioDAO.loadUserByUsername(email);
		UsuarioDTO dto = new UsuarioDTO();
		dto.setEmail(usuario.getEmail());
		dto.setNome(usuario.getNome());
		dto.setRoles(usuario.getRoles().stream().map(r -> new Role(r.getNome())).collect(Collectors.toList()));
		return dto;
	}

	public void addRolesToUser(UsuarioDTO user) {
		Usuario usuario = usuarioDAO.loadUserByUsername(user.getEmail());
		List<br.com.casadocodigo.loja.models.Role> roleDb = new ArrayList<>();
		user.getRoles().forEach(r -> {
			roleDb.add(roleDAO.findByName(r.getRegra()));
		});
		usuario.setRoles(roleDb);
		usuarioDAO.gravar(usuario);
	}

}
