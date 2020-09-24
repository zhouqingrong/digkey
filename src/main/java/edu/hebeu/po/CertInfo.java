package edu.hebeu.po;

public class CertInfo {
    private  int certinfoId;
    private String cert_name;
    private String phone;


    @Override
    public String toString() {
        return "CertInfo{" +
                "certinfoId=" + certinfoId +
                ", cert_name='" + cert_name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public CertInfo(int certinfoId, String cert_name, String phone) {
        this.certinfoId = certinfoId;
        this.cert_name = cert_name;
        this.phone = phone;
    }

    public CertInfo(String cert_name, String phone) {
        this.cert_name = cert_name;
        this.phone = phone;
    }

    public CertInfo() {
    }

    public int getCertinfoId(){
        return this.certinfoId;
    }

    public void setCertinfoId(int certinfoId){
        this.certinfoId = certinfoId;
    }

    public String getcert_name(){
        return this.cert_name;
    }

    public void setcert_name(String cert_name){
        this.cert_name = cert_name;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
}
