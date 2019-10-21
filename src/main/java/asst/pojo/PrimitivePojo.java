package asst.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Explore conversion between JSON and Java.  Setting ignore unknown
 * properties to true means that errors will not be thrown in the
 * incoming JSON object has properties that are not found in the Java
 * object.  The Ignore property is not processed when creating a JSON
 * object.
 * @author Material Gain
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class PrimitivePojo {
  @JsonProperty("firstName")
  public String firstName;
  /* Does not participate in generating or reading JSON. */
  @JsonIgnore
  public int internalValue;
  @JsonProperty("lat")
  public double lat;
  @JsonProperty("isl")
  public boolean isl;
}
