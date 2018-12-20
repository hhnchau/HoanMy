package phuthotech.vn.hospital.model.api.patient;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kingpes on 9/5/18.
 */

public class Patient implements Parcelable {
    private String nobhi;
    private String idlinebhi;
    private String nohicd;
    private long idlinehi;
    private String cardid;
    private String idlineidy;
    private String birthday;
    private int siterf;
    private int patid; //ID Benh Nhan
    private int patcde; //Ma Benh Nhan
    private String fsname;   //Ten
    private String lsname;  //Ho
    private int sex;
    private String ismarr;  //Tinh Trang Hon Nhan
    private int yearbr;  //Nam Sinh
    private int month; //Thang Sinh
    private int daybr; //Ngay Sinh
    private String paport; //Passport
    private String cuntry; //Quoc Gia
    private int nation; //Quoc Tich
    private int provin; //Tinh/Thanh
    private int distric; //Quan/Huyen
    private int ward; //Phuong/Xa
    private String nofhus; //So Nha
    private String street; //Duong
    private String addres; //Dia Chi Day Du
    private int jobid; //Id Nghe Nghiep
    private String email; //Email
    private String phone; //So Dien Thoai
    private String faname; //Ten Cha Me
    private String facard; //CMND Cha Me
    private int ethnic; //Dan Toc
    private String usercr; //User Tao
    private String userup; //User Update
    private String timecr; //Thoi Gian Tao
    private String timeup; //Thoi Gian Update
    private String trsnear; //Thoi Gian Giao Dich Gan Nhat
    private String trsnum; //So Giao Dich Gan Nhat
    private String form;
    private long idlink;
    private boolean nhapngaysinh;

    public Patient() {
    }


