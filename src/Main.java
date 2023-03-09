public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(5);
        list.addLast(3);
        list.addLast(89);
        list.addLast(126);

//        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.getElemById(4));
        list.print();

        // реализовать метод разворота связного списка
        list.revLinkedList();
        System.out.println("----------");
        System.out.println(list.getElemById(4));
        list.print();
    }
}