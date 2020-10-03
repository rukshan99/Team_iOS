package com.app.getsettravel;


public class Pro {
    private  int id;
    private String Pcode,Ptype,Poffer,Pdes;

    public Pro(){

    }

    public Pro(int id, String pcode, String ptype, String poffer, String pdes){
        this.id = id;
        Pcode = pcode;
        Ptype = ptype;
        Poffer = poffer;
        Pdes = pdes;
    }

    public Pro(String pcode, String ptype, String poffer, String pdes){
        Pcode = pcode;
        Ptype = ptype;
        Poffer = poffer;
        Pdes = pdes;
    }

    public int getId() {
        return id;
    }
    public  String getPcode(){return Pcode;}
    public  String getPtype(){return  Ptype;}
    public  String getPoffer(){return  Poffer;}
    public  String getPdes(){return  Pdes;}

    public   void setId(int id){this.id = id;}
    public void setPcode(String pcode){Pcode = pcode;}
    public void setPtype(String ptype){Ptype = ptype;}
    public  void setPoffer(String poffer){Poffer = poffer;}
    public  void setPdes(String pdes){this.Pdes = pdes;}
}
