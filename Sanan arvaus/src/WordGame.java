
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class WordGame {
    
    private ArrayList<String> lista = new ArrayList<>();
    private WordGameState betterWork;
    private String word;
    private String guessed;

    
    static class WordGameState{
        private boolean state;
        private String word;
        private int mistakes;
        private int mistakeLimit;
        private int missingChars;

        public String getWord() {
            return word;
        }

        public int getMistakes() {
            return mistakes;
        }

        public int getMistakeLimit() {
            return mistakeLimit;
        }

        public int getMissingChars() {
            return missingChars;
        }

        private WordGameState(boolean state, String word, int mistakes, int mistakeLimit, int missingChars) {
            this.state = state;
            this.word = word;
            this.mistakes = mistakes;
            this.mistakeLimit = mistakeLimit;
            this.missingChars = missingChars;
        }
    }

    public WordGame(String wordFilename)throws IOException {
        var file = new BufferedReader(new FileReader(wordFilename));
        String a;
        while ((a = file.readLine()) != null){
            lista.add(a);
        }
        this.betterWork = new WordGameState(false,null, 0 ,0 , 0);
        
    }
    
    public void initGame(int wordIndex, int mistakeLimit)throws GameStateException{
        String str = "_";
        this.betterWork.mistakeLimit = mistakeLimit;
        this.betterWork.word = str.repeat(lista.get(wordIndex % lista.size()).length());
        this.betterWork.state = true;
        this.betterWork.missingChars = lista.get(wordIndex % lista.size()).length();
        this.betterWork.mistakes = 0;
        
        word = lista.get(wordIndex % lista.size());
        this.guessed = "";
        
    }
    
    public boolean isGameActive() throws GameStateException{
        return this.betterWork.state;
    }
    
    public WordGameState getGameState() throws GameStateException{
        if (this.isGameActive()){
            return this.betterWork; 
        }else{
            throw new GameStateException("There is currently no active word game!");
        }
    }
    
    public WordGameState guess(char c) throws GameStateException{
        if (this.isGameActive()){
            StringBuilder temp = new StringBuilder(this.betterWork.word);
            char ct = Character.toLowerCase(c);
            if (this.word.contains(String.valueOf(ct)) && !guessed.contains(String.valueOf(ct))){
                    guessed += ct;
                    
                    for (int i = 0; i < this.word.length(); i++){
                        if (this.word.charAt(i) == ct){
                            temp.setCharAt(i, ct);
                            this.betterWork.missingChars -= 1;
                            if (this.betterWork.missingChars == 0){
                                this.betterWork.word = this.word;
                                this.betterWork.state = false;
                            }
                        }
                    }
                    this.betterWork.word = temp.toString();
            }else{
                this.betterWork.mistakes += 1;
                if (this.betterWork.mistakes > this.betterWork.mistakeLimit){
                    this.betterWork.word = this.word;
                    this.betterWork.state = false;
                }
            }
            return this.betterWork;
        }else{
            throw new GameStateException("There is currently no active word game!");
        }
    }
    
    public WordGameState guess(String c) throws GameStateException{
        if (this.isGameActive()){
            if (c.equals(this.word)){
                this.betterWork.missingChars = 0;
                this.betterWork.word = this.word;
                this.betterWork.state = false;
            }else{
                this.betterWork.mistakes += 1;
                if (this.betterWork.mistakes > this.betterWork.mistakeLimit){
                    this.betterWork.word = this.word;
                    this.betterWork.state = false;
                }
            }
            return this.betterWork;
        }else{
            throw new GameStateException("There is currently no active word game!");
        } 
    }
    
}
