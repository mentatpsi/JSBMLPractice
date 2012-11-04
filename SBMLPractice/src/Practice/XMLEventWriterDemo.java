package Practice;

import java.util.Arrays;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;

public class XMLEventWriterDemo {
  public static void main(String[] args) throws Exception {
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

    XMLEventWriter writer = outputFactory.createXMLEventWriter(System.out);

    XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();

    StartDocument startDocument = xmlEventFactory.createStartDocument("UTF-8", "1.0");
    writer.add(startDocument);

    StartElement startElement = xmlEventFactory.createStartElement("", "", "My-list");
    writer.add(startElement);

    Attribute attribute = xmlEventFactory.createAttribute("version", "1");
    List attributeList = Arrays.asList(attribute);
    List nsList = Arrays.asList();
    StartElement startElement2 = xmlEventFactory.createStartElement("", "", "Item",
        attributeList.iterator(), nsList.iterator());
    writer.add(startElement2);

    StartElement codeSE = xmlEventFactory.createStartElement("", "", "code");
    writer.add(codeSE);
    Characters codeChars = xmlEventFactory.createCharacters("I001");
    writer.add(codeChars);
    EndElement codeEE = xmlEventFactory.createEndElement("", "", "code");
    writer.add(codeEE);

    StartElement nameSE = xmlEventFactory.createStartElement(" ", " ", "name");
    writer.add(nameSE);
    Characters nameChars = xmlEventFactory.createCharacters("a name");
    writer.add(nameChars);
    EndElement nameEE = xmlEventFactory.createEndElement("", "", "name");
    writer.add(nameEE);

    StartElement contactSE = xmlEventFactory.createStartElement("", "", "contact");
    writer.add(contactSE);
    Characters contactChars = xmlEventFactory.createCharacters("another name");
    writer.add(contactChars);
    EndElement contactEE = xmlEventFactory.createEndElement("", "", "contact");
    writer.add(contactEE);

    EndDocument ed = xmlEventFactory.createEndDocument();
    writer.add(ed);

    writer.flush();
    writer.close();
  }
}