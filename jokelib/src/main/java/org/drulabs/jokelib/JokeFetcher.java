package org.drulabs.jokelib;

public class JokeFetcher {

    private static final String jokesJSON = "[\n" +
            "  {\n" +
            "    \"title\": \"Angry Birds?\",\n" +
            "    \"text\": \"If couples who are in love are called \\\"love birds\\\", then couples who always argue should be called \\\"Angry Birds\\\".\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Defuse it\",\n" +
            "    \"text\": \"Some people like to stop the microwave with one second to go; it makes them feel like bomb defusal experts.\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Newspaper\",\n" +
            "    \"text\": \"I read an actual newspaper today! For those of you who don't understand, a newspaper is like the Internet but made of paper.\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Resume…\",\n" +
            "    \"text\": \"My resume is just a list of things I hate to do.\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Better than nothing\",\n" +
            "    \"text\": \"If you can't fix your brakes make your horn louder\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"This generation\",\n" +
            "    \"text\": \"It is truly easier to forgive your enemies than figure out how to limit their access to your Facebook page.\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"My professor at his best\",\n" +
            "    \"text\": \"Prof. Sahu was at a theatre with his wife and he happened to see me there. Next day: \\\"Yesterday I saw you WITH MY WIFE at the Cinema Theatre.\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Prof. Sahu\",\n" +
            "    \"text\": \"Why are you late - say YES or NO ....(?)\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Prof. Sahu about his family\",\n" +
            "    \"text\": \"I have two sons. Both of them are boys....(?)\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Totally makes sense\",\n" +
            "    \"text\": \"Give me a red pen of any colour\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Say what?\",\n" +
            "    \"text\": \"Close the doors of the windows please .. I have winter in my nose today\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"RIP Dean\",\n" +
            "    \"text\": \"Shhh...Quiet, boys...the dean just passed away in the corridor\",\n" +
            "    \"remarks\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Sure, why not…\",\n" +
            "    \"text\": \"Cut an apple into two halves - take the bigger half\",\n" +
            "    \"remarks\": \"\"\n" +
            "  }\n" +
            "]";

    public static String getJokeList() {
        return jokesJSON;
    }

}
