package dataBase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FileReaderTest {
    FileReader fileReader = new FileReader("D:\\UOFT\\course-project-the-frank-lloyd-bytes\\tcard\\FacilitiesInfo.csv");

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void reader() throws IOException {
        Assert.assertEquals("[[\uFEFFRobarts, toronto, library, 9 to 5, \"program=(any), level=(undergrad):department=(any), position=(postdoc/professor)\"], [bahen, toronto, lab, 9 to 5, \"program=(CS), level=(undergrad):department=(CS), position=(postdoc/professor)\"]]", fileReader.reader().toString());
    }
}