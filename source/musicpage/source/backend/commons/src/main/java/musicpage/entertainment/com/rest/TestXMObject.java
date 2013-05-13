package musicpage.entertainment.com.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestXMObject {
	@XmlElement
	public String name;
	@XmlElement
	public int age;

	public TestXMObject() {
	}

}
