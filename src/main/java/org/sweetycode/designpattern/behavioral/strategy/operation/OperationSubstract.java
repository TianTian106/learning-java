package org.sweetycode.designpattern.behavioral.strategy.operation;

/**
 * Created by tiantian on 02/09/2018.
 */
public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
