package asst.pojo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MappedPojo {
  @JsonProperty("aString")
  public String aString;
  /* If we're going to have a map, the map must go to a class for which we
   * have an object which has JSON annotations so the JSON code knows how to
   * handle it.  We used a map of ArrayElement because that
   * is already defined for JSON.  */
  @JsonProperty("aMap")
  public Map<String, ArrayElement> aMap = new HashMap<String, ArrayElement>();
}
