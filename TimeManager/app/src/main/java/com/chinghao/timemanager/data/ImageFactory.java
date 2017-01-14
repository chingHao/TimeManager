package com.chinghao.timemanager.data;

import com.chinghao.timemanager.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChingHao on 2016/12/22.
 */

public class ImageFactory {
    private ImageFactory(){

    }
    private static final String[] ids=new String[]{
            "asset:///bg_autumn_tree-min.jpg", "asset:///bg_kites-min.png", "asset:///bg_lake-min.jpg", "asset:///bg_leaves-min.jpg",
            "asset:///bg_magnolia_trees-min.jpg", "asset:///bg_solda-min.jpg", "asset:///bg_tree-min.jpg", "asset:///bg_tulip-min.jpg"};

    public static List<String> createBgImgs(){
        return Arrays.asList(ids);
    }

    private static final int[] priorityIcons=new int[]{
            R.drawable.ic_priority_1,
            R.drawable.ic_priority_2,
            R.drawable.ic_priority_3,
            R.drawable.ic_priority_4
    };

    public static int[] createPriorityIcons(){
        return priorityIcons;
    }
}
