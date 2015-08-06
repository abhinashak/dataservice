/*
* Copyright 2015 Bizosys Technologies Limited
*
* Licensed to the Bizosys Technologies Limited (Bizosys) under one
* or more contributor license agreements. See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership. The Bizosys licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.bizosys.dataservice.management;

import java.lang.management.*;

public class PerformanceMonitor { 

	/** Get CPU time in nanoseconds. */
	public long getCpuTime( ) {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	    return bean.isCurrentThreadCpuTimeSupported( ) ?
	        bean.getCurrentThreadCpuTime( ) : 0L;
	}
	 
	/** Get user time in nanoseconds. */
	public long getUserTime( ) {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	    return bean.isCurrentThreadCpuTimeSupported( ) ?
	        bean.getCurrentThreadUserTime( ) : 0L;
	}
	
	public static void main(String args[]) {
		for ( int i=0; i< 1000; i++) measure();
	}
	
	public static void measure() {
		PerformanceMonitor pm = new PerformanceMonitor();
		
		long startSystemTimeNano = pm.getCpuTime( );
		long startUserTimeNano   = pm.getUserTime( );
		long st = System.currentTimeMillis();

		for ( long i=0; i<10000000000L; i++) {
			double j = i * 23.f; 
		}
		
		long ed = System.currentTimeMillis();
		long duration = (ed - st);
		long taskUserTimeNano    = pm.getUserTime( ) - startUserTimeNano;
		long taskUserTimePct = (taskUserTimeNano/(duration * 10000));

		long taskSystemTimeNano  = pm.getCpuTime( ) - startSystemTimeNano;
		long taskSystemTimeNanoPct = (taskSystemTimeNano/(duration * 10000));
		
		System.out.println( "CPU Time:" + taskSystemTimeNanoPct + "/" +  taskUserTimePct  + "/" + duration );
		
	}

}