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
  
     static void  Lister(File input) throws IOException{
        
         File lists[]=input.listFiles();
  
      
      if(input.isDirectory()){ 
      
               for(int i=0;i<lists.length;i++){

                      
                       if(lists[i].isFile()){  
                          
                           l.add(lists[i].getName());
                           size++;
                           l.add(lists[i].getAbsoluteFile());
                           //System.out.println("File name: "+lists[i].getName()+" and Path :"+lists[i].getPath());
                           size++;


                       }
                       else{
                          
                           File temp=new File(lists[i].getPath());
                           Lister(temp); 
                       }

                   }
       }
      else{
         
           l.add(lists[0].getAbsoluteFile());
      }
        
   }
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
