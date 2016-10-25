package com.google.gson;

import com.google.gson.annotations.IngoreOnParseFailure;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import junit.framework.TestCase;

import java.util.List;

/*
 * This file is part of gson-parent.
 * 
 * Created by christophesmet on 25/10/2016
 * 
 * (c) 2016 November Five BVBA
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public class AllowInvalidTypeParseTest extends TestCase {

    private Gson gson;

    private static final String VALID_JSON = "[\n" +
            "{\n" +
            "    \"id\": \"256968069936000\",\n" +
            "    \"title\": \"Cordon afl.8 \",\n" +
            "    \"duration\": \"3350\"\n" +
            "}\n" +
            "]";

    private static final String INVALID_JSON = "[\n" +
            "{\n" +
            "    \"id\": \"256968069936000\",\n" +
            "    \"title\": \"Cordon afl.8 \",\n" +
            "    \"duration\": {\n" +
            "        \"value\": 3350,\n" +
            "        \"formatted\": \"55:50\"\n" +
            "    }\n" +
            "}\n" +
            "]";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        gson = new GsonBuilder()
                .create();
    }

    public void testValidJson() {
        List<Content> parsedValue = gson.fromJson(VALID_JSON, new TypeToken<List<Content>>(){}.getType());
        assertNotNull(parsedValue);
    }

    public void testInvalidJson() {
        List<Content> parsedValue = gson.fromJson(INVALID_JSON, new TypeToken<List<Content>>(){}.getType());
        assertNotNull(parsedValue);
    }

    class Content {
        @Expose
        public String id;
        @Expose
        public String title;
        @Expose
        @IngoreOnParseFailure
        public String duration;
    }
}