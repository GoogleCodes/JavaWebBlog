package codeing.bean;

import java.util.*;

/**
 * 
 * 
 * Bank
 * 创建人:菜鸟
 * 时间：2018年1月13日-下午9:27:03 
 * @version 1.0.0
 *
 */
public class Bank {
	/**
	 * 主键
	 */
	private int id;
	
	/**
	 * 年龄
	 */
	private String age;
	
	/**
	 * 工作类型
	 */
	private String job;
	
	/**
	 * 婚否
	 */
	private String marital;
	
	/**
	 * 教育程度
	 */
	private String education;
	
	/**
	 * 是否有信用卡
	 */
	private String defaults;
	
	/**
	 * 房贷
	 */
	private String housing;
	
	/**
	 * 贷款
	 */
	private String loan;
	
	/**
	 * 联系途径
	 */
	private String contact;
	
	/**
	 * 月份
	 */
	private Date month;
	
	/**
	 * 星期几
	 */
	private String day_of_week;
	
	/**
	 * 持续时间
	 */
	private String duration;
	
	/**
	 * 本次活动联系的次数
	 */
	private Integer campaign;
	
	/**
	 * 与上一次联系的时间间隔
	 */
	private double pdays;
	
	/**
	 * 之前与客户联系的次数
	 */
	private double previous;
	
	/**
	 * 之前市场活动的结果
	 */
	private String poutcome;
	
	/**
	 * 就业变化速率
	 */
	private double emp_var_rate;
	
	/**
	 * 消费者物价指数
	 */
	private double cons_price_idx;
	
	/**
	 * 消费者信心指数
	 */
	private double cons_conf_idx;
	
	/**
	 * 欧元存款利率
	 */
	private double euribor3m;
	
	/**
	 * 职工人数
	 */
	private double nr_employed;
	
	/**
	 * 是否有定期存款
	 */
	private Integer deposit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDefaults() {
		return defaults;
	}

	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}

	public String getHousing() {
		return housing;
	}

	public void setHousing(String housing) {
		this.housing = housing;
	}

	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public String getDay_of_week() {
		return day_of_week;
	}

	public void setDay_of_week(String day_of_week) {
		this.day_of_week = day_of_week;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getCampaign() {
		return campaign;
	}

	public void setCampaign(Integer campaign) {
		this.campaign = campaign;
	}

	public double getPdays() {
		return pdays;
	}

	public void setPdays(double pdays) {
		this.pdays = pdays;
	}

	public double getPrevious() {
		return previous;
	}

	public void setPrevious(double previous) {
		this.previous = previous;
	}

	public String getPoutcome() {
		return poutcome;
	}

	public void setPoutcome(String poutcome) {
		this.poutcome = poutcome;
	}

	public double getEmp_var_rate() {
		return emp_var_rate;
	}

	public void setEmp_var_rate(double emp_var_rate) {
		this.emp_var_rate = emp_var_rate;
	}

	public double getCons_price_idx() {
		return cons_price_idx;
	}

	public void setCons_price_idx(double cons_price_idx) {
		this.cons_price_idx = cons_price_idx;
	}

	public double getCons_conf_idx() {
		return cons_conf_idx;
	}

	public void setCons_conf_idx(double cons_conf_idx) {
		this.cons_conf_idx = cons_conf_idx;
	}

	public double getEuribor3m() {
		return euribor3m;
	}

	public void setEuribor3m(double euribor3m) {
		this.euribor3m = euribor3m;
	}

	public double getNr_employed() {
		return nr_employed;
	}

	public void setNr_employed(double nr_employed) {
		this.nr_employed = nr_employed;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	
}
