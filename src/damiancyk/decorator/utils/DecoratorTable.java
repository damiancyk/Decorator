package damiancyk.decorator.utils;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DecoratorTable {

	private String lp;
	private String checkbox;

	public void data(Object... params) {
		String data = "";
		for (Object param : params) {
			if (param != null) {
				data += param;
			}
		}

		String hiddenData = "<input class='data' type='hidden' " + data + " >";

		setCheckbox(hiddenData);
	}

	public Object addField(String str, Object o) {
		String data = " data-" + str + "='" + o + "'";

		return data;
	}

	public String getLink(String url, String text) {
		if (url == null || text == null) {
			return "";
		}

		String str = "<a class='link' href='" + url + "'>" + text + "</a>";

		return str;
	}

	public String getCurrency(Double val) {
		DecimalFormat formatter = new DecimalFormat();
		formatter.setGroupingSize(3);
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);

		String format = formatter.format(val);

		return format != null ? format : "";
	}

	public String getDate(Date date) {
		if (date == null) {
			return "";
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormatted = sdf.format(date);

		return dateFormatted != null ? dateFormatted : "";
	}

	public String getLp() {
		return lp;
	}

	public void setLp(String lp) {
		this.lp = lp;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

}
