public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 1 || args.length > 3) throw new Exception("Enter arguments in this order:" +
                "1) con or win" +
                "2) input file name" +
                "3) output file name");//можно не вводить 2 и 3 пункт или только 3 пункт
        if (args[0].equals("con")) {
            consoleStart(args);
        } else {
            if (args[0].equals("win")) {
                winStart(args);
            } else {
                throw new Exception("First argument is wrong");
            }
        }
    }

    /**
     * если передали аргумент "win"
     */
    static void winStart(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FrameMain(args).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * если передали аргумент "con"
     */
    static void consoleStart(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<>();
        Arguments arguments = new Arguments(args);
        String[] arrOfLines = arguments.readArrOfLinesFromConsoleOrFile();

        convertArrOfLinesToLinkedList(arrOfLines, list);

        System.out.println("------------");
        System.out.println("Words from text in linked list: ");
        printLinkedList(list);
        System.out.println("\n" + "------------");

        LinkedList<String> modifiedList = Task.LinkedListOfWordsOfMaxLength(list);

        System.out.println("New linked list: ");
        printLinkedList(modifiedList);
        System.out.println("\n" + "------------");

        arguments.writeLinkedListToFile(modifiedList);
    }

    /**
     * Преобразует массив линий в связанный список
     */
    static void convertArrOfLinesToLinkedList(String[] lines, LinkedList<String> listOfWords) {

        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split("\\s+|[.!?,;:']\\s*");
            for (String word : words) {
                listOfWords.addLast(word);
            }
        }
    }

    static void printLinkedList(LinkedList<String> listOfWords) {
        int lastWord = 1;

        for (Object v : listOfWords) {
            if (listOfWords.size==lastWord) System.out.print(v + ".");
            else System.out.print(v + ", ");

            lastWord++;
        }
    }
}