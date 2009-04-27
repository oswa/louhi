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

import java.util.Calendar;

/**
 *
 * @author alos
 */
public class MetaData {
    private String articleName; //the name of the PDF/Article
    private String issn; //Issn of the magazine
    private String isbn;//isbn of the magazine
    private String magazineTitle; //the title of the magazine
    private Language language; //the language the article is in
    private String theme; //The Article's theme
    private int numberOfPages;//the total number of pages in the original PDF/Article
    private String keywords;//keywords captures in the GUI
    private String maker;//how the PDF was made
    private String producer;//how the PDF was made
    private Calendar creationDate;//the day the PDF was made
    private Calendar modificationDate;//the day the PDF was modified
    private String owner;//the IP/name of the person who saved this citation

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
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

    public String getMagazineTitle() {
        return magazineTitle;
    }

    public void setMagazineTitle(String magazineTitle) {
        this.magazineTitle = magazineTitle;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Calendar getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Calendar modificationDate) {
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
