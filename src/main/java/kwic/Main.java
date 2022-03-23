package kwic;

import kwic.filters.Adapter;
import kwic.filters.Selector;
import kwic.filters.Transformer;
import kwic.filters.IO;

import static kwic.filters.IO.READ;

public class Main {
    public static void main(String[] args) {
        String pathTitle = args[0];
        String pathIgnore = args[1];
        String pathRequired = args[2];

        Selector.SelectionInterface fIgnore = Selector.NEW_FILTER_IGNORE(Adapter.ITERATE_KEYWORDS(READ(pathIgnore)));
        Selector.SelectionInterface fRequire = Selector.NEW_FILTER_REQUIRE(Adapter.ITERATE_KEYWORDS(READ(pathRequired)));
        IO.WriterInterface pWriter = IO.NEW_WRITE(pathTitle.replace(".txt", "-output.txt"));

        // outer function takes in output of the inner function
        pWriter.write(Adapter.STRINGIFY(fRequire.filter(fIgnore.filter(Transformer.LEXI((Transformer.SHIFT(Adapter.ITERATE_TITLES(READ(pathTitle)))))))));
    }
}
