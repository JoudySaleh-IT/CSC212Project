/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datasproject;

/**
 *
 * @author rubas
 */
public class InvIndexPhotoManager {
     BST<LinkedList<Photo>> IndexPhot;
        
        // Constructor
        public InvIndexPhotoManager()
        {
            IndexPhot = new BST<LinkedList<Photo>>();
        }
        
        // Add a photo
        public void addPhoto(Photo p)
        {
            LinkedList<String> tags = p.getTags();
            if (! tags.empty())
            {
                tags.findFirst();
                while (!tags.last())
                {
                    if ( IndexPhot.findkey(tags.retrieve()) == true )
                    {
                        LinkedList<Photo> inverted_photo = IndexPhot.retrieve();
                        inverted_photo.insert(p);
                        IndexPhot.update(tags.retrieve(), inverted_photo);
                    }
                    else
                    {
                        LinkedList<Photo> inverted_photo = new LinkedList<Photo>();
                        inverted_photo.insert(p);
                        IndexPhot.insert(tags.retrieve(), inverted_photo);
                    }
                    tags.findNext();
                }
                if ( IndexPhot.findkey(tags.retrieve()) == true )// same code for the last node
                   
                {
                    LinkedList<Photo> inverted_photo = IndexPhot.retrieve();
                    inverted_photo.insert(p);
                    IndexPhot.update(tags.retrieve(), inverted_photo);
                }
                else
                {
                    LinkedList<Photo> inverted_photo = new LinkedList<Photo>();
                    inverted_photo.insert(p);
                    IndexPhot.insert(tags.retrieve(), inverted_photo);
                }
            }
        }
        
        // Delete a photo
        public void deletePhoto(String path)
        {
            String The_tags = IndexPhot.inOrder();
            String[] tags = The_tags.split(" AND ");
            
            for ( int i = 0; i < tags.length ; i++)
            {
                IndexPhot.findkey(tags[i]);
               LinkedList<Photo> photos_inverted = IndexPhot.retrieve();
               photos_inverted.findFirst();
               while ( ! photos_inverted.last())
               {
                   if ( photos_inverted.retrieve().getPath().compareToIgnoreCase(path) == 0)
                   {
                       photos_inverted.remove();
                       break;
                   }
                   else
                      photos_inverted.findNext();
                   
               }   
               if (photos_inverted.retrieve().getPath().compareToIgnoreCase(path) == 0)// check hf it has the same name 
                    photos_inverted.remove();
               
               if ( photos_inverted.getSize() == 0)
                   IndexPhot.removeKey(tags[i]);
               else
                   IndexPhot.update(tags[i], photos_inverted);
            }
        }
        
        // Return the inverted index of all managed photos
        public BST<LinkedList<Photo>> getPhotos()
        {
            return IndexPhot;
        }
    
}
