package com.aghasi.androidpl.algorithms.wordMatching;


public class LevenshteinWordDistanceCalculator {

    public static final LevenshteinWordDistanceCalculator DEFAULT = new LevenshteinWordDistanceCalculator(1, 1, 1);

    private final int _costOfSubstitution;
    private final int _costOfDeletion;
    private final int _costOfInsertion;


    public LevenshteinWordDistanceCalculator(int costOfSubstitution, int costOfDeletion, int costOfInsertion) {
        assert costOfSubstitution >= 0 : "costOfSubstitution can't be < 0";
        assert costOfDeletion >= 0 : "costOfDeletion can't be < 0";
        assert costOfInsertion >= 0 : "costOfInsertion can't be < 0";

        _costOfSubstitution = costOfSubstitution;
        _costOfDeletion = costOfDeletion;
        _costOfInsertion = costOfInsertion;
    }


    public int calculate(CharSequence source, CharSequence target) {
        int sourceLength = source.length();
        int targetLength = target.length();
        int[][] grid = new int[sourceLength + 1][targetLength + 1];
        grid[0][0] = 0;

        for (int row = 1; row <= sourceLength; ++row) {
            grid[row][0] = row;
        }
        for (int col = 1; col <= targetLength; ++col) {
            grid[0][col] = col;
        }
        for (int row = 1; row <= sourceLength; ++row) {
            for (int col = 1; col <= targetLength; ++col) {
                grid[row][col] = minCost(source, target, grid, row, col);
            }
        }
        return grid[sourceLength][targetLength];
    }

    
    private int minCost(CharSequence source, CharSequence target, int[][] grid, int row, int col) {
        return min(
                substitutionCost(source, target, grid, row, col),
                deleteCost(grid, row, col),
                insertCost(grid, row, col)
        );
    }


    private int substitutionCost(CharSequence source, CharSequence target, int[][] grid, int row, int col) {
        int cost = 0;
        if (source.charAt(row - 1) != target.charAt(col - 1)) {
            cost = _costOfSubstitution;
        }
        return grid[row - 1][col - 1] + cost;
    }


    private int deleteCost(int[][] grid, int row, int col) {
        return grid[row - 1][col] + _costOfDeletion;
    }


    private int insertCost(int[][] grid, int row, int col) {
        return grid[row][col - 1] + _costOfInsertion;
    }


    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
