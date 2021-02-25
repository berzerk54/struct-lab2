package pack;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        System.out.println("Введите число элементов: ");

        Scanner scanner = new Scanner(System.in);


        int length = Integer.parseInt(scanner.nextLine());


        int[] inputUnsorted = randomUnsortedInputOfSize(length);


        int[] inputSorted = Arrays.copyOf(inputUnsorted, inputUnsorted.length);
        Arrays.sort(inputSorted);
        Tree isdp = Tree.ISDP(inputSorted);
        System.out.printf("ISDP статистика: ");
        describeTree(isdp);

        System.out.printf("AVL статистика: ");

        Tree avl = Tree.AVL(inputUnsorted);
        describeTree(avl);


    }


    private static int[] randomUnsortedInputOfSize(int treeSize) {
        Random random = new Random(System.currentTimeMillis());

        HashMap uniqueRandomIntsMap = new HashMap<Integer, Integer>();
        while (uniqueRandomIntsMap.size() < treeSize) {
            int nextVal = random.nextInt() % (treeSize * 10);
            uniqueRandomIntsMap.put(nextVal, nextVal);
        }

        int i = 0;
        int[] unsortedRandomUniqueInts = new int[treeSize];
        for (Iterator iterator = uniqueRandomIntsMap.keySet().iterator(); iterator.hasNext();) {
            unsortedRandomUniqueInts[i++] = (int) iterator.next();
        }

        return unsortedRandomUniqueInts;
    }

    private static void describeTree(Tree tree) {
        printMessage("дерево целиком: ", tree);
        printMessage("размер дерева: ", tree.getSize());
        printMessage("высота дерева: ", tree.getHeight());
        printMessage("средняя высота дерева: ", tree.getAverageHeigth());
        printMessage("Дерево поисковое?: ", tree.isValidBinarySearch());
    }

    private static void printMessage(String message, Object object) {
        System.out.println(message);
        System.out.println();
        System.out.println(object);
        System.out.println();
    }



}