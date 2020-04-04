package com.instanect.uicrudastableformmodule.common.view;

import android.view.View;
import android.view.ViewParent;

public class ParentViewByIdFinder {

    public ViewParent findParentById(View view, int targetId) {
        if (view.getId() == targetId) {
            return (ViewParent)view;
        }
        View parent = (View) view.getParent();
        if (parent == null) {
            return null;
        }
        return findParentById(parent, targetId);
    }
}
