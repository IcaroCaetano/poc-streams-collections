package com.myprojetcicaro.poc_streams_collections;

import com.myprojetcicaro.poc_streams_collections.list.ListExamples;
import com.myprojetcicaro.poc_streams_collections.map.MapExamples;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocStreamsCollectionsApplication {

	public static void main(String[] args) {

		System.out.println("******Lists******");
		ListExamples.run();

		System.out.println();
		System.out.println("******Maps******");
		MapExamples.run();
	}
}
