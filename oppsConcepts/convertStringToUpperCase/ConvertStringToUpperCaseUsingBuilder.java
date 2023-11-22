package oppsConcepts.convertStringToUpperCase;

class ConvertStringToUpperCase {

    private String text;

    public ConvertStringToUpperCase(CustomStringBuilder customStringBuilder){
        this.text=customStringBuilder.internalText;
    }

    public static class CustomStringBuilder {
        
        private String internalText;

        public CustomStringBuilder(String internalText){
            this.internalText=internalText;
        }

        public CustomStringBuilder convertToUpperCase(){
            this.internalText = this.internalText.toUpperCase();
            return this;
        }

        public CustomStringBuilder convertToLowerCase(){
            this.internalText=this.internalText.toLowerCase();
            return this;
        }

        public String build(){
            return new String(this.internalText);
        }
    }
}

public class ConvertStringToUpperCaseUsingBuilder {
    public static void main(String[] args) {
        String originalString = "dev Krishna Gupta";
        String convertedString = new ConvertStringToUpperCase.CustomStringBuilder(originalString)
                                    .convertToUpperCase()
                                    .convertToLowerCase()
                                    .build();
        System.out.println("Original String: "+originalString);
        System.out.println("Convrted String: "+convertedString);
    }
}
