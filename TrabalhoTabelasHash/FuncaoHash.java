public class FuncaoHash {
    private ListaEncadeada[] tabela;
    private int tamanho;
    private long colisoes;
    private long comparacoes;

    public FuncaoHash(int tamanho) {
        this.tamanho = tamanho;
        this.colisoes = 0;
        this.comparacoes = 0;
        tabela = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }

    public void busca_hashing(int chave) {
        int i = h(chave);
        comparacoes += tabela[i].busca(chave);
    }

    public void insere_hashing(int chave) {
        int i = h(chave);
        if (!tabela[i].isEmpty()) {
            colisoes++;
        }
        tabela[i].insere(chave);
    }

    public long getColisoes() {
        return colisoes;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    private int h(int chave) {
        return chave % tamanho;
    }
}