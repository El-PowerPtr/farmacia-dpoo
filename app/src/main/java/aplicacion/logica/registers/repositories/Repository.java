package aplicacion.logica.registers.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Repository<T> {
    protected Map<Long, T> elements;

    public Repository(Map<Long, T> elements) {
        elements = new HashMap<>();
    }

    public boolean add(long id, T element) {
        if (elements.get(id) == null) {
            return false;
        }
        elements.put(id, element);
        return true;
    }

    public Optional<T> findById(long id) {
        return Optional.ofNullable(elements.get(id));
    }

    public Optional<T> deleteById(long id) {
        return Optional.ofNullable(elements.remove(id));
    }

    public Optional<T> update(long id, T replacement) {
        return Optional.ofNullable(elements.replace(id, replacement));
    }

    public List<T> getIf(Predicate<T> conditions) {
        return elements.values()
                .stream()
                .filter(conditions)
                .collect(Collectors.toList());
    }

    public List<T> getAll() {
        return elements.values()
                .stream()
                .collect(Collectors.toList());
    }
}
