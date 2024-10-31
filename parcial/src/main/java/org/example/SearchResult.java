package org.example;

public class SearchResult {
    private String operation;
    private String inputlist;
    private String value;
    private int output;

    public SearchResult(String operation, String inputlist, String value, int output) {
        this.operation = operation;
        this.inputlist = inputlist;
        this.value = value;
        this.output = output;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getInputlist() {
        return inputlist;
    }

    public void setInputlist(String inputlist) {
        this.inputlist = inputlist;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}