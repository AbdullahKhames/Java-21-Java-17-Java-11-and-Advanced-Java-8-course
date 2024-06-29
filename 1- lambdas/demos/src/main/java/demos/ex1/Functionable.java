package demos.ex1;
@FunctionalInterface

public interface Functionable <T, R>{
    R applyThis(T t);
}
