package com.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

@ComponentScan
@Slf4j
public class CustomPartitioner implements Partitioner {

    @Override
    public void configure(Map<String, ?> map) {
        log.info("Total partitions are ::" );
    }

    @Override
    public void close() {

    }

    @Override
    public int partition(String s, Object key, byte[] keyBytes, Object val, byte[] valBytes, Cluster cluster) {
        int noOfPartitions = cluster.partitionCountForTopic(s);
        log.info("Total partitions are :: " + noOfPartitions);
        return  Integer.parseInt(String.valueOf(key)) % noOfPartitions;
    }

}
