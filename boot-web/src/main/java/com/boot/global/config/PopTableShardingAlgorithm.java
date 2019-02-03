//package com.boot.global.config;
//
//import com.boot.common.exception.ShardingAlgorithmException;
//import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
//import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
//
//import java.util.Collection;
//
///**
// * Created by meijie on 2019/2/3.
// */
//public class PopTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
//    @Override
//    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
//        for (String col : collection) {
//            if (col.endsWith(String.valueOf(preciseShardingValue.getValue() % collection.size()))) {
//                return col;
//            }
//        }
//        throw new ShardingAlgorithmException();
//    }
//}
