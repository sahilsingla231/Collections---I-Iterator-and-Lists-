package dynamicarray;

import java.util.Vector;
public class DynamicArrayUsingVector<T> {

	 Vector<T> arr;
	    static int size=0;
	    static int factor=(int) (1.5*size);
	    
	    DynamicArrayUsingVector(){
	        arr=new Vector(size,factor);   
	    }
	    
	    void Insert(T element){
	        T value=element;
	        arr.add(value);
	        size++;
	    }
	    
	     void set(int index,T element){
	        T value=element;
	        if(index<size)
	        arr.add(index, value);
	        else
	            System.out.println("You can't set the value at given index as array size is "+size);
	        
	    }
	     
	       void printArray(){
	        
	        for(T var:arr){
	            System.out.print(" "+var);
	         }
	    
	    
	       }

	    
	    public static void main(String args[]){
	       
	        DynamicArrayUsingVector obj=new DynamicArrayUsingVector();
	        obj.Insert(1);
	        obj.Insert(2);
	        obj.Insert(3);
	        obj.Insert(4);
	        obj.set(2,5);//set 5 at index 2
	        
	        obj.printArray();
	    }
	    
	    
	
	
	
	
	
}
