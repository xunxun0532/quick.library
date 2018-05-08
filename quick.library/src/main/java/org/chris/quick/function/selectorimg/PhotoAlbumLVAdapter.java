/*
 * yidingliu.com Inc. * Copyright (c) 2016 All Rights Reserved.
 */

package org.chris.quick.function.selectorimg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import org.chris.quick.R;
import org.chris.quick.m.ImageManager;

import java.io.File;
import java.util.ArrayList;

/**
 * 选择相册页面,ListView的adapter
 * Created by hanj on 14-10-14.
 */
public class PhotoAlbumLVAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PhotoAlbumLVItem> list;

    public PhotoAlbumLVAdapter ( Context context, ArrayList<PhotoAlbumLVItem> list ) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.activity_photo_album_lv_item, null);
            holder = new ViewHolder();

            holder.firstImageIV = (ImageView) convertView.findViewById (R.id.select_img_gridView_img );
            holder.pathNameTV = (TextView) convertView.findViewById(R.id.select_img_gridView_path);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //图片（缩略图）
        String filePath = list.get(position).getFirstImagePath();
        ImageManager.loadImage ( parent.getContext (),new File(filePath),holder.firstImageIV );
        //文字
        holder.pathNameTV.setText(getPathNameToShow(list.get(position)));

        return convertView;
    }

    private class ViewHolder {
        ImageView firstImageIV;
        TextView pathNameTV;
    }

    /**根据完整路径，获取最后一级路径，并拼上文件数用以显示。*/
    private String getPathNameToShow(PhotoAlbumLVItem item) {
        String absolutePath = item.getPathName();
        int lastSeparator = absolutePath.lastIndexOf(File.separator);
        return absolutePath.substring(lastSeparator + 1) + "(" + item.getFileCount() + ")";
    }

}
