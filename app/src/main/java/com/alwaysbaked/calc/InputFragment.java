package com.alwaysbaked.calc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private CalculatorContract.ForwardInputInteractionToPresenter forwardInputInteraction;

    public void setPresenter(CalculatorContract.ForwardInputInteractionToPresenter forwardInputInteraction){
        this.forwardInputInteraction = forwardInputInteraction;
    }

    @OnClick({
            R.id.buttonZero,
            R.id.buttonOne,
            R.id.buttonTwo,
            R.id.buttonThree,
            R.id.buttonFour,
            R.id.buttonFive,
            R.id.buttonSix,
            R.id.buttonSeven,
            R.id.buttonEight,
            R.id.buttonNine})

    public void onNumberClick(Button v){
        forwardInputInteraction.onNumberClick(Integer.parseInt(v.getText().toString()));
    }

    @OnClick({
            R.id.buttonAdd,
            R.id.buttonSubtract,
            R.id.buttonMultiply,
            R.id.buttonDivide})

    public void onOperatorClick(Button v){
        forwardInputInteraction.onOperatorClick(v.getText().toString());
    }

    @OnClick(R.id.buttonDecimal)

    public void onDecimalClick(Button v){
        forwardInputInteraction.onDecimalClick();
    }

    @OnClick(R.id.buttonEquals)

    public void onEqualsClick(Button v){
        forwardInputInteraction.onEqualsClick();
    }

    public InputFragment() {
        // Required empty public constructor
    }

    public static InputFragment newInstance(){
        return new InputFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_input, container, false);

        ButterKnife.bind(this, v);

        return v;
    }

}
