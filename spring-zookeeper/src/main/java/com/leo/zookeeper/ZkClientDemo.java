package com.leo.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

public class ZkClientDemo {

	private int sessionTimeout = 2000;
	private String connectString = "node01:2181,node02:2181,node03:2181";
	private ZooKeeper zkClient;

	// 1 创建客户端
	// @Test
	@Before
	@SuppressWarnings("unused")
	public void initZk() throws IOException {
		zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			public void process(WatchedEvent event) {
				System.out.println(event.getType() + "--" + event.getPath());
				try {
					
					Stat exists = zkClient.exists("/leo", true);
					List<String> children = zkClient.getChildren("/", false);
				} catch (KeeperException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	// 2 创建子节点
	@Test
	public void createNode() throws IOException, KeeperException, InterruptedException {
		// 参数1：创建的路径；参数2：创建节点存储的数据；参数3：创建节点后节点具有权限；参数4：节点类型
		String create = zkClient.create("/leo", "ss.avi".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(create);
	}

	// 3 获取节点下的子节点数
	@Test
	public void getChild() throws IOException, KeeperException, InterruptedException {
		List<String> children = zkClient.getChildren("/", false);
		for (String child : children) {
			System.out.println(child);
		}
		Thread.sleep(Long.MAX_VALUE);
	}

	// 4 判断某一节点时候存在
	@Test
	public void chechExists() throws IOException, KeeperException, InterruptedException {
		Stat exists = zkClient.exists("/leo", true);
		System.out.println(exists == null ? "not exists" : "exists");
		Thread.sleep(Long.MAX_VALUE);
	}
}
