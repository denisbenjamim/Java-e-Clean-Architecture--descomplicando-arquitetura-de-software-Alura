package br.com.alura.escola.infra.aluno;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.alura.escola.dominio.aluno.CifradorSenha;


public class CifradorSenhaMD5 implements CifradorSenha{

    @Override
    public String cifrarSenha(String senha) {
      try {
         MessageDigest digest = MessageDigest.getInstance("MD5");
         digest.update(senha.getBytes());
         byte [] bytes = digest.digest();
         StringBuilder builder = new StringBuilder();
         for(int i = 0 ; i <  bytes.length; i++){
            builder.append(Integer.toString((bytes[i] & 0xff ) + 0x100, 16).substring(1));
         }
         return builder.toString();
      } catch (NoSuchAlgorithmException e) {
       throw new RuntimeException("Erro ao tenta cifrar senha");
      }
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return senhaCifrada.equals(cifrarSenha(senha));
    }

}
