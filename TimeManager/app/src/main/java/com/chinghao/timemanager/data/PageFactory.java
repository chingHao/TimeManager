package com.chinghao.timemanager.data;

import com.chinghao.timemanager.entities.MainPageItem;
import com.chinghao.timemanager.fragments.PageFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ChingHao on 2016/12/19.
 */

public class PageFactory {
    private static List<MainPageItem> mItems=new ArrayList<>();
    public static List<MainPageItem> createPage(){
        if (mItems == null || mItems.size()==0){
            mItems=new ArrayList<>();
            mItems.add(new MainPageItem(Calendar.SUNDAY, "周日", new PageFragment()));
            mItems.add(new MainPageItem(Calendar.MONDAY, "周一", new PageFragment()));
            mItems.add(new MainPageItem(Calendar.TUESDAY, "周二", new PageFragment()));
            mItems.add(new MainPageItem(Calendar.WEDNESDAY, "周三", new PageFragment()));
            mItems.add(new MainPageItem(Calendar.THURSDAY, "周四", new PageFragment()));
            mItems.add(new MainPageItem(Calendar.FRIDAY, "周五", new PageFragment()));
            mItems.add(new MainPageItem(Calendar.SATURDAY, "周六", new PageFragment()));
        }
        return mItems;
    }
}
