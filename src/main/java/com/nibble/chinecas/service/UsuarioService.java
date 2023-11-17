package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Usuario;
import com.nibble.chinecas.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IService<Usuario, String>{

    @Autowired
    private IUsuarioRepository data;

    @Override
    public List<Usuario> obtenerTodos() {
        return (List<Usuario>) data.findAll();
    }

    @Override
    public Optional<Usuario> obtener(String id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Usuario t) {
        int res=0;
        Usuario usuario=data.save(t);
        if(!usuario.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(String id) {
        data.deleteById(id);
    }
    

    /**
     * Autentica un usuario verificando su login y clave.
     * 
     * @param usuario El usuario a autenticar.
     * @return El usuario autenticado o null si la autenticación falla.
     */
    public Usuario autenticar(Usuario usuario){
        Usuario usuarioAutenticado = null;
        
        // Buscar el usuario en la base de datos por su login
        Optional<Usuario> usuarioOptional = data.findById(usuario.getLogin());
        
        if(usuarioOptional.isPresent()){
            usuarioAutenticado = usuarioOptional.get();
            
            // Verificar si la clave del usuario coincide
            if(!usuarioAutenticado.getClave().equals(usuario.getClave())){
                usuarioAutenticado = null;
            }
        }
        
        return usuarioAutenticado;
    }

}
