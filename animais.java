/*
EXERCÍCIO: GERENCIAMENTO DE ANIMAIS
-----------------------------------
Objetivo: Desenvolver uma aplicação que permita o gerenciamento de diferentes animais,
suas características e comportamentos.

Requisitos (Classe Animal):
- Atributos:
  - nome: representa o nome do animal (por exemplo, "Rex").
  - tipo: define a classificação do animal (como "Mamífero", "Réptil", etc.).
  - som : descreve o som característico que o animal faz (como "Latido", "Miado", etc.).
- Construtor:
  - Inicializa os atributos nome, tipo e som.
- Métodos:
  - setSom(String som): permite alterar o som do animal.
  - fazerSom(): imprime a ação de o animal fazer o seu som característico.
  - alimentar(): imprime a ação de alimentar o animal.
  - dormir(): imprime a ação do animal dormindo.
  - mostrarInfo(): imprime as informações do animal.

Observações:
- Este arquivo implementa APENAS a classe Animal solicitada. Para testes, crie uma classe
  separada com método main (por exemplo, App.java) que instancie e chame os métodos.
*/

/**
 * Classe que modela um Animal com nome, tipo e som característico.
 * <p>
 * O código foi escrito com comentários detalhados para fins didáticos,
 * seguindo boas práticas de encapsulamento e validação simples de entrada.
 */
public class Animal {

    /* ----------------------------------------------------------------------
       ATRIBUTOS (ESTADO DO OBJETO)
       ---------------------------------------------------------------------- */

    // Nome do animal (ex.: "Rex", "Mimi"). Mantido como String para facilitar I/O.
    private String nome;

    // Tipo ou classificação do animal (ex.: "Mamífero", "Réptil", "Ave").
    private String tipo;

    // Som característico (ex.: "Latido", "Miado", "Canto").
    private String som;

    /* ----------------------------------------------------------------------
       CONSTRUTOR
       ---------------------------------------------------------------------- */

    /**
     * Construtor que inicializa os três atributos obrigatórios.
     * Realiza uma normalização simples (trim) e aplica valores padrão
     * quando alguma informação vier nula ou em branco.
     *
     * @param nome nome do animal
     * @param tipo tipo/classificação do animal
     * @param som  som característico do animal
     */
    public Animal(String nome, String tipo, String som) {
        // Normaliza as entradas removendo espaços extras nas pontas (caso não sejam nulas).
        this.nome = sanitize(nome, "Sem nome");
        this.tipo = sanitize(tipo, "Sem tipo");
        this.som  = sanitize(som,  "Som indefinido");
    }

    /* ----------------------------------------------------------------------
       MÉTODOS DE COMPORTAMENTO (REQUISITADOS PELO ENUNCIADO)
       ---------------------------------------------------------------------- */

    /**
     * Altera o som do animal. Caso a string recebida seja nula ou em branco,
     * aplica um valor padrão legível.
     *
     * @param som novo som característico
     */
    public void setSom(String som) {
        // Atualiza o atributo com validação simples.
        this.som = sanitize(som, "Som indefinido");
    }

    /**
     * Imprime no console o som característico do animal.
     * Exemplo de saída: "Rex faz: Latido!"
     */
    public void fazerSom() {
        // Usa toStringSom() para garantir texto amigável mesmo se vazio.
        System.out.println(getNomeSeguro() + " faz: " + toStringSom() + "!");
    }

    /**
     * Imprime no console a ação de alimentar o animal.
     * Exemplo de saída: "Rex está se alimentando."
     */
    public void alimentar() {
        System.out.println(getNomeSeguro() + " está se alimentando.");
    }

    /**
     * Imprime no console a ação do animal dormindo.
     * Exemplo de saída: "Rex está dormindo... zZz"
     */
    public void dormir() {
        System.out.println(getNomeSeguro() + " está dormindo... zZz");
    }

    /**
     * Imprime no console um resumo com as informações do animal:
     * nome, tipo e som característico.
     */
    public void mostrarInfo() {
        System.out.println("=== Informações do Animal ===");
        System.out.println("Nome: " + getNomeSeguro());
        System.out.println("Tipo: " + getTipoSeguro());
        System.out.println("Som : " + toStringSom());
    }

    /* ----------------------------------------------------------------------
       GETTERS (OPCIONAIS PARA USO FUTURO)
       ---------------------------------------------------------------------- */

    /**
     * Retorna o nome do animal (nunca nulo/blank; garante texto padrão).
     */
    public String getNome() {
        return getNomeSeguro();
    }

    /**
     * Retorna o tipo/classificação do animal (nunca nulo/blank; garante texto padrão).
     */
    public String getTipo() {
        return getTipoSeguro();
    }

    /**
     * Retorna o som característico (nunca nulo/blank; garante texto padrão).
     */
    public String getSom() {
        return isBlank(this.som) ? "Som indefinido" : this.som;
    }

    /* ----------------------------------------------------------------------
       MÉTODOS AUXILIARES PRIVADOS
       ---------------------------------------------------------------------- */

    // Normaliza um texto: se for nulo ou em branco, retorna o padrão; caso contrário, trim().
    private static String sanitize(String value, String defaultValue) {
        return isBlank(value) ? defaultValue : value.trim();
    }

    // Retorna true se a string for nula ou só com espaços.
    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    // Garante nome amigável para mensagens.
    private String getNomeSeguro() {
        return isBlank(this.nome) ? "Sem nome" : this.nome;
    }

    // Garante tipo amigável para mensagens.
    private String getTipoSeguro() {
        return isBlank(this.tipo) ? "Sem tipo" : this.tipo;
    }

    // Garante som amigável para impressão.
    private String toStringSom() {
        return isBlank(this.som) ? "Som indefinido" : this.som;
    }

    /* ----------------------------------------------------------------------
       REPRESENTAÇÃO TEXTUAL (ÚTIL PARA LOG/DEPURAÇÃO)
       ---------------------------------------------------------------------- */

    @Override
    public String toString() {
        // Retorna uma linha compacta com as principais informações.
        return String.format("Animal{nome='%s', tipo='%s', som='%s'}",
                getNomeSeguro(), getTipoSeguro(), toStringSom());
    }
}