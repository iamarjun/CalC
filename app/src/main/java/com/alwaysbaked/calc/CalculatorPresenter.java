package com.alwaysbaked.calc;

public class CalculatorPresenter implements CalculatorContract.ForwardDisplayInteractionToPresenter,
        CalculatorContract.ForwardInputInteractionToPresenter, Calculation.CalculationResult {

    private CalculatorContract.PublishToView publishResult;
    private Calculation calculation;

    public CalculatorPresenter(CalculatorContract.PublishToView publishResult) {
        this.publishResult = publishResult;
        calculation = new Calculation();
        calculation.setCalculationResultListener(this);
    }

    @Override
    public void onDeleteShortClick() {
        calculation.deleteCharacter();
    }

    @Override
    public void onDeleteLongClick() {
        calculation.deleteExpression();
    }

    @Override
    public void onNumberClick(int number) {
        calculation.appendNumber(Integer.toString(number));
    }

    @Override
    public void onOperatorClick(String operator) {
        calculation.appendOperator(operator);
    }

    @Override
    public void onDecimalClick() {
        calculation.appendDecimal();
    }

    @Override
    public void onEqualsClick() {
        calculation.performEvaluation();
    }

    @Override
    public void onExpressionChange(String result, Boolean successful) {
        if (successful){
            publishResult.showResult(result);
        } else {
            publishResult.showToast(result);
        }
    }
}
