package asst.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** Class to demonstrate writing one .xml file with multiple classes in it
 * @author William Taylor
 * @since 201910
 */
@XmlRootElement(name = "arrayed")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ArrayedClass {
  @XmlElement(name="individual")
  public Individual[] individuals;
}
