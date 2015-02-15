package cn.gs.network.server.loader;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.gs.network.server.config.NettyServerConfig;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao 创建时间：2015年2月14日 类说明：
 * 
 *         最后修改时间：2015年2月14日 修改内容： 新建此类
 */
public class NettyServerConfigXmlLoader {

	private Logger log = LoggerFactory
			.getLogger(NettyServerConfigXmlLoader.class);

	public NettyServerConfig load(String file) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
			Document doc = builder.parse(in);
			NodeList list = doc.getElementsByTagName("server");

			NettyServerConfig config = new NettyServerConfig();
			if (list.getLength() > 0) {
				Node node = list.item(0);
				NodeList childs = node.getChildNodes();
				for (int j = 0; j < childs.getLength(); j++) {
					if ("server-name".equals(childs.item(j).getNodeName())) {
						config.setName(childs.item(j).getTextContent());
					} else if ("server-id".equals(childs.item(j).getNodeName())) {
						config.setId(Integer.parseInt(childs.item(j)
								.getTextContent()));
					} else if ("server-web"
							.equals(childs.item(j).getNodeName())) {
						config.setWeb(childs.item(j).getTextContent());
					} else if ("server-netty-port".equals(childs.item(j).getNodeName())) {
						config.setMina_port(Integer.parseInt(childs.item(j).getTextContent()));
					}
				}
			}
			in.close();

			return config;
		} catch (Exception e) {
			this.log.error(e.getMessage(), e);
		}
		return null;
	}
}
