/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.datasproject;


public class Photo {
    
          String path;
          LinkedList<String> allTags = new LinkedList<>();
         
        // Constructor
         public Photo(String path, LinkedList<String> tags)
         {
             this.path = path;
                
             if (! tags.empty()) //اجيب الداتا واسوي رتريف للتاقز
             {   
                tags.findFirst();
                while ( !tags.last())//all except the last 
                {
                    allTags.insert(tags.retrieve());
                    tags.findNext();
                }
                 allTags.insert(tags.retrieve());//the last one
             }
        }
         
        // Return the path (full file name) of the photo. A photo is uniquely identified by its path.
        public String getPath()
        {
                return path;
        }
        
        // Return all tags associated with the photo
        public LinkedList<String> getTags()
        {
            LinkedList<String> tagsNew = new LinkedList<String>();
            
            if (! allTags.empty())
            {
                allTags.findFirst();
                while ( ! allTags.last())
                {
                    tagsNew.insert(allTags.retrieve());
                    allTags.findNext();
                }
                tagsNew.insert(allTags.retrieve());
            }
            return tagsNew;
        }

   public void display() {
    System.out.print("Photo{" + "path=" + path + ", allTags=");
    
    allTags.findFirst();
    while (!allTags.last()) {
        System.out.print(allTags.retrieve().toString() + "; ");
        allTags.findNext();
    }
    
    System.out.println(allTags.retrieve().toString() + "}");
}

}
