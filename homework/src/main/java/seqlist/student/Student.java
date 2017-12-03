package seqlist.student;

public class Student {
    private String stuId;
    private String stuName;
    private String year;
    private int stuCore;

    protected Student() {
    }
    public Student(String stuId, String stuName, String year, int stuCore){
        this.stuId = stuId;
        this.stuName = stuName;
        this.year = year;
        this.stuCore = stuCore;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getStuCore() {
        return stuCore;
    }

    public void setStuCore(int stuCore) {
        this.stuCore = stuCore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (stuCore != student.stuCore) return false;
        if (!stuId.equals(student.stuId)) return false;
        if (!stuName.equals(student.stuName)) return false;
        return year.equals(student.year);
    }

    @Override
    public int hashCode() {
        int result = stuId.hashCode();
        result = 31 * result + stuName.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + stuCore;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", year='" + year + '\'' +
                ", stuCore=" + stuCore +
                '}';
    }
}
