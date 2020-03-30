package com.instanect.uicrudastableformmodule.createOrEdit.ui.structure

import com.instanect.uicrudastableformmodule.common.base.UIFragmentBaseProperties
import com.instanect.uicrudastableformmodule.createOrEdit.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback
import com.instanect.uicrudastableformmodule.createOrEdit.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback
import com.instanect.uicrudastableformmodule.common.base.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked

class UIEditOrCreateFragmentProperties : UIFragmentBaseProperties() {
    var addAllowed = true
    var deleteAllowed = true
    var addNewRowCallback: UITableLayoutFormFragmentAddNewRowCallback? = null
    var deleteRowCallback: UITableLayoutFormFragmentDeleteRowCallback? = null
    var buttonDeleteResId = -1
}