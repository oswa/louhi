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

package dbFillers;

import control.Db4oConnectionManager;
import java.util.LinkedList;
import localContainers.TemplateContainer;
import modelo.*;
import modelo.descriptors.Token;
import modelo.descriptors.TokenType;
/**
 *
 * @author alos
 */
public class TemplateFiller {
    public static void main(String[] args) {
        Template newTemplate = new Template();

        Author author= new Author();
        Title title = new Title();
        modelo.Date date = new modelo.Date(); 
        Location location = new Location();
        Pages pages = new Pages();
        Publisher publisher = new Publisher();
        Volume volume = new Volume();
        PeriodicalTitle periodicalTitle = new PeriodicalTitle();

        Token separatorDot = new Token(TokenType.SEPARATOR,".");
        Token separatorColon = new Token(TokenType.SEPARATOR,":");
        Token separatorComma = new Token(TokenType.SEPARATOR,",");
        Token otherInfo = new Token(TokenType.STRING);
        Token separatorSameColon = new Token(TokenType.SEPARATOR,";");
        //Templates:

        /*Chicago*/
        TemplateContainer templateContainer= new TemplateContainer();
        //Book
        LinkedList<Node> nodeList = new LinkedList<Node>();
        nodeList.add(author);
        nodeList.add(separatorDot);
        nodeList.add(date);
        nodeList.add(separatorDot);
        nodeList.add(title);
        nodeList.add(separatorDot);
        nodeList.add(location);
        nodeList.add(separatorColon);
        nodeList.add(publisher);
        newTemplate.setType(Type.BOOK);
        newTemplate.setName("Chicago");
        newTemplate.setCitationRule(nodeList);
        templateContainer.saveTemplate(newTemplate);
        //JournalArticle
        newTemplate = new Template();
        nodeList = new LinkedList<Node>();
        nodeList.add(author);
        nodeList.add(separatorDot);
        nodeList.add(date);
        nodeList.add(separatorDot);
        nodeList.add(title);
        nodeList.add(separatorDot);
        nodeList.add(periodicalTitle);
        nodeList.add(volume);
        nodeList.add(separatorColon);
        nodeList.add(pages);
        newTemplate.setType(Type.JOURNALARTICLE);
        newTemplate.setName("Chicago");
        newTemplate.setCitationRule(nodeList);
        templateContainer.saveTemplate(newTemplate);
        //MagazineArticle
        newTemplate = new Template();
        nodeList = new LinkedList<Node>();
        nodeList.add(author);
        nodeList.add(separatorDot);
        nodeList.add(date);
        nodeList.add(separatorDot);
        nodeList.add(title);
        nodeList.add(separatorDot);
        nodeList.add(periodicalTitle);
        newTemplate.setType(Type.MAGAZINEARTICLE);
        newTemplate.setName("Chicago");
        newTemplate.setCitationRule(nodeList);
        templateContainer.saveTemplate(newTemplate);
        //NewspaperArticle
        newTemplate = new Template();
        nodeList = new LinkedList<Node>();
        nodeList.add(author);
        nodeList.add(separatorDot);
        nodeList.add(date);
        nodeList.add(separatorDot);
        nodeList.add(title);
        nodeList.add(separatorDot);
        nodeList.add(periodicalTitle);
        nodeList.add(separatorComma);
        nodeList.add(date);
        nodeList.add(separatorComma);
        nodeList.add(pages);
        newTemplate.setType(Type.NEWSPAPERARTICLE);
        newTemplate.setName("Chicago");
        newTemplate.setCitationRule(nodeList);
        templateContainer.saveTemplate(newTemplate);
        //NewspaperArticle-NoAuthor
        newTemplate = new Template();
        nodeList = new LinkedList<Node>();
        nodeList.add(periodicalTitle);
        nodeList.add(separatorDot);
        nodeList.add(date);
        nodeList.add(separatorDot);
        nodeList.add(title);
        nodeList.add(separatorDot);
        nodeList.add(date);
        nodeList.add(separatorComma);
        nodeList.add(otherInfo);
        nodeList.add(separatorComma);
        nodeList.add(pages);
        newTemplate.setType(Type.NEWSPAPERARTICLENOAUTHOR);
        newTemplate.setName("Chicago");
        newTemplate.setCitationRule(nodeList);
        templateContainer.saveTemplate(newTemplate);
        System.out.println("Se termino de dar de alta los templates para Chicago");

        /*AMA*/
        //Book
        LinkedList<Node> nodeListAMA = new LinkedList<Node>();
        nodeListAMA.add(author);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(title);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(location);
        nodeListAMA.add(separatorColon);
        nodeListAMA.add(publisher);
        nodeListAMA.add(separatorSameColon);
        nodeListAMA.add(date);
        newTemplate.setType(Type.BOOK);
        newTemplate.setName("AMA");
        newTemplate.setCitationRule(nodeListAMA);
        templateContainer.saveTemplate(newTemplate);
        //JournalArticle with volume numbers
        nodeListAMA.add(author);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(title);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(periodicalTitle);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(date);
        nodeListAMA.add(separatorSameColon);
        nodeListAMA.add(volume);
        nodeListAMA.add(separatorColon);
        nodeListAMA.add(pages);
        newTemplate.setType(Type.JOURNALARTICLE);
        newTemplate.setName("AMA");
        newTemplate.setCitationRule(nodeListAMA);
        templateContainer.saveTemplate(newTemplate);
        //MagazineArticle with volume numbers
        nodeListAMA.add(author);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(title);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(periodicalTitle);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(date);
        nodeListAMA.add(separatorSameColon);
        nodeListAMA.add(volume);
        nodeListAMA.add(separatorColon);
        nodeListAMA.add(pages);
        newTemplate.setType(Type.MAGAZINEARTICLE);
        newTemplate.setName("AMA");
        newTemplate.setCitationRule(nodeListAMA);
        templateContainer.saveTemplate(newTemplate);
        //Newspaper Article without volume numbers
        nodeListAMA.add(author);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(title);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(periodicalTitle);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(date);
        nodeListAMA.add(separatorColon);
        nodeListAMA.add(pages);
        newTemplate.setType(Type.NEWSPAPERARTICLENOVOLUME);
        newTemplate.setName("AMA");
        newTemplate.setCitationRule(nodeListAMA);
        templateContainer.saveTemplate(newTemplate);
        //Magazine Article without volume numbers
        nodeListAMA.add(author);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(title);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(periodicalTitle);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(date);
        nodeListAMA.add(separatorColon);
        nodeListAMA.add(pages);
        newTemplate.setType(Type.MAGAZINEARTICLENOVOLUME);
        newTemplate.setName("AMA");
        newTemplate.setCitationRule(nodeListAMA);
        templateContainer.saveTemplate(newTemplate);
        //Journal Article without volume numbers
        nodeListAMA.add(author);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(title);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(periodicalTitle);
        nodeListAMA.add(separatorDot);
        nodeListAMA.add(date);
        nodeListAMA.add(separatorColon);
        nodeListAMA.add(pages);
        newTemplate.setType(Type.JOURNALARTICLENOVOLUME);
        newTemplate.setName("AMA");
        newTemplate.setCitationRule(nodeListAMA);
        templateContainer.saveTemplate(newTemplate);

        /*APA*/
        //Journal Article
        LinkedList<Node> nodeListAPA = new  LinkedList<Node>();
        nodeListAPA.add(author);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(date);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(title);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(periodicalTitle);
        nodeListAPA.add(separatorComma);
        nodeListAPA.add(volume);
        nodeListAPA.add(separatorComma);
        nodeListAPA.add(pages);
        newTemplate.setType(Type.JOURNALARTICLE);
        newTemplate.setName("APA");
        newTemplate.setCitationRule(nodeListAPA);
        templateContainer.saveTemplate(newTemplate);
        //Magazine Article
        nodeListAPA.add(author);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(date);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(title);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(periodicalTitle);
        nodeListAPA.add(separatorComma);
        nodeListAPA.add(volume);
        nodeListAPA.add(separatorComma);
        nodeListAPA.add(pages);
        newTemplate.setType(Type.MAGAZINEARTICLE);
        newTemplate.setName("APA");
        newTemplate.setCitationRule(nodeListAPA);
        templateContainer.saveTemplate(newTemplate);
        //Newspaper Article
        nodeListAPA.add(author);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(date);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(title);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(periodicalTitle);
        nodeListAPA.add(separatorComma);
        nodeListAPA.add(pages);
        newTemplate.setType(Type.NEWSPAPERARTICLE);
        newTemplate.setName("APA");
        newTemplate.setCitationRule(nodeListAPA);
        templateContainer.saveTemplate(newTemplate);
        //Book
        nodeListAPA.add(author);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(date);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(title);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(location);
        nodeListAPA.add(separatorColon);
        nodeListAPA.add(publisher);
        newTemplate.setType(Type.BOOK);
        newTemplate.setName("APA");
        newTemplate.setCitationRule(nodeListAPA);
        templateContainer.saveTemplate(newTemplate);
        //BookArticle
        nodeListAPA.add(author);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(date);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(title);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(otherInfo);
        nodeListAPA.add(author);
        nodeListAPA.add(separatorComma);
        nodeListAPA.add(title);
        nodeListAPA.add(pages);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(location);
        nodeListAPA.add(separatorColon);
        nodeListAPA.add(publisher);
        newTemplate.setType(Type.BOOKARTICLE);
        newTemplate.setName("APA");
        newTemplate.setCitationRule(nodeListAPA);
        templateContainer.saveTemplate(newTemplate);
        //ChapterArticle
        nodeListAPA.add(author);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(date);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(title);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(otherInfo);
        nodeListAPA.add(author);
        nodeListAPA.add(separatorComma);
        nodeListAPA.add(title);
        nodeListAPA.add(pages);
        nodeListAPA.add(separatorDot);
        nodeListAPA.add(location);
        nodeListAPA.add(separatorColon);
        nodeListAPA.add(publisher);
        newTemplate.setType(Type.CHAPTER);
        newTemplate.setName("APA");
        newTemplate.setCitationRule(nodeListAPA);
        templateContainer.saveTemplate(newTemplate);

        /*MLA*/
        //Book
        LinkedList<Node> nodeListMLA = new LinkedList<Node>();
        nodeListMLA.add(author);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(title);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(location);
        nodeListMLA.add(separatorColon);
        nodeListMLA.add(publisher);
        nodeListMLA.add(separatorComma);
        nodeListMLA.add(date);
        newTemplate.setType(Type.BOOK);
        newTemplate.setName("MLA");
        newTemplate.setCitationRule(nodeListMLA);
        templateContainer.saveTemplate(newTemplate);
        //JournalArticle
        nodeListMLA.add(author);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(title);
        nodeListMLA.add(periodicalTitle);
        nodeListMLA.add(volume);
        nodeListMLA.add(date);
        nodeListMLA.add(separatorColon);
        nodeListMLA.add(pages);
        newTemplate.setType(Type.JOURNALARTICLE);
        newTemplate.setName("MLA");
        newTemplate.setCitationRule(nodeListMLA);
        templateContainer.saveTemplate(newTemplate);
        //NewspaperArticle
        nodeListMLA.add(author);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(title);
        nodeListMLA.add(periodicalTitle);
        nodeListMLA.add(date);
        nodeListMLA.add(separatorColon);
        nodeListMLA.add(pages);
        newTemplate.setType(Type.NEWSPAPERARTICLE);
        newTemplate.setName("MLA");
        newTemplate.setCitationRule(nodeListMLA);
        templateContainer.saveTemplate(newTemplate);
        //MagazineArtcle
        nodeListMLA.add(author);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(title);
        nodeListMLA.add(periodicalTitle);
        nodeListMLA.add(date);
        nodeListMLA.add(separatorColon);
        nodeListMLA.add(pages);
        newTemplate.setType(Type.MAGAZINEARTICLE);
        newTemplate.setName("MLA");
        newTemplate.setCitationRule(nodeListMLA);
        templateContainer.saveTemplate(newTemplate);
        //BookArticle
        nodeListMLA.add(author);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(title);
        nodeListMLA.add(title);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(author);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(location);
        nodeListMLA.add(separatorComma);
        nodeListMLA.add(date);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(pages);
        newTemplate.setType(Type.BOOKARTICLE);
        newTemplate.setName("MLA");
        newTemplate.setCitationRule(nodeListMLA);
        templateContainer.saveTemplate(newTemplate);
        //Chapter
        nodeListMLA.add(author);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(title);
        nodeListMLA.add(title);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(author);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(location);
        nodeListMLA.add(separatorComma);
        nodeListMLA.add(date);
        nodeListMLA.add(separatorDot);
        nodeListMLA.add(pages);
        newTemplate.setType(Type.CHAPTER);
        newTemplate.setName("MLA");
        newTemplate.setCitationRule(nodeListMLA);
        templateContainer.saveTemplate(newTemplate);

        Db4oConnectionManager.closeDB();
    }
}
