public class Person {


    private int id;
    private String name;
    private String course;
    private int mark;

    public Person(int id, String name, String course, int mark) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.mark = mark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", mark=" + mark +
                '}';
    }
}
