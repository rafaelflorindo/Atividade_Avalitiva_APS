import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        funcionarios.add(new Funcionario(1, "João", 3000));
        funcionarios.add(new Funcionario(2, "Maria", 3500));
        int opcao;
        do {
            System.out.println("\nMENU");
            System.out.println("1 - Adicionar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Alterar Funcionário");
            System.out.println("4 - Remover Funcionário");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    alterarFuncionario();
                    break;
                case 4:
                    removerFuncionario();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    public static void adicionarFuncionario() {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        funcionarios.add(new Funcionario(id, nome, salario));
    }

    public static void listarFuncionarios() {
        System.out.println("Lista de Funcionários:");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }

    public static void removerFuncionario() {
        System.out.print("Digite o ID do funcionário a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        funcionarios.removeIf(f -> f.getId() == id);
    }

    public static Funcionario buscarFuncionarioPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public static void alterarFuncionario() {
        System.out.print("Digite o ID do funcionário a ser alterado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Funcionario funcionario = buscarFuncionarioPorId(id);
        if (funcionario != null) {
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo salário: ");
            double novoSalario = scanner.nextDouble();
            scanner.nextLine();
            funcionario.setNome(novoNome);
            funcionario.setSalario(novoSalario);
        } else {
            System.out.println("Funcionário com ID " + id + " não encontrado.");
        }
    }
}
