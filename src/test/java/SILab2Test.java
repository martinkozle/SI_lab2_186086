import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void Branch() {
        SILab2 test = new SILab2();
        int result = 0;
        RuntimeException exception = null;
        result = test.function(Collections.singletonList(new Angle(300, 50, 50))).get(0);
        assertEquals(1083050L, result);
        result = test.function(Collections.singletonList(new Angle(360, 0, 0))).get(0);
        assertEquals(1296000L, result);
        try {
            result = test.function(Collections.singletonList(new Angle(360, 1, 1))).get(0);
        } catch (RuntimeException e) {
            exception = e;
        }
        assert exception != null;
        assertEquals("The angle is greater then the maximum", exception.getMessage());
        exception = null;
        try {
            result = test.function(Collections.singletonList(new Angle(390, 0, 0))).get(0);
        } catch (RuntimeException e) {
            exception = e;
        }
        assert exception != null;
        assertEquals("The angle is smaller or greater then the minimum", exception.getMessage());
        exception = null;
        try {
            result = test.function(Collections.singletonList(new Angle(350, 70, 0))).get(0);
        } catch (RuntimeException e) {
            exception = e;
        }
        assert exception != null;
        assertEquals("The minutes of the angle are not valid!", exception.getMessage());
        exception = null;
        try {
            result = test.function(Collections.singletonList(new Angle(350, 50, 70))).get(0);
        } catch (RuntimeException e) {
            exception = e;
        }
        assert exception != null;
        assertEquals("The seconds of the angle are not valid", exception.getMessage());

    }

    @Test
    void Path(){

    }

}