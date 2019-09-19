package sk.zatko.pitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    private HappyDeveloperResult result;

    Developer vasek = new Developer() {{
        this.setName("Vasek");
        this.setMood(0);
    }};

    Developer florin = new Developer() {{
        this.setName("Florin");
        this.setMood(-1);
    }};

    Developer michal = new Developer() {{
        this.setName("Michal");
        this.setMood(2);
    }};

    Developer karol = new Developer() {{
        this.setName("Karol");
        this.setMood(-1);
    }};

    Developer jozef = new Developer() {{
        this.setName("Jozef");
        this.setMood(-2);
    }};


    @BeforeEach
    void init() {
        result = new HappyDeveloperResult();
        result.setNames(new ArrayList<String>());
    }

    @Test
    void test_1() {
        List<Developer> developers = Arrays.asList(jozef, karol);
        result.setMood(-1);
        result.setNames(Arrays.asList("Karol"));
        assertEquals(result, Utils.findTheHappiestDeveloper(developers));
    }

    @Test
    void test_2() {
        List<Developer> developers = Arrays.asList();
        assertNull(Utils.findTheHappiestDeveloper(developers));
    }

    @Test
    void test_3() {
        assertNull(Utils.findTheHappiestDeveloper(null));
    }

    @Test
    void test_4() {
        List<Developer> developers = Arrays.asList(jozef, karol);
        result.setMood(-1);
        result.setNames(Arrays.asList("Karol"));
        assertEquals(result, Utils.findTheHappiestDeveloper(developers));
    }

    @Test
    void test_5() {
        List<Developer> developers = Arrays.asList(karol, florin, jozef);
        result.setMood(-1);
        result.setNames(Arrays.asList("Karol", "Florin"));
        assertEquals(result, Utils.findTheHappiestDeveloper(developers));
    }

}
