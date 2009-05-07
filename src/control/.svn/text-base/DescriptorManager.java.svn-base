/*
 *
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
package control;

import exceptions.DataBaseNotFoundException;
import java.util.LinkedList;
import java.util.List;
import localContainers.*;
import modelo.*;
import modelo.descriptors.*;

/**
 *
 * @author alos
 */
public class DescriptorManager {
    //The containers

    ReferenceDescriptorContainer referenceDescriptorContainer = new ReferenceDescriptorContainer();
    LocationContainer locationContainer = new LocationContainer();
    PublisherContainer publisherContainer = new PublisherContainer();
    AuthorDescriptorContainer authorDescriptorContainer = new AuthorDescriptorContainer();
    DateDescriptorContainer dateDescriptorContainer = new DateDescriptorContainer();
    LocationDescriptorContainer locationDescriptorContainer = new LocationDescriptorContainer();
    PagesDescriptorContainer pagesDescriptorContainer = new PagesDescriptorContainer();
    PublisherDescriptorContainer publisherDescriptorContainer = new PublisherDescriptorContainer();
    TitleDescriptorContainer titleDescriptorContainer = new TitleDescriptorContainer();
    VolumeDescriptorContainer volumeDescriptorContainer = new VolumeDescriptorContainer();
    PeriodicalTitleDescriptorContainer periodicalTitleDescriptorContainer = new PeriodicalTitleDescriptorContainer();

    TemplateContainer templateContainer = new TemplateContainer();
    //We instanciate the descriptors
    AuthorDescriptor authorDesc = null;
    DateDescriptor dateDesc = null;
    LocationDescriptor locationDesc = null;
    PagesDescriptor pagesDesc = null;
    PublisherDescriptor publisherDesc = null;
    TitleDescriptor titleDesc = null;
    VolumeDescriptor volumeDesc = null;
    PeriodicalTitleDescriptor periodicalTitleDesc = null;
    LinkedList<Descriptor> descList = new LinkedList<Descriptor>();

    public String getReferences(String content) throws DataBaseNotFoundException {
        System.out.println("Buscando contenedor");
        ReferenceDescriptor descriptorReferencias = referenceDescriptorContainer.getReferenceDescriptor();
        System.out.println("Se encontro el descritptor");
        DescriptorAnswer resp = descriptorReferencias.runRules(content);
        System.out.println("Se encontro q el statement: " + resp.getAnswer().toString() + " se compara con el texto");
        System.out.println("Score: " + resp.getScore());

        return (String) resp.getObject();
    }

    /**
     * Splits the string into separate words to help in the parcing
     * @param referencias
     * @return
     */
    public String[] parsePossibleCitations(String referencias) {
        String[] cit = referencias.split("[ ]");
        return cit;
    }

