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

package org.gvlabs.math.utils.numeric.rootfinding;

import java.math.BigDecimal;

import org.gvlabs.math.utils.CommonValues;
import org.gvlabs.math.utils.Function;
import org.gvlabs.math.utils.Interval;

/**
 * Bissection Root Finding Method
 * 
 * @author Thiago Galbiatti Vespa
 * @version 1.0
 * 
 */
public class BissectionMethod extends AbstractIntervalMethod {

	@Override
	public BigDecimal findARoot(BigDecimal aP, BigDecimal bP,
			BigDecimal precision, Function f, long maxIter) {

		BigDecimal a = aP;
		BigDecimal b = bP;

		for (long k = 0; k < maxIter; k++) {

			// x = (a + b)/2
			BigDecimal x = a.add(b).divide(CommonValues.TWO.getValue());

			// (b - a) < precision
			if (b.subtract(a).compareTo(precision) < 0) {
				// result a or b is ok too
				return x;
			}

			// m = f(a)
			BigDecimal m = f.evaluate(a);

			// m*f(x) > 0
			if (m.multiply(f.evaluate(x)).compareTo(BigDecimal.ZERO) > 0) {
				a = x;
			} else {
				b = x;
			}
		}
		// found no root
		return null;
	}

	/**
	 * Estimate the number of iterations necessary to find a root
	 * 
	 * @param i
	 *            interval
	 * @param precision
	 *            precision
	 * @return number of iterations necessary to find a root
	 */
	public long estimateMaxIter(Interval i, BigDecimal precision) {
		// (log_10(b - a) - log(precision))/log_10(2)
		return (long) Math.ceil((Math.log10(i.getB().subtract(i.getA())
				.doubleValue()) - Math.log10(precision.doubleValue())
				/ Math.log10(2.0)));
	}

}
