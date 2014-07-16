/*
 Copyright 2014 GVLabs.org

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.gvlabs.math.utils;

import java.math.BigDecimal;

/**
 * Common BigDecimal values, except 0, 1 and 10, because these already exists in
 * BigDecimal class
 * 
 * @author Thiago Galbiatti Vespa
 * @version 1.0
 * 
 */
public enum CommonValues {
	TWO(new BigDecimal(2));

	private BigDecimal value;

	private CommonValues(BigDecimal value) {
		this.value = value;
	}

	/**
	 * Returns the BigDecimal value associated to the enum
	 * 
	 * @return the BigDecimal value
	 */
	public BigDecimal getValue() {
		return value;
	}

}
