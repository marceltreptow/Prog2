package set08;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DuplicateFileFinder {
    public static void main(String[] args) {
        //FlexibleFileTreeWalker erstellen und DuplicateFileProcesso übergeben
        //Siehe LargeFileFinder
        DuplicateFileProcessor duplicateFileProcessor = new DuplicateFileProcessor();
        FlexibleFileTreeWalker flexibleFileTreeWalker = new FlexibleFileTreeWalker(duplicateFileProcessor);
        try {
            flexibleFileTreeWalker.walk(".");
        } catch (IOException e) {
            e.printStackTrace();
        }
        duplicateFileProcessor.sortAndPrint();
    }


    public static class DuplicateFileProcessor implements FlexibleFileTreeWalker.Fileprocessor{
        //Key = Name der Datei
        //Value = Liste von File Objekten
        //Idee zu jedem Dateinamen speichern wir in einer Liste die File Objekte ab
        private Map<String, List<File>> fileMap = new HashMap<>();;

        @Override
        public void process(File file) {
            //file in die Map(Liste) einfügen
            //fileMap.computeIfPresent(file.getName(),)
            if (!fileMap.containsKey(file.getName())) {
                List<File> list = new ArrayList<File>();
                list.add(file);
                fileMap.putIfAbsent(file.getName(), list);
            } else {
                fileMap.get(file.getName()).add(file);
                //System.out.println("1 " + fileMap.get(file.getName()));
                //System.out.println("2 " + file);

            }
        }

        public void sortAndPrint(){
            //über alle Values der Map iterieren
            //fileMap.values().stream().map(List::size).filter(Integer < 1);
            for(List<File> filelist : fileMap.values()){
                for(File file : filelist) {
                    if(filelist.size() > 1)
                        System.out.println(file.getName() + ": " + file.length() + " Byte");
                }
                //list >= 2? Es könnten Duplicate verhanden sein
                //Liste sortieren damit File Objekte mit der gleichen Größe nebeneinander liegen
                //Dann immer paarweise die Einträge der Liste vergleichen
                //Ist die Größe gleich? Duplikat gefunden --> Ausgabe



            }
        }
    }
}
