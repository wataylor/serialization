package asst.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Experiment with generating JSON strings from a more complicated
 * object.  The JsonProperty takes one argument.  If it has no
 * argument, the JSON attribute is given the same name as the Java
 * attribute.  The JSON attribute name may be a constant string, which
 * means that acceptable parameter names can be put in a file of
 * constants.
 * @author Material gain
 *
 */
public class NestedPojo {
public static final String AST = "aString";

@JsonProperty(AST)
  public String aString;
  /* The array must hold a class for which we have an object which has
   * JSON annotations so the JSON code knows how to handle it.  The
   * ArrayElement class has defined JSON annotations.  */
  @JsonProperty()
  public ArrayElement[] aRay;
  /* int is a primitive Java type, so the library knows how to process
   * it.  The value of intRay written to the JSON object is null if
   * the array is left null.  intRay remains null if the attribute is
   * missing from the incoming JSON string.*/
  @JsonProperty()
  public int[] intRay;
  @JsonProperty()
  public AnAddress anAddress;
}
