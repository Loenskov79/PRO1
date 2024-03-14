public class File extends FileSystemElement{

    private String extensionName;
    private double size;

    public File(String name, String extensionName, double size) {
        super(name);
        this.extensionName = extensionName;
        this.size = size;
    }
}
