package com.alwaysbaked.calc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment implements CalculatorContract.PublishToView{

    private CalculatorContract.ForwardDisplayInteractionToPresenter forwardDisplayInteraction;

    public void setPresenter(CalculatorContract.ForwardDisplayInteractionToPresenter forwardDisplayInteraction){
        this.forwardDisplayInteraction = forwardDisplayInteraction;
    }


    @BindView(R.id.textDisplay) TextView display;

    @OnClick(R.id.imageButtonDelete)
    public void onDeleteShortClick(View v){
        forwardDisplayInteraction.onDeleteShortClick();

    }

    @OnLongClick(R.id.imageButtonDelete)
    public boolean onDeleteLongClick(View v){
        forwardDisplayInteraction.onDeleteLongClick();
        return true;

    }

    public DisplayFragment() {
        // Required empty public constructor
    }

    public static DisplayFragment newInstance(){
        return new DisplayFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_display, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void showResult(String result) {
        display.setText(result);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
