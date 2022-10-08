package Database_Proj;

public class Recipe {
  int id;
  String name;
  Skill skill;
  int time_min;
  Restriction restriction;

  public Recipe(int id, String name, Skill skill, int time_min, Restriction restriction) {
    this.id = id;
    this.name = name;
    this.skill = skill;
    this.time_min = time_min;
    this.restriction = restriction;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Skill getSkill() {
    return skill;
  }

  public void setSkill(Skill skill) {
    this.skill = skill;
  }

  public int getTime_min() {
    return time_min;
  }

  public void setTime_min(int time_min) {
    this.time_min = time_min;
  }

  public Restriction getRestriction() {
    return restriction;
  }

  public void setRestriction(Restriction restriction) {
    this.restriction = restriction;
  }
}
