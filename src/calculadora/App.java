package calculadora;

//Localização e hora local
import java.util.Locale;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

//Scanner e tratamento de erros
import java.util.Scanner;

//Logs + salvar arquivo
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Calculos
import calculadora.entities.Soma;
import calculadora.entities.Subtrair;
import calculadora.entities.Multiplicar;
import calculadora.entities.Porcentagem;
import calculadora.entities.Divisao;

public class App {

    // Instância do Logger para esta classe
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        //define a localidade
        Locale.setDefault(Locale.US);

        // 1. Especifica explicitamente o fuso horário do Brasil
        String dataHoje = LocalDate.now(ZoneId.of("America/Sao_Paulo"))
                                   .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 2. Garante que o diretório "logs" exista antes de criar o arquivo
        File pastaLogs = new File("logs");
        if (!pastaLogs.exists()) {
            pastaLogs.mkdirs();
        }

        // 3. Monta o caminho dinâmico com Data + Contador de Rotação (%g)
        String nomeArquivoLog = String.format("logs/app-%s-%%g.log", dataHoje);

        try {
            // Gera arquivos como: logs/app-2026-10-07-0.log
            FileHandler fileHandler = new FileHandler(
                nomeArquivoLog,
                1024 * 1024, // 1 MB
                3,           // Limite de 3 arquivos por rotação
                true
            );

            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao criar arquivo de log dinâmico", e);
        }

        // Execução normal do código
        logger.info("Bem-Vindo");
        logger.info("Vamos calcular!");
        int n1;
        int n2;
        int opcao = -1; // Inicializado para garantir o controle do loop


        Scanner sc = new Scanner(System.in);
        do{
            logger.info("Escolha uma operação");
            // Exibição do menu
            System.out.println("\n--- CALCULADORA  ---");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Porcentagem");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            // Tratamento simples caso o usuário digite algo que não seja um número
            if (!sc.hasNextInt()) {
                logger.log(Level.SEVERE, "Por favor, digite um número válido!");
                sc.next(); // Descarta a entrada inválida para evitar loop infinito
                continue;
            }

            opcao = sc.nextInt();
            sc.nextLine(); // CORREÇÃO: Consome o '\n' deixado após ler a opção do menu
            switch (opcao) {
            case 1:
                logger.info("Digite dois números:");
                    n1 = sc.nextInt();
                    n2 = sc.nextInt();
                    sc.nextLine(); // CORREÇÃO: Consome o '\n'

                Soma soma = new Soma();
                    soma.setN1(n1);
                    soma.setN2(n2);
            // Registra o resultado em nível INFO
            logger.log(Level.INFO, "O resultado da soma é: {0}", soma);
                
            break;

            case 2: 
                logger.info("Digite dois números:");
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            sc.nextLine(); // CORREÇÃO: Consome o '\n'

            Subtrair sub = new Subtrair();
            sub.setN1(n1);
            sub.setN2(n2);
            
            // Registra o resultado em nível INFO
            logger.log(Level.INFO, "O resultado da subtração é: {0}", sub);
                
            break;

            case 3: 
                logger.info("Digite dois números:");
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            sc.nextLine(); // CORREÇÃO: Consome o '\n'

            Multiplicar multi = new Multiplicar();
            multi.setN1(n1);
            multi.setN2(n2);
            
            // Registra o resultado em nível INFO
            logger.log(Level.INFO, "O resultado da multiplicação é: {0}", multi);
                
            break;

            case 4: 
            logger.info("Digite dois números:");
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            sc.nextLine(); // CORREÇÃO: Consome o '\n'

            Divisao dividir = new Divisao();
            dividir.setN1(n1);
            dividir.setN2(n2);
            
            // Registra o resultado em nível INFO
            logger.log(Level.INFO, "O resultado da divisão é: {0}", dividir);
                
            break;

            case 5:
            logger.info("Digite dois números:");
            double porcen = sc.nextDouble();
            double valorTotal = sc.nextDouble();
            sc.nextLine(); // CORREÇÃO: Consome o '\n'

            Porcentagem porcentagem = new Porcentagem();
            porcentagem.setPorcen(porcen);
            porcentagem.setValorTotal(valorTotal);
            
            // Registra o resultado em nível INFO
            logger.log(Level.INFO, "O resultado da porcentagem é: {0}", porcentagem);
            break;
            case 0: logger.info("Saindo....");
            break;

            default: logger.log(Level.SEVERE,"Opção inválida!");
            break;
            }
    } while (opcao != 0); // Continua no loop até que o usuário digite 0

    sc.close();
    logger.info("Fim do programa");
}
}