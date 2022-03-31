package cn.java666.sztcommon.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpUtil;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author Geek
 * @date 2020-04-13 19:11:04
 *
 * 由于在前期保存数据时，我没有采用合适的格式分隔，
 * 导致后来 ETL 非常繁琐，此处建议使用最接近原始数据的格式保存，
 * 原始数据：  参考 .file/.api/page1x100.json
 *
 * 因为 spark 可以直接处理多行 json 文本，
 * 所以这里的 jsons 默认每行存一个完整 json 对象文本。我已经踩过坑了
 */
public class SZTData {
//	public static void main(String[] args){
	String SAVE_PATH = "F:\\zkd\\CODE\\zgz\\SZT-bigdata\\.file\\zfr_file\\";

//	String URL = "https://opendata.sz.gov.cn/api/29200_00403601/1/service.xhtml?page=";
//	String FILE_NAME = "szt-data-page.jsons";
//// totalDataLen = 1337000;

//	享单车企业每日订单表
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_00403627
//// totalDataLen = ??;
//	String URL = "https://opendata.sz.gov.cn/api/29200_00403627/1/service.xhtml?page=";
//	String FILE_NAME = "shared_bike_orders.jsons";


//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_00403589
//  街道实时数据
////// totalDataLen = 5546000
//	String URL = "http://opendata.sz.gov.cn/api/29200_00403589/1/service.xhtml?page=";
//	String FILE_NAME = "street_readtime.jsons";

//  https://opendata.sz.gov.cn/data/api/toApiDetails/29200_00403587
//	街道属性数据
////// totalDataLen =74
//	String URL = "http://opendata.sz.gov.cn/api/29200_00403587/1/service.xhtml?page=";
//	String FILE_NAME = "street_property.jsons";



//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01100977
//	招聘岗位信息
////// totalDataLen = 4923;
//	String URL = "http://opendata.sz.gov.cn/api/559353124/1/service.xhtml?page=";
//	String FILE_NAME = "job_info.jsons";


//	食品许可证
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01303137
//	//// totalDataLen = 692801;
//	String URL = "https://opendata.sz.gov.cn/api/264673094/1/service.xhtml?page=";
//	String FILE_NAME = "food_business_certificate.jsons";

//	食品生产企业
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01303562
//	//// totalDataLen = 164116;
//	String URL = "http://opendata.sz.gov.cn/api/29200_01303562/1/service.xhtml?page=";
//	String FILE_NAME = "food_production_enterprise.jsons";


//	一手商品房成交信息（按日统计）
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01903510
//	//// totalDataLen = 55984;
//	String URL = "https://opendata.sz.gov.cn/api/29200_01903510/1/service.xhtml?page=";
//	String FILE_NAME = "firsthand_commercial_housing_transactions.jsons";


//	一手商品房按面积统计成交信息（按日统计）
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01903511
//	//// totalDataLen = 27074;
//	String URL = "https://opendata.sz.gov.cn/api/29200_01903511/1/service.xhtml?page=";
//	String FILE_NAME = "firsthand_commercial_housing_transactions_area.jsons";


//	二手房成交信息（按日统计）
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01903513
//	//// totalDataLen = 18859;
//	String URL = "https://opendata.sz.gov.cn/api/29200_01903513/1/service.xhtml?page=";
//	String FILE_NAME = "second_commercial_housing_transactions.jsons";



//	深圳市住宅小区二手住房成交参考价格表
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01903516
//	//// totalDataLen = 7190;
//	String URL = "https://opendata.sz.gov.cn/api/29200_01903516/1/service.xhtml?page=";
//	String FILE_NAME = "second_housing_ref_price.jsons";


//	二手房源信息
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01903509
//	//// totalDataLen = 72302;
//	String URL = "http://opendata.sz.gov.cn/api/29200_01903509/1/service.xhtml?page=";
//	String FILE_NAME = "second_housing_source.jsons";


//	电梯、大型游乐设备特种设备信息
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01303133
//	//// totalDataLen = 72302;
//	String URL = "https://opendata.sz.gov.cn/api/2011822768/1/service.xhtml?page=";
//	String FILE_NAME = "special_equipment.jsons";


//	星级酒店基本信息数据
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01600254
//// totalDataLen = 155;
//	String URL = "http://opendata.sz.gov.cn/api/1452539482/1/service.xhtml?page=";
//	String FILE_NAME = "starred_hotel.jsons";

//	宾馆旅店
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_00200868
//	//// totalDataLen = 269;
//	String URL = "https://opendata.sz.gov.cn/api/1860171636/1/service.xhtml?page=";
//	String FILE_NAME = "hotel_info.jsons";

//	药店统计表
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_04203563
//	//// totalDataLen = 1543341;
//	String URL = "http://opendata.sz.gov.cn/api/29200_04203563/1/service.xhtml?page=";
//	String FILE_NAME = "drugstore_info.jsons";

//	个体户监管区域
//	https://opendata.sz.gov.cn/data/dataSet/toDataDetails/29200_01303577
//	//// totalDataLen = 1514594;
//	String URL = "http://opendata.sz.gov.cn/api/29200_01303577/1/service.xhtml?page=";
//	String FILE_NAME = "individual_household_info.jsons";

//	市政公共厕所信息
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_00100929
//	//// totalDataLen = 32227;
//	String URL = "http://opendata.sz.gov.cn/api/1560172272/1/service.xhtml?page=";
//	String FILE_NAME = "public_lavatory_info.jsons";

//	公共场所卫生许可
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01500200
//	//// totalDataLen = 30446;
//	String URL = "http://opendata.sz.gov.cn/api/1853507078/1/service.xhtml?page=";
//	String FILE_NAME = "public_health_info.jsons";


//	网络文化经营单位
//	https://opendata.sz.gov.cn/data/api/toApiDetails/29200_01603264
//	//// totalDataLen = 24688;
	String URL = "http://opendata.sz.gov.cn/api/1209602151/1/service.xhtml?page=";
	String FILE_NAME = "internet_culture_enterprise_info.jsons";


