public class Main {
    public static void main(String[] args) {
        String first = "Hello";
        String second = "Mary";
        String txt = "Hello Everybody";
        int index = 2;

        Array array = new Array(3);
        array.insert(10);
        array.insert(11);
        array.insert(34);
        System.out.println("Initial array: ");
        array.print();
        System.out.println("Resultant array: ");
        array.delete(index);
        array.print();

        System.out.println(first.concat(second));
        System.out.println(txt.indexOf("e"));
    }
}