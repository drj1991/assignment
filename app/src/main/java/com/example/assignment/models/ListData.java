package com.example.assignment.models;

public class ListData {
    private int number;
    private int colorRes;

    public ListData(int number, int colorRes) {
        this.number = number;
        this.colorRes = colorRes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getColorRes() {
        return colorRes;
    }

    public void setColorRes(int colorRes) {
        this.colorRes = colorRes;
    }

    @Override
    public String toString() {
        return "ListData{" +
                "number=" + number +
                ", colorRes=" + colorRes +
                '}';
    }
}
