/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.services;

import fit5192.zz.repository.entities.User_;
import javax.ejb.Remote;

/**
 *
 * @author 10759
 */
@Remote
public interface UserService {
    public String register(User_ user);
    
}
