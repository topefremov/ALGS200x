import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PlacingParenthesesTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "1+5", 6 },
                { "5-8+7*4-8+9", 200 },
                { "7+6+3-2-7-4*2+4+2-9*6*8", 9168 }
        });
    }

    private String exp;

    private int expected;

    public PlacingParenthesesTest(String exp, int expected) {
        this.exp = exp;
        this.expected = expected;
    }

    @Test
    public void getMaximValueTest() {
        assertEquals(expected, PlacingParentheses.getMaximValue(exp));
    }
}