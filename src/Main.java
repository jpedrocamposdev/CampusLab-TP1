
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean usuarioAtivo = true;
        boolean possuiAtraso = false;

        int solicitacoes = 0;
        int opcao = 0;

        boolean notebookDisponivel = true;
        boolean projetorDisponivel = true;

        while (opcao != 3) {

            System.out.println("\n=== CAMPUSLAB ===");
            System.out.println("1 - Consultar equipamentos");
            System.out.println("2 - Solicitar emprestimo");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nEQUIPAMENTOS:");

                    if (notebookDisponivel) {
                        System.out.println("1 - Notebook: Disponivel");
                    } else {
                        System.out.println("1 - Notebook: Reservado");
                    }

                    if (projetorDisponivel) {
                        System.out.println("2 - Projetor: Disponivel");
                    } else {
                        System.out.println("2 - Projetor: Reservado");
                    }
                    break;

                case 2:
                    if (!usuarioAtivo) {
                        System.out.println("Usuario inativo!");
                    } else if (possuiAtraso) {
                        System.out.println("Voce possui emprestimos atrasados!");
                    } else if (solicitacoes >= 2) {
                        System.out.println("Limite de duas solicitacoes atingido!");
                    } else {

                        System.out.println("1 - Notebook");
                        System.out.println("2 - Projetor");
                        System.out.print("Escolha o equipamento: ");

                        int equipamento = scanner.nextInt();

                        if (equipamento == 1 && notebookDisponivel) {
                            notebookDisponivel = false;
                            solicitacoes++;
                            System.out.println("Notebook reservado! Aguardando aprovacao.");

                        } else if (equipamento == 2 && projetorDisponivel) {
                            projetorDisponivel = false;
                            solicitacoes++;
                            System.out.println("Projetor reservado! Aguardando aprovacao.");

                        } else {
                            System.out.println("Equipamento invalido ou indisponivel!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Encerrando o CampusLab...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }

        scanner.close();
    }
}
