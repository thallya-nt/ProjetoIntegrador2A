package projeto2A.principal;

import projeto2A.DAO.AgendaGenericDAO;
import projeto2A.entidade.Contato;
import projeto2A.principal.conFactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// CLASSE ONDE FICAM AS QUERY SQL
public class AgendaTelefonica implements AgendaGenericDAO {

    //CREATE
    @Override
    public void adcionarContato(Contato contato) {

        String sql = "INSERT INTO CONTATO (NOME , TELEFONE , EMAIL) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement ps = null;
        try {
            conexao = ConnectionFactory.getConexao();
            ps = conexao.prepareStatement(sql);

            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.setString(3, contato.getEmail());

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println(" CADASTRO REALIZADO! ✅");
            }

        } catch (Exception e) {
            System.err.println("Erro ao cadastrar novo contato: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    //UPDATE
    @Override
    public void atualizarContato(String nomeOld, Contato newCntt) {
        String sql = "UPDATE CONTATO SET  NOME = ?, TELEFONE = ?, EMAIL = ?  WHERE NOME = ?";
        Connection conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = ConnectionFactory.getConexao();
            ps = conexao.prepareStatement(sql);

            ps.setString(1,newCntt.getNome() );
            ps.setString(2, newCntt.getTelefone());
            ps.setString(3, newCntt.getEmail());
            ps.setString(4,nomeOld);

            ps.executeUpdate();
            System.out.println(" OS DADOS FORAM MODIFICADOS . . .");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE
    @Override
    public void removerContato(String nome) {
        String sql = "DELETE FROM CONTATO WHERE NOME = ?";
        Connection conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = ConnectionFactory.getConexao();
            ps = conexao.prepareStatement(sql);

            ps.setString(1, nome);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("CONTATO REMOVIDO COM SUCESSO! ✅");
            } else{
                System.out.println("ESTE CONTATO NÃO EXISTE.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao remover contato: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }


    //READ
    @Override
    public Contato buscarContato(String nome) {
        Contato contato = null;
        if (nome == "") {
            System.out.println("Nome inválido 🚫");
            return null;
        }
        String sql = "SELECT * FROM CONTATO WHERE NOME = ?";
        Connection conexao = null;
        PreparedStatement ps = null;

        try {
            conexao = ConnectionFactory.getConexao();
            ps = conexao.prepareStatement(sql);

            ps.setString(1, nome);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return contato = new Contato(
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // READ
    @Override
    public List<Contato> listarContatos() {
        String sql = "SELECT * FROM CONTATO";

        List<Contato> contatos = new ArrayList<Contato>();
        PreparedStatement ps = null;
        ResultSet rset = null;
        Connection conexao = null;

        try {
            conexao = ConnectionFactory.getConexao();
            ps = conexao.prepareStatement(sql);
            rset = ps.executeQuery();

            while (rset.next()) {
                Contato contato = new Contato();
                contato.setNome(rset.getString("nome"));
                contato.setTelefone(rset.getString("telefone"));
                contato.setEmail(rset.getString("email"));

                contatos.add(contato);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar contato: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }  return contatos;
    }

}
