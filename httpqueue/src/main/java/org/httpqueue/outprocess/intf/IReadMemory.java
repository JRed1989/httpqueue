package org.httpqueue.outprocess.intf;

import org.httpqueue.protocolbean.MessageBody;

/**
 * Created by andilyliao on 16-3-31.
 */
public interface IReadMemory {
    public void registDirectQueue(String queueName)throws Exception;
    public int registFanoutQueue(String clientID,String queueName)throws Exception;//返回当前pubset
    public int registTopic(String clientID,String queueName)throws Exception;//返回当前pubset
    public MessageBody outputDirect(String queName,int offset,int seq)throws Exception;//返回消息内容
    public MessageBody outputFanout(String clientID, String queName, int offset, int seq)throws Exception;//返回消息内容
    public MessageBody outputTopic(String clientID,String queName,int offset,int seq)throws Exception;//返回消息内容

}
