package projeto2A.principal;

import projeto2A.DAO.AgendaGenericDAO;
import projeto2A.entidade.Contato;

import java.util.List;
import java.util.Scanner;

public class AgendaTeste {
    public static void main(String[] args) {
        AgendaTeste interfc = new AgendaTeste();

        interfc.executar();
    }

    private Scanner scan = new Scanner(System.in);
    private AgendaGenericDAO agendaTelefonica = new AgendaTelefonica();


    public void executar() {
        int opcao;
        do {
            showMenu();
            try {
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarContato();
                        break;
                    case 2:
                        atualizarContato();
                        break;
                    case 3:
                        removerContato();
                        break;
                    case 4:
                        buscarContato();
                        break;
                    case 5: listarContatos();
                        break;
                    case 6:
                        System.out.println("Sistema encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente");
                scan.nextLine();
                opcao = 0;
            }
        } while (opcao != 6);
    }
    // MENU
    private void showMenu(){
        System.out.println(" ");
        System.out.println("------- OLÁ! O QUE VOCê GOSTARIA DE FAZER ?-------" );
        System.out.println("1. ADICIONAR UM NOVO CONTATO.");
        System.out.println("2. ALTERAR UM CONTATO EXISTENTE.");
        System.out.println("3. REMOVER UM CONTATO.");
        System.out.println("4. BUSCAR UM CONTATO ESPECÍFICO.");
        System.out.println("5. VER TODOS OS CONTATOS CADASTRADOS.");
        System.out.println("6. SAIR.");
    }

    private void adicionarContato(){
        System.out.println("||||| OPÇÃO 1 --> ADICINAR NOVO CONTATO |||||");
        System.out.println( "NOME:" );
        String nome = scan.nextLine();
        if (agendaTelefonica.buscarContato(nome) != null){
            System.out.println("ESSE NOME JÁ EXISTE.");
        } else {
            System.out.println("TELEFONE: ");
            String telefone = scan.nextLine();
            System.out.println(" EMAIL: ");
            String email = scan.nextLine();

            Contato novoContato = new Contato(nome, telefone, email);
            agendaTelefonica.adcionarContato(novoContato);
            System.out.println("NOVO CONTATO ADICIONADO! " + nome + "✅");
        }

    }

    private void atualizarContato(){
        System.out.println("||||| OPÇÃO 2 --> ATUALIZAR CONTATO EXISTENTE |||||");
        System.out.println("DIGITE UM NOME VÁLIDO: ");
        String nome = scan.nextLine();

        Contato nomeExist = agendaTelefonica.buscarContato(nome);

        if (nomeExist == null){
            System.out.println("CONTATO NÃO ENCONTRADO.");
        } else {
            System.out.println( "CONTATO LOCALIZADO COM SUCESSO!");
            System.out.println(" INFORMAÇÕES ATUAIS: " + nomeExist.getNome() + ", "
            + nomeExist.getTelefone() + ", " + nomeExist.getEmail() );
            System.out.println(" ");
            System.out.println("INICIANDO ATUALIZAÇÃO DE CONTATO ...");
            System.out.println("NOVO NOME: ");
            String newName = scan.nextLine();
            System.out.println("NOVO TELEFONE: ");
            String newPhone = scan.nextLine();
            System.out.println("NOVO EMAIL: ");
            String newEmail = scan.nextLine();

            Contato cnttAtualizado = new Contato();
            cnttAtualizado.setNome(newName);
            cnttAtualizado.setTelefone(newPhone);
            cnttAtualizado.setEmail(newEmail);

            agendaTelefonica.atualizarContato(nome, cnttAtualizado);

            System.out.println("CONTATO ATUALIZADO COM SUCESSO ✅");
        }
    }

    private void removerContato(){
        System.out.println("||||| OPÇÃO 3 --> REMOVER CONTATO EXISTENTE |||||");
        System.out.println("DIGITE UM NOME VÁLIDO: ");
        String nome = scan.nextLine();
        if (nome == null){
            System.out.println("NOME INVÁLIDO");
        }
        agendaTelefonica.removerContato(nome);
    }

    private void buscarContato(){
        System.out.println("||||| OPÇÃO 4 --> BUSCAR CONTATO |||||");
        System.out.println("DIGITE UM NOME VÁLIDO: ");
        String nome = scan.nextLine();
        Contato contatos = agendaTelefonica.buscarContato(nome);
        if (contatos == null){
            System.out.println("CONTATO NÃO ENCOTRADA. verifique se o nome foi " +
                    "escrito corretamente.");
        } else {
            System.out.println("CONTATO ECONTRADO COM SUCESSO");
            System.out.println("IMPRIMINDO INFORMAÇÕES . . .");
            System.out.println("NOME: " + contatos.getNome());
            System.out.println("TELEFONE: " + contatos.getTelefone());
            System.out.println("EMAIL: "+ contatos.getEmail());
        }
    }

    private void listarContatos(){
        System.out.println("||||| OPÇÃO 5 --> LISTAR CONTATOS |||||");
        List<Contato> lista = agendaTelefonica.listarContatos();
        if (lista.isEmpty()) {
            System.out.println("NENHUM CONTATO CADASTRADO");
        }
        for (Contato c : lista){
            System.out.println( "||| CONTATOS |||");
            System.out.println("NOME: " + c.getNome());
            System.out.println("TELEFONE: " + c.getTelefone());
            System.out.println("EMAIL: " + c.getEmail());
        }
    }
}
