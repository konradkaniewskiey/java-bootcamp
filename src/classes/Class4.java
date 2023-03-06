package classes;

import annotations.Private;
import annotations.Public;
import annotations.ScanMe;
import interfaces.MyInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@ScanMe
public class Class4 implements MyInterface {
    @Override
    @Public
    public String getId() {
        return null;
    }

    @Override
    @Public
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
    @Private
    public Double divide(Double a, Double b) throws Exception {
        return null;
    }

    @Override
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