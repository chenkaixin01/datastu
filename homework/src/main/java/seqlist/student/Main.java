package seqlist.student;

import seqlist.list.SeqList;
import seqlist.list.SeqListImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SeqList<Student> stuList= new SeqListImpl<Student>(20);
        boolean b = true;

        while(b){
            Student student ;
            int key = -1;
            Student value;

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
                    student = inp();
                    stuList.add(student);
                    break;
                case 2:
                    System.out.printf("请输入学号");
                    String sId =  input.next();
                    key = getKey(stuList, key, sId);
                    System.out.println(stuList.deleteData(key));
                    break;
                case 3:
                    System.out.println(stuList.enptyList());
                    break;
                case 4:
                    sId = input.next();
                     student = inp();
                    key = getKey(stuList, key, sId);
                    value = student;
                    Object[] seqs = stuList.insertData(key,value);
                    for (int j = 0; j <seqs.length ; j++) {
                        if(seqs[j]==null){
                            break;
                        }
                        System.out.println(seqs[j]);
                    }
                    break;
                case 5:
                    System.out.printf("请输入学号：");
                    sId = input.next();
                    student = inp();
                     key = getKey(stuList, key, sId);
                     value = student;
                    System.out.println(stuList.replaceData(key,value));
                    break;
                case 6:
                    System.out.println(stuList.lenthList());
                    break;
                case 7:
                    seqs = stuList.selectAll();
                    for (Object seql: seqs) {
                        if(seql==null){
                            break;
                        }
                        System.out.println(seql.toString());
                    }
                    break;
                case 8:
                    sId = input.next();
                    key = getKey(stuList, key, sId);
                    Student seql = stuList.selectData(key);
                    System.out.println(seql.toString());
                    break;
                case 9:
                    int index = stuList.selectIndex(inp());
                    System.out.println(index);
                    break;
                default:
                    b=false;
                    break;
            }
        }
    }

    private static int getKey(SeqList<Student> stuList, int key, String sId) {
        Object[] objs =  stuList.selectAll();

        for (Object obj:objs) {
            Student stu = (Student) obj;
            if (sId.equals(stu.getStuId())){
                key = stuList.selectIndex(stu);
                break;
            }
        }
        return key;
    }

    private static Student inp() {
        Scanner input = new Scanner(System.in);
        Student student = new Student();
        System.out.printf("请输入学号：");
        student.setStuId(input.next());
        System.out.printf("请输入姓名：");
        student.setStuName(input.next());
        System.out.printf("请输入年级：");
        student.setYear(input.next());
        System.out.printf("请输入成绩：");
        student.setStuCore(input.nextInt());
        return student;
    }
}


