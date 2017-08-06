package com.multiplelisttest;

import java.io.Serializable;

/**
 * Created by zhangjiaying on 2017/8/6.
 */

public class BaseObject implements Serializable{
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
