package codeing.DB;

import codeing.Array.ListObject;
import codeing.Util.JackJsonUtils;
import codeing.Util.ResponseUtils;
import codeing.Util.StatusHouse;
import codeing.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * 数据查询
 * 
 * BankInformation
 * 创建人:菜鸟
 * 时间：2018年1月13日-下午9:28:33 
 * @version 1.0.0
 *
 */
public class BankInformation {
	
	/**
	 * PRER
	 */
	private static PreparedStatement PRER = null;
	
	/**
	 * READ
	 */
	private static ResultSet READ = null;
	
	/**
	 * 创建实例
	 */
	private static DBClass db = null;
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getBankMessage
	 * 创建人：xuchengfei 
	 * 时间：2018年1月13日-下午9:31:23 
	 * 手机:1564545646464
	 * @return List<Bank>
	 * @exception 
	 * @since  1.0.0
	 */
	public static List<Bank> getBankMessage() {
		
		db = new DBClass();
		
		List<Bank> list = new ArrayList<Bank>();
		/**
		 * Sql语句
		 */
		String sql = "select " + 
						"id, " +
						"age," +
						"job," +
						"marital," +
						"education," +
						"defaults," +
						"housing," +
						"loan," +
						"contact," +
						"month," +
						"day_of_week," +
						"duration," +
						"campaign," +
						"pdays," +
						"previous," +
						"poutcome," +
						"emp_var_rate," +
						"cons_price_idx," +
						"cons_conf_idx," +
						"euribor3m," +
						"deposit," +
						"nr_employed from bank_data where age < 16 limit 25";
		/**
		 * 创建实例
		 */
		Connection conn = db.getConnection();
		
		try {
			PRER = conn.prepareStatement(sql);
			READ = PRER.executeQuery();
			while (READ.next()) {
				Bank bank = new Bank();
				/**
				 * 主键
				 */
				int id = READ.getInt("id");
				bank.setId(id);
				
				/**
				 * 年龄
				 */
				String age = READ.getString("age");
				bank.setAge(age);
				
				/**
				 * 工作类型
				 */
				String job = READ.getString("job");
				bank.setJob(job);
				
				/**
				 * 婚否
				 */
				String marital = READ.getString("marital");
				bank.setMarital(marital);
				
				/**
				 * 教育程度
				 */
				String education = READ.getString("education");
				bank.setEducation(education);
				
				/**
				 * 是否有信用卡
				 */
				String defaults = READ.getString("defaults");
				bank.setDefaults(defaults);
				
				/**
				 * 房贷
				 */
				String housing = READ.getString("housing");
				bank.setHousing(housing);
				
				/**
				 * 贷款
				 */
				String loan = READ.getString("loan");
				bank.setLoan(loan);
				
				/**
				 * 联系途径
				 */
				String contact = READ.getString("contact");
				bank.setContact(contact);
				
				/**
				 * 月份
				 */
				Date month = READ.getDate("month");
				bank.setMonth(month);
				
				/**
				 * 星期几
				 */
				String day_of_week = READ.getString("day_of_week");
				bank.setDay_of_week(day_of_week);
				
				/**
				 * 持续时间
				 */
				String duration = READ.getString("duration");
				bank.setDuration(duration);
				
				/**
				 * 本次活动联系的次数
				 */
				Integer campaign = READ.getInt("campaign");
				bank.setCampaign(campaign);
				
				/**
				 * 与上一次联系的时间间隔
				 */
				double pdays = READ.getDouble("pdays");
				bank.setPdays(pdays);
				
				/**
				 * 之前与客户联系的次数
				 */
				double previous = READ.getDouble("previous");
				bank.setPrevious(previous);
				
				/**
				 * 之前市场活动的结果
				 */
				String poutcome = READ.getString("poutcome");
				bank.setPoutcome(poutcome);
				
				/**
				 * 就业变化速率
				 */
				double emp_var_rate = READ.getDouble("emp_var_rate");
				bank.setEmp_var_rate(emp_var_rate);
				
				/**
				 * 消费者物价指数
				 */
				double cons_price_idx = READ.getDouble("cons_price_idx");
				bank.setCons_price_idx(cons_price_idx);
				
				/**
				 * 消费者信心指数
				 */
				double cons_conf_idx = READ.getDouble("cons_conf_idx");
				bank.setCons_conf_idx(cons_conf_idx);
				
				/**
				 * 欧元存款利率
				 */
				double euribor3m = READ.getDouble("euribor3m");
				bank.setEuribor3m(euribor3m);
				
				/**
				 * 职工人数
				 */
				double nr_employed = READ.getDouble("nr_employed");
				bank.setNr_employed(nr_employed);
				
				/**
				 * 是否有定期存款
				 */
				Integer deposit = READ.getInt("deposit");
				bank.setDeposit(deposit);
				
				System.out.println(deposit + "--" + nr_employed);
				
				list.add(bank);
			}
			
			READ.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.getConnection();
		}
		return list;
	}

	public static void main(String[] args) {
//		int size = list.size();
//		int i;
//		Bank bank = new Bank();
//		for(i = 0; i < size; i++) {
//			bank.setId(list.get(i).getId());
//			int id = bank.getId();
//			System.out.println(id);
//		}
		List<Bank> list = getBankMessage();
		ListObject listobj = new ListObject();
		listobj.setItems(list);
		listobj.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		String responseText = JackJsonUtils.toJson(listobj);
		System.out.println(responseText);
	}
	
}
