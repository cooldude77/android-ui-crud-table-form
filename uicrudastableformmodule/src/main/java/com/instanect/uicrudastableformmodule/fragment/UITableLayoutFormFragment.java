package com.instanect.uicrudastableformmodule.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.instanect.uicrudastableformmodule.R;
import com.instanect.uicrudastableformmodule.R2;
import com.instanect.uicrudastableformmodule.formObject.UiFormUnitObject;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentAddNewRowCallback;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentDeleteRowCallback;
import com.instanect.uicrudastableformmodule.fragment.interfaces.UITableLayoutFormFragmentOnViewInsideRowClicked;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UITableLayoutFormFragment extends Fragment {
    private UiFormUnitObject uiFormUnitObject;
    private Context context;

    private int maxRowAllowed = 0;
    private int idResRowLayout = -1;
    private boolean addAllowed = true;
    private boolean deleteAllowed = true;
    private String titleOfForm = "My Form";
    private UITableLayoutFormFragmentAddNewRowCallback addNewRowCallback;
    private UITableLayoutFormFragmentDeleteRowCallback deleteRowCallback;
    private UITableLayoutFormFragmentOnViewInsideRowClicked onViewInsideRowClickedCallback;
    private int buttonDeleteResId = -1;

    @OnClick(R2.id.imageButtonAdd)
    public void onImageButtonAddClicked() {

        assertNotEquals(uiFormUnitObject.getIdResRowLayout(), -1);

        View view = getLayoutInflater().inflate(uiFormUnitObject.getIdResRowLayout(), null);

        assertNotNull(uiFormUnitObject.getAddNewRowCallback());
        uiFormUnitObject.getAddNewRowCallback().onUITableLayoutFormFragmentAddNewButtonAddClicked(view);

    }

    @BindView(R2.id.tableLayout)
    TableLayout tableLayout;

    public void onAddNewRequestSuccessful(View rowChildView) {
        TableRow tableRow = new TableRow(context);
        tableRow.addView(rowChildView);
        String tag = UUID.randomUUID().toString();
        tableRow.setTag(tag);

        ImageButton deleteButton = tableRow.findViewById(uiFormUnitObject.getButtonDeleteResId());

        if (deleteButton != null)
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    assertNotNull(uiFormUnitObject.getDeleteRowCallback());
                    uiFormUnitObject.getDeleteRowCallback().onUITableLayoutFormFragmentRowDeleteButtonClicked(

                            tableRow
                    );

                }
            });


        if (uiFormUnitObject.getOnViewInsideRowClickedCallback() != null)
            for (int i = 0; i < ((ViewGroup) rowChildView).getChildCount(); i++) {
                View v = ((ViewGroup) rowChildView).getChildAt(i);
                if (v instanceof TextView)
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            uiFormUnitObject.getOnViewInsideRowClickedCallback()
                                    .onUITableLayoutFormFragmentViewInsideRowClicked(
                                            view);
                        }
                    });
            }


        tableLayout.addView(tableRow);
    }

    public static UITableLayoutFormFragment newInstance(UiFormUnitObject uiFormUnitObject) {

        UITableLayoutFormFragment formUnitFragment = new UITableLayoutFormFragment();

        formUnitFragment.setUiFormUnitObject(uiFormUnitObject);

        return formUnitFragment;
    }

    public void setUiFormUnitObject(UiFormUnitObject uiFormUnitObject) {
        this.uiFormUnitObject = uiFormUnitObject;
    }

    @BindView(R2.id.textViewFormTitle)
    TextView textViewFormTitle;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_layout, null);
        ButterKnife.bind(this, view);

        textViewFormTitle.setText(uiFormUnitObject.getTitleOfForm());

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    public void deleteRow(TableRow rowOnWhichDeleteWasClicked) {
        tableLayout.removeView(rowOnWhichDeleteWasClicked);
    }

    public void setMaxRowAllowed(int maxRowAllowed) {
        this.maxRowAllowed = maxRowAllowed;
    }

    public void setIdResRowLayout(int idResRowLayout) {
        this.idResRowLayout = idResRowLayout;
    }

    public void setAddAllowed(boolean addAllowed) {
        this.addAllowed = addAllowed;
    }

    public void setDeleteAllowed(boolean deleteAllowed) {
        this.deleteAllowed = deleteAllowed;
    }

    public void setTitleOfForm(String titleOfForm) {
        this.titleOfForm = titleOfForm;
    }

    public void setAddNewRowCallback(UITableLayoutFormFragmentAddNewRowCallback addNewRowCallback) {
        this.addNewRowCallback = addNewRowCallback;
    }

    public void setDeleteRowCallback(UITableLayoutFormFragmentDeleteRowCallback deleteRowCallback) {
        this.deleteRowCallback = deleteRowCallback;
    }

    public void setOnViewInsideRowClickedCallback(UITableLayoutFormFragmentOnViewInsideRowClicked onViewInsideRowClickedCallback) {
        this.onViewInsideRowClickedCallback = onViewInsideRowClickedCallback;
    }
}
