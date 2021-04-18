import java.util.HashMap;

public class Library{
   public Library(){
    
   }
  
   public void getFinishedBooks (HashMap<String, Boolean> library){ 
      if(library.size() < 1){
         System.out.println("Bye");   
      }
      else {
         for (String book : library.keySet()) {
        	 System.out.print(book + " ... " + "Progress: ");
        	 if (library.get(book) == true) {
               System.out.print("Completed.");
               System.out.println();
            }
        	 else if(library.get(book) == false){
        		 System.out.print("Incomplete.");
        		 System.out.println();
        	 }
         }
      }
   
   }
  
   public static void main(String[] args) {
      
	   System.out.println("My Books: ");
	   
	   HashMap<String,Boolean> myBooks=new HashMap<String, Boolean>();
      
      myBooks.put("Final Fantasy XV: Dawn of the Future",true);
      myBooks.put("Kingdom Hearts 358/2 Days: The Novel",false);
      myBooks.put("Fahrenheit 451",true);
      myBooks.put("Beyonders: A World Without Heroes",false);
      
      
      Library myLibrary = new Library();
      myLibrary.getFinishedBooks(myBooks);
        
        
   }
}
