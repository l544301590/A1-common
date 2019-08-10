/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.repository;

import fit5192.zz.repository.entities.User_;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Zheng Ru
 */
@Remote
public interface UserRepository extends Serializable {
    /**
     * ADD use for login
     *
     * @param user
     * @throws Exception
     */
    public void addUser(User_ user) throws Exception;

    /**
     * SEARCH
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User_ searchUserById(int id) throws Exception;
    
    /**
     * DELETE
     *
     * @param id
     * @throws Exception
     */
    public void removeUserById(int id) throws Exception;

    /**
     * UPDATE
     *
     * @param User
     * @throws Exception
     */
    public void updateUser(User_ product) throws Exception;

    /**
     * GET ALL
     *
     * @return
     * @throws Exception
     */
    public List<User_> getAllUsers() throws Exception;
    /**
     * register
     * @param user
     * @return String  success:the level of the user
     *                  fail:the reason
     */
    public String register(User_ user);
    
   /**
    * login
    * @param user
    * @return String success:the level of the user
    *                 fail:"wrong password,try again"
    */
    public String login(User_ user);
    
    public List<User_> searchUserByAnyAttribute (User_ user);
    
    //these two method may be replace by the update
    
    
    public List<User_> searchUserByEmail(String email);
    
    /**
     * modify the user's infomation except
     * @param user
     * @return 
     */
    //public void modifyUserInfoNotLevel(User_ user);
    
    /**
     * modify the user's level and make sure the phone field,Last name,First name,Addressis not empty at the front desk
     * @param user
     * @return 
     */
    //public void modifyLevel(User_ user);
    
    
}
