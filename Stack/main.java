public class main {
    public static void main(String[] args) {

        MyStack MyStack = new CharacterStack;
        String filePath = "infix.txt";

        try(BufferedReader infixReader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = infixReader.readLine()) != null)[
                String[] Character= line.split(" ");
                CharacterStack.push(Character);
            ]
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    private static void processStack(){
        // bilmem ne 
    }
}
