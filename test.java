package geekbrain;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class test {


    private Main main;
    int a10[] = {7, 8, 9, 77};
    int a20[] = {};
    int a30[] = {7, 7, 8, 9, 77};

    int a1[] = {1, 2, 55, 6, 8, 4, 7, 4, 7, 8, 9, 77};
    int a2[] = {1, 2, 55, 6, 8, 4, 7, 7, 8, 9, 4};
    int a3[] = {1, 2, 55, 6, 8, 4, 7, 7, 8, 9, 77};

    int[] e1 = {4, 4, 4, 4, 4, 4, 4};
    int[] e2 = {1, 1, 1, 1, 1, 1};
    int[] e3 = {1, 1, 8, 8, 1, 1, 3};
    int[] e4 = {1, 1, 4, 4, 1, 1};

    @BeforeEach
    public void init() {
        main = new Main();
    }

    @CsvSource({
            "a10, a1",
            "a20, a2",
            "a30, a3",
    })


    @ParameterizedTest
    public void testCutafterfour(int[] a10, int[] a1) {
        Assertions.assertEquals(a10, main.cutafterfour(a1));
    }

    @CsvSource({
            "false, e1",
            "false, e2",
            "false, e3",
            "true, e4",
    })

    @ParameterizedTest
    public void testTestdrive(boolean a, int[] e) {
        Assertions.assertEquals(a, main.testdrive(e));
    }

}
