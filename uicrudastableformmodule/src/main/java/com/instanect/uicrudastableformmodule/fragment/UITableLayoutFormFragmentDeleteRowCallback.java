package com.instanect.uicrudastableformmodule.fragment;

import android.view.View;
import android.widget.TableRow;

public interface UITableLayoutFormFragmentDeleteRowCallback {
    void onRowDeleteButtonClicked(UITableLayoutFormFragment uiTableLayoutFormFragment,
                                  TableRow rowOnWhichDeleteWasClicked);
}
