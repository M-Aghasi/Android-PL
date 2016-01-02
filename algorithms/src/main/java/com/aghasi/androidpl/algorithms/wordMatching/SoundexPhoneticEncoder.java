package com.aghasi.androidpl.algorithms.wordMatching;


public class SoundexPhoneticEncoder implements PhoneticEncoder {

    public static final SoundexPhoneticEncoder INSTANCE = new SoundexPhoneticEncoder();
    private static final char[] LETTER_ENCODING_MAP = "01230120022455012623010202".toCharArray();


    private SoundexPhoneticEncoder() {
    }


    public String encode(CharSequence string) {
        assert string.length() > 0 : "string can't be empty";
        char[] result = {'0', '0', '0', '0'};
        result[0] = Character.toUpperCase(string.charAt(0));
        int stringIndex = 1;
        int resultIndex = 1;

        while (stringIndex < string.length() && resultIndex < result.length) {
            char c = mapCharToEncoding(string.charAt(stringIndex));
            if (c != '0' && c != result[resultIndex - 1]) {
                result[resultIndex] = c;
                ++resultIndex;
            }
            ++stringIndex;
        }
        return String.valueOf(result);
    }

    private static char mapCharToEncoding(char c) {
        int index = Character.toUpperCase(c) - 'A';
        return isValidMapIndex(index) ? LETTER_ENCODING_MAP[index] : '0';
    }

    private static boolean isValidMapIndex(int index) {
        return index >= 0 && index < LETTER_ENCODING_MAP.length;
    }
}
