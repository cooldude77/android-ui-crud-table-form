package com.instanect.uicrudastableformmodule.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.instanect.uicrudastableformmodule.R;
import com.instanect.uicrudastableformmodule.R2;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked;
import com.instanect.uicrudastableformmodule.ui.structure.UIFragmentProperties;
import com.instanect.uicrudastableformmodule.ui.view.ChildIdList;
import com.instanect.uicrudastableformmodule.ui.view.IdFieldValueForARowMap;
import com.instanect.uicrudastableformmodule.ui.view.RowViewTagRelationObject;

import java.util.ArrayList;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UITableLayoutFormFragment extends Fragment {
    private Context context;


    UIFragmentProperties uiFragmentProperties = new UIFragmentProperties();

    @OnClick(R2.id.imageButtonAdd)
    void onImageButtonAddClicked() {
        assertNotEquals(uiFragmentProperties.getIdResRowLayout(), -1);
        View view = getLayoutInflater().inflate(uiFragmentProperties.getIdResRowLayout(), null);
        assertNotNull(uiFragmentProperties.getAddNewRowCallback());
        uiFragmentProperties.getAddNewRowCallback().onUITableLayoutFormFragmentAddNewButtonAddClicked(view);
    }

    @BindView(R2.id.layout_table_entries)
    LinearLayout linearLayout;

    private ArrayList<RowViewTagRelationObject> rowViewTagRelationObjects = new ArrayList<>();
    private ChildIdList childIdList = new ChildIdList();

    public ArrayList<RowViewTagRelationObject> getRowViewTagRelationObjects() {
        return rowViewTagRelationObjects;
    }

    public void setChildIdList(ChildIdList childIdList) {
        this.childIdList = childIdList;
    }

    public ChildIdList getChildIdList() {
        return childIdList;
    }

    public ArrayList<IdFieldValueForARowMap> getData() {
        ArrayList<IdFieldValueForARowMap> idFieldValueForARowMaps = new ArrayList<>();
        for (int i = 0; i < rowViewTagRelationObjects.size(); i++) {
            View parent = rowViewTagRelationObjects.get(i).getView();

            idFieldValueForARowMaps.add(getIdValueMap(parent));

        }
        return idFieldValueForARowMaps;
    }

    private IdFieldValueForARowMap getIdValueMap(View parent) {
        IdFieldValueForARowMap idValueMap = new IdFieldValueForARowMap();

        for (Integer integer : childIdList) {
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

    public void onAddNewRequestSuccessful(View rowChildView) {

        String tag = UUID.randomUUID().toString();

        rowChildView.setTag(tag);

        RowViewTagRelationObject rowViewTagRelationObject = new RowViewTagRelationObject();
        rowViewTagRelationObject.setTag(tag);
        rowViewTagRelationObject.setView(rowChildView);
        rowViewTagRelationObjects.add(rowViewTagRelationObject);

        ImageButton deleteButton = rowChildView.findViewById(uiFragmentProperties
                .getButtonDeleteResId());

        if (deleteButton != null)
            deleteButton.setOnClickListener(v -> {
                assertNotNull(uiFragmentProperties.getDeleteRowCallback());
                uiFragmentProperties.getDeleteRowCallback()
                        .onUITableLayoutFormFragmentRowDeleteButtonClicked(rowChildView);
            });

        if (uiFragmentProperties.getOnViewInsideRowClickedCallback() != null)
            for (int i = 0; i < ((ViewGroup) rowChildView).getChildCount(); i++) {
                View v = ((ViewGroup) rowChildView).getChildAt(i);
                if (v instanceof TextView)
                    v.setOnClickListener(view ->
                            uiFragmentProperties.getOnViewInsideRowClickedCallback()
                                    .onUITableLayoutFormFragmentViewInsideRowClicked(view));
            }

        // This looks better
        linearLayout.addView(rowChildView,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    public static UITableLayoutFormFragment newInstance() {
        return new UITableLayoutFormFragment();
    }


    @BindView(R2.id.textViewFormTitle)
    TextView textViewFormTitle;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_layout, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    public void deleteRow(View rowOnWhichDeleteWasClicked) {
        linearLayout.removeView(rowOnWhichDeleteWasClicked);
    }

    public void setMaxRowAllowed(int maxRowAllowed) {
        uiFragmentProperties.setMaxRowAllowed(maxRowAllowed);
    }

    protected void setIdResRowLayout(int idResRowLayout) {
        uiFragmentProperties.setIdResRowLayout(idResRowLayout);
    }

    public void setButtonDeleteResId(int buttonDeleteResId) {
        uiFragmentProperties.setButtonDeleteResId(buttonDeleteResId);
    }

    public void setAddAllowed(boolean addAllowed) {
        uiFragmentProperties.setAddAllowed(addAllowed);
    }

    public void setDeleteAllowed(boolean deleteAllowed) {
        uiFragmentProperties.setDeleteAllowed(deleteAllowed);
    }

    public void setTitleOfForm(String titleOfForm) {
        uiFragmentProperties.setTitleOfForm(titleOfForm);
    }

    protected void setAddNewRowCallback(UITableLayoutFormFragmentAddNewRowCallback addNewRowCallback) {
        uiFragmentProperties.setAddNewRowCallback(addNewRowCallback);
    }

    protected void setDeleteRowCallback(UITableLayoutFormFragmentDeleteRowCallback deleteRowCallback) {
        uiFragmentProperties.setDeleteRowCallback(deleteRowCallback);
    }

    protected void setOnViewInsideRowClickedCallback(
            UITableLayoutFormFragmentOnViewInsideRowClicked onViewInsideRowClickedCallback) {
        uiFragmentProperties.setOnViewInsideRowClickedCallback(onViewInsideRowClickedCallback);
    }
}
