package com.instanect.uicrudastableformmodule.common.base

import com.instanect.uicrudastableformmodule.common.base.interfaces.UITableLayoutFormFragmentBeforeRowAdd
import com.instanect.uicrudastableformmodule.common.base.interfaces.UITableLayoutFormFragmentOnSpinnerInsideRowClicked
import com.instanect.uicrudastableformmodule.common.base.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked

public open class UIFragmentBaseProperties {
    var maxRowAllowed = 0
    var idResRowLayout = -1
    var titleOfForm = "My Form"
    var onViewInsideRowClickedListener: UITableLayoutFormFragmentOnViewInsideRowClicked? = null
    var onSpinnerInsideRowClickedListener: UITableLayoutFormFragmentOnSpinnerInsideRowClicked? = null
    var onBeforeRowAddListener: UITableLayoutFormFragmentBeforeRowAdd? = null

}