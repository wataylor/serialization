package asst.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AnAddress {
  @JsonProperty("line1")
  public String line1;
  @JsonProperty("line2")
  public String line2;
  @JsonProperty("line3")
  public String line3;
  @JsonProperty("city")
  public String city;
  @JsonProperty("state")
  public String state;
  @JsonProperty("country")
  public String country;
  @JsonProperty("zip")
  public String zip;

}
