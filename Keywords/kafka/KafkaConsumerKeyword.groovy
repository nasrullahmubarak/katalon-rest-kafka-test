package kafka

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.ConsumerRecord
import com.kms.katalon.core.annotation.Keyword

import java.util.Properties
import java.util.Arrays

class KafkaConsumerKeyword {
    @Keyword
    def consumeMessage(String topic) {
        Properties props = new Properties()
        props.put("bootstrap.servers", "localhost:9092")
        props.put("group.id", "test-group")
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)
        consumer.subscribe(Arrays.asList(topic))

        ConsumerRecords<String, String> records = consumer.poll(5000)
        for (ConsumerRecord<String, String> record : records) {
            println("Received message: " + record.value())
        }

        consumer.close()
    }
}
