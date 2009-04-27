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

package modelo.descriptors;

/**
 *
 * @author alos
 */
public class DescriptorAnswer {
    private double score = 0.0;
    private Statement answer;
    private Object object;
    private boolean inOrder = false;
    private DescriptorType descriptorType;

    public DescriptorType getDescriptorType() {
        return descriptorType;
    }

    public void setDescriptorType(DescriptorType descriptorType) {
        this.descriptorType = descriptorType;
    }

    public Statement getAnswer() {
        return answer;
    }

    public void setAnswer(Statement answer) {
        this.answer = answer;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void addToScore(double aScore){
        this.score= this.score + aScore;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isInOrder() {
        return inOrder;
    }

    public void setInOrder(boolean inOrder) {
        this.inOrder = inOrder;
    }

    @Override
    public String toString() {
        return "Score: "+this.score +" Answer"+ this.descriptorType.toString() +" with: "+ this.answer.toString();
    }

}
