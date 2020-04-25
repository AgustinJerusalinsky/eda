package Qgrams;

import java.util.Arrays;

public class QGram {
    int size;
    public QGram(int i) {
        size=i;
    }

    public void printTokens(String s) {
        System.out.println(Arrays.toString(getTokens(s)));
    }

    public double similarity(String s1, String s2) {
        String[] t1 = getTokens(s1);
        String[] t2 = getTokens(s2);

        return (t1.length+t2.length-countNotShared(t1,t2))/((t1.length+t2.length)*1.0f);
    }

    private int countNotShared(String[] t1, String t2[]){
        int i=0;
        for(int j=0;j<t1.length;j++)i += contains(t2,t1[j])?0:1;
        for(int j=0;j<t2.length;j++)i += contains(t1,t2[j])?0:1;
        return i;
    }

    private boolean contains(String[] arr, String el){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(el)) return true;
        }
        return false;
    }

    private String[] getTokens(String s){
        String border = "";
        for(int i=0;i<size-1;i++){
            border+="#";
        }
        String borderString = border+s+border;
        String[] out = new String[s.length()+size-1];

        for(int i=0;i<s.length()+size-1;i++){
            out[i]=borderString.substring(i,i+size);
        }
        return out;

    }
}
