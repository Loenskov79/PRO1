public class Main {

    public static void main(String[] args) {
        Folder home = new Folder("Home");
        Folder users = home.addSubFolder("Users");
        Folder work = home.addSubFolder("Work");
        Folder word = work.addSubFolder("Word");
        File homework = new File ("Homework", "docx", 400);
        word.addFile(homework);

    }

}
