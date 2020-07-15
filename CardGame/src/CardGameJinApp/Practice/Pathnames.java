package CardGameJinApp.Practice;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Pathnames {
	
	
	public static String[] getfileList(){

    
        // Creates an array in which we will store the names of files and directories
        String[] pathnames;

        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File f = new File("/Users/haleyhowell/Java_WorkspaceNew/JinCardGame/CardGame/WebContent/img");

        // Populates the array with names of files and directories
        pathnames = f.list();
        return(pathnames);
    }
    


//public static void main(String[] args){
//	Pathnames path = new Pathnames();
//	
//	String[] list = path.getfileList();
//	
//	System.out.println("in main.......");
//	
//    List<String> pathList = Arrays.asList(list);  
//    pathList.stream();
//    
//    System.out.println("This is printing the stream");
//   pathList.stream().forEach(item -> System.out.println(item));
//
//    
//
//
//
//}
}
