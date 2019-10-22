package asst.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Attributes which are given values to demonstrate serialization
 * @author William A. Taylor
 * @since 2019 10
 */
@XmlRootElement(name = "individualAddressed")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class IndividualWithAddress {
  @JsonProperty()
  public String firstName;
  @JsonProperty()
  public String lastName;
  @JsonProperty()
  public int age;
  @JsonProperty()
  public AnAddress address;

  public AnAddress getAddress() {
    return address;
  }
  public IndividualWithAddress setAddress(AnAddress address) {
    this.address = address;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }
  public IndividualWithAddress setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }
  public String getLastName() {
    return lastName;
  }
  public IndividualWithAddress setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
  public int getAge() {
    return age;
  }
  public IndividualWithAddress setAge(int age) {
    this.age = age;
    return this;
  }

}
