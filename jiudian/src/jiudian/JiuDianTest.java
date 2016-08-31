package jiudian;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;


/**
 * 
 * @author 张泽军
 *
 */
public class JiuDianTest {
	@Test
	public void JDTest() throws Exception{
		JiuDian rj =  new JiuDian(3,  110,80, 90, 80, "如家");
		JiuDian qt  =  new JiuDian(4, 160,110, 60, 50, "七天");
		JiuDian ht  =  new JiuDian(5, 220,100, 150, 40, "汉庭");
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入你是否是会员：（是/否）");
		String hy = scanner.next();
		System.out.print("请输入你的起始入住日期：");
		String kdate = scanner.next();
		System.out.print("请输入你的结束入住日期：");
		String jdate = scanner.next();
		
		//判断时间
		Map<String,Integer> map = this.getWeekNum(kdate, jdate);
		Integer weekend = map.get("weekend");
		Integer mon = map.get("mon");
		rj.setZmoney(this.jisuan(rj, weekend, mon, hy));
		qt.setZmoney(this.jisuan(qt, weekend, mon, hy));
		ht.setZmoney(this.jisuan(ht, weekend, mon, hy));
		//判断酒店的比较
		JiuDian[] jds={rj,qt,ht};
		System.out.println(this.bj(jds).getName());
	}
	//酒店比较
	public JiuDian bj(JiuDian[] jds){
		JiuDian dian = new JiuDian();
		for (int i = 0; i < jds.length-1; i++) {
			for (int j =i+1; j < jds.length; j++) {
				if(jds[i].getZmoney()>jds[i+1].getZmoney()){
					dian=jds[i];
					jds[i] = jds[i+1];
					jds[i+1] = dian;
				}
			}
		}
		for (int i = 0; i < jds.length-1; i++) {
			if(jds[i].getZmoney()==jds[i+1].getZmoney()){
				dian = jds[i].getXing()>jds[i+1].getXing()?jds[i]:jds[i+1];
			}
		}
		return dian;
	}
	
	//计算各酒店价格
	public float jisuan(JiuDian jd,int k,int j,String hy){
		float money=0;
		if(hy.equals("是")){
			money+=jd.getHprice()*k+jd.getZhprice()*j;
		}else{
			money+=jd.getPrice()*k+jd.getPrice1()*j;
		}
		return money;
	}
	//获取周一到周五有多少天，周末有多少天
	public Map<String,Integer> getWeekNum(String bTime,String endTime) throws Exception{
		SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd" );
		Date Date = format.parse(bTime);
		Date EDate = format.parse(endTime);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		DaytoWeek dw  = new DaytoWeek();
		c1.setTime(Date);
		c2.setTime(EDate);
		int weekend=0;
		int mon=0;
		while(c1.compareTo(c2)<=0){
			if(dw.dayForWeek(c1)==6||dw.dayForWeek(c1)==7){
				weekend++;
			}else{
				mon++;
			}
			c1.add(Calendar.DAY_OF_MONTH, 1);
		}
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("weekend", weekend);
		map.put("mon", mon);
		return map;
	}
}
