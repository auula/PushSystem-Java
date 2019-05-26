package com.vo;

import java.util.ArrayList;
import java.util.List;

public class Pull {

	private List<String> filterList = new ArrayList<String>();
	private List<String> current = new ArrayList<String>();
	





	 // 私有构造
    private Pull() {}

    private static Pull Pull = new Pull();

    // 静态工厂方法
    public static Pull getInstance() {
        return Pull;
    }

	public List<String> getFilterList() {
		return filterList;
	}

	public void setFilterList(List<String> filterList) {
		this.filterList = filterList;
	}

	public List<String> getCurrent() {
		return current;
	}

	public void setCurrent(List<String> current) {
		this.current = current;
	}

	
	
	public boolean isNewMessage() {
		//System.out.println("0============"+current.size());
		if (this.current.size() > 0) {
			//System.out.println("1============"+current.size());
			return true;
		}
		//System.out.println("2============"+current.size());
		return false;
	}


	public synchronized void setFList(String value) {
		this.filterList.add(value);
	}
	public boolean Contain(String ssession) {
		Boolean flog = false;
		for (int i = 0; i < filterList.size(); i++) { // 通过循环输出列表中的内容
			if (filterList.contains(ssession)) {
				flog = true;
			}
		}
		return flog;
	}
}
