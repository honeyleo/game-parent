package cn.gs.network.message;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月14日
 * 类说明：
 * 
 * 最后修改时间：2015年2月14日
 * 修改内容： 新建此类
 */
public class Message implements IMessage {

	private int size;
	private int cmd;
	private byte[] data;
	
	private Message(int size, int cmd, byte[] data) {
		
	}
	public static IMessage build(int size, int cmd, byte[] data) {
		return null;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public int cmd() {
		return cmd;
	}

	@Override
	public int pid() {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T parseBody(Class<? extends com.google.protobuf.Message> clazz) throws InvalidProtocolBufferException {
		try {
			T t = (T)clazz.newInstance().getParserForType().parseFrom(data);
			return t;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