	String SAVE_ABSOLUTE_PATH = SAVE_PATH + FILE_NAME;
	
	//TODO appKey 自己申请 https://opendata.sz.gov.cn/data/api/toApiDetails/29200_00403601
	String appKey = "badb5cc62e9a47a99d612e3c2cfb4d72";


//	String lastData = "";
	/** 这个过程可能花费一个通宵，如果中断，查看已保存数据最后一条的 page，然后调整 i 的起始值继续抓取
	 * 使用 test 可以保存每次运行的历史日志
	 */
	@Test
	public void saveData() {

		// exist to delete
		if(FileUtil.exist(SAVE_ABSOLUTE_PATH)) {
//			FileUtil.del(SAVE_ABSOLUTE_PATH);
			throw new IllegalArgumentException();
		}

		int startIndex = 1;
		int readedLine = 0;
		int i = startIndex;
		int totalLen = Integer.MAX_VALUE;
		String lastStr = "";
		ProgressBar progressBar = new ProgressBar(0);
		while (true){

			String s = "";
			try {
//				int maxTry = 3;
//				while (maxTry == 0) {
//					s = HttpUtil.get(URL + i + "&rows=1000&appKey=" + appKey);
//					if (!s.contains("\"data\":[]"))
//						break;
//					maxTry--;
//				}
				s = HttpUtil.get(URL + i + "&rows=1000&appKey=" + appKey);
			}

			catch (HttpException e) { //超时异常
				System.out.println("触发异常 : "+e);
			}
			// 一定要加换行符，否则以后处理起来会是灾难。
			// 一定要加换行符，否则以后处理起来会是灾难。
			// 一定要加换行符，否则以后处理起来会是灾难。
			if(s.contains("未经许可的证书，请先订阅接口")){ //
				System.out.println(s);
				throw new IllegalArgumentException();
			}
			if (i == startIndex) {
				JSONObject jsonObject = JSON.parseObject(s);
				totalLen = (Integer)jsonObject.get("total");
				lastStr = s;
			}
			else {
				JSONObject jsonObject = JSON.parseObject(lastStr);
				JSONArray data = (JSONArray) jsonObject.get("data");


				// 判断是否为最后一条
//				if (readedLine + data.size() < totalLen) {
				if(!s.contains("\"data\":[]")){
					data.remove(data.size() - 1);
					jsonObject.put("data", data);
				}

				String s1 = jsonObject.toString();
				if (totalLen <= readedLine && data.size() == 0) {
					System.out.println("\r\n" + i + "," + readedLine + "/" + totalLen);
					break;
				}
				FileUtil.appendUtf8String(s1 + "\n", SAVE_ABSOLUTE_PATH);
				readedLine += data.size();
//			System.out.println(i);
//				if(totalLen > readedLine)
//					progressBar.printProgress(readedLine/totalLen);
//				else
				progressBar.printProgress((readedLine * 100)/totalLen);
				lastStr = s;
			}
			i++;

		}
		
		int size = FileUtil.readUtf8Lines(SAVE_ABSOLUTE_PATH).size();

		System.out.println(" 数据保存完成,行数:" + size);
		System.out.println(FILE_NAME);
		// 如果中途断了，需要自己实现数据完整性检查
//		if (size == 1337) {
//			System.out.println(" 数据完全保存！！！ ");
//		}
	}
}
