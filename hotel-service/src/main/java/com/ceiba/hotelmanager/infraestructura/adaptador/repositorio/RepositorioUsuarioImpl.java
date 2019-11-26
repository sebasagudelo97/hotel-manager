package com.ceiba.hotelmanager.infraestructura.adaptador.repositorio;

        import com.ceiba.hotelmanager.dominio.modelo.Usuario;
        import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioUsuario;
        import com.ceiba.hotelmanager.infraestructura.convertidor.usuario.ConvertidorUsuario;
        import com.ceiba.hotelmanager.infraestructura.entidad.UsuarioEntidad;
        import com.ceiba.hotelmanager.infraestructura.repositoriojpa.RepositorioUsuarioJpa;
        import org.modelmapper.ModelMapper;
        import org.springframework.stereotype.Repository;

        import java.util.ArrayList;
        import java.util.List;

@Repository
public class RepositorioUsuarioImpl implements RepositorioUsuario {

    private ModelMapper modelMapper = new ModelMapper();
    private ConvertidorUsuario convertidorUsuario=new ConvertidorUsuario();
    private RepositorioUsuarioJpa repositorioUsuarioJpa;


    public RepositorioUsuarioImpl(RepositorioUsuarioJpa repositorioUsuarioJpa){
        this.repositorioUsuarioJpa=repositorioUsuarioJpa;
    }

    @Override
    public void guardar(Usuario usuario){
        UsuarioEntidad usuarioEntidad = modelMapper.map(usuario,UsuarioEntidad.class);
        repositorioUsuarioJpa.save(usuarioEntidad);
    }

    @Override
    public boolean existe(Usuario usuario) {
        Long cedulaIngresada = usuario.getCedulaCiudadania();
        return  (repositorioUsuarioJpa.filtroPorCedulaUsuario(cedulaIngresada)) != null;
    }

    @Override
    public Usuario obtenerIdUsuarioByNumeroCedula(Long numeroCedula) {
        UsuarioEntidad usuarioEntidad = repositorioUsuarioJpa.filtroPorCedulaUsuario(numeroCedula);
        return modelMapper.map(usuarioEntidad,Usuario.class);
    }

    @Override
    public List<Usuario> listar() {
        List<UsuarioEntidad> listUsuarioEntidad = repositorioUsuarioJpa.findAll();
        List<Usuario> listUsuario = new ArrayList<>();
        return convertidorUsuario.convertirListUsuarioEntidadAListUsuario(listUsuarioEntidad,listUsuario);
    }

    @Override
    public UsuarioEntidad obtenerUsuarioEntidadByNumeroCedula(Long numeroCedula) {
        return repositorioUsuarioJpa.filtroPorCedulaUsuario(numeroCedula);
    }

    @Override
    public void eliminar(Long numeroCedula) {
        UsuarioEntidad usuarioEntidad = repositorioUsuarioJpa.filtroPorCedulaUsuario(numeroCedula);
        repositorioUsuarioJpa.delete(usuarioEntidad);
    }
}
