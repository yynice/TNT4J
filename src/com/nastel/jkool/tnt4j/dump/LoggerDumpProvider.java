/*
 * Copyright 2014 Nastel Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nastel.jkool.tnt4j.dump;

import java.util.List;
import java.util.Map;

import com.nastel.jkool.tnt4j.TrackingLogger;

/**
 * <p>
 * This class is a dump provider for TNT4J registered loggers
 * 
 * </p>
 * 
 * @see DumpCollection
 * 
 * @version $Revision: 3 $
 * 
 */
public class LoggerDumpProvider extends DefaultDumpProvider {

	/**
	 * Create a new logger dump provider with a given name
	 * 
	 *@param name
	 *            provider name
	 */
	public LoggerDumpProvider(String name) {
	    super(name, "Logger");
    }

	/**
	 * Create a new logger dump provider with a given name
	 * and category
	 * 
	 *@param name
	 *            provider name
	 *@param cat
	 *            category name
	 */
	public LoggerDumpProvider(String name, String cat) {
	    super(name, cat);
    }

	@Override
	public DumpCollection getDump() {
		Dump rootDump = new Dump("LoggerStats", this);		
		List<TrackingLogger> list = TrackingLogger.getAllTrackers();
		for (TrackingLogger logger: list) {
			Dump dump = new Dump(logger.getId(), this);
			Map<String, Object> stats = logger.getStats();
			dump.addAll(stats);
			dump.add("source", logger.getSource().getFQName());
			rootDump.add(logger.getId(), dump);
		}
		return rootDump;
	}
}