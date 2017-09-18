package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.TipoEndereco;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TipoEnderecoDAO<T> extends DAOGenerico<TipoEndereco> implements Serializable {

    public TipoEnderecoDAO() {
        super();
        classePersistente = TipoEndereco.class;
        ordem = "descricao";
    }
}
