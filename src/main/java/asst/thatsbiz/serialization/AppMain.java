package asst.thatsbiz.serialization;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import asst.pojo.AnAddress;
import asst.pojo.Individual;
import asst.pojo.IndividualWithAddress;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Serialize an array of objects in multiple ways
 * @author William A. Taylor
 * @since 2019 10
 */
public class AppMain {
  /**
   * @param args none
   * @throws Exception when things go wrong
   */
  public static void main( String[] args ) throws Exception{
    /* Class without any fields containing non-Java objects */
    Individual[] individuals = new Individual[2];
    individuals[0] =
	new Individual().setFirstName("first \" name's & % , value")
	.setLastName("last name value").setAge(20);
    individuals[1] =
	new Individual().setFirstName("2nd first name value")
	.setLastName("2nd last name value").setAge(31);
    ObjectMapper mapper = new ObjectMapper();
    // JsonFactory f = new JsonFactory();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // JsonGenerator jg = f.createGenerator(baos);
    mapper.writeValue(baos, individuals);
    String jsVal = baos.toString();
    System.out.println(jsVal);

    /* Class with a field containing only Java primitives and classes */
    AnAddress address = new AnAddress().setLine1("al1").setLine2("al2")
	.setCity("City").setState("state").setZip("zip");

    /* Class with a field containing a non-Java object class */
    IndividualWithAddress iwa = new IndividualWithAddress()
    .setFirstName("iwa first \" name's & % , value")
    .setLastName("last name value")
    .setAge(20)
    .setAddress(address);
    mapper = new ObjectMapper();
    baos = new ByteArrayOutputStream();
    mapper.writeValue(baos, iwa);
    jsVal = baos.toString();
    System.out.println(jsVal);
    System.out.println();

    /* Write the objects in CSV format  */
    CSVPrinter printer = CSVFormat.DEFAULT.withHeader("firstName", "lastName", "age").print(System.out);
    for (Individual i : individuals) {
      printer.printRecord(i.firstName , i.lastName , i.age);
    }
    System.out.println();

    printer = CSVFormat.DEFAULT.withHeader("firstName", "lastName", "age", "address").print(System.out);
    printer.printRecord(iwa.firstName , iwa.lastName , iwa.age, iwa.address);
    System.out.println();

    // create JAXB context to write the Individual class as xml
    JAXBContext context = JAXBContext.newInstance(Individual.class);
    // create Marshaller using JAXB context
    Marshaller m = context.createMarshaller();
    // To format the [to be]generated XML output
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    // Marshall it and write output to System.out or to a file
    for (Individual i : individuals) {
      m.marshal(i, System.out);
    }
    System.out.println();

    /* This object includes a field which is itself an object.  Both
     * classes have JAXB annotations, however, so the marshaller
     * is able to generate .xml for the Java fields and the 
     * field which contains an AnAddress object.*/
    context = JAXBContext.newInstance(IndividualWithAddress.class);
    m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    m.marshal(iwa, System.out);
    System.out.println();
  }
}
