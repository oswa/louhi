/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;
import java.util.Vector;
import java.util.regex.*;
import java.util.LinkedList;
import modelo.Template;
import modelo.Type;
import modelo.Node;
import modelo.Author;
import modelo.Date;
import modelo.Location;
import modelo.Pages;
import modelo.Publisher;
import modelo.Title;
import modelo.Volume;
import modelo.descriptors.*;
import modelo.RevistaID;
import cloudContainers.RevistasContainer;
import java.awt.Component;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.JList;

/**
 *
 * @author luis
 */
public class GUIRenderer {

/**
 * Divides a String in an specific format, to get the differents nodes acording to an specific template
 * @param citPattern
 */
    public static Vector splitDefinedCitation(String citPattern){

        if (citPattern==null)
            return null;

        boolean next=true;
        Vector citNodes=new Vector();
        while(next){
            if(citPattern.startsWith("Autor")){
                citNodes.add(citPattern.substring(0,6));
                citPattern=citPattern.substring(6);
                if(citPattern.length()<0)
                    next=true;
            }else
            if(citPattern.startsWith("Fecha")){
                citNodes.add(citPattern.substring(0,6));
                citPattern=citPattern.substring(6);
                if(citPattern.length()<0)
                    next=true;
            }else
            if(citPattern.startsWith("Lugar")){
                citNodes.add(citPattern.substring(0,6));
                citPattern=citPattern.substring(6);
                if(citPattern.length()<0)
                    next=true;
            }else
            if(citPattern.startsWith("Volumen")){
                citNodes.add(citPattern.substring(0,8));
                citPattern=citPattern.substring(8);
                if(citPattern.length()<0)
                    next=true;
            }else
            if(citPattern.startsWith("Paginas")){
                citNodes.add(citPattern.substring(0,8));
                citPattern=citPattern.substring(8);
                if(citPattern.length()<0)
                    next=true;
            }else
            if(citPattern.startsWith("Titulo")){
                citNodes.add(citPattern.substring(0,7));
                citPattern=citPattern.substring(7);
                if(citPattern.length()<0)
                    next=true;
            }else
            if(citPattern.startsWith("Mayuscula")){
                citNodes.add(citPattern.substring(0,10));
                citPattern=citPattern.substring(10);
                if(citPattern.length()<0)
                    next=true;
            }else
            if(citPattern.startsWith("Minuscula")){
                citNodes.add(citPattern.substring(0,10));
                citPattern=citPattern.substring(10);
                if(citPattern.length()<0)
                    next=true;
            }else
            if(citPattern.startsWith("Editorial")){
                citNodes.add(citPattern.substring(0,10));
                citPattern=citPattern.substring(10);
                if(citPattern.length()<0)
                    next=true;
            }else
                next=false;
        }
        return citNodes;
    }

/**
 * Divides a String containing the format of a single node
 * @param formatMap
 * @return
 */
    public static Vector splitNodeFormat(String formatMap){
        Vector result=new Vector();
        if (formatMap==null)
            return result;

        while((formatMap.length()>0)){
            if (formatMap.length()>1){
                if (formatMap.startsWith("A ")){//Mayuscula
                    result.add("Mayuscula");
                    formatMap=formatMap.substring(2);
                }else
                    if (formatMap.startsWith("a ")){//Minuscula
                        result.add("minuscula");
                        formatMap=formatMap.substring(2);
                    }else
                        if (formatMap.startsWith("N ")){//Numero
                            result.add("Numero");
                            formatMap=formatMap.substring(2);
                        }else
                            if (formatMap.startsWith("D ")){//Dia
                                result.add("Day");
                                formatMap=formatMap.substring(2);
                            }else
                                if (formatMap.startsWith("Y ")){//Anio
                                    result.add("Year");
                                    formatMap=formatMap.substring(2);
                                }else{//para separadores:
                                    if (formatMap.charAt(1)==' ' ){
                                        try{
                                            result.add(formatMap.substring(0,2));
                                            formatMap=formatMap.substring(2);
                                        }catch(StringIndexOutOfBoundsException e){
                                            result.add(formatMap.substring(0));
                                            if (formatMap.length()==2)
                                            formatMap="";
                                        }
                                    }else{
                                        result.add(formatMap.charAt(0));
                                        if (formatMap.length()>1)
                                            formatMap=formatMap.substring(1);
                                    }
                                }
            }
            if(formatMap.length()==1){
                result.add(formatMap);
                formatMap="";
            }
        }
        return result;
    }

/**
 * Provides different messages for each different node in the system
 * Recieves a code number of the respective node
 * Returns a Vector containing the respective messages to be applied on the interfaces
 * @param dataCode
 * @return
 */
    public static Vector messageResources(int dataCode){
        Vector output= new Vector();
        switch (dataCode){
            case 1: //MsgRscrs for Author
                output.add("Reyna");//0. Mayuscula
                output.add("");//1. minuscula
                output.add("");//2. numero - no disponible para autor
                output.add("");//3. Dia - no disponible para autor
                output.add("");//4. Anio - no disponible para autor
                break;
            case 2: //MsgResources for Date
                output.add("July");//0. Mayuscula
                output.add("july");//1. minuscula
                output.add("3");//2. numero
                output.add("03");//3. Dia
                output.add("2009");//4. Anio
                output.add("Day");//5. predef8
                output.add("D ");//6. cve predef8
                output.add("Year");//7. predef9
                output.add("Y ");//8. cve predef9
                break;
            case 3: //MsgResources for Title
                output.add("Louhi Adventures");//0. Mayuscula
                output.add("louhi adventures");//1. minuscula
                output.add("3");//2. numero - no disponible para titulo
                output.add(" ");//3. Dia - no disponible para titulo
                output.add("");//4. Anio - no disponible para titulo
                break;
            case 4: //MsgResources for Publisher
                output.add("Ed UAEM");//0. Mayuscula
                output.add("ed UAEM");//1. minuscula
                output.add("3");//2. numero - no disponible para autor
                output.add("");//3. Dia - no disponible para autor
                output.add("");//4. Anio - no disponible para autor
                break;
            case 5: //MsgResources for Place
                output.add("Mexico");//0. Mayuscula
                output.add("mexico");//1. minuscula
                output.add("3");//2. numero - no disponible para autor
                output.add("");//3. Dia - no disponible para autor
                output.add("");//4. Anio - no disponible para autor
                break;
            case 6: //MsgResources for Page
                output.add("Pags");//0. Mayuscula
                output.add("pags");//1. minuscula
                output.add("3");//2. numero - no disponible para autor
                output.add("");//3. Dia - no disponible para autor
                output.add("");//4. Anio - no disponible para autor
                break;
            case 7:  //MsgResources for Volume
                output.add("Volume");//0. Mayuscula
                output.add("volume");//1. minuscula
                output.add("3");//2. numero - no disponible para autor
                output.add("");//3. Dia - no disponible para autor
                output.add("");//4. Anio - no disponible para autor
                break;
        }
        return output;
    }



/**
 * Mix the Message Resources for an specific node
 * Recieves a Vector that contains the specific messages and the target string
 * Returns a modified String with the respective modifications acording to the node selected
 * @param target
 * @param msgRsrcs
 * @return
 */
    public static String mixMsgResources(String target, Vector msgRsrcs){
        //0. May 1. Min 2. Sep 3.Num 4. Dia 5. Anio
        String modified=target;
        if ( (msgRsrcs.size()==0) ||(target.length()<1) )
            return "";
        Pattern patron = Pattern.compile("A ");//Mayuscula
        Matcher encaja = patron.matcher(modified);
        modified=encaja.replaceAll( (String)msgRsrcs.elementAt(0) );
        patron = Pattern.compile("a ");//minuscula
        encaja = patron.matcher(modified);
        modified=encaja.replaceAll( (String)msgRsrcs.elementAt(1) );
        patron = Pattern.compile("N ");//numero
        encaja = patron.matcher(modified);
        modified=encaja.replaceAll( (String)msgRsrcs.elementAt(2) );
        patron = Pattern.compile("D ");//Dia
        encaja = patron.matcher(modified);
        modified=encaja.replaceAll( (String)msgRsrcs.elementAt(3) );
        patron = Pattern.compile("Y ");//anio
        encaja = patron.matcher(modified);
        modified=encaja.replaceAll( (String)msgRsrcs.elementAt(4) );
        return modified;
    }


