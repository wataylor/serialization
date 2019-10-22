package asst.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class AnAddress {
  @JsonProperty("line1")
  public String line1;
  @JsonProperty("line2")
  public String line2;
  @JsonProperty("city")
  public String city;
  @JsonProperty("state")
  public String state;
  @JsonProperty("country")
  public String country;
  @JsonProperty("zip")
  public String zip;

  public String getLine1() {
    return line1;
  }
  public AnAddress setLine1(String line1) {
    this.line1 = line1;
    return this;
  }
  public String getLine2() {
    return line2;
  }
  public AnAddress setLine2(String line2) {
    this.line2 = line2;
    return this;
  }
  public String getCity() {
    return city;
  }
  public AnAddress setCity(String city) {
    this.city = city;
    return this;
  }
  public String getState() {
    return state;
  }
  public AnAddress setState(String state) {
    this.state = state;
    return this;
  }
  public String getCountry() {
    return country;
  }
  public AnAddress setCountry(String country) {
    this.country = country;
    return this;
  }
  public String getZip() {
    return zip;
  }
  public AnAddress setZip(String zip) {
    this.zip = zip;
    return this;
  }
}
