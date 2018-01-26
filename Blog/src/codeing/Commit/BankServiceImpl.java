package codeing.Commit;

import java.util.List;

import codeing.DB.BankInformation;
import codeing.Interface.BankInterface;
import codeing.bean.Bank;

/**
 * 
 * 
 * BankServiceImpl
 * 创建人:菜鸟
 * 时间：2018年1月13日-下午10:56:21 
 * @version 1.0.0
 *
 */
public class BankServiceImpl implements BankInterface {
	
	@Override
	public List<Bank> getBankMessage() {
		return BankInformation.getBankMessage();
	}

}
