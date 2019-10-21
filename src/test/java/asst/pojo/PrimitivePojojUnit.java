package asst.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PrimitivePojojUnit {
  public static final String jsonValue = "{\"firstName\":\"first \\\" name's value\",\"lat\":44.33,\"isl\":false}";
  PrimitivePojo js;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    js = new PrimitivePojo();
    js.firstName = "first \" name's value";
    js.internalValue = 2;
    js.isl = false;
    js.lat = 44.33d;
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testPojoToJson() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    // JsonFactory f = new JsonFactory();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // JsonGenerator jg = f.createGenerator(baos);
    mapper.writeValue(baos, js);
    String jsVal = baos.toString();
    System.out.print(jsVal);
    assertEquals("wrote", jsonValue, jsVal);
  }

  @Test
  public void testJsonToPojo() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    ByteArrayInputStream bais = new ByteArrayInputStream(jsonValue.getBytes());
    PrimitivePojo priPo = mapper.readValue(bais, PrimitivePojo.class);
    assertEquals("read", js.firstName, priPo.firstName);
    assertEquals(js.lat, priPo.lat, .001d);
  }
}
