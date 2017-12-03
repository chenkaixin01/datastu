package seqlist.list;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SeqListImpl<Integer> seq = new SeqListImpl<Integer>(10);

        boolean b = true;

        while(b){
            System.out.println("1:添加");
            System.out.println("2:删除");
            System.out.println("3:清空");
            System.out.println("4:插入");
            System.out.println("5:替换");
            System.out.println("6:长度");
            System.out.println("7:查询全部");
            System.out.println("8:查询");
            System.out.println("9:查询索引");

            int i = input.nextInt();
            switch (i){
                case 1:
                    seq.add(input.nextInt());
                    break;
                case 2:
                    System.out.println(seq.deleteData(input.nextInt()));
                    break;
                case 3:
                    System.out.println(seq.enptyList());
                    break;
                case 4:
                    int key = input.nextInt();
                    int value = input.nextInt();
                    Object[] seqs = seq.insertData(key,value);
                    for (int j = 0; j <seqs.length ; j++) {
                        if(seqs[j]==null){
                            break;
                        }
                        System.out.println(seqs[j]);
                    }
                    break;
                case 5:
                    System.out.println(seq.replaceData(input.nextInt(),input.nextInt()));
                    break;
                case 6:
                    System.out.println(seq.lenthList());
                    break;
                case 7:
                    seqs = seq.selectAll();
                    for (Object seql: seqs
                         ) {
                        if(seql==null){
                            break;
                        }
                        System.out.println(seql);
                    }
                    break;
                case 8:
                    Integer seql = seq.selectData(input.nextInt());
                    System.out.println(seql);
                    break;
                case 9:
                    int index = seq.selectIndex(input.nextInt());
                    System.out.println(index);
                    break;
                default:
                    b=false;
                    break;
            }
        }
    }
}
