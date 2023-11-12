public class ListaEncadeada {
    No cabeca;

    public ListaEncadeada() {
        this.cabeca = null;
    }

    public void insere(int chave) {
        No novoNo = new No(chave);
        novoNo.proximo = cabeca;
        cabeca = novoNo;
    }

    public int busca(int chave) {
        No atual = cabeca;
        int comparacoes = 0;
        while (atual != null) {
            comparacoes++;
            if (atual.chave == chave) {
                break;
            }
            atual = atual.proximo;
        }
        return comparacoes;
    }

    public boolean isEmpty() {
        return cabeca == null;
    }
}