package Day19Task1;

import com.sun.source.tree.WhileLoopTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task19_1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dushi.txt");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("[.,:;()?!\\\"\\\\s–]+");

        Map<String, Integer> map = new HashMap<>();

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            //System.out.println(line);

            if (!line.trim().equals("")){
                String[] wordSplit = line.split(" ");
                for (String word: wordSplit){
                    if (word == null || word.trim().equals("") || word.trim().equals("–")){
                        continue;
                    }
                    //word = word.replaceAll("[,.+*/\\-;:()?!'\\[]]", "");
                    word = word.replace(",", "");
                    word = word.replace(".", "");
                    word = word.replace(":", "");
                    word = word.replace(";", "");
                    word = word.replace("(", "");
                    word = word.replace(")", "");
                    word = word.replace("?", "");
                    word = word.replace("!", "");
                    word = word.replace("+", "");
                    word = word.replace("-", "");
                    word = word.replace("*", "");
                    word = word.replace("/", "");
                    word = word.replace("'", "");
                    word = word.replace("[", "");
                    word = word.replace("]", "");
                    word = word.replace("}", "");
                    word = word.replace("{", "");
                    if (map.containsKey(word)){
                        map.put(word, map.get(word) + 1);
                    } else{
                        map.put(word, 1);
                    }
                }
            }

        }
        System.out.println(map);


        List<Map.Entry<String, Integer>> statistics = new ArrayList<>(map.entrySet());
        Collections.sort(statistics, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> one, Map.Entry<String, Integer> another) {
                return - one.getValue().compareTo(another.getValue());
            }
        });

        List<Map.Entry<String, Integer>> topHundred = statistics.subList(0,100);
        for (Map.Entry<String, Integer> word : topHundred){
            System.out.println(word.getKey() + " : " + word.getValue()
            );
        }



    }
}
