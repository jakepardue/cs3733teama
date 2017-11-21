package com.teama.requestsubsystem;

import com.teama.mapsubsystem.data.Location;

public class Request {
    private Location location;
    private RequestType reqType;
    private PriorityLevel priority;
    private String note;
    private String id;
    private boolean fulfilled = false;

    public Request(String id, Location location, RequestType reqType, PriorityLevel priority, String note, boolean fulfilled) {
        this(id, location, reqType, priority, note);
        this.fulfilled = fulfilled;
    }

    public Request(String id, Location location, RequestType reqType, PriorityLevel priority, String note) {
        this.id = id;
        this.location = location;
        this.reqType = reqType;
        this.priority = priority;
        this.note = note;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    };

    public RequestType getReqType() {
        return reqType;
    }

    public void setReqType(RequestType reqType){
        this.reqType = reqType;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public void setPriority(PriorityLevel priority){
        this.priority = priority;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note){
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setFulfilled() { fulfilled = true; }

    public boolean isFulfilled() { return  fulfilled; }

    public String toSQLValues() {
        String f = "FALSE";
        if(fulfilled) {
            f = "TRUE";
        }
        return "'"+getId()+"',"+location.getxCoord()+","+location.getyCoord()+",'"+location.getLevel()+"','"
                +location.getBuilding()+"','"+getReqType().name()+"','"+getPriority()+"','"+getNote()+"','"+f+"'";
    }
    @Override
    public String toString(){
        return reqType +"\n" + id + "\n"+location.toString()+"\n"+note;
    }
}