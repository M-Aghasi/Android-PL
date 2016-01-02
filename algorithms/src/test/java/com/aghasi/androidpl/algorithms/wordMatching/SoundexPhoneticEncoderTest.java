package com.aghasi.androidpl.algorithms.wordMatching;

import junit.framework.TestCase;


public class SoundexPhoneticEncoderTest extends TestCase {

    private SoundexPhoneticEncoder _encoder;

    protected void setUp() throws Exception {
        super.setUp();

        _encoder = SoundexPhoneticEncoder.INSTANCE;
    }

    public void testFirstLetterIsAlwaysUsed() {
        for (char c = 'A'; c <= 'Z'; ++c) {
            String result = _encoder.encode(c + "-");

            assertNotNull(result);
            assertEquals(4, result.length());

            assertEquals(c, result.charAt(0));
        }
    }

    public void testVowelsAreIgnored() {
        assertAllEquals('0', new char[] {'A', 'E', 'I', 'O', 'U', 'H', 'W', 'Y'});
    }

    public void testLettersRepresentedByOne() {
        assertAllEquals('1', new char[] {'B', 'F', 'P', 'V'});
    }

    public void testLettersRepresentedByTwo() {
        assertAllEquals('2', new char[] {'C', 'G', 'J', 'K', 'Q', 'S', 'X', 'Z'});
    }

    public void testLettersRepresentedByThree() {
        assertAllEquals('3', new char[] {'D', 'T'});
    }

    public void testLettersRepresentedByFour() {
        assertAllEquals('4', new char[] {'L'});
    }

    public void testLettersRepresentedByFive() {
        assertAllEquals('5', new char[] {'M', 'N'});
    }

    public void testLettersRepresentedBySix() {
        assertAllEquals('6', new char[] {'R'});
    }

    public void testDuplicateCodesAreDropped() {
        assertEquals("B100", _encoder.encode("BFPV"));
        assertEquals("C200", _encoder.encode("CGJKQSXZ"));
        assertEquals("D300", _encoder.encode("DDT"));
        assertEquals("L400", _encoder.encode("LLL"));
        assertEquals("M500", _encoder.encode("MNMN"));
        assertEquals("R600", _encoder.encode("RRR"));
    }

    public void testSomeRealStrings() {
        assertEquals("S530", _encoder.encode("Smith"));
        assertEquals("S530", _encoder.encode("Smythe"));
        assertEquals("M235", _encoder.encode("McDonald"));
        assertEquals("M235", _encoder.encode("MacDonald"));
        assertEquals("H620", _encoder.encode("Harris"));
        assertEquals("H620", _encoder.encode("Harrys"));
    }

    private void assertAllEquals(char expectedValue, char[] chars) {
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            String result = _encoder.encode("-" + c);

            assertNotNull(result);
            assertEquals(4, result.length());

            assertEquals("-" + expectedValue + "00", result);
        }
    }
}