public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer grade;

    public User(Integer id, String name, Integer age, Integer grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
