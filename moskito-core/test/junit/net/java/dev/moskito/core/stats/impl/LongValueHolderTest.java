package net.java.dev.moskito.core.stats.impl;

import org.junit.Test;
import static org.junit.Assert.*;

public class LongValueHolderTest {
	@Test public void testArythmetics(){
		LongValueHolder h = new LongValueHolder(null);
		
		for (int i=0; i<100; i++)
			h.increase();
		
		assertEquals(100, h.getCurrentValueAsInt());

		for (int i=0; i<100; i++)
			h.decrease();
		
		assertEquals(0, h.getCurrentValueAsInt());
	}
	
	@Test public void testReset(){
		LongValueHolder h = new LongValueHolder(null);
		h.setDefaultValueAsInt(100);
		h.reset();
		assertEquals(100, h.getCurrentValueAsInt());
	}

	@Test public void testResetWithConversion(){
		LongValueHolder h = new LongValueHolder(null);
		h.setDefaultValueAsLong(100);
		h.reset();
		assertEquals(100l, h.getCurrentValueAsLong());
		assertEquals(100, h.getCurrentValueAsInt());
		assertEquals(100.0, h.getCurrentValueAsDouble(), 0.0001);

		h.setDefaultValueAsDouble(100.0);
		h.reset();
		assertEquals(100l, h.getCurrentValueAsLong());
		assertEquals(100, h.getCurrentValueAsInt());
		assertEquals(100.0, h.getCurrentValueAsDouble(), 0.0001);
	
	
	}
	
	@Test public void testConversion(){
		LongValueHolder h = new LongValueHolder(null);
		
		h.setValueAsDouble(100.0);
		assertEquals(100l, h.getCurrentValueAsLong());
		assertEquals(100, h.getCurrentValueAsInt());
		assertEquals(100.0, h.getCurrentValueAsDouble(), 0.0001);

		h.setValueAsLong(100l);
		assertEquals(100l, h.getCurrentValueAsLong());
		assertEquals(100, h.getCurrentValueAsInt());
		assertEquals(100.0, h.getCurrentValueAsDouble(), 0.0001);

	}
	
	@Test public void testIncreaseBy(){
		LongValueHolder h = new LongValueHolder(null);
		h.increaseByDouble(100.0);
		h.increaseByInt(25);
		h.increaseByLong(250L);
		assertEquals(25+250+100, h.getCurrentValueAsInt());
	}

	@Test public void testDecreaseBy(){
		LongValueHolder h = new LongValueHolder(null);
		h.setValueAsInt(1000);
		h.decreaseByDouble(100.0);
		h.decreaseByInt(25);
		h.decreaseByLong(250L);
		assertEquals(1000-(25+250+100), h.getCurrentValueAsInt());
	}
	
	@Test public void testUpdate(){
		LongValueHolder h = new LongValueHolder(null);
		h.setDefaultValueAsInt(50);
		h.reset();
		
		h.increaseByInt(25);
		h.intervalUpdated(null);
		
		//test that update restored default value
		assertEquals(h.getCurrentValueAsInt(), 50);
		
		//test that update stored the proper value as last - 50default + 25 increase
		assertEquals(75, h.getValueAsInt());
		assertEquals(75l, h.getValueAsLong());
		assertEquals(75.0, h.getValueAsDouble(), 0.0001);
		
	}
}
