package com.instanect.uicrudastableformmodule.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.instanect.uicrudastableformmodule.R;
import com.instanect.uicrudastableformmodule.R2;
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
    void onImageButtonAddClicked() {

        assertNotEquals(idResRowLayout, -1);

        View view = getLayoutInflater().inflate(idResRowLayout, null);

        assertNotNull(addNewRowCallback);
        addNewRowCallback.onUITableLayoutFormFragmentAddNewButtonAddClicked(view);

    }

    @BindView(R2.id.ll_table_entries)
    LinearLayout linearLayout;

    public void onAddNewRequestSuccessful(View rowChildView) {


        String tag = UUID.randomUUID().toString();

        rowChildView.setTag(tag);

        ImageButton deleteButton = rowChildView.findViewById(buttonDeleteResId);

        if (deleteButton != null)
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    assertNotNull(deleteRowCallback);
                    deleteRowCallback.onUITableLayoutFormFragmentRowDeleteButtonClicked(rowChildView);

                }
            });


        if (onViewInsideRowClickedCallback != null)
            for (int i = 0; i < ((ViewGroup) rowChildView).getChildCount(); i++) {
                View v = ((ViewGroup) rowChildView).getChildAt(i);
                if (v instanceof TextView)
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onViewInsideRowClickedCallback
                                    .onUITableLayoutFormFragmentViewInsideRowClicked(
                                            view);
                        }
                    });
            }


        // This looks better
        linearLayout.addView(rowChildView,
                new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    public static UITableLayoutFormFragment newInstance() {
        return new UITableLayoutFormFragment();
    }


    @BindView(R2.id.textViewFormTitle)
    TextView textViewFormTitle;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
        this.maxRowAllowed = maxRowAllowed;
    }

    protected void setIdResRowLayout(int idResRowLayout) {
        this.idResRowLayout = idResRowLayout;
    }

    public void setButtonDeleteResId(int buttonDeleteResId) {
        this.buttonDeleteResId = buttonDeleteResId;
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

    protected void setAddNewRowCallback(UITableLayoutFormFragmentAddNewRowCallback addNewRowCallback) {
        this.addNewRowCallback = addNewRowCallback;
    }

    protected void setDeleteRowCallback(UITableLayoutFormFragmentDeleteRowCallback deleteRowCallback) {
        this.deleteRowCallback = deleteRowCallback;
    }

    protected void setOnViewInsideRowClickedCallback(UITableLayoutFormFragmentOnViewInsideRowClicked onViewInsideRowClickedCallback) {
        this.onViewInsideRowClickedCallback = onViewInsideRowClickedCallback;
    }
}
