/*
 * This file is part of Louhi.

    Louhi is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    Louhi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Louhi.  If not, see <http://www.gnu.org/licenses/>.
 */
package localContainers;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import java.util.LinkedList;
import java.util.List;
import modelo.Template;
import modelo.Type;

/**
 *
 * @author alos
 */
public class TemplateContainer extends Container {


    public TemplateContainer(){
        super();
    }
    public List getTemplatesByName(String probableType) {


        final String name = probableType;
        try {
            List<Template> templates = db.query(new Predicate<Template>() {

                public boolean match(Template aTemplate) {
                    return (aTemplate.getName().compareToIgnoreCase(name) == 0);
                }
            });

            return templates;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Saves one specific Template
     * @param a template
     */
    public void saveTemplate(Template template) {
        try {
            deleteAllMatches(template.getName(),template.getType());
            db.store(template);
            db.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    /**
     * Deletes from DB a specific template matching the given pattern
     * @param refDesc
     */
    public boolean deleteReferenceDescriptor(Template template) {
        try {
            db.delete(db.queryByExample(template).next());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Gets a list of all the reference descriptors
     * @return
     */
    public LinkedList<Template> retrieveAllTemplates() {
        LinkedList<Template> readData = new LinkedList<Template>();
        try {
            ObjectSet objTemp = db.queryByExample(Template.class);
            while (objTemp.hasNext()) {
                readData.add((Template) objTemp.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readData;
    }

    public Template getTemplateByNameAndType(final String nombre, final Type tipo) {
        LinkedList<Template> readData = new LinkedList<Template>();
        Template tmplt=new Template();
        tmplt.setName(nombre);
        tmplt.setType(tipo);
        tmplt.setCitationRule(null);
        try {
            ObjectSet objTemp=db.query(new Predicate<Template>() {
                public boolean match(Template tmpl) {
                    return (tmpl.getName().equals(nombre) &&(tmpl.getType().equals(tipo)) );
                }
            });
            if (objTemp.hasNext())
                readData.add((Template)objTemp.next() );
            else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (readData.size()==1)
                return readData.getFirst();
            else
                return null;
        }
    }

    public void deleteAllMatches(final String nombre, final Type tipo) {
        Template tmplt=new Template();
        tmplt.setName(nombre);
        tmplt.setType(tipo);
        tmplt.setCitationRule(null);

        try{
            ObjectSet objTemp=db.query(new Predicate<Template>() {
                public boolean match(Template tmpl) {
                    return (tmpl.getName().equals(nombre) &&(tmpl.getType().equals(tipo)) );
                }
            });
            while (objTemp.hasNext()){
                db.delete((Template)objTemp.next());
            }
            db.commit();
       } catch (Exception e) {
            e.printStackTrace();
       }
    }

}
