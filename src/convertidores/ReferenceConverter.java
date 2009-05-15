/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package convertidores;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import modelo.Author;
import modelo.Citation;
/**
 *
 * @author alos
 */
public class ReferenceConverter implements Converter{

    public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext context) {
       Citation cit = (Citation)obj;

       writer.startNode("reference");

       writer.startNode("type");
       writer.setValue(cit.getType().name());
       writer.endNode();

       writer.startNode("title");
       writer.setValue(cit.getTitle().title);
       writer.endNode();

       writer.startNode("srouce");
       writer.setValue(cit.getPeriodicalTitle().getName());
       writer.endNode();

       writer.startNode("authors");
            for(Author a : cit.getAutors()){
                writer.startNode("author");
                writer.setValue(a.getName());
                writer.endNode();
            }
       writer.endNode();

       writer.startNode("referencedate");
            writer.startNode("date");
            writer.setValue(cit.getDate().getDateWithStatement());
            writer.endNode();

            writer.startNode("timeinmilis");
            writer.setValue(cit.getDate().getDate().getTimeInMillis()+"");
            writer.endNode();
            writer.startNode("timezone");
            writer.setValue(cit.getDate().getDate().getTimeZone().getID()+"");
            writer.endNode();
       writer.endNode();

       writer.startNode("publisher");
       writer.setValue(cit.getPublisher().getName());
       writer.endNode();

       writer.startNode("location");
       writer.setValue(cit.getLocation().getNameOfLocation());
       writer.endNode();

       writer.startNode("pages");
       writer.setValue(cit.getPages().getPages());
       writer.endNode();

       writer.startNode("volume");
       writer.setValue(cit.getVolume().getVolume());
       writer.endNode();

       writer.startNode("clasification");
            writer.startNode("autocitation");
            writer.setValue(cit.getClasificacion().name());
            writer.endNode();

            writer.startNode("national");
            if(cit.isIsNacional())
                writer.setValue("true");
            else
                writer.setValue("false");
            writer.endNode();
       writer.endNode();

       writer.startNode("unknown");
       writer.setValue(cit.getExtra());
       writer.endNode();

       writer.startNode("isbn");
       writer.setValue(cit.getIsbn());
       writer.endNode();

       writer.startNode("issn");
       writer.setValue(cit.getIssn());
       writer.endNode();

       writer.startNode("metadata");
            writer.startNode("language");
            writer.setValue(cit.getMetaData().getLanguage().name());
            writer.endNode();

            writer.startNode("theme");
            writer.setValue(cit.getMetaData().getTheme());
            writer.endNode();

            writer.startNode("numberofpages");
            writer.setValue(cit.getMetaData().getNumberOfPages()+"");
            writer.endNode();

            writer.startNode("keywords");
            writer.setValue(cit.getMetaData().getKeywords());
            writer.endNode();

            writer.startNode("maker");
            writer.setValue(cit.getMetaData().getMaker());
            writer.endNode();
          
       writer.endNode();

       writer.endNode();

    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Citation cit = new Citation();
        reader.moveDown();
        System.out.println(reader.getValue());
        reader.moveUp();
        return cit;
    }

    public boolean canConvert(Class clazz) {
        return clazz.equals(modelo.Citation.class);
    }

}
