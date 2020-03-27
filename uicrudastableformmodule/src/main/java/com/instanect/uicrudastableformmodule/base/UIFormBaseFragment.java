package com.instanect.uicrudastableformmodule.base;

import android.annotation.SuppressLint;
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
import com.instanect.uicrudastableformmodule.createOrEdit.ui.view.ChildIdList;
import com.instanect.uicrudastableformmodule.createOrEdit.ui.view.RowViewAndItsTagRelationObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

abstract public class UIFormBaseFragment extends Fragment {
    private Context context;

    private ArrayList<RowViewAndItsTagRelationObject> rowViewAndItsTagRelationObjects = new ArrayList<>();
    private ChildIdList childIdList = new ChildIdList();

    protected void setChildIdList(ChildIdList childIdList) {
        this.childIdList = childIdList;
    }

    protected ArrayList<RowViewAndItsTagRelationObject> getRowViewAndItsTagRelationObjects() {
        return rowViewAndItsTagRelationObjects;
    }
    public void setRowViewAndItsTagRelationObjects(ArrayList<RowViewAndItsTagRelationObject> rowViewAndItsTagRelationObjects) {
        this.rowViewAndItsTagRelationObjects = rowViewAndItsTagRelationObjects;
    }

    protected ChildIdList getChildIdList() {
        return childIdList;
    }

    @BindView(R2.id.layout_table_entries)
    LinearLayout linearLayout;

    @BindView(R2.id.textViewFormTitle)
    TextView textViewFormTitle;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.base_layout, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }


    @Nullable
    @Override
    public Context getContext() {
        return context;
    }

    protected LinearLayout getLinearLayout() {
        return linearLayout;
    }

}
