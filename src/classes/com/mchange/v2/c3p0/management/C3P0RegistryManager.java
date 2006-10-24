/*
 * Distributed as part of c3p0 v.0.9.1-pre10
 *
 * Copyright (C) 2005 Machinery For Change, Inc.
 *
 * Author: Steve Waldman <swaldman@mchange.com>
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 2.1, as 
 * published by the Free Software Foundation.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this software; see the file LICENSE.  If not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 */


package com.mchange.v2.c3p0.management;

import java.util.*;
import com.mchange.v2.c3p0.C3P0Registry;

public class C3P0RegistryManager implements C3P0RegistryManagerMBean 
{
    public String[] getAllIdentityTokens()
    { 
	Set tokens = C3P0Registry.allIdentityTokens(); 
	return (String[]) tokens.toArray( new String[ tokens.size() ] );
    }

    public Set getAllIdentityTokenized()
    { return C3P0Registry.allIdentityTokenized(); }

    public Set getAllPooledDataSources()
    { return C3P0Registry.allPooledDataSources(); }

    public int getAllIdentityTokenCount()
    { return C3P0Registry.allIdentityTokens().size(); }

    public int getAllIdentityTokenizedCount()
    { return C3P0Registry.allIdentityTokenized().size(); }

    public int getAllPooledDataSourcesCount()
    { return C3P0Registry.allPooledDataSources().size(); }

    public String[] getAllIdentityTokenizedStringified()
    { return stringifySet( C3P0Registry.allIdentityTokenized() ); }

    public String[] getAllPooledDataSourcesStringified()
    { return stringifySet( C3P0Registry.allPooledDataSources() ); }

    private String[] stringifySet(Set s)
    {
	String[] out = new String[ s.size() ];
	int i = 0;
	for (Iterator ii = s.iterator(); ii.hasNext(); )
	    out[i++] = ii.next().toString();
	return out;
    }
}