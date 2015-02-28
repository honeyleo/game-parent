package cn.gs.handler;

import cn.gs.network.message.IMessage;

/**
 * 消息处理器接口
 * @author Leo.liao
 *
 */
public interface Handler {

	/**
	 * 消息处理方法
	 * @param message
	 */
	void handle(IMessage message);
}
