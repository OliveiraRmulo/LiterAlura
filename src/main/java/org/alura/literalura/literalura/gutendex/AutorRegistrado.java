package org.alura.literalura.literalura.gutendex;

import lombok.Data;

@Data
public class AutorRegistrado {

	private String nome;
    private Integer nascimento;
    private Integer falecimento;

    public boolean estavaVivoEm(int ano) {
        return nascimento != null && nascimento <= ano &&
               (falecimento == null || falecimento > ano);
    }

    public AutorRegistrado(String nome, Integer nascimento, Integer falecimento) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.falecimento = falecimento;
    }
}
