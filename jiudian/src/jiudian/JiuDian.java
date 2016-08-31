package jiudian;
/**
 * 
 * @author 张泽军
 *
 */
public class JiuDian {
	private Integer xing;
	
	private float price;
	
	private float hprice;
	
	private float price1;
	
	private float zhprice;
	
	private String name;
	
	private float zmoney;
	

	public float getZmoney() {
		return zmoney;
	}

	public void setZmoney(float zmoney) {
		this.zmoney = zmoney;
	}

	public Integer getXing() {
		return xing;
	}

	public void setXing(Integer xing) {
		this.xing = xing;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getHprice() {
		return hprice;
	}

	public void setHprice(float hprice) {
		this.hprice = hprice;
	}

	public float getPrice1() {
		return price1;
	}

	public void setPrice1(float price1) {
		this.price1 = price1;
	}

	public float getZhprice() {
		return zhprice;
	}

	public void setZhprice(float zhprice) {
		this.zhprice = zhprice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JiuDian(Integer xing, float price, float hprice, float price1, float zhprice, String name) {
		super();
		this.xing = xing;
		this.price = price;
		this.hprice = hprice;
		this.price1 = price1;
		this.zhprice = zhprice;
		this.name = name;
	}

	public JiuDian() {
		super();
	}
	
}
