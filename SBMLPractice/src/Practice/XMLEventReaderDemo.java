package Practice;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLEventReaderDemo {
	 public static void main(String[] args) throws Exception {
		    XMLInputFactory factory = XMLInputFactory.newInstance();
		    Reader fileReader = new FileReader("Source.xml");
		    XMLEventReader reader = factory.createXMLEventReader(fileReader);

		    while (reader.hasNext()) {
		      XMLEvent event = reader.nextEvent();
		      if (event.isStartElement()) {
		        StartElement element = (StartElement) event;
		        System.out.println("Start Element: " + element.getName());

		        Iterator iterator = element.getAttributes();
		        while (iterator.hasNext()) {
		          Attribute attribute = (Attribute) iterator.next();
		          QName name = attribute.getName();
		          String value = attribute.getValue();
		          System.out.println("Attribute name/value: " + name + "/" + value);
		        }
		      }
		      if (event.isEndElement()) {
		        EndElement element = (EndElement) event;
		        System.out.println("End element:" + element.getName());
		      }
		      if (event.isCharacters()) {
		        Characters characters = (Characters) event;
		        System.out.println("Text: " + characters.getData());
		      }
		    }
		  }
	}

