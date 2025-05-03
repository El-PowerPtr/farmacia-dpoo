package aplicacion.logica.file_managers;

import java.io.Serializable;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.function.Function;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileSynchronizer<T extends Serializable> {
   private T target; 
   private Path targetPath;
   private String targetName;

   public void saveIn(File directory){
      Path tmpFile = new File(directory.getPath() + targetName).toPath();

      try(FileOutputStream fos = new FileOutputStream(tmpFile);
          ObjectOutputStream oos = new ObjectOutputStream(foos)){
            oos.writeObject(target);        
         }catch(IOException e){
            throw new IOException("ha ocurrido un error a la hora de guardar el archivo: " + targetName);
      }
   }

   public void save(){
      try {
         Path tmpFile = new File(directory.getPath() + targetName + ".tmp").toPath();
      
         try(FileOutputStream fos = new FileOutputStream(tmpFile);
            ObjectOutputStream oos = new ObjectOutputStream(foos)){
               oos.writeObject(target);        
               targetPath.toFile().delete();
               tmpFile.toFile().renameTo(targetPath);
            }catch(IOException e){
               throw new IOException("ha ocurrido un error a la hora de guardar el archivo: " + targetName);
         }
      } catch (InvalidPathException e) {
         throw new InvalidPathException("Error al crear el archivo temporal");
      }
   }
}