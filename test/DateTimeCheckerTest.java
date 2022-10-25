/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HUNG
 */
public class DateTimeCheckerTest {

    private class TestCase {

        private byte day;
        private byte month;
        private short year;
        private byte expResult;
        private boolean expBooleanResult;

        public TestCase(byte month, short year, byte expResult) {
            this.month = month;
            this.year = year;
            this.expResult = expResult;
        }

        public TestCase(byte month, short year, byte day, boolean expBooleanResult) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.expBooleanResult = expBooleanResult;
        }

        public byte getExpResult() {
            return expResult;
        }

        public void setExpResult(byte expResult) {
            this.expResult = expResult;
        }

        public boolean isExpBooleanResult() {
            return expBooleanResult;
        }

        public void setExpBooleanResult(boolean expBooleanResult) {
            this.expBooleanResult = expBooleanResult;
        }

        public TestCase() {
        }

        public byte getDay() {
            return day;
        }

        public void setDay(byte day) {
            this.day = day;
        }

        public byte getMonth() {
            return month;
        }

        public void setMonth(byte month) {
            this.month = month;
        }

        public short getYear() {
            return year;
        }

        public void setYear(short year) {
            this.year = year;
        }

    }

    /**
     * Test of checkDayInMonth method, of class DateTimeChecker.
     */
    @Test
    public void testCheckDayInMonth() {
        System.out.println("checkDayInMonth");
        ArrayList<TestCase> allcase = new ArrayList<>();
        allcase.add(new TestCase(Byte.parseByte("1"), Short.parseShort("2022"), Byte.parseByte("31")));
        allcase.add(new TestCase(Byte.parseByte("3"), Short.parseShort("2022"), Byte.parseByte("31")));
        allcase.add(new TestCase(Byte.parseByte("4"), Short.parseShort("2022"), Byte.parseByte("30")));
        allcase.add(new TestCase(Byte.parseByte("5"), Short.parseShort("2022"), Byte.parseByte("31")));
        allcase.add(new TestCase(Byte.parseByte("6"), Short.parseShort("2022"), Byte.parseByte("30")));
        allcase.add(new TestCase(Byte.parseByte("7"), Short.parseShort("2022"), Byte.parseByte("31")));
        allcase.add(new TestCase(Byte.parseByte("8"), Short.parseShort("2022"), Byte.parseByte("31")));
        allcase.add(new TestCase(Byte.parseByte("9"), Short.parseShort("2022"), Byte.parseByte("30")));
        allcase.add(new TestCase(Byte.parseByte("10"), Short.parseShort("2022"), Byte.parseByte("31")));
        allcase.add(new TestCase(Byte.parseByte("11"), Short.parseShort("2022"), Byte.parseByte("30")));
        allcase.add(new TestCase(Byte.parseByte("12"), Short.parseShort("2022"), Byte.parseByte("31")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2000"), Byte.parseByte("29")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2001"), Byte.parseByte("28")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2022"), Byte.parseByte("28")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("1900"), Byte.parseByte("28")));
        for (TestCase testCase : allcase) {
            assertEquals("Test case: {" + testCase.getMonth() + ", " + testCase.getYear() + ", " + testCase.getExpResult() + "} fail.",
                     testCase.getExpResult(), DateTimeChecker.checkDayInMonth(testCase.getMonth(), testCase.getYear()));
        }
    }

    /**
     * Test of isValidDate method, of class DateTimeChecker.
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        ArrayList<TestCase> allcase = new ArrayList<>();
        allcase.add(new TestCase(Byte.parseByte("1"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("3"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("4"), Short.parseShort("2022"), Byte.parseByte("30"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("4"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("false")));
        allcase.add(new TestCase(Byte.parseByte("5"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("6"), Short.parseShort("2022"), Byte.parseByte("30"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("6"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("false")));
        allcase.add(new TestCase(Byte.parseByte("7"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("8"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("9"), Short.parseShort("2022"), Byte.parseByte("30"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("9"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("false")));
        allcase.add(new TestCase(Byte.parseByte("10"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("11"), Short.parseShort("2022"), Byte.parseByte("30"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("11"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("false")));
        allcase.add(new TestCase(Byte.parseByte("12"), Short.parseShort("2022"), Byte.parseByte("31"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2000"), Byte.parseByte("30"), Boolean.parseBoolean("false")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2000"), Byte.parseByte("31"), Boolean.parseBoolean("false")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2000"), Byte.parseByte("29"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2001"), Byte.parseByte("29"), Boolean.parseBoolean("false")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2001"), Byte.parseByte("28"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2022"), Byte.parseByte("29"), Boolean.parseBoolean("false")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("2022"), Byte.parseByte("28"), Boolean.parseBoolean("true")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("1900"), Byte.parseByte("29"), Boolean.parseBoolean("false")));
        allcase.add(new TestCase(Byte.parseByte("2"), Short.parseShort("1900"), Byte.parseByte("28"), Boolean.parseBoolean("true")));
        for (TestCase testCase : allcase) {
            assertEquals("Test IsValidDate case: {" + testCase.getMonth() + ", " + testCase.getYear() + ", " + testCase.getDay() + ", " + testCase.isExpBooleanResult() + "} fail.",
                   testCase.isExpBooleanResult(), 
                   DateTimeChecker.isValidDate(testCase.getDay(), testCase.getMonth(), testCase.getYear()));
        }

    }

}
