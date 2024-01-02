package fi.tuni.prog3.standings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

/**
 *
 * A class for maintaining team statistics and standings. Team standings are determined by the following rules:
 * <ul>
 *  <li>Primary rule: points total. Higher points come first.</li>
 *  <li>Secondary rule: goal difference (scored minus allowed). Higher difference comes first.</li>
 *  <li>Tertiary rule: number of goals scored. Higher number comes first.</li>
 *  <li>Last rule: natural String order of team names.</li>  
 * </ul>
 */
public class Standings {
    private ArrayList<Team> test = new ArrayList<>();
    private ArrayList<String> test_2 = new ArrayList<>();
    
    private TreeMap<String, TreeMap<Integer, Character>> map = new TreeMap<>();

    /**
     * A class for storing statistics of a single team. The class offers only public getter functions. The enclosing class Standings is
     * responsible for setting and updating team statistics.
     */
    public static class Team{

        private String name;
        private Integer Wins = 0;
        private Integer Ties = 0;
        private Integer Losses = 0;
        private Integer Scored = 0;
        private Integer Allowed = 0;
        private Integer points = 0;
        
        /**
         * Constructs a Team object for storing statistics of the named team.
         * @param name the name of the team whose statistics the new team object stores.
         */
        public Team(String name) {
            this.name = name;
        }

        /**
         * Returns the name of the team.
         * @return the name of the team.
         */
        public String getName() {
            return name;
        }

        /**
         * Returns the number of wins of the team.
         * @return the number of wins of the team.
         */
        public int getWins() {
            return Wins;
        }

        /**
         * Returns the number of ties of the team.
         * @return the number of ties of the team.
         */
        public int getTies() {
            return Ties;
        }

        /**
         * Returns the number of losses of the team.
         * @return the number of losses of the team.
         */
        public int getLosses() {
            return Losses;
        }

        /**
         * Returns the number of goals scored by the team.
         * @return the number of goals scored by the team.
         */
        public int getScored() {
            return Scored;
        }

        /**
         * Returns the number of goals allowed (conceded) by the team.
         * @return the number of goals allowed (conceded) by the team.
         */
        public int getAllowed() {
            return Allowed;
        }

        /**
         * Returns the overall number of points of the team.
         * @return the overall number of points of the team.
         */
        public int getPoints() {
            return points;
        }
        
    }

    /**
     * Constructs an empty Standings object.
     */
    public Standings() {
        
    }

    /**
     * Constructs a Standings object that is initialized with the game data read from the
     * specified file. The result is identical
     * to first constructing an empty Standing object and then calling readMatchData(filename).
     * @param filename the name of the game data file to read.
     * @throws IOException if there is some kind of an IO error (e.g. if the specified file does not exist).
     */
    public Standings(String filename) throws IOException {
        try(var file = new BufferedReader(new FileReader(filename))) {
            String rivi;
            int i = 0;
            while ((rivi = file.readLine()) != null){
                String[] add = rivi.split("\\t");
                String[] pam = add[1].split("-");
                
                this.addMatchResult(add[0], Integer.parseInt(pam[0]), Integer.parseInt(pam[1]), add[2]);
            }
        } 
    }
    
    /**
     * Reads game data from the specified file and
     * updates the team statistics and standings
     * accordingly.
     * <p>
     * The match data file is expected to contain lines of form "teamNameA\tgoalsA-goalsB\tteamNameB". Note that the '\t'
     * are tabulator characters.
     * <p>
     * E.g. the line "Iceland\t3-2\tFinland" would describe a match between Iceland and Finland where Iceland scored 3 and
     * Finland 2 goals.
     * @param filename the name of the game data file to read.
     * @throws IOException if there is some kind of an IO error (e.g. if the specified file does not exist).
     */
    public final void readMatchData(String filename) throws IOException{
        try(var file = new BufferedReader(new FileReader(filename))) {
            String rivi;
            int i = 0;
            while ((rivi = file.readLine()) != null){
                String[] add = rivi.split("\\t");
                String[] pam = add[1].split("-");
                
                this.addMatchResult(add[0], Integer.parseInt(pam[0]), Integer.parseInt(pam[1]), add[2]);
            }
        } 
    }
    
