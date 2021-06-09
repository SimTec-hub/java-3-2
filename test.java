package geekbrain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class test {

    @ParameterizedTest
    @MethodSource("cutafterfourParams")
    void sliceTest(int[] in, int [] out) {
        Assertions.assertArrayEquals(out, test.cutafterfour(in));
    }
    static Stream<Arguments> cutafterfourParams() {
        List<Arguments> list = new ArrayList<>();
        list.add(arguments(new int[] {1,5,4,8,2,1,4,8,6,5,77,1}, new int[] {8,6,5,77,1}));
        return list.stream();
    }

    @Test
    static int[] cutafterfour(int[] ints) {
        Assertions.assertThrows(RuntimeException.class, () -> test.cutafterfour(new int[]{1, 2, 5, 4, 5}));
        return ints;
    }


    @Test
    static boolean testdrive(int[] ints) {
        Assertions.assertTrue(test.testdrive(new int[]{1, 1, 1, 4, 4, 4, 1}));
        return false;
    }

}
