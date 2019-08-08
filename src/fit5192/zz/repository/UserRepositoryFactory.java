/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.repository;

/**
 *
 * @author dylan
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The class is responsible for creating property repository
 * 
 * @author Eddie Leung
 */
public class UserRepositoryFactory {
    
    private static final UserRepository REPOSITORY_INSTANCE = createInstance();
    
    /**
     * Create a property repository object based on the setting 'repository.implementation.use' in the XML file 'repository-settings.properties'
     *
     * @return the property repository object created
     */
    private static UserRepository createInstance()
    {
        try{
            return (UserRepository)Class.forName("UserRepositoryImpl").newInstance();         
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
    /**
     * Return the class member REPOSITORY_INSTANCE
     *
     * @return the class member REPOSITORY_INSTANCE
     */
    public static UserRepository getInstance()
    {
            return REPOSITORY_INSTANCE;
    }
}
