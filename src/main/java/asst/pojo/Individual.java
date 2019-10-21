package asst.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Attributes which are given values to demonstrate serialization
 * @author William A. Taylor
 * @since 2019 10
 */
public class Individual {
  @JsonProperty()
  public String firstName;
  @JsonProperty()
  public String lastName;
  @JsonProperty()
  public int age;

  public String getFirstName() {
    return firstName;
  }
  public Individual setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }
  public String getLastName() {
    return lastName;
  }
  public Individual setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
  public int getAge() {
    return age;
  }
  public Individual setAge(int age) {
    this.age = age;
    return this;
  }

}
