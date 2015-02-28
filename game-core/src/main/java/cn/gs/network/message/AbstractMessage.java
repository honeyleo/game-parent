package cn.gs.network.message;

import io.netty.channel.Channel;

import com.google.protobuf.InvalidProtocolBufferException;

public abstract class AbstractMessage implements IMessage {

	private int size;
	private int cmd;
	private byte[] data;
	private Channel channel;
	
	protected AbstractMessage(int size, int cmd, byte[] data, Channel channel) {
		this.size = size;
		this.cmd = cmd;
		this.data = data;
		this.channel = channel;
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
	public byte[] data() {
		return data;
	}

	
	@Override
	public int pid() {
		return 0;
	}

	@Override
	public Channel channel() {
		return channel;
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
