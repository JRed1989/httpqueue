package org.httpqueue.protocolbean;

/**
 * Created by andilyliao on 16-4-1.
 */
public class OutputHead {
    //任务类型
    private int ty;
    //是否从持久化读取
    private int h;
    //需要获取的消息的位置
    private int o;
    //事务中数据序号
    private int s;

    public int getTy() {
        return ty;
    }

    public void setTy(int ty) {
        this.ty = ty;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }
}
