package planner.naive;

import java.util.HashMap;
import java.util.Map;

public class Office {
    public String name;
    public int column;
    public int row;
    private boolean isDirty;
    public boolean hasRobot;
    public Map<String, Box> boxes;
    private Map<String, Office> adjacent_offices;

    public Office(int column, int row) {
        // TODO Auto-generated constructor stub
        this.column = column;
        this.row = row;
        this.adjacent_offices = new HashMap<String, Office>();
        this.boxes = new HashMap<String, Box>();

    }

    public boolean addBox(String key, Box box) {
        if (this.boxes.containsKey(key)) {
            this.boxes.put(key, box);
            return true;
        } else {
            return false;
        }

    }


    public boolean deleteBox(String key) {
        if (this.boxes.containsKey(key)) {
            this.boxes.remove(key);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     */
    public boolean deleteAllBox() {
        boolean hasRemoved = false;
        for (String key : boxes.keySet()) {
            boxes.remove(key);
            hasRemoved = true;
        }
        return hasRemoved;
    }

    public boolean isEmptyBox() {
        return this.boxes.size() == 0;
    }

    public void addAjacentOffice(String key, Office office) {

        System.out.println(this.name + " Add: " + key);
        this.adjacent_offices.put(key, office);
    }

    /**
     * Returns true if it has flipped the flag
     *
     * @return
     */
    public boolean setDirty() {
        System.out.print("setDirty");
        if (this.isDirty != true) {
            this.isDirty = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if it has flipped a flag
     *
     * @return
     */
    public boolean setClean() {
        System.out.print("setClean");
        if (this.isDirty != false) {
            this.isDirty = false;
            return true;
        } else {
            return false;
        }
    }

    public void prettyPrint() {

        // System.out.format("%1s-%1s :%-5s : %10s : %10s : %10s\n", this.row, this.column, this.name, this.boxes.size(), this.isDirty, this.hasRobot);
        System.out.format("%2d - %1d     :%1s    :%7s     :    %s   :    %s\n", this.row, this.column, this.name, this.boxes.size(), this.isDirty, this.hasRobot);

    }
}