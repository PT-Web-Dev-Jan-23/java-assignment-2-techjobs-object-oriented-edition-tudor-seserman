package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = (name.equals(""))? "Data not available":name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
//        String name = (this.name.equals(""))? "Data not available":this.name;
//        String employer = (this.employer.getValue().equals(""))? "Data not available":this.employer.getValue();
//        String location = (this.location.getValue().equals(""))? "Data not available":this.location.getValue();
//        String positionType = (this.positionType.getValue().equals(""))? "Data not available":this.positionType.getValue();
//        String coreCompetency = (this.coreCompetency.getValue().equals(""))? "Data not available":this.coreCompetency.getValue();

        if(name.equals("Data not available") && employer.toString().equals("Data not available") && location.toString().equals("Data not available") && positionType.toString().equals("Data not available") && coreCompetency.toString().equals("Data not available")){
            return "OOPS! This job does not seem to exist.";
        }
        return
                "\nID: " + this.id +"\n" +
                "Name: " + name + "\n" +
                "Employer: " + employer + "\n"+
                "Location: " + location + "\n"+
                "Position Type: " + positionType + "\n"+
                "Core Competency: " + coreCompetency +"\n"
                ;
    }
}
