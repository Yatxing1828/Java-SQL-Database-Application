package Database_Proj;

public class User {
    int id;
    String name;
    Sex sex;
    int age;
    String phone;
    String email;
    String address;
    int grocer_id;

    public User(int id, String name, Sex sex, int age, String phone,
            String email, String address, int grocer_id) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.grocer_id = grocer_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }
    
    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getGrocer_id() {
        return grocer_id;
    }

    public void setId(int id) {
        this.id = id; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGrocer_id(int grocer_id) {
        this.grocer_id = grocer_id;
    }
}
