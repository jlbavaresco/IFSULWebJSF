package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pais;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class PaisDAO<T> extends DAOGenerico<Pais> implements Serializable {

    public PaisDAO(){
        super();
        classePersistente = Pais.class;
        ordem = "nome";
    }
}
