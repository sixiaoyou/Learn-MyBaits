package com.jike.mybatis.jikebook;
/**
 * 读者表
 * @author wsdhr
 *
 */
public class JiKeReader {
	private Integer readerID;
	private JiKeUser jikeUser;
	private Integer money;
	public Integer getReaderID() {
		return readerID;
	}
	public void setReaderID(Integer readerID) {
		this.readerID = readerID;
	}
	public JiKeUser getJikeUser() {
		return jikeUser;
	}
	public void setJikeUser(JiKeUser jikeUser) {
		this.jikeUser = jikeUser;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
}
