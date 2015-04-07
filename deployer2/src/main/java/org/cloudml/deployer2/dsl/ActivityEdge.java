/**
 * This file is part of CloudML [ http://cloudml.org ]
 *
 * Copyright (C) 2012 - SINTEF ICT
 * Contact: Franck Chauvel <franck.chauvel@sintef.no>
 *
 * Module: root
 *
 * CloudML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * CloudML is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with CloudML. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.cloudml.deployer2.dsl;

import org.cloudml.core.NamedElement;

/**
 * Created by Maksym on 13.03.2015.
 */
public class ActivityEdge extends Element {
    //TODO maybe add edge guard and edge weight. Also object flow has multicast and multireceive parameters, may be useful later

    private ActivityNode source;
    private ActivityNode target;
    // by default all edges are control edges
    private boolean objectFlow = false;


    // constructors
    public ActivityEdge() {
    }

    public ActivityEdge(boolean objectFlow) {
        this.setObjectFlow(objectFlow);
    }

    // setters and getters
    public ActivityNode getSource() {
        return source;
    }

    public void setSource(ActivityNode source) {
        this.source = source;
    }

    public ActivityNode getTarget() {
        return target;
    }

    public void setTarget(ActivityNode target) {
        this.target = target;
    }

    public boolean isObjectFlow() {
        return objectFlow;
    }

    public void setObjectFlow(boolean objectFlow) {
        this.objectFlow = objectFlow;
    }

    // three methods to describe edge
    @Override
    public String toString(){
        String target = "";
        String source = "";
        if (getTarget() != null){
            target = " to " + getEdgeDescription(getTarget());
        }
        if (getSource() != null){
            source =  " from " + getEdgeDescription(getSource());
        }
        if (isObjectFlow())
                return "Data flow" + source + target;
        return "Control flow" + source + target;

    }

    private String getEdgeDescription(ActivityNode node) {
        String targetString;
        if (node instanceof Action) {
            targetString = "(" + node.getClass().getSimpleName()
                    + ":" + node.getName() + actionInputName(node) + ")";
        } else {
            targetString = "(" + node.getClass().getSimpleName()
                    + ":" + node.getName() + ")";
        }
        return targetString;
    }

    private String actionInputName(ActivityNode node){
        return "_" + ((NamedElement)((Action) node).getInputs().get(0)).getName();
    }

}
