package interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public interface MyInterface {
    String getId();
    Integer sum(Integer a, Integer b);
    Double divide(Double a, Double b) throws Exception;
    Date calcDate3DaysAgo();
    LocalTime alwaysAdd3Hours(LocalDate inDate);
    void someMethodWithoutReturnData();
    void someMethodWithoutDataBugHaveVariableNumbersOfArguments(String... varArgs);
}