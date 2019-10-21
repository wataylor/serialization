package asst.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimitiveSubClass extends PrimitivePojo {
  @JsonProperty("firstName2")
  public String firstName2;
  /* Does not participate in generating or reading JSON. */
  @JsonIgnore
  public int internalValue2;
  @JsonProperty("lat2")
  public double lat2;
  @JsonProperty("isl2")
  public boolean isl2;
}
