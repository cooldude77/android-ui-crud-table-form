package com.instanect.uicrudastableformmodule.fragment.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.instanect.uicrudastableformmodule.R;
import com.instanect.uicrudastableformmodule.R2;
import com.instanect.uicrudastableformmodule.ui.view.ChildIdList;
import com.instanect.uicrudastableformmodule.ui.view.RowViewAndItsTagRelationObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

abstract public class UIFormBaseFragment extends Fragment {
    private Context context;


    UIFragmentBaseProperties uiFragmentBaseProperties = new UIFragmentBaseProperties();


    @BindView(R2.id.layout_table_entries)
    LinearLayout linearLayout;

    private ArrayList<RowViewAndItsTagRelationObject> rowViewAndItsTagRelationObjects = new ArrayList<>();
    private ChildIdList childIdList = new ChildIdList();


    protected void setChildIdList(ChildIdList childIdList) {
        this.childIdList = childIdList;
    }

    public ArrayList<RowViewAndItsTagRelationObject> getRowViewAndItsTagRelationObjects() {
        return rowViewAndItsTagRelationObjects;
    }

    public void setRowViewAndItsTagRelationObjects(ArrayList<RowViewAndItsTagRelationObject> rowViewAndItsTagRelationObjects) {
        this.rowViewAndItsTagRelationObjects = rowViewAndItsTagRelationObjects;
    }

    public ChildIdList getChildIdList() {
        return childIdList;
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


    public void setMaxRowAllowed(int maxRowAllowed) {
        uiFragmentBaseProperties.setMaxRowAllowed(maxRowAllowed);
    }

    protected void setIdResRowLayout(int idResRowLayout) {
        uiFragmentBaseProperties.setIdResRowLayout(idResRowLayout);
    }

    @Nullable
    @Override
    public Context getContext() {
        return context;
    }

    public UIFragmentBaseProperties getUiFragmentBaseProperties() {
        return uiFragmentBaseProperties;
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }


    public void setTitleOfForm(String titleOfForm) {
        uiFragmentBaseProperties.setTitleOfForm(titleOfForm);
    }
}
