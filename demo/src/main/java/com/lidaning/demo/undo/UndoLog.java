package com.lidaning.demo.undo;

import java.util.Date;

public class UndoLog {

    private static final long serialVersionUID = 1L;


    private int id;

    private int branchId;

    private String xid;

    private String context;

    private String rollbackInfo;

    private int logStatus;

    private Date logCreated;

    private Date logModified;

    private String ext;



    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getBranchid() {
        return branchId;
    }

    public void setBranchid(int branchId){
        this.branchId = branchId;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid){
        this.xid = xid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context){
        this.context = context;
    }

    public String getRollbackinfo() {
        return rollbackInfo;
    }

    public void setRollbackinfo(String rollbackInfo){
        this.rollbackInfo = rollbackInfo;
    }

    public int getLogstatus() {
        return logStatus;
    }

    public void setLogstatus(int logStatus){
        this.logStatus = logStatus;
    }

    public Date getLogcreated() {
        return logCreated;
    }

    public void setLogcreated(Date logCreated){
        this.logCreated = logCreated;
    }

    public Date getLogmodified() {
        return logModified;
    }

    public void setLogmodified(Date logModified){
        this.logModified = logModified;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext){
        this.ext = ext;
    }


    @Override
    public String toString() {

        return new StringBuilder("")
            .append("id:" + getId()+" ")
            .append("branchId:" + getBranchid()+" ")
            .append("xid:" + getXid()+" ")
            .append("context:" + getContext()+" ")
            .append("rollbackInfo:" + getRollbackinfo()+" ")
            .append("logStatus:" + getLogstatus()+" ")
            .append("logCreated:" + getLogcreated()+" ")
            .append("logModified:" + getLogmodified()+" ")
            .append("ext:" + getExt()+" ")
            .toString();
    }
}