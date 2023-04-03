package set08;

import java.io.File;
import java.io.IOException;
/**
 * Prints recursively all files which are contained in
 * the current directory or in sub-directories.
 * @author Reinhard Schiedermeier, Ruediger Lunde
 */
public class FlexibleFileTreeWalker {
    private Fileprocessor fileprocessor;

    public FlexibleFileTreeWalker(Fileprocessor fileprocessor) {
        this.fileprocessor = fileprocessor;
    }

    public void walk(String pathname) throws IOException {
        File[] files = new File(pathname).listFiles();
        if (files != null) {
            for (File file : files)
                if (file.isDirectory())
                    walk(file.getCanonicalPath());
                else
                    fileprocessor.process(file);

        }
    }

    protected void process(File file) throws IOException {
        System.out.printf("%-100s%6d%n", file.getCanonicalPath(), file.length());

    }

    public interface Fileprocessor{
        void process(File file);

    }
}
