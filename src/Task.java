public class Task {
    /**
     * Возращает лист слов с максимальной длиной
     * @return newLinkedList
     */
    public static LinkedList<String> LinkedListOfWordsOfMaxLength(LinkedList<String> words) throws Exception {
        LinkedList<String> newLinkedList = new LinkedList<>();
        int maxLength = -1;
        String word;

        for (Object i : words) {
            word = i.toString();

            if (word.length() >= maxLength) {
                if(word.length() > maxLength){
                    maxLength = word.length();
                    newLinkedList.removeAll();
                    }
                newLinkedList.addLast(word);
            }
        }
        return newLinkedList;
    }
}