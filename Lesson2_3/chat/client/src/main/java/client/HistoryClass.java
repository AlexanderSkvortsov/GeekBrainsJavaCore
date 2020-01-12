package client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class HistoryClass {
    private List<String> historyList = new ArrayList<>();
    private String fileName;

    public HistoryClass(String userName) {

        fileName = "history_" + userName+".txt";

        try {
            historyList = Files.readAllLines(Paths.get(fileName ), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getHistoryList() {
        return historyList;
    }

    public String getHistoryContent() {
        StringBuffer str = new StringBuffer();

        for (String s: historyList) {
            str.append(s+"\n");
        }

        return str.toString();
    }

    public void setHistoryLine(String line) {
        historyList.add(line);
        if (historyList.size() > 100) {
            historyList.remove(0);
        }
    }

    public void saveHistoryList(){
        try {
            Files.write(Paths.get(fileName), historyList, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
