package br.sabadini;

/**
 * Created by felipesabadinifacina on 05/03/18.
 */
public class App {
    public static void main(String[] args) {
        Pessoa build = Pessoa
                .build()
                .nome("felipe")
                .sobrenome("sabadini")
                .idade(24)
                .altura(170)
                .build();
        System.out.println(build);
    }
}
