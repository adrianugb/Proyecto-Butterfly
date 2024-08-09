package com.Butterfly.services.impl;

import com.Butterfly.dao.UsuarioDao;
import com.Butterfly.domain.Rol;
import com.Butterfly.domain.Usuario;
import com.Butterfly.services.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Se busca el usuario por el username en la tabla usuarios
        Usuario usuario = usuarioDao.findByUsername(username);

        // Se valida si se encontró
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        // Si se encontró el usuario, se carga la imagen del usuario en la sesión
        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario", usuario.getRutaImagen());

        // Se cargan los roles del usuario como roles de seguridad
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol r : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }

        // Se retorna un usuario ya de tipo UserDetails
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
