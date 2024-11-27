package LPH.StoreManagement.ServiceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;
import LPH.StoreManagement.Constansts.Constanst;
import LPH.StoreManagement.Model.User;
import LPH.StoreManagement.Repository.UserRepository;
import LPH.StoreManagement.Service.UserService;
import LPH.StoreManagement.utils.Util;
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public ResponseEntity<String> signUp( Map<String,String> requestMap){
        log.info("inside signUp {}" , requestMap);
        try{
        if(Uservalidation(requestMap)) {
            User user =  userRepository.findUserByEmail(requestMap.get("email"));
            if(user == null) {
                User newUser = createUser(requestMap);
                userRepository.save(newUser);
                return Util.getResponseEntity(Constanst.USER_CREATED, HttpStatus.OK);
            }
            return Util.getResponseEntity(Constanst.USER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);

        }
        return Util.getResponseEntity(Constanst.INVALID_DATA, HttpStatus.BAD_REQUEST);
    }
    catch(Exception ex){
        ex.printStackTrace();

    }
    return Util.getResponseEntity(Constanst.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
}



    public boolean Uservalidation(Map<String,String> requestMap) {
        
        if(requestMap.containsKey("email") && requestMap.containsKey("password") && requestMap.containsKey("username")) {
            return true;
        }
        return false;
    }
    public User createUser(Map<String,String> requestMap) {
        User user = new User();
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setUsername(requestMap.get("username"));
        user.setRole("USER");
        user.setStatus("ACTIVE");
        return user;
    }

}
