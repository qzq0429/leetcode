package com.qzq.leetcode.hashmap;

public interface Map<K,V> {

	/**
	 * Returns the number of key-value mappings in this map.
	 * If the map contains more than Integer.MAX_VALUE elements,returns
	 * Integer.MAXVALUE.
	 * 
	 * @return the number of key-value mappings in this map
	 */
	int size();
	
	/**
	 * Return  <tt>true</tt> if this map contains no key-value mappings.
	 * 
	 * @return <tt>true</tt> if this map contains no key-value mappings
	 */
	boolean isEmpty();
	
	/**
	 * Return <tt>true</tt> if this map contains a mapping for the specified
	 * key. More formally, returns <tt>true</tt> if and only if 
	 * this map contains a mapping for a key <tt>k</tt> such that 
	 * <tt>(key==null ? k==null:key.equals(k))
	 * @param key key whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map contains a mapping for the specified
     *         key
	 */
	boolean containsKey(Object key);
	
	
	/**
	 * Return true if this map one or more keys to the specified value
	 * More formally, returns true if and only if this map contains at
	 * least one mapping to a value v such that value == null ? 
	 * v==null ? value.equals(v). this operation will probably require 
	 * time  linear in the map size for most implementations of the Map
	 * interface
	 * @param value
	 * @return true if this map maps one or more keys to the specified value
	 * @throws ClassCastException if the value is of an inappropriate type
	 * for  this map
	 */
	boolean containsValue(Object value);
	
	/**
	 * Returns the value to which the specified key is mapped,
	 * or {@code null} if this map contains no mapping for the key.
	 * 
	 * <p>More formally,if this map contains a mapping from a key 
	 * {@code k} to a value{@code v} such that {@code (key == null ? k==null :
	 * key.equals(k))},then this method return {@code v};otherwise it return
	 * {@code null}.(There can be at most one such mapping.)
	 * 
	 * If this map permits null values,then a return value of {@code null}
	 * does not <i>necessarily</i> indicate that the map
	 * contains no mapping for the key; it's also possible that the map
	 * explicitly maps the key to {@code null}. The {@link #containsKey
	 * containsKey} operation may be used to distinguish these two cases.
	 * 
	 * @param key the key whose associated value is to be returned
	 * @return the value to which the specified is mapped ,or
	 * {@code null} if this map contains no mapping for the key
	 */
	V get(Object key);
	
	
	
}
