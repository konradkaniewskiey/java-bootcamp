package classes;

import annotations.Private;
import annotations.Public;
import interfaces.MyInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Class1 implements MyInterface {
    @Override
    public String getId() {
        return null;
    }

    @Override
    @Private
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
    @Public
    @Private
    public Double divide(Double a, Double b) throws Exception {
        return null;
    }

    @Override
    @Public
    public Date calcDate3DaysAgo() {
        return null;
    }

    @Override
    public LocalTime alwaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Override
    @Public
    @Private
    public void someMethodWithoutReturnData() {

    }

    @Override
    @Public
    public void someMethodWithoutDataBugHaveVariableNumbersOfArguments(String... varArgs) {

    }
}