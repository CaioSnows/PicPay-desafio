package com.carteiradesafio.carteiraapi.dto;


public class UserDTO {

    private final Long idDoUser;
    private final String nomeDoUser;
    private final String cpfDoUser;
    private final String emailDoUser;

    public UserDTO(Long idDoUser, String nomeDoUser, String cpfDoUser, String emailDoUser){
        this.idDoUser = idDoUser;
        this.nomeDoUser = nomeDoUser;
        this.cpfDoUser = cpfDoUser;
        this.emailDoUser = emailDoUser;
    }

    public Long getIdDoUser() {
        return idDoUser;
    }

    public String getNomeDoUser() {
        return nomeDoUser;
    }

    public String getCpfDoUser() {
        return cpfDoUser;
    }

    public String getEmailDoUser() {
        return emailDoUser;
    }
}
