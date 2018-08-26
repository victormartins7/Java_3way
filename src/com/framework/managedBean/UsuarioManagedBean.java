package com.framework.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transaction;

import com.framework.db.UsuarioDAO;
import com.framework.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	public List usuarioListDb() {
		return usuarioDAO.listaUsuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String incluirUsuarioDb(Usuario usuario) {
		usuarioDAO.inserirUsuario(usuario);
		return "/main";
	}
	
	public String excluirUsuarioDb(Usuario usuario) {
		usuarioDAO.deletarUsuario(usuario);
		return "/main";
	}
	
	
	
	
}