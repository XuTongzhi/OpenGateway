package org.imooc.core.context;

import io.netty.channel.ChannelHandlerContext;

public interface IContext {

    /**
     * 上下文生命周期，运行中状态
     */
    int Running = 1;

    /**
     * 运行过程中发生错误，对其进行标记，告诉我们请求已经结束，需要返回客户端
     */
    int Written = 0;

    /**
     * 标记写回成功，防止并发情况下的多次写回
     */
    int Completed = 1;
    /**
     * 标识网关请求结束
     */
    int Terminated = 2;

    /**
     * 设置上下文状态为运行中
     */
    void runned();

    /**
     * 设置上下文状态为标记写回
     */
    void writtened();

    /**
     * 设置上下文状态为标记写回成功
     */
    void completed();

    /**
     * 设置上下文状态为请求结束
     */
    void terminated();

    /**
     * 判断网关状态
     */
    boolean isRunning();
    boolean isWritten();
    boolean isCompleted();
    boolean isTerminated();

    /**
     * 获取协议
     * @return
     */
    String getProtocol();

    /**
     * 获取请求对象
     * @return
     */
    Object getRequest();

    /**
     * 获取返回对象
     * @return
     */
    Object getResponse();

    /**
     * 设置返回对象
     * @return
     */
    Object setResponse(Object response);

    /**
     * 获取返回对象
     * @return
     */
    Object getThrowable();

    /**
     * 设置返回对象
     * @return
     */
    Object setThrowable(Throwable throwable);

    /**
     * 获取Netty上下文
     * @return
     */
    ChannelHandlerContext getNettyCtx();

    /**
     *
     * @return
     */
    boolean isKeepAlive();

}
