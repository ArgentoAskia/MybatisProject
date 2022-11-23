package bean;

public class Salgrade {
    private Integer grade;
    private Double losal;
    private Double hisal;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Salgrade{");
        sb.append("grade=").append(grade);
        sb.append(", losal=").append(losal);
        sb.append(", hisal=").append(hisal);
        sb.append('}');
        return sb.toString();
    }

    public Integer getGrade() {
        return grade;
    }

    public Salgrade setGrade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public Double getLosal() {
        return losal;
    }

    public Salgrade setLosal(Double losal) {
        this.losal = losal;
        return this;
    }

    public Double getHisal() {
        return hisal;
    }

    public Salgrade setHisal(Double hisal) {
        this.hisal = hisal;
        return this;
    }
}
