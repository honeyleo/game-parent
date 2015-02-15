package cn.gs.network.server.loader;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.gs.network.server.config.ClientServerConfig;
import cn.gs.network.server.config.ServerInfo;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao 创建时间：2015年2月14日 类说明：
 * 
 *         最后修改时间：2015年2月14日 修改内容： 新建此类
 */
public class ClientServerConfigXmlLoader {

	private Logger log = LoggerFactory
			.getLogger(ClientServerConfigXmlLoader.class);

	public ClientServerConfig load(String file) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
			Document doc = builder.parse(in);
			NodeList list = doc.getElementsByTagName("server");

			ClientServerConfig config = new ClientServerConfig();
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
					} else if ("gate-servers".equals(childs.item(j)
							.getNodeName())) {
						NodeList servers = childs.item(j).getChildNodes();
						for (int k = 0; k < servers.getLength(); k++) {
							if ("gate-server".equals(servers.item(k)
									.getNodeName())) {
								Node line = servers.item(k);
								ServerInfo info = new ServerInfo();
								NodeList attrs = line.getChildNodes();
								for (int l = 0; l < attrs.getLength(); l++) {
									if ("server-id".equals(attrs.item(l)
											.getNodeName())) {
										info.setId(Integer.parseInt(attrs.item(
												l).getTextContent()));
									} else if ("server-ip".equals(attrs.item(l)
											.getNodeName())) {
										info.setIp(attrs.item(l)
												.getTextContent());
									} else if ("server-port".equals(attrs.item(
											l).getNodeName())) {
										info.setPort(Integer.parseInt(attrs
												.item(l).getTextContent()));
									}
								}
								config.getGateServers().add(info);
							}
						}
					} else if ("world-server".equals(childs.item(j)
							.getNodeName())) {
						ServerInfo info = new ServerInfo();
						NodeList attrs = childs.item(j).getChildNodes();
						for (int l = 0; l < attrs.getLength(); l++) {
							if ("server-id".equals(attrs.item(l).getNodeName())) {
								info.setId(Integer.parseInt(attrs.item(l)
										.getTextContent()));
							} else if ("server-ip".equals(attrs.item(l)
									.getNodeName())) {
								info.setIp(attrs.item(l).getTextContent());
							} else if ("server-port".equals(attrs.item(l)
									.getNodeName())) {
								info.setPort(Integer.parseInt(attrs.item(l)
										.getTextContent()));
							}
						}
						config.setWorldServer(info);
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
