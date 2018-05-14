package salesmgr.base.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Addresslist {
    private String addresslistid;

    private String addresslistname;

    private String addresslistphone;

    private Date addresslisttime;

    private Integer addresslistsex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    @JSONField(format = "yyyy-MM-dd")
    private Date addresslistbirthday;

    public String getAddresslistid() {
        return addresslistid;
    }

    public void setAddresslistid(String addresslistid) {
        this.addresslistid = addresslistid;
    }

    public String getAddresslistname() {
        return addresslistname;
    }

    public void setAddresslistname(String addresslistname) {
        this.addresslistname = addresslistname;
    }

    public String getAddresslistphone() {
        return addresslistphone;
    }

    public void setAddresslistphone(String addresslistphone) {
        this.addresslistphone = addresslistphone;
    }

    public Date getAddresslisttime() {
        return addresslisttime;
    }

    public void setAddresslisttime(Date addresslisttime) {
        this.addresslisttime = addresslisttime;
    }

    public Integer getAddresslistsex() {
        return addresslistsex;
    }

    public void setAddresslistsex(Integer addresslistsex) {
        this.addresslistsex = addresslistsex;
    }

    public Date getAddresslistbirthday() {
        return addresslistbirthday;
    }

    public void setAddresslistbirthday(Date addresslistbirthday) {
        this.addresslistbirthday = addresslistbirthday;
    }
}