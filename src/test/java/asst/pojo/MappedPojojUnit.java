package asst.pojo;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
public class MappedPojojUnit {
  public static final String jsonValue = "{\"aString\":\"aString\",\"aMap\":{\"ae1\":{\"firstName\":\"firstAE\",\"lastName\":\"\"},\"ae2\":{\"firstName\":\"secondAE\",\"lastName\":null}}}";
  MappedPojo mp;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    ArrayElement ae;
    mp = new MappedPojo();
    mp.aString = "aString";
    mp.aMap.put("ae1", (ae = new ArrayElement()));
    ae.firstName = "firstAE";
    ae.lastName = "";
    mp.aMap.put("ae2", (ae = new ArrayElement()));
    ae.firstName = "secondAE";
    ae.lastName = null;
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
    mapper.writeValue(baos, mp);
    String jsVal = baos.toString();
    System.out.print(jsVal);
    assertEquals("wrote", jsonValue, jsVal);
  }

  @Test
  public void testJsonToNested() throws JsonParseException, JsonMappingException, IOException {
    ArrayElement ae1, ae2;
    ObjectMapper mapper = new ObjectMapper();
    ByteArrayInputStream bais = new ByteArrayInputStream(jsonValue.getBytes());
    MappedPojo mapPo = mapper.readValue(bais, MappedPojo.class);
    assertEquals(mp.aString, mapPo.aString);
    ae1 = mp.aMap.get("ae1");
    ae2 = mapPo.aMap.get("ae1");
    assertEquals(ae1.firstName, ae2.firstName);
    ae1 = mp.aMap.get("ae2");
    ae2 = mapPo.aMap.get("ae2");
    assertEquals(ae1.firstName, ae2.firstName);
  }
}
