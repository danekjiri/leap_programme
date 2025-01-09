package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MullItOver {
    public static class WordState {
        public enum MulStates {
            NONE, M, U, L, OPEN_BRACKET,FIRST_NUMBER, COMMA, SECOND_NUMBER, CLOSE_BRACKET
        }

        public MulStates mulState = MulStates.NONE;
        public long firstNumber;
        public long secondNumber;
    }

    public static class WordStateEnhanced extends WordState {
        public enum DoStates {
            NONE, D, O, OPEN_BRACKET, CLOSE_BRACKET
        }

        public enum DontStates {
            NONE, D, O, N, APOSTROPHE, T, OPEN_BRACKET, CLOSE_BRACKET
        }

        public DoStates doState = DoStates.NONE;
        public DontStates dontState = DontStates.NONE;
        public boolean isMulEnabled = true;
    }

    private void doStateMachine(int currentChar, WordStateEnhanced wordStateEnhanced) {
        switch (currentChar) {
            case 'd' -> {
                wordStateEnhanced.doState = WordStateEnhanced.DoStates.D;
            }
            case 'o' -> {
                if (wordStateEnhanced.doState == WordStateEnhanced.DoStates.D) {
                    wordStateEnhanced.doState = WordStateEnhanced.DoStates.O;
                } else {
                    wordStateEnhanced.doState = WordStateEnhanced.DoStates.NONE;
                }
            }
            case '(' -> {
                if (wordStateEnhanced.doState == WordStateEnhanced.DoStates.O) {
                    wordStateEnhanced.doState = WordStateEnhanced.DoStates.OPEN_BRACKET;
                } else {
                    wordStateEnhanced.doState = WordStateEnhanced.DoStates.NONE;
                }
            }
            case ')' -> {
                if (wordStateEnhanced.doState == WordStateEnhanced.DoStates.OPEN_BRACKET) {
                    wordStateEnhanced.doState = WordStateEnhanced.DoStates.CLOSE_BRACKET;
                    wordStateEnhanced.isMulEnabled = true;
                } else {
                    wordStateEnhanced.doState = WordStateEnhanced.DoStates.NONE;
                }
            }
        }
    }

    private void dontStateMachine(int currentChar, WordStateEnhanced wordStateEnhanced) {
        switch (currentChar) {
            case 'd' -> {
                wordStateEnhanced.dontState = WordStateEnhanced.DontStates.D;
            }
            case 'o' -> {
                if (wordStateEnhanced.dontState == WordStateEnhanced.DontStates.D) {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.O;
                } else {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.NONE;
                }
            }
            case 'n' -> {
                if (wordStateEnhanced.dontState == WordStateEnhanced.DontStates.O) {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.N;
                } else {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.NONE;
                }
            }
            case '\'' -> {
                if (wordStateEnhanced.dontState == WordStateEnhanced.DontStates.N) {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.APOSTROPHE;
                } else {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.NONE;
                }
            }
            case 't' -> {
                if (wordStateEnhanced.dontState == WordStateEnhanced.DontStates.APOSTROPHE) {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.T;
                } else {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.NONE;
                }
            }
            case '(' -> {
                if (wordStateEnhanced.dontState == WordStateEnhanced.DontStates.T) {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.OPEN_BRACKET;
                } else {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.NONE;
                }
            }
            case ')' -> {
                if (wordStateEnhanced.dontState == WordStateEnhanced.DontStates.OPEN_BRACKET) {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.CLOSE_BRACKET;
                    wordStateEnhanced.isMulEnabled = false;
                } else {
                    wordStateEnhanced.dontState = WordStateEnhanced.DontStates.NONE;
                }
            }
        }
    }

    private void mulStateMachine(int currentChar, WordState wordState) {
        switch (currentChar) {
            case 'm' -> {
                wordState.mulState = WordState.MulStates.M;
                wordState.firstNumber = 0;
                wordState.secondNumber = 0;
            }
            case 'u' -> {
                if (wordState.mulState == WordState.MulStates.M) {
                    wordState.mulState = WordState.MulStates.U;
                } else {
                    wordState.mulState = WordState.MulStates.NONE;
                }
            }
            case 'l' -> {
                if (wordState.mulState == WordState.MulStates.U) {
                    wordState.mulState = WordState.MulStates.L;
                } else {
                    wordState.mulState = WordState.MulStates.NONE;
                }
            }
            case '(' -> {
                if (wordState.mulState == WordState.MulStates.L) {
                    wordState.mulState = WordState.MulStates.OPEN_BRACKET;
                } else {
                    wordState.mulState = WordState.MulStates.NONE;
                }
            }
            case '0' , '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                if (wordState.mulState == WordState.MulStates.OPEN_BRACKET ||
                        wordState.mulState == WordState.MulStates.FIRST_NUMBER) {
                    wordState.mulState = WordState.MulStates.FIRST_NUMBER;
                    wordState.firstNumber = (wordState.firstNumber * 10) + (currentChar - '0');
                } else if (wordState.mulState == WordState.MulStates.COMMA ||
                        wordState.mulState == WordState.MulStates.SECOND_NUMBER) {
                    wordState.mulState = WordState.MulStates.SECOND_NUMBER;
                    wordState.secondNumber = (wordState.secondNumber * 10) + (currentChar - '0');
                } else {
                    wordState.mulState = WordState.MulStates.NONE;
                }
            }
            case ',' -> {
                if (wordState.mulState == WordState.MulStates.FIRST_NUMBER) {
                    wordState.mulState = WordState.MulStates.COMMA;
                } else {
                    wordState.mulState = WordState.MulStates.NONE;
                }
            }
            case ')' -> {
                if (wordState.mulState == WordState.MulStates.SECOND_NUMBER) {
                    wordState.mulState = WordState.MulStates.CLOSE_BRACKET;
                } else {
                    wordState.mulState = WordState.MulStates.NONE;
                }
            }
            default -> wordState.mulState = WordState.MulStates.NONE;
        }
    }

    public long getDoDontMulStatementsSum(String fileName) {
        long sumOfMuls = 0;
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            int currentChar;
            WordStateEnhanced wordState = new WordStateEnhanced();

            while((currentChar = reader.read()) != -1) {
                mulStateMachine(currentChar, wordState);
                doStateMachine(currentChar, wordState);
                dontStateMachine(currentChar, wordState);

                if (wordState.mulState == WordState.MulStates.CLOSE_BRACKET && wordState.isMulEnabled) {
                        sumOfMuls += wordState.firstNumber * wordState.secondNumber;
                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return sumOfMuls;
    }

    public long getMulStatementsSum(String fileName) {
        long sumOfMuls = 0;
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            int currentChar;
            WordState wordState = new WordState();

            while((currentChar = reader.read()) != -1) {
                mulStateMachine(currentChar, wordState);
                if (wordState.mulState == WordState.MulStates.CLOSE_BRACKET) {
                    sumOfMuls += wordState.firstNumber * wordState.secondNumber;
                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return sumOfMuls;
    }
}