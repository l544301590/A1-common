/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.repository;

import fit5192.zz.repository.entities.Product;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author dylanz
 */
@Remote
public interface ProductRepository extends Serializable {

    /**
     * ADD
     *
     * @param product
     * @throws Exception
     */
    public void addProduct(Product product) throws Exception;

    /**
     * SEARCH
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Product searchProductById(int id) throws Exception;

    /**
     * DELETE
     *
     * @param id
     * @throws Exception
     */
    public void removeProductById(int id) throws Exception;

    /**
     * UPDATE
     *
     * @param property
     * @throws Exception
     */
    public void updateProduct(Product product) throws Exception;

    /**
     * GET ALL
     *
     * @return
     * @throws Exception
     */
    public List<Product> getAllProducts() throws Exception;
}
