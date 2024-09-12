import java.util.stream.IntStream;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
       items = new int[length];
    }

    public void insert(int item) {
        if(count == items.length){
            int[] newItems = new int[items.length * 2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }
    public void delete(int index) {

        if (index < 0 || index >= this.items.length) {
            System.out.println("Invalid index");
        }

        items = IntStream.range(0, this.items.length)
                .filter(i->i != index)
                .map(i -> this.items[i])
                .toArray();
        count--;
    }

    public void print(){
        for(int i=0; i<count; i++){
            System.out.println(items[i]);
        }
    }
}
