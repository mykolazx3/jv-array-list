package core.basesyntax;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();

        //        System.out.println("size: " + stringArrayList.size());
        //        System.out.println("maximum size: " + stringArrayList.getMaxSize());

        stringArrayList.add("0");
        stringArrayList.add("1");
        stringArrayList.add("2");
        stringArrayList.add("3");
        stringArrayList.add("4");
        stringArrayList.add("5");
        stringArrayList.add("6");
        stringArrayList.add("7");
        stringArrayList.add("8");

        //        stringArrayList.add("9");
        //        stringArrayList.add("10");
        //        stringArrayList.add("11");

        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.print(stringArrayList.get(i) + " ");
            if (i == stringArrayList.size() - 1) {
                System.out.println();
            }
        }

        System.out.println("size: " + stringArrayList.size());
        System.out.println("maximum size: " + stringArrayList.getMaxSize());

        stringArrayList.remove(1);

        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.print(stringArrayList.get(i) + " ");
            if (i == stringArrayList.size() - 1) {
                System.out.println();
            }
        }

        System.out.println("size: " + stringArrayList.size());
        System.out.println("maximum size: " + stringArrayList.getMaxSize());

    }
}
