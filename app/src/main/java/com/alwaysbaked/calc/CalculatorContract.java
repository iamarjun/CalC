package com.alwaysbaked.calc;

public interface CalculatorContract {

    interface PublishToView {

        void showResult(String result);

        void showToast(String message);
    }

    interface ForwardDisplayInteractionToPresenter{

        void onDeleteShortClick();

        void onDeleteLongClick();
    }

    interface ForwardInputInteractionToPresenter{

        void onNumberClick(int number);

        void onOperatorClick(String operator);

        void onDecimalClick();

        void onEqualsClick();
    }
}
