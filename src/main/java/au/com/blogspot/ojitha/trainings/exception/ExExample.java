package au.com.blogspot.ojitha.trainings.exception;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
interface ExFunction<E, F> {
    F apply (E e) throws Throwable;
    static <E, F> Function<E, Optional<F>> wrap (ExFunction<E, F> op){
        return e -> {
            try {
                return Optional.of(op.apply(e));
            } catch (Throwable throwable) {
                return Optional.empty();
            }
        };
    }

}

public class ExExample {

    public static void main(String[] args) {
        Stream.of("a.txt", "b.txt","c.txt")
                .map(ExFunction.wrap(f -> Files.lines(Paths.get(f))))
                .filter(opt -> opt.isPresent()) //filter only the available files
                .flatMap(opt -> opt.get())
                .forEach(r -> System.out.println(r));
    }
}
