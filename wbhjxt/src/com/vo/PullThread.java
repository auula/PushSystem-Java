package com.vo;

import java.util.List;

public class PullThread extends Thread {

	public  PullThread(List<String> filterList, List<String> current) {
		super();
		this.filterList = filterList;
		this.current = current;
	}

	private List<String> filterList;
	private List<String> current;

	@Override
	public void run() {
		super.run();
		try {
			//设置超时时间
			Thread.sleep(30000);
			this.Close();
			System.out.println("清理成功~");
		} catch (InterruptedException e) {
			//设置超时时间
			this.Close();
			//e.printStackTrace();
		}
	}
	
	// 线程安全的
	public synchronized void Close() {
		for (int i = 0; i < filterList.size(); i++) {
			filterList.remove(i);
		}
		for (int i = 0; i < current.size(); i++) {
			current.remove(i);
		}
	}
}
