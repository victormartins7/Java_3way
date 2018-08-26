package com.framework.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.framework.db.UsuarioDAO;
import com.framework.model.Usuario;

@ManagedBean(name = "CardLoginMB")
@ViewScoped
public class CardLoginMB {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String enviar() {
		apiRecebeDadosCartao();
		usuario = usuarioDAO.getUsuarioCard(getUsuario().getNomeUsuario(), getUsuario().getMatricula());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/acessoliberado";
		}
	}
	
	
	private void apiRecebeDadosCartao() {
		String nomeUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nomeUsuario");
		
		String matricula = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("matricula");
		
		usuario.setNomeUsuario(nomeUsuario);
		usuario.setMatricula(matricula);
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
