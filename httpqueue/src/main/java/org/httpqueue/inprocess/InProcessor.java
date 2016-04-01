package org.httpqueue.inprocess;

import org.httpqueue.inprocess.intf.IInProcessor;
import org.httpqueue.inprocess.task.intf.IInputCreate;
import org.httpqueue.inprocess.task.InputCreate;
import org.httpqueue.protocolbean.InputHead;
import org.httpqueue.protocolbean.Mode;

/**
 * Created by andilyliao on 16-3-31.
 */
//log.debug("Type is "+type+"mode is: " + mode + " ttl is: " + ttl + " hashdisk is: " + hashdisk + " hastransaction is: "+hastransaction+" seq is: " + seq);

public class InProcessor implements IInProcessor {
    @Override
    public void process(String queueName,InputHead inputHead, String body) throws Exception {
        int type=inputHead.getTy();
        switch (type){
            case Mode.INPUTTYPE_CREATEQUEUE:
                IInputCreate inputCreate=new InputCreate();
                int mode=inputHead.getM();
                int hashdisk=inputHead.getH();
                switch (mode){
                    case Mode.MODE_DIRECT:
                        switch (hashdisk){
                            case Mode.HASHDISK_WITHDISK:
                                inputCreate.createDirectWithDisk(queueName);
                                break;
                            case Mode.HASHDISK_WITHOUTDISK:
                                inputCreate.createDirectWithoutDisk(queueName);
                                break;
                            default:
                                throw new Exception("Header doesn't has hashdisk param");
                        }
                        break;
                    case Mode.MODE_FANOUT:
                        switch (hashdisk){
                            case Mode.HASHDISK_WITHDISK:
                                inputCreate.createFanoutWithDisk(queueName);
                                break;
                            case Mode.HASHDISK_WITHOUTDISK:
                                inputCreate.createFanoutWithoutDisk(queueName);
                                break;
                            default:
                                throw new Exception("Header doesn't has hashdisk param");
                        }
                        break;
                    case Mode.MODE_TOPIC:
                        inputCreate.createTopic(queueName);
                        break;
                    default:
                        throw new Exception("Header doesn't has mode param");
                }
                break;
            case Mode.INPUTTYPE_PUBLISH:
                break;
            default:
                throw new Exception("Header doesn't has type param");
        }
    }
}
