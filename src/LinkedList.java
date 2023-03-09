import org.w3c.dom.Node;

import java.util.Comparator;

/**
 * Однонаправленный связанный список
 * @param <T>
 */
public class LinkedList<T> {

    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    /**
     * Узел
     */
    class Node{
        private T value;
        private Node next;
        private int size = 0;
        private Node prevNode;

        private T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * Разворачивает односвязный список
     * @return
     */
    public Node revLinkedList() {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.getNext();
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return prev;
    }

    /**
     * Возвращаем длину списка
     * @return
     */
    public int size() {
        int count = 0;
        if (head == null) {
            return count;
        }
        Node node = head;
        count++;
        while (node.getNext() != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    /**
     * Возвращает элемент списка по индексу
     * @param num
     * @return
     */
    public T getElemById(int num) {
        Node currNode = head;
        int count = 0;
        if (num == count) {
            return currNode.getValue();
        }
        while (currNode.getNext() != null) {
            currNode = currNode.getNext();
            count++;
            if (num == count) {
                return currNode.getValue();
            }
        }
        return null;
    }

    /**
     * Распечатывает список
     */
    public void print() {
        Node node = head;
        if (node != null) {
            System.out.println(node.getValue());
        }

        while (node.getNext() != null) {
            node = node.getNext();
            System.out.println(node.getValue());
        }
    }

    /**
     * Добавить новый элемент в начало связанного списка
     * @param value значение
     */
    public void addFirst(T value) {
        Node node = new Node(value);
        if (head != null)
            node.setNext(head);
        head = node;
    }

    /**
     * Удалить первый элемент связанного списка
     */
    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }

    /**
     * Поиск элемента в связанном списке
     * @param value значение
     * @return результат поиска
     */
    public boolean Contains(T value) {
        Node node = head;
        while (node != null) {
            if (node.getValue().equals(value))
                return true;
            node = node.getNext();
        }
        return false;
    }

    /**
     * Додавить элемент в конец связанного списка
     * @param value значение
     */
    public void addLast(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        }
        else {
            Node last = head;
            while (last.getNext() != null)
                last = last.getNext();
            last.setNext(node);
        }
    }

    public void directSort(Comparator<T> comparator) {
        Node node = head;
        while (node != null) {
            Node minValueNode = node;
            Node node2 = node.getNext();
            while (node2 != null) {
                if (comparator.compare(
                        minValueNode.getValue(), node2.getValue()) > 0) {
                    minValueNode = node2;
                }
                node2 = node2.getNext();
            }

            if (node != minValueNode) {
                T buf = node.getValue();
                node.setValue(minValueNode.getValue());
                minValueNode.setValue(buf);
            }
            node = node.getNext();
        }

    }

    /**
     * Удалить последний элемент из связанного списка
     */
    public void removeLast() {
        if (head == null)
            return;
        Node node = head;
        while (node.getNext() != null) {
            if (node.getNext().getNext() == null) {
                node.setNext(null);
                return;
            }
            node = node.getNext();
        }
        head = null;
    }
}
