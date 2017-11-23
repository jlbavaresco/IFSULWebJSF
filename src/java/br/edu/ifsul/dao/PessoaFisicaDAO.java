package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.PessoaFisica;
import java.io.Serializable;
import javax.persistence.Query;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class PessoaFisicaDAO<T> extends DAOGenerico<PessoaFisica> implements Serializable {

    public PessoaFisicaDAO() {
        super();
        classePersistente = PessoaFisica.class;
        ordem = "nome";
    }
    
    public boolean login(String usuario, String senha){
        Query query = em.createQuery("from PessoaFisica where upper(nomeUsuario) = :usuario and "
                + " upper(senha) = :senha");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()){
            return true;
        } else {
            return false;
        }        
    }
    
    public PessoaFisica localizaPorNomeUsuario(String usuario){
        Query query = em.createQuery("from PessoaFisica where upper(nomeUsuario) = :usuario");
        query.setParameter("usuario", usuario.toUpperCase());
        return (PessoaFisica) query.getSingleResult();
    }
}
