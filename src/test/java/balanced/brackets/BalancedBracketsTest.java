package balanced.brackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedBracketsTest {

    @Test
    void emptyStringIsBalanced() {
        assertTrue(BalancedBrackets.isBalanced(""));
    }

    @Test
    void singlePairIsBalanced() {
        assertTrue(BalancedBrackets.isBalanced("()"));
        assertTrue(BalancedBrackets.isBalanced("[]"));
        assertTrue(BalancedBrackets.isBalanced("{}"));
    }

    @Test
    void nestedPairsAreBalanced() {
        assertTrue(BalancedBrackets.isBalanced("({[]})"));
        assertTrue(BalancedBrackets.isBalanced("[({})]"));
    }

    @Test
    void sequentialPairsAreBalanced() {
        assertTrue(BalancedBrackets.isBalanced("()[]{}"));
        assertTrue(BalancedBrackets.isBalanced("[](){}"));
    }

    @Test
    void mixedIncorrectOrderIsNotBalanced() {
        assertFalse(BalancedBrackets.isBalanced("(]"));
        assertFalse(BalancedBrackets.isBalanced("[)"));
        assertFalse(BalancedBrackets.isBalanced("{]"));
    }

    @Test
    void closingWithoutOpeningIsNotBalanced() {
        assertFalse(BalancedBrackets.isBalanced(")"));
        assertFalse(BalancedBrackets.isBalanced("]"));
        assertFalse(BalancedBrackets.isBalanced("}"));
        assertFalse(BalancedBrackets.isBalanced("())"));
    }

    @Test
    void oddLengthIsNotBalanced() {
        assertFalse(BalancedBrackets.isBalanced("("));
        assertFalse(BalancedBrackets.isBalanced("([)"));
    }

    @Test
    void extraOpeningIsNotBalanced() {
        assertFalse(BalancedBrackets.isBalanced("(()"));
        assertFalse(BalancedBrackets.isBalanced("[[[]"));
    }

    @Test
    void complexUnbalancedCases() {
        assertFalse(BalancedBrackets.isBalanced("({[})]"));
        assertFalse(BalancedBrackets.isBalanced("([{}]][)"));
    }

}
