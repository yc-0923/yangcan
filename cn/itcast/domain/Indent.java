package cn.itcast.domain;

import java.util.Date;

public class Indent {
  private String id;
  private String idate;
  private String idesc;
  private String status;
  private String cid;//用户的用户名

    @Override
    public String toString() {
        return "Indent{" +
                "id='" + id + '\'' +
                ", idate='" + idate + '\'' +
                ", idesc='" + idesc + '\'' +
                ", status='" + status + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdate() {
        return idate;
    }

    public void setIdate(String idate) {
        this.idate = idate;
    }

    public String getIdesc() {
        return idesc;
    }

    public void setIdesc(String idesc) {
        this.idesc = idesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
