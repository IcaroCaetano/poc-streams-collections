package com.myprojetcicaro.poc_streams_collections;

import com.myprojetcicaro.poc_streams_collections.enummap.EnumMapExamples;
import com.myprojetcicaro.poc_streams_collections.enumset.EnumSetExamples;
import com.myprojetcicaro.poc_streams_collections.hashmap.HashMapExamples;
import com.myprojetcicaro.poc_streams_collections.hashset.HashSetExamples;
import com.myprojetcicaro.poc_streams_collections.hashtable.HashtableExamples;
import com.myprojetcicaro.poc_streams_collections.linkedhashmap.LinkedHashMapExamples;
import com.myprojetcicaro.poc_streams_collections.linkedlist.LinkedListExamples;
import com.myprojetcicaro.poc_streams_collections.list.ListExamples;
import com.myprojetcicaro.poc_streams_collections.listiterator.ListIteratorExamples;
import com.myprojetcicaro.poc_streams_collections.map.MapExamples;
import com.myprojetcicaro.poc_streams_collections.treemap.TreeMapExamples;
import com.myprojetcicaro.poc_streams_collections.vector.VectorExamples;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocStreamsCollectionsApplication {

	public static void main(String[] args) {

		System.out.println("******Lists******");
		ListExamples.run();

		System.out.println("******Maps******");
		MapExamples.run();

		System.out.println("\n******HashMap******");
		HashMapExamples.run();

		System.out.println("******ListIterator******");
		ListIteratorExamples.run();

		System.out.println("******HashSet******");
		HashSetExamples.run();

		System.out.println("******HashTable******");
		HashtableExamples.run();

		System.out.println("******TreeMap******");
		TreeMapExamples.run();

		System.out.println("******LinkedHashMap******");
		LinkedHashMapExamples.run();

		System.out.println("******EnumSet******");
		EnumSetExamples.run();

		System.out.println("******EnumMap******");
		EnumMapExamples.run();

		System.out.println("******LinkedList******");
		LinkedListExamples.run();

		System.out.println("******Vector******");
		VectorExamples.run();


	}
}
