package by.epamlab.beans;

import java.util.List;

public class HistoryRecord {

    private String result;
    private List<String> attempts;

    public HistoryRecord(String result, List<String> attempts) {
        this.result = result;
        this.attempts = attempts;
    }

    public HistoryRecord() {
    }

    public List<String> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<String> attempts) {
        this.attempts = attempts;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result + " " + attempts;
    }
}
