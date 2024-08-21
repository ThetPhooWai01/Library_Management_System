import java.util.List;

public interface IFileService {
    void FileWriteService(List<History> historyList);
    List<History> FileReadService();
}
