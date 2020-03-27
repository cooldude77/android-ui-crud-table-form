package com.instanect.uicrudastableformmodule.ui.view

import android.view.View

/**
 * Container for relation between tag and view
 */
public class RowViewAndItsTagRelationObject {
    var tag: String? = null
    var view: View? = null
    var isNew: Boolean = true;
    var isDeleted: Boolean = false;
}