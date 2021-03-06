package ERE.Mips;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        Leitura leitura = new Leitura();
        Escrita escrita =  new Escrita("saidaComandos.txt");

        ArrayList<String> entradas = leitura.getEntradas();
        ArrayList<String> saidaBinario = new ArrayList<>();

        for (String entrada: entradas) {
            String registradores = "";
            //Recebe a linha completa do comando

            //Separa a linha recebida em um array
            String comando[] = entrada.split(" ");

            //Pega a primera posição desse novo array, que é a função mips que queremos
            String funcao = comando[0];

            //Junta o restante em outra variável, esse são os nosso possíveis registradores
            for (int i = 1; i < comando.length; i++) {
                registradores += comando[i];
            }
            //verifica se a função é do tipo R
            if(funcao.equals("add") || funcao.equals("addu")
                    || funcao.equals("sub") || funcao.equals("subu")
                    || funcao.equals("and") || funcao.equals("or")
                    || funcao.equals("xor") || funcao.equals("nor")
                    || funcao.equals("slt") || funcao.equals("sltu")
                    || funcao.equals("sll") || funcao.equals("srl")
                    || funcao.equals("sra") || funcao.equals("sllv")
                    || funcao.equals("srlv") || funcao.equals("srav")
                    || funcao.equals("mfhi") || funcao.equals("mthi")
                    || funcao.equals("mflo") || funcao.equals("mtlo")
                    || funcao.equals("mult") || funcao.equals("multu")
                    || funcao.equals("div") || funcao.equals("divu")
                    || funcao.equals("jr") || funcao.equals("jarl")) {
                FormatoR formR = new FormatoR(funcao, registradores);

                System.out.println(entrada + " - " + formR.converter());
                saidaBinario.add(formR.converter());
            }
            //verifica se a função é do tipo I
            else if (funcao.equals("addi") || funcao.equals("ori")
                    || funcao.equals("xori") || funcao.equals("lui")
                    || funcao.equals("bltz") || funcao.equals("bgez")
                    || funcao.equals("bltzal") || funcao.equals("beq")
                    || funcao.equals("bne") || funcao.equals("blez")
                    || funcao.equals("bgtz") || funcao.equals("lb")
                    || funcao.equals("lh") || funcao.equals("lwl")
                    || funcao.equals("lw") || funcao.equals("lbu")
                    || funcao.equals("lhu") || funcao.equals("lwr")
                    || funcao.equals("sb") || funcao.equals("sh")
                    || funcao.equals("swl") || funcao.equals("sw")
                    || funcao.equals("swr") || funcao.equals("addiu")
                    || funcao.equals("slti") || funcao.equals("sltiu")
                    || funcao.equals("andi")) {
                FormatoI formI = new FormatoI(funcao, registradores);

                System.out.println(entrada + " - " + formI.converter());
                saidaBinario.add(formI.converter());
            }
            //verifica se a função é do tipo J
            else if (funcao.equals("j") || funcao.equals("jal")) {
                FormatoJ formJ = new FormatoJ(funcao, registradores);

                System.out.println(entrada + " - " + formJ.converter());
                saidaBinario.add(formJ.converter());
            } else {
                System.out.println("ERROR - Função desconhecida!");
            }
        }
        escrita.escrever(saidaBinario);
    }
}
