
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Book> books=new ArrayList<>();
    public static List<User> users=new ArrayList<>();
    public static void main(String[] args) {
        menu();

    }
    public static void menu(){
        System.out.println("Welcome to Genius Library...");
        System.out.println("Enter 1 to borrow book");
        System.out.println("Enter 2 to return book");
        System.out.println("Enter 3 to see borrow history");
        Scanner scanner=new Scanner(System.in);
        int input1=scanner.nextInt();
        switch(input1){
            case 1:
                loadBook();
                borrowBook();
                break;
            case 2:

                returnBook();
                break;
            case 3:
                borrowHistory();
                break;
            default:
                System.out.println("Invalid Input ");
                menu();
                break;

        }
    }
    public static void borrowBook(){
        for(Book book:books){
            if(book.isBorrow()){
                continue;
            }
            System.out.println(book.getId()+","+book.getTitle()+","+book.getCategory()+","+book.getAuthor());
        }
        System.out.println("Enter 0 to back:");

        System.out.println("Enter Book:");
        Scanner scanner3=new Scanner(System.in);
        int bookInput=convertToInt(scanner3.nextLine());
        if(bookInput==0){
            menu();
        }
        if(bookInput==-1){
            System.out.println("Invalid Input");
            loadBook();
        }

//        Scanner scanner=new Scanner(System.in);
//        int input=scanner.nextInt();

        Book book=getBookById(bookInput);
        if(book==null){
            System.out.println("Invalid input");
            loadBook();
        }
        System.out.println("Enter user's name,age,grade:");

        Scanner scanner1=new Scanner(System.in);
        String[] userinfos=scanner1.nextLine().split(",");

        String name=userinfos[0];
        int age=convertToInt(userinfos[1]);

        int grade=convertToInt(userinfos[2]);
        if(age==-1 || grade==-1){
            System.out.println("Invalid input");
            loadBook();
        }

        User user=new User(users.size(),name,age,grade);
        users.add(user);

        System.out.println("Enter days:");
        Scanner scanner2=new Scanner(System.in);
        int days=convertToInt(scanner2.nextLine());
        if(days==-1){
            System.out.println("Invalid Input");
            loadBook();
        }
        UserService userService=new UserService();
        userService.saveUserInfo(user);
        BookService bookService=new BookService();
        bookService.borrowBook(user,book,days,books);
        menu();



    }
    public static Integer convertToInt(String input){
        try{
            return Integer.valueOf(input);
        }catch (Exception e){
            return -1;
        }
    }
    public static Book getBookById(int id){
        for(Book book:books){
            if(book.getId()==id){
                book.setBorrow(true);
                return book;
            }
        }
        return null;
    }

    public static void returnBook(){
        for(Book book:books){
            if(book.isBorrow()){
                continue;
            }
            System.out.println(book.getId()+","+book.getTitle()+","+book.getCategory()+","+book.getAuthor());
        }
        System.out.println("Enter 0 to back:");

        System.out.println("Enter Book:");
        Scanner scanner3=new Scanner(System.in);
        int bookInput=convertToInt(scanner3.nextLine());
        if(bookInput==0){
            menu();
        }
        if(bookInput==-1){
            System.out.println("Invalid Input");
            loadBook();
        }
//        Scanner scanner=new Scanner(System.in);
//        int book=convertToInt(scanner.nextLine());
        for(Book book1:books){
            if(book1.getId()==bookInput && book1.isBorrow()){
                book1.setBorrow(false);

            }else{
                System.out.println("Invalid Input");
                returnBook();
            }
        }
        menu();

    }

    public static void borrowHistory(){

    }
    public static void loadBook(){
        if(!books.isEmpty()){
            return;
        }
        Book book1=new Book(1,"Essential Moe","Juu",Category.JUU,false);
        Book book2=new Book(2,"အမှတ်တရ","Juu",Category.JUU,false);
        Book book3=new Book(3,"HP1","CC",Category.HARRYPOTTER,false);
        Book book4=new Book(4,"HP2","CC",Category.HARRYPOTTER,false);
        Book book5=new Book(5,"LOR1","AA",Category.LORDOFRINGS,false);
        Book book6=new Book(6,"LOR2","AA",Category.LORDOFRINGS,false);

        books=List.of(book1,book2,book3,book4,book5,book6);
    }
}