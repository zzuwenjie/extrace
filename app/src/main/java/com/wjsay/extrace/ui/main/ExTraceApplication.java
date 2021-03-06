package com.wjsay.extrace.ui.main;

import com.mysql.jdbc.StringUtils;
import com.wjsay.extrace.misc.model.UserInfo;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class ExTraceApplication extends Application {
	//private static final String PREFS_NAME = "ExTrace.cfg";
    SharedPreferences settings;// = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
//	String mServerUrl;
//	String mMiscService,mDomainService;
    UserInfo userInfo;
    
    public String getServerUrl() {  
        return settings.getString("ServerUrl", "");  
    }  
    public String getMiscServiceUrl() {
        String tmp = getServerUrl() + settings.getString("MiscService", "");
        //Log.e(TAG, "getMiscServiceUrl: " + tmp);
        return tmp;
    }
    public String getDomainServiceUrl() {  
        String tmp = getServerUrl() + settings.getString("DomainService", "");
        //Log.e(TAG, "getDomainServiceUrl: " + tmp);
        return tmp;
    }  
  
    public UserInfo getLoginUser(){
    	return userInfo;
    }
    
    @Override  
    public void onCreate() {  
        super.onCreate();  
        settings = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        //SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        //临时造一个用户
		userInfo = new UserInfo();
		userInfo.setID(12);
		userInfo.setReceivePackageID("1111112222");
		userInfo.setTransPackageID("1111115555");
		userInfo.setDelivePackageID("1111113333");
    }  
      
    public void onTerminate() {  
        super.onTerminate();  
          
        //save data of the map  
    }  
}
