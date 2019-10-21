package asst.thatsbiz.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import asst.pojo.Individual;

/**
 * Serialize an array of objects in multiple ways
 * @author William A. Taylor
 * @since 2019 10
 */
public class AppMain {
  public static void main( String[] args ) throws Exception{
    Individual[] individuals = new Individual[2];
    individuals[0] =
	new Individual().setFirstName("first \" name's & % , value")
	.setLastName("last name value").setAge(0);
    individuals[1] =
	new Individual().setFirstName("2nd first name value")
	.setLastName("2nd last name value").setAge(1);
    ObjectMapper mapper = new ObjectMapper();
    // JsonFactory f = new JsonFactory();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // JsonGenerator jg = f.createGenerator(baos);
    mapper.writeValue(baos, individuals);
    String jsVal = baos.toString();
    System.out.print(jsVal);
  }
}
