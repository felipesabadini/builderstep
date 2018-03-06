package br.sabadini;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private Integer idade;
    private Integer altura;

    public Pessoa() {}

    public Pessoa(String nome, String sobrenome, Integer idade, Integer altura) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getAltura() {
        return altura;
    }

    public static Builder build() {
        return new Builder();
    }

    static final class Builder {

        public SobrenomeStep nome(String nome) {
            return new PessoaStepBuilder(nome);
        }

        class PessoaStepBuilder implements SobrenomeStep, IdadeStep, AlturaStep, PessoaBuild {
            private String nome;
            private String sobrenome;
            private Integer idade;
            private Integer altura;

            public PessoaStepBuilder(String nome) {
                this.nome = nome;
            }

            public IdadeStep sobrenome(String sobrenome) {
                this.sobrenome = nome;
                return this;
            }

            public AlturaStep idade(Integer idade) {
                this.idade = idade;
                return this;
            }

            public PessoaBuild altura(Integer altura) {
                this.altura = altura;
                return this;
            }

            public Pessoa build() {
                return new Pessoa(nome, sobrenome, idade, altura);
            }
        }

        interface SobrenomeStep {
            IdadeStep sobrenome(String sobrenome);
        }

        interface IdadeStep {
            AlturaStep idade(Integer idade);
        }

        interface AlturaStep {
            PessoaBuild altura(Integer altura);
        }

        interface PessoaBuild {
            Pessoa build();
        }
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }
}
