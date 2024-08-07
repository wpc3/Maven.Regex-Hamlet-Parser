import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
       String actual = hamletParser.regexHamlet();


       assertTrue(actual.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String actual = hamletParser.regexHamlet();


        assertTrue(actual.contains("Tariq"));
    }

    @Test
    public void testFindHoratio() {




    }

    @Test
    public void testFindHamlet() {
    }
}