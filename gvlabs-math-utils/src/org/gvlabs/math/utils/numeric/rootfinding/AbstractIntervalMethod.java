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

import org.gvlabs.math.utils.Function;
import org.gvlabs.math.utils.Interval;

/**
 * Abstract Finding Root Method Class using an interval and precision
 * We have two stop point: by precision or maximum number of iterations
 * 
 * @author Thiago Galbiatti Vespa
 * @version 1.1
 * 
 */
public abstract class AbstractIntervalMethod {

	/**
	 * Try to find a root
	 * 
	 * @param a
	 *            lower value of the interval
	 * @param b
	 *            greater value of the interval
	 * @param precision
	 *            precision
	 * @param f
	 *            function
	 * @param maxIter
	 *            max number of interactions
	 * @return the approximated root if found and null otherwise
	 */
	public BigDecimal findARoot(double a, double b, double precision,
			Function f, long maxIter) {
		BigDecimal bigA = new BigDecimal(a);
		BigDecimal bigB = new BigDecimal(b);
		BigDecimal bigPrecision = new BigDecimal(precision);
		return findARoot(bigA, bigB, bigPrecision, f, maxIter);
	}

	/**
	 * Try to find a root
	 * 
	 * @param i
	 *            interval
	 * @param precision
	 *            precision
	 * @param f
	 *            function
	 * @param maxIter
	 *            max number of interactions
	 * @return the approximated root if found and null otherwise
	 */
	public BigDecimal findARoot(Interval i, BigDecimal precision, Function f,
			long maxIter) {
		BigDecimal a = i.getA();
		BigDecimal b = i.getB();
		return findARoot(a, b, precision, f, maxIter);
	}

	/**
	 * Intermediate value theorem (Bolzano's theorem)
	 * 
	 * @param i
	 *            interval
	 * @param f
	 *            function
	 * @return true if has at least one root, false if it is inconclusive
	 */
	public boolean hasRoot(Interval i, Function f) {
		// if f(a) and f(b) has opposite signs, there must be at least one root
		// within this interval if this is a continuous function
		return f.evaluate(i.getA()).multiply(f.evaluate(i.getB()))
				.compareTo(BigDecimal.ZERO) < 0;
	}

	/**
	 * Try to find a root
	 * 
	 * @param a
	 *            lower value of the interval
	 * @param b
	 *            greater value of the interval
	 * @param precision
	 *            precision
	 * @param f
	 *            function
	 * @param maxIter
	 *            max number of interactions
	 * @return the approximated root if found and null otherwise
	 */
	public abstract BigDecimal findARoot(BigDecimal a, BigDecimal b,
			BigDecimal precision, Function f, long maxIter);

}
