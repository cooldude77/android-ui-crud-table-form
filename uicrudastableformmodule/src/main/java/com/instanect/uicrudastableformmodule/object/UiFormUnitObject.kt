package com.instanect.uicrudastableformmodule.`object`

import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked

public class UiFormUnitObject {
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