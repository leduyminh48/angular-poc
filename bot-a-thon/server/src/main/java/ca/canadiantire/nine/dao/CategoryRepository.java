package ca.canadiantire.nine.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.canadiantire.nine.domain.Category;

/**
 * @author Victor Letunovsky (@vletunovsky)
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
