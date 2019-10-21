package asst.pojo;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrimitiveSubClassjUnit {

  PrimitiveSubClass js;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    js = new PrimitiveSubClass();
    js.firstName = "first \" name's value";
    js.internalValue = 2;
    js.isl = false;
    js.lat = 44.33d;

    js.firstName2 = "first \" name2's value";
    js.internalValue2 = 4;
    js.isl2 = true;
    js.lat2 = 88.66d;
}

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    // JsonFactory f = new JsonFactory();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // JsonGenerator jg = f.createGenerator(baos);
    mapper.writeValue(baos, js);
    String jsVal = baos.toString();
    System.out.print(jsVal);
  }

  @Test
  public void test2() throws Exception {
    Class<?> clazz = js.getClass();
    Annotation[] annos = clazz.getAnnotations();
    for (Annotation a : annos) {
      System.out.println(a.annotationType().toString() + " " + a.toString());
    }
    Field[] flds = clazz.getFields();
    for (Field f : flds) {
      System.out.println(f.getName());
    }
  }

}
