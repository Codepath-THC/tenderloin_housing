package com.tenderloinhousing.apps.adapter;

import java.util.ArrayList;
import java.util.List;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.squareup.picasso.Picasso;
import com.tenderloinhousing.apps.R;
import com.tenderloinhousing.apps.fragment.CaseDetailsFragment;
import com.tenderloinhousing.apps.model.Case;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CasePictureAdatper extends BaseAdapter {

	ArrayList<ParseFile> pictures;
	LayoutInflater li;
	Context context;
	
	public CasePictureAdatper(Activity activity, ArrayList<ParseFile> pictures) {
		this.pictures = pictures;
		this.li = activity.getLayoutInflater();
		this.context = activity;
	}
	
	@Override
	public int getCount() {
		if (pictures==null) {
			return 0;
		}
		return pictures.size();
	}

	@Override
	public Object getItem(int position) {
		return pictures.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		if (convertView==null) {
			view = li.inflate(R.layout.image_case_item, null);
		} else {
			view = convertView;
		}
		
		
		ParseFile currentParseFile = pictures.get(position);
		String image = currentParseFile.getUrl();
			
//		String image = "http://i.imgur.com/DvpvklR.png";
		Picasso.with(context).load(image).into((ImageView)view.findViewById(R.id.imageView1));
			
			
		
		return view;
	}

	
	

}