    /**
     * Finds if a given String is a valid separator
     * @param testPat
     * @return
     */
    public static boolean isSeparator(String testPat){
        Pattern patron = Pattern.compile("[a-zA-Z0-9]{1}");//agregar entre los corchetes cualquier simbolo que no sea separador
        Matcher encaja = patron.matcher(testPat);
        if ( testPat.length()!=1 )
            return false;
        if(encaja.find()){
            return false;
        }else
            return true;
    }//fin isSeparator

/**
 * Creates a Type for a Template
 * @param target
 * @return
 */
    public static Type createType(String target){
        Type res=null;
        if (target.equals("Libro")){
            res=Type.BOOK;
        }
        if (target.equals("Articulo Libro")){
            res=Type.BOOKARTICLE;
        }
        if (target.equals("Capitulo")){
            res=Type.CHAPTER;
        }
        if (target.equals("Revista")){
            res=Type.JOURNALARTICLE;
        }
        if (target.equals("Articulo Revista sin Volumen")){
            res=Type.JOURNALARTICLENOVOLUME;
        }
        if (target.equals("Periodico")){
            res=Type.NEWSPAPERARTICLE;
        }
        if (target.equals("Articulo Anonimo de Periodico")){
            res=Type.NEWSPAPERARTICLENOAUTHOR;
        }
        if (target.equals("Articulo de Periodico sin volumen")){
            res=Type.NEWSPAPERARTICLENOVOLUME;
        }
        if (target.equals("Pagina de internet")){
            res=Type.WEBPAGE;
        }

        return res;
    }

/**
 * Creates a Template by recieving a vector (list of nodes), a rule (such as Harvard), and a Type (such as Book)
 * @param nodeVec
 * @param regla
 * @param tipo
 * @return
 */
    public static Template createTemplateForSaving(Vector nodeVec, String regla, Type tipo){
        Template obj=new Template ();
        obj.setType(tipo);
        obj.setName(regla);
        LinkedList<Node> nodes = new LinkedList<Node>();

        for (int i=0; i<nodeVec.size();i++){
            if ( ( (String) nodeVec.elementAt(i)).startsWith("Autor") ){
                nodes.add(new modelo.Author());
            }
            if ( ( (String) nodeVec.elementAt(i)).startsWith("Fecha") ){
                nodes.add(new modelo.Date());
            }
            if ( ( (String) nodeVec.elementAt(i)).startsWith("Titulo") ){
                nodes.add(new modelo.Title());
            }
            if ( ( (String) nodeVec.elementAt(i)).startsWith("Volumen") ){
                nodes.add(new modelo.Volume());
            }
            if ( ( (String) nodeVec.elementAt(i)).startsWith("Paginas") ){
                nodes.add(new modelo.Pages());
            }
            if ( ( (String) nodeVec.elementAt(i)).startsWith("Lugar") ){
                nodes.add(new modelo.Location());
            }
            if ( ( (String) nodeVec.elementAt(i)).startsWith("Editorial") ){
                nodes.add(new modelo.Publisher());
            }
        }
        obj.setCitationRule(nodes);

        
        
        return obj;
    }


