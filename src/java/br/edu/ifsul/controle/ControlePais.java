
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PaisDAO;
import br.edu.ifsul.modelo.Pais;
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
@ManagedBean(name = "controlePais")
@SessionScoped
public class ControlePais implements Serializable {
    
    private PaisDAO<Pais> dao;
    private Pais objeto;
    
    public ControlePais(){
        dao = new PaisDAO<>();
    }
    
    public String listar(){
        return "/privado/pais/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Pais();
        return "formulario?faces-redirect=true";        
    }
    
    public String salvar(){
        boolean persistiu = false;
        if (objeto.getId() == null){
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu){
            Util.mensagemInformacao(dao.getMensagem());
            return "listar?faces-redirect=true";
        } else {
            Util.mensagemErro(dao.getMensagem());
            return "formulario?faces-redirect=true";
        }
    }
    
    public String cancelar(){
        return "listar?faces-redirect=true";
    }
    
    public String editar(Integer id){
        objeto = dao.localizar(id);
        return "formulario?faces-redirect=true";
    }
    
    public void remover(Integer id){
        objeto = dao.localizar(id);
        if (dao.remove(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }
    
    public PaisDAO getDao() {
        return dao;
    }

    public void setDao(PaisDAO dao) {
        this.dao = dao;
    }

    public Pais getObjeto() {
        return objeto;
    }

    public void setObjeto(Pais objeto) {
        this.objeto = objeto;
    }    
}
