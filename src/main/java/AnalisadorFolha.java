import java.util.*;
import java.util.stream.Collectors;

public class AnalisadorFolha {

    public static void main(String[] args) {
        List<RegistroFolha> registros = carregarDadosSimulados();
        verificarReaparecimentoRendimento(registros);
        verificarVariacaoDesconto(registros);
    }

    private static void verificarReaparecimentoRendimento(List<RegistroFolha> registros) {
        System.out.println("\nSituações de RENDIMENTO após 6 meses:");

        Map<String, List<RegistroFolha>> agrupado = registros.stream()
                .filter(r -> r.tipoRubrica.equals("RENDIMENTO"))
                .collect(Collectors.groupingBy(r -> r.matricula + "-" + r.codigoRubrica));

        for (Map.Entry<String, List<RegistroFolha>> entry : agrupado.entrySet()) {
            List<RegistroFolha> rubricas = entry.getValue();
            rubricas.sort(Comparator.comparing(r -> r.anoCalculo * 100 + r.mesCalculo));

            for (int i = 1; i < rubricas.size(); i++) {
                RegistroFolha anterior = rubricas.get(i - 1);
                RegistroFolha atual = rubricas.get(i);

                int meses = (atual.anoCalculo - anterior.anoCalculo) * 12 + (atual.mesCalculo - anterior.mesCalculo);
                if (meses >= 6) {
                    System.out.printf("%s (Rubrica %s) reapareceu após %d meses\n",
                            atual.nome, atual.codigoRubrica, meses);
                }
            }
        }
    }

    private static void verificarVariacaoDesconto(List<RegistroFolha> registros) {
        System.out.println("\nSituações de DESCONTO com variação >= 5%:");

        Map<String, List<RegistroFolha>> agrupado = registros.stream()
                .filter(r -> r.tipoRubrica.equals("DESCONTO"))
                .collect(Collectors.groupingBy(r -> r.matricula + "-" + r.codigoRubrica));

        for (Map.Entry<String, List<RegistroFolha>> entry : agrupado.entrySet()) {
            List<RegistroFolha> rubricas = entry.getValue();
            rubricas.sort(Comparator.comparing(r -> r.anoCalculo * 100 + r.mesCalculo));

            double media = rubricas.stream().mapToDouble(r -> r.valor).average().orElse(0);

            for (RegistroFolha r : rubricas) {
                double variacao = Math.abs(r.valor - media) / media;
                if (variacao >= 0.05) {
                    System.out.printf("%s (Rubrica %s): valor %.2f difere %.2f%% da média %.2f\n",
                            r.nome, r.codigoRubrica, r.valor, variacao * 100, media);
                }
            }
        }
    }

    private static List<RegistroFolha> carregarDadosSimulados() {
        return Arrays.asList(
                new RegistroFolha("João", "001", "RENDIMENTO", "R001", 1500, 1, 2023),
                new RegistroFolha("João", "001", "RENDIMENTO", "R001", 1500, 8, 2023),
                new RegistroFolha("Maria", "002", "DESCONTO", "D001", 200, 1, 2023),
                new RegistroFolha("Maria", "002", "DESCONTO", "D001", 220, 2, 2023),
                new RegistroFolha("Maria", "002", "DESCONTO", "D001", 300, 3, 2023)
        );
    }
}

class RegistroFolha {
    String nome;
    String matricula;
    String tipoRubrica;
    String codigoRubrica;
    double valor;
    int mesCalculo;
    int anoCalculo;

    public RegistroFolha(String nome, String matricula, String tipoRubrica,
                         String codigoRubrica, double valor, int mesCalculo, int anoCalculo) {
        this.nome = nome;
        this.matricula = matricula;
        this.tipoRubrica = tipoRubrica;
        this.codigoRubrica = codigoRubrica;
        this.valor = valor;
        this.mesCalculo = mesCalculo;
        this.anoCalculo = anoCalculo;
    }
}
