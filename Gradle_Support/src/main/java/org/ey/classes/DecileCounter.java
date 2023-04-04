package org.ey.classes;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.util.*;

public class DecileCounter {
    private static final Logger LOG = Logger.getLogger(DecileCounter.class);
    public void Decile() {
        BasicConfigurator.configure();
        Scanner inputScanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int num;
        do {
            LOG.info("Enter a number from 1 to 1000 or 'END' to stop, press 'Enter' to submit: ");
            String str = inputScanner.nextLine();
            if (str.equals("END")) {
                break;
            }
            try {
                num = Integer.parseInt(str);
                if (num < 1 || num > 1000) {
                    LOG.info("Invalid input. Number must be between 1 and 1000.");
                    continue;
                }
                numbers.add(num);
            } catch (NumberFormatException e) {
                LOG.error("Invalid input. Please enter a number or 'END'.");
            }
        } while (true);

        Collections.sort(numbers);
        int size = numbers.size();
        int thirdDecileIndex = (int) Math.ceil(size * 0.3) - 1;
        int sixthDecileIndex = (int) Math.ceil(size * 0.6) - 1;
        int thirdDecileCount = 0;
        int sixthDecileCount = 0;

        for (int i = 0; i < size; i++) {
            int numAtIndex = numbers.get(i);
            if (i == thirdDecileIndex) {
                thirdDecileCount++;
            } else if (i == sixthDecileIndex) {
                sixthDecileCount++;
            } else if (numAtIndex > numbers.get(thirdDecileIndex) && numAtIndex <= numbers.get(sixthDecileIndex)) {
                thirdDecileCount++;
                sixthDecileCount++;
            }
        }

        System.out.printf("Total numbers entered: %d\n", size);
        System.out.printf("Numbers in the 3rd decile: %d\n", thirdDecileCount);
        System.out.printf("Numbers in the 6th decile: %d\n", sixthDecileCount);
    }

}
