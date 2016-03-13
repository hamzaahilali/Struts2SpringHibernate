package com.web.prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Constant {
	public static List<String> colors = Arrays.asList("Blue", "Black", "Gold", "Gray,", "Green", "Pink", "Red",
			"White");
	public static List<String> operatingSystems = Arrays.asList("Android 4.0", "Android 4.0.4", "Android 4.4", "IOS7",
			"IOS8", "IOS9");

	public static List<String> screenTypes = Arrays.asList("AMOLED", "LCD", "LED", "IPS", "TFT");
	public static List<Boolean> yesOrNo = Arrays.asList(true, false);

	public static List<String> getColors() {
		return colors;
	}

	public static List<String> getOperatingSystems() {
		return operatingSystems;
	}

	public static void setOperatingSystems(List<String> operatingSystems) {
		Constant.operatingSystems = operatingSystems;
	}

	public static void setColors(List<String> colors) {
		Constant.colors = colors;
	}

	public static List<String> getScreenTypes() {
		return screenTypes;
	}

	public static void setScreenTypes(List<String> screenTypes) {
		Constant.screenTypes = screenTypes;
	}

	public static List<Boolean> getYesOrNo() {
		return yesOrNo;
	}

	public static void setYesOrNo(List<Boolean> yesOrNo) {
		Constant.yesOrNo = yesOrNo;
	}

}
