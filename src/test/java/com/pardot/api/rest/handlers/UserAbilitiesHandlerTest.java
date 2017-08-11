package com.pardot.api.rest.handlers;

import com.pardot.api.rest.responses.UserAbilitiesResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 *
 */
public class UserAbilitiesHandlerTest extends BaseResponseHandlerTest {
    private static final Logger logger = LoggerFactory.getLogger(UserAbilitiesHandler.class);

    @Test
    public void test() throws IOException {
        final String input = readFile("userAbilities.xml");
        final UserAbilitiesResponse.Result result = new UserAbilitiesHandler().parseResponse(input);
        logger.info("result: {}", result);

        assertEquals("Should have 189 results", 189, (int) result.getTotalResults());
        assertEquals("Check first entry", "marketing:emails:emails:transactionalsend", result.getCredentials().get(0));
        assertEquals("Check last entry", "marketing:engagementstudio:engagementprogram:delete", result.getCredentials().get(188));


    }
}