    protected Patient(Parcel in) {
        nobhi = in.readString();
        idlinebhi = in.readString();
        nohicd = in.readString();
        idlinehi = in.readLong();
        cardid = in.readString();
        idlineidy = in.readString();
        birthday = in.readString();
        siterf = in.readInt();
        patid = in.readInt();
        patcde = in.readInt();
        fsname = in.readString();
        lsname = in.readString();
        sex = in.readInt();
        ismarr = in.readString();
        yearbr = in.readInt();
        month = in.readInt();
        daybr = in.readInt();
        paport = in.readString();
        cuntry = in.readString();
        nation = in.readInt();
        provin = in.readInt();
        distric = in.readInt();
        ward = in.readInt();
        nofhus = in.readString();
        street = in.readString();
        addres = in.readString();
        jobid = in.readInt();
        email = in.readString();
        phone = in.readString();
        faname = in.readString();
        facard = in.readString();
        ethnic = in.readInt();
        usercr = in.readString();
        userup = in.readString();
        timecr = in.readString();
        timeup = in.readString();
        trsnear = in.readString();
        trsnum = in.readString();
        form = in.readString();
        idlink = in.readLong();
        nhapngaysinh = in.readByte() != 0;
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

    public String getNobhi() {
        return nobhi;
    }

    public void setNobhi(String nobhi) {
        this.nobhi = nobhi;
    }

    public String getIdlinebhi() {
        return idlinebhi;
    }

    public void setIdlinebhi(String idlinebhi) {
        this.idlinebhi = idlinebhi;
    }

    public String getNohicd() {
        return nohicd;
    }

    public void setNohicd(String nohicd) {
        this.nohicd = nohicd;
    }

    public long getIdlinehi() {
        return idlinehi;
    }

    public void setIdlinehi(long idlinehi) {
        this.idlinehi = idlinehi;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getIdlineidy() {
        return idlineidy;
    }

    public void setIdlineidy(String idlineidy) {
        this.idlineidy = idlineidy;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSiterf() {
        return siterf;
    }

    public void setSiterf(int siterf) {
        this.siterf = siterf;
    }

    public int getPatid() {
        return patid;
    }

    public void setPatid(int patid) {
        this.patid = patid;
    }

    public int getPatcde() {
        return patcde;
    }

    public void setPatcde(int patcde) {
        this.patcde = patcde;
    }

    public String getFsname() {
        return fsname;
    }

    public void setFsname(String fsname) {
        this.fsname = fsname;
    }

    public String getLsname() {
        return lsname;
    }

    public void setLsname(String lsname) {
        this.lsname = lsname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIsmarr() {
        return ismarr;
    }

    public void setIsmarr(String ismarr) {
        this.ismarr = ismarr;
    }

    public int getYearbr() {
        return yearbr;
    }

    public void setYearbr(int yearbr) {
        this.yearbr = yearbr;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDaybr() {
        return daybr;
    }

    public void setDaybr(int daybr) {
        this.daybr = daybr;
    }

    public String getPaport() {
        return paport;
    }

    public void setPaport(String paport) {
        this.paport = paport;
    }

    public String getCuntry() {
        return cuntry;
    }

    public void setCuntry(String cuntry) {
        this.cuntry = cuntry;
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }

    public int getProvin() {
        return provin;
    }

    public void setProvin(int provin) {
        this.provin = provin;
    }

    public int getDistric() {
        return distric;
    }

    public void setDistric(int distric) {
        this.distric = distric;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public String getNofhus() {
        return nofhus;
    }

    public void setNofhus(String nofhus) {
        this.nofhus = nofhus;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaname() {
        return faname;
    }

    public void setFaname(String faname) {
        this.faname = faname;
    }

    public String getFacard() {
        return facard;
    }

    public void setFacard(String facard) {
        this.facard = facard;
    }

    public int getEthnic() {
        return ethnic;
    }

    public void setEthnic(int ethnic) {
        this.ethnic = ethnic;
    }

    public String getUsercr() {
        return usercr;
    }

    public void setUsercr(String usercr) {
        this.usercr = usercr;
    }

    public String getUserup() {
        return userup;
    }

    public void setUserup(String userup) {
        this.userup = userup;
    }

    public String getTimecr() {
        return timecr;
    }

    public void setTimecr(String timecr) {
        this.timecr = timecr;
    }

    public String getTimeup() {
        return timeup;
    }

    public void setTimeup(String timeup) {
        this.timeup = timeup;
    }

    public String getTrsnear() {
        return trsnear;
    }

    public void setTrsnear(String trsnear) {
        this.trsnear = trsnear;
    }

    public String getTrsnum() {
        return trsnum;
    }

    public void setTrsnum(String trsnum) {
        this.trsnum = trsnum;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public long getIdlink() {
        return idlink;
    }

    public void setIdlink(long idlink) {
        this.idlink = idlink;
    }

    public boolean isNhapngaysinh() {
        return nhapngaysinh;
    }

    public void setNhapngaysinh(boolean nhapngaysinh) {
        this.nhapngaysinh = nhapngaysinh;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nobhi);
        dest.writeString(idlinebhi);
        dest.writeString(nohicd);
        dest.writeLong(idlinehi);
        dest.writeString(cardid);
        dest.writeString(idlineidy);
        dest.writeString(birthday);
        dest.writeInt(siterf);
        dest.writeInt(patid);
        dest.writeInt(patcde);
        dest.writeString(fsname);
        dest.writeString(lsname);
        dest.writeInt(sex);
        dest.writeString(ismarr);
        dest.writeInt(yearbr);
        dest.writeInt(month);
        dest.writeInt(daybr);
        dest.writeString(paport);
        dest.writeString(cuntry);
        dest.writeInt(nation);
        dest.writeInt(provin);
        dest.writeInt(distric);
        dest.writeInt(ward);
        dest.writeString(nofhus);
        dest.writeString(street);
        dest.writeString(addres);
        dest.writeInt(jobid);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(faname);
        dest.writeString(facard);
        dest.writeInt(ethnic);
        dest.writeString(usercr);
        dest.writeString(userup);
        dest.writeString(timecr);
        dest.writeString(timeup);
        dest.writeString(trsnear);
        dest.writeString(trsnum);
        dest.writeString(form);
        dest.writeLong(idlink);
        dest.writeByte((byte) (nhapngaysinh ? 1 : 0));
    }
}
