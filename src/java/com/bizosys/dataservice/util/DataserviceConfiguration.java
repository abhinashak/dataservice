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

package com.bizosys.dataservice.util;

public class DataserviceConfiguration {

	private static DataserviceConfiguration instance = null;
	public  static final DataserviceConfiguration getInstance() {
		if ( null != instance) return instance;
		synchronized (DataserviceConfiguration.class.getName()) {
			if ( null != instance) return instance;
			instance = new DataserviceConfiguration();
		}
		return instance;
	}
	
	private Configuration config = null;
	private DataserviceConfiguration() {
		this.config = new Configuration("dataservice-default.xml", "dataservice-site.xml");
	}
	
	public final Configuration getConfiguration() {
		return config;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println ( DataserviceConfiguration.getInstance().getConfiguration().get("privatekey") );
	}

}
