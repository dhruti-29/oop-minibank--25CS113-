package service;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import model.annotation.Id;
public class Repository<T> {
    private final HashMap<String,T> data = new HashMap<>();
    public T save(T entity) { data.put(readId(entity), entity); return entity; }
    public T findById(String id) { return data.get(id); }
    public ArrayList<T> findAll() { return new ArrayList<>(data.values()); }
    public boolean delete(String id) { return data.remove(id) != null; }
    @SafeVarargs public final void saveAll(T... items) { for (T item : items) save(item); }
    private String readId(T entity) {
        for (Field f : entity.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Id.class)) try { f.setAccessible(true); return String.valueOf(f.get(entity)); }
            catch (IllegalAccessException e) { throw new IllegalArgumentException(e); }
        }
        throw new IllegalArgumentException("No @Id field found in " + entity.getClass().getSimpleName());
    }
    public static <N extends Number> double average(N[] values) {
        if (values.length == 0) return 0;
        double sum=0; for (N n: values) sum += n.doubleValue(); return sum/values.length;
    }
}