package payload;

public class payloadTrello {

    public static String updateCard(String updatedcard,String desc, String idBoard, String idList) {
        return "  {\n" +
                "            \"name\": \""+updatedcard+"\",\n" +
                "                \"desc\": \"" + desc + "\",\n" +
                "                \"idBoard\":\"" + idBoard + "\",\n" +
                "                \"idList\":\"" + idList + "\"\n" +
                "        }";
    }


}
