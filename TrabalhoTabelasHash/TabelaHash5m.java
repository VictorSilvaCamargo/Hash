import java.util.Random;

public class TabelaHash5m {
    public static void main(String[] args) {

        FuncaoHash tabelaDivisao100000 = new FuncaoHash(100000);
        FuncaoHash tabelaDivisao1000000 = new FuncaoHash(500000);
        FuncaoHash tabelaDivisao5000000 = new FuncaoHash(1000000);
        FuncaoHash tabelaDivisao7000000 = new FuncaoHash(2000000);
        FuncaoHash tabelaDivisao8000000 = new FuncaoHash(8000000);


        FuncaoHashMultiplicacao tabelaMultiplicacao100000 = new FuncaoHashMultiplicacao(100000);
        FuncaoHashMultiplicacao tabelaMultiplicacao1000000 = new FuncaoHashMultiplicacao(500000);
        FuncaoHashMultiplicacao tabelaMultiplicacao5000000 = new FuncaoHashMultiplicacao(1000000);
        FuncaoHashMultiplicacao tabelaMultiplicacao7000000 = new FuncaoHashMultiplicacao(2000000);
        FuncaoHashMultiplicacao tabelaMultiplicacao8000000 = new FuncaoHashMultiplicacao(8000000);


        FuncaoHashDobramento tabelaDobramento100000 = new FuncaoHashDobramento(100000);
        FuncaoHashDobramento tabelaDobramento1000000 = new FuncaoHashDobramento(500000);
        FuncaoHashDobramento tabelaDobramento5000000 = new FuncaoHashDobramento(1000000);
        FuncaoHashDobramento tabelaDobramento7000000 = new FuncaoHashDobramento(2000000);
        FuncaoHashDobramento tabelaDobramento8000000 = new FuncaoHashDobramento(8000000);


        Registro[] registros = new Registro[5000000];

        for (int i = 0; i < 5000000; i++) {
            int codigoRegistro = Registro.generateRandomCodigoRegistro();
            registros[i] = new Registro(codigoRegistro);
        }

        Random random = new Random();
        Registro[] chavesBusca = new Registro[5];
        for (int i = 0; i < 5; i++) {
            chavesBusca[i] = registros[random.nextInt(5000000)];
        }


        medirInsercoesETempo(tabelaDivisao100000, registros, "tabelaDivisao100000");
        medirInsercoesETempo(tabelaDivisao1000000, registros, "tabelaDivisao1000000");
        medirInsercoesETempo(tabelaDivisao5000000, registros, "tabelaDivisao5000000");
        medirInsercoesETempo(tabelaDivisao7000000, registros, "tabelaDivisao7000000");
        medirInsercoesETempo(tabelaDivisao8000000, registros, "tabelaDivisao8000000");


        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao100000, registros, "tabelaMultiplicacao100000");
        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao1000000, registros, "tabelaMultiplicacao1000000");
        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao5000000, registros, "tabelaMultiplicacao5000000");
        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao7000000, registros, "tabelaMultiplicacao7000000");
        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao8000000, registros, "tabelaMultiplicacao8000000");


        medirInsercoesETempoDobramento(tabelaDobramento100000, registros, "tabelaDobramento10000");
        medirInsercoesETempoDobramento(tabelaDobramento1000000, registros, "tabelaDobramento1000000");
        medirInsercoesETempoDobramento(tabelaDobramento5000000, registros, "tabelaDobramento5000000");
        medirInsercoesETempoDobramento(tabelaDobramento7000000, registros, "tabelaDobramento7000000");
        medirInsercoesETempoDobramento(tabelaDobramento8000000, registros, "tabelaDobramento8000000");


        medirBuscasETempo(tabelaDivisao100000, chavesBusca, "tabelaDivisao100000");
        medirBuscasETempo(tabelaDivisao1000000, chavesBusca, "tabelaDivisao1000000");
        medirBuscasETempo(tabelaDivisao5000000, chavesBusca, "tabelaDivisao5000000");
        medirBuscasETempo(tabelaDivisao7000000, chavesBusca, "tabelaDivisao7000000");
        medirBuscasETempo(tabelaDivisao8000000, chavesBusca, "tabelaDivisao8000000");

        medirBuscasETempoMultiplicacao(tabelaMultiplicacao100000, chavesBusca, "tabelaMultiplicacao100000");
        medirBuscasETempoMultiplicacao(tabelaMultiplicacao1000000, chavesBusca, "tabelaMultiplicacao1000000");
        medirBuscasETempoMultiplicacao(tabelaMultiplicacao5000000, chavesBusca, "tabelaMultiplicacao5000000");
        medirBuscasETempoMultiplicacao(tabelaMultiplicacao7000000, chavesBusca, "tabelaMultiplicacao10000000");
        medirBuscasETempoMultiplicacao(tabelaMultiplicacao8000000, chavesBusca, "tabelaMultiplicacao10000000");

        medirBuscasETempoDobramento(tabelaDobramento100000, chavesBusca, "tabelaDobramento100000");
        medirBuscasETempoDobramento(tabelaDobramento1000000, chavesBusca, "tabelaDobramento1000000");
        medirBuscasETempoDobramento(tabelaDobramento5000000, chavesBusca, "tabelaDobramento5000000");
        medirBuscasETempoDobramento(tabelaDobramento7000000, chavesBusca, "tabelaDobramento10000000");
        medirBuscasETempoDobramento(tabelaDobramento8000000, chavesBusca, "tabelaDobramento10000000");
    }

    public static void medirInsercoesETempo(FuncaoHash tabela, Registro[] registros, String tabelaNome) {
        long inicio, fim;
        inicio = System.currentTimeMillis();
        for (Registro registro : registros) {
            tabela.insere_hashing(registro.getCodigoRegistro());
        }
        fim = System.currentTimeMillis();
        System.out.println("Inserções na " + tabelaNome + ": " + 5000000);
        System.out.println("Tempo para inserir na " + tabelaNome + ": " + (fim - inicio) + " milisegundos");
        System.out.println("Número total de colisões na " + tabelaNome + ": " + tabela.getColisoes());
        System.out.println();
    }

    public static void medirBuscasETempo(FuncaoHash tabela, Registro[] chavesBusca, String tabelaNome) {
        System.out.println("Buscas na " + tabelaNome + ": " + 5000000);

        long totalTime = 0;
        long totalComparacoes = 0;

        for (Registro chave : chavesBusca) {
            long inicio, fim;
            inicio = System.currentTimeMillis();
            tabela.busca_hashing(chave.getCodigoRegistro());
            fim = System.currentTimeMillis();

            long tempoExecucao = fim - inicio;
            totalTime += tempoExecucao;
            totalComparacoes += tabela.getComparacoes();
        }


        System.out.println("Média de tempo de busca na " + tabelaNome + ": " + totalTime + " milisegundos");
        System.out.println("Média de comparações na " + tabelaNome + ": " + totalComparacoes);
        System.out.println();
    }



    public static void medirInsercoesETempoMultiplicacao(FuncaoHashMultiplicacao tabela, Registro[] registros, String tabelaNome) {
        long inicio, fim;
        inicio = System.currentTimeMillis();
        for (Registro registro : registros) {
            tabela.insere_hashing(registro.getCodigoRegistro());
        }
        fim = System.currentTimeMillis();
        System.out.println("Inserções na " + tabelaNome + ": " + 5000000);
        System.out.println("Tempo para inserir na " + tabelaNome + ": " + (fim - inicio) + " milisegundos");
        System.out.println("Número total de colisões na " + tabelaNome + ": " + tabela.getColisoes());
        System.out.println();
    }

    public static void medirBuscasETempoMultiplicacao(FuncaoHashMultiplicacao tabela, Registro[] chavesBusca, String tabelaNome) {
        System.out.println("Buscas na " + tabelaNome + ": " + 5000000);

        long totalTime = 0;
        long totalComparacoes = 0;

        for (Registro chave : chavesBusca) {
            long inicio, fim;
            inicio = System.currentTimeMillis();
            tabela.busca_hashing(chave.getCodigoRegistro());
            fim = System.currentTimeMillis();

            long tempoExecucao = fim - inicio;
            totalTime += tempoExecucao;
            totalComparacoes += tabela.getComparacoes();
        }


        System.out.println("Média de tempo de busca na " + tabelaNome + ": " + totalTime + " milisegundos");
        System.out.println("Média de comparações na " + tabelaNome + ": " + totalComparacoes);
        System.out.println();
    }



    public static void medirInsercoesETempoDobramento(FuncaoHashDobramento tabela, Registro[] registros, String tabelaNome) {
        long inicio, fim;
        inicio = System.currentTimeMillis();
        for (Registro registro : registros) {
            tabela.insere_hashing(registro.getCodigoRegistro());
        }
        fim = System.currentTimeMillis();
        System.out.println("Inserções na " + tabelaNome + ": " + 5000000);
        System.out.println("Tempo para inserir na " + tabelaNome + ": " + (fim - inicio) + " milisegundos");
        System.out.println("Número total de colisões na " + tabelaNome + ": " + tabela.getColisoes());
        System.out.println();
    }

    public static void medirBuscasETempoDobramento(FuncaoHashDobramento tabela, Registro[] chavesBusca, String tabelaNome) {
        System.out.println("Buscas na " + tabelaNome + ": " + 5000000);

        long totalTime = 0;
        long totalComparacoes = 0;

        for (Registro chave : chavesBusca) {
            long inicio, fim;
            inicio = System.currentTimeMillis();
            tabela.busca_hashing(chave.getCodigoRegistro());
            fim = System.currentTimeMillis();

            long tempoExecucao = fim - inicio;
            totalTime += tempoExecucao;
            totalComparacoes += tabela.getComparacoes();
        }


        System.out.println("Média de tempo de busca na " + tabelaNome + ": " + totalTime + " milisegundos");
        System.out.println("Média de comparações na " + tabelaNome + ": " + totalComparacoes);
        System.out.println();
    }


}