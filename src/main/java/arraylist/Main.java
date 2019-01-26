package arraylist;

public class Main {

    public static void main(String[] args) {
            ArrayList arr= new ArrayListImpl(10);
            for ( int i = 0; i < 10; i++ ) {
                arr.add(i);
            }
            arr.deleteData(3);
            System.out.println(arr.lenthList());
            arr.insertData(5, 55);
            System.out.println(arr.selectIndex(5)+"\n");
            System.out.println(arr.selectData(5)+"\n");
            System.out.println(arr.replaceData(4, 33) + "\n");
            
            Integer[] in = (Integer[]) arr.selectAll();            
        for ( Integer integer : in ) {
            System.out.println(integer);
        }
    }

}
