package com.web.factory;

import java.util.Collection;

import com.web.model.Accessory;
import com.web.model.Camera;
import com.web.model.Mobile;
import com.web.model.MobileCase;
import com.web.model.PowerBank;
import com.web.model.Screen;

public class MobileFacetory {
	public Mobile getModelMobile(String str) {
		if (str.isEmpty()) {
			return null;
		}
		if (str.equalsIgnoreCase("Phone 1")) {
			Screen screen = new Screen("IPS", 4.7);
			Camera camera = new Camera(1.2, 5);
			Mobile phone1 = new Mobile("IOS9", 2, 128, screen, camera, false, "Mobile");
			phone1.setColor("White");
			phone1.setName("Phone 1");
			phone1.setPic("Phone1");
			phone1.setPrice(150);
			return phone1;
		}
		if (str.equalsIgnoreCase("Phone 2")) {
			Screen screen = new Screen("Amoled", 5);
			Camera camera = new Camera(3, 5);
			Mobile phone2 = new Mobile("Android 5.0", 2, 64, screen, camera, false, "Mobile");
			phone2.setColor("Black");
			phone2.setName("Phone 2");
			phone2.setPic("Phone2");
			phone2.setPrice(250);
			return phone2;
		}
		if (str.equalsIgnoreCase("Phone 3")) {
			Screen screen = new Screen("Amoled", 5);
			Camera camera = new Camera(1, 3);
			Mobile phone3 = new Mobile("Window Phone 7", 1, 16, screen, camera, true, "Mobile");
			phone3.setColor("Blue");
			phone3.setName("Phone 3");
			phone3.setPic("Phone3");
			phone3.setPrice(199);
			return phone3;
		}
		if (str.equalsIgnoreCase("Phone 4")) {
			Screen screen = new Screen("LCD", 4);
			Camera camera = new Camera(1, 2);
			Mobile phone4 = new Mobile("IOS8", 1, 32, screen, camera, true, "Mobile");
			phone4.setColor("Black");
			phone4.setName("Phone 4");
			phone4.setPic("Phone4");
			phone4.setPrice(250);
			return phone4;
		}
		if (str.equalsIgnoreCase("Phone 5")) {
			Screen screen = new Screen("IPS", 4.2);
			Camera camera = new Camera(1, 8);
			Mobile phone5 = new Mobile("Android 4.4", 1, 16, screen, camera, true, "Mobile");
			phone5.setColor("Black");
			phone5.setName("Phone 5");
			phone5.setPic("Phone5");
			phone5.setPrice(99);
			return phone5;
		}
		if (str.equalsIgnoreCase("Phone 6")) {
			Screen screen = new Screen("TFT", 4.2);
			Camera camera = new Camera(1, 2);
			Mobile phone6 = new Mobile("Android 4.0", 1, 16, screen, camera, true, "Mobile");
			phone6.setColor("Green");
			phone6.setName("Phone 6");
			phone6.setPic("Phone6");
			phone6.setPrice(250);
			return phone6;
		}
		return null;
	}

	public MobileCase getMobileCase(String str) {
		if (str.isEmpty()) {
			return null;
		}
		if (str.equalsIgnoreCase("Mobile Case 1")) {
			MobileCase mobileCase = new MobileCase("Mobile Case 1", 3, "White", "MobileCase1", "Plastic Case",
					"MobileCase");
			return mobileCase;
		}
		if (str.equalsIgnoreCase("Mobile Case 2")) {
			MobileCase mobileCase = new MobileCase("Mobile Case 2", 5, "Black", "MobileCase2", "Protect your Phone 24h",
					"MobileCase");
			return mobileCase;
		}
		if (str.equalsIgnoreCase("Mobile Case 3")) {
			MobileCase mobileCase = new MobileCase("Mobile Case 3", 2, "Red", "MobileCase3", "Attractive case",
					"MobileCase");
			return mobileCase;
		}
		if (str.equalsIgnoreCase("Mobile Case 4")) {
			MobileCase mobileCase = new MobileCase("Mobile Case 4", 8, "Green", "MobileCase4", "Luxury case",
					"MobileCase");
			return mobileCase;
		}
		if (str.equalsIgnoreCase("Mobile Case 5")) {
			MobileCase mobileCase = new MobileCase("Mobile Case 5", 1, "Green", "MobileCase5", "Reasonable case",
					"MobileCase");
			return mobileCase;
		}

		if (str.equalsIgnoreCase("Mobile Case 6")) {
			MobileCase mobileCase = new MobileCase("Mobile Case 6", 2, "Pink", "MobileCase6", "Girl's case",
					"MobileCase");
			return mobileCase;
		}
		return null;
	}

	public PowerBank getPoweBank(String str) {
		if (str.isEmpty()) {
			return null;
		}
		if (str.equalsIgnoreCase("Power Bank 1")) {
			PowerBank powerBank = new PowerBank("Power Bank 1", 10, "White", "PowerBank1", "", 6600, "PowerBank");
			return powerBank;
		}
		if (str.equalsIgnoreCase("Power Bank 2")) {
			PowerBank powerBank = new PowerBank("Power Bank 2", 12, "White", "PowerBank2", "", 5000, "PowerBank");
			return powerBank;
		}
		if (str.equalsIgnoreCase("Power Bank 3")) {
			PowerBank powerBank = new PowerBank("Power Bank 3", 15, "White", "PowerBank3", "", 10000, "PowerBank");
			return powerBank;
		}
		if (str.equalsIgnoreCase("Power Bank 4")) {
			PowerBank powerBank = new PowerBank("Power Bank 4", 8, "White", "PowerBank4", "", 10000, "PowerBank");
			return powerBank;
		}
		if (str.equalsIgnoreCase("Power Bank 5")) {
			PowerBank powerBank = new PowerBank("Power Bank 5", 26, "White", "PowerBank5", "", 6000, "PowerBank");
			return powerBank;
		}

		if (str.equalsIgnoreCase("Power Bank 6")) {
			PowerBank powerBank = new PowerBank("Power Bank 6", 30, "White", "PowerBank6", "", 8000, "PowerBank");
			return powerBank;
		}
		return null;
	}
}
