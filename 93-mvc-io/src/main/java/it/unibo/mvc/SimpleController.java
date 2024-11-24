package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String currentString = null; // NOPMD inizializzazione obbligatoria per evitare stampe
    private final List<String> history = new ArrayList<>();

    @Override
    public void setNextString(final String s) {
        if (s.isBlank() || s.isEmpty()) { 
            throw new IllegalStateException(); 
        }
        this.currentString = s;
    }

    @Override
    public String getNextString() {
        return this.currentString;
    }

    @Override
    public List<String> getHistory() {
        final List<String> list = new ArrayList<>();
        list.addAll(this.history);
        return list;
    }

    @Override
    public void printCurrentString() {
        if (currentString.isBlank() || currentString.isEmpty()) { 
            throw new IllegalStateException(); 
        }
        this.history.add(currentString);
        System.out.println(currentString); // NOPMD Chiede l'esercizio di stampre sullo stdout
        this.currentString = null;
    }
}
