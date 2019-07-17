package com.ahv.allakumarreddy.lcapplication;

public class Utils {

    private static int mScoreLimit;

    public static int getmScoreLimit(){
        return mScoreLimit;
    }

    public static Player[] getPlayers() {
        return players;
    }

    public static void setPlayers(Player[] players) {
        Utils.players = players;
        names = new String[players.length];
        int i=0;
        for(Player p:players){
            names[i]=p.getName();
            i++;
        }
    }

    private static Player[] players;

    public static String[] getNames() {
        return names;
    }

    public static void setNames(String[] names) {
        Utils.names = names;
    }

    private static String[] names;

    public static void setOutScoreLimit(int scoreLimit) {
        Utils.mScoreLimit = scoreLimit;
    }
}
