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
public class ListedPojojUnit {
  public static final String jsonValue = "{\"aString\":\"aString\",\"aList\":[{\"firstName\":\"firstAE\",\"lastName\":\"\"},{\"firstName\":\"secondAE\",\"lastName\":null}],\"intRay\":null,\"anAddress\":{\"line1\":\"line1\",\"line2\":null,\"line3\":null,\"city\":\"city\",\"state\":\"state\",\"country\":\"country\",\"zip\":\"zip\"}}";
  ListedPojo lp;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    ArrayElement ae;
    lp = new ListedPojo();
    lp.aString = "aString";
    lp.aList.add(ae = new ArrayElement());
    ae.firstName = "firstAE";
    ae.lastName = "";
    lp.aList.add(ae = new ArrayElement());
    ae.firstName = "secondAE";
    ae.lastName = null;
    lp.anAddress = new AnAddress();
    lp.anAddress.city = "city";
    lp.anAddress.state = "state";
    lp.anAddress.zip = "zip";
    lp.anAddress.line1 = "line1";
    lp.anAddress.country = "country";

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
    mapper.writeValue(baos, lp);
    String jsVal = baos.toString();
    System.out.print(jsVal);
    assertEquals("wrote", jsonValue, jsVal);
  }

  @Test
  public void testJsonToNested() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    ByteArrayInputStream bais = new ByteArrayInputStream(jsonValue.getBytes());
    ListedPojo nstPo = mapper.readValue(bais, ListedPojo.class);
    assertEquals(lp.aString, nstPo.aString);
    assertEquals(lp.aList.get(0).firstName, nstPo.aList.get(0).firstName);
    assertEquals(lp.aList.get(1).lastName,  nstPo.aList.get(1).lastName);
    //7-assertEquals(lp.aList.get(2),           nstPo.aList.get(2));
    assertEquals(lp.anAddress.city,         nstPo.anAddress.city);
  }
}
