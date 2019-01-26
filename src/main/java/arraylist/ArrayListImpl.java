package arraylist;

public class ArrayListImpl implements ArrayList<Integer> {
    private Integer[] data = null;
    private int size;
    private int length = 0;

    private ArrayListImpl() {
    }

    /**
     * 通过构造函数创建数组来存储顺序表的数据
     * 
     * @param size
     */
    public ArrayListImpl(int size) {
        this.size = size;
        this.data = new Integer[this.size];
    }

    @Override
    public Integer[] enptyList() {
        this.data = null; // 直接将数组置换为null；第一次是下，理论上应该可以
        return this.data;
    }

    @Override
    public void add(Integer obj) {
        if(this.length<this.size){
            this.data[this.length] = obj; // 顺序表的初始长度为0；当加入一个元素是长度+1
            this.length++;
        }else{
            System.out.println("表已满");
        }
        
    }

    @Override
    public Integer[] insertData(int i,Integer obj) {
       if(this.length<this.size){
           int j = this.length;
           while(j>i){
               this.data[j] = this.data[j-1];
               j--;
           }
           this.data [i] = obj;
           this.length ++;
       }else{
           System.out.println("表已满");
       }
        
        return this.data;
    }

    @Override
    public Integer deleteData(int i) {
        Integer obj = null ;

        if(this.length != 0){
            if(0 <= i && i<this.length-1){
                obj = this.data[i];
                for ( ; i < data.length-1; i++ ) {
                    this.data[i] = this.data[i+1];
                }
                this.data[this.length-1] = null;
                this.length--;
            }else {
                System.out.println("该元素不在范围内");
            }
        } else {
            System.out.println("顺序表为空");
        }
        return obj;
    }

    @Override
    public Integer[] selectAll() {
        // TODO Auto-generated method stub
        return this.data;
    }

    @Override
    public Integer selectData(int i) {
        // TODO Auto-generated method stub
        
        return this.data[i];
    }

    @Override
    public int selectIndex(Integer obj) {
        for(int i=0;i<this.length;i++){
            if(this.data[i] == obj){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer replaceData(int i,Integer obj) {
        Integer rep ;
        if(this.length != 0){
            if(0 <= i && i<this.length-1){
                rep = this.data[i];
                this.data[i] = obj;
                return rep;
            }else {
                System.out.println("该元素不在范围内");
            }
        } else {
            System.out.println("顺序表为空");
        }
        return null;
    }

    @Override
    public int lenthList() {
        // TODO Auto-generated method stub
        return this.length;
    }

}
