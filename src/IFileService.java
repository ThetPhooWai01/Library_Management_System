import java.util.List;

public interface IFileService {
    void FileWriteService(List<History> historyList);
    List<History> FileReadService();
    void UserInfoFileWriteService(List<User> userHistoryList);
    List<User> UserInfoFileReadService();
}
