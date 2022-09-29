package com.refresh.pos.ui.component;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

/**
在每筆資料分配一個按鈕
 */
public class ButtonAdapter extends SimpleAdapter {

	private List<? extends Map<String, ?>> data;
	private int buttonId;
	private String tag;
	
	/**
	 * 建構按鈕適配器
	 */
	public ButtonAdapter(Context context, List<? extends Map<String, ?>> data,
			int resource, String[] from, int[] to, int buttonId, String tag) {
		super(context, data, resource, from, to);
		this.data = data;
		this.buttonId = buttonId;
		this.tag = tag;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
		((View) view.findViewById(buttonId)).setTag(data.get(position).get(tag));
		return view;
	}

}
