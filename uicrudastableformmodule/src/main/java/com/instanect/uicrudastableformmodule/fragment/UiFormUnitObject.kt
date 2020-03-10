package com.instanect.uicrudastableformmodule.fragment

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