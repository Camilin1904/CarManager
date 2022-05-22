package ui;

import model.Terminal;
import java.time.LocalDate;

public class TestCases {

    private LocalDate today;

    public TestCases(){
        today = LocalDate.now();
       
    }
    public void CreateTestCases(Terminal control){
        control.addVehicle(10000000.0, "Yamaha", 2022, 234.0, 0.0, true, "", 200.0, 3, 3, -1.0, 0, 0.0, -1.0, 0, 0.0,today.getYear() , 0.0, "1234567890");
        control.addVehicle(1000000.0, "ElCarrito", 2014, 2.0, 234.0, false, "P9t0#", 4, true, 1, 20.0, true, 123, 1, 20220.0, 2013, 20233.0, 22.0, 2022, 20123.0, 2020, 123.0, "0987654321");
        control.addVehicle(2345646.9, "TuMama", 2013, 123.0, 1243453346.0, false, "78yu9ij", 4, false, 2, 124.9, 3, 24.8, 2309, 123.8, 23454.8, 2013, 2434.8, 2021, 123.4, "9078563412");
        control.addVehicle(243434.3, "TalVez", 2011, 2535.7, 235345.7, false, "2h3hd63", 3, true, 1, false, 1234.7, 2.1, 1234, 12435.7, 1234.7, 2022, 12423.2, 1233, 12423.2, "1029384756");
        control.addVehicle(10000000.0, "Yamaha", 2010, 234.0, 0.0, false, "dfhtrdfg", 200.0, 3, 3, -1.0, 0, 0.0, -1.0, 0, 0.0,today.getYear() , 0.0, "1234567890");
        control.addVehicle(1000000.0, "ElCarrito", 2012, 2.0, 234.0, false, "P9t0#", 4, true, 1, 20.0, true, 123, 1, 20220.0, 2013, 20233.0, 22.0, 2022, 20123.0, 2020, 123.0, "0987654321");
        control.addVehicle(2345646.9, "TuMama", 2014, 123.0, 1243453346.0, false, "78yu9ij", 4, false, 2, 124.9, 3, 24.8, 2309, 123.8, 23454.8, 2013, 2434.8, 2021, 123.4, "9078563412");
        control.addVehicle(243434.3, "TalVez", 2011, 2535.7, 235345.7, false, "2h3hd63", 3, true, 1, false, 1234.7, 2.1, 1234, 12435.7, 1234.7, 2022, 12423.2, 1233, 12423.2, "1029384756");
        control.addVehicle(10000000.0, "Yamaha", 2013, 234.0, 0.0, false, "dhdhfdhf", 200.0, 3, 3, -1.0, 0, 0.0, -1.0, 0, 0.0,today.getYear() , 0.0, "1234567890");
        control.addVehicle(1000000.0, "ElCarrito", 2011, 2.0, 234.0, false, "P9t0#", 4, true, 1, 20.0, true, 123, 1, 20220.0, 2013, 20233.0, 22.0, 2022, 20123.0, 2020, 123.0, "0987654321");
        control.addVehicle(2345646.9, "TuMama", 2010, 123.0, 1243453346.0, false, "78yu9ij", 4, false, 2, 124.9, 3, 24.8, 2309, 123.8, 23454.8, 2013, 2434.8, 2021, 123.4, "9078563412");
        control.addVehicle(243434.3, "TalVez", 2014, 2535.7, 235345.7, false, "2h3hd63", 3, true, 1, false, 1234.7, 2.1, 1234, 12435.7, 1234.7, 2022, 12423.2, 1233, 12423.2, "1029384756");
    
    }
    
}
