package edu.fsu.cs.mobile.rockpaperscissor;

public class Match {
    String p1Identifier;
    String p2Identifier;
    int p1Choice;
    int p2Choice;
    String lobbyName;
    String winnerIdentifier;

    public Match(String p1Identifier, String p2Identifier, int p1Choice, int p2Choice, String lobbyName) {
        this.p1Identifier = p1Identifier;
        this.p2Identifier = p2Identifier;
        this.p1Choice = p1Choice;
        this.p2Choice = p2Choice;
        this.lobbyName = lobbyName;
    }

    public Match(String p1Identifier, String p2Identifier, int p1Choice, int p2Choice, String lobbyName, String winnerIdentifier) {
        this.p1Identifier = p1Identifier;
        this.p2Identifier = p2Identifier;
        this.p1Choice = p1Choice;
        this.p2Choice = p2Choice;
        this.lobbyName = lobbyName;
        this.winnerIdentifier = winnerIdentifier;
    }

    public String getP1Identifier() {
        return p1Identifier;
    }

    public void setP1Identifier(String p1Identifier) {
        this.p1Identifier = p1Identifier;
    }

    public String getP2Identifier() {
        return p2Identifier;
    }

    public void setP2Identifier(String p2Identifier) {
        this.p2Identifier = p2Identifier;
    }

    public int getP1Choice() {
        return p1Choice;
    }

    public void setP1Choice(int p1Choice) {
        this.p1Choice = p1Choice;
    }

    public int getP2Choice() {
        return p2Choice;
    }

    public void setP2Choice(int p2Choice) {
        this.p2Choice = p2Choice;
    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }


    public String getWinnerIdentifier() {
        return winnerIdentifier;
    }

    public void setWinnerIdentifier(String winnerIdentifier) {
        this.winnerIdentifier = winnerIdentifier;
    }
}
