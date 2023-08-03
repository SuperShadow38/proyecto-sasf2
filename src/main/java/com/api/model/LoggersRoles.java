package com.api.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users_rol")
@IdClass(LoggersRolesId.class)
@Getter
@Setter
@NoArgsConstructor
public class LoggersRoles {
    @Id
    @Column(nullable = false, length = 20)
    private String usuario;

    @Id
    @Column(nullable = false, length = 20)
    private String rol;

    @Column(name = "granted_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "usuarios", insertable = false, updatable = false)
    private Loggers user;

}