    /**
     * Sends to control the current template for saving to DB
     * @param tmplt
     * @return
     */
    public static boolean saveCitationTemplate(Template tmplt){
//System.out.println("---------saveCitationTemplate--------");
//System.out.println("Regla: "+tmplt.getName());
//System.out.println("Tipo: "+tmplt.getType());
//System.out.println("Nodos: "+ getDefinedCitationString(tmplt));
        new localContainers.TemplateContainer().saveTemplate(tmplt);
        return true;
    }


/**
 * Obtains a String representing a citation template - must be control's layer
 * @return
 */
    public static String getDefinedCitationString(Template tmplt){
        //String citationPattern="Autor.Fecha.Titulo.Volumen/Paginas.Lugar/Editorial.";
        String aux="";
        if (tmplt==null)
            return null;
        
        LinkedList<Node> nodeList=tmplt.getCitationRule();

        for(Node n : nodeList){
            if(n instanceof Author)
                aux=aux +"Autor ";
            if(n instanceof Title)
                aux=aux +"Titulo ";
            if(n instanceof Date)
                aux=aux +"Fecha ";
            if(n instanceof Pages)
                aux=aux +"Paginas ";
            if(n instanceof Volume)
                aux=aux +"Volumen ";
            if(n instanceof Publisher)
                aux=aux +"Editorial ";
            if(n instanceof Location)
                aux=aux +"Lugar ";
        }

        return aux;
    }
/**
 * Searches for a Template matching to given RuleName and Type
 * @param nombre
 * @param tipo
 * @return
 */
    public static Template getTemplate(String nombre, Type tipo){
        Template readed=new Template();
//System.out.println("--- getTemplate---");
//System.out.println("Regla: "+nombre);
//System.out.println("Tipo: "+tipo);
        readed= ( (Template) new localContainers.TemplateContainer().getTemplateByNameAndType(nombre, tipo));
        if (readed==null)
            return null;
        
        return readed;
    }

/**
 * Try to add to DB a new statement to AuthorDescriptor
 * @param stat
 * @return
 */
    public static boolean addAuthorStatement(Statement stat){
        
        return true;
    }


/**
 * For testing use... Shows existing templates in DB
 */
    public static void showTemplates(){
        LinkedList<Template> tmpl=new LinkedList<Template>();
        localContainers.TemplateContainer tem= new localContainers.TemplateContainer();
        tmpl= tem.retrieveAllTemplates();


System.out.println("Entro a showtemplates.. size: "+tem.retrieveAllTemplates().size());
        for(Template temp: tmpl){
System.out.println("un template:  ");
System.out.println(tmpl.toString() );
System.out.println("-----------");
        }

    }
/**
 * Returns all the magazines found in the central DB as RevistaID objects
 * @return
 */
    public static LinkedList<RevistaID> retrieveAllMagazinesAndID(){
        LinkedList<RevistaID> output= RevistasContainer.getListOfMagazines();
        return output;
    }
/**
 * Retrieves the magazine names from a LinkedList of RevistaID objects
 * @param magz
 * @return
 */
    public static String[] getMagazineNames(LinkedList<RevistaID> magz){
        String listMag[]=new String[(magz.size()+1)];
        listMag[0]="0000000000";
        for(int i=1;i<magz.size()+1;i++){
            listMag[i]=magz.get(i-1).getTitle();
        }
        java.util.Arrays.sort(listMag);
        listMag[0]="Seleccione una revista...";
        return listMag;
    }

    public static String[] getTypeElements(){
        Type[] typesList= Type.values();
        String[] result=new String[typesList.length+1];
        result[0]="Seleccione uno...";
        for (int i=0;i<typesList.length;i++){
            result[i+1]=typesList[i].name();
        }
        return result;
    }

  class TypeComboBoxRenderer extends BasicComboBoxRenderer {
      Type[] typesList= Type.values();

    @Override
    public Component getListCellRendererComponent(JList list, Object val,
        int idx, boolean isSelected, boolean cellHasFocus) {
        String[] tooltips=new String[typesList.length+1];
        tooltips[0]="Select One...";
        for (int i=0;i<typesList.length;i++){
            tooltips[i+1]=typesList[i].name();
        }

      if (isSelected) {
        setBackground(list.getSelectionBackground());
        setForeground(list.getSelectionForeground());
        if (-1 < idx) {
          list.setToolTipText(tooltips[idx]);
        }
      } else {
        setBackground(list.getBackground());
        setForeground(list.getForeground());
      }
      setFont(list.getFont());
      setText((val == null) ? "" : val.toString());
      return this;
    }
  }

}