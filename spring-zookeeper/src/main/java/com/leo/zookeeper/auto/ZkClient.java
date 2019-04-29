package com.leo.zookeeper.auto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZkClient {
	private int sessionTimeout = 2000;
	private String connectString = "node01:2181,node02:2181,node03:2181";
	private ZooKeeper zkClient = null;
	private String parentNode = "/servers";

	// 1 创建客户端
	public void getConnect() throws IOException {
		zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			public void process(WatchedEvent event) {
				System.out.println(event.getType() + "--" + event.getPath());

				try {
					// 保证循环执行
					getServers();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 2 监听节点变化
	public void getServers() throws IOException, KeeperException, InterruptedException {
		List<String> children = zkClient.getChildren(parentNode, true);
		List<String> servers = new ArrayList<String>();
		for (String child : children) {
			byte[] data = zkClient.getData(parentNode + "/" + child, false, null);
			servers.add(new String(data));
		}
		System.out.println(servers);
	}

	// 3 具体业务
	public void business() throws IOException, KeeperException, InterruptedException {

		System.out.println("ss 来送客");
		Thread.sleep(Long.MAX_VALUE);
	}

	public static void main(String[] args) throws Exception {
		ZkClient server = new ZkClient();
		server.getConnect();
		server.getServers();
		server.business();
	}
}
