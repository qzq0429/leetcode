package com.qzq.leetcode.my;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaTest {
	public static void main(String[] args) {
		kafka32start();
		kafka42start();
	}
	
	public static void kafka32start() {
//		Properties kafkaProps = new Properties();
//		kafkaProps.put("bootstrap.servers","192.168.63.100:9092");
//		kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//		kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//		KafkaProducer<String,String> producer = new KafkaProducer<String,String>(kafkaProps);
//		ProducerRecord<String, String> record = new ProducerRecord<String, String>("CustomerCountry", "Precision Products","France");
//		try {
//		producer.send(record);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.63.100:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
 
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i)));
        }
        producer.close();
	}
	
	public static void kafka42start() {
//		Properties kafkaProps = new Properties();
//		kafkaProps.put("bootstrap.servers", "192.168.63.100:9092");
//		kafkaProps.put("group.id", "group-1");
//		kafkaProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		kafkaProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		kafkaProps.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
//		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kafkaProps);
//		consumer.subscribe(Collections.singleton("CustomerCountry"));
//		while (true) {
//			ConsumerRecords<String, String> records = consumer.poll(100);
//			for (ConsumerRecord<String, String> record : records) {
//				System.out.println(record.key());
//				System.out.println(record.value());
//			}
//		}
		
		  Properties props = new Properties();
	        props.put("bootstrap.servers", "192.168.63.100:9092");
	        props.put("group.id", "group-201");
	        //props.put("enable.auto.commit", "true");
	        props.put("auto.commit.interval.ms", "1000");
	        props.put("session.timeout.ms", "30000");
	        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	 
	        Consumer<String,String> consumer = new KafkaConsumer<String,String>(props);
	        consumer.subscribe(Arrays.asList("test"));
	        while(true){
	            ConsumerRecords<String,String> records = consumer.poll(100);
	            for(ConsumerRecord<String,String> record : records){
	                System.out.println("offset=" + record.offset() + ",--key=" + record.key() + ",--value=" + record.value());
	            }
	        }


	}
}
