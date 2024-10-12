package com.integrado3grupo9.demo.services;

import com.integrado3grupo9.demo.model.entities.Estudiante;
import jakarta.persistence.PersistenceException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.integrado3grupo9.demo.repository.EstudianteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> findAll() {
        return this.repository.findAll();
    }

    /*
     * Este metodo busca los estudiantes ordenados por algun criterio establecido.
     *  El objeto Sort de Spring Boot permite
     * definir como ordenar (desc o asc) y por cual columna de nuestra entidad.
     * Esta variante de findAll(Sort sort)
     * => => la implementa el JpaRepository <= <=
     *
     * @param String order: Indicamos como queremos ordenar la lista
     * @param String field: El tipo de columna es un string porque le interesa unicamente el NOMBRE de
     * la columna (y no el tipo)
     *
     * @details Si el valor del order no es igual a ASC o DESC lanza una excepcion. De la misma forma ocurre si
     * el campo proporcionado no existe como propiedad en la Entidad. El campo debe ser proporcionado tal cual esta
     * en la entidad (no en la base de datos)
     * Dos opciones: o validamos, o capturamos la excepcion
     *
     * @return List<Estudiante>: Lista con los estudiantes obtenidos ordenados por los criterios definidos
     */
    public List<Estudiante> findAllOrderBy(String order, String field) throws PersistenceException {
        List<Estudiante> estudiantes;
        try {
            estudiantes = this.repository.findAll(Sort.by(Sort.Direction.fromString(order.toUpperCase()), field));
        } catch(Exception e) {
            throw new PersistenceException(e.getMessage());
        }

        return estudiantes;
    }

    /* Resuelve ejercicio E
     * Este metodo busca todos los estudiantes por genero
     *
     * @details
     * Si el genero solicitado no existe o simplemente no hay ningun estudiante cargado con dicho genero,
     * la consulta JPQL devuelve null. El metodo es personalizado en el Repositorio porque JpaRepository no tiene
     * un metodo similar
     *
     * @param String genero: Genero solicitado
     *
     * @return List<Estudiante>: Lista con los estudiantes obtenidos por el genero
     */
    public List<Estudiante> findAllByGenero(String genero) {
        return this.repository.findAllByGenero(genero.toUpperCase());
    }

    public Estudiante save(Estudiante estudiante) {
        return this.repository.save(estudiante);
    }

    public Estudiante findById(Long estudianteId) {
        return this.repository.findById(estudianteId).orElse(null);
    }

    /*
     * Este metodo busca un estudiante por su nro de libreta. No existe tal metodo en el JpaRepository
     * por lo cual lo tenemos que implementar (ver repositorio)
     *
     * @param Long nroLibreta: Es el nro de libreta del Estudiante
     *
     * @return Estudiante: Objeto que contiene el registro del estudiante obtenido por su nro de libreta.
     * Si n oexiste devuelve null
     */
    public List<Estudiante> findByNroLibreta(Long nroLibreta) {
        return this.repository.findByNroLibreta(nroLibreta);
    }

    public Estudiante update(Long estudianteId, Estudiante estudiante) {
        Estudiante tmp = this.repository.findById(estudianteId).orElse(null);
        if (tmp != null) {
            tmp.setNombre(estudiante.getNombre());
            tmp.setApellido(estudiante.getApellido());
            tmp.setCiudad(estudiante.getCiudad());
            tmp.setEdad(estudiante.getEdad());
            tmp.setGenero(estudiante.getGenero());
            this.repository.save(tmp);
        }

        return tmp;
    }

    public boolean delete(Long estudianteId) {
        this.repository.deleteById(estudianteId);
        return this.repository.findById(estudianteId).isPresent();
    }

    /* Resuelve ejercicio G
    * */
    public List<Estudiante> findAllByCarreraFilterByCiudad(String ciudad, String nombreCarrera) {
        List<Estudiante> estudiantes = this.repository.findAllByCarreraFilterByCiudad(ciudad, nombreCarrera);
        if (!estudiantes.isEmpty()) {
            return estudiantes;
        }
        return null;
    }


}
