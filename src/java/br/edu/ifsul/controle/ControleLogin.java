package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PessoaFisicaDAO;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@ManagedBean(name = "controleLogin")
@SessionScoped
public class ControleLogin implements Serializable{

    private PessoaFisicaDAO<PessoaFisica> dao;
    private PessoaFisica usuarioLogado;
    private String usuario;
    private String senha;
    
    public ControleLogin(){
        dao = new PessoaFisicaDAO<>();
    }
    
    public String paginaLogin(){
        return "/login?faces-redirect=true";
    }
    
    public String efetuarLogin(){
        if(dao.login(usuario, senha)){
            usuarioLogado = dao.localizaPorNomeUsuario(usuario);
            Util.mensagemInformacao("Login realizado com sucesso!");
            usuario = "";
            senha = "";
            return "/index?faces-redirect=true";
        } else {
            Util.mensagemErro("Usuário ou senha inválidos!");
            return "/login?faces-redirect=true";
        }
    }
    
    public String efetuarLogout(){
        usuarioLogado = null;
        Util.mensagemInformacao("Logout realizado com sucesso!");
        return "/index?faces-redirect=true";
    }

    public PessoaFisicaDAO<PessoaFisica> getDao() {
        return dao;
    }

    public void setDao(PessoaFisicaDAO<PessoaFisica> dao) {
        this.dao = dao;
    }

    public PessoaFisica getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(PessoaFisica usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
