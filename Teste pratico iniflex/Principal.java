import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Principal {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.parse("2000-10-18"), BigDecimal.valueOf(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.parse("1990-05-12"), BigDecimal.valueOf(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.parse("1961-02-05"), BigDecimal.valueOf(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.parse("1988-10-14"), BigDecimal.valueOf(19119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.parse("1995-01-05"), BigDecimal.valueOf(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.parse("1999-11-19"), BigDecimal.valueOf(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.parse("1993-03-31"), BigDecimal.valueOf(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.parse("1994-07-08"), BigDecimal.valueOf(301745.00), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.parse("2003-05-24"), BigDecimal.valueOf(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.parse("1996-09-02"), BigDecimal.valueOf(2799.93), "Gerente"));

        funcionarios.remove("João");

        System.out.println("\nFuncionários Atualizados:");
        funcionarios.forEach(funcionario -> {
            System.out.println(String.format("Nome: %s, Data Nascimento: %s, Salário: R$ %,.2f, Função: %s",
                    funcionario.getNome(),
                    funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    funcionario.getSalario(),
                    funcionario.getFuncao()));
        });

        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(BigDecimal.valueOf(0.1));
            BigDecimal novoSalario = salarioAtual.add(aumento);
            funcionario.setSalario(novoSalario);
        }


        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        //3.6 – Imprimir os funcionários, agrupados por função.


        System.out.println("\nFuncionários com aniversário entre outubro e dezembro:");
        funcionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() >= 10 && funcionario.getDataNascimento().getMonthValue() <= 12)
                .forEach(System.out::println);


        Funcionario pessoaMaisAntiga = null;
        LocalDate dataNascimentoMaisAntiga = LocalDate.MAX;

        for (Funcionario funcionario : funcionarios) {
            LocalDate dataNascimentoAtual = funcionario.getDataNascimento();
            if (dataNascimentoAtual.isBefore(dataNascimentoMaisAntiga)) {
                dataNascimentoMaisAntiga = dataNascimentoAtual;
                pessoaMaisAntiga = funcionario;
            }
        }
        System.out.println("\nPessoa mais velha: "+pessoaMaisAntiga.getNome()+" Idade "+ (2024- pessoaMaisAntiga.getDataNascimento().getYear()));


        funcionarios.sort(Comparator.comparing(Funcionario::getNome));

        System.out.println("\nLista de funcionários por ordem alfabética:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }



        BigDecimal totalSalarios = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioFuncionario = funcionario.getSalario();
            totalSalarios = totalSalarios.add(salarioFuncionario);
        }

        System.out.printf("\nTotal do salário dos funcionários: R$ %,.2f", totalSalarios);

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.




    }
}