public class Example {
    public static void main(String[] args) {
        String day="W";
        String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if(day.isEmpty())
                    yield "Please insert a valid day.";
                else
                    yield "Looks like a Sunday.";
            }
 
        };
        System.out.println("Result of Switch Case---"+result);
        String text = """
                Did you know \
                Java 14 \
                has the most features among\
                all non-LTS versions so far\
                """;
 
String text2 = """
                line1
                line2 \s
                line3
                """;
 
 
String text3 = "line1\nline2 \nline3\n";
System.out.println(text+text3+text2);
        //null pointer error has been modified
        Integer intObj=null;
        System.out.println(intObj.intValue());
    
    }
}