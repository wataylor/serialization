package asst.pojo;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Explore converting nested POJOs to JSON
 * @author Material gain
 *
 */
public class NestedPojojUnit {
  public static final String jsonValue = "{\"aRay\":[{\"firstName\":\"firstAE\",\"lastName\":\"\"},{\"firstName\":\"secondAE\",\"lastName\":null},null],\"intRay\":null,\"anAddress\":{\"line1\":\"line1\",\"line2\":null,\"line3\":null,\"city\":\"city\",\"state\":\"state\",\"country\":\"country\",\"zip\":\"zip\"},\"aString\":\"aString\"}";
      NestedPojo np;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    ArrayElement ae;
    np = new NestedPojo();
    np.aString = "aString";
    np.aRay = new ArrayElement[3];
    np.aRay[0] = (ae = new ArrayElement());
    ae.firstName = "firstAE";
    ae.lastName = "";
    np.aRay[1] = (ae = new ArrayElement());
    ae.firstName = "secondAE";
    ae.lastName = null;
    np.anAddress = new AnAddress();
    np.anAddress.city = "city";
    np.anAddress.state = "state";
    np.anAddress.zip = "zip";
    np.anAddress.line1 = "line1";
    np.anAddress.country = "country";

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testNestedToJson() throws JsonGenerationException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    // JsonFactory f = new JsonFactory();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // JsonGenerator jg = f.createGenerator(baos);
    mapper.writeValue(baos, np);
    String jsVal = baos.toString();
    System.out.print(jsVal);
    assertEquals("wrote", jsonValue, jsVal);
  }

  @Test
  public void testJsonToNested() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    ByteArrayInputStream bais = new ByteArrayInputStream(jsonValue.getBytes());
    NestedPojo nstPo = mapper.readValue(bais, NestedPojo.class);
    assertEquals(np.aString, nstPo.aString);
    assertEquals(np.aRay[0].firstName, nstPo.aRay[0].firstName);
    assertEquals(np.aRay[1].lastName,  nstPo.aRay[1].lastName);
    assertEquals(np.aRay[2],           nstPo.aRay[2]);
    assertEquals(np.anAddress.city,    nstPo.anAddress.city);
  }
}
