package damiancyk.decorator.utils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

public class Decorator {

	public static String COLLECTION_NAME = "results";

	public static String getJson(List<?> rows, Class<?> decoratorClass) {
		HashMap<String, Object> map = getMap(rows, decoratorClass);

		return toJson(map);
	}

	public static String getJsonWithParams(List<?> rows,
			Class<?> decoratorClass, DecoratorParams params) {
		setParams(params);

		String json = null;
		if (COLLECTION_NAME == null) {
			json = getJsonOnlyData(rows, decoratorClass);
		} else {
			json = getJson(rows, decoratorClass);
		}

		return json;
	}

	private static void setParams(DecoratorParams params) {
		if (params != null) {
			COLLECTION_NAME = params.getCollectionName();
		}
	}

	public static String getJsonOnlyData(List<?> rows, Class<?> decoratorClass) {
		ArrayList<Object> resultList = getObjects(rows, decoratorClass);

		return toJson(resultList);
	}

	public static HashMap<String, Object> getMap(List<?> rows,
			Class<?> decoratorClass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Object> resultList = getObjects(rows, decoratorClass);
		map.put(COLLECTION_NAME, resultList);

		return map;
	}

	public static ArrayList<Object> getObjects(List<?> rows,
			Class<?> decoratorClass) {
		ArrayList<Object> resultList = new ArrayList<Object>();

		Object firstRow = rows.get(0);
		Class<? extends Object> rowClass = firstRow.getClass();

		Integer lp = 1;
		for (Object row : rows) {
			try {
				Constructor<?> constructor = decoratorClass
						.getDeclaredConstructor(rowClass);
				DecoratorTable decorator = (DecoratorTable) constructor
						.newInstance(row);
				decorator.setLp("<span class='lp'>" + lp + "</span>");
				String checkbox = (decorator.getCheckbox() != null ? decorator
						.getCheckbox() : "");
				decorator.setCheckbox(checkbox
						+ "<input class='checkbox' type='checkbox'/>");
				resultList.add(decorator);

				lp++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return resultList;
	}

	public static String toJson(Object obj) {
		return new Gson().toJson(obj);
	}

}
