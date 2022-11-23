package bean;


import java.sql.Date;

public class Emp {

  private Integer empno;
  private String ename;
  private String job;
  private Integer mgr;
  private Date hiredate;
  private Double sal;
  private Double comm;
  private Integer deptno;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Emp{");
    sb.append("empno=").append(empno);
    sb.append(", ename='").append(ename).append('\'');
    sb.append(", job='").append(job).append('\'');
    sb.append(", mgr=").append(mgr);
    sb.append(", hiredate=").append(hiredate);
    sb.append(", sal=").append(sal);
    sb.append(", comm=").append(comm);
    sb.append(", deptno=").append(deptno);
    sb.append('}');
    return sb.toString();
  }

  public Integer getEmpno() {
    return empno;
  }

  public Emp setEmpno(Integer empno) {
    this.empno = empno;
    return this;
  }

  public String getEname() {
    return ename;
  }

  public Emp setEname(String ename) {
    this.ename = ename;
    return this;
  }

  public String getJob() {
    return job;
  }

  public Emp setJob(String job) {
    this.job = job;
    return this;
  }

  public Integer getMgr() {
    return mgr;
  }

  public Emp setMgr(Integer mgr) {
    this.mgr = mgr;
    return this;
  }

  public Date getHiredate() {
    return hiredate;
  }

  public Emp setHiredate(Date hiredate) {
    this.hiredate = hiredate;
    return this;
  }

  public Double getSal() {
    return sal;
  }

  public Emp setSal(Double sal) {
    this.sal = sal;
    return this;
  }

  public Double getComm() {
    return comm;
  }

  public Emp setComm(Double comm) {
    this.comm = comm;
    return this;
  }

  public Integer getDeptno() {
    return deptno;
  }

  public Emp setDeptno(Integer deptno) {
    this.deptno = deptno;
    return this;
  }
}
