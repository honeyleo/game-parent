package cn.gs.network.message;

import io.netty.channel.Channel;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月13日
 * 类说明：
 * 
 * 最后修改时间：2015年2月13日
 * 修改内容： 新建此类
 */
public interface IMessage {

	/**
	 * 包大小
	 * @return
	 */
	int size();
	/**
	 * 指令
	 * @return
	 */
	int cmd();
	/**
	 * 消息体字节流
	 * @return
	 */
	byte[] data();
	/**
	 * 玩家ID
	 * @return
	 */
	int pid();
	/**
	 * 该消息通道
	 * @return
	 */
	Channel channel();
	/**
	 * 包体
	 * @param clazz
	 * @return
	 */
	<T> T parseBody(Class<? extends  Message> clazz) throws InvalidProtocolBufferException;
}
