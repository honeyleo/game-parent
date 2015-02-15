package cn.gs.network.message;

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

	private Message(int size, int cmd, byte[] data) {
		
	}
	public static IMessage build(int size, int cmd, byte[] data) {
		return null;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cmd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pid() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T parseBody(Class<? extends com.google.protobuf.Message> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