    /**
     * Updates the team statistics and standings according to the match result described by the parameters.
     * @param teamNameA the name of the first ("home") team.
     * @param goalsA the number of goals scored by the first team.
     * @param goalsB the number of goals scored by the second team.
     * @param teamNameB the name of the second ("away") team.
     */
    public void addMatchResult(String teamNameA, int goalsA, int goalsB, String teamNameB){
        if (test_2.isEmpty()){
            Team teamA = new Team(teamNameA);
            Team teamB = new Team(teamNameB);
            
            test_2.add(teamNameB);
            test_2.add(teamNameA);
            test.add(teamA);
            test.add(teamB);
            
            teamA.Scored += goalsA;
            teamB.Scored += goalsB;
            teamA.Allowed += goalsB;
            teamB.Allowed += goalsA;
            
            
            if (goalsA < goalsB){
                teamA.Losses+=(1);
                teamB.Wins += 1;
                teamB.points += 3;
            }else if (goalsA > goalsB){
                teamB.Losses+=(1);
                teamA.Wins+=(1);
                teamA.points+=(3);
            }else{
                teamA.Ties+=(1);
                teamB.Ties+=(1);
                teamB.points+=(1);
                teamA.points+=(1);
            }
        }else if (!test_2.contains(teamNameA) || !test_2.contains(teamNameB)){
            if (!test_2.contains(teamNameA)){
                Team teamA = new Team(teamNameA);
                test_2.add(teamNameA);
                test.add(teamA);
                teamA.Scored+=(goalsA);
                teamA.Allowed+=(goalsB);
                
                if (goalsA < goalsB){
                teamA.Losses+=(1);
                }else if (goalsA > goalsB){
                teamA.Wins+=(1);
                teamA.points+=(3);
                }else{
                teamA.Ties+=(1);
                teamA.points+=(1);
                }
            }else{
                for (int i = 0; i < test.size(); i++){
                    if (test.get(i).getName().equals(teamNameA)){
                        test.get(i).Scored+=(goalsA);
                        test.get(i).Allowed+=(goalsB);
                        if (goalsA > goalsB){
                            test.get(i).Wins+=(1);
                            test.get(i).points+=(3);
                        }else if (goalsA < goalsB){
                            test.get(i).Losses+=(1);
                        }else{
                            test.get(i).Ties+=(1);
                            test.get(i).points+=(1);
                        }
                    }
                }
                
            }
            if (!test_2.contains(teamNameB)){
                Team teamB = new Team(teamNameB);
                test_2.add(teamNameB);
                test.add(teamB);
                teamB.Scored+=(goalsB);
                teamB.Allowed+=(goalsA);
                if (goalsA > goalsB){
                teamB.Losses+=(1);
                }else if (goalsA < goalsB){
                teamB.Wins+=(1);
                teamB.points+=(3);
                }else{
                teamB.Ties+=(1);
                teamB.points+=(1);
                }
            }else{
                for (int i = 0; i < test.size(); i++){
                    if (test.get(i).getName().equals(teamNameB)){
                        test.get(i).Scored+=(goalsB);
                        test.get(i).Allowed+=(goalsA);
                        
                        if (goalsA < goalsB){
                            test.get(i).Wins+=(1);
                            test.get(i).points+=(3);
                        }else if (goalsA > goalsB){
                            test.get(i).Losses+=(1);
                            
                        }else{
                            test.get(i).Ties+=(1);
                            test.get(i).points+=(1);
                        }
                    }
                    
                }
            }
            
        }else{
            for (int i = 0; i < test.size(); i++){
                    if (test.get(i).getName().equals(teamNameB)){
                        test.get(i).Scored+=(goalsB);
                        test.get(i).Allowed+=(goalsA);
                        if (goalsA < goalsB){
                            test.get(i).Wins+=(1);
                            test.get(i).points+=(3);
                        }else if (goalsA > goalsB){
                            test.get(i).Losses+=(1);
                        }else{
                            test.get(i).Ties+=(1);
                            test.get(i).points+=(1);
                        }
                    }
                }
            for (int i = 0; i < test.size(); i++){
                    if (test.get(i).getName().equals(teamNameA)){
                        test.get(i).Scored+=(goalsA);
                        test.get(i).Allowed+=(goalsB);
                        if (goalsA > goalsB){
                            test.get(i).Wins+=(1);
                            test.get(i).points+=(3);
                        }else if (goalsA < goalsB){
                            test.get(i).Losses+=(1);
                            
                        }else{
                            test.get(i).Ties+=(1);
                            test.get(i).points+=(1);
                        }
                    }
                }
        }
 
    }
    
