package sqlGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/3/6 下午5:48
 * @description
 */
public class BatchInsertGenerator {

	/**
	 * 仅限于txt文件
	 * index标识CPI/CPA/SCORE
	 */
	static String[] buildCpiBatchInsert() throws Exception {

		StringBuilder cpiSB = new StringBuilder();
		StringBuilder scoreSB = new StringBuilder();
		cpiSB.append("insert into af_cpi_channel_offer ( id,  gmt_create,  gmt_modified,  channel,  country,  " +
				"unit_price,  gmt_effective,  status,  platform,  currency) values ");
		String cpiValue = "(%d,now(),now(),\'%s\',\'%s\',%d,now(),\'ACTIVE\',\'%s\',\'%s\')";
		scoreSB.append("insert into af_app_quality_score_channel_setting ( id,  gmt_create,  gmt_modified, " +
				" channel,  country,  platform,  quality_score,  gmt_effective,  status) values ");
		String scoreValue = "(%d,now(),now(),\'%s\',\'%s\',\'%s\',%d,now(),\'ACTIVE\')";
		File file = new File("/Users/yangmin/Documents/Java/personal/UsefulTools/src/main/java/sqlGenerator/data.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		int count = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if (count != 0) {
				cpiSB.append(",");
				scoreSB.append(",");
			}
			String[] strs = line.split("\\t", -1);
			String country = strs[0].toUpperCase();
			String pid = strs[1];
			String price = strs[2];
			long priceLong = (long) (Double.parseDouble(price) * 100);
			String score = strs[3];
			long scoreLong = Long.parseLong(score);
			String appendCpiStrIOS = String.format(cpiValue, count, pid, country, priceLong, "IOS", "USD") + ",";
			String appendCpiStrANDROID = String.format(cpiValue, count + 1, pid, country, priceLong, "ANDROID", "USD");
			cpiSB.append(appendCpiStrIOS).append(appendCpiStrANDROID);
			String appendScoreStrIOS = String.format(scoreValue, count, pid, country, "IOS", scoreLong) + ",";
			String appendScoreStrANDROID = String.format(scoreValue, count + 1, pid, country, "ANDROID", scoreLong);
			scoreSB.append(appendScoreStrIOS).append(appendScoreStrANDROID);
			count += 2;
		}
		String[] strs = new String[2];
		strs[0] = cpiSB.toString();
		strs[1] = scoreSB.toString();

		return strs;
	}

	static String buildCpaBatchInsert() throws Exception {

		StringBuilder cpaSB = new StringBuilder();
		cpaSB.append("insert into af_cpi_offer ( id,  gmt_create,  gmt_modified, country,  " +
				"unit_price,  gmt_effective,  platform,  status,currency) values ");
		String cpaValue = "(%d,now(),now(),\'%s\',%d,now(),\'%s\',\'ACTIVE\',\'USD\')";
		File file = new File("/Users/yangmin/Documents/Java/personal/UsefulTools/src/main/java/sqlGenerator/cpidata.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		int count = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if (count != 0) {
				cpaSB.append(",");
			}
			String[] strs = line.split("\\t", -1);
			String country = strs[0].toUpperCase();
			String price = strs[1];
			long priceLong = (long) (Double.parseDouble(price) * 100);
			String appendCpaStrIOS = String.format(cpaValue, count, country,priceLong, "IOS") + ",";
			String appendCpaStrANDROID = String.format(cpaValue, count+1, country,priceLong, "ANDROID");
			cpaSB.append(appendCpaStrIOS).append(appendCpaStrANDROID);
			count += 2;
		}


		return cpaSB.toString();
	}

	static String buildCpiScoreBatchInsert() throws Exception {

		StringBuilder cpaSB = new StringBuilder();
		cpaSB.append("insert into af_app_quality_score_setting ( id,  gmt_create,  gmt_modified, country,  " +
				"quality_score,  gmt_effective,  platform,  status) values ");
		String cpaValue = "(%d,now(),now(),\'%s\',%d,now(),\'%s\',\'ACTIVE\')";
		File file = new File("/Users/yangmin/Documents/Java/personal/UsefulTools/src/main/java/sqlGenerator/score.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		int count = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if (count != 0) {
				cpaSB.append(",");
			}
			String[] strs = line.split("\\t", -1);
			String country = strs[0].toUpperCase();
			String score = strs[1];
			long scoreLong = Long.parseLong(score);
			String appendCpaStrIOS = String.format(cpaValue, count, country,scoreLong, "IOS") + ",";
			String appendCpaStrANDROID = String.format(cpaValue, count+1, country,scoreLong, "ANDROID");
			cpaSB.append(appendCpaStrIOS).append(appendCpaStrANDROID);
			count += 2;
		}


		return cpaSB.toString();
	}


	static String buildOdpsBatchInsert() throws Exception {

		StringBuilder odpsSB = new StringBuilder();
		odpsSB.append("insert into table s_ae_seo_category_search_seed  values ");
		String cpaValue = "(\'%s\')";
		File file = new File("/Users/yangmin/Documents/Java/personal/UsefulTools/src/main/java/sqlGenerator/1.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		int count = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if (count != 0) {
				odpsSB.append(",");
			}
			String txt = String.format(cpaValue, line.trim());
			odpsSB.append(txt);
			count += 1;
		}


		return odpsSB.toString();
	}
	public static void main(String[] args) throws Exception {
//		String[] strs = buildCpiBatchInsert();
//		System.out.println(strs[0]);
//		System.out.println(strs[1]);
		String str=buildOdpsBatchInsert();
		System.out.println(str);

	}
}
