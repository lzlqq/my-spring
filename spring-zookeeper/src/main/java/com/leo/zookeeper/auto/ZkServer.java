package com.leo.zookeeper.auto;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZkServer {

	private int sessionTimeout = 2000;
	private String connectString = "node01:2181,node02:2181,node03:2181";
	private ZooKeeper zkClient = null;
	private String parentNode = "/servers";

	// 1 创建客户端
	public void getConnect() throws IOException {
		zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			public void process(WatchedEvent event) {

			}
		});
	}

	// 2 注册
	public void regist(String hostname) throws IOException, KeeperException, InterruptedException {
		String create = zkClient.create(parentNode + "/server", hostname.getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(hostname + " is online " + create);
	}

	// 3 具体业务
	public void business() throws IOException, KeeperException, InterruptedException {

		System.out.println("ss 来解困");
		Thread.sleep(Long.MAX_VALUE);
	}

	public static void main(String[] args) throws Exception {
		ZkServer server = new ZkServer();
		server.getConnect();
		server.regist(args[0]);
		server.business();
	}
}
