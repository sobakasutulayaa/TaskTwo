import ru.vsu.cs.util.ArrayUtils;

import java.io.File;
import java.io.FileWriter;

public class Arguments {
    public String firstArg, secondArg=null, thirdArg=null;
    private final String[] args;

    public Arguments(String[] args) {
        this.firstArg = args[0];
        if(args.length>1)this.secondArg = args[1];
        if(args.length>2)this.thirdArg = args[2];
        this.args = args;

    }

    /**
     * Записывает связанный список в файл
     */
    public void writeLinkedListToFile(LinkedList list) throws Exception {
        if (args.length == 3) {
            String thirdArgument = args[2];

            FileWriter output = new FileWriter(thirdArgument+".txt");
            String data = "";
            for (int i = 0; i < list.size; i++) {
                data += list.get(i) + " ";
            }
            output.write(data);
            output.flush();
            output.close();
        }
    }

    /**
     * Возращает массив строк считанных с консоли или с файла
     * @return String[] arr
     */
    public String[] readArrOfLinesFromConsoleOrFile() throws Exception {
        String[] arr;
        if (args.length > 1) {

            String secondArgument = args[1];
            File inputFile = new File(secondArgument + ".txt");

            if (inputFile.exists()) {
                arr = ArrayUtils.readLinesFromFile(secondArgument + ".txt");
            } else throw new Exception("File does not exist");

        } else {
            System.out.println("Enter values of linked list: ");
            arr = ArrayUtils.readLinesFromConsole();
        }
        if (arr.length == 0) throw new Exception("Array is empty.");
        return arr;
    }
}
