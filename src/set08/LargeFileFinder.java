package set08;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargeFileFinder {
    public static void main(String[] args) throws IOException {
        LargeFileProcessor largeFileProcessor = new LargeFileProcessor();
        FlexibleFileTreeWalker flexibleFileTreeWalker = new FlexibleFileTreeWalker(largeFileProcessor);
        try {
            flexibleFileTreeWalker.walk(".");
        } catch (IOException e) {
            e.printStackTrace();
        }
        largeFileProcessor.sortAndPrint();
    }

    private static class LargeFileProcessor implements FlexibleFileTreeWalker.Fileprocessor {
        private List<File> filesList;

        public LargeFileProcessor(){
            filesList = new ArrayList<>();

        }

        @Override
        public void process(File file) {
            //file in die Liste einfügen
            filesList.add(file);

        }

        public void sortAndPrint() throws IOException {
            //Sortieren und dann ausgeben
            Collections.sort(filesList, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return (int)(o1.length() - o2.length());
                }
            });
            for(File file : filesList){
                System.out.println(file.getName() + ": " + file.length() + " Byte");

            }

            /*filesList.stream().forEach(System.out::println);
            filesList.stream().map(file -> {
                try {
                    return Files.size(file.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return 0;
            }).forEach(System.out::println);

             */

        }
    }
}
