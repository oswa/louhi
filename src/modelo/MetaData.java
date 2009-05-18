/*
 *This file is part of Louhi.

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

package modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author alos & oswa
 */
public class MetaData {

    private Language language; //the language the article is in
    private String theme; //The Article's theme
    private int numberOfPages;//the total number of pages in the original PDF/Article
    private String keywords;//keywords captures in the GUI
    private String maker;//how the PDF was made
    private String producer;//how the PDF was made
    private GregorianCalendar creationDate;//the day the PDF was made
    private GregorianCalendar modificationDate;//the day the PDF was modified
    private String owner;//the IP
    private GregorianCalendar captureDate;//the time of capture
    private String userName;//name the person who saved this citaion

    public MetaData(){
        this.theme="";
        this.numberOfPages=0;
        this.keywords="";
        this.maker="";
        this.producer="";
        this.creationDate=new GregorianCalendar();
        this.modificationDate=new GregorianCalendar();
        this.owner="";
        this.captureDate=new GregorianCalendar();
        this.userName="";
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public GregorianCalendar getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(GregorianCalendar captureDate) {
        this.captureDate = captureDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public GregorianCalendar getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(GregorianCalendar modificationDate) {
        this.modificationDate = modificationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    
    
}
