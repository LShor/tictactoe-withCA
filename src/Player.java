// Player class to represent the players
class Player {
    private char marker;
    private String name;

    public Player(char marker, String name) {
        this.marker = marker;
        this.name = name;
    }

    public char getMarker() {
        return marker;
    }

    public String getName() {
        return name;
    }
}