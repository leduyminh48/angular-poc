package ca.canadiantire.nine.dto;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Victor Letunovsky
 */
public class UserLoginDtoMarshallingTest {

    private ObjectMapper mapper;

    @Before
    public void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    public void testUserLoginDtoMarshalling() throws IOException {

        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, new UserLoginDto("viktor_letunovskyi@epam.com", "qwerty"));

        String json = writer.toString();

        assertTrue(json.contains("viktor_letunovskyi@epam.com"));
    }
}
