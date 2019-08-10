/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.repository;

import fit5192.zz.repository.entities.Transaction_;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Zheng Ru
 */
@Remote
public interface TransactionRepository extends Serializable {
    
    /**
     * ADD  Transaction_
     *
     * @param transaction
     * @throws Exception
     */
    public void addTransaction(Transaction_ transaction) throws Exception;

    /**
     * SEARCH
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Transaction_ searchTransactionById(int id) throws Exception;

    /**
     * DELETE
     *
     * @param id
     * @throws Exception
     */
    public void removeTransactionById(int id) throws Exception;

    /**
     * UPDATE
     *
     * @param transaction
     * @throws Exception
     */
    public void updateTransaction(Transaction_ transaction) throws Exception;

    /**
     * GET ALL
     *
     * @return
     * @throws Exception
     */
    public List<Transaction_> getAllTransactions() throws Exception;
    
    public List<Transaction_> SearchTransactionsByUserId(int userId);
    public List<Transaction_> SerachTransactionByAnyAttribute(Transaction_ transaction);
    
}
