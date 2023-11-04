public class TabelaHash1m {
    public static void main(String[] args) {

        FuncaoHash tabelaDivisao10 = new FuncaoHash(10);
        FuncaoHash tabelaDivisao100 = new FuncaoHash(100);
        FuncaoHash tabelaDivisao1000 = new FuncaoHash(1000);
        FuncaoHash tabelaDivisao10000 = new FuncaoHash(10000);
        FuncaoHash tabelaDivisao100000 = new FuncaoHash(100000);


        FuncaoHashMultiplicacao tabelaMultiplicacao10 = new FuncaoHashMultiplicacao(10);
        FuncaoHashMultiplicacao tabelaMultiplicacao100 = new FuncaoHashMultiplicacao(100);
        FuncaoHashMultiplicacao tabelaMultiplicacao1000 = new FuncaoHashMultiplicacao(1000);
        FuncaoHashMultiplicacao tabelaMultiplicacao10000 = new FuncaoHashMultiplicacao(10000);
        FuncaoHashMultiplicacao tabelaMultiplicacao100000 = new FuncaoHashMultiplicacao(100000);


        FuncaoHashDobramento tabelaDobramento10 = new FuncaoHashDobramento(10);
        FuncaoHashDobramento tabelaDobramento100 = new FuncaoHashDobramento(100);
        FuncaoHashDobramento tabelaDobramento1000 = new FuncaoHashDobramento(1000);
        FuncaoHashDobramento tabelaDobramento10000 = new FuncaoHashDobramento(10000);
        FuncaoHashDobramento tabelaDobramento100000 = new FuncaoHashDobramento(100000);


        Registro[] registros = new Registro[1000000];

        for (int i = 0; i < 1000000; i++) {
            int codigoRegistro = Registro.generateRandomCodigoRegistro();
            registros[i] = new Registro(codigoRegistro);
        }


        medirInsercoesETempo(tabelaDivisao10, registros, "tabelaDivisao10");
        medirInsercoesETempo(tabelaDivisao100, registros, "tabelaDivisao100");
        medirInsercoesETempo(tabelaDivisao1000, registros, "tabelaDivisao1000");
        medirInsercoesETempo(tabelaDivisao10000, registros, "tabelaDivisao10000");
        medirInsercoesETempo(tabelaDivisao100000, registros, "tabelaDivisao100000");


        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao10, registros, "tabelaMultiplicacao10");
        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao100, registros, "tabelaMultiplicacao100");
        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao1000, registros, "tabelaMultiplicacao1000");
        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao10000, registros, "tabelaMultiplicacao10000");
        medirInsercoesETempoMultiplicacao(tabelaMultiplicacao100000, registros, "tabelaMultiplicacao100000");


        medirInsercoesETempoDobramento(tabelaDobramento10, registros, "tabelaDobramento10");
        medirInsercoesETempoDobramento(tabelaDobramento100, registros, "tabelaDobramento100");
        medirInsercoesETempoDobramento(tabelaDobramento1000, registros, "tabelaDobramento1000");
        medirInsercoesETempoDobramento(tabelaDobramento10000, registros, "tabelaDobramento10000");
        medirInsercoesETempoDobramento(tabelaDobramento100000, registros, "tabelaDobramento100000");


        medirBuscasETempo(tabelaDivisao10, registros, "tabelaDivisao10");
        medirBuscasETempo(tabelaDivisao100, registros, "tabelaDivisao100");
        medirBuscasETempo(tabelaDivisao1000, registros, "tabelaDivisao1000");
        medirBuscasETempo(tabelaDivisao10000, registros, "tabelaDivisao10000");
        medirBuscasETempo(tabelaDivisao100000, registros, "tabelaDivisao100000");


        medirBuscasETempoMultiplicacao(tabelaMultiplicacao10, registros, "tabelaMultiplicacao10");
        medirBuscasETempoMultiplicacao(tabelaMultiplicacao100, registros, "tabelaMultiplicacao100");
        medirBuscasETempoMultiplicacao(tabelaMultiplicacao1000, registros, "tabelaMultiplicacao1000");
        medirBuscasETempoMultiplicacao(tabelaMultiplicacao10000, registros, "tabelaMultiplicacao10000");
        medirBuscasETempoMultiplicacao(tabelaMultiplicacao100000, registros, "tabelaMultiplicacao100000");


        medirBuscasETempoDobramento(tabelaDobramento10, registros, "tabelaDobramento10");
        medirBuscasETempoDobramento(tabelaDobramento100, registros, "tabelaDobramento100");
        medirBuscasETempoDobramento(tabelaDobramento1000, registros, "tabelaDobramento1000");
        medirBuscasETempoDobramento(tabelaDobramento10000, registros, "tabelaDobramento10000");
        medirBuscasETempoDobramento(tabelaDobramento100000, registros, "tabelaDobramento100000");
    }

    public static void medirInsercoesETempo(FuncaoHash tabela, Registro[] registros, String tabelaNome) {
        long inicio, fim;
        inicio = System.currentTimeMillis();
        for (Registro registro : registros) {
            tabela.insere_hashing(registro.getCodigoRegistro());
        }
        fim = System.currentTimeMillis();
        System.out.println("Inserções na " + tabelaNome + ": " + 1000000);
        System.out.println("Tempo para inserir na " + tabelaNome + ": " + (fim - inicio) + " milisegundos");
        System.out.println("Número total de colisões na " + tabelaNome + ": " + tabela.getColisoes());
        System.out.println();
    }

    public static void medirBuscasETempo(FuncaoHash tabela, Registro[] registros, String tabelaNome) {
        System.out.println("Buscas na " + tabelaNome + ": " + 1000000);

        long totalTime = 0;
        long totalComparacoes = 0;
        for (int i = 0; i < 5; i++) {


            for (Registro registro : registros) {
                long inicio, fim;
                inicio = System.currentTimeMillis();
                tabela.busca_hashing(registro.getCodigoRegistro());
                fim = System.currentTimeMillis();

                long tempoExecucao = fim - inicio;
                totalTime += tempoExecucao;
                totalComparacoes += tabela.getComparacoes();
            }
        }
        long mediaTempo = totalTime / 5;
        long mediaComparacoes = totalComparacoes / 5;

        System.out.println("Média de tempo de busca na " + tabelaNome + ": " + mediaTempo + " milisegundos");
        System.out.println("Média de comparações na " + tabelaNome + ": " + mediaComparacoes);
        System.out.println();
        System.out.println();
    }


    public static void medirInsercoesETempoMultiplicacao(FuncaoHashMultiplicacao tabela, Registro[] registros, String tabelaNome) {
        long inicio, fim;
        inicio = System.currentTimeMillis();
        for (Registro registro : registros) {
            tabela.insere_hashing(registro.getCodigoRegistro());
        }
        fim = System.currentTimeMillis();
        System.out.println("Inserções na " + tabelaNome + ": " + 1000000);
        System.out.println("Tempo para inserir na " + tabelaNome + ": " + (fim - inicio) + " milisegundos");
        System.out.println("Número total de colisões na " + tabelaNome + ": " + tabela.getColisoes());
        System.out.println();
    }

    public static void medirBuscasETempoMultiplicacao(FuncaoHashMultiplicacao tabela, Registro[] registros, String tabelaNome) {
        System.out.println("Buscas na " + tabelaNome + ": " + 1000000);

        long totalTime = 0;
        long totalComparacoes = 0;
        for (int i = 0; i < 5; i++) {


            for (Registro registro : registros) {
                long inicio, fim;
                inicio = System.currentTimeMillis();
                tabela.busca_hashing(registro.getCodigoRegistro());
                fim = System.currentTimeMillis();

                long tempoExecucao = fim - inicio;
                totalTime += tempoExecucao;
                totalComparacoes += tabela.getComparacoes();
            }
        }
        long mediaTempo = totalTime / 5;
        long mediaComparacoes = totalComparacoes / 5;

        System.out.println("Média de tempo de busca na " + tabelaNome + ": " + mediaTempo + " milisegundos");
        System.out.println("Média de comparações na " + tabelaNome + ": " + mediaComparacoes);
        System.out.println();
        System.out.println();
    }


    public static void medirInsercoesETempoDobramento(FuncaoHashDobramento tabela, Registro[] registros, String tabelaNome) {
        long inicio, fim;
        inicio = System.currentTimeMillis();
        for (Registro registro : registros) {
            tabela.insere_hashing(registro.getCodigoRegistro());
        }
        fim = System.currentTimeMillis();
        System.out.println("Inserções na " + tabelaNome + ": " + 1000000);
        System.out.println("Tempo para inserir na " + tabelaNome + ": " + (fim - inicio) + " milisegundos");
        System.out.println("Número total de colisões na " + tabelaNome + ": " + tabela.getColisoes());
        System.out.println();
    }

    public static void medirBuscasETempoDobramento(FuncaoHashDobramento tabela, Registro[] registros, String tabelaNome) {
        System.out.println("Buscas na " + tabelaNome + ": " + 1000000);

        long totalTime = 0;
        long totalComparacoes = 0;
        for (int i = 0; i < 5; i++) {


            for (Registro registro : registros) {
                long inicio, fim;
                inicio = System.currentTimeMillis();
                tabela.busca_hashing(registro.getCodigoRegistro());
                fim = System.currentTimeMillis();

                long tempoExecucao = fim - inicio;
                totalTime += tempoExecucao;
                totalComparacoes += tabela.getComparacoes();
            }
        }
        long mediaTempo = totalTime / 5;
        long mediaComparacoes = totalComparacoes / 5;

        System.out.println("Média de tempo de busca na " + tabelaNome + ": " + mediaTempo + " milisegundos");
        System.out.println("Média de comparações na " + tabelaNome + ": " + mediaComparacoes);
        System.out.println();
        System.out.println();
    }
}