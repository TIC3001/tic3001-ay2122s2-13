package kwic.kwicio;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class Writer {
    public static WriterInterface NEW_WRITE(String pathString) {
        return output -> {
            try {
                Files.write(Path.of(pathString), output.getBytes(StandardCharsets.UTF_8));
            } catch (Exception ignored) {
            }
        };
    }
}
