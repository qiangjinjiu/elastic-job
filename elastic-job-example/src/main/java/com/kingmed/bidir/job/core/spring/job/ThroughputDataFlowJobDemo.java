/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.kingmed.bidir.job.core.spring.job;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.dataflow.AbstractIndividualThroughputDataFlowElasticJob;
import com.dangdang.example.elasticjob.utils.PrintContext;

@Component
public class ThroughputDataFlowJobDemo extends AbstractIndividualThroughputDataFlowElasticJob<String> {
    
    private PrintContext printContext = new PrintContext(ThroughputDataFlowJobDemo.class);
        
    @Override
    public List<String> fetchData(final JobExecutionMultipleShardingContext context) {
        printContext.printFetchDataMessage(context.getShardingItems());
        List<String> re = new ArrayList<String>();
        re.add("hello");
        re.add("world");
        Map<Integer, String> shardingItemParams = context.getShardingItemParameters();
        for(Integer key: shardingItemParams.keySet()) {
        	System.out.println(key + " = " + shardingItemParams.get(key));
        }
        return re;
    }
    
    @Override
    public boolean processData(final JobExecutionMultipleShardingContext context, final String data) {
        printContext.printProcessDataMessage(data);
        System.out.println(data);
        return true;
    }
    
    @Override
    public boolean isStreamingProcess() {
        return false;
    }
}