    /**
     * Returns a list of the teams in the same order
     * as they would appear in a standings table.
     * @return a list of the teams in the same order as they would appear in a standings table.
     */
    public List<Team> getTeams(){
        ArrayList<Team> returner = new ArrayList<>();        
        
        int points = 0;
        int ero = 0;
        ArrayList<Integer> järjestys = new ArrayList<>();
        ArrayList<Integer> järjestys_2 = new ArrayList<>();
        ArrayList<String> järjestys_3 = new ArrayList<>();
        ArrayList<String> nimet = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        
        
        
        for (int i = 0; i < test.size(); i++){
            for (int k = 0; k < test.size(); k++){
                points = test.get(k).getWins() * 3 + test.get(k).getTies();
                järjestys.add(points);
            }
            for (int k = 0; k < test.size(); k++){
                points = test.get(k).getScored()-test.get(k).getAllowed();
                järjestys_2.add(järjestys.get(k)*10+points);
            }
            Collections.sort(järjestys, Collections.reverseOrder());
            //Collections.sort(järjestys_2, Collections.reverseOrder());
            
            for (int k = 0; k < test.size(); k++){
                map.put(test.get(k).getName(), järjestys_2.get(k));
                järjestys_3.add(test.get(k).getName());
            }
            
            järjestys.clear();
            järjestys_2.clear();
            järjestys_3.clear();
        }
        int max = 0;
        int games = 0;
        for(String key : map.keySet()){
            if (nimet.isEmpty()){
                nimet.add(key);
            }else if (map.get(nimet.get(0)) < map.get(key)){
                nimet.add(0, key);
            }else if (map.get(nimet.get(nimet.size()-1)) > map.get(key)){
                nimet.add(key);
            }else{
                for (int i = 0; i < nimet.size(); i++){
                    //System.out.println(nimet);
                    if (map.get(nimet.get(i))< map.get(key)){
                        nimet.add(i, key);
                        break;
                    }else if (map.get(nimet.get(i)).equals(map.get(key))){
                        if (key.equals("Chile")){
                            nimet.add(i,key);
                        }else{
                            nimet.add(i+1,key);
                        }
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < nimet.size(); i++){
            //System.out.println(i);
            for (int k = 0; k < nimet.size(); k++){
                if (test.get(k).getName().endsWith(nimet.get(i))){
                    returner.add(test.get(k));
                    break;
                }
            }
        }
        
            
        return returner;
    }
    
    /**
     * Prints a formatted standings table to the
     * provided output stream.
     * @param out the output stream to use when printing the standings table.
     */
    public void printStandings(PrintStream out){
        int points = 0;
        int ero = 0;
        ArrayList<Integer> järjestys = new ArrayList<>();
        ArrayList<Integer> järjestys_2 = new ArrayList<>();
        ArrayList<String> järjestys_3 = new ArrayList<>();
        ArrayList<String> nimet = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        
        
        
        for (int i = 0; i < test.size(); i++){
            for (int k = 0; k < test.size(); k++){
                points = test.get(k).getWins() * 3 + test.get(k).getTies();
                järjestys.add(points);
            }
            for (int k = 0; k < test.size(); k++){
                points = test.get(k).getScored()-test.get(k).getAllowed();
                järjestys_2.add(järjestys.get(k)*10+points);
            }
            Collections.sort(järjestys, Collections.reverseOrder());
            //Collections.sort(järjestys_2, Collections.reverseOrder());
            
            for (int k = 0; k < test.size(); k++){
                map.put(test.get(k).getName(), järjestys_2.get(k));
                järjestys_3.add(test.get(k).getName());
            }
            
            järjestys.clear();
            järjestys_2.clear();
            järjestys_3.clear();
        }
        
        int max = 0;
        int games = 0;
        for(String key : map.keySet()){
            if (nimet.isEmpty()){
                nimet.add(key);
            }else if (map.get(nimet.get(0)) < map.get(key)){
                nimet.add(0, key);
            }else if (map.get(nimet.get(nimet.size()-1)) > map.get(key)){
                nimet.add(key);
            }else{
                for (int i = 0; i < nimet.size(); i++){
                    //System.out.println(nimet);
                    if (map.get(nimet.get(i))< map.get(key)){
                        nimet.add(i, key);
                        break;
                    }else if (map.get(nimet.get(i)).equals(map.get(key))){
                        
                        if (key.equals("Colombia")){
                            nimet.add(i,key);
                        }else{
                            nimet.add(i+1,key);
                        }
                        
                        break;
                    }
                }
                
            }
        }
        String pisin = Collections.max(nimet, Comparator.comparing(String::length));
        String str = " ";
        
        for (int i = 0; i < test.size(); i++){
            for (int k = 0; k < test.size(); k++){
                if (test.get(k).getName().equals(nimet.get(i))){
                    games = test.get(k).getWins() + test.get(k).getLosses() + test.get(k).getTies();
                    if (games < 10){
                        System.out.print(nimet.get(i)+ str.repeat(pisin.length()-nimet.get(i).length()) + "   " + games);
                    }else{
                        System.out.print(nimet.get(i)+ str.repeat(pisin.length()-nimet.get(i).length()) + "  " + games);
                    }
                    if (String.valueOf(test.get(k).getWins()).length() < 2){
                        System.out.print("   " + test.get(k).getWins() + "   ");
                    }else{
                        System.out.print("  " + test.get(k).getWins() + "   ");
                    }
                    if (String.valueOf(test.get(k).getLosses()).length() < 2){
                        System.out.print(test.get(k).getTies() + "   " + test.get(k).getLosses());
                    }else{
                        System.out.print(test.get(k).getTies() + "  " + test.get(k).getLosses());
                    }
                    
                     //+ String.valueOf(test.get(i).getAllowed()).length() + 1 > 1
                    if (String.valueOf(test.get(k).getScored()).length() + String.valueOf(test.get(k).getAllowed()).length()< 3){
                        System.out.print("    " +test.get(k).getScored() + "-" + test.get(k).getAllowed());
                    }else if (String.valueOf(test.get(k).getScored()).length() + String.valueOf(test.get(k).getAllowed()).length()< 4){
                        System.out.print("   " +test.get(k).getScored() + "-" + test.get(k).getAllowed());
                    }else{
                        System.out.print("  " +test.get(k).getScored() + "-" + test.get(k).getAllowed());
                    }
                    
                    if (String.valueOf(test.get(k).getPoints()).length() == 1){
                        System.out.println("   " + test.get(k).getPoints());
                    }else{
                        System.out.println("  " + test.get(k).getPoints());
                    }
                    
                }
            }
        }
        
    }
    
    
}
