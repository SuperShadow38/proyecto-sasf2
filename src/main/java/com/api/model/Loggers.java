package com.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios_roles")
public class Loggers {

    @Id
    @Column(name = "usuarios", length = 20)
    private String usuario;

    @Email
    @Column(name = "email_usuarios", length = 30)
    private String email_usuarios;

    @Column(name = "contraseña")
    private String contraseña_usuarios;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<LoggersRoles> roles;
}