    public LinkedList<TemporalReference> getCitations(LinkedList<String> references) {
        LinkedList<TemporalReference> listaDeCitas = new LinkedList<TemporalReference>();
        for (String ref : references) {
            TemporalReference citation = new TemporalReference();
            String cit[] = this.parsePossibleCitations(ref);
            String anItem = "";
            DescriptorAnswer auxAns = null;
            for (int i = 0; i < cit.length; i++) {
                anItem = anItem + cit[i];

                //we clean up the last character
                if (anItem.charAt(anItem.length() - 1) == '.' || anItem.charAt(anItem.length() - 1) == ',') {
                    //if we are evaluating a title and we find a period then we might wanna end this.
                    if (auxAns != null) {
                        if (auxAns.getDescriptorType().equals(DescriptorType.TITLE)) {
                            DescriptorAnswer resp = this.getProbableNodeType(anItem);
                            if (resp.getDescriptorType().equals(DescriptorType.TITLE)) {
                                auxAns = resp;
                            }
                            //entonces se crea un nuevo nodo y se guarda
                            citation.setTitle((Title) auxAns.getObject());
                            System.out.println("Se crea un nodo con: " + auxAns.getDescriptorType().toString() + ": " + auxAns.getObject().toString());
                            anItem = "";

                            if (auxAns.getDescriptorType().equals(DescriptorType.TITLE)) {
                                descList.remove(this.titleDesc);
                            }
                            auxAns = null;
                            continue;
                        }
                    }
                    String aux = anItem.substring(0, anItem.length() - 1);
                    anItem = aux;
                }
                DescriptorAnswer resp = this.getProbableNodeType(anItem);
                if (auxAns == null) {
                    auxAns = resp;
                    anItem = anItem + " ";
                } else {
                    if (resp.getDescriptorType() != auxAns.getDescriptorType()) {
                        //entonces se crea un nuevo nodo y se guarda
                        if (auxAns.getDescriptorType().equals(DescriptorType.AUTHOR)) {
                             citation.setAuthors( (LinkedList<Author>) auxAns.getObject());
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.DATE)) {
                            //citation.setDate((Calendar) auxAns.getObject());
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.LOCATION)) {
                             citation.setLocation((Location) auxAns.getObject());
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.PAGES)) {
                             citation.setPages((Pages) auxAns.getObject());
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.PUBLISHER)) {
                             citation.setPublisher((Publisher) auxAns.getObject());
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.TITLE)) {
                             citation.setTitle((Title) auxAns.getObject());
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.VOLUME)) {
                             citation.setVolume((Volume) auxAns.getObject());
                        }
                        System.out.println("Se crea un nodo con: " + auxAns.getDescriptorType().toString() + ": " + auxAns.getObject().toString());

                        anItem = "";

                        i--;
                        //we eliminate this node from the list
                        if (auxAns.getDescriptorType().equals(DescriptorType.AUTHOR)) {
                            descList.remove(this.authorDesc);
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.DATE)) {
                            descList.remove(this.dateDesc);
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.LOCATION)) {
                            descList.remove(this.locationDesc);
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.PAGES)) {
                            descList.remove(this.pagesDesc);
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.PUBLISHER)) {
                            descList.remove(this.publisherDesc);
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.TITLE)) {
                            descList.remove(this.titleDesc);
                        }
                        if (auxAns.getDescriptorType().equals(DescriptorType.VOLUME)) {
                            descList.remove(this.volumeDesc);
                        }
                        auxAns = null;
                    } else {
                        auxAns = resp;
                        anItem = anItem + " ";
                    }
                }
            }//del q itera sobre las partes


            //creamos el que quedo pendiente en aux
            if (auxAns.getDescriptorType().equals(DescriptorType.AUTHOR)) {
                citation.setAuthors((LinkedList<Author>) auxAns.getObject());
            }
            if (auxAns.getDescriptorType().equals(DescriptorType.DATE)) {
                citation.setDate((modelo.Date) auxAns.getObject());
            }
            if (auxAns.getDescriptorType().equals(DescriptorType.LOCATION)) {
                citation.setLocation((Location) auxAns.getObject());
            }
            if (auxAns.getDescriptorType().equals(DescriptorType.PAGES)) {
                citation.setPages((Pages) auxAns.getObject());
            }
            if (auxAns.getDescriptorType().equals(DescriptorType.PUBLISHER)) {
                citation.setPublisher((Publisher) auxAns.getObject());
            }
            if (auxAns.getDescriptorType().equals(DescriptorType.TITLE)) {
                citation.setTitle((Title) auxAns.getObject());
            }
            if (auxAns.getDescriptorType().equals(DescriptorType.VOLUME)) {
                citation.setVolume((Volume) auxAns.getObject());
            }
            System.out.println("Se crea un nodo con: " + auxAns.getDescriptorType().toString() + ": " + auxAns.getObject().toString());
            listaDeCitas.add(citation);
        }//del for de las referencias
        return listaDeCitas;
    }

    /**
     * From a string it guesses the probable node type
     * @param aString
     * @return
     */
    public DescriptorAnswer getProbableNodeType(String aString) {
        //We instanciate the descriptors
        if (descList.size() == 0) {
            descList = this.reviveDescriptors();
        }
        DescriptorAnswer bestDesc = new DescriptorAnswer();
        for (Descriptor desc : descList) {

            if (desc.getClass().equals(this.locationDesc.getClass())) {
                //we clean the thing to test it with a location
                Evaluator eva = new Evaluator();
                aString = eva.removeSeparators(aString);
            }

            DescriptorAnswer auxAns = desc.runRules(aString);

            if (auxAns.getDescriptorType().equals(DescriptorType.PUBLISHER) && (this.descList.contains(this.authorDesc) || this.descList.contains(this.titleDesc))) {
                auxAns.addToScore(-auxAns.getScore());//temp bugfix to make author come first
            }


            if (auxAns.getDescriptorType().equals(DescriptorType.LOCATION) || auxAns.getDescriptorType().equals(DescriptorType.PUBLISHER)) {
                boolean foundLocation = false;
                boolean foundPublisher = false;

                if (descList.contains(this.locationDesc)) {
                    if (auxAns.getDescriptorType().equals(DescriptorType.LOCATION)) {
                        if (locationContainer.isLocation(aString)) {
                            foundLocation = true;
                            auxAns.addToScore(50);
                        }
                    }
                    if (auxAns.getDescriptorType().equals(DescriptorType.PUBLISHER)) {
                        if (publisherContainer.isPublisher(aString)) {
                            foundPublisher = true;
                            auxAns.addToScore(50);
                        }
                    }

                    if (foundLocation && foundPublisher) {
                        auxAns.addToScore(-100);
                    }

                    if (!foundLocation && !foundPublisher) {
                        auxAns.addToScore(-100);
                    }

                }
            }
            if (auxAns.getScore() > bestDesc.getScore()) {
                //to prevent conflicts we see if this thing is a location or a publisher                
                bestDesc = auxAns;
            }
        }
        return bestDesc;
    }


    /**
     * Retrives the definitions from the database
     * @return
     */
    public LinkedList<Descriptor> reviveDescriptors() {
        LinkedList<Descriptor> descriptorList = new LinkedList<Descriptor>();
        this.authorDesc = authorDescriptorContainer.getAuthorDescriptor();
        this.dateDesc = dateDescriptorContainer.getDateDescriptor();
        this.locationDesc = locationDescriptorContainer.getLocationDescriptor();
        this.pagesDesc = pagesDescriptorContainer.getPagesDescriptor();
        this.publisherDesc = publisherDescriptorContainer.getPublisherDescriptor();
        this.titleDesc = titleDescriptorContainer.getTitleDescriptor();
        this.volumeDesc = volumeDescriptorContainer.getVolumeDescriptor();
        this.periodicalTitleDesc = this.periodicalTitleDescriptorContainer.getPeriodicalTitleDescriptor();

        descriptorList.add(authorDesc);
        descriptorList.add(dateDesc);
        descriptorList.add(locationDesc);
        descriptorList.add(pagesDesc);
        descriptorList.add(publisherDesc);
        descriptorList.add(titleDesc);
        descriptorList.add(periodicalTitleDesc);
        descriptorList.add(volumeDesc);
        return descriptorList;
    }

    /**
     * Get the citation using a probable template as a default
     * @param listaDeCitas
     * @param probableType
     * @return
     */
    public LinkedList<TemporalReference> getCitations(LinkedList<String> listaDeCitas, String probableType) {
        LinkedList<TemporalReference> citationList = new LinkedList<TemporalReference>();
        if (descList.size() == 0) {
            descList = this.reviveDescriptors();
        }


        boolean didFinishedExaminingString = false;
        List<Template> templates = templateContainer.getTemplatesByName(probableType);
        if (templates.size()==0) {
            return this.getCitations(listaDeCitas);
        } else {

            referenceFor:
            for (String aReference : listaDeCitas) {
                //we split this reference

                String[] possibleNodes = aReference.split("[ ]");
                TemporalReference bestLooserCitation = null;
                int lastLooserPoints = 0;
                int lastI = 0;
                int lastNullCounter = 100;
                templateFor:
                for (Template t : templates) {
                    //for this template
                    int i = 0;
                    TemporalReference citation = new TemporalReference();
                    citation.setOriginalReference(aReference);
                    citation.setIsLooserReference(false);
                    citation.setType(t.getType());

                    int looserPoints = 0;//even if we dont finish with all the nodes
                    //this helps to get the better of the loosers

                    ruleFor:
                    for (Node n : t.getCitationRule()) {
                        try {
                            if (n instanceof Author) {
//                            System.out.println("La regla dice q hay un autor");
                                DescriptorAnswer currentBestAnswer = new DescriptorAnswer();
                                String possibleAuthors = "";
                                for (; i < possibleNodes.length; i++) {
                                    //for this string
                                    possibleAuthors = possibleAuthors + possibleNodes[i];
                                    if (possibleAuthors.charAt(possibleAuthors.length() - 1) == '.' || possibleAuthors.charAt(possibleAuthors.length() - 1) == ',') {

                                        String aux = possibleAuthors.substring(0, possibleAuthors.length() - 1);
                                        possibleAuthors = aux;
                                    }
                                    DescriptorAnswer descAnswer = this.authorDesc.runRules(possibleAuthors);
                                    if (descAnswer.getScore() >= 100) {
                                        currentBestAnswer = descAnswer;
                                        possibleAuthors = possibleAuthors + " ";
                                    } else {
                                        citation.setAuthors((LinkedList<Author>) currentBestAnswer.getObject());
                                        looserPoints++;
                                        continue ruleFor;
                                    }
                                }
                            }

                            if (n instanceof Date) {
//                            System.out.println("La regla dice q hay un date");
                                DescriptorAnswer currentBestAnswer = new DescriptorAnswer();
                                String possibleDate = "";
                                for (; i < possibleNodes.length; i++) {
                                    //for this string
                                    possibleDate = possibleDate + possibleNodes[i];
                                    if (possibleDate.charAt(possibleDate.length() - 1) == '.' || possibleDate.charAt(possibleDate.length() - 1) == ',') {

                                        String aux = possibleDate.substring(0, possibleDate.length() - 1);
                                        possibleDate = aux;
                                    }
                                    DescriptorAnswer descAnswer = this.dateDesc.runRules(possibleDate);
                                    if (descAnswer.getScore() >= 100) {
                                        currentBestAnswer = descAnswer;
                                        possibleDate = possibleDate + " ";
                                    } else {
                                        citation.setDate((modelo.Date)currentBestAnswer.getObject());
                                        //citation.setDate(new GregorianCalendar());
                                        looserPoints++;
                                        continue ruleFor;
                                    }
                                }
                            }


                            if (n instanceof Publisher) {
//                            System.out.println("La regla dice q hay un publisher");
                                DescriptorAnswer currentBestAnswer = new DescriptorAnswer();
                                String possiblePublisher = "";
                                for (; i < possibleNodes.length; i++) {
                                    //for this string
                                    possiblePublisher = possiblePublisher + possibleNodes[i];
                                    if (possiblePublisher.charAt(possiblePublisher.length() - 1) == '.' || possiblePublisher.charAt(possiblePublisher.length() - 1) == ',') {
                                        String aux = possiblePublisher.substring(0, possiblePublisher.length() - 1);
                                        possiblePublisher = aux;
                                        DescriptorAnswer descAnswer = this.publisherDesc.runRules(possiblePublisher);
                                        citation.setPublisher((Publisher) descAnswer.getObject());
                                        i++;//TODO maybe this only when its the lastone?
                                        looserPoints++;
                                        continue ruleFor;
                                    }
                                    DescriptorAnswer descAnswer = this.publisherDesc.runRules(possiblePublisher);
                                    if (descAnswer.getScore() >= 100) {
                                        currentBestAnswer = descAnswer;
                                        possiblePublisher = possiblePublisher + " ";
                                    } else {
                                        citation.setPublisher((Publisher) currentBestAnswer.getObject());
                                        looserPoints++;
                                        continue ruleFor;
                                    }
                                }
                                citation.setPublisher((Publisher) currentBestAnswer.getObject());
                                looserPoints++;
                                continue ruleFor;
                            }


                            if (n instanceof Pages) {
//                            System.out.println("La regla dice q hay un paginas");
                                DescriptorAnswer currentBestAnswer = new DescriptorAnswer();
                                String possiblePages = "";
                                for (; i < possibleNodes.length; i++) {
                                    //for this string
                                    possiblePages = possiblePages + possibleNodes[i];
                                    if (possiblePages.charAt(possiblePages.length() - 1) == '.' || possiblePages.charAt(possiblePages.length() - 1) == ',') {

                                        String aux = possiblePages.substring(0, possiblePages.length() - 1);
                                        possiblePages = aux;
                                    }
                                    DescriptorAnswer descAnswer = this.pagesDesc.runRules(possiblePages);
                                    if (descAnswer.getScore() >= 100) {
                                        currentBestAnswer = descAnswer;
                                        possiblePages = possiblePages + " ";
                                    } else {
                                        citation.setPages((Pages) currentBestAnswer.getObject());
                                        looserPoints++;
                                        continue ruleFor;
                                    }

                                }
                            }


                            if (n instanceof Volume) {
//                            System.out.println("La regla dice q hay un volume");
                                DescriptorAnswer currentBestAnswer = new DescriptorAnswer();
                                String possibleVolume = "";
                                for (; i < possibleNodes.length; i++) {
                                    //for this string
                                    possibleVolume = possibleVolume + possibleNodes[i];
                                    if (possibleVolume.charAt(possibleVolume.length() - 1) == '.' || possibleVolume.charAt(possibleVolume.length() - 1) == ',') {

                                        String aux = possibleVolume.substring(0, possibleVolume.length() - 1);
                                        possibleVolume = aux;
                                    }
                                    DescriptorAnswer descAnswer = this.volumeDesc.runRules(possibleVolume);
                                    if (descAnswer.getScore() >= 100) {
                                        currentBestAnswer = descAnswer;
                                        possibleVolume = possibleVolume + " ";
                                    } else {
                                        citation.setVolume((Volume) currentBestAnswer.getObject());
                                        looserPoints++;
                                        continue ruleFor;
                                    }

                                }
                            }


                            if (n instanceof Location) {
//                            System.out.println("La regla dice q hay un location");
                                DescriptorAnswer currentBestAnswer = new DescriptorAnswer();
                                String possibleLocation = "";
                                for (; i < possibleNodes.length; i++) {
                                    //for this string
                                    possibleLocation = possibleLocation + possibleNodes[i];
                                    if (possibleLocation.charAt(possibleLocation.length() - 1) == '.' || possibleLocation.charAt(possibleLocation.length() - 1) == ',' || possibleLocation.charAt(possibleLocation.length() - 1) == ':') {
                                        String aux = possibleLocation.substring(0, possibleLocation.length() - 1);
                                        possibleLocation = aux;
                                        DescriptorAnswer descAnswer = this.locationDesc.runRules(possibleLocation);
                                        citation.setLocation((Location) descAnswer.getObject());
                                        i++;
                                        looserPoints++;
                                        continue ruleFor;
                                    }
                                    DescriptorAnswer descAnswer = this.locationDesc.runRules(possibleLocation);
                                    if (descAnswer.getScore() >= 100) {
                                        currentBestAnswer = descAnswer;
                                        possibleLocation = possibleLocation + " ";
                                    } else {
                                        citation.setLocation((Location) currentBestAnswer.getObject());
                                        looserPoints++;
                                        continue ruleFor;
                                    }

                                }
                            }

                            if (n instanceof Title) {
                                //System.out.println("La regla dice q hay un title");
                                DescriptorAnswer currentBestAnswer = new DescriptorAnswer();
                                String possibleTitle = "";
                                for (; i < possibleNodes.length; i++) {
                                    //for this string
                                    possibleTitle = possibleTitle + possibleNodes[i];
                                    if (possibleTitle.charAt(possibleTitle.length() - 1) == '.' || possibleTitle.charAt(possibleTitle.length() - 1) == ',') {
                                        String aux = possibleTitle.substring(0, possibleTitle.length() - 1);
                                        possibleTitle = aux;
                                        DescriptorAnswer descAnswer = this.titleDesc.runRules(possibleTitle);
                                        citation.setTitle((Title) descAnswer.getObject());
                                        i++;
                                        looserPoints++;
                                        continue ruleFor;
                                    }
                                    DescriptorAnswer descAnswer = this.titleDesc.runRules(possibleTitle);
                                    if (descAnswer.getScore() >= 100) {
                                        currentBestAnswer = descAnswer;
                                        possibleTitle = possibleTitle + " ";
                                    } else {
                                        citation.setTitle((Title) currentBestAnswer.getObject());
                                        looserPoints++;
                                        continue ruleFor;
                                    }
                                }
                            }

                            if (n instanceof PeriodicalTitle) {
                                System.out.println("La regla dice q hay un periodical titletitle");
                                DescriptorAnswer currentBestAnswer = new DescriptorAnswer();
                                String possibleTitle = "";
                                for (; i < possibleNodes.length; i++) {
                                    //for this string
                                    possibleTitle = possibleTitle + possibleNodes[i];
                                    if (possibleTitle.charAt(possibleTitle.length() - 1) == '.' || possibleTitle.charAt(possibleTitle.length() - 1) == ',') {
                                        String aux = possibleTitle.substring(0, possibleTitle.length() - 1);
                                        possibleTitle = aux;
                                        DescriptorAnswer descAnswer = this.periodicalTitleDesc.runRules(possibleTitle);
                                        citation.setPeriodicalTitle((PeriodicalTitle) descAnswer.getObject());
                                        i++;
                                        looserPoints++;
                                        continue ruleFor;
                                    }
                                    DescriptorAnswer descAnswer = this.periodicalTitleDesc.runRules(possibleTitle);
                                    if (descAnswer.getScore() >= 100) {
                                        currentBestAnswer = descAnswer;
                                        possibleTitle = possibleTitle + " ";
                                    } else {
                                        citation.setPeriodicalTitle((PeriodicalTitle) currentBestAnswer.getObject());
                                        looserPoints++;
                                        continue ruleFor;
                                    }
                                }
                            }

                        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        } catch (java.lang.StringIndexOutOfBoundsException e2) {
                            e2.printStackTrace();
                        }

                    }//del for de nodos
                    if (i >= possibleNodes.length && this.didFinishLiveTokens(looserPoints, t)) {
                        System.out.println("SE TERMINO TODA LA CADENA");
                        didFinishedExaminingString = true;

                    } else {
                        System.out.println("NO SE TERMINO TODA LA CADENA");
                        didFinishedExaminingString = false;
                    }

                    if (didFinishedExaminingString) {
                        System.out.println("Se termino de ver el string y gano:" + t.getType());
                        citationList.add(citation);
                        continue referenceFor;//TODOthis is not working!!!!
                    } else {
                        if (looserPoints >= lastLooserPoints) {
                            //we now check if this has more not nulls err...mistakes
                            int nullCounter = 0;

                            if (citation.getAutors() == null) {
                                nullCounter++;
                            }
                            if (citation.getTitle() == null) {
                                nullCounter++;
                            }
                            if (citation.getDate() == null) {
                                nullCounter++;
                            }
                            if (citation.getLocation() == null) {
                                nullCounter++;
                            }
                            if (citation.getPublisher() == null) {
                                nullCounter++;
                            }
                            if (citation.getPages() == null) {
                                nullCounter++;
                            }
                            if (citation.getVolume() == null) {
                                nullCounter++;
                            }
                            if (nullCounter <= lastNullCounter) {
                                lastNullCounter = nullCounter;
                                lastLooserPoints = looserPoints;
                                lastI = i;
                                bestLooserCitation = citation;
                            }

                        }
                    }

                }//del for de temlates
                //if this is the end and we dont have the winning citation we go for the looser
                System.out.println("Eligiendo mejor perdedor con: " + lastLooserPoints);
                System.out.println("lastI: " + lastI);
                String trash = "";
                for (; lastI < possibleNodes.length; lastI++) {
                    trash = trash + " " + possibleNodes[lastI];
                }
                bestLooserCitation.setExtra(trash);
                bestLooserCitation.setIsLooserReference(true);
                bestLooserCitation.setOriginalReference(aReference);
                citationList.add(bestLooserCitation);
                System.out.println("TRASH: " + trash);
            }///del for de references
        }
        return citationList;
    }

/**
 * Compares the looserPoints (the compleated descriptos) to the number of tokens in the template.
 * If the number of tokens and the number of looserPoints are the same, then this template has been evaluadted compleatly.
 *
 * NOTE: This only takes into account livetokens. Tokens that do not represent separators.
 * @return
 */
    public boolean didFinishLiveTokens(int looserPoints, Template temp){
        //we count how many live tokens we have on this template
        int liveTokens = 0;
        for(Node node : temp.getCitationRule()){
            if(!(node instanceof Token))
                liveTokens++;
        }
        //we compare them 
        if(looserPoints == liveTokens)
            return true;
        else
            return false;
    }

}
