package co.javeriana.taller.Libros.Libro.Infrastructure.Adapters;


import co.javeriana.taller.Shared.Infrastruture.Hibernate.HibernateRepository;
import co.javeriana.taller.Libros.Libro.Domain.Ports.LibroRepository;
import co.javeriana.taller.Libros.Libro.Domain.Libro;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroNombreAutor;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateLibroRepository extends HibernateRepository<Libro> implements LibroRepository {

    public HibernateLibroRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Libro.class);
    }

    @Override
    public void save(Libro libro) {
        persist(libro);
    }

    @Override
    public void update(Libro libro) {
        updateEntity(libro);
    }

    @Override
    public Optional<Libro> find(LibroId libroId) {
        return byId(libroId);
    }

    @Override
    public Optional<List<Libro>> findByNombreAutor(LibroNombreAutor libroNombreAutor) {
        Libro libro = null;
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Libro> cr = cb.createQuery(Libro.class);
        Root<Libro> root = cr.from(Libro.class);
        cr.select(root).where(cb.equal(root.get("libroNombreAutor"), libroNombreAutor));
        List<Libro> libros = sessionFactory.getCurrentSession().createQuery(cr).getResultList();
        /*
        if(!libros.isEmpty()){
            libro = libros.get(0);
        }
         */
        return  Optional.ofNullable(libros);
    }

    @Override
    public Optional<List<Libro>> all() {
        return getAll();
    }

    @Override
    public void delete(Libro user) {
        deleteEntity(user);
    }
}
