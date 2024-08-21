import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
                fileWriter.write(history.getUserName()+","+history.getBookTitle()+","+history.getDays());

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
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        }

    }
}
