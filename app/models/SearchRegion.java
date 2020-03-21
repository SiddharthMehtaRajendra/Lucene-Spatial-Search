/*
 * This project is the sole property of Siddharth Mehta. It may not be duplicated or reproduced without my consent. Please direct all technical queries to mehtasiddharth@hotmail.co.uk
 */

package models;

public class SearchRegion {

    public class Pair{
        int year;
        int month;

        public Pair(int year, int month){
            this.year = year;
            this.month = month;
        }

        public int getMonth() {
            return month;
        }

        public int getYear() {
            return year;
        }
    }

    private Pair source;
    private Pair destination;

    public Pair getSource() {
        return source;
    }

    public void setSource(int year, int month) {
        this.source = new Pair(year, month);
    }

    public Pair getDestination() {
        return destination;
    }

    public void setDestination(int year, int month) {
        this.destination = new Pair(year, month);
    }
}
