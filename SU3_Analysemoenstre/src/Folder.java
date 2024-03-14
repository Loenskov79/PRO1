import java.util.ArrayList;

public class Folder extends FileSystemElement{

    private ArrayList<FileSystemElement> fileSystemElements = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public void addFile (File file) {
        fileSystemElements.add(file);
    }

    public Folder addSubFolder (String name) {
        Folder newFolder = new Folder(name);
        fileSystemElements.add(newFolder);
        return newFolder;
    }




}
