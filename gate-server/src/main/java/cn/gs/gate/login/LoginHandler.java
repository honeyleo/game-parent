package cn.gs.gate.login;

import io.netty.util.AttributeKey;
import cn.gs.handler.Handler;
import cn.gs.network.message.IMessage;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年3月11日
 * 类说明：
 * 
 * 最后修改时间：2015年3月11日
 * 修改内容： 新建此类
 */
public class LoginHandler implements Handler {

	@Override
	public void handle(IMessage message) {
		//解包出来验证玩家登录
		int pid = 0;
		AttributeKey<Integer> key = AttributeKey.valueOf(message.channel().id().asLongText());
		message.channel().attr(key).set(pid);
	}

}
