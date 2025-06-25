package aplicacion.logica.registers;

import java.util.Collection;
import java.util.function.Predicate;

public interface Repository<T, C extends Collection<T>> {
    boolean add(T element);

    T delete(T element);

    T update(T element);

    C getIf(Predicate<T> conditions);

    C getAll();
}
