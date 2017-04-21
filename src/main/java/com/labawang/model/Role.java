package com.labawang.model;

public class Role {
    private Integer id;

    private String rolename;

    private Integer remarks;

    private String savejob;

    private String deletejob;

    private String updatejob;

    private String queryjob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Integer getRemarks() {
        return remarks;
    }

    public void setRemarks(Integer remarks) {
        this.remarks = remarks ;
    }

    public String getSavejob() {
        return savejob;
    }

    public void setSavejob(String savejob) {
        this.savejob = savejob == null ? null : savejob.trim();
    }

    public String getDeletejob() {
        return deletejob;
    }

    public void setDeletejob(String deletejob) {
        this.deletejob = deletejob == null ? null : deletejob.trim();
    }

    public String getUpdatejob() {
        return updatejob;
    }

    public void setUpdatejob(String updatejob) {
        this.updatejob = updatejob == null ? null : updatejob.trim();
    }

    public String getQueryjob() {
        return queryjob;
    }

    public void setQueryjob(String queryjob) {
        this.queryjob = queryjob == null ? null : queryjob.trim();
    }
}