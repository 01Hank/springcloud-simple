package com.zxb.druid.Pojo;


import javax.persistence.Table;

@Table(name = "student")
public class Student {

  private long id;
  private String name;
  private String pwd;
  private long tid;
  private long radio;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public long getTid() {
    return tid;
  }

  public void setTid(long tid) {
    this.tid = tid;
  }


  public long getRadio() {
    return radio;
  }

  public void setRadio(long radio) {
    this.radio = radio;
  }

}
