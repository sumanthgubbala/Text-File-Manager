import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Main{
    String filename ;
    String extenstion;
    File file;
    Scanner scanner = new Scanner(System.in);
    Main(String filename, String extenstion){
        this.filename = filename;
        this.extenstion = filename+extenstion;
        this.file = new File(this.extenstion);
    }
    void createfile(){
        try{
            
            File file = new File(extenstion);
            if(!file.exists()){
                file.createNewFile();
                System.out.println("Creating file " + file.toPath());
            }else{
                System.out.println("File already exists");
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    void writefile(){
        if(file.length() >1){
            appendtext();
            return;
        }
        try(FileWriter fw = new FileWriter(extenstion)){
            System.out.println("Enter content");
            String content = scanner.nextLine();
            fw.write(content);
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    void readfile(){
        try(BufferedReader br = new BufferedReader(new FileReader(extenstion) )){
            while(br.ready()){
                System.out.println(br.readLine());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    void appendtext(){
        try(FileWriter fw = new FileWriter(extenstion, true)){
            System.out.println("writing text...");
            System.out.println("Enter content");
            String content = scanner.nextLine();
            fw.write(content);
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }

    void deletefile(){
        try{
            if(file.delete()){
                System.out.println("deleting file...");
            }else{
                System.out.println("Deleting file failed");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter filename");
        String newfilename = sc.next();
        System.out.println("enter extension");
        String extension = sc.next();
        Main app = new Main(newfilename,"."+ extension);
        while(true){
            System.out.println("1.Create file");
            System.out.println("2.Delete file");
            System.out.println("3.Append text");
            System.out.println("4.Read file");
            System.out.println("5.Write text");
            System.out.println("6.Exit");
            System.out.println("Enter choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    app.createfile();
                    break;
                case 2:
                    app.deletefile();
                    break;
                case 3:
                    app.appendtext();
                    break;
                case 4:
                    app.readfile();
                    break;
                case 5:
                    app.writefile();
                    break;
                case 6:
                    sc.close();
                    System.exit(choice);
                default:
                    System.out.println("Unknown choice");
                    break;
            }
        }
    }
}