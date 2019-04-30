package hackerrank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Reader {

    public  List<List<Integer>> readInput() throws IOException {

        List<List<Integer>> inputs = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\github\\template\\src\\main\\resources\\input"))) {
            String line = br.readLine();
            System.out.println(String.format("Reading %s elements",line));

            line = br.readLine();
            while (line != null) {
                String[] s = line.split(" ");
                List<Integer> pair =new ArrayList<>();
                pair.add(Integer.valueOf(s[0].trim()));
                pair.add(Integer.valueOf(s[1].trim()));
                inputs.add(pair);
                line = br.readLine();
            }
        }
        return inputs;
    }

    public List<Integer> readOutput() throws IOException {

        List<Integer> output = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\github\\template\\src\\main\\resources\\output"))) {
            String line = br.readLine();
            while (line != null) {
                output.add(Integer.valueOf(line.trim()));
                line = br.readLine();
            }
        }
        return output;
    }

}
