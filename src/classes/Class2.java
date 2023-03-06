package classes;

import annotations.Private;
import annotations.Public;
import interfaces.MyInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Class2 implements MyInterface {
    @Override
    @Public
    @Private
    public String getId() {
        return null;
    }

    @Override
    @Private
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
    public Double divide(Double a, Double b) throws Exception {
        return null;
    }

    @Override
    @Private
    public Date calcDate3DaysAgo() {
        return null;
    }

    @Override
    @Private
    public LocalTime alwaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Override
    public void someMethodWithoutReturnData() {

    }

    @Override
    @Public
    public void someMethodWithoutDataBugHaveVariableNumbersOfArguments(String... varArgs) {

    }
}