package salesmgr.base.model;

import java.util.Date;

public class Userinfo {
    private String userid;

    private String username;

    private String password;

    private String realname;

    private Date createtime;

    private Float wages;

    private Integer usertype;

    private String userheadimgurl;

    private String phone;

    private String address;

    private String cardid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Float getWages() {
        return wages;
    }

    public void setWages(Float wages) {
        this.wages = wages;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getUserheadimgurl() {
        return userheadimgurl;
    }

    public void setUserheadimgurl(String userheadimgurl) {
        this.userheadimgurl = userheadimgurl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
}