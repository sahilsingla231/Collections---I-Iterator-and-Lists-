package dynamicarray;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class FileListing {

	static int size=0; // for storing the size of ArrayList
    static List l= new ArrayList();
           
    
   public static void main(String[] args) throws IOException {
     
       /*
       Scanner scan=new Scanner(System.in);
       
       System.out.println("File Listing Application");
       System.out.println(" ");
       System.out.println("Enter the Path for the Text File which contains the source and destination path :");
       String user_input=scan.next();
       */
       
       String user_input=JOptionPane.showInputDialog("Enter the Path for the Text File which contains the source and destination path :");
           
 
       String input_line="Contains source path";
       String output_line="Contains destination path";
       FileReader fr=null;
       
       //for getting the source and destination path from given text file (whose path is supplied by user)
           try {
               fr = new FileReader(user_input); 
               BufferedReader br = new BufferedReader(fr);
               input_line = br.readLine(); //reads the first line which is Target path(for input)
               output_line = br.readLine(); // reads the second line which is Destination path (for output)

           }catch(FileNotFoundException | NullPointerException e) {JOptionPane.showMessageDialog(null,"Some Exception ocurred"+e);}
           finally{
               if(fr!=null)
                   fr.close();           
           }
           
           BufferedWriter out=null;
           
           try{

            File input = new File(input_line);
            FileWriter output = new FileWriter(output_line);
            out=new BufferedWriter(output);

            Lister(input);// call to Lister
            Writer(out);// call to Writer
        
                   String display=(size/2)+" were written successfully at "+output_line;
                   JOptionPane.showMessageDialog(null,display);

                   
            }
            catch(NullPointerException e)
            {
                System.out.print("NullPointerException Caught"+e);
            } 
     
     //end of main()  
   }
   
   // Recursive function Lister
   /*
   Lister() will take a single argument as a File handler which will be the source path where we have
   to work and list all the files's path (even those in directories and subdirectories)
   */
     static void  Lister(File input) throws IOException{
        
         File lists[]=input.listFiles();
  
      //if input points to a directory then generate all the files and folders list into an array called lists[]   
      if(input.isDirectory()){ 
          
           
       // say the array is lists
          
               //for each file/folder stored in array lists[]
               for(int i=0;i<lists.length;i++){

                       //check if it's a File or Directory
                       if(lists[i].isFile()){  // Also, a break condition for Recursion.
                           //if it's a file write it's path to an ArrayList
                           l.add(lists[i].getName());
                           size++;
                           l.add(lists[i].getAbsoluteFile());
                           //System.out.println("File name: "+lists[i].getName()+" and Path :"+lists[i].getPath());
                           size++;


                       }
                       else{
                           // if it's not a file then initialise File handler "input" with it's path  
                           //Recall the function Lister() by passing the updated File Handler
                           File temp=new File(lists[i].getPath());
                           Lister(temp); //Recursive call
                       }

                   }
       }
      else{
          //if input points to a file add it to list and terminate Lister ()
           l.add(lists[0].getAbsoluteFile());
      }
        
   }// end of function Lister()
     
   /*
   Writer() will take a single argument as a File handler which will be the destination path where we have
   to write the ArrayList 
    */   
       static void Writer(BufferedWriter out) throws IOException{
        
                   for(int i=0;i<size;i++){
                         System.out.println(l.get(i));
                       out.write(l.get(i).toString()); 
                       out.write(",");
                       if((i+1)%2==0)
                           out.write("\n");
                       
                       out.flush();
                   }
       }//end of CSV Writer function
   
	
	
}
