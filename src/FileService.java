import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService implements IFileService {

    @Override
    public void FileWriteService(List<History> historyList) {
        try{
            File file=new File("history.txt");
            FileWriter fileWriter=new FileWriter(file);
            for(History history:historyList){
                fileWriter.write(history.getUserName()+","+history.getBookTitle()+","+history.getDays()+"\n");

            }
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<History> FileReadService() {
        try{
            File file=new File("history.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            Scanner scanner=new Scanner(file);
            List<History> histories=new ArrayList<>();
            while (scanner.hasNext()){
                String[] line=scanner.nextLine().split(",");
                History history=new History();
                history.setUserName(line[0]);
                history.setBookTitle(line[1]);
                history.setDays(Integer.parseInt(line[2]));
                histories.add(history);

            }
            return histories;
        }catch (IOException ie ){
            ie.printStackTrace();
            return null;
        }

    }

    @Override
    public void UserInfoFileWriteService(List<User> userHistoryList) {
        try{
            File file=new File("userInfo.txt");
            FileWriter fileWriter=new FileWriter(file);
            for(User userInfo:userHistoryList){
                fileWriter.write(userInfo.getName()+","+userInfo.getAge()+","+userInfo.getGrade()+"\n");

            }
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<User> UserInfoFileReadService() {
        try{
            File file=new File("userInfo.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            Scanner scanner=new Scanner(file);
            List<User> userInfo=new ArrayList<>();
            while (scanner.hasNext()){
                String[] line=scanner.nextLine().split(",");
                User user=new User();
                user.setId(Integer.parseInt(line[0]));
                user.setName(line[1]);
                user.setAge(Integer.parseInt(line[2]));
                user.setGrade(Integer.parseInt(line[3]));
                userInfo.add(user);

            }
            return userInfo;
        }catch (IOException ie ){
            ie.printStackTrace();
            return null;
        }
    }
}

