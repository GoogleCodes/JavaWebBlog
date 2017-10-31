package codeing.Commit;

import codeing.DB.StudentBusiness;
import codeing.Interface.MyInterface;

import java.util.*;

import codeing.User.*;

/**
 * 
 * 
 * StudentServiceImpl
 * 创建人:菜鸟
 * 时间：2017年10月31日-下午9:05:36 
 * @version 1.0.0
 *
 */
public class StudentServiceImpl implements MyInterface {

	public List<Students> getAllStudents() {
        return StudentBusiness.getAllStudents();
    }
	
}
