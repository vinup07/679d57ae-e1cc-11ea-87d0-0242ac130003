package com.telstra.b2b.dig.Tester;

import com.telstra.b2b.dig.Tester.reader.ExcelReader;
import groovy.util.logging.Log;
import groovy.util.logging.Log4j2;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import javafx.util.Pair;
import org.apache.commons.lang3.concurrent.ConcurrentException;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiFunction;

@Log4j2
public class ComplexQuestions {


    //Question 1 what is the output of the main method?

    public static void main(String... doYourBest) {
        StringBuilder warriorProfession = new StringBuilder("Dragon ");
        String warriorWeapon = "Sword ";
        changeWarriorClass(warriorProfession, warriorWeapon);

        System.out.println("Warrior=" + warriorProfession + " Weapon=" + warriorWeapon);

    }

    static void changeWarriorClass(StringBuilder warriorProfession, String weapon) {
        warriorProfession.append("Knight");
        weapon = "Dragon " + weapon;

        weapon = null;
        warriorProfession = null;
    }

    //Question 2: Implement your own LinkedList. do not use Standard Java Implementation.


    //Question 3: Create a method that checks if a String passed to it is a valid integer.


    //Question 4: Complete 1 of Question 4a and 4b
    //Question 4a: is focused on Rest APIs and is found in the class APIConnection.

    //Question 4b: Inspect the following code and describe what it does.

    private ThreadFactory threadFactory;
    private ExecutorService executorService;

    public void ValidateNumberMatches() {
        if (threadFactory == null) {
            threadFactory = new ThreadFactoryBuilder().setNameFormat("act-comp-%d").build();
            executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), threadFactory);
        }
        HashMap<String, BigInteger> validationMap = new ExcelReader().readExcel();
        List<Future> futureList = new ArrayList<>();
        validationMap.forEach((k, v) -> {
            futureList.add(executorService.submit(new ComplexQuestions.RunnableActionDouble<>(new ComplexQuestions().checkIfStringMatchesInt, k, v)));
        });
        int failCount = 0;
        for (Future future : futureList) {
            try {

                if (!(boolean) future.get()) {
                    failCount++;
                }
            } catch (ExecutionException e) {

            } catch (InterruptedException e) {

            }
        }
        System.out.println(failCount + " numbers failed Validation");


    }

    public BiFunction<String, BigInteger, Boolean> checkIfStringMatchesInt = (numString, number) -> {
        if (number.toString().equals(numString)) {
            return true;
        }
        return false;
    };

    public static class RunnableActionDouble<T, U, F extends BiFunction<T, U, R>, R> implements Callable<R> {

        private T inputA;
        private U inputB;
        private F action;

        public RunnableActionDouble(F action, T inputA, U inputB) {
            this.inputA = inputA;
            this.inputB = inputB;
            this.action = action;
        }

        @Override
        public R call() throws Exception {
            return this.action.apply(inputA, inputB);
        }


    }
}
