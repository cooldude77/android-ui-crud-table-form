package com.instanect.uicrudastableformmodule.common.base

import com.instanect.uicrudastableformmodule.common.base.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked

public open class UIFragmentBaseProperties {
    var maxRowAllowed = 0
    var idResRowLayout = -1
    var titleOfForm = "My Form"
    var onViewInsideRowClickedCallback: UITableLayoutFormFragmentOnViewInsideRowClicked? = null

}