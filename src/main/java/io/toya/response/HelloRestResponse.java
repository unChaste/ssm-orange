package io.toya.response;

public class HelloRestResponse {
    private String name;

    private Integer age;

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

    @Override
    public String toString() {
        return "HelloRestResponse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
