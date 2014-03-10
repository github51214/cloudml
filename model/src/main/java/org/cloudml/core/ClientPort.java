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
package org.cloudml.core;

import java.util.List;
import org.cloudml.core.visitors.Visitor;

public class ClientPort extends ArtefactPort {

    public static final boolean OPTIONAL = true;
    public static final boolean MANDATORY = false;
    public static final boolean DEFAULT_IS_OPTIONAL = MANDATORY;
    
    private boolean optional = true;

    public ClientPort(String name, Artefact owner, boolean isRemote) {
        super(name, owner, isRemote);
    }

    public ClientPort(String name, Artefact owner, boolean isRemote, boolean isOptional) {
        super(name, owner, isRemote);
        this.optional = isOptional;
    }

    public ClientPort(String name, List<Property> properties, Artefact owner, boolean isRemote, boolean isOptional) {
        super(name, properties, owner, isRemote);
        this.optional = isOptional;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitClientPort(this);
    }

    
    @Deprecated
    public void setIsOptional(boolean isOptional) {
        this.optional = isOptional;
    }

    @Deprecated
    public boolean getIsOptional() {
        return optional;
    }

    public void setOptional(boolean isOptional) {
        this.optional = isOptional;
    }
    
    public boolean isOptional() {
        return optional;
    }
    
    public boolean isMandatory() {
        return !this.optional;
    }
    
    @Override
    public String toString() {
        return "ClientTypePort " + getName() + " ownerType" + owner.getName();
    }

    
}
