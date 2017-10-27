
public class ArrayDequeue implements DequeInterface {
  private Object[] aa;
  private int start;
  private int end;
  private int size;
  public ArrayDequeue(){
	  aa= new Object[1];
	  start=-1;
	  end=-1;
	  size=0;
	  }
  private void twice(){
      Object[] temp = new Object[2*size];
          for(int k=0; k <size; k++){ 
            temp[k] = aa[(start + k)%aa.length];
          }
       aa=temp;
       start=0;
       end=size-1;
  }
  public void insertFirst(Object o){
	  if(start==-1&&end==-1)
	  {
		  aa[++start]=o;
		  end++;
		  size++;
	  }
	  else{
		  if(aa.length==size){
		   twice();
		  }
		  start-=1;
		  if(start==-1){
				  start=aa.length-1;
		   }
		  aa[start]=o;
		  size++;
	  }

  }
  
  public void insertLast(Object o){
	  if(start==-1&&end==-1)
	  {
		  aa[++end]=o;
		  start++;
		  size++;
	  }
	  else{
		  if(aa.length==size){
		   twice();
		  }
		  end+=1;
		  if(end==aa.length){
				  end=0;
		   }
		  aa[end]=o;
		  size++;
	  }
  }
  
  public Object removeFirst()throws EmptyDequeException {
    if(size==0){
    	throw new EmptyDequeException("Empty");
    	}
    else{
    	size--;
    	Object O=aa[start];
    	if(start==aa.length-1){
    		start=0;
    	}
    	else start++;
    	
    	return O;
    }
  }
  
  public Object removeLast() throws EmptyDequeException{
	  if(size==0){
	    	throw new EmptyDequeException("Empty");
	    	}
	    else{
	    	size--;
	    	Object o=aa[end];
	    	if(end==0){
	    		end=aa.length-1;
	    	}
	    	else end--;
	    	return o;
	    }
  }
  public Object first()throws EmptyDequeException{
	  if(isEmpty()){
	    	throw new EmptyDequeException("Empty");
	  }
	    else{
	    	return aa[start];
	    }
  }
  
  public Object last() throws EmptyDequeException{
    if(isEmpty()){
    	throw new EmptyDequeException("Empty");
  }
    else{
    	return aa[end];
    }
    }
  
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size==0;
  }
  public String toString(){
    if(isEmpty()){
    	String deq="[]";
    	return deq;
    }
    else{
    	String deq="[";
    	int s=start;
    	int e=end;
    	while(s!=e){
    		deq=deq+aa[s]+",";
    		s=(s+1)%aa.length;
    		if(s==e){
    			deq=deq+aa[e];
    		}	
    	}
    	deq+="]";
    	return deq;
    }
  }
  
  
  public static void main(String[] args){
    int  N = 10;
    DequeInterface myDeque = new ArrayDequeue();
    for(int i = 0; i < N; i++) {
      myDeque.insertFirst(i);
      myDeque.insertLast(-1*i);
    }
   
    int size1 = myDeque.size();
    System.out.println("Size: " + size1);
    System.out.println(myDeque.toString());
    
    if(size1 != 2*N){
      System.err.println("Incorrect size of the queue.");
    }
    
    //Test first() operation
    try{
      int first = (int)myDeque.first();
      int size2 = myDeque.size(); //Should be same as size1
      if(size1 != size2) {
        System.err.println("Error. Size modified after first()");
      }
    }
    catch (EmptyDequeException e){
      System.out.println("Empty queue");
    }
    
    //Remove first N elements
    for(int i = 0; i < N; i++) {
      try{
        int first = (Integer)myDeque.removeFirst();
      }
      catch (EmptyDequeException e) {
        System.out.println("Cant remove from empty queue");
      }
      
    }
    
    
    int size3 = myDeque.size();
    System.out.println("Size: " + myDeque.size());
    System.out.println(myDeque.toString());
    
    if(size3 != N){
      System.err.println("Incorrect size of the queue.");
    }
    
    try{
      int last = (int)myDeque.last();
      int size4 = myDeque.size(); //Should be same as size3
      if(size3 != size4) {
        System.err.println("Error. Size modified after last()");
      }
    }
    catch (EmptyDequeException e){
      System.out.println("Empty queue");
    }
    
    //empty the queue  - test removeLast() operation as well
    while(!myDeque.isEmpty()){
        try{
          int last = (int)myDeque.removeLast();
        }
        catch (EmptyDequeException e) {
          System.out.println("Cant remove from empty queue");
        }
    }
    
    int size5 = myDeque.size();
    if(size5 != 0){
      System.err.println("Incorrect size of the queue.");
    }
    
  }
  
}