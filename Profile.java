package Database_Proj;

public class Profile {
  int id;
  Cuisine cuisine;
  Boolean spicy;
  Integer time;
  Skill skill;
  Restriction restriction;

  public Profile(int id, Cuisine cuisine, Boolean spicy, Integer time, Skill skill,
      Restriction restriction) {
    this.id = id;
    this.cuisine = cuisine;
    this.spicy = spicy;
    this.time = time;
    this.skill = skill;
    this.restriction = restriction;
  }

  public Profile(int id) {
    this(id, null, null, null, null, null);
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setCuisine(Cuisine cuisine) {
    this.cuisine = cuisine;
  }

  public void setSpicy(Boolean spicy) {
    this.spicy = spicy;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  public void setSkill(Skill skill) {
    this.skill = skill;
  }

  public void setRestriction(Restriction restriction) {
    this.restriction = restriction;
  }

  public int getId() {
    return id;
  }

  public Cuisine getCuisine() {
    return cuisine;
  }

  public Boolean getSpicy() {
    return spicy;
  }

  public Integer getTime() {
    return time;
  }

  public Skill getSkill() {
    return skill;
  }

  public Restriction getRestriction() {
    return restriction;
  }
}