package org.gvlabs.math.utils.numeric.rootfinding;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.gvlabs.math.utils.Function;
import org.gvlabs.math.utils.Interval;
import org.junit.Before;
import org.junit.Test;

public class BissectionMethodTest {

	BissectionMethod bm = null;
	Interval i1;
	Interval i2;
	Function f1;
	Function f2;
	Function f3;

	@Before
	public void setUp() throws Exception {
		bm = new BissectionMethod();
		i1 = new Interval(2.0, 3.0);
		i2 = new Interval(0.0, 1.0);
		f1 = new Function() {

			@Override
			public BigDecimal evaluate(BigDecimal x) {
				// f(x) = x*log_10(x) - 1
				return new BigDecimal(x.doubleValue()
						* Math.log10(x.doubleValue()) - 1.0);
			}
		};
		f2 = new Function() {

			@Override
			public BigDecimal evaluate(BigDecimal x) {
				// f(x) = x^3 - 9x + 3
				return new BigDecimal(Math.pow(x.doubleValue(), 3) - 9
						* x.doubleValue() + 3);
			}
		};
		f3 = new Function() {

			@Override
			public BigDecimal evaluate(BigDecimal x) {
				// f(x) = x^2 + 1
				return new BigDecimal(x.pow(2).doubleValue() + 1.0);
			}
		};
	}

	@Test
	public void testHasRoot() {
		boolean hasRootF1 = bm.hasRoot(i1, f1);
		assertTrue("this function must have a root", hasRootF1);
		boolean hasRootF2 = bm.hasRoot(i2, f2);
		assertTrue("this function must have a root", hasRootF2);
		boolean hasRootF3 = bm.hasRoot(i2, f3);
		assertFalse("this function must not have a root", hasRootF3);

	}

	@Test
	public void testFindARoot() {

		BigDecimal root = bm.findARoot(i1, new BigDecimal(0.00001), f1, 100);

		assertTrue("Root must be between 2.5018 and 2.5019",
				root.doubleValue() > 2.50618 && root.doubleValue() < 2.50619);

		root = bm.findARoot(i2, new BigDecimal(0.001), f2, 100);

		assertTrue("Root must be between 0.33 and 0.34",
				root.doubleValue() > 0.33 && root.doubleValue() < 0.34);

	}

}
