package com.instanect.uicrudastableformmodule.fragment.interfaces;

import android.view.View;
import android.widget.TableRow;

import com.instanect.uicrudastableformmodule.fragment.UITableLayoutFormFragment;

public interface UITableLayoutFormFragmentDeleteRowCallback {
    void onUITableLayoutFormFragmentRowDeleteButtonClicked(
            TableRow rowOnWhichDeleteWasClicked);
}
