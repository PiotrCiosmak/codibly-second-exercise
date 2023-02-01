package com.ciosmak.balancedwordscounter;

import java.util.HashMap;
import java.util.Map;

public class BalancedWordsCounter
{
    private Integer numberOfBalancedWords;

    public BalancedWordsCounter()
    {
        this.numberOfBalancedWords = 0;
    }

    public Integer count(String input)
    {
        try
        {
            assertIsNotNull(input);
            assertNotContainAnyCharacterOtherThenLetters(input);
            checkAllWords(input);
            return this.numberOfBalancedWords;
        }
        catch (RuntimeException e)
        {
            throw e;
        }
    }

    private void assertIsNotNull(String word)
    {
        if (word == null)
        {
            throw new RuntimeException("Word can't be null");
        }
    }

    private void assertNotContainAnyCharacterOtherThenLetters(String word)
    {
        if (!word.matches("^[a-zA-Z]*$"))
        {
            throw new RuntimeException("Word can't contain any character other then letters");
        }
    }

    private void checkAllWords(String word)
    {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; ++i)
        {
            for (int j = i + 1; j <= wordLength; ++j)
            {
                String subword = word.substring(i, j);
                increaseNumberOfBalanceWordsIfWordIsBalanced(subword);
            }
        }
    }

    private void increaseNumberOfBalanceWordsIfWordIsBalanced(String word)
    {
        if (isWordBalanced(word))
        {
            this.numberOfBalancedWords++;
        }
    }

    private boolean isWordBalanced(String word)
    {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (var letter : word.toCharArray())
        {
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        }

        int count = Integer.MIN_VALUE;
        for (int numberOfOccurrencesOfTheLetter : letterCount.values())
        {
            if (count == Integer.MIN_VALUE)
            {
                count = numberOfOccurrencesOfTheLetter;
            }
            else if (count != numberOfOccurrencesOfTheLetter)
            {
                return false;
            }
        }
        return true;
    }
}
