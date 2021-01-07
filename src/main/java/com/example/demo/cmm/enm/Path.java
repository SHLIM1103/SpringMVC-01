package com.example.demo.cmm.enm;

public enum Path {
	DEFAULT_PROFILE;
	
	@Override
	public String toString() {
		String path = "" ;
		switch(this) {
		case DEFAULT_PROFILE:
			path = "https://www.kindpng.com/imgv/iwoxbb_user-profile-default-image-png-clipart-png-download/";
		}
		return path;
	}
}
