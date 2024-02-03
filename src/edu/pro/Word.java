package edu.pro;



/*
  @author   george
  @project   harrry-potter
  @class  Word
  @version  1.0.0 
  @since 03.02.24 - 18.07
*/

public class Word {
    private String body;
    private int freq;

    public Word(String body, int freq) {
        this.body = body;
        this.freq = freq;
    }

    public Word() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "Word{" +
                "body='" + body + '\'' +
                ", freq=" + freq +
                '}';
    }
}
