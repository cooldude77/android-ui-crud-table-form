package com.instanect.uicrudastableformmodule.ui.structure

import com.instanect.uicrudastableformmodule.fragment.base.UIFragmentBaseProperties
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked

class UIEditOrCreateFragmentProperties() {
    var uiFragmentBaseProperties = UIFragmentBaseProperties()
    var addAllowed = true
    var deleteAllowed = true
    var addNewRowCallback: UITableLayoutFormFragmentAddNewRowCallback? = null
    var deleteRowCallback: UITableLayoutFormFragmentDeleteRowCallback? = null
    var onViewInsideRowClickedCallback: UITableLayoutFormFragmentOnViewInsideRowClicked? = null
    var buttonDeleteResId = -1
}