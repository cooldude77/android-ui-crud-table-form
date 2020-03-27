package com.instanect.uicrudastableformmodule.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.instanect.uicrudastableformmodule.R2;
import com.instanect.uicrudastableformmodule.fragment.base.UIFormBaseFragment;
import com.instanect.uicrudastableformmodule.ui.structure.UIEditOrCreateFragmentProperties;
import com.instanect.uicrudastableformmodule.ui.view.IdFieldValueForARowMap;
import com.instanect.uicrudastableformmodule.ui.view.RowViewAndItsTagRelationObject;

import java.util.ArrayList;
import java.util.UUID;

import butterknife.OnClick;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UIEditOrCreateTableFormFragment extends UIFormBaseFragment {


    protected UIEditOrCreateFragmentProperties uiEditOrCreateFragmentProperties
            = new UIEditOrCreateFragmentProperties();



    @OnClick(R2.id.imageButtonAdd)
    void onImageButtonAddClicked() {
        assertNotEquals(
                uiEditOrCreateFragmentProperties.getUiFragmentBaseProperties()
                        .getIdResRowLayout(), -1);
        View view = getLayoutInflater().inflate(
                uiEditOrCreateFragmentProperties.getUiFragmentBaseProperties().getIdResRowLayout(), null);

        assertNotNull(uiEditOrCreateFragmentProperties.getAddNewRowCallback());

        uiEditOrCreateFragmentProperties.getAddNewRowCallback().onUITableLayoutFormFragmentAddNewButtonAddClicked(view);
    }


    public ArrayList<IdFieldValueForARowMap> getData() {
        ArrayList<IdFieldValueForARowMap> idFieldValueForARowMaps = new ArrayList<>();
        for (int i = 0; i < getRowViewAndItsTagRelationObjects().size(); i++) {
            View parent = getRowViewAndItsTagRelationObjects().get(i).getView();

            idFieldValueForARowMaps.add(getIdValueMap(parent));

        }
        return idFieldValueForARowMaps;
    }


    private IdFieldValueForARowMap getIdValueMap(View parent) {
        IdFieldValueForARowMap idValueMap = new IdFieldValueForARowMap();

        for (Integer integer : getChildIdList()) {
            assert parent != null;
            View view = parent.findViewById(integer);
            if (view != null) {
                String value = null;
                if (view instanceof TextView) {
                    value = ((TextView) view).getText().toString();
                    idValueMap.put(integer, value);
                }

            }

        }
        return idValueMap;

    }


    public void addNewRow(View rowChildView) {

        String tag = UUID.randomUUID().toString();

        rowChildView.setTag(tag);

        RowViewAndItsTagRelationObject rowViewAndItsTagRelationObject = new RowViewAndItsTagRelationObject();
        rowViewAndItsTagRelationObject.setTag(tag);
        rowViewAndItsTagRelationObject.setView(rowChildView);
        getRowViewAndItsTagRelationObjects().add(rowViewAndItsTagRelationObject);

        ImageButton deleteButton = rowChildView.findViewById(uiEditOrCreateFragmentProperties
                .getButtonDeleteResId());

        if (deleteButton != null)
            deleteButton.setOnClickListener(v -> {
                assertNotNull(uiEditOrCreateFragmentProperties.getDeleteRowCallback());
                uiEditOrCreateFragmentProperties.getDeleteRowCallback()
                        .onUITableLayoutFormFragmentRowDeleteButtonClicked(rowChildView);
            });

        if (uiEditOrCreateFragmentProperties.getOnViewInsideRowClickedCallback() != null)
            for (int i = 0; i < ((ViewGroup) rowChildView).getChildCount(); i++) {
                View v = ((ViewGroup) rowChildView).getChildAt(i);
                if (v instanceof TextView)
                    v.setOnClickListener(view ->
                            uiEditOrCreateFragmentProperties.getOnViewInsideRowClickedCallback()
                                    .onUITableLayoutFormFragmentViewInsideRowClicked(view));
            }

        // This looks better
        getLinearLayout().addView(rowChildView,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    public void deleteRow(View rowOnWhichDeleteWasClicked) {
        getLinearLayout().removeView(rowOnWhichDeleteWasClicked);
    }


}
