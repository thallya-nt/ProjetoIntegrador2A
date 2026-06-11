package projeto2A.DAO;

import projeto2A.entidade.Contato;

import java.util.List;

// CLASSE MODELO/ BASE
public interface AgendaGenericDAO {

    void adcionarContato(Contato contato );

    void atualizarContato (String nomeOld, Contato contato);

    void removerContato(String nome);

    Contato buscarContato(String nome);

    List<Contato> listarContatos();
}
