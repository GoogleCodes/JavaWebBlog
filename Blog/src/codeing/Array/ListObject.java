package codeing.Array;

import java.util.List;

import codeing.Util.AbstractJsonObject;

/**
 * 
 * 
 * ListObject
 * 创建人:菜鸟
 * 时间：2017年10月31日-下午8:52:16 
 * @version 1.0.0
 *
 */
public class ListObject extends AbstractJsonObject {
	
    private List<?> items;
  
    public List<?> getItems() {
        return items;
    }
  
    public void setItems(List<?> items) {
        this.items = items;
    }
}
