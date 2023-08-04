package com.api.model;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoggersRolesId implements Serializable {
    private String usuario;
    private String rol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoggersRolesId that)) return false;
        return Objects.equals(usuario, that.usuario) && Objects.equals(rol, that.rol);
    
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, rol);
    }
}
