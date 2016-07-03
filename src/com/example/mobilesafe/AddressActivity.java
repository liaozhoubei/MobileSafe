package com.example.mobilesafe;


import com.example.mobilesafe.dao.AddressDao;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddressActivity extends Activity{
	private EditText et_address_queryphone;
	private TextView tv_address_queryaddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address);
		et_address_queryphone = (EditText) findViewById(R.id.et_address_queryphone);
		tv_address_queryaddress = (TextView) findViewById(R.id.tv_address_queryaddress);
	}
	/**
	 * 查询号码归属地操作
	 * @param v
	 */
	public void query(View v){
		//1.获取输入的号码
		String phone = et_address_queryphone.getText().toString().trim();
		//2.判断号码是否为空
		if (TextUtils.isEmpty(phone)) {
			Toast.makeText(getApplicationContext(), "请输入要查询号码", 0).show();
			return;
		}
		//3.根据号码查询号码归属地
		String queryAddress = AddressDao.queryAddress(phone, getApplicationContext());
		//4.判断查询的号码归属地是否为空
		if (!TextUtils.isEmpty(queryAddress)) {
			tv_address_queryaddress.setText(queryAddress);
		}
	}
}
