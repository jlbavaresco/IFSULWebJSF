package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class EstadoDAO<T> extends DAOGenerico<Estado> implements Serializable {

    public EstadoDAO() {
        super();
        classePersistente = Estado.class;
        ordem = "nome";
    }
}
