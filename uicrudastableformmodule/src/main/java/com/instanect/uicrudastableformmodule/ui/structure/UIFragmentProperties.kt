package com.instanect.uicrudastableformmodule.ui.structure

import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked

class UIFragmentProperties {
    var maxRowAllowed = 0
    var idResRowLayout = -1
    var addAllowed = true
    var deleteAllowed = true
    var titleOfForm = "My Form"
    var addNewRowCallback: UITableLayoutFormFragmentAddNewRowCallback? = null
    var deleteRowCallback: UITableLayoutFormFragmentDeleteRowCallback? = null
    var onViewInsideRowClickedCallback: UITableLayoutFormFragmentOnViewInsideRowClicked? = null
    var buttonDeleteResId = -1
}