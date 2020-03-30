package com.instanect.uicrudastableformmodule.createOrEdit.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.instanect.uicrudastableformmodule.R;
import com.instanect.uicrudastableformmodule.R2;
import com.instanect.uicrudastableformmodule.common.base.UIFormBaseFragment;
import com.instanect.uicrudastableformmodule.common.view.IdFieldValueForARowMap;
import com.instanect.uicrudastableformmodule.common.view.RowViewAndItsTagRelationObject;
import com.instanect.uicrudastableformmodule.createOrEdit.ui.structure.UIEditOrCreateFragmentProperties;

import java.util.ArrayList;
import java.util.UUID;

import butterknife.OnClick;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UIEditOrCreateTableFormFragment extends UIFormBaseFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setContentViewResId(R.layout.base_layout_create);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @OnClick(R2.id.imageButtonAdd)
    void onImageButtonAddClicked() {
        assertNotEquals(
                getUiFragmentProperties()
                        .getIdResRowLayout(), -1);
        View view = getLayoutInflater().inflate(
                getUiFragmentProperties().getIdResRowLayout(), null);

        assertNotNull(getUiFragmentProperties().getAddNewRowCallback());

        getUiFragmentProperties()
                .getAddNewRowCallback()
                .onUITableLayoutFormFragmentAddNewButtonAddClicked(view);
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

        ImageButton deleteButton = rowChildView.findViewById(getUiFragmentProperties()
                .getButtonDeleteResId());

        if (deleteButton != null)
            deleteButton.setOnClickListener(v -> {
                assertNotNull(getUiFragmentProperties().getDeleteRowCallback());
                getUiFragmentProperties().getDeleteRowCallback()
                        .onUITableLayoutFormFragmentRowDeleteButtonClicked(rowChildView);
            });

        if (getUiFragmentProperties().getOnViewInsideRowClickedCallback() != null)
            for (int i = 0; i < ((ViewGroup) rowChildView).getChildCount(); i++) {
                View v = ((ViewGroup) rowChildView).getChildAt(i);
                if (v instanceof TextView)
                    v.setOnClickListener(view ->
                            getUiFragmentProperties().getOnViewInsideRowClickedCallback()
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

    @Override
    public UIEditOrCreateFragmentProperties getUiFragmentProperties() {
        return (UIEditOrCreateFragmentProperties) super.getUiFragmentProperties();
    }
}
