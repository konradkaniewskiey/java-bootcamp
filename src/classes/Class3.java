package classes;

import annotations.Private;
import annotations.Public;
import annotations.ScanMe;
import interfaces.MyInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@ScanMe
public class Class3 implements MyInterface {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
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
    @Public
    @Private
    public LocalTime alwaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Override
    @Private
    public void someMethodWithoutReturnData() {

    }

    @Override
    public void someMethodWithoutDataBugHaveVariableNumbersOfArguments(String... varArgs) {

    }
}