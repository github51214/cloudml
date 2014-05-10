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


package org.cloudml.core.builders;

import org.cloudml.core.Port;


public abstract class PortBuilder<T extends Port, N extends PortBuilder<?,?>> extends WithResourcesBuilder<T, N> {

    private boolean local;
    private int portNumber;
            
    public PortBuilder() {
        local = Port.REMOTE;
        portNumber = Port.DEFAULT_PORT_NUMBER;
    }
    
    protected boolean isLocal() {
        return local;
    }
    
    public N withPortNumber(int portNumber) {
        this.portNumber = portNumber;
        return next();
    }
    
    public N remote() {
        this.local = false;
        return next();
    }
    
    public N local() {
        this.local = true;
        return next();
    }
        
    protected void prepare(T port) {
        super.prepare(port);
        port.setPortNumber(portNumber);
    }
    
    
}