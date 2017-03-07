import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TrialCode1 {

	public static void main(String[] args) {

		System.out.println("### TrialCode1 ###");

		// 変換対象
		String dateStr1 = "4231223";
		Date date1 = convGGyymmddToyyyymmdd(dateStr1);

		String dateStr2 = "3201208";
		Date date2 = convGGyymmddToyyyymmdd(dateStr2);

//		System.out.println("target date : "+dateStr1);
//
//		// 元号変換
//		int gengo = Integer.parseInt(dateStr1.substring(0, 1));
//		String gengoStr = "";
//		if ( gengo == 1 ){
//			gengoStr = "M";
//		} else if ( gengo == 2 ) {
//			gengoStr = "T";
//		} else if ( gengo == 3 ) {
//			gengoStr = "S";
//		} else if ( gengo == 4 ) {
//			gengoStr = "H";
//		} else {
//			// error!
//		}
//		System.out.println("gengoStr : "+gengoStr);
//
//		String yearStr = gengoStr + dateStr1.substring(1,7);
//		System.out.println("yearStr : "+yearStr);
//
//		SimpleDateFormat sdfWaR= new SimpleDateFormat("GGyymmdd", new Locale("ja","JP","JP"));
//		SimpleDateFormat sdfENG= new SimpleDateFormat("yyyymmdd", Locale.ENGLISH);
//		try {
//			Date date=sdfWaR.parse(yearStr);
//			System.out.println("date : "+sdfENG.format(date));
//
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
	}


	// 和暦（元号は数字）→和暦（元号は記号）→西暦への変換関数
	// gyymmdd --> GGyymmdd --> yyyymmdd
	public static Date convGGyymmddToyyyymmdd(String targetStr) {

		// DEBUG
		//System.out.println("targetStr : "+targetStr);

		// 元号変換
		int gengo = Integer.parseInt(targetStr.substring(0, 1));
		String gengoStr = "";
		if ( gengo == 1 ){
			gengoStr = "M";
		} else if ( gengo == 2 ) {
			gengoStr = "T";
		} else if ( gengo == 3 ) {
			gengoStr = "S";
		} else if ( gengo == 4 ) {
			gengoStr = "H";
		} else {
			// error!
		}
		// DEBUG
		//System.out.println("gengoStr : "+gengoStr);

		String targetStr2 = gengoStr + targetStr.substring(1,7);

		// DEBUG
		//System.out.println("targetStr2 : "+targetStr2);

		SimpleDateFormat sdfWaR= new SimpleDateFormat("GGyymmdd", new Locale("ja","JP","JP"));
		SimpleDateFormat sdfENG= new SimpleDateFormat("yyyymmdd", Locale.ENGLISH);
		Date date = null;
		try {
			date=sdfWaR.parse(targetStr2);

			// DEBUG
			//System.out.println("date : "+sdfENG.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
