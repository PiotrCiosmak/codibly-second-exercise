package balancedwordscounter;

import com.ciosmak.balancedwordscounter.BalancedWordsCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedWordsCounterTest
{
    private BalancedWordsCounter balancedWordsCounter;

    @BeforeEach
    public void initialize()
    {
        balancedWordsCounter = new BalancedWordsCounter();
    }

    @Test
    @DisplayName("Should return twenty-eighth for input word: \"aabbabcccba\"")
    public void shouldReturnTwentyEighthForThisInputWord()
    {
        Integer numberOfPossibleBalancedWords = balancedWordsCounter.count("aabbabcccba");
        assertEquals(28, numberOfPossibleBalancedWords);
    }

    @Test
    @DisplayName("Should return zero when input word is empty")
    public void shouldReturnZeroWhenInputWordIsEmpty()
    {
        Integer numberOfPossibleBalancedWords = balancedWordsCounter.count("");
        assertEquals(0, numberOfPossibleBalancedWords);
    }

    @Test
    @DisplayName("Should throw exception when input contains other characters then just letters")
    public void shouldThrowExceptionWhenInputContainsOtherCharactersThenJustLetters()
    {
        assertThrows(RuntimeException.class, () -> balancedWordsCounter.count("abababa1"));
    }

    @Test
    @DisplayName("Should throw exception when input contains null")
    public void shouldThrowExceptionWhenInputContainsNull()
    {
        assertThrows(RuntimeException.class, () -> balancedWordsCounter.count(null));
    }
}