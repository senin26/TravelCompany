package common.solutions.functionaldomainsolutions;

@FunctionalInterface
public interface Replaceable<T, V> {
    void replaceTo(T out,V in);
}
