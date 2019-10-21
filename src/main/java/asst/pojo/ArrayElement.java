package asst.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArrayElement {
  @JsonProperty("firstName")
  public String firstName;
  @JsonProperty("lastName")
  public String lastName;
}
