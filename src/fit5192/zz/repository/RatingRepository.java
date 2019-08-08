/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.repository;

import fit5192.zz.repository.entities.Rating;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Zheng Ru
 */
@Remote
public interface RatingRepository extends Serializable {
     /**
     * ADD  Rating
     *
     * @param Rating
     * @throws Exception
     */
    public void addRating(Rating rating) throws Exception;

    /**
     * SEARCH
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Rating searchRatingById(int id) throws Exception;

    /**
     * DELETE
     *
     * @param id
     * @throws Exception
     */
    public void removeRatingById(int id) throws Exception;

    /**
     * UPDATE
     *
     * @param Rating
     * @throws Exception
     */
    public void updateRating(Rating rating) throws Exception;

    /**
     * GET ALL
     *
     * @return
     * @throws Exception
     */
    public List<Rating> getAllRating() throws Exception;
    
}
