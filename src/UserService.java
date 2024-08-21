import java.util.List;

public class UserService implements IUserService{
    public FileService fileService =new FileService();
    List<User> userInfo;
    public UserService(){
        userInfo=fileService.UserInfoFileReadService();
    }
    @Override
    public void saveUserInfo(User user) {
        User user1=new User();
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        user1.setGrade(user.getGrade());
        userInfo.add(user1);
        fileService.UserInfoFileWriteService(userInfo);

    }
}
