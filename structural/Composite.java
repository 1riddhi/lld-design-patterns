//Composite pattern composes objects into tree structures to represent part-whole hierarchies.

//Composite Pattern allows you to treat individual objects and groups of objects in the same way.

//Example:
//File System
//Folder contains files and other folders
//File is a leaf node
//Folder is a composite node

import java.util.ArrayList;
import java.util.List;

// =================================
// 1. Component Interface
// =================================
interface FileSystemComponent {
    void showDetails(String indent);
}

// =================================
// 2. Leaf Class (File)
// =================================
class File implements FileSystemComponent {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "File: " + name);
    }
}

// =================================
// 3. Composite Class (Folder)
// =================================
class Folder implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails(indent + "   ");
        }
    }
}

// =================================
// 4. Client
// =================================
public class Composite{

    public static void main(String[] args) {

        // Files
        File file1 = new File("Resume.pdf");
        File file2 = new File("Photo.png");
        File file3 = new File("Notes.txt");
        File file4 = new File("Project.docx");

        // Sub Folder
        Folder documents = new Folder("Documents");
        documents.add(file1);
        documents.add(file3);

        // Another Sub Folder
        Folder images = new Folder("Images");
        images.add(file2);

        // Root Folder
        Folder root = new Folder("Root");
        root.add(documents);
        root.add(images);
        root.add(file4);

        // Display whole structure
        root.showDetails("");
    }
}
