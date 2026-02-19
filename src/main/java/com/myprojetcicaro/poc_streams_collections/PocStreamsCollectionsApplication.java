package com.myprojetcicaro.poc_streams_collections;

import com.myprojetcicaro.poc_streams_collections.hashmap.HashMapExamples;
import com.myprojetcicaro.poc_streams_collections.hashset.HashSetExamples;
import com.myprojetcicaro.poc_streams_collections.list.ListExamples;
import com.myprojetcicaro.poc_streams_collections.listiterator.ListIteratorExamples;
import com.myprojetcicaro.poc_streams_collections.map.MapExamples;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocStreamsCollectionsApplication {

	public static void main(String[] args) {

		System.out.println("******Lists******");
		ListExamples.run();

		System.out.println();
		System.out.println("******Maps******");
		MapExamples.run();

		System.out.println("\n******HashMap******");
		HashMapExamples.run();

		System.out.println("******ListIterator******");
		ListIteratorExamples.run();

		System.out.println("******HashSet******");
		HashSetExamples.run();

	}
}
